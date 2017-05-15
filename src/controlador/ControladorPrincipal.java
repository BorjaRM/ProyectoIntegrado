package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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
		switch(e.getActionCommand()){
			case "Entrar": preparaVistaPrincipal(); break;
		}
	}
	
	public void preparaVistaPrincipal(){
		this.esAdministrador = this.vistaLogin.getSoyAdmin().isSelected();
		PrincipalView vp = new PrincipalView(esAdministrador);
		vp.setVisible(true);
	}
	
	public void cierraVista(JFrame vista){
		vista.dispose();
	}

}
