
package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import modelo.BD;
import modelo.dao.ClienteDAO;
import modelo.dao.EmpleadoDAO;
import modelo.vo.ClienteVO;
import modelo.vo.EmpleadoVO;
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
		switch(e.getActionCommand().toLowerCase()){
			case "ver empleados": preparaEmpleadosView(); break;
			case "nuevo empleado": preparaNuevoEmpleadoView(); break;
			case "modificar empleado": preparaModificaEmpleadoView(); break;
			case "eliminar empleado": /* **************************************************************************** */ break;
			case "enviar": /* **************************************************************************** */ break;
			case "modificar": /* **************************************************************************** */ break;
			case "cancelar": cancelar(); break;
		}
	}
	
	public void preparaEmpleadosView(){
		Controlador.frame.creaEmpleadosView(this);
		this.ev=Controlador.frame.getEv();
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(refHotel);
		ArrayList <EmpleadoVO> empleados = modeloEmpleado.rellenarYConseguirArrayEmpleados();
		ev.rellenaListaEmpleados(empleados);
		Controlador.frame.muestraEmpleadosView();
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
	
	public void eliminarEmpleado(){
		//Eliminar empleado seleccionado y volver a mostar empleadosView
	}
	
	public void insertarEmpleado(){
		//Insertar empleado y volver a mostar empleadosView
		
	}

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