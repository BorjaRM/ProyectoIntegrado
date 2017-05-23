package vista;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ListSelectionModel;

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
		
		//Creamos un modelo para la lista *******************SUSTITUIR***********************
		DefaultListModel<String> llegadasModel = new DefaultListModel<String>();
		llegadasModel.addElement("8:00 - Alejandro Tortajada");
		llegadasModel.addElement("10:00 - Andrea Gimeno");
		llegadasModel.addElement("15:00 - Alejandro Tortajada");
		llegadasModel.addElement("16:30 - Andrea Gimeno");		
		listaLLegadas.setModel(llegadasModel);
		
		//Creamos la lista de salidas
		JScrollPane scrollSalidas = new JScrollPane();
		listaSalidas = new JList<String>();		
		listaSalidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollSalidas.setViewportView(listaSalidas);
		llegas_y_salidas.add(scrollSalidas);
		
		//Creamos un modelo para la lista *******************SUSTITUIR***********************
		DefaultListModel<String> salidasModel = new DefaultListModel<String>();
		salidasModel.addElement("10:00 - Alejandro Tortajada");
		salidasModel.addElement("10:00 - Alejandro Tortajada");
		salidasModel.addElement("10:00 - Alejandro Tortajada");
		listaSalidas.setModel(salidasModel);

		//Creamos el segundo splitPane
		JSplitPane habitaciones_e_incidencias = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		//Creamos la lista de habitaciones
		JScrollPane scrollHabitaciones = new JScrollPane();
		listaHabitaciones = new JList<String>();		
		listaHabitaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollHabitaciones.setViewportView(listaHabitaciones);
		habitaciones_e_incidencias.add(scrollHabitaciones);
		
		//Creamos un modelo para la lista *******************SUSTITUIR***********************
		DefaultListModel<String> habitacionesModel = new DefaultListModel<String>();
		habitacionesModel.addElement("Habitacion libre 1");
		habitacionesModel.addElement("Habitacion libre 2");
		habitacionesModel.addElement("Habitacion libre 3");
		listaHabitaciones.setModel(habitacionesModel);

		//Creamos la lista de incidencias
		JScrollPane scrollIncidencias = new JScrollPane();
		listaIncidencias = new JList<String>();
		listaIncidencias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollIncidencias.setViewportView(listaIncidencias);
		habitaciones_e_incidencias.add(scrollIncidencias);
		
		//Creamos un modelo para la lista *******************SUSTITUIR***********************
		DefaultListModel<String> incidenciasModel = new DefaultListModel<String>();
		incidenciasModel.addElement("incidencia 1");
		incidenciasModel.addElement("incidencia 2");
		incidenciasModel.addElement("incidencia 3");
		listaIncidencias.setModel(incidenciasModel);
		setLayout(new BorderLayout(0, 0));
		
		//Creamos un tercer SplitPane que contiene al uno y al dos
		JSplitPane splitPane_10 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,llegas_y_salidas,habitaciones_e_incidencias);
		add(splitPane_10);
		
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
		if(!llegadas.isEmpty()){
			//Creamos un modelo por defecto
			DefaultListModel listModel = new DefaultListModel();
			//Añadimos los datos
			listModel.addElement("Llegadas hoy:");
			for(String llegada: llegadas){
				listModel.addElement(llegada);
			}
			//Añadimos el modelo por defecto a la lista
			listaLLegadas.setModel(listModel);
		}
	}
	
	public void rellenaListaSalidas(ArrayList<String> salidas){
		if(!salidas.isEmpty()){
			//Creamos un modelo por defecto
			DefaultListModel listModel = new DefaultListModel();
			//Añadimos los datos
			listModel.addElement("Salidas hoy:");
			for(String salida: salidas){
				listModel.addElement(salida);
			}
			//Añadimos el modelo por defecto a la lista
			listaSalidas.setModel(listModel);
		}
	}
	
	public void rellenaListaIncidencias(ArrayList<String> incidencias){
		if(!incidencias.isEmpty()){
			//Creamos un modelo por defecto
			DefaultListModel listModel = new DefaultListModel();
			//Añadimos los datos
			listModel.addElement("Incidencias activas:");
			for(String incidencia: incidencias){
				listModel.addElement(incidencia);
			}
			//Añadimos el modelo por defecto a la lista
			listaIncidencias.setModel(listModel);
		}
	}

}
