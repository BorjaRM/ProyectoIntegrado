package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class IncidenciasView extends JPanel {
	private JTable table;


	public IncidenciasView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Nueva Incidencia");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Marcar Como Resuelta");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		String[]titulosColumnas = {"Descripcion Incidencia", "Estancia", "Estado", "Fecha"};
		
		DefaultTableModel modeloTabla = new DefaultTableModel(titulosColumnas, 0);
		panel_1.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		table = new JTable(modeloTabla);
	
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
	}

	
}