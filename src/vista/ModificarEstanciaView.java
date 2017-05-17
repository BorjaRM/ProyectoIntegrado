package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.Font;

public class ModificarEstanciaView extends JPanel {
	private JTextField txt_Nombre;
	private JTextField txt_Tipo;
	private JTextField txt_Plazas;
	private JTextField txt_Precio;
	private JTextField txt_Descripcion;
	private JTextField txt_nombre_uso;

	/**
	 * Create the panel.
	 */
	public ModificarEstanciaView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Textos = new JPanel();
		add(panel_Textos, BorderLayout.NORTH);
		
		JLabel lblHabitacin = new JLabel("Habitación");
		lblHabitacin.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblHabitacin);
		
		Component horizontalStrut = Box.createHorizontalStrut(150);
		panel_Textos.add(horizontalStrut);
		
		JLabel lblUsoComn = new JLabel("Uso Común");
		lblUsoComn.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		panel_Textos.add(lblUsoComn);
		
		JPanel panel_Botones = new JPanel();
		add(panel_Botones, BorderLayout.SOUTH);
		
		JButton btn_NewHabitacion = new JButton("Añadir Habitacion");
		panel_Botones.add(btn_NewHabitacion);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		panel_Botones.add(horizontalStrut_1);
		
		JButton btnModificar = new JButton("Modificar");
		panel_Botones.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_Botones.add(btnCancelar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_Habitacion = new JPanel();
		panel.add(panel_Habitacion);
		panel_Habitacion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel_Habitacion.add(lblNombre);
		
		txt_Nombre = new JTextField();
		panel_Habitacion.add(txt_Nombre);
		txt_Nombre.setColumns(5);
		
		JLabel lblTipo = new JLabel("Tipo:");
		panel_Habitacion.add(lblTipo);
		
		txt_Tipo = new JTextField();
		panel_Habitacion.add(txt_Tipo);
		txt_Tipo.setColumns(5);
		
		JLabel lblPlazas = new JLabel("Plazas:");
		panel_Habitacion.add(lblPlazas);
		
		txt_Plazas = new JTextField();
		panel_Habitacion.add(txt_Plazas);
		txt_Plazas.setColumns(5);
		
		JLabel lblPrecio = new JLabel("Precio:");
		panel_Habitacion.add(lblPrecio);
		
		txt_Precio = new JTextField();
		panel_Habitacion.add(txt_Precio);
		txt_Precio.setColumns(5);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		panel_Habitacion.add(lblDescripcin);
		
		txt_Descripcion = new JTextField();
		panel_Habitacion.add(txt_Descripcion);
		txt_Descripcion.setColumns(10);
		
		JPanel panel_Servicios = new JPanel();
		panel.add(panel_Servicios);
		panel_Servicios.setLayout(new BorderLayout(0, 0));
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblServicios.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Servicios.add(lblServicios, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_Servicios.add(panel_1, BorderLayout.CENTER);
		
		JRadioButton rdbtnBaoPrivado = new JRadioButton("Baño Privado");
		panel_1.add(rdbtnBaoPrivado);
		
		JRadioButton rdbtnAc = new JRadioButton("A/C            ");
		panel_1.add(rdbtnAc);
		
		JRadioButton rdbtnWifi = new JRadioButton("Wifi             ");
		panel_1.add(rdbtnWifi);
		
		JRadioButton rdbtnTv = new JRadioButton(" TV             ");
		panel_1.add(rdbtnTv);
		
		JPanel panel_UsoComun = new JPanel();
		panel.add(panel_UsoComun);
		panel_UsoComun.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(100);
		panel_UsoComun.add(horizontalStrut_2);
		
		Component verticalStrut = Box.createVerticalStrut(70);
		panel_UsoComun.add(verticalStrut);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		panel_UsoComun.add(lblNombre_1);
		
		txt_nombre_uso = new JTextField();
		panel_UsoComun.add(txt_nombre_uso);
		txt_nombre_uso.setColumns(10);

	}

}
