package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.HotelDAO;
import modelo.dao.UsuarioDAO;
import vista.LoginView;
import vista.Marco;

public class ControladorUsuarios implements ActionListener, ItemListener{
	private BD modelo;
	private boolean esAdministrador;
	private LoginView vistaLogin;
	private Marco frame;
	private int refHotel;
	private String elEmpleado;
	private String idioma; /* ************** terminar de programar ************************* */
	private HotelDAO consultasHotel;
	private ControladorClientes cClientes;
	private ControladorEmpleados cEmpleados;
	private ControladorReservas cReservas;
	private ControladorEstancias cEstancias;
	private ControladorIncidencias cIncidencias;
	
	public ControladorUsuarios(BD modelo, LoginView login){
		this.modelo=modelo;
		vistaLogin=login;
		consultasHotel = new HotelDAO(modelo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Entrar": verificaAcceso(); break;
			case "Enviar": enviar(); break;
			case "Cancelar": cancelar(); break;
			case "Nuevo Hotel": preparaNuevoHotelView(); break;
			case "Eliminar Hotel": eliminar(); break;
			case "comboBoxChanged": estableceReferenciaHotel(); break;
		}
	}
	
	public void verificaAcceso(){
		this.esAdministrador = this.vistaLogin.getSoyAdmin().isSelected();
		if(!esAdministrador){
			if(compruebaLoginEmpleado()){
				this.elEmpleado=vistaLogin.recogeDatos().getNombre();
				preparaPrincipalEmpleadoView();
			}else
				JOptionPane.showMessageDialog(null, "Datos incorrectos, Acceso denegado");			
		}else{
			System.err.println("programar acceso por VMware");
			preparaPrincipalAdminView();
		}
	}
	
	public boolean compruebaLoginEmpleado(){
		UsuarioDAO consultasUsuario = new UsuarioDAO(modelo);
		return consultasUsuario.compruebaUsuario(vistaLogin.recogeDatos());			
		
	}
	
	public void preparaPrincipalAdminView(){
		frame = new Marco();
		frame.creaPrincipalAdminView(this);
		preparaDesplegableHotelView();
		estableceReferenciaHotel();
		frame.muestraPrincipalAdminView();
		preparaControladores();
		frame.setVisible(true);

	}
	
	public void preparaPrincipalEmpleadoView(){
		frame = new Marco();
		frame.creaPrincipalEmpleadoView();
		estableceReferenciaHotel();
		frame.muestraPrincipalEmpleadoView();
		preparaControladores();
		frame.setVisible(true);
	}

	public void preparaControladores(){
		creaControladoresVistas();
		estableceControladoresMenu();
	}
	
	public void creaControladoresVistas(){
		//Creamos los controladores para cada modulo
		cClientes = new ControladorClientes(frame,modelo,esAdministrador, refHotel);
		cEmpleados = new ControladorEmpleados(frame,modelo, refHotel);
		cReservas = new ControladorReservas(frame,modelo,esAdministrador, refHotel);
		cEstancias = new ControladorEstancias(frame,modelo,esAdministrador, refHotel);
		cIncidencias = new ControladorIncidencias(frame,modelo,esAdministrador, refHotel);
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
	
	public void preparaDesplegableHotelView(){
		frame.getPav().rellenaDesplegableHoteles(consultasHotel.getNombresHoteles());
	}
	
	public void estableceReferenciaHotel(){
		if(esAdministrador){
			String nombre= (String) frame.getPav().getNombresHoteles().getSelectedItem();
			this.refHotel=consultasHotel.getCodigoHotel(nombre);
			System.out.println("referencia hotel:" +refHotel);
		}else{
			UsuarioDAO consultasUsuario = new UsuarioDAO(modelo);
			this.refHotel=consultasUsuario.getReferenciaHotel(consultasUsuario.getReferenciaEmpleado(elEmpleado));
			System.out.println("referencia hotel:" +refHotel);
		}
	}
	
	public void enviar(){
		consultasHotel.insertaHotel(frame.getHv().enviarDatos());
		preparaDesplegableHotelView();
		if(esAdministrador)
			frame.muestraPrincipalAdminView();		
		else
			frame.muestraPrincipalEmpleadoView();
	}
	
	public void cancelar(){
		if(esAdministrador)
			frame.muestraPrincipalAdminView();		
		else
			frame.muestraPrincipalEmpleadoView();
	}
	
	public void eliminar(){
		consultasHotel.eliminaHotel(refHotel);
		preparaDesplegableHotelView();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItemSelectable());
		// TODO Auto-generated method stub
		
	}

}
