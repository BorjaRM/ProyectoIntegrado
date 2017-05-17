package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NuevoEmpleadoView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public NuevoEmpleadoView() {
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
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_2);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		panel_4.add(lblApellidos);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_4.add(textField_1);
		
		Component verticalStrut_3 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_3);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel1 = new JLabel("Identificacion:");
		panel_5.add(lblNewLabel1);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_4);
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		
		Component verticalStrut_4 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_4);
		
		JPanel panel6 = new JPanel();
		panel_2.add(panel6);
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
		
		JLabel label1 = new JLabel("Telefono:");
		panel6.add(label1);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel6.add(horizontalStrut_5);
		
		textField = new JTextField();
		panel6.add(textField);
		textField.setColumns(10);
		
		Component verticalStrut_5 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_5);
		
		JPanel panel7 = new JPanel();
		panel_2.add(panel7);
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));
		
		JLabel label2 = new JLabel("Inicio contrato:");
		panel7.add(label2);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel7.add(horizontalStrut_6);
		
		textField = new JTextField();
		panel7.add(textField);
		textField.setColumns(10);
		
		Component verticalStrut_6 = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut_6);
		
		JPanel panel8 = new JPanel();
		panel_2.add(panel8);
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.X_AXIS));
		
		JLabel label3 = new JLabel("Hotel:");
		panel8.add(label3);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel8.add(horizontalStrut_9);
		
		textField = new JTextField();
		panel8.add(textField);
		textField.setColumns(10);
		
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
		
		textField = new JTextField();
		panel9.add(textField);
		textField.setColumns(10);
		
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
		
		textField = new JTextField();
		panel10.add(textField);
		textField.setColumns(10);
		
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
		
		JButton btnEnviar = new JButton("Enviar");
		botonera.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		botonera.add(btnCancelar);

	}

}
