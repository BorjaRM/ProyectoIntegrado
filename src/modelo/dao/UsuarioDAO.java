package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.BD;
import modelo.vo.UsuarioVO;

public class UsuarioDAO {
	private BD modelo;
	
	public UsuarioDAO(){
		this.modelo=BD.getSingleDBInstance();;
	}
	
	public boolean compruebaUsuario(UsuarioVO usuario){
		int coincidencias=0;
		boolean datosCorrectos = false;
		String sql = ("SELECT count(*) FROM usuario WHERE nombre=? AND contrasena=?;");
		try {
			PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
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
	
	// Metodo que recoja la informacion de un usuario y la guarde en un ArrayList
		public ArrayList<UsuarioVO> rellenarYConseguirArrayUsuarios() {
			ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
			try {
				Statement st = modelo.getConexion().createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM Usuario;");
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					String contrasena = rs.getString("contrasena");
					int cod_empleado = rs.getInt("cod_empleado");

					UsuarioVO u = new UsuarioVO(nombre, contrasena, cod_empleado);
					usuarios.add(u);
				}
			} catch (Exception e) {
				System.err.println("Error rellenando el array de usuarios");
			}
			return usuarios;
		}
		
	public int getReferenciaEmpleado(String nombreUsuario){
		int cod_empleado=0;
		String sql = ("SELECT cod_empleado FROM usuario WHERE nombre=?;");
		try {
			PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
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
			PreparedStatement consulta = this.modelo.getConexion().prepareStatement(sql);
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
