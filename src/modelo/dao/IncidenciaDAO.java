package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import modelo.BD;
import modelo.vo.EstanciaVO;
import modelo.vo.IncidenciaVO;

public class IncidenciaDAO {
	private BD bd;
	
	public IncidenciaDAO(){
		this.bd=BD.getSingleDBInstance();
	}
	public void insertaIncidencia(IncidenciaVO in){
		if(in != null){
			String sql = ("INSERT INTO incidencia (descripcion,estado,fecha,cod_estancia) VALUES (?,?,?,?);");
			try {
				PreparedStatement consultaIn = this.bd.getConexion().prepareStatement(sql);	
				consultaIn.setInt(1, in.getCodigo());
				consultaIn.setString(2, in.getDescripcion());
				consultaIn.setBoolean(3, in.getEstado());
				consultaIn.setString(4, in.getFecha());
				consultaIn.setInt(5, in.getCod_estancia());
				
				consultaIn.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String obtenFecha(){
		Calendar fecha = new GregorianCalendar();
        int any = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String ff = "" + any + "/" + mes + "/" + dia + "" ;
    	return ff;
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
			e.printStackTrace();
		} 		
		return estancias;
	}
	
	public ArrayList<String> getIncidenciaActivas(int refHotel){
		ArrayList<String> incidencias = new ArrayList<String>();
		String incidencia;
		
		try{
			String sql = "SELECT concat(estancia.nombre,' - ',incidencia.descripcion) AS incidencia FROM incidencia INNER JOIN "
					+ "estancia ON incidencia.cod_estancia=estancia.id INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo AND "
					+ "hotel.codigo=? AND incidencia.estado='activa';";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			//Transformamos el resultset en un arraylist
			while(resultadoConsulta.next()){
				incidencia=resultadoConsulta.getString("incidencia");
				//Creamos un objeto Estancia y lo añadimos al Arraylist
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
