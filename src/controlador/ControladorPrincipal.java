package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import modelo.BD;
import vista.LoginView;
import vista.Marco;

public class ControladorPrincipal implements ActionListener{
	private BD modelo;
	private boolean esAdministrador;
	private LoginView vistaLogin;
	private Marco frame;
	private ControladorClientes cClientes;
	private ControladorEmpleados cEmpleados;
	private ControladorReservas cReservas;
	private ControladorEstancias cEstancias;
	private ControladorIncidencias cIncidencias;
	
	public ControladorPrincipal(BD modelo, LoginView login){
		this.modelo=modelo;
		vistaLogin=login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Entrar": preparaPrincipalView(); break;
			case "Nuevo Hotel": preparaNuevoHotelView(); break;
			case "Cancelar": frame.cancelar(); break;
			case "Clientes": preparaVistaClientes(); break;
		}
	}

	public void preparaPrincipalView(){
		this.esAdministrador = this.vistaLogin.getSoyAdmin().isSelected();
		frame = new Marco(this);
		frame.creaVistaPrincipal();
		frame.muestraVistaPrincipal(esAdministrador);
		frame.estableceControlador();
		frame.setVisible(true);
	}
	
	public void preparaNuevoHotelView(){
		frame.creaVistaHotel();
	}
	
	public void preparaVistaClientes(){
		cClientes = new ControladorClientes(modelo);
		cClientes.setCv(frame.getCv());
		cClientes.setNcv(frame.getNcv());
		cClientes.setMcv(frame.getMcv());
		frame.creaVistaClientes();
	}
	
	
}
