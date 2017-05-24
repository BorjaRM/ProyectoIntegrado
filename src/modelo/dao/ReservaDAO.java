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
            PreparedStatement st = bd.getConexion().prepareStatement("INSERT INTO reserva VALUES(null, ?, ?, ?, ?, ?, ?)");
          st.setString(1, reserva.getInicio());
          st.setString(2, reserva.getFin());
          st.setString(3, reserva.getRegimen());
          st.setString(4, reserva.getCod_cliente());
          st.setString(5, reserva.getCod_usuario());
          st.setString(6, reserva.getCod_habitacion());
          st.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void eliminarReserva(int posicion){
		reservas = consultaReservas(bd.getSingleDBInstance());
		String codigoString = reservas.get(posicion).getCodigo();
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("DELETE FROM reserva WHERE codigo ='"+codigoString+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error al eliminar la reserva");
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
	
	public int getTotalReservasHoy(int refHotel){
		int total=0;
		String sql = ("SELECT count(*) AS total_reservas  from ((reserva INNER JOIN estancia ON estancia.id=reserva.cod_habitacion) "
				+ "INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo) WHERE cod_hotel=?;");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, refHotel);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				total=resultadoConsulta.getInt("total_reservas");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}
