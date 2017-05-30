package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import idiomas.Idiomas;
import modelo.ConexionAdmin;
import modelo.dao.ClienteDAO;
import modelo.dao.EmpleadoDAO;
import modelo.dao.HabitacionDAO;
import modelo.dao.HotelDAO;
import modelo.dao.IncidenciaDAO;
import modelo.dao.ReservaDAO;
import modelo.dao.UsuarioDAO;
import vista.LoginView;

public class ControladorUsuarios extends Controlador implements MouseListener{
	private LoginView vistaLogin;
	private HotelDAO consultasHotel;
	
	public ControladorUsuarios(LoginView login){
		vistaLogin=login;
		consultasHotel = new HotelDAO();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand().toLowerCase()){
			case "entrar": 	compruebaIdioma(); verificaAcceso(); break;		
			case "enviar": enviar(); break;
			case "cancelar": cancelar(); break;
			case "nuevo hotel": preparaNuevoHotelView(); break;
			case "eliminar hotel": eliminar(); break;
			case "nueva referencia hotel": super.actualizaReferenciaHotelAdmin(); preparaListadoAdminView(); break;
			case "obtener permisos": setPermisos((JCheckBox) e.getSource()); break;
		}
	}
	
	public void setPermisos(JCheckBox soyAdmin){
		Controlador.esAdministrador=soyAdmin.isSelected();	
		if(esAdministrador){
			vistaLogin.getText_usuario().setText("Administrador");
			vistaLogin.getText_usuario().setEnabled(false);
		}else{
			vistaLogin.getText_usuario().setEnabled(true);
		}
	}
	
	public void verificaAcceso(){
		if(!Controlador.esAdministrador){
			if(compruebaLoginEmpleado()){
				Controlador.refUsuario=vistaLogin.recogeDatos().getNombre();
				this.estableceReferenciaHotelEmpleado(refUsuario);
				this.estableceReferenciaCodigoEmpleado(refUsuario);
				preparaPrincipalEmpleadoView();
				vistaLogin.setVisible(false);
			}else
				JOptionPane.showMessageDialog(null, "Datos incorrectos, Acceso denegado");			
		}else{
			String pass = vistaLogin.getPasswordAdmin();
			if(!pass.equalsIgnoreCase("")){
				ConexionAdmin ca = new ConexionAdmin(pass);
				if(ca.isDatosOk()){
					preparaPrincipalAdminView();
					vistaLogin.setVisible(false);
				}
			}else
				JOptionPane.showMessageDialog(null, "Ha habido un error en la autenticación", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean compruebaLoginEmpleado(){
		UsuarioDAO consultasUsuario = new UsuarioDAO();
		return consultasUsuario.compruebaUsuario(vistaLogin.recogeDatos());			
	}
	
	public void preparaPrincipalAdminView(){
		super.creaMarco();
		frame.estableceControlador(this);
		frame.creaPrincipalAdminView(this); 
		preparaDesplegableHotelView();
		preparaListadoAdminView();
		actualizaReferenciaHotelAdmin();
		frame.muestraPrincipalAdminView();
		super.creaControladoresVistas();
		frame.setVisible(true);
	}
	
	public void preparaPrincipalEmpleadoView(){
		super.creaMarco();
		frame.estableceControlador(this);
		frame.creaPrincipalEmpleadoView();
		preparaListadosEmpleadoView();
		frame.muestraPrincipalEmpleadoView();
		super.creaControladoresVistas();
		frame.setVisible(true);
	}
	
	public void preparaListadosEmpleadoView(){
		Controlador.frame.getPev().rellenaListaLlegadas(new ReservaDAO().getLLegadasHoy(refHotel));
		Controlador.frame.getPev().rellenaListaSalidas(new ReservaDAO().getSalidasHoy(refHotel));
		Controlador.frame.getPev().rellenaListaIncidencias(new IncidenciaDAO().getIncidenciaActivas(refHotel));
		Controlador.frame.getPev().rellenaListaHabitacionesLibres(new HabitacionDAO().getHabitacionesLibresHoy(refHotel));
	}
	
	public void preparaListadoAdminView(){
		Controlador.frame.getPav().rellenaListaIncidencias(new IncidenciaDAO().getIncidenciaActivas(refHotel));
		Controlador.frame.getPav().getTxt_clientes().setText(String.valueOf(new ClienteDAO().getTotalClientes(refHotel)));
		Controlador.frame.getPav().getTxt_empleados().setText(String.valueOf(new EmpleadoDAO().getTotalEmpleados(refHotel)));
		Controlador.frame.getPav().getTxt_reservas().setText(String.valueOf(new ReservaDAO().getTotalReservasHoy(refHotel)));
		Controlador.frame.getPav().getTxt_hab().setText(String.valueOf(new HabitacionDAO().getTotalHabitaciones(refHotel)));
		Controlador.frame.getPav().getTxt_incidencias().setText(String.valueOf(new IncidenciaDAO().getTotalIncidencias(refHotel)));
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
		int eleccion = JOptionPane.showConfirmDialog(null, "Confirma que deseas eliminar este hotel", "Borrar registro", JOptionPane.YES_NO_OPTION);
		if(eleccion == JOptionPane.YES_OPTION) {
			consultasHotel.eliminaHotel(refHotel);
			preparaDesplegableHotelView();
		}
	}
	
	public void compruebaIdioma() {		
		if (Idiomas.getBundle() == null)
			Idiomas.newIdioma("Español");
	}

	@Override
	public void mouseClicked(MouseEvent e){
		if(esAdministrador){
			preparaListadoAdminView();
			frame.muestraPrincipalAdminView();
		}else{
			preparaListadosEmpleadoView();
			frame.muestraPrincipalEmpleadoView();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
}
