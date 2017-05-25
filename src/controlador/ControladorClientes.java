package controlador;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import modelo.dao.ClienteDAO;
import modelo.vo.ClienteVO;
import vista.ClientesView;
import vista.ModificarClienteView;
import vista.NuevoClienteView;

public class ControladorClientes extends Controlador{
	private ClientesView cv;
	private NuevoClienteView ncv;
	private ModificarClienteView mcv;
	private ClienteDAO modeloCliente;
	private int posicionSeleccionada;
	
	public ControladorClientes(){
		frame.estableceControlador(this);
		modeloCliente = new ClienteDAO();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
			int eleccion = JOptionPane.showConfirmDialog(null, "Confirma que deseas eliminar este cliente", "Borrar registro", JOptionPane.YES_NO_OPTION);
			if(eleccion == JOptionPane.YES_OPTION) {
				modeloCliente.eliminarCliente(posicionSeleccionada);
				rellenaTabla();
			}
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, Primero Selecciona Un Cliente");
		}
	}
	
	private void insertaCliente() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		fecha = sdf.format(ncv.getDateChooser().getDate().getTime());
		ClienteVO cliente = new ClienteVO("",ncv.getTxt_Nombre().getText(),
				ncv.getTxt_Apellidos().getText(),
				ncv.getTxt_Identificacion().getText(),
				fecha,
				ncv.getTxt_Telefono().getText(),
				ncv.getTxt_Nacionalidad().getText(),
				ncv.getTxt_Email().getText(),"");

		if(ncv.getTxt_Apellidos().getText().isEmpty() || ncv.getTxt_Nombre().getText().isEmpty() || ncv.getTxt_Email().getText().isEmpty() || ncv.getTxt_Identificacion().getText().isEmpty() || ncv.getTxt_Telefono().getText().isEmpty() || ncv.getTxt_Nacionalidad().getText().isEmpty()){
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
		ArrayList <ClienteVO> clientes = modeloCliente.rellenaYConsigueArrayClientes();
		mcv.getTxt_Apellidos().setText(clientes.get(posicionSeleccionada).getApellidos());
		mcv.getTxt_Email().setText(clientes.get(posicionSeleccionada).getEmail());
		mcv.getDateChooser().setToolTipText(clientes.get(posicionSeleccionada).getFecha_nacimiento());
		mcv.getTxt_Identificacion().setText(clientes.get(posicionSeleccionada).getIdentificacion());
		mcv.getTxt_Nacionalidad().setText(clientes.get(posicionSeleccionada).getNacionalidad());
		mcv.getTxt_Nombre().setText(clientes.get(posicionSeleccionada).getNombre());
		mcv.getTxt_Telefono().setText(clientes.get(posicionSeleccionada).getTelefono());
		
	}
	public void modificaCliente(){
		String apellidos =mcv.getTxt_Apellidos().getText();
		String email =mcv.getTxt_Email().getText();
		String fNacimiento =mcv.getDateChooser().getToolTipText();
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