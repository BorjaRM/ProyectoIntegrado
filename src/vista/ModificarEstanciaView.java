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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import controlador.ControladorEstancias;
import idiomas.Idiomas;
import interfaces.IControladorEstancias;
import modelo.vo.TipoHabitacion;

public class ModificarEstanciaView extends JPanel implements IControladorEstancias{
	private JTextField txt_Nombre;
	private JTextField txt_Descripcion;
	private JTextField txt_nombre_uso;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JSpinner spinner_plazas;
	private JSpinner spinner_precio;
	private JTextArea text_descripcion;
	private JComboBox<TipoHabitacion> desplegable_tipo;
	ResourceBundle bundle;
	/**
	 * Create the panel.
	 */
	public ModificarEstanciaView() {
		bundle = Idiomas.getBundle();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Textos = new JPanel();
		add(panel_Textos, BorderLayout.NORTH);
		
		JLabel lblHabitacion = new JLabel(bundle.getString("jLblModEstanTit1"));
		lblHabitacion.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblHabitacion);
		
		Component horizontalStrut = Box.createHorizontalStrut(150);
		panel_Textos.add(horizontalStrut);
		
		JLabel lblUsoComn = new JLabel(bundle.getString("jLblModEstanTit2"));
		lblUsoComn.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblUsoComn);
		
		JPanel panel_Botones = new JPanel();
		add(panel_Botones, BorderLayout.SOUTH);
		
		btnModificar = new JButton(bundle.getString("btnModEstanEnviar"));
		panel_Botones.add(btnModificar);
		
		btnCancelar = new JButton(bundle.getString("btnModEstanCancel"));
		panel_Botones.add(btnCancelar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 3, 20, 0));
		
		JPanel panel_Habitacion = new JPanel();
		panel.add(panel_Habitacion);
		panel_Habitacion.setLayout(new BoxLayout(panel_Habitacion, BoxLayout.Y_AXIS));
		
		JLabel lblNombre = new JLabel(bundle.getString("jLblModEstanNom"));
		panel_Habitacion.add(lblNombre);
		
		txt_Nombre = new JTextField();
		panel_Habitacion.add(txt_Nombre);
		txt_Nombre.setColumns(5);
		
		JLabel lblTipo = new JLabel(bundle.getString("jLblModEstanTipo"));
		panel_Habitacion.add(lblTipo);
		
		desplegable_tipo = new JComboBox<TipoHabitacion>();
		rellenaDesplegableTipoHabitacion();
		panel_Habitacion.add(desplegable_tipo);
		
		JLabel lblPlazas = new JLabel(bundle.getString("jLblModEstanPlazas"));
		panel_Habitacion.add(lblPlazas);
		
		spinner_plazas = new JSpinner();
		spinner_plazas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		panel_Habitacion.add(spinner_plazas);
		
		JLabel lblPrecio = new JLabel(bundle.getString("jLblModEstanPrecio"));
		panel_Habitacion.add(lblPrecio);
		
		spinner_precio = new JSpinner();
		spinner_precio.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel_Habitacion.add(spinner_precio);
		
		JLabel lblDescripcin = new JLabel(bundle.getString("jLblModEstanDescrp"));
		panel_Habitacion.add(lblDescripcin);
		
		text_descripcion = new JTextArea();
		text_descripcion.setRows(10);
		text_descripcion.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportView(text_descripcion);
		panel_Habitacion.add(scrollPane);
		
		JPanel panel_UsoComun = new JPanel();
		panel.add(panel_UsoComun);
		panel_UsoComun.setLayout(new BoxLayout(panel_UsoComun, BoxLayout.Y_AXIS));
		
		JLabel lblNombre_1 = new JLabel(bundle.getString("jLblModEstanNom"));
		panel_UsoComun.add(lblNombre_1);
		
		txt_nombre_uso = new JTextField();
		panel_UsoComun.add(txt_nombre_uso);
		txt_nombre_uso.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(210);
		panel_UsoComun.add(verticalStrut);
	}

	@Override
	public void estableceControlador(ControladorEstancias controlador) {
		this.btnModificar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}
	
	public void rellenaDesplegableTipoHabitacion(){
		desplegable_tipo.removeAllItems();
		for(TipoHabitacion tipo: TipoHabitacion.values()){
			this.desplegable_tipo.addItem(tipo);
		}
	}

	public JTextField getTxt_Nombre() {
		return txt_Nombre;
	}

	public void setTxt_Nombre(JTextField txt_Nombre) {
		this.txt_Nombre = txt_Nombre;
	}

	public JTextField getTxt_Descripcion() {
		return txt_Descripcion;
	}

	public void setTxt_Descripcion(JTextField txt_Descripcion) {
		this.txt_Descripcion = txt_Descripcion;
	}

	public JTextField getTxt_nombre_uso() {
		return txt_nombre_uso;
	}

	public void setTxt_nombre_uso(JTextField txt_nombre_uso) {
		this.txt_nombre_uso = txt_nombre_uso;
	}

	public JSpinner getSpinner_plazas() {
		return spinner_plazas;
	}

	public void setSpinner_plazas(JSpinner spinner_plazas) {
		this.spinner_plazas = spinner_plazas;
	}

	public JSpinner getSpinner_precio() {
		return spinner_precio;
	}

	public void setSpinner_precio(JSpinner spinner_precio) {
		this.spinner_precio = spinner_precio;
	}

	public JTextArea getText_descripcion() {
		return text_descripcion;
	}

	public void setText_descripcion(JTextArea text_descripcion) {
		this.text_descripcion = text_descripcion;
	}

	public JComboBox<TipoHabitacion> getDesplegable_tipo() {
		return desplegable_tipo;
	}

	public void setDesplegable_tipo(JComboBox<TipoHabitacion> desplegable_tipo) {
		this.desplegable_tipo = desplegable_tipo;
	}
	
}
