package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BD;
import vista.LoginView;
import vista.Marco;

public class ControladorUsuarios implements ActionListener{
	private BD modelo;
	private boolean esAdministrador;
	private LoginView vistaLogin;
	private Marco frame;
	private ControladorClientes cClientes;
	private ControladorEmpleados cEmpleados;
	private ControladorReservas cReservas;
	private ControladorEstancias cEstancias;
	private ControladorIncidencias cIncidencias;
	
	public ControladorUsuarios(BD modelo, LoginView login){
		this.modelo=modelo;
		vistaLogin=login;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Entrar": preparaPrincipalView(); break;
			case "Enviar": /* **************************************************************************** */ break;
			case "Cancelar": frame.muestraPrincipalView(esAdministrador); break;
			case "Nuevo Hotel": preparaNuevoHotelView(); break;
			case "Eliminar Hotel": /* **************************************************************************** */ break;
		}
	}

	public void preparaPrincipalView(){
		this.esAdministrador = this.vistaLogin.getSoyAdmin().isSelected();
		frame = new Marco();
		frame.creaPrincipalView(this);
		frame.muestraPrincipalView(esAdministrador);
		creaControladoresVistas();
		estableceControladoresMenu();
		frame.setVisible(true);
	}
	
	public void creaControladoresVistas(){
		//Creamos los controladores para cada modulo
		cClientes = new ControladorClientes(frame,modelo,esAdministrador);
		cEmpleados = new ControladorEmpleados(frame,modelo);
		cReservas = new ControladorReservas(frame,modelo,esAdministrador);
		cEstancias = new ControladorEstancias(frame,modelo,esAdministrador);
		cIncidencias = new ControladorIncidencias(frame,modelo,esAdministrador);
	}
	
	public void estableceControladoresMenu(){
		frame.estableceControlador(this);
		frame.estableceControlador(cClientes);
		frame.estableceControlador(cEmpleados);
		frame.estableceControlador(cReservas);
		frame.estableceControlador(cEstancias);
		frame.estableceControlador(cIncidencias);
	}
	
	public void preparaNuevoHotelView(){
		frame.creaHotelView(this);
		frame.muestraHotelView();
	}	
	
	
}
