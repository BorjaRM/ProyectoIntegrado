package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import controlador.ControladorEstancias;
import interfaces.IControladorEstancias;
import modelo.vo.EstanciaVO;
import modelo.vo.HabitacionVO;
import modelo.vo.TipoEstancia;
import modelo.vo.TipoHabitacion;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;

public class NuevaEstanciaView extends JPanel implements IControladorEstancias{
	private JTextField txt_Nombre;
	private JTextField txt_nombre_uso;
	private JButton btn_NewHabitacion;
	private JButton btnAadirEstancia;
	private JButton btn_Cancelar;
	private JComboBox<TipoHabitacion> desplegableTipoHab;
	private JSpinner spinner_precio;
	private JSpinner spinner_plazas;
	private JTextArea text_descripcion;

	/**
	 * Create the panel.
	 */
	public NuevaEstanciaView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Textos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_Textos.getLayout();
		add(panel_Textos, BorderLayout.NORTH);
		
		JLabel lblHabitacin = new JLabel("Habitacion");
		lblHabitacin.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblHabitacin);
		
		Component horizontalStrut = Box.createHorizontalStrut(400);
		panel_Textos.add(horizontalStrut);
		
		JLabel lblUsoComn = new JLabel("Uso Comun");
		lblUsoComn.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblUsoComn);
		
		JPanel panel_Botones = new JPanel();
		add(panel_Botones, BorderLayout.SOUTH);
		panel_Botones.setLayout(new BoxLayout(panel_Botones, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_Botones.add(horizontalGlue);
		
		btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.setActionCommand("Cancelar");
		panel_Botones.add(btn_Cancelar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 15, 0));
		
		JPanel panel_Habitacion = new JPanel();
		panel.add(panel_Habitacion);
		panel_Habitacion.setLayout(new BoxLayout(panel_Habitacion, BoxLayout.Y_AXIS));
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel_Habitacion.add(lblNombre);
		
		txt_Nombre = new JTextField();
		panel_Habitacion.add(txt_Nombre);
		txt_Nombre.setColumns(5);
		
		JLabel lblTipo = new JLabel("Tipo:");
		panel_Habitacion.add(lblTipo);
		
		desplegableTipoHab = new JComboBox<TipoHabitacion>();
		rellenaDesplegableTipoHabitacion();
		panel_Habitacion.add(desplegableTipoHab);
		
		JLabel lblPlazas = new JLabel("Plazas:");
		panel_Habitacion.add(lblPlazas);
		
		spinner_plazas = new JSpinner();
		spinner_plazas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		panel_Habitacion.add(spinner_plazas);
		
		JLabel lblPrecio = new JLabel("Precio:");
		panel_Habitacion.add(lblPrecio);
		
		spinner_precio = new JSpinner();
		spinner_precio.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel_Habitacion.add(spinner_precio);
		
		JLabel lblDescripcin = new JLabel("Descripcion:");
		panel_Habitacion.add(lblDescripcin);
		
		text_descripcion = new JTextArea();
		text_descripcion.setRows(10);
		text_descripcion.setLineWrap(true);
		//panel_Habitacion.add(text_descripcion);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(text_descripcion);
		panel_Habitacion.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_Habitacion.add(panel_2);
		
		btn_NewHabitacion = new JButton("Nueva Habitacion");
		btn_NewHabitacion.setActionCommand("Nueva habitacion");
		panel_2.add(btn_NewHabitacion);
		
		JPanel panel_Servicios = new JPanel();
		panel.add(panel_Servicios);
		panel_Servicios.setLayout(new BorderLayout(0, 0));
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblServicios.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Servicios.add(lblServicios, BorderLayout.NORTH);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		panel_Servicios.add(separator, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_Servicios.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JRadioButton rdbtnBaoPrivado = new JRadioButton("Aseo Privado");
		panel_1.add(rdbtnBaoPrivado);
		
		JRadioButton rdbtnAc = new JRadioButton("A/C            ");
		panel_1.add(rdbtnAc);
		
		JRadioButton rdbtnWifi = new JRadioButton("Wifi             ");
		panel_1.add(rdbtnWifi);
		
		JRadioButton rdbtnTv = new JRadioButton(" TV             ");
		panel_1.add(rdbtnTv);
		
		JPanel panel_UsoComun = new JPanel();
		panel.add(panel_UsoComun);
		panel_UsoComun.setLayout(new BoxLayout(panel_UsoComun, BoxLayout.Y_AXIS));
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		panel_UsoComun.add(lblNombre_1);
		
		txt_nombre_uso = new JTextField();
		panel_UsoComun.add(txt_nombre_uso);
		txt_nombre_uso.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_UsoComun.add(verticalStrut);
		
		btnAadirEstancia = new JButton("Nueva zona comun");
		btnAadirEstancia.setActionCommand("Nueva zona comun");
		panel_UsoComun.add(btnAadirEstancia);
		
		Component verticalStrut_1 = Box.createVerticalStrut(280);
		panel_UsoComun.add(verticalStrut_1);
	}

	@Override
	public void estableceControlador(ControladorEstancias controlador) {
		this.btn_NewHabitacion.addActionListener(controlador);
		this.btnAadirEstancia.addActionListener(controlador);
		this.btn_Cancelar.addActionListener(controlador);
	}
	
	public void rellenaDesplegableTipoHabitacion(){
		desplegableTipoHab.removeAllItems();
		for(TipoHabitacion tipo: TipoHabitacion.values()){
			this.desplegableTipoHab.addItem(tipo);
		}
	}
	
	public HabitacionVO enviarDatosHabitacion(){
		String nombre = this.txt_Nombre.getText().toUpperCase();
		String tipo = TipoEstancia.HABITACION.name();
		String clasificacion = this.desplegableTipoHab.getSelectedItem().toString();
		int plazas = (Integer) spinner_plazas.getValue();
		int precio = (Integer) spinner_precio.getValue();
		String desc = this.text_descripcion.getText();
		HabitacionVO habitacion = new HabitacionVO(0, 0,nombre,tipo,clasificacion,plazas,precio,desc);
		return habitacion;
	}
	
	public EstanciaVO enviarDatosUsoComun(){
		String nombre = this.txt_nombre_uso.getText();
		String tipo = TipoEstancia.USO_COMUN.name();
		EstanciaVO estancia = new EstanciaVO(0, 0, nombre, tipo);
		return estancia;
	}

}
