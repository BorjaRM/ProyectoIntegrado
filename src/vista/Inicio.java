package vista;

import java.awt.EventQueue;
import java.sql.Statement;

import modelo.BD;

public class Inicio {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Creamos la base de datos
					BD database = BD.getSingleDBInstance("52.90.200.239","hotel_pi","usuario","Pintegrado2017");
					Statement stmt = database.getConexion().createStatement();
					//stmt.executeUpdate("INSERT INTO cliente VALUES (null, 'manolo', 'manolete', 'joder', '2017-01-01', '665848120', 'Española', 'jeje@pepe.com', '2022-10-03');");
					//stmt.executeUpdate("DELETE FROM cliente WHERE codigo = '1';");
					stmt.executeUpdate("UPDATE cliente SET nombre='pepe', apellidos='pepito', identificacion='toma', fecha_nacimiento='1992-02-03', nacionalidad='Marroqui', email='manoloNO', fecha_alta='2003-02-02' WHERE codigo='4';");

					
					
					/*Creamos la primera ventana de la aplicacion
					LoginView login = new LoginView();
					//Creamos el controlador principal
					ControladorUsuarios cUsuarios = new ControladorUsuarios(database,login);
					//Asociamos el controlador con la ventana
					login.estableceControlador(cUsuarios);
					//Visualizamos la ventana
					login.setVisible(true);
					*/		
				} catch (Exception e) {
					//e.printStackTrace();
					e.printStackTrace();
				} 		
			}
		});
	}
	
}
