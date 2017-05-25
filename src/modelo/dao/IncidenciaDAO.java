package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	
	public IncidenciaDAO(){
		this.bd=BD.getSingleDBInstance();
		
	}
	public void insertaIncidencia(IncidenciaVO in){
		if(in != null){
			String sql = ("INSERT INTO incidencia (null,descripcion,estado,fecha,cod_estancia) VALUES (?,?,?,?,?);");
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
	
	public ArrayList<EstanciaVO> getEstancias(int refHotel){
		ArrayList<EstanciaVO> estancias = new ArrayList<EstanciaVO>();
		int id_estancia,cod_hotel;
		String nombre,tipo;
		
		try{
			String sql = "SELECT * FROM estancia WHERE estancia.cod_hotel=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			//Transformamos el resultset en un arraylist
			while(resultadoConsulta.next()){
				id_estancia=resultadoConsulta.getInt("id");
				cod_hotel=resultadoConsulta.getInt("cod_hotel");
				nombre=resultadoConsulta.getString("nombre");
				tipo=resultadoConsulta.getString("tipo");
				//Creamos un objeto Estancia y lo añadimos al Arraylist
				estancias.add(new EstanciaVO(id_estancia,cod_hotel,nombre,tipo));
			}
		}catch(SQLException e){
			System.out.println("Error consultando las estancias en la base de datos");
		} 		
		return estancias;
	}
	public void modificaEstadoIncidencia(){
		IncidenciasView iv = new IncidenciasView();
	
		try {
			String sql ="UPDATE incidencia SET estado='inactiva' WHERE fecha=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setString(1, iv.getFecha());
			ps.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("Error al cambiar estado de incidencia");
		}
	}
	public ArrayList<String> getTablaIncidencias(int refHotel){
		ArrayList<String> tablaIncidencias = new ArrayList<String>();
		String descripcion,nombre,estado,fecha;
		
		try{
			String sql = "SELECT (incidencia.descripcion) AS descripcion,(estancia.nombre) AS nombre,(incidencia.estado) AS estado,(incidencia.fecha) AS fecha FROM incidencia INNER JOIN estancia "
					+ "ON incidencia.cod_estancia=estancia.id INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo AND "
					+ "incidencia.estado='activa' AND hotel.codigo=?;";

			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			//Transformamos el resultset en un arraylist
			while(resultadoConsulta.next()){
				descripcion=resultadoConsulta.getString("descripcion");
				tablaIncidencias.add(descripcion);
				nombre=resultadoConsulta.getString("nombre");
				tablaIncidencias.add(nombre);
				estado=resultadoConsulta.getString("estado");
				tablaIncidencias.add(estado);
				fecha=resultadoConsulta.getString("fecha");
				tablaIncidencias.add(fecha);
			}
		}catch(SQLException e){
			System.err.println("Error haciendo la consulta de incidencias");
		} 		
		return tablaIncidencias;
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
