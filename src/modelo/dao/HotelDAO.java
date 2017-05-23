package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.vo.HotelVO;

public class HotelDAO {
	private BD modelo;
	
	public HotelDAO(){
		this.modelo=BD.getSingleDBInstance();;
	}

	public void insertaHotel(HotelVO hotel){
		if(hotel != null){
			String sql = ("INSERT INTO hotel (nombre,telefono,calle,numero,cp,ciudad,pais) VALUES (?,?,?,?,?,?,?);");
			try {
				PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
				consulta.setString(1, hotel.getNombre());
				consulta.setString(2, hotel.getTelefono());
				consulta.setString(3, hotel.getCalle());
				consulta.setInt(4, hotel.getNumero());
				consulta.setInt(5, hotel.getNumero());
				consulta.setString(6, hotel.getCiudad());
				consulta.setString(7, hotel.getPais());
				consulta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void eliminaHotel(int refHotel){
		String sql = ("DELETE FROM hotel WHERE codigo = ?;");
		try {
			PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
			consulta.setInt(1, refHotel);
			consulta.executeUpdate();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar este hotel");
		}
	}
	
	public ArrayList<HotelVO> getHoteles(){
		ArrayList<HotelVO> nombresHoteles = new ArrayList<HotelVO>();
		String nombre,telefono,calle,ciudad,pais;
		int codigo,numero,cp;
		String sql = ("SELECT * FROM hotel ORDER BY nombre;");
		try{
			Statement consulta = this.modelo.getConexion().createStatement();
			ResultSet resultadoConsulta = consulta.executeQuery(sql);
			while(resultadoConsulta.next()){
				codigo=resultadoConsulta.getInt(1);
				nombre=resultadoConsulta.getString(2);
				telefono=resultadoConsulta.getString(3);
				calle=resultadoConsulta.getString(4);
				numero=resultadoConsulta.getInt(5);
				cp=resultadoConsulta.getInt(6);
				ciudad=resultadoConsulta.getString(7);
				pais=resultadoConsulta.getString(8);
				nombresHoteles.add(new HotelVO(codigo,nombre,telefono,calle,numero,cp,ciudad,pais));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} 		
		return nombresHoteles;
	}
	
	public int getCodigoHotel(String nombre){
		int codigo=0;
		String sql = ("SELECT codigo FROM hotel WHERE nombre = ?;");
		try {
			PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
			consulta.setString(1, nombre);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				codigo=resultadoConsulta.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return codigo;
	}
}
