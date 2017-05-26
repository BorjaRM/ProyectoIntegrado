package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import controlador.ControladorUsuarios;
import modelo.vo.UsuarioVO;
import res.Md5;

public class LoginView extends JFrame{
	private JPanel contentPane;
	private JTextField text_usuario;
	private JPasswordField passwordField;
	private JButton bntEntrar;
	private JCheckBox soyAdmin;
	private JComboBox<String> desplegableIdioma;

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
		
		contentPane.add(Box.createHorizontalStrut(250), BorderLayout.WEST);
		contentPane.add(Box.createHorizontalStrut(250), BorderLayout.EAST);
		contentPane.add(Box.createVerticalStrut(100), BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255,90));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		panel_1.add(Box.createVerticalStrut(110));
		
		JLabel lbl_usuario = new JLabel("Usuario:");
		panel_1.add(lbl_usuario);
		
		text_usuario = new JTextField();
		panel_1.add(text_usuario);
		text_usuario.setColumns(10);
		
		panel_1.add(Box.createVerticalStrut(20));
		
		JLabel lbl_pass = new JLabel("Contrase\u00F1a:");
		panel_1.add(lbl_pass);
		
		passwordField = new JPasswordField();
		panel_1.add(passwordField);
		
		panel_1.add(Box.createVerticalStrut(20));
		
		soyAdmin = new JCheckBox("Entrar como administrador");
		soyAdmin.setActionCommand("Obtener permisos");
		panel_1.add(soyAdmin);
		
		JPanel botonera = new JPanel();
		panel.add(botonera);
		
		bntEntrar = new JButton("Entrar");
		botonera.add(bntEntrar);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		desplegableIdioma = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"Seleciona un idioma ...", "Espa\u00F1ol", "English"}));
		panel_2.add(desplegableIdioma);
	}

	public void estableceControlador(ControladorUsuarios controlador) {
		this.bntEntrar.addActionListener(controlador);
	}
	
	public void estableceControlador(Controlador controlador){
		this.soyAdmin.addActionListener(controlador);
		this.desplegableIdioma.addItemListener(controlador);
	}

	public JCheckBox getSoyAdmin() {
		return soyAdmin;
	}	
	
	public UsuarioVO recogeDatos(){
		UsuarioVO u = null;
		try{
			String nombre=this.text_usuario.getText();
			String passText = Md5.encriptar(new String(passwordField.getPassword()));
			u=new UsuarioVO(nombre,passText);
		}catch (Exception e){
			e.printStackTrace();
		}
		return u;
	}

}
