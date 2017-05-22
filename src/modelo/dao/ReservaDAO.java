package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.BD;
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
}
