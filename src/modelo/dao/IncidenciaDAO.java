package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.IncidenciaVO;

public class IncidenciaDAO {
	private BD bd;
	
	public IncidenciaDAO(){
		this.bd=BD.getSingleDBInstance();
	}
	public void insertaIncidencia(IncidenciaVO in){
		if(in != null){
			String sql = ("INSERT INTO incidencia (codigo,descripcion,estado,fecha,codigo_estancia) VALUES (?,?,?,?,?);");
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

		public ArrayList<IncidenciaVO> mostrarIncidencias(){
			ArrayList<String> incidencias = new ArrayList<String>();
			String nombre;
			
			String sql = ("SELECT nombre FROM incidencia;");
			try{
				Statement consulta = this.bd.getConexion().createStatement();
				ResultSet resultadoConsulta = consulta.executeQuery(sql);
				while(resultadoConsulta.next()){
					nombre=resultadoConsulta.getString(1);
					nombresHoteles.add(nombre);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} 		
			return nombresHoteles;
		}
		
	
	

	public int getReferenciaHotel(int codigoEmpleado){
		int cod_hotel=0;
		String sql = ("SELECT lugar_trabajo FROM empleado WHERE codigo=?");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, codigoEmpleado);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				cod_hotel = resultadoConsulta.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return cod_hotel;
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
	
	
}
