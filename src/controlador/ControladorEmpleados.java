package controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.dao.ClienteDAO;
import modelo.dao.EmpleadoDAO;
import modelo.dao.UsuarioDAO;
import modelo.vo.ClienteVO;
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
	private int posicionSeleccionada;
	

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
			case "Modificar": modificarEmpleado();
							  preparaEmpleadosView(); break;
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
		 posicionSeleccionada = ev.getTable().getSelectedRow();
		if(posicionSeleccionada != -1){
		frame.creaModificarEmpeladoView(this);
		this.mev=frame.getMev();
		estableceValorCampos();
		modificarEmpleado();
		frame.muestraModificarEmpleadoView();
		}else{
			JOptionPane.showMessageDialog(null, "ERROR. Selecciona un empleado.");
		}
	}
	
	private void eliminaEmpleado(){
		 posicionSeleccionada = ev.getTable().getSelectedRow();
		if(posicionSeleccionada != -1){
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		modeloEmpleado.eliminarEmpleado(posicionSeleccionada);
		rellenaTabla();
		}else{
			JOptionPane.showMessageDialog(null, "ERROR. Selecciona un empleado,");
		}
	}
	
	public void estableceValorCampos(){
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		ArrayList <EmpleadoVO> empleado = modeloEmpleado.rellenarYConseguirArrayEmpleados();
		ArrayList <UsuarioVO> usuarios = modeloEmpleado.rellenarYConseguirArrayUsuarios();

		String salario = String.valueOf(empleado.get(posicionSeleccionada).getSalario());

		mev.getTxtApellido1().setText(empleado.get(posicionSeleccionada).getApellido1());
		mev.getTxtApellido2().setText(empleado.get(posicionSeleccionada).getApellido2());
		mev.getTxtNombre().setText(empleado.get(posicionSeleccionada).getNombre());
		mev.getTxtIdentificacion().setText(empleado.get(posicionSeleccionada).getIdentificacion());
		mev.getTxtSeguridadSocial().setText(empleado.get(posicionSeleccionada).getSeguridad_social());
		mev.getTxtTelefono().setText(empleado.get(posicionSeleccionada).getTelefono());
		mev.getTxtSalario().setText(salario);
		//mev.getTxtUsuario().setText(usuarios.get(posicionSeleccionada).getNombre());
		//mev.getPasswordField().setText(usuarios.get(posicionSeleccionada).getContrasena());
		
	
	}

	public void modificarEmpleado(){
		EmpleadoDAO modeloEmpleado = new EmpleadoDAO(Controlador.refHotel);
		String nombre = mev.getTxtNombre().getText();
		String apellido1 = mev.getTxtApellido1().getText();
		String apellido2 = mev.getTxtApellido2().getText();
		String identificacion = mev.getTxtIdentificacion().getText();
		String telefono = mev.getTxtTelefono().getText();
		String salario =mev.getTxtSalario().getText();
		int salarioINT = Integer.parseInt(salario);
		String seguridad_social = mev.getTxtSeguridadSocial().getText();
		String usuario = mev.getTxtUsuario().getText();
		String contrasena = mev.getPasswordField().getText();
		EmpleadoVO empleado = new EmpleadoVO(0,nombre,apellido1,apellido2,identificacion,telefono,salarioINT,seguridad_social,"",Controlador.refHotel);
		UsuarioVO us = new UsuarioVO(usuario,contrasena);
		modeloEmpleado.modificarEmpleado(empleado,us,posicionSeleccionada);
		
		
	}
	

		public void cancelar(){
		if(ev == null){
			Controlador.frame.muestraPrincipalAdminView();
		}else
			Controlador.frame.muestraEmpleadosView();
	}
	
	


}