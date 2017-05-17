package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import java.awt.BorderLayout;

public class PrincipalEmpleadoView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PrincipalEmpleadoView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 94, 0, 0, 0, 0, 104, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 64, 0, 0, 67, 47, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblLlegadasHoy = new JLabel("LLegadas hoy:");
		GridBagConstraints gbc_lblLlegadasHoy = new GridBagConstraints();
		gbc_lblLlegadasHoy.insets = new Insets(0, 0, 5, 5);
		gbc_lblLlegadasHoy.gridx = 2;
		gbc_lblLlegadasHoy.gridy = 1;
		add(lblLlegadasHoy, gbc_lblLlegadasHoy);
		
		JLabel lblSalidasHoy = new JLabel("Salidas hoy:");
		GridBagConstraints gbc_lblSalidasHoy = new GridBagConstraints();
		gbc_lblSalidasHoy.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalidasHoy.gridx = 6;
		gbc_lblSalidasHoy.gridy = 1;
		add(lblSalidasHoy, gbc_lblSalidasHoy);
		
		JList list_Llegadas = new JList();
		GridBagConstraints gbc_list_Llegadas = new GridBagConstraints();
		gbc_list_Llegadas.insets = new Insets(0, 0, 5, 5);
		gbc_list_Llegadas.fill = GridBagConstraints.BOTH;
		gbc_list_Llegadas.gridx = 2;
		gbc_list_Llegadas.gridy = 2;
		add(list_Llegadas, gbc_list_Llegadas);
		
		JList list_Salidas = new JList();
		GridBagConstraints gbc_list_Salidas = new GridBagConstraints();
		gbc_list_Salidas.insets = new Insets(0, 0, 5, 5);
		gbc_list_Salidas.fill = GridBagConstraints.BOTH;
		gbc_list_Salidas.gridx = 6;
		gbc_list_Salidas.gridy = 2;
		add(list_Salidas, gbc_list_Salidas);
		
		JLabel lblIncidenciasActivas = new JLabel("Incidencias activas:");
		GridBagConstraints gbc_lblIncidenciasActivas = new GridBagConstraints();
		gbc_lblIncidenciasActivas.insets = new Insets(0, 0, 5, 5);
		gbc_lblIncidenciasActivas.gridx = 2;
		gbc_lblIncidenciasActivas.gridy = 4;
		add(lblIncidenciasActivas, gbc_lblIncidenciasActivas);
		
		JLabel lblHabitacionesDisponibles = new JLabel("Habitaciones disponibles:");
		GridBagConstraints gbc_lblHabitacionesDisponibles = new GridBagConstraints();
		gbc_lblHabitacionesDisponibles.insets = new Insets(0, 0, 5, 5);
		gbc_lblHabitacionesDisponibles.gridx = 6;
		gbc_lblHabitacionesDisponibles.gridy = 4;
		add(lblHabitacionesDisponibles, gbc_lblHabitacionesDisponibles);
		
		JList list_Incidencias = new JList();
		GridBagConstraints gbc_list_Incidencias = new GridBagConstraints();
		gbc_list_Incidencias.insets = new Insets(0, 0, 5, 5);
		gbc_list_Incidencias.fill = GridBagConstraints.BOTH;
		gbc_list_Incidencias.gridx = 2;
		gbc_list_Incidencias.gridy = 5;
		add(list_Incidencias, gbc_list_Incidencias);
		
		JList list_Habitaciones = new JList();
		GridBagConstraints gbc_list_Habitaciones = new GridBagConstraints();
		gbc_list_Habitaciones.insets = new Insets(0, 0, 5, 5);
		gbc_list_Habitaciones.fill = GridBagConstraints.BOTH;
		gbc_list_Habitaciones.gridx = 6;
		gbc_list_Habitaciones.gridy = 5;
		add(list_Habitaciones, gbc_list_Habitaciones);

	}

}
