package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import modelo.BD;
import modelo.vo.ReservaVO;

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
				String pension = rs.getString("regimen");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ReservaVO r = new ReservaVO(codigo,cliente,habitacion,inicio,fin,pension)
	}
}
