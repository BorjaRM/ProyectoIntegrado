
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BD;
import vista.EmpleadosView;
import vista.Marco;
import vista.ModificarEmpleadoView;
import vista.NuevoEmpleadoView;

public class ControladorEmpleados implements ActionListener {
	private BD modelo;
	private Marco frame;
	private EmpleadosView ev;
	private ModificarEmpleadoView mev;
	private NuevoEmpleadoView nev;
	private int refHotel;

	public ControladorEmpleados(Marco frame, BD modelo, int refHotel){
		this.frame=frame;
		this.modelo=modelo;
		this.refHotel=refHotel;
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
		frame.muestraEmpleadosView();
	}

	public void preparaNuevoEmpleadoView(){
		frame.creaNuevoEmpleadoView(this);
		this.nev=frame.getNev();
		frame.muestraNuevoEmpleadoView();
	}
	
	public void preparaModificaEmpleadoView(){
		//Falta a�adir que el admin debe seleccionar a un empleado primero
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