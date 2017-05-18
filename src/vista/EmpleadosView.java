package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;

import controlador.ControladorEmpleados;
import interfaces.IControladorEmpleados;

import javax.swing.JTable;

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
		add(panel, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(40);
		panel.add(verticalStrut);
		
		btnNuevoEmpleado = new JButton("Nuevo Empleado");
		btnNuevoEmpleado.setActionCommand("Nuevo Empleado");
		panel.add(btnNuevoEmpleado);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		btnEliminarEmpleado = new JButton("Eliminar Empleado");
		btnEliminarEmpleado.setActionCommand("Eliminar Empleado");
		panel.add(btnEliminarEmpleado);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		btnModificarEmpleado = new JButton("Modificar Empleado");
		btnModificarEmpleado.setActionCommand("Modificar Empleado");
		panel.add(btnModificarEmpleado);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(40);
		add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(40);
		add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		add(horizontalStrut_1, BorderLayout.EAST);
		
		table = new JTable();
		add(table, BorderLayout.CENTER);
	}

	@Override
	public void estableceControlador(ControladorEmpleados controlador) {
		this.btnNuevoEmpleado.addActionListener(controlador);
		this.btnModificarEmpleado.addActionListener(controlador);
		this.btnEliminarEmpleado.addActionListener(controlador);
	}

}
