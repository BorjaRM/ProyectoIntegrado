package modelo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.EmpleadoVO;
import modelo.vo.UsuarioVO;

public class EmpleadoDAO {

	BD bd;
	ArrayList<EmpleadoVO> empleados;
	ArrayList<UsuarioVO> usuarios;

	public EmpleadoDAO(BD bd) {
		this.bd = bd;
	}

	// Metodo que recoja la informacion de un empleado y la guarde en un
	// ArrayList
	public ArrayList<EmpleadoVO> rellenarYConseguirArrayEmpleados() {
		empleados = new ArrayList<EmpleadoVO>();
		try {
			Statement st = bd.getConexion().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Empleado;");
			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");
				String identificacion = rs.getString("identificacion");
				String telefono = rs.getString("telefono");
				String salario = rs.getString("salario");
				String seguridad_social = rs.getString("seguridad_social");
				String fecha_alta = rs.getString("fecha_alta");
				String lugar_trabajo = rs.getString("lugar_trabajo");
				EmpleadoVO em = new EmpleadoVO(codigo, nombre, apellido1, apellido2, identificacion, telefono, salario,
						seguridad_social, fecha_alta, lugar_trabajo);
				empleados.add(em);
			}
			bd.getConexion().close();
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
				String cod_empleado = rs.getString("cod_empleado");

				UsuarioVO u = new UsuarioVO(nombre, contrasena, cod_empleado);
				usuarios.add(u);
			}
			bd.getConexion().close();
		} catch (Exception e) {
			System.err.println("Error rellenando el array de empleados");
		}
		return usuarios;
	}

	// Metodo que recoja la informacion de un empleado y haga un INSERT sobre la BBDD

	public void insertarEmpleado(EmpleadoVO empleados, UsuarioVO usuarios) {
		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("INSERT INTO Empleado VALUES(null, '"+empleados.getNombre() + "', '"
					+ empleados.getApellido1() + "', '"+ empleados.getApellido2() + "', '"
					+ empleados.getIdentificacion() + "', '" + empleados.getTelefono() + "', '"
					+ empleados.getSalario() + "', '" + empleados.getSeguridad_social() + "','"
					+ empleados.getFecha_alta() + "', '" + empleados.getLugar_trabajo() + "')");

			stmt.executeUpdate("INSERT INTO Usuario VALUES('" + usuarios.getNombre() + "', '" + usuarios.getContrasena()
					+ "', '" + usuarios.getEmpleado() + "')");

		} catch (SQLException e) {
			System.err.println("Error insertando empleado");
		}
	}

	// Metodo que te permita eliminar empleado a partir de su codigo.

	public void eliminarEmpleado(int posicion) {
		empleados = rellenarYConseguirArrayEmpleados();
		String codigo = empleados.get(posicion).getCodigo();

		try {
			Statement stmt = bd.getConexion().createStatement();
			stmt.executeUpdate("DELETE FROM Empleado WHERE codigo= '"+codigo+"';");
			stmt.executeUpdate("DELETE FROM Usuario WHERE cod_empleado= '"+codigo+"';");
			

		} catch (SQLException e) {
			System.err.println("Error eliminando empleado");
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

}
