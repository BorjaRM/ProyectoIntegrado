package controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.dao.EmpleadoDAO;
import modelo.dao.UsuarioDAO;
import modelo.vo.EmpleadoVO;
import modelo.vo.UsuarioVO;
import res.Md5;
import vista.EmpleadosView;
import vista.ModificarEmpleadoView;
import vista.NuevoEmpleadoView;

public class ControladorEmpleados extends Controlador implements ListSelectionListener{
	private EmpleadosView ev;
	private ModificarEmpleadoView mev;
	private NuevoEmpleadoView nev;
	private EmpleadoVO empleadoSeleccionado;
	private UsuarioVO usuarioSeleccionado;
	

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
			case "Enviar": insertarEmpleado(); preparaEmpleadosView(); break;
			case "Modificar": modificarEmpleado(); preparaEmpleadosView(); break;
			case "Cancelar": cancelar(); break;
		}
	}

	
	private void insertarEmpleado() {	
		EmpleadoVO e;
		String nom=nev.getTxtNombre().getText();
		String ap1=nev.getTxtApellido1().getText();
		String ap2=nev.getTxtApellido2().getText();
		String id=nev.getTxtIdentificacion().getText();
		String tlf=nev.getTxtTelefono().getText();
		int s=Integer.valueOf(nev.getTxtSalario().getText());
		String ss=nev.getTxtSeguridadSocial().getText();
		String us= nev.getTxtUsuario().getText();
		String pass=Md5.encriptar(new String(nev.getPasswordField().getPassword()));
				
		new EmpleadoDAO().insertarEmpleado(new EmpleadoVO(0,nom,ap1,ap2,id,tlf,s,ss,"",0), refHotel);
		new UsuarioDAO().insertarUsuario(new UsuarioVO(us,pass,0));
	}	

	
	
	public void preparaEmpleadosView(){
		Controlador.frame.creaEmpleadosView(this);
		this.ev=Controlador.frame.getEv();
		rellenaTabla();
		Controlador.frame.muestraEmpleadosView();
	}
	
	public void rellenaTabla(){
		ev.rellenaListaEmpleados(new EmpleadoDAO().getEmpleados(Controlador.refHotel));
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
		frame.muestraModificarEmpleadoView();
	}
	
	private void eliminaEmpleado(){
		if(this.empleadoSeleccionado != null){
			int eleccion = JOptionPane.showConfirmDialog(null, "Confirma que deseas eliminar este cliente", "Borrar registro", JOptionPane.YES_NO_OPTION);
			if(eleccion == JOptionPane.YES_OPTION) {
				new EmpleadoDAO().eliminarEmpleado(this.empleadoSeleccionado);;
				rellenaTabla();
			}
		}else{
			JOptionPane.showMessageDialog(null, "ERROR. Selecciona un empleado,");
		}
	}
	
	public void estableceValorCampos(){
		if(this.empleadoSeleccionado != null && this.usuarioSeleccionado != null){
			mev.getTxtApellido1().setText(this.empleadoSeleccionado.getApellido1());
			mev.getTxtApellido2().setText(this.empleadoSeleccionado.getApellido2());
			mev.getTxtNombre().setText(this.empleadoSeleccionado.getNombre());
			mev.getTxtIdentificacion().setText(this.empleadoSeleccionado.getIdentificacion());
			mev.getTxtSeguridadSocial().setText(this.empleadoSeleccionado.getSeguridad_social());
			mev.getTxtTelefono().setText(this.empleadoSeleccionado.getTelefono());
			mev.getTxtSalario().setText(String.valueOf(this.empleadoSeleccionado.getSalario()));
			mev.getTxtUsuario().setText(this.usuarioSeleccionado.getNombre());
			mev.getPasswordField().setText(this.usuarioSeleccionado.getContrasena());
		}
	}

	public void modificarEmpleado(){
		int cod = this.empleadoSeleccionado.getCodigo();
		String nom = mev.getTxtNombre().getText();
		String ap1 = mev.getTxtApellido1().getText();
		String ap2 = mev.getTxtApellido2().getText();
		String id = mev.getTxtIdentificacion().getText();
		String tlf = mev.getTxtTelefono().getText();
		int s =Integer.parseInt(mev.getTxtSalario().getText());
		String ss = mev.getTxtSeguridadSocial().getText();
		String us = mev.getTxtUsuario().getText();
		String pass = Md5.encriptar(new String(mev.getPasswordField().getPassword()));		
		
		EmpleadoVO empleadoModificado = new EmpleadoVO(cod,nom,ap1,ap2,id,tlf,s,ss,"",0);
		UsuarioVO usuariomodificado = new UsuarioVO(us,pass,0);
		
		new EmpleadoDAO().modificarEmpleado(empleadoModificado);
		new UsuarioDAO().modificarUsuario(usuariomodificado,cod);
	}
	

		public void cancelar(){
		if(ev == null){
			Controlador.frame.muestraPrincipalAdminView();
		}else
			Controlador.frame.muestraEmpleadosView();
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()){
				ArrayList <EmpleadoVO> empleados = new EmpleadoDAO().getEmpleados(Controlador.refHotel);
				ArrayList <UsuarioVO> usuarios = new UsuarioDAO().getUsuarios(Controlador.refHotel);
				if(!e.getValueIsAdjusting()){
					int filaSeleccionada = ev.getTable().getSelectedRow();
					if(filaSeleccionada > -1){
						this.empleadoSeleccionado=empleados.get(filaSeleccionada);
						this.usuarioSeleccionado=usuarios.get(filaSeleccionada);
					}
				}
			}
		}
	
	


}