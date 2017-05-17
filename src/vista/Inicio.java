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
					BD database = BD.getSingleDBInstance("54.88.246.216","hotel_pi","usuario","Pintegrado2017");
					LoginView login = new LoginView();
					ControladorPrincipal controlador = new ControladorPrincipal(database,login);
					login.estableceControlador(controlador);
					login.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				} 		
				
			}
		});
	}
	
		


}
