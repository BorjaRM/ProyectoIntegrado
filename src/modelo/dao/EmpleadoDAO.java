package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import modelo.BD;
import modelo.vo.EmpleadoVO;
import modelo.vo.UsuarioVO;

public class EmpleadoDAO {
	BD bd;
	int codigoNuevoEmpleado;
	ArrayList<EmpleadoVO> empleados;
	ArrayList<UsuarioVO> usuarios;
	int numero_hotel;
	
	public EmpleadoDAO(int numero_hotel) {
		this.bd = BD.getSingleDBInstance();		
		this.numero_hotel = numero_hotel;
		
	}

	// Metodo que recoja la informacion de un empleado y la guarde en un
	// ArrayList
	public ArrayList<EmpleadoVO> rellenarYConseguirArrayEmpleados() {
	
		empleados = new ArrayList<EmpleadoVO>();
		try {
			String sql = "SELECT * FROM Empleado WHERE lugar_trabajo=?;";
			PreparedStatement ps = this.bd.getConexion().prepareStatement(sql);
			ps.setInt(1, numero_hotel);
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

	// Metodo que recoja la informacion de un usuario y la guarde en un
	// ArrayList
	public ArrayList<UsuarioVO> rellenarYConseguirArrayUsuarios() {
		usuarios = new ArrayList<UsuarioVO>();
		try {
			Statement st = bd.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Usuario;");
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String contrasena = rs.getString("contrasena");
				int cod_empleado = rs.getInt("cod_empleado");

				UsuarioVO u = new UsuarioVO(nombre, contrasena, cod_empleado);
				usuarios.add(u);
			}
		} catch (Exception e) {
			System.err.println("Error rellenando el array de empleados");
		}
		return usuarios;
	}

	// Metodo que recoja la informacion de un empleado y haga un INSERT sobre la BBDD

	public void insertarEmpleado(EmpleadoVO empleados, UsuarioVO usuarios) {
		// Create an instance of SimpleDateFormat used for formatting 
				// the string representation of date (month/day/year)
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				// Get the date today using Calendar object.
				java.util.Date today =Calendar.getInstance().getTime();        
				// Using DateFormat format method we can create a string 
				// representation of a date with the defined format.
				String reportDate = df.format(today);
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("INSERT INTO Empleado VALUES(null, '"+empleados.getNombre() + "', '"
					+ empleados.getApellido1() + "', '"+ empleados.getApellido2() + "', '"
					+ empleados.getIdentificacion() + "', '" + empleados.getTelefono() + "', '"
					+ empleados.getSalario() + "', '" + empleados.getSeguridad_social() + "','"
					+ reportDate+ "', '" + empleados.getLugar_trabajo() + "')");

		} catch (SQLException e) {
			System.err.println("Error insertando empleado" + e);
		}
		try {
			Statement stmt = bd.getConexion().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT (codigo) FROM Empleado WHERE identificacion='"+empleados.getIdentificacion()+"';");
		while(rs.next()){
			 codigoNuevoEmpleado = rs.getInt("codigo");
		}
		} catch (SQLException e) {
			System.err.println("Error insertando usuario" + e);
		}
		try {
			Statement stmt = bd.getConexion().createStatement();
		stmt.executeUpdate("INSERT INTO Usuario VALUES('" + usuarios.getNombre() + "', '" + usuarios.getContrasena()
		+ "', '" +codigoNuevoEmpleado+ "')");
		} catch (SQLException e) {
			System.err.println("Error insertando usuario" + e);
		}
	}

	// Metodo que te permita eliminar empleado a partir de su codigo.

	public void eliminarEmpleado(int posicion) {
		empleados = rellenarYConseguirArrayEmpleados();
		int codigo = empleados.get(posicion).getCodigo();

		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("DELETE FROM Usuario WHERE cod_empleado= '"+codigo+"';");
			stmt.executeUpdate("DELETE FROM Empleado WHERE codigo= '"+codigo+"';");


			
		} catch (SQLException e) {
			System.err.println("Error eliminando empleado"+e);
		}
		


	}
	
	// Metodo que permita modificar los datos de las tablas empleado y usuario.

	public void modificarEmpleado(EmpleadoVO empleados, UsuarioVO usuarios) {

		try {
			
			Statement stmt = bd.getConexion().createStatement();
			
			stmt.executeUpdate("UPDATE FROM Empleado SET nombre='"+empleados.getNombre()+"', apellido1='"+empleados.getApellido1()+""
					+ ", apellido2='"+empleados.getApellido2()+"', identificacion='"+empleados.getIdentificacion()+"'"
					+ ", telefono='"+empleados.getTelefono()+"', salario='"+empleados.getSalario()+"'"
					+ ", seguridad_social='"+empleados.getSeguridad_social()+"', fecha_alta='"+empleados.getFecha_alta()+"'"
					+ ", lugar_trabajo='"+empleados.getLugar_trabajo()+"' WHERE codigo='"+empleados.getCodigo()+"';");
			
			stmt.executeUpdate("UPDATE FROM Usuario SET nombre='"+usuarios.getNombre()+"', contrasena='"+usuarios.getContrasena()+"'"
					+ " WHERE cod_empleado='"+empleados.getCodigo()+"';");

		} catch (SQLException e) {
			System.err.println("Error modificando empleado");
		}

	}
	
	public int getTotalEmpleados(){
		int total=0;
		String sql = ("SELECT COUNT(*) AS total_empleados FROM empleado WHERE empleado.lugar_trabajo=?;");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, numero_hotel);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				total=resultadoConsulta.getInt("total_empleados");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}