package vista;

import java.awt.EventQueue;

import controlador.ControladorClientes;
import controlador.ControladorEmpleados;
import controlador.ControladorEstancias;
import controlador.ControladorIncidencias;
import controlador.ControladorUsuarios;
import controlador.ControladorReservas;
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
					//Creamos la primera ventana de la aplicacion
					LoginView login = new LoginView();
					//Creamos el controlador principal
					ControladorUsuarios cUsuarios = new ControladorUsuarios(database,login);
					//Asociamos el controlador con la ventana
					login.estableceControlador(cUsuarios);
					//Visualizamos la ventana
					login.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				} 		
			}
		});
	}
	
}
