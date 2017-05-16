package vista;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JTextField;

public class NuevaReserva extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public NuevaReserva() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel, BorderLayout.SOUTH);
		
		JButton btnEnviar = new JButton("Enviar");
		panel.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 102, 125, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 1;
		panel_1.add(lblCliente, gbc_lblCliente);
		
		JComboBox listaClientes = new JComboBox();
		GridBagConstraints gbc_listaClientes = new GridBagConstraints();
		gbc_listaClientes.gridwidth = 3;
		gbc_listaClientes.insets = new Insets(0, 0, 5, 5);
		gbc_listaClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaClientes.gridx = 3;
		gbc_listaClientes.gridy = 1;
		panel_1.add(listaClientes, gbc_listaClientes);
		
		JLabel lblHabitacion = new JLabel("Habitaci\u00F3n");
		GridBagConstraints gbc_lblHabitacion = new GridBagConstraints();
		gbc_lblHabitacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblHabitacion.gridx = 1;
		gbc_lblHabitacion.gridy = 2;
		panel_1.add(lblHabitacion, gbc_lblHabitacion);
		
		JComboBox listaHabitaciones = new JComboBox();
		GridBagConstraints gbc_listaHabitaciones = new GridBagConstraints();
		gbc_listaHabitaciones.gridwidth = 3;
		gbc_listaHabitaciones.insets = new Insets(0, 0, 5, 5);
		gbc_listaHabitaciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaHabitaciones.gridx = 3;
		gbc_listaHabitaciones.gridy = 2;
		panel_1.add(listaHabitaciones, gbc_listaHabitaciones);
		
		JLabel lblLlegada = new JLabel("Llegada");
		GridBagConstraints gbc_lblLlegada = new GridBagConstraints();
		gbc_lblLlegada.insets = new Insets(0, 0, 5, 5);
		gbc_lblLlegada.gridx = 1;
		gbc_lblLlegada.gridy = 3;
		panel_1.add(lblLlegada, gbc_lblLlegada);
		
		JDateChooser dateChooserLlegada = new JDateChooser();
		GridBagConstraints gbc_dateChooserLlegada = new GridBagConstraints();
		gbc_dateChooserLlegada.gridwidth = 3;
		gbc_dateChooserLlegada.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserLlegada.fill = GridBagConstraints.BOTH;
		gbc_dateChooserLlegada.gridx = 3;
		gbc_dateChooserLlegada.gridy = 3;
		panel_1.add(dateChooserLlegada, gbc_dateChooserLlegada);
		dateChooserLlegada.setMinSelectableDate(new Date());
		
		
		JLabel lblSalida = new JLabel("Salida");
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalida.gridx = 1;
		gbc_lblSalida.gridy = 4;
		panel_1.add(lblSalida, gbc_lblSalida);
		
		JDateChooser dateChooserSalida = new JDateChooser();
		GridBagConstraints gbc_dateChooserSalida = new GridBagConstraints();
		gbc_dateChooserSalida.gridwidth = 3;
		gbc_dateChooserSalida.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserSalida.fill = GridBagConstraints.BOTH;
		gbc_dateChooserSalida.gridx = 3;
		gbc_dateChooserSalida.gridy = 4;
		panel_1.add(dateChooserSalida, gbc_dateChooserSalida);
		dateChooserSalida.setMinSelectableDate(new Date());
		
		
		JLabel lblPension = new JLabel("Pensi\u00F3n");
		GridBagConstraints gbc_lblPension = new GridBagConstraints();
		gbc_lblPension.insets = new Insets(0, 0, 5, 5);
		gbc_lblPension.gridx = 1;
		gbc_lblPension.gridy = 5;
		panel_1.add(lblPension, gbc_lblPension);
		
		JComboBox listaPension = new JComboBox();
		GridBagConstraints gbc_listaPension = new GridBagConstraints();
		gbc_listaPension.gridwidth = 3;
		gbc_listaPension.insets = new Insets(0, 0, 5, 5);
		gbc_listaPension.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaPension.gridx = 3;
		gbc_listaPension.gridy = 5;
		panel_1.add(listaPension, gbc_listaPension);

	}

}
