package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.ClienteDAO;
import modelo.dao.EmpleadoDAO;
import modelo.dao.HabitacionDAO;
import modelo.dao.HotelDAO;
import modelo.dao.IncidenciaDAO;
import modelo.dao.ReservaDAO;
import modelo.dao.UsuarioDAO;
import modelo.vo.HotelVO;
import vista.LoginView;
import vista.Marco;

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
			case "entrar": verificaAcceso(); break;
			case "enviar": enviar(); break;
			case "cancelar": cancelar(); break;
			case "nuevo hotel": preparaNuevoHotelView(); break;
			case "eliminar hotel": eliminar(); break;
			case "nueva referencia hotel": super.actualizaReferenciaHotelAdmin(); preparaListadoAdminView(); break;
		}
	}
	
	public void verificaAcceso(){
		if(!Controlador.esAdministrador){
			if(compruebaLoginEmpleado()){
				String elEmpleado=vistaLogin.recogeDatos().getNombre();
				this.estableceReferenciaHotelEmpleado(elEmpleado);
				this.estableceReferenciaCodigoEmpleado(elEmpleado);
				preparaPrincipalEmpleadoView();
			}else
				JOptionPane.showMessageDialog(null, "Datos incorrectos, Acceso denegado");			
		}else{
			System.err.println("programar acceso por VMware");
			preparaPrincipalAdminView();
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
		Controlador.frame.getPev().rellenaListaHabitacionesLibres(new HabitacionDAO().getHabitacionesLibres(refHotel));
	}
	
	public void preparaListadoAdminView(){
		Controlador.frame.getPav().rellenaListaIncidencias(new IncidenciaDAO().getIncidenciaActivas(refHotel));
		Controlador.frame.getPav().getTxt_clientes().setText(String.valueOf(new ClienteDAO().getTotalClientes(refHotel)));
		Controlador.frame.getPav().getTxt_empleados().setText(String.valueOf(new EmpleadoDAO(refHotel).getTotalEmpleados()));
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

	@Override
	public void mouseClicked(MouseEvent e){
		if(esAdministrador)
			frame.muestraPrincipalAdminView();
		else
			frame.muestraPrincipalEmpleadoView();
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
