package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.ClienteVO;

public class ClienteDAO {

	BD bd ;
	ArrayList <ClienteVO> clientes;
	
	public ClienteDAO (){
		this.bd = bd;
		
	}
	
	public ArrayList <ClienteVO> rellenaYConsigueArrayClientes(){
		clientes = new ArrayList <ClienteVO>();
		try{
		Statement stmt = bd.getConexion().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM cliente;");
		while (rs.next()){
			String codigo = rs.getString("codigo");
			String nombre = rs.getString("nombre");
			String apellidos = rs.getString("apellidos");
			String identificacion = rs.getString("identificacion");
			String fecha_nacimiento = rs.getString("fecha_nacimiento");
			String telefono = rs.getString("telefono");
			String nacionalidad = rs.getString("nacionalidad");
			String Email = rs.getString("email");
			String fecha_alta = rs.getString("fecha_alta");
			ClienteVO c = new ClienteVO(codigo, nombre, apellidos, identificacion, fecha_nacimiento, telefono, nacionalidad, Email, fecha_alta);
			clientes.add(c);
		}
		bd.getConexion().close();
		
		}
		catch(Exception e){
			System.err.println("Error plenant el Array de clientes");
		}
	
		return clientes;
	}
	
	public void insertaCliente(ClienteVO cliente){
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("INSERT INTO cliente VALUES(null, "+cliente.getNombre()+", "+cliente.getApellidos()+", "+cliente.getIdentificacion()+", "+cliente.getFecha_nacimiento()+", "+cliente.getTelefono()+", "+cliente.getNacionalidad()+", "+cliente.getEmail()+", "+cliente.getFecha_alta()+")");

		} catch (SQLException e) {
			System.err.println("Error insertant client");
		}
	}
	
	public void eliminarCliente(){
		
	}
}
