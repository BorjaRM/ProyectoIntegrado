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
import modelo.vo.EmpleadoVO;
import modelo.vo.EstanciaVO;
import modelo.vo.UsuarioVO;
import res.Md5;

public class EmpleadoDAO {
	BD bd;
	
	public EmpleadoDAO() {
		this.bd = BD.getSingleDBInstance();				
	}

	// Metodo que recoja la informacion de un empleado y la guarde en un ArrayList
	public ArrayList<EmpleadoVO> getEmpleados(int refHotel) {
		ArrayList<EmpleadoVO> empleados = new ArrayList<EmpleadoVO>();
		try {
			String sql = "SELECT * FROM Empleado WHERE lugar_trabajo=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, refHotel);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");
				String identificacion = rs.getString("identificacion");
				String telefono = rs.getString("telefono");
				int salario = rs.getInt("salario");
				String seguridad_social = rs.getString("seguridad_social");
				String fecha_alta = rs.getString("fecha_alta");
				int lugar_trabajo = rs.getInt("lugar_trabajo");
				EmpleadoVO em = new EmpleadoVO(codigo, nombre, apellido1, apellido2, identificacion, telefono, salario,
						seguridad_social, fecha_alta, lugar_trabajo);
				empleados.add(em);
			}
		} catch (Exception e) {
			System.err.println("Error rellenando el array de empleados");
		}
		return empleados;
	}

	// Metodo que recoja la informacion de un empleado y haga un INSERT sobre la BBDD
	public void insertarEmpleado(EmpleadoVO empleado, int refHotel) {
		if(empleado != null){
			String sql = ("INSERT INTO empleado (nombre,apellido1,apellido2,identificacion,telefono,salario,seguridad_social,"
					+ "fecha_alta,lugar_trabajo) VALUES (?,?,?,?,?,?,?,CURDATE(),?);");
			try{
				PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
				consulta.setString(1, empleado.getNombre());
				consulta.setString(2, empleado.getApellido1());
				consulta.setString(3, empleado.getApellido2());
				consulta.setString(4, empleado.getIdentificacion());
				consulta.setString(5, empleado.getTelefono());
				consulta.setInt(6, empleado.getSalario());
				consulta.setString(7, empleado.getSeguridad_social());
				consulta.setInt(8, refHotel);
				consulta.executeUpdate();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Se ha producido un error, no se ha podido completar la insercion", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}

	// Metodo que te permita eliminar empleado
	public void eliminarEmpleado(EmpleadoVO empleado) {
		if(empleado != null){
			String sql = "DELETE FROM empleado WHERE codigo=?";
			try{
				PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
				consulta.setInt(1, empleado.getCodigo());
				consulta.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "No se puede eliminar este empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Metodo que permita modificar los datos de las tablas empleado y usuario.
	public void modificarEmpleado(EmpleadoVO empleado) {
		if(empleado != null){
			String sql = "UPDATE empleado SET nombre=?, apellido1=?, apellido2=?, identificacion=?, telefono=?, salario=?, "
					+ "seguridad_social=? WHERE empleado.codigo=?;";
			try{
				PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
				consulta.setString(1, empleado.getNombre());
				consulta.setString(2, empleado.getApellido1());
				consulta.setString(3, empleado.getApellido2());
				consulta.setString(4, empleado.getIdentificacion());
				consulta.setString(5, empleado.getTelefono());
				consulta.setInt(6, empleado.getSalario());
				consulta.setString(7, empleado.getSeguridad_social());
				consulta.setInt(8, empleado.getCodigo());
				consulta.executeUpdate();				
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Se ha producido un error, no se ha podido realizar la modificacion", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public int getTotalEmpleados(int refHotel){
		int total=0;
		String sql = ("SELECT COUNT(*) AS total_empleados FROM empleado WHERE empleado.lugar_trabajo=?;");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, refHotel);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				total=resultadoConsulta.getInt("total_empleados");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}