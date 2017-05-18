package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTable;

import controlador.ControladorEstancias;
import interfaces.IControladorEstancias;

public class EstanciasView extends JPanel implements IControladorEstancias{
	private JTable table;
	private JButton btnNuevaEstancia;
	private JButton btnEliminarEstancia;
	private JButton btnModificarEstancia;

	/**
	 * Create the panel.
	 */
	public EstanciasView() {
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
		
		btnNuevaEstancia = new JButton("Nueva Estancia");
		panel.add(btnNuevaEstancia);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		btnEliminarEstancia = new JButton("Eliminar Estancia");
		panel.add(btnEliminarEstancia);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		btnModificarEstancia = new JButton("Modificar Estancia");
		panel.add(btnModificarEstancia);
		
		table = new JTable();
		add(table, BorderLayout.CENTER);

	}

	@Override
	public void estableceControlador(ControladorEstancias controlador) {
		this.btnNuevaEstancia.addActionListener(controlador);
		this.btnModificarEstancia.addActionListener(controlador);
		this.btnEliminarEstancia.addActionListener(controlador);
	}

}
