package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorReservas;
import interfaces.IControladorReservas;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;

public class ReservasView extends JPanel implements IControladorReservas{
	private JTable table;
	private JButton btnNuevaReserva;
	private JButton btnCancelarReserva;

	/**
	 * Create the panel.
	 */
	public ReservasView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		btnNuevaReserva = new JButton("Nueva Reserva");
		btnNuevaReserva.setActionCommand("Nueva Reserva");
		panel.add(btnNuevaReserva);
		
		btnCancelarReserva = new JButton("Anular Reserva");
		btnCancelarReserva.setActionCommand("Anular Reserva");
		panel.add(btnCancelarReserva);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		String[] colHeader = {"ID","Cliente","Habitaci�n","Check-In","Check-Out","Noches","Pensi�n"};
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		scrollPane.setViewportView(table);
	}

	@Override
	public void estableceControlador(ControladorReservas controlador) {
		this.btnNuevaReserva.addActionListener(controlador);
		this.btnCancelarReserva.addActionListener(controlador);
	}

}