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
					BD database = BD.getSingleDBInstance("localhost","hotel_pi","root","");
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
