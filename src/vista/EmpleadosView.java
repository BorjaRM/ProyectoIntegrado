package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

public class EmpleadosView extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public EmpleadosView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(40);
		panel.add(verticalStrut);
		
		JButton btnNewButton = new JButton("A\u00F1adir Empleado");
		panel.add(btnNewButton);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		JButton btnNewButton_1 = new JButton("Eliminar Empleado");
		panel.add(btnNewButton_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		JButton btnNewButton_2 = new JButton("Modificar Empleado");
		panel.add(btnNewButton_2);
		
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

}
