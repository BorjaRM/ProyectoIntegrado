package vista;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEstancias;
import idiomas.Idiomas;
import interfaces.IControladorEstancias;
import modelo.vo.EstanciaVO;
import modelo.vo.HabitacionVO;

public class EstanciasView extends JPanel implements IControladorEstancias{
	private JButton btnNuevaEstancia;
	private JButton btnModificarEstancia;
	private JButton btnEliminarEstancia;
	private JTable tabla_habitaciones;
	ResourceBundle bundle = Idiomas.getBundle();
	private final String[] habitaciones_head = {bundle.getString("jTblEstanID"),bundle.getString("jTblEstanNom"),bundle.getString("jTblEstanTipo"),bundle.getString("jTblEstanPlazas"),bundle.getString("jTblEstanPension"),bundle.getString("jLblRegEstanDescrp")};
	private DefaultTableModel habitaciones_model;
	private JTable tabla_estancias;
	private final String[] estancias_head = {bundle.getString("jTblEstanZonCom")};
	private DefaultTableModel estancias_model;
	
	
	/**
	 * Create the panel.
	 */
	public EstanciasView() {
		setLayout(new BorderLayout(0, 0));
		JPanel botonera = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botonera.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setVgap(15);
		add(botonera, BorderLayout.NORTH);
		
		btnNuevaEstancia = new JButton(bundle.getString("btnNewEstan"));
		botonera.add(btnNuevaEstancia);
		
		btnEliminarEstancia = new JButton(bundle.getString("btnRmvEstan"));
		botonera.add(btnEliminarEstancia);
		
		btnModificarEstancia = new JButton(bundle.getString("btnModEstan"));
		botonera.add(btnModificarEstancia);
		
		JPanel panel_Tabla = new JPanel();
		add(panel_Tabla, BorderLayout.CENTER);
		
		//Creamos la tabla que contiene las habitaciones
		JScrollPane scrollPane = new JScrollPane();
		habitaciones_model = new DefaultTableModel(habitaciones_head,0);
		tabla_habitaciones = new JTable(habitaciones_model);
		tabla_habitaciones.setAutoCreateRowSorter(true);
		tabla_habitaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla_habitaciones.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla_habitaciones);		

		//Creamos la tabla que contiene el resto de estancias
		JScrollPane scrollPane_1 = new JScrollPane();
		estancias_model = new DefaultTableModel(estancias_head,0);
		tabla_estancias = new JTable(estancias_model);
		tabla_estancias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla_estancias.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tabla_estancias);
		panel_Tabla.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane_10 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,scrollPane,scrollPane_1);
		add(splitPane_10);
	}

	@Override
	public void estableceControlador(ControladorEstancias controlador) {
		this.btnNuevaEstancia.addActionListener(controlador);
		this.btnModificarEstancia.addActionListener(controlador);
		this.btnEliminarEstancia.addActionListener(controlador);		
		this.tabla_habitaciones.getSelectionModel().addListSelectionListener(controlador);
		this.tabla_estancias.getSelectionModel().addListSelectionListener(controlador);
	}
	
	public void ocultaBotonNuevaEstancia(){
		this.btnNuevaEstancia.setVisible(false);
	}
	
	public void ocultaBotonModificarEstancia(){
		this.btnModificarEstancia.setVisible(false);
	}

	public void ocultaBotonEliminarEstancia(){
		this.btnEliminarEstancia.setVisible(false);
	}
	
	public void rellenaTablahabitaciones(ArrayList<HabitacionVO> habitaciones){
		habitaciones_model = new DefaultTableModel(habitaciones_head,0);
		Object[] fila = new Object[habitaciones_model.getColumnCount()];
		
		for (int i = 0 ; i < habitaciones.size(); i++ ){
			fila[1] = habitaciones.get(i).getNombre();
			fila[2] = habitaciones.get(i).getClasificacion();
			fila[3] = habitaciones.get(i).getPlazas();
			fila[4] = habitaciones.get(i).getPrecio();
			fila[5] = habitaciones.get(i).getDescripcion();
			habitaciones_model.addRow(fila);
		}
		tabla_habitaciones.setModel(habitaciones_model);
	}
	
	public void rellenaTablaEstancias(ArrayList<EstanciaVO> estancias){
		estancias_model = new DefaultTableModel(estancias_head,0);
		Object[] fila = new Object[estancias_model.getColumnCount()];
		
		for (int i = 0 ; i < estancias.size(); i++ ){
			fila[0] = estancias.get(i).getNombre();
			estancias_model.addRow(fila);
		}
		tabla_estancias.setModel(estancias_model);
	}

	public JTable getTabla_habitaciones() {
		return tabla_habitaciones;
	}

	public JTable getTabla_estancias() {
		return tabla_estancias;
	}
	
}
