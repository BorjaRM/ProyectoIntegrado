package vista;

import java.awt.EventQueue;

import controlador.ControladorPrincipal;
import modelo.BD;

public class Inicio {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BD database = BD.getSingleDBInstance("52.70.251.153","hotel_pi","usuario","Pintegrado2017");
					LoginView login = new LoginView();
					ControladorPrincipal controlador = new ControladorPrincipal(database,login);
					login.estableceControlador(controlador);
					login.visualiza();					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
