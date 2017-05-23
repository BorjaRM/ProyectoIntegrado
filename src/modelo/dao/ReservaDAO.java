package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.EstanciaVO;
import modelo.vo.ReservaVO;


public class ReservaDAO {
	BD bd;
	ArrayList <ReservaVO> reservas;
	ClienteDAO cld;
	public ReservaDAO(){
		this.bd=BD.getSingleDBInstance();
	}
	public ArrayList<ReservaVO> consultaReservas(BD modelo){
		reservas = new ArrayList<ReservaVO>();
		try {
			Statement stmt = bd.getConexion().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reserva");
			
			while(rs.next()){
				String codigo = rs.getString("codigo");
				String cliente = rs.getString("cod_cliente");
				String habitacion = rs.getString("cod_habitacion");
				String inicio = rs.getString("inicio");
				String fin = rs.getString("fin");
				String usuario = rs.getString("cod_usuario");
				String pension = rs.getString("regimen");
				
				ReservaVO r = new ReservaVO(codigo,inicio,fin,pension,cliente,usuario,habitacion);
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public void nuevaReserva(ReservaVO reserva){
		try {
			Statement st = bd.getConexion().createStatement();
			st.executeUpdate("INSERT INTO reserva VALUES(null,"+reserva.getInicio()+", "+reserva.getFin()
			+", "+reserva.getRegimen()+", "+reserva.getCod_cliente()+", "+reserva.getCod_usuario()
			+", "+reserva.getCod_habitacion()+");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getLLegadasHoy(int refHotel){
		ArrayList<String> llegadas = new ArrayList<String>();
		String llegada;
		
		try{
			String sql = "SELECT concat(cliente.nombre,' ',cliente.apellidos,' - ',estancia.nombre) AS llegada FROM reserva INNER JOIN "
					+ "estancia ON reserva.cod_habitacion=estancia.id INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo INNER JOIN "
					+ "cliente ON reserva.cod_cliente=cliente.codigo AND reserva.inicio=curdate() AND hotel.codigo=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			while(resultadoConsulta.next()){
				llegada=resultadoConsulta.getString("llegada");
				llegadas.add(llegada);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 		
		return llegadas;
	}
	
	public ArrayList<String> getSalidasHoy(int refHotel){
		ArrayList<String> salidas = new ArrayList<String>();
		String salida;
		
		try{
			String sql = "SELECT concat(cliente.nombre,' ',cliente.apellidos,' - ',estancia.nombre) AS salida FROM reserva INNER JOIN "
					+ "estancia ON reserva.cod_habitacion=estancia.id INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo INNER JOIN "
					+ "cliente ON reserva.cod_cliente=cliente.codigo AND reserva.fin=curdate() AND hotel.codigo=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			while(resultadoConsulta.next()){
				salida=resultadoConsulta.getString("salida");
				salidas.add(salida);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 		
		return salidas;
	}
}
