package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import modelo.BD;
import vista.ClientesView;
import vista.LoginView;
import vista.PrincipalAdminView;
import vista.PrincipalView;

public class ControladorPrincipal implements ActionListener, MenuListener {
	private BD modelo;
	private LoginView vistaLogin;
	private boolean esAdministrador;
	
	public ControladorPrincipal(BD modelo, LoginView login){
		this.modelo=modelo;
		vistaLogin=login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Entrar": preparaVistaPrincipal(); break;
			case "Salir" : salir(); break;
			case "Salir2" : salir(); break;
		}
	}
	
	public void preparaVistaPrincipal(){
		this.esAdministrador = this.vistaLogin.getSoyAdmin().isSelected();
		PrincipalView vp = new PrincipalView(esAdministrador);
		vp.setVisible(true);
	}
	
	public void salir(){
		System.out.println("has elegido salir");
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		System.out.println("has elegido salir");
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
		System.out.println("has elegido salir");
		
	}

	@Override
	public void menuSelected(MenuEvent e) {
		System.out.println("has elegido salir");
		
	}

}
