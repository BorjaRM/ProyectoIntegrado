package modelo.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.vo.ClienteVO;

public class ClienteDAO {
	BD bd ;
	ArrayList <ClienteVO> clientes;
	
	public ClienteDAO (){
		this.bd = BD.getSingleDBInstance();		
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
		}catch(Exception e){
			System.err.println("Error plenant el Array de clientes");
		}
		return clientes;
	}
	
	public void insertaCliente(ClienteVO cliente){
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("INSERT INTO cliente VALUES(null, '"+cliente.getNombre()+"', '"+cliente.getApellidos()+"', "
					+ "'"+cliente.getIdentificacion()+"', '"+cliente.getFecha_nacimiento()+"', '"+cliente.getTelefono()+"', "
							+ "'"+cliente.getNacionalidad()+"', '"+cliente.getEmail()+"', NOW());");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error, no se ha podido completar la insercion", "Error", JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, "No se puede eliminar este cliente", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void modificarCliente(int posicion, ClienteVO cliente){
		clientes = rellenaYConsigueArrayClientes();
		String codigoString = clientes.get(posicion).getCodigo();
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("UPDATE cliente SET nombre='"+cliente.getNombre()+"', apellidos='"+cliente.getApellidos()+"', "
					+ "identificacion='"+cliente.getIdentificacion()+"', fecha_nacimiento='"+cliente.getFecha_nacimiento()+"', "
							+ "nacionalidad='"+cliente.getNacionalidad()+"', email='"+cliente.getEmail()+"', "
									+ "telefono='"+cliente.getTelefono()+"' WHERE codigo='"+codigoString+"';");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error, no se ha podido realizar la modificacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int getTotalClientes(int refHotel){
		int total=0;
		String sql = ("SELECT COUNT(*) AS total_clientes FROM ((((reserva INNER JOIN estancia on reserva.cod_habitacion=estancia.id) "
				+ "INNER JOIN hotel ON estancia.cod_hotel=hotel.codigo)) INNER JOIN cliente ON reserva.cod_cliente=cliente.codigo) "
				+ "WHERE hotel.codigo = ?;");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, refHotel);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				total=resultadoConsulta.getInt("total_clientes");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}
