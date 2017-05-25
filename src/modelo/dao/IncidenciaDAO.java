package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modelo.BD;
import modelo.vo.EstanciaVO;
import modelo.vo.IncidenciaVO;
import res.Md5;
import vista.IncidenciasView;

public class IncidenciaDAO {
	private BD bd;
	ArrayList <IncidenciaVO> incidencia;
	ArrayList <EstanciaVO> estancia;

	public IncidenciaDAO(){
		this.bd=BD.getSingleDBInstance();
	}
	public void insertaIncidencia(IncidenciaVO in){
		if(in != null){
			String sql = ("INSERT INTO incidencia (codigo,descripcion,estado,fecha,cod_estancia) VALUES (?,?,?,?,?);");
			try {
				PreparedStatement consultaIn = this.bd.getConexion().prepareStatement(sql);	
				consultaIn.setString(1, null);
				consultaIn.setString(2, in.getDescripcion());
				consultaIn.setString(3, in.getEstado());
				consultaIn.setString(4, in.getFecha());
				consultaIn.setInt(5, in.getCod_estancia());
				
				consultaIn.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error insertando datos de incidencia en la base de datos");
			}
		}
	}
	public String getFechayHora(){
		Instant instant = Instant.now ();
		String output = instant.toString ().replace ( "T" , " " ).replace( "Z" , "" );
		return output;	 
	}
	public ArrayList<EstanciaVO> getEstancias(int refHotel){
		ArrayList<EstanciaVO> estancias = new ArrayList<EstanciaVO>();
		int id_estancia,cod_hotel;
		String nombre,tipo;
		
		try{
			String sql = "SELECT * FROM estancia WHERE estancia.cod_hotel=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			while(resultadoConsulta.next()){
				id_estancia=resultadoConsulta.getInt("id");
				cod_hotel=resultadoConsulta.getInt("cod_hotel");
				nombre=resultadoConsulta.getString("nombre");
				tipo=resultadoConsulta.getString("tipo");
				estancias.add(new EstanciaVO(id_estancia,cod_hotel,nombre,tipo));
			}
		}catch(SQLException e){
			System.out.println("Error consultando las estancias en la base de datos");
		} 		
		return estancias;
	}
	public void modificaEstadoIncidencia(int posicion,int refHotel){
		incidencia = getTablaIncidencias(refHotel);
		int codigo = incidencia.get(posicion).getCodigo();
		String estado = "resuelta";
		String sql = "UPDATE incidencia SET estado=? WHERE codigo=?;";
		if(incidencia != null){	
		try {
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setString(1, estado);
			ps.setInt(2, codigo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error al cambiar el estado de la incidencia");
		}
	}
}
	public ArrayList<IncidenciaVO> getTablaIncidencias(int refHotel){
		incidencia = new ArrayList<IncidenciaVO>();
		int codigo,cod_estancia;
		String descripcion,estado,fecha;
		try{
			String sql = "SELECT * FROM incidencia INNER JOIN estancia ON incidencia.cod_estancia=estancia.id INNER JOIN hotel ON "
					+ "estancia.cod_hotel=hotel.codigo AND hotel.codigo=? ORDER BY estado ASC, fecha DESC;";

			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();

			while(resultadoConsulta.next()){
				codigo=resultadoConsulta.getInt("codigo");
				descripcion=resultadoConsulta.getString("descripcion");
				estado=resultadoConsulta.getString("estado");
				fecha=resultadoConsulta.getString("fecha");
				cod_estancia=resultadoConsulta.getInt("cod_estancia");
				IncidenciaVO i = new IncidenciaVO(codigo,descripcion,estado,fecha,cod_estancia);
				incidencia.add(i);
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.err.println("Error haciendo la consulta de incidencias");
		} 		
		return incidencia;
	} 
	
	public ArrayList<String> getIncidenciaActivas(int refHotel){
		ArrayList<String> incidencias = new ArrayList<String>();
		String incidencia;
		
		try{
			String sql = "SELECT concat(estancia.nombre,' - ',incidencia.descripcion) AS incidencia FROM incidencia INNER JOIN "
					+ "estancia ON incidencia.cod_estancia=estancia.id INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo AND "
					+ "incidencia.estado='activa' AND hotel.codigo=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			while(resultadoConsulta.next()){
				incidencia=resultadoConsulta.getString("incidencia");
				incidencias.add(incidencia);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 		
		return incidencias;
	} 
		public int getTotalIncidencias(int refHotel){
		 		int total=0;
		 		String sql = ("SELECT count(*) AS total_incidencias FROM incidencia INNER JOIN estancia ON incidencia.cod_estancia=estancia.id "
		 				+ "INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo WHERE incidencia.estado='activa' AND hotel.codigo=?;");
		 		try {
		 			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
		 			consulta.setInt(1, refHotel);
		 			ResultSet resultadoConsulta = consulta.executeQuery();
		 			while(resultadoConsulta.next())
		 				total=resultadoConsulta.getInt("total_incidencias");
				}catch (SQLException e) {
		 			e.printStackTrace();
		 		}
		 	return total;
		 	}
	
}
