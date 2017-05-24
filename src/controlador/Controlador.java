package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;

import javax.swing.JCheckBox;
import modelo.BD;
import modelo.dao.IncidenciaDAO;
import modelo.dao.UsuarioDAO;
import modelo.vo.HotelVO;
import vista.Marco;

public class Controlador implements ActionListener, ItemListener{
	protected static BD modelo;
	protected static Marco frame;
	protected static boolean esAdministrador;
	protected static int refHotel;
	protected static ResourceBundle bundle;
	protected static int refEmpleado;
	
	public Controlador(){
		this.modelo = BD.getSingleDBInstance();
		this.bundle = ResourceBundle.getBundle("idiomas/es_ES");
	}
	
	public void creaMarco(){
		frame = new Marco(bundle);
	}
	
	public void creaControladoresVistas(){
		//Creamos los controladores para cada modulo
		new ControladorClientes();
		new ControladorEmpleados();
		new ControladorReservas();
		new ControladorEstancias();
		new ControladorIncidencias();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand().toLowerCase()){
			case "obtener permisos": setPermisos((JCheckBox) e.getSource()); break;
		}				
	}
	
	public void setPermisos(JCheckBox soyAdmin){
		esAdministrador=soyAdmin.isSelected();
	}

	@Override
	public void itemStateChanged(ItemEvent e){
		//Se ha seleccionado un idioma
		if(e.getStateChange() == 1){ 
			System.out.println("Has cambiado idioma:" +e.getItem());			
			switch ((String)e.getItem()){
				case "Espa�ol": bundle = ResourceBundle.getBundle("idiomas/es_ES"); break;
				case "English": bundle = ResourceBundle.getBundle("idiomas/en_UK"); break;
			}
		}
	}
	
	public void estableceReferenciaHotelEmpleado(String elEmpleado){
		UsuarioDAO consultasUsuario = new UsuarioDAO();
		refHotel=consultasUsuario.getReferenciaHotel(consultasUsuario.getReferenciaEmpleado(elEmpleado));
		System.out.println("referencia hotel:" +refHotel);
	}
	
	public void actualizaReferenciaHotelAdmin(){
		HotelVO hotelSeleccionado = (HotelVO) frame.getPav().getDesplegableHoteles().getSelectedItem();
		if(hotelSeleccionado != null)
			Controlador.refHotel= hotelSeleccionado.getCodigo();
		System.out.println("referencia hotel:" +refHotel);
	}
	public void estableceReferenciaCodigoEmpleado(String elEmpleado){
		UsuarioDAO  consultasUsuario = new UsuarioDAO();
		refEmpleado=consultasUsuario.getReferenciaEmpleado(elEmpleado);
	}

}
