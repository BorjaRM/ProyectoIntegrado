package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
	private static BD instanciaUnica=null;
	private static Connection conexion;
	private String servidor, bd, usuario, contrasena;
	
	private BD(String servidor, String bd, String usuario, String contrasena){
		this.servidor=servidor;
		this.bd=bd;
		this.usuario=usuario;
		this.contrasena=contrasena;			
	
		//Registramos el driver de Mysql
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e){
			System.err.println("Error registrando el Driver mysql");
		}
		
		//Realizamos la conexion a la bd con el usuario y contraseña proporcionados
		try{
			String cadenaDeConexion = "jdbc:mysql://"+servidor+"/"+bd+"?user="+usuario+"&password="+contrasena;
			conexion= DriverManager.getConnection(cadenaDeConexion);
		}catch(Exception e){
			System.err.println("Error conectando a mysql/"+bd+" con el usuario="+usuario);
		}
	}
	
	//Patron singleton para evitar crear multiples conexiones a la base de datos
	public static BD getSingleDBInstance(String servidor, String bd, String usuario, String contrasena){
		if(instanciaUnica == null)
			instanciaUnica = new BD(servidor,bd,usuario,contrasena);
		return instanciaUnica;
	}

	public static BD getinstanciaUnica() {
		return instanciaUnica;
	}

	public static void setinstanciaUnica(BD instanciaUnica) {
		BD.instanciaUnica = instanciaUnica;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	
	
}
