package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import modelo.vo.EstanciaVO;
import modelo.vo.IncidenciaVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import idiomas.Idiomas;

public class IncidenciasView extends JPanel implements IControladorIncidencias{
	ResourceBundle bundle = Idiomas.getBundle();
	private JTable table;
	private JButton btnNueva;
	private JButton btnResuelta;
	private String[]titulosColumnas = {bundle.getString("jTblInciDesc"), bundle.getString("jTblInciEstan"), bundle.getString("jTblInciEstado"), bundle.getString("jTblInciFecha")};
	private DefaultTableModel modeloTabla;
	private String fecha;
	JScrollPane scrollPane;


	public IncidenciasView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(30);
		add(panel, BorderLayout.NORTH);
		
		btnNueva = new JButton(bundle.getString("btnInciNewInci"));
		btnNueva.setActionCommand("Nueva Incidencia");
		panel.add(btnNueva);
		
		btnResuelta = new JButton(bundle.getString("btnInciDoneInci"));
		btnResuelta.setActionCommand("Incidencia Resuelta");
		panel.add(btnResuelta);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);

		panel_1.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
	}


	@Override
	public void estableceControlador(ControladorIncidencias controlador) {
		this.btnNueva.addActionListener(controlador);
		this.btnResuelta.addActionListener(controlador);
	}

	public void rellenaTablaIncidencias(ArrayList<IncidenciaVO> incidencias,ArrayList<EstanciaVO>estancias){
		modeloTabla = new DefaultTableModel(titulosColumnas,0);
		table = new JTable(modeloTabla);
	    scrollPane.setViewportView(table);
	    
		Object[] fila = new Object[modeloTabla.getColumnCount()];
		for (int i = 0 ; i < incidencias.size(); i++ ){
			fila[0] = incidencias.get(i).getDescripcion();
			fila[2] = incidencias.get(i).getEstado();
			fila[3] = incidencias.get(i).getFecha();
		for (int j = 0 ; j < estancias.size(); j++){
			if(incidencias.get(i).getCod_estancia()==(estancias.get(j).getId())){
			fila[1] = estancias.get(j).getNombre();
			}
		}
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