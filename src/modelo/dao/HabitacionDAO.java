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
	
	/*public String[][] getMatrizHabitaciones(int refHotel){
		String[][] habitaciones = null;
		int id_estancia,cod_hotel,plazas,precio,cod_reserva;
		String tipo_hab,nombre,clasificacion,descripcion;
		
		try{
			//Calculamos el numero total de resultados
			int totalResultados=0;
			String sql = "SELECT count(*) AS total FROM Estancia WHERE estancia.cod_hotel=?;";
			PreparedStatement st1 = this.modelo.getConexion().prepareStatement(sql);		
			st1.setInt(1, refHotel);
			ResultSet resultadoConsulta1 = st1.executeQuery();
			while (resultadoConsulta1.next()){
				totalResultados = resultadoConsulta1.getInt("total");
			 }
			resultadoConsulta1.close();
			
			//creamos la matriz
			habitaciones = new String[totalResultados][];
			
			//obtenemos los datos para rellena la matriz
			PreparedStatement stmt = this.modelo.getConexion().prepareStatement("SELECT * FROM estancia INNER JOIN habitacion "
					+ "ON estancia.id=habitacion.id_estancia AND estancia.cod_hotel = ? AND estancia.tipo='habitacion';");
			stmt.setInt(1,refHotel);
			ResultSet resultadoConsulta = stmt.executeQuery();
			int contador=0;
			while (resultadoConsulta.next()){
				//Vamos obteniendo los atributos de la consulta tupla por tupla y los añadimos a la matriz
				habitaciones[contador][0]=resultadoConsulta.getString("nombre");
				habitaciones[contador][1]=resultadoConsulta.getString("clasificacion");
				habitaciones[contador][2]=resultadoConsulta.getString("plazas");
				habitaciones[contador][3]=resultadoConsulta.getString("precio");
				habitaciones[contador][4]=resultadoConsulta.getString("descripcion");
				habitaciones[contador][4]=resultadoConsulta.getString("cod_reserva");
			 }
			resultadoConsulta1.close();
		}catch (SQLException e) {
			e.printStackTrace();
		} 		
		return habitaciones;		
	}*/
			
}
