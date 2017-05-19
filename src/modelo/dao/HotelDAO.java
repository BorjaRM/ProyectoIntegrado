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
	
	public HotelDAO(BD modelo){
		this.modelo=modelo;
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
			System.out.println("hecho");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar este hotel");
		}
	}
	
	public ArrayList<String> getNombresHoteles(){
		ArrayList<String> nombresHoteles = new ArrayList<String>();
		String nombre;
		String sql = ("SELECT nombre FROM hotel ORDER BY codigo;");
		try{
			Statement consulta = this.modelo.getConexion().createStatement();
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
