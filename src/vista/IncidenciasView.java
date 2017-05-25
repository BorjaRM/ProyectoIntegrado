package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorIncidencias;
import interfaces.IControladorIncidencias;
import modelo.vo.IncidenciaVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IncidenciasView extends JPanel implements IControladorIncidencias{
	private JTable table;
	private JButton btnNueva;
	private JButton btnResuelta;
	private String[]titulosColumnas = {"Descripcion Incidencia", "Estancia", "Estado", "Fecha"};
	private DefaultTableModel modeloTabla;
	private String fecha;


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
		//metodo para que no se pueda editar la celda
		table = new JTable(modeloTabla){
			private static final long serialVersionUID = 1L;
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent event) {
	            if (table.getSelectedRow() > -1) {
	              fecha=(String) table.getValueAt(table.getSelectedRow(), 3);
	            }
	        }
	    });
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
		
		for (int i = 0 ; i < arrayList.size(); i=i+4 ){
			fila[0] = arrayList.get(i);
			fila[1] = arrayList.get(i+1);
			fila[2] = arrayList.get(i+2);
			fila[3] = arrayList.get(i+3);
			modeloTabla.addRow(fila);
		}
		table.setModel(modeloTabla);
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
}