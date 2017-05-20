
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
		frame.estableceControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver Empleados": preparaEmpleadosView(); break;
			case "Nuevo Empleado": preparaNuevoEmpleadoView(); break;
			case "Modificar Empleado": preparaModificaEmpleadoView(); break;
			case "Eliminar Empleado": /* **************************************************************************** */ break;
			case "Enviar": /* **************************************************************************** */ break;
			case "Modificar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
	}
	
	public void preparaEmpleadosView(){
		frame.creaEmpleadosView(this);
		this.ev=frame.getEv();
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(modelo, refHotel);
		ArrayList <EmpleadoVO> empleados = modeloEmpleado.rellenarYConseguirArrayEmpleados();
		ev.rellenaListaEmpleados(empleados);
		frame.muestraEmpleadosView();
	}


	public void preparaNuevoEmpleadoView(){
		frame.creaNuevoEmpleadoView(this);
		this.nev=frame.getNev();
		frame.muestraNuevoEmpleadoView();
	}
	
	public void preparaModificaEmpleadoView(){
		//Falta añadir que el admin debe seleccionar a un empleado primero
		frame.creaModificarEmpeladoView(this);
		this.mev=frame.getMev();
		frame.muestraModificarEmpleadoView();
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
			frame.muestraPrincipalAdminView();
		}else
			frame.muestraEmpleadosView();
	}


}