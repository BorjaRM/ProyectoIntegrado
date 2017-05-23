package vista;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import controlador.ControladorReservas;
import interfaces.IControladorReservas;
import modelo.BD;
import modelo.dao.ClienteDAO;
import modelo.dao.HabitacionDAO;
import modelo.vo.ClienteVO;
import modelo.vo.HabitacionVO;

import java.awt.BorderLayout;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NuevaReservaView extends JPanel implements IControladorReservas{
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JComboBox listaClientes;
	private JComboBox listaHabitaciones;
	private JComboBox listaPension;
	private JDateChooser dateChooserLlegada;
	private JDateChooser dateChooserSalida;
	private ClienteVO clv;

	
	/**
	 * Create the panel.
	 */
	public NuevaReservaView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel, BorderLayout.SOUTH);
		
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		
		btnEnviar = new JButton("Enviar");
		panel.add(btnEnviar);
		
		btnCancelar = new JButton("Cancelar");
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
		
		
		listaClientes = new JComboBox();
		
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
		
		listaHabitaciones = new JComboBox();
		HabitacionDAO h = new HabitacionDAO();
		
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
		
		dateChooserLlegada = new JDateChooser();
		GridBagConstraints gbc_dateChooserLlegada = new GridBagConstraints();
		gbc_dateChooserLlegada.gridwidth = 3;
		gbc_dateChooserLlegada.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserLlegada.fill = GridBagConstraints.BOTH;
		gbc_dateChooserLlegada.gridx = 3;
		gbc_dateChooserLlegada.gridy = 3;
		panel_1.add(dateChooserLlegada, gbc_dateChooserLlegada);
		dateChooserLlegada.setMinSelectableDate(new Date());
		dateChooserLlegada.setDateFormatString("yyyy-MM-dd");
		
		
		JLabel lblSalida = new JLabel("Salida");
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalida.gridx = 1;
		gbc_lblSalida.gridy = 4;
		panel_1.add(lblSalida, gbc_lblSalida);
		
		dateChooserSalida = new JDateChooser();
		GridBagConstraints gbc_dateChooserSalida = new GridBagConstraints();
		gbc_dateChooserSalida.gridwidth = 3;
		gbc_dateChooserSalida.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserSalida.fill = GridBagConstraints.BOTH;
		gbc_dateChooserSalida.gridx = 3;
		gbc_dateChooserSalida.gridy = 4;
		panel_1.add(dateChooserSalida, gbc_dateChooserSalida);
		dateChooserSalida.setMinSelectableDate(new Date());
		dateChooserSalida.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblPension = new JLabel("Pensi\u00F3n");
		GridBagConstraints gbc_lblPension = new GridBagConstraints();
		gbc_lblPension.insets = new Insets(0, 0, 5, 5);
		gbc_lblPension.gridx = 1;
		gbc_lblPension.gridy = 5;
		panel_1.add(lblPension, gbc_lblPension);
		
		String[] pension = {"Alojamiento","Desayuno","Media","Completa"};
		listaPension = new JComboBox(pension);
		GridBagConstraints gbc_listaPension = new GridBagConstraints();
		gbc_listaPension.gridwidth = 3;
		gbc_listaPension.insets = new Insets(0, 0, 5, 5);
		gbc_listaPension.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaPension.gridx = 3;
		gbc_listaPension.gridy = 5;
		panel_1.add(listaPension, gbc_listaPension);

	}

	@Override
	public void estableceControlador(ControladorReservas controlador) {
		this.btnEnviar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}

	public JComboBox getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(JComboBox listaClientes) {
		this.listaClientes = listaClientes;
	}

	public JComboBox getListaHabitaciones() {
		return listaHabitaciones;
	}

	public void setListaHabitaciones(JComboBox listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

	public JComboBox getListaPension() {
		return listaPension;
	}

	public void setListaPension(JComboBox listaPension) {
		this.listaPension = listaPension;
	}

	public JDateChooser getDateChooserLlegada() {
		return dateChooserLlegada;
	}

	public void setDateChooserLlegada(JDateChooser dateChooserLlegada) {
		this.dateChooserLlegada = dateChooserLlegada;
	}

	public JDateChooser getDateChooserSalida() {
		return dateChooserSalida;
	}

	public void setDateChooserSalida(JDateChooser dateChooserSalida) {
		this.dateChooserSalida = dateChooserSalida;
	}

	public void llenaComboBoxClientes(ArrayList<ClienteVO> clientes) {
		for(int i=0;i<clientes.size();i++){
			listaClientes.addItem(clientes.get(i).getNombre()+" "+clientes.get(i).getApellidos());
		}
		
	}

	public void llenaComboBoxHabitaciones(ArrayList<HabitacionVO> habitaciones) {
		for(int i=0;i<habitaciones.size();i++){
			listaHabitaciones.addItem(habitaciones.get(i).getNombre());
		}
	}
}