package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import modelo.BD;
import modelo.vo.ReservaVO;
import modelo.vo.TipoRegimen;


public class ReservaDAO {
	BD bd;
	ArrayList <ReservaVO> reservas;
	
	public void consultaReservas(BD modelo){
		try {
			Statement stmt = bd.getConexion().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reserva");
			
			while(rs.next()){
				String codigo = rs.getString("codigo");
				String cliente = rs.getString("cod_cliente");
				String habitacion = rs.getString("cod_habitacion");
				String inicio = rs.getString("inicio");
				String fin = rs.getString("fin");
				String noches = "LMAO";
				TipoRegimen pension = null;
				
				ReservaVO r = new ReservaVO(codigo,cliente,habitacion,pension,fin,inicio, noches);
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void nuevaReserva(ReservaVO reserva){
		try {
			Statement st = bd.getConexion().createStatement();
			st.executeUpdate("INSERT INTO reserva VALUES(null,"+reserva.getInicio()+", "+reserva.getFin()
			+", "+reserva.getRegimen()+", "+reserva.getCliente()+", "+reserva.getUsuario()
			+", "+reserva.getHabitacion()+");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
