package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorClientes;
import interfaces.IControladorClientes;
import modelo.vo.ClienteVO;

public class ClientesView extends JPanel implements IControladorClientes{
	private JTable table;
	private JButton btnNuevoCliente;
	private JButton btnEliminarCliente;
	private JButton btnEditarCliente;

	/**
	 * Create the panel.
	 */
	public ClientesView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_BotonesArriba = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_BotonesArriba.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(30);
		add(panel_BotonesArriba, BorderLayout.NORTH);
		
		btnNuevoCliente = new JButton("Nuevo cliente");
		btnNuevoCliente.setActionCommand("Nuevo cliente");
		panel_BotonesArriba.add(btnNuevoCliente);
		
		btnEliminarCliente = new JButton("Eliminar cliente");
		btnEliminarCliente.setActionCommand("Eliminar cliente");
		panel_BotonesArriba.add(btnEliminarCliente);
		
		btnEditarCliente = new JButton("Editar cliente");
		btnEditarCliente.setActionCommand("Editar cliente");
		panel_BotonesArriba.add(btnEditarCliente);
		
		JPanel panel_Tabla = new JPanel();
		add(panel_Tabla, BorderLayout.CENTER);
		panel_Tabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Tabla.add(scrollPane);
		
		String[] colHeader = {"ID","Nombre","Apellidos","F.Nacimiento","Telefono","Email","Nacionalidad"};
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		scrollPane.setViewportView(table);
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

}

