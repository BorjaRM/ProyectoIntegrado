package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEmpleados;
import interfaces.IControladorEmpleados;

import javax.swing.JTable;
import java.awt.FlowLayout;

public class EmpleadosView extends JPanel implements IControladorEmpleados{
	private JTextField textField;
	private JTable table;
	private JButton btnNuevoEmpleado;
	private JButton btnEliminarEmpleado;
	private JButton btnModificarEmpleado;

	/**
	 * Create the panel.
	 */
	public EmpleadosView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(30);
		add(panel, BorderLayout.NORTH);
		
		btnNuevoEmpleado = new JButton("Nuevo Empleado");
		btnNuevoEmpleado.setActionCommand("Nuevo Empleado");
		panel.add(btnNuevoEmpleado);
		
		btnEliminarEmpleado = new JButton("Eliminar Empleado");
		btnEliminarEmpleado.setActionCommand("Eliminar Empleado");
		panel.add(btnEliminarEmpleado);
		
		btnModificarEmpleado = new JButton("Modificar Empleado");
		btnModificarEmpleado.setActionCommand("Modificar Empleado");
		panel.add(btnModificarEmpleado);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_Tabla = new JPanel();
		add(panel_Tabla, BorderLayout.CENTER);
		panel_Tabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Tabla.add(scrollPane);
		
		String[] colHeader = {"ID","Nombre","Apellidos","Telefono","Inicio contrato"};
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		scrollPane.setViewportView(table);
	}

	@Override
	public void estableceControlador(ControladorEmpleados controlador) {
		this.btnNuevoEmpleado.addActionListener(controlador);
		this.btnModificarEmpleado.addActionListener(controlador);
		this.btnEliminarEmpleado.addActionListener(controlador);
	}

}
