package modelo.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import modelo.BD;
import modelo.vo.ClienteVO;

public class ClienteDAO {

	BD bd ;
	ArrayList <ClienteVO> clientes;
	int referenciaHotel;
	
	public ClienteDAO (BD bd, int refernciaHotel){
		this.bd = bd;
		this.referenciaHotel = referenciaHotel;
		
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

		
		}
		catch(Exception e){
			System.err.println("Error plenant el Array de clientes");
		}
	
		return clientes;
	}
	
	public void insertaCliente(ClienteVO cliente){
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Get the date today using Calendar object.
		java.util.Date today =Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		// Print what date is today!
		//System.out.println("Report Date: " + reportDate);
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("INSERT INTO cliente VALUES(null, '"+cliente.getNombre()+"', '"+cliente.getApellidos()+"', '"+cliente.getIdentificacion()+"', '"+cliente.getFecha_nacimiento()+"', '"+cliente.getTelefono()+"', '"+cliente.getNacionalidad()+"', '"+cliente.getEmail()+"', '"+reportDate+"');");
			
		} catch (SQLException e) {
			System.err.println("Error insertant client");
			e.printStackTrace();
		}
	}
	
	public void eliminarCliente(int posicion){
		clientes = rellenaYConsigueArrayClientes();
		String codigoString = clientes.get(posicion).getCodigo();
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("DELETE FROM reserva WHERE cod_cliente ='"+codigoString+"'");
			stmt.executeUpdate("DELETE FROM cliente WHERE codigo = '"+codigoString+"';");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error al eliminar cliente");
		}
	}
	
	public void modificarCliente(int posicion, ClienteVO cliente){
		clientes = rellenaYConsigueArrayClientes();
		String codigoString = clientes.get(posicion).getCodigo();
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("UPDATE cliente SET nombre='"+cliente.getNombre()+"', apelllidos='"+cliente.getApellidos()+"', identificacion='"+cliente.getIdentificacion()+"', fecha_nacimiento='"+cliente.getTelefono()+"', nacionalidad='"+cliente.getNacionalidad()+"', email='"+cliente.getEmail()+"', fecha_alta='"+cliente.getFecha_alta()+"' WHERE codigo='"+codigoString+"';");
		} catch (Exception e) {
			System.err.println("Error modificando cliente.");
		}
	}
}
