package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTable;

public class ListaEstancias extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListaEstancias() {
		setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(40);
		add(horizontalStrut, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		add(horizontalStrut_1, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(40);
		add(verticalStrut, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(40);
		panel.add(verticalStrut_1);
		
		JButton btnNewButton = new JButton("Nueva Estancia");
		panel.add(btnNewButton);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		JButton btnNewButton_1 = new JButton("Eliminar Estancia");
		panel.add(btnNewButton_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		JButton btnNewButton_2 = new JButton("Modificar Estancia");
		panel.add(btnNewButton_2);
		
		table = new JTable();
		add(table, BorderLayout.CENTER);

	}

}
