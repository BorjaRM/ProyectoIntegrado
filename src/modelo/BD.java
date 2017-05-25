package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
	private static BD instanciaUnica=null;
	private static Connection conexion;
	private String servidor, bd, usuario, contrasena;
	
	private BD(){
		this.servidor="52.90.200.239";
		this.bd="hotel_pi";
		this.usuario="usuario";
		this.contrasena="Pintegrado2017";			
	
		//Registramos el driver de Mysql
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e){
			System.err.println("Error registrando el Driver mysql");
		}
		
		//Realizamos la conexion a la bd con el usuario y contrase�a proporcionados
		try{
			String cadenaDeConexion = "jdbc:mysql://"+servidor+"/"+bd+"?user="+usuario+"&password="+contrasena;
			conexion= DriverManager.getConnection(cadenaDeConexion);
		}catch(Exception e){
			System.err.println("Error conectando a mysql/"+bd+" con el usuario="+usuario);
		}
	}
	
	//Patron singleton para evitar crear multiples conexiones a la base de datos
	public static BD getSingleDBInstance(){
		if(instanciaUnica == null)
			instanciaUnica = new BD();
		return instanciaUnica;
	}

	public Connection getConexion() {
		return conexion;
	}

}
