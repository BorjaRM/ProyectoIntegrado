package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BD;
import vista.ClientesView;
import vista.Marco;
import vista.ModificarClienteView;
import vista.NuevoClienteView;

public class ControladorClientes implements ActionListener{
	private BD modelo;
	private Marco frame;
	private ClientesView cv;
	private NuevoClienteView ncv;
	private ModificarClienteView mcv;
	private final boolean esAdministrador;
;
	
	public ControladorClientes(Marco frame, BD modelo, boolean esAdministrador){
		this.frame=frame;
		this.modelo=modelo;
		this.esAdministrador=esAdministrador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver clientes": preparaClientesView(); break;
			case "Nuevo cliente": preparaNuevoClienteView(); break;
			case "Editar cliente": preparaModificaClienteView(); break;
			case "Eliminar cliente": /* **************************************************************************** */ break;
			case "Enviar": /* **************************************************************************** */ break;
			case "Modificar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
	}
	
	public void preparaClientesView(){
		frame.creaClientesView(this);
		this.cv=frame.getCv();
		if(!esAdministrador)
			cv.ocultaBotonEliminar();
		frame.muestraClientesView();
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
			frame.muestraPrincipalView(esAdministrador);
		}else
			frame.muestraClientesView();
	}
	
	
	

}