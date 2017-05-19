package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.EstanciaVO;

public class EstanciaDAO {
	private BD modelo;
	
	public EstanciaDAO(BD modelo){
		this.modelo=modelo;
	}
	
	public ArrayList<EstanciaVO> getEstanciasUsoComun(int refHotel){
		ArrayList<EstanciaVO> estancias = new ArrayList<EstanciaVO>();
		int id_estancia,cod_hotel;
		String nombre,tipo;
		
		try{
			String sql = "SELECT * FROM estancia WHERE estancia.tipo='uso_comun' AND estancia.cod_hotel=?;";
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
		}catch (SQLException e) {
			e.printStackTrace();
		} 		
		return estancias;
	}
	
	

	
	
}
