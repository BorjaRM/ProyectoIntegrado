package modelo;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.swing.JOptionPane;

public class ConexionAdmin {
	private boolean datosValidos;
	
	public ConexionAdmin(String pass){
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, "ldap://10.2.72.131");
		
		//Rellenamos con el usuario/dominio y password
		env.put(Context.SECURITY_PRINCIPAL, "Administrador@dominio2012.com");
		env.put(Context.SECURITY_CREDENTIALS, pass);

		DirContext ctx;

		try {
			//Authenticate the login user
			ctx = new InitialDirContext(env);
			ctx.close();
			datosValidos=true;
		} catch (NamingException ex) {
			datosValidos = false;
			JOptionPane.showMessageDialog(null, "Ha habido un error en la autenticación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean isDatosOk() {
		return datosValidos;
	}

}
