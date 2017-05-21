package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.vo.EstanciaVO;
import modelo.vo.HabitacionVO;

public class HabitacionDAO {
	private BD modelo;

	public HabitacionDAO(BD modelo){
		this.modelo=modelo;
	}
	
	/*public ArrayList<String> getNombresHabitaciones(int refHotel){
		ArrayList<String> habitaciones = new ArrayList<String>();
		String nombre;
		
		try{
			String sql ="SELECT estancia.nombre FROM estancia INNER JOIN hotel ON estancia.cod_hotel = ? "
					+ "AND estancia.tipo='Habitacion';";
			PreparedStatement ps = this.modelo.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery(sql);
			//Transformamos el resultset en un arraylist
			while(resultadoConsulta.next()){
				nombre=resultadoConsulta.getString("nombre");
				habitaciones.add(nombre);		
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} 		
		return habitaciones;		
	}*/
	
	public ArrayList<HabitacionVO> getHabitaciones(int refHotel){
		ArrayList<HabitacionVO> habitaciones = new ArrayList<HabitacionVO>();
		int id_estancia,cod_hotel,plazas,precio;
		String tipo_hab,nombre,clasificacion,descripcion;
		
		try{
			String sql = "SELECT * FROM estancia INNER JOIN habitacion ON "
					+ "estancia.id=habitacion.id_estancia AND estancia.cod_hotel = ? AND estancia.tipo='habitacion';";
			PreparedStatement ps = this.modelo.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			//Transformamos el resultset en un arraylist
			while(resultadoConsulta.next()){
				cod_hotel=resultadoConsulta.getInt("cod_hotel");
				tipo_hab=resultadoConsulta.getString("tipo");
				id_estancia=resultadoConsulta.getInt("id");
				nombre=resultadoConsulta.getString("nombre");
				clasificacion=resultadoConsulta.getString("clasificacion");
				plazas=resultadoConsulta.getInt("plazas");
				precio=resultadoConsulta.getInt("precio");
				descripcion=resultadoConsulta.getString("descripcion");
				//Creamos un objeto Habitacion y lo a�adimos al Arraylist
				habitaciones.add(new HabitacionVO(id_estancia,cod_hotel,nombre,tipo_hab,clasificacion,plazas,precio,descripcion));		
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} 		
		return habitaciones;		
	}
	
	public void insertHabitacion(HabitacionVO habitacion){
		if(habitacion != null){
			String sql = ("INSERT INTO habitacion (id_estancia,clasificacion,plazas,precio,descripcion) VALUES (0,?,?,?,?);");
			try{
				PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
				consulta.setString(1, habitacion.getClasificacion());
				consulta.setInt(2, habitacion.getPlazas());
				consulta.setInt(3, habitacion.getPrecio());
				consulta.setString(4, habitacion.getDescripcion());
				consulta.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
			
}
