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
	private int posicionSeleccionada;
	
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
			case "Modificar": modificaCliente();
							  preparaClientesView(); break;
			case "Cancelar": cancelar(); break;
		}
	}
	
	private void eliminaCliente(){
		posicionSeleccionada = cv.getTable().getSelectedRow();
		if(posicionSeleccionada != -1){
		ClienteDAO modeloCliente = new ClienteDAO(modelo, refHotel);
		modeloCliente.eliminarCliente(posicionSeleccionada);
		rellenaTabla();
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, Primero Selecciona Un Cliente");
		}
	}
	
	private void insertaCliente() {
		ClienteDAO modeloCliente = new ClienteDAO(refHotel);
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
		ClienteDAO modeloCliente = new ClienteDAO(refHotel);
		ArrayList <ClienteVO> clientes = modeloCliente.rellenaYConsigueArrayClientes();
		cv.rellenaListaClientes(clientes);
	}
	
	public void preparaNuevoClienteView(){
		frame.creaNuevoClienteView(this);
		this.ncv=frame.getNcv();
		frame.muestraNuevoClientesView();
	}
	
	public void preparaModificaClienteView(){
		posicionSeleccionada = cv.getTable().getSelectedRow();
		if(posicionSeleccionada != -1){
			frame.creaModificarClienteView(this);
			this.mcv=frame.getMcv();
			estableceValorCampos();
			frame.muestraModificarClienteView();
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, Pimero Selecciona Un Cliente");
		}
	}
	
	public void estableceValorCampos(){
		ClienteDAO modeloCliente = new ClienteDAO(refHotel);
		ArrayList <ClienteVO> clientes = modeloCliente.rellenaYConsigueArrayClientes();
		mcv.getTxt_Apellidos().setText(clientes.get(posicionSeleccionada).getApellidos());
		mcv.getTxt_Email().setText(clientes.get(posicionSeleccionada).getEmail());
		mcv.getTxt_FechaNacimiento().setText(clientes.get(posicionSeleccionada).getFecha_nacimiento());
		mcv.getTxt_Identificacion().setText(clientes.get(posicionSeleccionada).getIdentificacion());
		mcv.getTxt_Nacionalidad().setText(clientes.get(posicionSeleccionada).getNacionalidad());
		mcv.getTxt_Nombre().setText(clientes.get(posicionSeleccionada).getNombre());
		mcv.getTxt_Telefono().setText(clientes.get(posicionSeleccionada).getTelefono());
		
	}
	public void modificaCliente(){
		ClienteDAO modeloCliente = new ClienteDAO(modelo, refHotel);
		String apellidos =mcv.getTxt_Apellidos().getText();
		String email =mcv.getTxt_Email().getText();
		String fNacimiento =mcv.getTxt_FechaNacimiento().getText();
		String nacionalidad =mcv.getTxt_Nacionalidad().getText();
		String identificacion =mcv.getTxt_Identificacion().getText();
		String nombre =mcv.getTxt_Nombre().getText();
		String telefono =mcv.getTxt_Telefono().getText();
		ClienteVO cliente = new ClienteVO("",nombre,apellidos,identificacion,fNacimiento,telefono,nacionalidad,email,"");
		modeloCliente.modificarCliente(posicionSeleccionada, cliente);
		
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