package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorClientes;
import interfaces.IControladorClientes;
import modelo.vo.ClienteVO;
import javax.swing.ListSelectionModel;

public class ClientesView extends JPanel implements IControladorClientes{
	private JTable table;
	private JButton btnNuevoCliente;
	private JButton btnEliminarCliente;
	private JButton btnEditarCliente;
	JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public ClientesView(ResourceBundle bundle) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_BotonesArriba = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_BotonesArriba.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(30);
		add(panel_BotonesArriba, BorderLayout.NORTH);
		
		btnNuevoCliente = new JButton(bundle.getString("btnNewCli"));
		btnNuevoCliente.setActionCommand("Nuevo cliente");
		panel_BotonesArriba.add(btnNuevoCliente);
		
		btnEliminarCliente = new JButton(bundle.getString("btnRmvCli"));
		btnEliminarCliente.setActionCommand("Eliminar cliente");
		panel_BotonesArriba.add(btnEliminarCliente);
		
		btnEditarCliente = new JButton(bundle.getString("btnEditCli"));
		btnEditarCliente.setActionCommand("Editar cliente");
		panel_BotonesArriba.add(btnEditarCliente);
		
		JPanel panel_Tabla = new JPanel();
		add(panel_Tabla, BorderLayout.CENTER);
		panel_Tabla.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_Tabla.add(scrollPane);
		
	
	}
	
	public void estableceControlador(ControladorClientes controlador){
		this.btnNuevoCliente.addActionListener(controlador);
		this.btnEditarCliente.addActionListener(controlador);
		this.btnEliminarCliente.addActionListener(controlador);
	}
	
	public void ocultaBotonEliminar(){
		this.btnEliminarCliente.setVisible(false);
	}
	public void rellenaListaClientes(ArrayList <ClienteVO> cliente){
		String[] colHeader = {"ID","Nombre","Apellidos","F.Nacimiento","Telefono","E-Mail","Nacionalidad"};
		
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
		Object[] fila = new Object[modeloTabla.getColumnCount()];
		
		for (int i = 0 ; i < cliente.size(); i++ ){
			fila[0] = cliente.get(i).getIdentificacion();
			fila[1] = cliente.get(i).getNombre();
			fila[2] = cliente.get(i).getApellidos();
			fila[3] = cliente.get(i).getFecha_nacimiento();
			fila[4] = cliente.get(i).getTelefono();
			fila[5] = cliente.get(i).getEmail();
			fila[6] = cliente.get(i).getNacionalidad();
			modeloTabla.addRow(fila);
		}
		table.setModel(modeloTabla);
			
	}
	public void limpiaLista(){
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	

}

