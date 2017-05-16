package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BD;
import vista.LoginView;
import vista.PrincipalView;

public class ControladorPrincipal implements ActionListener {
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

}
