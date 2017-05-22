package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.ClienteDAO;
import modelo.vo.ClienteVO;
import vista.ClientesView;
import vista.Marco;
import vista.ModificarClienteView;
import vista.NuevoClienteView;

public class ControladorClientes extends Controlador{
	private ClientesView cv;
	private NuevoClienteView ncv;
	private ModificarClienteView mcv;

	
	public ControladorClientes(){
		frame.estableceControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver clientes": preparaClientesView(); break;
			case "Nuevo cliente": preparaNuevoClienteView(); break;
			case "Editar cliente": preparaModificaClienteView(); break;
			case "Eliminar cliente": eliminaCliente(); break;
			case "Enviar": insertaCliente();
						   preparaClientesView(); break;
			case "Modificar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
	}
	
	private void eliminaCliente(){
		int posicionParaEliminar = cv.getTable().getSelectedRow();
		ClienteDAO modeloCliente = new ClienteDAO(modelo, refHotel);
		System.out.println(posicionParaEliminar);
		modeloCliente.eliminarCliente(posicionParaEliminar);
		rellenaTabla();
	}
	
	private void insertaCliente() {
		ClienteDAO modeloCliente = new ClienteDAO(modelo, refHotel);
		ClienteVO cliente = new ClienteVO("",ncv.getTxt_Nombre().getText(),ncv.getTxt_Apellidos().getText(),ncv.getTxt_Identificacion().getText(),ncv.getTxt_FechaNacimiento().getText(),ncv.getTxt_Telefono().getText(),ncv.getTxt_Nacionalidad().getText(),ncv.getTxt_Email().getText(),"");

		if(ncv.getTxt_Apellidos().getText().isEmpty() || ncv.getTxt_Nombre().getText().isEmpty() || ncv.getTxt_Email().getText().isEmpty() || ncv.getTxt_FechaNacimiento().getText().isEmpty() || ncv.getTxt_Identificacion().getText().isEmpty() || ncv.getTxt_Telefono().getText().isEmpty() || ncv.getTxt_Nacionalidad().getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Faltan datos por rellenar, Error");	
		}else{			
			modeloCliente.insertaCliente(cliente);
		}
		
	}

	public void preparaClientesView(){
		frame.creaClientesView(this);
		this.cv=frame.getCv();
		if(!esAdministrador)
			cv.ocultaBotonEliminar();
		rellenaTabla();
		frame.muestraClientesView();
	}
	
	public void rellenaTabla(){
		ClienteDAO modeloCliente = new ClienteDAO(modelo, refHotel);
		ArrayList <ClienteVO> clientes = modeloCliente.rellenaYConsigueArrayClientes();
		cv.rellenaListaClientes(clientes);
	}
	
	public void preparaNuevoClienteView(){
		frame.creaNuevoClienteView(this);
		this.ncv=frame.getNcv();
		frame.muestraNuevoClientesView();
	}
	
	public void preparaModificaClienteView(){
		//Falta a�adir que el usuario debe seleccionar a un cliente primero
		frame.creaModificarClienteView(this);
		this.mcv=frame.getMcv();
		frame.muestraModificarClienteView();
	}
	
	public void eliminarCliente(){
		//Eliminar cliente seleccionado y volver a mostar clientesView
	}
	
	public void insertarCliente(){
		//Insertar cliente y volver a mostar clientesView
	}

	public void modificarCliente(){
		//Modificar cliente seleccionado y volver a mostar clientesView
	}

	public void cancelar(){
		if(cv == null){
			if(esAdministrador)
				frame.muestraPrincipalAdminView();		
			else
				frame.muestraPrincipalEmpleadoView();
		}else
			frame.muestraClientesView();
	}
	
	
	

}