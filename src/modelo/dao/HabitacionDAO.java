package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.EstanciaVO;
import modelo.vo.HabitacionVO;

public class HabitacionDAO {
	private BD modelo;

	public HabitacionDAO(BD modelo){
		this.modelo=modelo;
	}
	
	public ArrayList<String> getNombresHabitaciones(int refHotel){
		ArrayList<String> habitaciones = new ArrayList<String>();
		String nombre;
		
		try{
			String sql = "SELECT estancia.nombre FROM estancia INNER JOIN hotel ON estancia.cod_hotel = ? "
					+ "AND estancia.tipo='Habitacion';";
			PreparedStatement ps = this.modelo.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			//ps.executeQuery();
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
	}
	
	public ArrayList<EstanciaVO> getHabitaciones(int refHotel){
		ArrayList<EstanciaVO> estancias = new ArrayList<EstanciaVO>();
		int id_estancia,cod_hotel,plazas,precio,cod_reserva;
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
				cod_reserva=resultadoConsulta.getInt("cod_reserva");
				//Creamos un objeto Habitacion y lo añadimos al Arraylist
				estancias.add(new HabitacionVO(id_estancia,cod_hotel,nombre,tipo_hab,clasificacion,plazas,precio,descripcion,cod_reserva));		
		}
		}catch (SQLException e) {
			e.printStackTrace();
		} 		
		return estancias;		
	}
}
