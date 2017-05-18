package vista;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import controlador.ControladorEmpleados;
import interfaces.IControladorEmpleados;

public class ModificarEmpleadoView extends JPanel implements IControladorEmpleados{
	private JTextField textField;
	private JTextField txtUsuario;
	private JTextField txtHotel;
	private JTextField txtInicio;
	private JTextField txtTlf;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JPasswordField txtPass;

	/**
	 * Create the panel.
	 */
	public ModificarEmpleadoView() {
setLayout(new BorderLayout(0, 0));
		
		JPanel formulario = new JPanel();
		add(formulario, BorderLayout.CENTER);
		formulario.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		formulario.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel_3.add(lblNombre);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_2);
		
		txtNombre = new JTextField();
		panel_3.add(txtNombre);
		txtNombre.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_2);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		panel_4.add(lblApellidos);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_3);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		panel_4.add(txtApellidos);
		
		Component verticalStrut_3 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_3);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel1 = new JLabel("Identificacion:");
		panel_5.add(lblNewLabel1);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_4);
		
		txtId = new JTextField();
		panel_5.add(txtId);
		txtId.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_4);
		
		JPanel panel6 = new JPanel();
		panel_2.add(panel6);
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
		
		JLabel label1 = new JLabel("Telefono:");
		panel6.add(label1);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel6.add(horizontalStrut_5);
		
		txtTlf = new JTextField();
		panel6.add(txtTlf);
		txtTlf.setColumns(10);
		
		Component verticalStrut_5 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_5);
		
		JPanel panel7 = new JPanel();
		panel_2.add(panel7);
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));
		
		JLabel label2 = new JLabel("Inicio contrato:");
		panel7.add(label2);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel7.add(horizontalStrut_6);
		
		txtInicio = new JTextField();
		panel7.add(txtInicio);
		txtInicio.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_6);
		
		JPanel panel8 = new JPanel();
		panel_2.add(panel8);
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.X_AXIS));
		
		JLabel label3 = new JLabel("Hotel:");
		panel8.add(label3);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel8.add(horizontalStrut_9);
		
		txtHotel = new JTextField();
		panel8.add(txtHotel);
		txtHotel.setColumns(10);
		
		Component verticalStrut_7 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_7);
		
		JPanel panel9;
		panel9 = new JPanel();
		panel_2.add(panel9);
		panel9.setLayout(new BoxLayout(panel9, BoxLayout.X_AXIS));
		
		JLabel label4 = new JLabel("Usuario:");
		panel9.add(label4);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel9.add(horizontalStrut_7);
		
		txtUsuario = new JTextField();
		panel9.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		Component verticalStrut_8 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_8);
		
		JPanel panel10;
		panel10 = new JPanel();
		panel_2.add(panel10);
		panel10.setLayout(new BoxLayout(panel10, BoxLayout.X_AXIS));
		
		JLabel label5 = new JLabel("Contrasena:");
		panel10.add(label5);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel10.add(horizontalStrut_8);
		
		txtPass = new JPasswordField();
		panel10.add(txtPass);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		formulario.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		formulario.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		formulario.add(verticalStrut, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		formulario.add(verticalStrut_1, BorderLayout.SOUTH);
		
		JPanel botonera = new JPanel();
		FlowLayout fl_botonera = (FlowLayout) botonera.getLayout();
		fl_botonera.setAlignment(FlowLayout.RIGHT);
		add(botonera, BorderLayout.SOUTH);
		
		btnEnviar = new JButton("Enviar");
		botonera.add(btnEnviar);
		
		btnCancelar = new JButton("Cancelar");
		botonera.add(btnCancelar);

	}
	
	@Override
	public void estableceControlador(ControladorEmpleados controlador) {
		this.btnEnviar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}

}
