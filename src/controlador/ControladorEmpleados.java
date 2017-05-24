package controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.EmpleadoDAO;
import modelo.vo.EmpleadoVO;
import modelo.vo.UsuarioVO;
import res.Md5;
import vista.EmpleadosView;
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
		switch(e.getActionCommand()){
			case "Ver empleados": preparaEmpleadosView(); break;
			case "Nuevo empleado": preparaNuevoEmpleadoView(); break;
			case "Modificar Empleado": preparaModificaEmpleadoView(); break;
			case "Eliminar Empleado": eliminaEmpleado();break;
			case "Enviar": insertarEmpleado();
						   preparaEmpleadosView();	break;
			case "Modificar": modificarEmpleado(); break;
			case "Cancelar": cancelar(); break;
		}
	}

	
	private void insertarEmpleado() {
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		if(nev.getTxtUsuario().getText().isEmpty() || new String(nev.getPasswordField().getPassword()).isEmpty() || nev.getTxtNombre().getText().isEmpty() || 
				nev.getTxtApellido1().getText().isEmpty() || nev.getTxtApellido2().getText().isEmpty() || nev.getTxtIdentificacion().getText().isEmpty() || 
				nev.getTxtTelefono().getText().isEmpty() || nev.getTxtSalario().getText().isEmpty() || nev.getTxtSeguridadSocial().getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Faltan datos por rellenar, Error");	
		}else{	
			int salarioInt = Integer.parseInt(nev.getTxtSalario().getText());
			EmpleadoVO em = new EmpleadoVO(0,nev.getTxtNombre().getText(),nev.getTxtApellido1().getText(),nev.getTxtApellido2().getText(),nev.getTxtIdentificacion().getText(),nev.getTxtTelefono().getText(),salarioInt,nev.getTxtSeguridadSocial().getText(),"",Controlador.refHotel);
			UsuarioVO us = new UsuarioVO(nev.getTxtUsuario().getText(),Md5.encriptar(new String(nev.getPasswordField().getPassword())),em.getCodigo());
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
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		ArrayList <EmpleadoVO> empleados = modeloEmpleado.rellenarYConseguirArrayEmpleados();
		ev.rellenaListaEmpleados(empleados);
	}


	public void preparaNuevoEmpleadoView(){
		Controlador.frame.creaNuevoEmpleadoView(this);
		this.nev=Controlador.frame.getNev();
		Controlador.frame.muestraNuevoEmpleadoView();
	}
	
	public void preparaModificaEmpleadoView(){
		frame.creaModificarEmpeladoView(this);
		this.mev=frame.getMev();
		estableceValorCampos();
		modificarEmpleado();
		frame.muestraModificarEmpleadoView();
	}
	
	private void eliminaEmpleado(){
		int posicionParaEliminar = ev.getTable().getSelectedRow();
		if(posicionParaEliminar != -1){
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		modeloEmpleado.eliminarEmpleado(posicionParaEliminar);
		rellenaTabla();
		}else{
			JOptionPane.showMessageDialog(null, "Selecciona un empleado, Error");
		}
	}
	
	public void estableceValorCampos(){
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		ArrayList <EmpleadoVO> empleados = modeloEmpleado.rellenarYConseguirArrayEmpleados();
		int posicionSeleccionada = ev.getTable().getSelectedRow();
		String lugar_trabajo = String.valueOf(empleados.get(posicionSeleccionada).getLugar_trabajo());
		String salario = String.valueOf(empleados.get(posicionSeleccionada).getSalario());

		
		mev.getTxtApellido1().setText(empleados.get(posicionSeleccionada).getApellido1());
		mev.getTxtApellido2().setText(empleados.get(posicionSeleccionada).getApellido2());
		mev.getTxtNombre().setText(empleados.get(posicionSeleccionada).getNombre());
		mev.getTxtIdentificacion().setText(empleados.get(posicionSeleccionada).getIdentificacion());
		mev.getTxtLugarTrabajo().setText(lugar_trabajo); 
		mev.getTxtSeguridadSocial().setText(empleados.get(posicionSeleccionada).getSeguridad_social());
		mev.getTxtTelefono().setText(empleados.get(posicionSeleccionada).getTelefono());
		mev.getTxtSalario().setText(salario);
	
	}

	public void modificarEmpleado(){
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		
		
	}

	public void cancelar(){
		if(ev == null){
			Controlador.frame.muestraPrincipalAdminView();
		}else
			Controlador.frame.muestraEmpleadosView();
	}
	
	


}