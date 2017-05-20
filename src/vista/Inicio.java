package vista;

import java.awt.EventQueue;
import java.sql.Statement;

import controlador.Controlador;
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
					//Creamos el controlador principal
					Controlador cPrincipal = new Controlador();
					//Creamos la primera ventana de la aplicacion
					LoginView login = new LoginView();
					//Creamos el controlador de acceso a la aplicacion
					ControladorUsuarios cUsuarios = new ControladorUsuarios(login);
					//Asociamos la ventana con sus controladores
					login.estableceControlador(cUsuarios);
					login.estableceControlador(cPrincipal);
					//Visualizamos la ventana
					login.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				} 		
			}
		});
	}
	
}
