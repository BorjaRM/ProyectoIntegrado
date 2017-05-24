package test;

import static org.junit.Assert.assertTrue;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Test;

import modelo.dao.UsuarioDAO;
import modelo.vo.UsuarioVO;
import res.Md5;

public class LoginEmpleadosTest {

	@Test
	public void test() {
		//Campos de prueba para Usuario y contraseña
		JTextField text_usuario=new JTextField("UsuarioTest");
		JPasswordField passwordField=new JPasswordField("UsuarioTest");

		UsuarioVO empleado = new UsuarioVO(text_usuario.getText(),Md5.encriptar(new String(passwordField.getPassword())));
		UsuarioDAO consultasUsuario = new UsuarioDAO();
		
		//Llamamos al metodo que comprueba si los datos introducidos coinciden con algun empleado registrado en la bd
		boolean existeEmpleado = consultasUsuario.compruebaUsuario(empleado);

		assertTrue(existeEmpleado);
	}

}
