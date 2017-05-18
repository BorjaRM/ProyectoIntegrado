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
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class NuevoEmpleadoView extends JPanel implements IControladorEmpleados{
	private JTextField textField;
	private JTextField txtSeguridadSocial;
	private JTextField txtSalario;
	private JTextField txtTelefono;
	private JTextField txtIdentificacion;
	private JTextField txtApellido2;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JPasswordField txtFechaAlta;
	private JTextField txtLugarTrabajo;

	/**
	 * Create the panel.
	 */
	public NuevoEmpleadoView() {
setLayout(new BorderLayout(0, 0));
		
		JPanel panel9;
		
		JPanel panel10;
		
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
		
		JLabel lblApellido1 = new JLabel("Primer apellido:");
		panel_4.add(lblApellido1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_3);
		
		txtApellido1 = new JTextField();
		txtApellido1.setColumns(10);
		panel_4.add(txtApellido1);
		
		Component verticalStrut_3 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_3);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JLabel lblApellido2 = new JLabel("Segundo apellido:");
		panel_5.add(lblApellido2);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_4);
		
		txtApellido2 = new JTextField();
		panel_5.add(txtApellido2);
		txtApellido2.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_4);
		
		JPanel panel6 = new JPanel();
		panel_2.add(panel6);
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
		
		JLabel lblIdentificacion = new JLabel("Identificacion:");
		panel6.add(lblIdentificacion);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel6.add(horizontalStrut_5);
		
		txtIdentificacion = new JTextField();
		panel6.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		Component verticalStrut_5 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_5);
		
		JPanel panel7 = new JPanel();
		panel_2.add(panel7);
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));
		
		JLabel lblTelefono = new JLabel("Telefono:");
		panel7.add(lblTelefono);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel7.add(horizontalStrut_6);
		
		txtTelefono = new JTextField();
		panel7.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_6);
		
		JPanel panel8 = new JPanel();
		panel_2.add(panel8);
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.X_AXIS));
		
		JLabel lblSalario = new JLabel("Salario:");
		panel8.add(lblSalario);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel8.add(horizontalStrut_9);
		
		txtSalario = new JTextField();
		panel8.add(txtSalario);
		txtSalario.setColumns(10);
		
		Component verticalStrut_7 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_7);
		panel9 = new JPanel();
		panel_2.add(panel9);
		panel9.setLayout(new BoxLayout(panel9, BoxLayout.X_AXIS));
		
		JLabel lblSeguridadSocial = new JLabel("Seguridad Social:");
		panel9.add(lblSeguridadSocial);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel9.add(horizontalStrut_7);
		
		txtSeguridadSocial = new JTextField();
		panel9.add(txtSeguridadSocial);
		txtSeguridadSocial.setColumns(10);
		
		Component verticalStrut_8 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_8);
		panel10 = new JPanel();
		panel_2.add(panel10);
		panel10.setLayout(new BoxLayout(panel10, BoxLayout.X_AXIS));
		
		JLabel lblFechaAlta = new JLabel("Fecha de alta:");
		panel10.add(lblFechaAlta);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel10.add(horizontalStrut_8);
		
		txtFechaAlta = new JPasswordField();
		panel10.add(txtFechaAlta);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_1);
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblLugarDeTrabajo = new JLabel("Lugar de trabajo:");
		lblLugarDeTrabajo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblLugarDeTrabajo);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_10);
		
		txtLugarTrabajo = new JTextField();
		txtLugarTrabajo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtLugarTrabajo);
		txtLugarTrabajo.setColumns(10);
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_9);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		formulario.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		formulario.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		formulario.add(verticalStrut, BorderLayout.NORTH);
		
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
