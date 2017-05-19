package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorIncidencias;
import interfaces.IControladorIncidencias;

public class IncidenciasView extends JPanel implements IControladorIncidencias{
	private JTable table;
	private JButton btnNueva;
	private JButton btnResuelta;


	public IncidenciasView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(30);
		add(panel, BorderLayout.NORTH);
		
		btnNueva = new JButton("Nueva Incidencia");
		btnNueva.setActionCommand("Nueva Incidencia");
		panel.add(btnNueva);
		
		btnResuelta = new JButton("Marcar Como Resuelta");
		btnResuelta.setActionCommand("Incidencia Resuelta");
		panel.add(btnResuelta);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		String[]titulosColumnas = {"Descripcion Incidencia", "Estancia", "Estado", "Fecha"};
		
		DefaultTableModel modeloTabla = new DefaultTableModel(titulosColumnas, 0);
		panel_1.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		table = new JTable(modeloTabla);
	
		scrollPane.setViewportView(table);
	}


	@Override
	public void estableceControlador(ControladorIncidencias controlador) {
		this.btnNueva.addActionListener(controlador);
		this.btnResuelta.addActionListener(controlador);
	}


	public void rellenaComboBox() {
		
		
	}
	
}