package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.vo.EstanciaVO;

public class EstanciaDAO {
	private BD modelo;
	
	public EstanciaDAO(){
		this.modelo=BD.getSingleDBInstance();
	}
	
	public ArrayList<EstanciaVO> getEstanciasUsoComun(int refHotel){
		ArrayList<EstanciaVO> estancias = new ArrayList<EstanciaVO>();
		int id_estancia,cod_hotel;
		String nombre,tipo;
		
		try{
			String sql = "SELECT * FROM estancia WHERE estancia.tipo='uso_comun' AND estancia.cod_hotel=? ORDER BY estancia.nombre ASC";
			PreparedStatement ps = this.modelo.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet resultadoConsulta = ps.executeQuery();
			//Transformamos el resultset en un arraylist
			while(resultadoConsulta.next()){
				id_estancia=resultadoConsulta.getInt("id");
				cod_hotel=resultadoConsulta.getInt("cod_hotel");
				nombre=resultadoConsulta.getString("nombre");
				tipo=resultadoConsulta.getString("tipo");
				//Creamos un objeto Estancia y lo añadimos al Arraylist
				estancias.add(new EstanciaVO(id_estancia,cod_hotel,nombre,tipo));
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 		
		return estancias;
	}
	
	public void insertEstancia(EstanciaVO estancia){
		if(estancia != null){
			String sql = ("INSERT INTO estancia (cod_hotel,nombre,tipo) VALUES (?,?,?);");
			try{
				PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
				consulta.setInt(1, estancia.getCod_hotel());
				consulta.setString(2, estancia.getNombre());
				consulta.setString(3, estancia.getTipo());
				consulta.executeUpdate();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Ya existe una estancia con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void updateEstancia(EstanciaVO estancia){
		if(estancia != null){
			String sql = ("UPDATE estancia SET nombre=? WHERE id=?;");
			try{
				PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
				consulta.setString(1, estancia.getNombre());
				consulta.setInt(2, estancia.getId());
				consulta.executeUpdate();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Ya existe una estancia con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void eliminarEstancia(EstanciaVO estancia){
		if(estancia != null){
			String sql = ("DELETE FROM estancia WHERE id=?");
			try{
				PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
				consulta.setInt(1, estancia.getId());
				consulta.executeUpdate();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Esta habitacion esta reservada, no se puede eliminar", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}	
}
