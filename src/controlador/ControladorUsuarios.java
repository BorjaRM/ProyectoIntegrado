package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		super.creaMarco();
		//Puedo hacer un new Controlador aqui? no se como pasar el Controlador de otra forma
		frame.creaPrincipalAdminView(this); 
		preparaDesplegableHotelView();
		actualizaReferenciaHotelAdmin();
		frame.muestraPrincipalAdminView();
		creaControladoresVistas();
		frame.setVisible(true);
	}
	
	public void preparaPrincipalEmpleadoView(){
		super.creaMarco();
		frame.creaPrincipalEmpleadoView();
		frame.muestraPrincipalEmpleadoView();
		creaControladoresVistas();
		frame.setVisible(true);
	}
	
	public void preparaNuevoHotelView(){
		Controlador.frame.creaHotelView(this);
		Controlador.frame.muestraHotelView();
	}	
	
	public void preparaDesplegableHotelView(){
		Controlador.frame.getPav().rellenaDesplegableHoteles(consultasHotel.getHoteles());
	}
	
	public void enviar(){
		consultasHotel.insertaHotel(Controlador.frame.getHv().enviarDatos());
		preparaDesplegableHotelView();
		Controlador.frame.muestraPrincipalAdminView();		
	}
	
	public void cancelar(){
		Controlador.frame.muestraPrincipalAdminView();		
	}
	
	public void eliminar(){
		consultasHotel.eliminaHotel(refHotel);
		preparaDesplegableHotelView();
	}
	
}
