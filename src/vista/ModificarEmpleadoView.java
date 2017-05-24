package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ControladorEmpleados;
import idiomas.Idiomas;
import interfaces.IControladorEmpleados;
import javax.swing.JPasswordField;

public class ModificarEmpleadoView extends JPanel implements IControladorEmpleados{
	private JTextField textField;
	private JTextField txtSeguridadSocial;
	private JTextField txtSalario;
	private JTextField txtTelefono;
	private JTextField txtIdentificacion;
	private JTextField txtApellido2;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	ResourceBundle bundle;
	
	/**
	 * Create the panel.
	 */
	public ModificarEmpleadoView() {
		bundle = Idiomas.getBundle();
		
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
		
		JLabel lblNombre = new JLabel(bundle.getString("jLblModEmpNomb"));
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
		
		JLabel lblApellido1 = new JLabel(bundle.getString("jLblModEmpApell1"));
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
		
		JLabel lblApellido2 = new JLabel(bundle.getString("jLblModEmpApell2"));
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
		
		JLabel lblIdentificacion = new JLabel(bundle.getString("jLblModEmpID"));
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
		
		JLabel lblTelefono = new JLabel(bundle.getString("jLblModEmpTelef"));
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
		
		JLabel lblSalario = new JLabel(bundle.getString("jLblModEmpSalario"));
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
		
		JLabel lblSeguridadSocial = new JLabel(bundle.getString("jLblModEmpSS"));
		panel9.add(lblSeguridadSocial);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel9.add(horizontalStrut_7);
		
		txtSeguridadSocial = new JTextField();
		panel9.add(txtSeguridadSocial);
		txtSeguridadSocial.setColumns(10);
		
		Component verticalStrut_8 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_8);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblUsuario = new JLabel(bundle.getString("jLblModEmpUsuaio"));
		panel_1.add(lblUsuario);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_11);
		
		txtUsuario = new JTextField();
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JLabel lblContrasea = new JLabel(bundle.getString("jLblModEmpPasswd"));
		panel_6.add(lblContrasea);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_12);
		
		passwordField = new JPasswordField();
		panel_6.add(passwordField);
		panel10 = new JPanel();
		panel_2.add(panel10);
		panel10.setLayout(new BoxLayout(panel10, BoxLayout.X_AXIS));
		
		
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel10.add(horizontalStrut_8);
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_10);
		
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
		
		btnModificar = new JButton(bundle.getString("btnModEmpEnviar"));
		botonera.add(btnModificar);// LOS PUTOS ACTION 
		
		btnCancelar = new JButton(bundle.getString("btnModEmpCancelar"));
		botonera.add(btnCancelar);
		


	}
	
	public JTextField getTxtSeguridadSocial() {
		return txtSeguridadSocial;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public void setTxtSeguridadSocial(JTextField txtSeguridadSocial) {
		this.txtSeguridadSocial = txtSeguridadSocial;
	}

	public JTextField getTxtSalario() {
		return txtSalario;
	}

	public void setTxtSalario(JTextField txtSalario) {
		this.txtSalario = txtSalario;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(JTextField txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}

	public JTextField getTxtApellido2() {
		return txtApellido2;
	}

	public void setTxtApellido2(JTextField txtApellido2) {
		this.txtApellido2 = txtApellido2;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido1() {
		return txtApellido1;
	}

	public void setTxtApellido1(JTextField txtApellido1) {
		this.txtApellido1 = txtApellido1;
	}






	@Override
	public void estableceControlador(ControladorEmpleados controlador) {
		this.btnModificar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}

}
