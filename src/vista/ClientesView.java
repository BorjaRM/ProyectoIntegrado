package vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientesView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ClientesView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_BotonesArriba = new JPanel();
		add(panel_BotonesArriba, BorderLayout.NORTH);
		
		JButton btnAadirCliente = new JButton("Añadir Cliente");
		panel_BotonesArriba.add(btnAadirCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		panel_BotonesArriba.add(btnEliminarCliente);
		
		JButton btnEditarCliente = new JButton("Editar Cliente");
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

}

