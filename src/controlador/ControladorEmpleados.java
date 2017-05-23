package controlador;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.ClienteDAO;
import modelo.dao.EmpleadoDAO;
import modelo.dao.UsuarioDAO;
import modelo.vo.ClienteVO;
import modelo.vo.EmpleadoVO;
import modelo.vo.UsuarioVO;
import vista.EmpleadosView;
import vista.Marco;
import vista.ModificarEmpleadoView;
import vista.NuevoEmpleadoView;

public class ControladorEmpleados extends Controlador{
	private EmpleadosView ev;
	private ModificarEmpleadoView mev;
	private NuevoEmpleadoView nev;
	

	public ControladorEmpleados(){
		Controlador.frame.estableceControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver empleados": preparaEmpleadosView(); break;
			case "Nuevo empleado": preparaNuevoEmpleadoView(); break;
			case "Modificar Empleado": preparaModificaEmpleadoView(); break;
			case "Eliminar Empleado": eliminaEmpleado();break;
			case "Enviar": insertarEmpleado();
						   preparaEmpleadosView();	break;
			case "Modificar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
	}

	
	private void insertarEmpleado() {
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(modelo, refHotel);
		//UsuarioDAO modeloUsuario = new UsuarioDAO(modelo);
		if(nev.getTxtUsuario().getText().isEmpty() || nev.getPasswordField().getText().isEmpty() || nev.getTxtNombre().getText().isEmpty() || nev.getTxtApellido1().getText().isEmpty() || nev.getTxtApellido2().getText().isEmpty() || nev.getTxtIdentificacion().getText().isEmpty() || nev.getTxtTelefono().getText().isEmpty() || nev.getTxtSalario().getText().isEmpty() || nev.getTxtSeguridadSocial().getText().isEmpty() /*|| nev.getTxtFechaAlta().getText().isEmpty() */ || nev.getTxtLugarTrabajo().getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Faltan datos por rellenar, Error");	
		}else{	
			String salarioTxt = nev.getTxtSalario().getText();
			int salarioInt = Integer.parseInt(salarioTxt);
			String hotelTxt = nev.getTxtLugarTrabajo().getText();
			int hotelInt = Integer.parseInt(hotelTxt);
			EmpleadoVO em = new EmpleadoVO(0,nev.getTxtNombre().getText(),nev.getTxtApellido1().getText(),nev.getTxtApellido2().getText(),nev.getTxtIdentificacion().getText(),nev.getTxtTelefono().getText(),salarioInt,nev.getTxtSeguridadSocial().getText(),"",hotelInt);
			UsuarioVO us = new UsuarioVO(nev.getTxtUsuario().getText(),nev.getPasswordField().getText(),em.getCodigo());
			modeloEmpleado.insertarEmpleado(em,us);
		}
		
	}
	
	public void preparaEmpleadosView(){
		Controlador.frame.creaEmpleadosView(this);
		this.ev=Controlador.frame.getEv();
		rellenaTabla();
		Controlador.frame.muestraEmpleadosView();
	}
	
	public void rellenaTabla(){
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(modelo, refHotel);
		ArrayList <EmpleadoVO> empleados = modeloEmpleado.rellenarYConseguirArrayEmpleados();
		ev.rellenaListaEmpleados(empleados);
	}


	public void preparaNuevoEmpleadoView(){
		Controlador.frame.creaNuevoEmpleadoView(this);
		this.nev=Controlador.frame.getNev();
		Controlador.frame.muestraNuevoEmpleadoView();
	}
	
	public void preparaModificaEmpleadoView(){
		//Falta añadir que el admin debe seleccionar a un empleado primero
		Controlador.frame.creaModificarEmpeladoView(this);
		this.mev=Controlador.frame.getMev();
		Controlador.frame.muestraModificarEmpleadoView();
	}
	
	private void eliminaEmpleado(){
		int posicionParaEliminar = ev.getTable().getSelectedRow();
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(modelo,refHotel);
		System.out.println(posicionParaEliminar);
		modeloEmpleado.eliminarEmpleado(posicionParaEliminar);
		rellenaTabla();
	}
	
//	public void insertarEmpleado(){
//		//Insertar empleado y volver a mostar empleadosView
//		
//	}

	public void modificarEmpleado(){
		//Modificar empleado seleccionado y volver a mostar empleadosView
	}

	public void cancelar(){
		if(ev == null){
			Controlador.frame.muestraPrincipalAdminView();
		}else
			Controlador.frame.muestraEmpleadosView();
	}


}