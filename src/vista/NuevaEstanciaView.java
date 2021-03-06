package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

import controlador.ControladorEstancias;
import idiomas.Idiomas;
import interfaces.IControladorEstancias;
import modelo.vo.EstanciaVO;
import modelo.vo.HabitacionVO;
import modelo.vo.TipoEstancia;
import modelo.vo.TipoHabitacion;

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
	ResourceBundle bundle;

	/**
	 * Create the panel.
	 */
	public NuevaEstanciaView() {
		bundle = Idiomas.getBundle();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Textos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_Textos.getLayout();
		add(panel_Textos, BorderLayout.NORTH);
		
		JLabel lblHabitacin = new JLabel(bundle.getString("jLblRegEstanTit1"));
		lblHabitacin.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblHabitacin);
		
		Component horizontalStrut = Box.createHorizontalStrut(400);
		panel_Textos.add(horizontalStrut);
		
		JLabel lblUsoComn = new JLabel(bundle.getString("jLblRegEstanTit2"));
		lblUsoComn.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblUsoComn);
		
		JPanel panel_Botones = new JPanel();
		add(panel_Botones, BorderLayout.SOUTH);
		panel_Botones.setLayout(new BoxLayout(panel_Botones, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_Botones.add(horizontalGlue);
		
		btn_Cancelar = new JButton(bundle.getString("btnRegEstanCancel"));
		btn_Cancelar.setActionCommand("Cancelar");
		panel_Botones.add(btn_Cancelar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel panel_Habitacion = new JPanel();
		panel.add(panel_Habitacion);
		panel_Habitacion.setLayout(new BoxLayout(panel_Habitacion, BoxLayout.Y_AXIS));
		
		JLabel lblNombre = new JLabel(bundle.getString("jLblRegEstanNom"));
		panel_Habitacion.add(lblNombre);
		
		txt_Nombre = new JTextField();
		panel_Habitacion.add(txt_Nombre);
		txt_Nombre.setColumns(5);
		
		JLabel lblTipo = new JLabel(bundle.getString("jLblRegEstanTipo"));
		panel_Habitacion.add(lblTipo);
		
		desplegableTipoHab = new JComboBox<TipoHabitacion>();
		rellenaDesplegableTipoHabitacion();
		panel_Habitacion.add(desplegableTipoHab);
		
		JLabel lblPlazas = new JLabel(bundle.getString("jLblRegEstanPlazas"));
		panel_Habitacion.add(lblPlazas);
		
		spinner_plazas = new JSpinner();
		spinner_plazas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		panel_Habitacion.add(spinner_plazas);
		
		JLabel lblPrecio = new JLabel(bundle.getString("jLblRegEstanPrecio"));
		panel_Habitacion.add(lblPrecio);
		
		spinner_precio = new JSpinner();
		spinner_precio.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel_Habitacion.add(spinner_precio);
		
		JLabel lblDescripcin = new JLabel(bundle.getString("jLblRegEstanDescrp"));
		panel_Habitacion.add(lblDescripcin);
		
		text_descripcion = new JTextArea();
		text_descripcion.setRows(10);
		text_descripcion.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(text_descripcion);
		panel_Habitacion.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_Habitacion.add(panel_2);
		
		btn_NewHabitacion = new JButton(bundle.getString("btnRegEstanAddHabi"));
		btn_NewHabitacion.setActionCommand("Nueva habitacion");
		panel_2.add(btn_NewHabitacion);
		
		JPanel panel_UsoComun = new JPanel();
		panel.add(panel_UsoComun);
		panel_UsoComun.setLayout(new BoxLayout(panel_UsoComun, BoxLayout.Y_AXIS));
		
		JLabel lblNombre_1 = new JLabel(bundle.getString("jLblRegEstanTit1"));
		panel_UsoComun.add(lblNombre_1);
		
		txt_nombre_uso = new JTextField();
		panel_UsoComun.add(txt_nombre_uso);
		txt_nombre_uso.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_UsoComun.add(verticalStrut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentX(0.0f);
		panel_UsoComun.add(panel_1);
		
		btnAadirEstancia = new JButton(bundle.getString("jLblRegEstanZonCom"));
		panel_1.add(btnAadirEstancia);
		btnAadirEstancia.setActionCommand("Nueva zona comun");
		
		Component verticalStrut_1 = Box.createVerticalStrut(270);
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

	public JTextField getTxt_Nombre() {
		return txt_Nombre;
	}

	public JTextField getTxt_nombre_uso() {
		return txt_nombre_uso;
	}

	public JComboBox<TipoHabitacion> getDesplegableTipoHab() {
		return desplegableTipoHab;
	}

	public JSpinner getSpinner_precio() {
		return spinner_precio;
	}

	public JSpinner getSpinner_plazas() {
		return spinner_plazas;
	}

	public JTextArea getText_descripcion() {
		return text_descripcion;
	}

}
