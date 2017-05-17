package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class ReservasView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ReservasView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JButton btnNuevaReserva = new JButton("Nueva Reserva");
		btnNuevaReserva.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNuevaReserva);
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		panel.add(btnCancelarReserva);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		String[] colHeader = {"ID","Cliente","Habitación","Check-In","Check-Out","Noches","Pensión"};
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		scrollPane.setViewportView(table);
		

	}

}