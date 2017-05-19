package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEstancias;
import interfaces.IControladorEstancias;
import modelo.vo.HabitacionVO;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class EstanciasView extends JPanel implements IControladorEstancias{
	private JTable tabla_habitaciones;
	private JButton btnNuevaEstancia;
	private JButton btnModificarEstancia;
	private JButton btnEliminarEstancia;
	private JTable tabla_estancias;

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
		
		btnNuevaEstancia = new JButton("Nueva Estancia");
		botonera.add(btnNuevaEstancia);
		
		btnEliminarEstancia = new JButton("Eliminar Estancia");
		botonera.add(btnEliminarEstancia);
		
		btnModificarEstancia = new JButton("Modificar Estancia");
		botonera.add(btnModificarEstancia);
		
		JPanel panel_Tabla = new JPanel();
		add(panel_Tabla, BorderLayout.CENTER);
		
		//Creamos la tabla que contiene las habitaciones
		JScrollPane scrollPane = new JScrollPane();
		String[] habitaciones_head = {"Nombre","Tipo","Camas","Aseo","A/C","Wifi","Precio"};
		DefaultTableModel habitaciones_model = new DefaultTableModel(habitaciones_head,0);
		tabla_habitaciones = new JTable(habitaciones_model);
		scrollPane.setViewportView(tabla_habitaciones);		
		panel_Tabla.add(scrollPane);

		//Creamos la tabla que contiene el resto de estancias
		JScrollPane scrollPane_1 = new JScrollPane();
		String[] estancias_head = {"Nombre"};
		DefaultTableModel estancias_model = new DefaultTableModel(estancias_head,0);
		tabla_estancias = new JTable(estancias_model);
		scrollPane_1.setViewportView(tabla_estancias);
		panel_Tabla.add(scrollPane_1);

		JSplitPane splitPane_10 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,scrollPane,scrollPane_1);
		add(splitPane_10);
		
	}

	@Override
	public void estableceControlador(ControladorEstancias controlador) {
		this.btnNuevaEstancia.addActionListener(controlador);
		this.btnModificarEstancia.addActionListener(controlador);
		this.btnEliminarEstancia.addActionListener(controlador);
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
	
	public void rellenaTablahabitaciones(ArrayList<HabitacionVO> estancias){
		DefaultTableModel modeloTabla = (DefaultTableModel) tabla_habitaciones.getModel();
		Object[] fila = new Object[modeloTabla.getColumnCount()];
		
		for (int i = 0 ; i < estancias.size(); i++ ){
			fila[0] = estancias.get(i).getId();
			fila[1] = estancias.get(i).getNombre();
			fila[2] = estancias.get(i).getTipo();
			fila[3] = estancias.get(i).getPlazas();
			fila[4] = estancias.get(i).getPrecio();
			fila[5] = estancias.get(i).getDescripcion();
			fila[6] = estancias.get(i).getCod_reserva();
			modeloTabla.addRow(fila);
		}
		tabla_habitaciones.setModel(modeloTabla);
	}

}
