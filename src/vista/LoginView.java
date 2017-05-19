package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorUsuarios;
import modelo.vo.UsuarioVO;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginView extends JFrame{

	private JPanel contentPane;
	private JTextField text_usuario;
	private JPasswordField passwordField;
	private JButton bntEntrar;
	private JCheckBox soyAdmin;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(250);
		contentPane.add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(250);
		contentPane.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(100);
		contentPane.add(verticalStrut_1, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255,90));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(110);
		panel_1.add(verticalStrut);
		
		JLabel lbl_usuario = new JLabel("Usuario:");
		panel_1.add(lbl_usuario);
		
		text_usuario = new JTextField();
		panel_1.add(text_usuario);
		text_usuario.setColumns(10);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2);
		
		JLabel lbl_pass = new JLabel("Contrasenya:");
		panel_1.add(lbl_pass);
		
		passwordField = new JPasswordField();
		panel_1.add(passwordField);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3);
		
		soyAdmin = new JCheckBox("Entrar como administrador");
		panel_1.add(soyAdmin);
		
		JPanel botonera = new JPanel();
		panel.add(botonera);
		
		bntEntrar = new JButton("Entrar");
		botonera.add(bntEntrar);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleciona un idioma ...", "Espa\u00F1ol", "English"}));
		panel_2.add(comboBox);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(600);
		panel_2.add(horizontalStrut_2);
	}

	public void estableceControlador(ControladorUsuarios controlador) {
		this.bntEntrar.addActionListener(controlador);
		this.soyAdmin.addActionListener(controlador);
		this.comboBox.addActionListener(controlador);
		
	}

	public JCheckBox getSoyAdmin() {
		return soyAdmin;
	}	
	
	public UsuarioVO recogeDatos(){
		UsuarioVO u = null;
		try{
			String nombre=this.text_usuario.getText();
			String passText = new String(passwordField.getPassword());
<<<<<<< HEAD
			u=new UsuarioVO(nombre,passText,0);
=======
			u=new UsuarioVO(nombre,passText);
>>>>>>> 63a40be1cb01864a1642dd0df795acb5b772f545
		}catch (Exception e){
			e.printStackTrace();
		}
		return u;
	}

}
