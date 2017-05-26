package modelo;

import java.util.Hashtable;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class ConexionAdmin {
	private boolean datosOk;
	
	public ConexionAdmin(){
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.PROVIDER_URL, "ldap://10.2.72.131");
		
		//Rellenamos con el usuario/dominio y password
		env.put(Context.SECURITY_PRINCIPAL, "Administrador@dominio2012.com");
		String pass = getPass();
		env.put(Context.SECURITY_CREDENTIALS, pass);

		DirContext ctx;

		try {
			// Authenticate the login user
			ctx = new InitialDirContext(env);
			System.out.println("El usuario se ha autenticado correctamente");			
			ctx.close();
			datosOk =true;
		} catch (NamingException ex) {
			System.out.println("Ha habido un error en la autenticación");
			datosOk = false;
		}
	}
	
	public String getPass(){
		String pass;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce contraseña:");
		return pass=sc.nextLine();
	}

	public boolean isDatosOk() {
		return datosOk;
	}

}
