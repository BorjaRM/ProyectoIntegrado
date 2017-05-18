package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorClientes;
import interfaces.IControladorClientes;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;

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

}

