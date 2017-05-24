package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

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
	private String[]titulosColumnas = {"Descripcion Incidencia", "Estancia", "Estado", "Fecha"};
	private DefaultTableModel modeloTabla;


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
		
		modeloTabla = new DefaultTableModel(titulosColumnas, 0);
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
	public void rellenaTablaIncidencias(ArrayList<String> arrayList){
		modeloTabla = new DefaultTableModel(titulosColumnas,0);
		Object[] fila = new Object[modeloTabla.getColumnCount()];
		
		for (int i = 0 ; i < arrayList.size(); i++ ){
			fila[0] = arrayList.get(i);
			fila[1] = arrayList.get(i);
			fila[2] = arrayList.get(i);
			fila[3] = arrayList.get(i);
			modeloTabla.addRow(fila);
		}
		table.setModel(modeloTabla);
	}

	public void rellenaComboBox() {
		
		
	}
	
}