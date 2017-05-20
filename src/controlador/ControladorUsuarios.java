package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.HotelDAO;
import modelo.dao.UsuarioDAO;
import modelo.vo.HotelVO;
import vista.LoginView;
import vista.Marco;

public class ControladorUsuarios extends Controlador{
	private LoginView vistaLogin;
	private HotelDAO consultasHotel;
	
	public ControladorUsuarios(LoginView login){
		vistaLogin=login;
		consultasHotel = new HotelDAO(Controlador.modelo);
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
		}
	}
	
	public void verificaAcceso(){
		if(!Controlador.esAdministrador){
			if(compruebaLoginEmpleado()){
				String elEmpleado=vistaLogin.recogeDatos().getNombre();
				this.estableceReferenciaHotelEmpleado(elEmpleado);
				preparaPrincipalEmpleadoView();
			}else
				JOptionPane.showMessageDialog(null, "Datos incorrectos, Acceso denegado");			
		}else{
			System.err.println("programar acceso por VMware");
			preparaPrincipalAdminView();
		}
	}
	
	public boolean compruebaLoginEmpleado(){
		UsuarioDAO consultasUsuario = new UsuarioDAO(Controlador.modelo);
		return consultasUsuario.compruebaUsuario(vistaLogin.recogeDatos());			
	}
	
	public void preparaPrincipalAdminView(){
		frame = new Marco();
		//Puedo hacer un new Controlador aqui? no se como pasar el Controlador de otra forma
		Controlador.frame.creaPrincipalAdminView(new Controlador(),this);
		preparaDesplegableHotelView();
		actualizaReferenciaHotelAdmin();
		frame.muestraPrincipalAdminView();
		preparaControladores();
		frame.setVisible(true);
	}
	
	public void preparaPrincipalEmpleadoView(){
		frame = new Marco();
		frame.creaPrincipalEmpleadoView();
		frame.muestraPrincipalEmpleadoView();
		preparaControladores();
		frame.setVisible(true);
	}

	public void preparaControladores(){
		creaControladoresVistas();
	}
	
	public void creaControladoresVistas(){
		//Creamos los controladores para cada modulo
		ControladorClientes cClientes = new ControladorClientes();
		ControladorEmpleados cEmpleados = new ControladorEmpleados();
		ControladorReservas cReservas = new ControladorReservas();
		ControladorEstancias cEstancias = new ControladorEstancias();
		ControladorIncidencias cIncidencias = new ControladorIncidencias();
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
		frame.getPav().rellenaDesplegableHoteles(consultasHotel.getHoteles());
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
	
}
