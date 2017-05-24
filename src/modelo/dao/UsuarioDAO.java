package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.vo.UsuarioVO;

public class UsuarioDAO {
	private BD bd;
	
	public UsuarioDAO(){
		this.bd=BD.getSingleDBInstance();;
	}
	
	public boolean compruebaUsuario(UsuarioVO usuario){
		int coincidencias=0;
		boolean datosCorrectos = false;
		String sql = ("SELECT count(*) FROM usuario WHERE nombre=? AND contrasena=?;");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setString(1, usuario.getNombre());
			consulta.setString(2, usuario.getContrasena());
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				coincidencias = resultadoConsulta.getInt(1);
			if(coincidencias>0)
				datosCorrectos=true;
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return datosCorrectos;
	}
	
	public ArrayList<UsuarioVO> getUsuarios(int refHotel) {
		ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();		
		try {
				
			String sql = "SELECT usuario.nombre,usuario.contrasena,usuario.cod_empleado FROM Usuario INNER JOIN Empleado ON "
					+ "usuario.cod_empleado=empleado.codigo WHERE empleado.lugar_trabajo=?;";
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, refHotel);
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String contrasena = rs.getString("contrasena");
				int cod_empleado = rs.getInt("cod_empleado");
				UsuarioVO u = new UsuarioVO(nombre, contrasena, cod_empleado);
				usuarios.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error rellenando el array de usuarios");
		}
		return usuarios;
	}
	
	public void insertarUsuario(UsuarioVO usuario){
		if(usuario != null){
			String sql = ("INSERT INTO usuario VALUES (?,?,0);");
			try{
				PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
				consulta.setString(1, usuario.getNombre());
				consulta.setString(2, usuario.getContrasena());
				consulta.executeUpdate();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Se ha producido un error, no se ha podido completar la insercion", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void modificarUsuario(UsuarioVO usuario, int refEmpleado){
		if(usuario != null){
			String sql="UPDATE usuario SET nombre=?,contrasena=? WHERE usuario.cod_empleado=?;";
			try{
				PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
				consulta.setString(1, usuario.getNombre());
				consulta.setString(2, usuario.getContrasena());
				consulta.setInt(3, refEmpleado);
				consulta.executeUpdate();
			}catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Se ha producido un error, no se ha podido realizar la modificacion", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
		
	public int getReferenciaEmpleado(String nombreUsuario){
		int cod_empleado=0;
		String sql = ("SELECT cod_empleado FROM usuario WHERE nombre=?;");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setString(1, nombreUsuario);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				cod_empleado = resultadoConsulta.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return cod_empleado;
	}
	
	public int getReferenciaHotel(int codigoEmpleado){
		int cod_hotel=0;
		String sql = ("SELECT lugar_trabajo FROM empleado WHERE codigo=?");
		try {
			PreparedStatement consulta = this.bd.getConexion().prepareStatement(sql);
			consulta.setInt(1, codigoEmpleado);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next())
				cod_hotel = resultadoConsulta.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return cod_hotel;
	}

}
