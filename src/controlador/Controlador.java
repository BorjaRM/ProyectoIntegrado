package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import idiomas.Idiomas;
import modelo.BD;
import modelo.dao.UsuarioDAO;
import modelo.vo.HotelVO;
import vista.Marco;

public class Controlador implements ActionListener, ItemListener{
	protected static BD modelo;
	protected static Marco frame;
	protected static boolean esAdministrador;
	protected static int refHotel;
	protected static int refEmpleado;
	protected static String refUsuario;
	
	public Controlador(){
		this.modelo = BD.getSingleDBInstance();
	}
	
	public void creaMarco(){
		frame = new Marco();
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
			Idiomas.newIdioma((String)e.getItem());
		}
	}
	
	public void estableceReferenciaHotelEmpleado(String elEmpleado){
		UsuarioDAO consultasUsuario = new UsuarioDAO();
		refHotel=consultasUsuario.getReferenciaHotel(consultasUsuario.getReferenciaEmpleado(elEmpleado));
	}
	
	public void actualizaReferenciaHotelAdmin(){
		HotelVO hotelSeleccionado = (HotelVO) frame.getPav().getDesplegableHoteles().getSelectedItem();
		if(hotelSeleccionado != null)
			Controlador.refHotel= hotelSeleccionado.getCodigo();
	}
	public void estableceReferenciaCodigoEmpleado(String refUsuario){
		UsuarioDAO  consultasUsuario = new UsuarioDAO();
		refEmpleado=consultasUsuario.getReferenciaEmpleado(refUsuario);
	}

}
