package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import modelo.vo.HabitacionVO;

public class PrincipalEmpleadoView extends JPanel {
	private JList<String> listaLLegadas;
	private JList<String> listaSalidas;
	private JList<String> listaHabitaciones;
	private JList<String> listaIncidencias;

	/**
	 * Create the panel.
	 */
	public PrincipalEmpleadoView() {
				
		//Creamos el primer splitPane
		JSplitPane llegas_y_salidas = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		//Creamos la lista de llegadas
		JScrollPane scrollLLegadas = new JScrollPane();
		listaLLegadas = new JList<String>();		
		listaLLegadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLLegadas.setViewportView(listaLLegadas);
		llegas_y_salidas.add(scrollLLegadas);
		
		//Creamos la lista de salidas
		JScrollPane scrollSalidas = new JScrollPane();
		listaSalidas = new JList<String>();		
		listaSalidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollSalidas.setViewportView(listaSalidas);
		llegas_y_salidas.add(scrollSalidas);

		//Creamos el segundo splitPane
		JSplitPane habitaciones_e_incidencias = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		//Creamos la lista de habitaciones
		JScrollPane scrollHabitaciones = new JScrollPane();
		listaHabitaciones = new JList<String>();		
		listaHabitaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollHabitaciones.setViewportView(listaHabitaciones);
		habitaciones_e_incidencias.add(scrollHabitaciones);

		//Creamos la lista de incidencias
		JScrollPane scrollIncidencias = new JScrollPane();
		listaIncidencias = new JList<String>();
		listaIncidencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollIncidencias.setViewportView(listaIncidencias);
		habitaciones_e_incidencias.add(scrollIncidencias);

		setLayout(new BorderLayout(0, 0));
		
		//Creamos un tercer SplitPane que contiene al uno y al dos
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,llegas_y_salidas,habitaciones_e_incidencias);
		add(splitPane);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1, BorderLayout.EAST);

	}
	
	public void rellenaListaLlegadas(ArrayList<String> llegadas){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Llegadas hoy:");
		if(!llegadas.isEmpty()){
			for(String llegada: llegadas){
				listModel.addElement(llegada);
			}
		}else
			listModel.addElement("no hay llegadas previstas para hoy");
		listaLLegadas.setModel(listModel);
	}
	
	public void rellenaListaSalidas(ArrayList<String> salidas){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Salidas hoy:");
		if(!salidas.isEmpty()){
			for(String salida: salidas){
				listModel.addElement(salida);
			}
		}else
			listModel.addElement("no hay salidas previstas para hoy");
		listaSalidas.setModel(listModel);
	}
	
	public void rellenaListaIncidencias(ArrayList<String> incidencias){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Incidencias activas:");
		if(!incidencias.isEmpty()){
			for(String incidencia: incidencias){
				listModel.addElement(incidencia);
			}
		}else
			listModel.addElement("no hay incidencias activas");
		listaIncidencias.setModel(listModel);
	}
	
	public void rellenaListaHabitacionesLibres(ArrayList<HabitacionVO> habitaciones){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Habitaciones disponibles:");
		if(!habitaciones.isEmpty()){
			for(HabitacionVO h: habitaciones){
				listModel.addElement(h.getNombre()+" - "+h.getClasificacion()+", "+h.getPlazas()+" plazas, "+h.getPrecio()+"€, "+h.getDescripcion());
			}
		}else
			listModel.addElement("no hay habitaciones disponibles");
		listaHabitaciones.setModel(listModel);
	}

}
