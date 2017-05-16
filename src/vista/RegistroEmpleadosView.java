package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.Box;

public class RegistroEmpleadosView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldIdentificacion;
	private JTextField textFieldTelefono;
	private JTextField textFieldInicioContrato;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldEmpleado;
	private JTextField textFieldHotel;
	private Component verticalGlue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEmpleadosView frame = new RegistroEmpleadosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroEmpleadosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setHorizontalAlignment(SwingConstants.RIGHT);
		panelBotones.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 269, 0};
		gbl_panel.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.anchor = GridBagConstraints.NORTH;
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 0);
		gbc_verticalGlue.gridx = 2;
		gbc_verticalGlue.gridy = 0;
		panel.add(verticalGlue, gbc_verticalGlue);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 1;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 2;
		panel.add(lblApellidos, gbc_lblApellidos);
		
		textFieldApellidos = new JTextField();
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.gridx = 2;
		gbc_textFieldApellidos.gridy = 2;
		panel.add(textFieldApellidos, gbc_textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Identificacion:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldIdentificacion = new JTextField();
		GridBagConstraints gbc_textFieldIdentificacion = new GridBagConstraints();
		gbc_textFieldIdentificacion.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIdentificacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIdentificacion.gridx = 2;
		gbc_textFieldIdentificacion.gridy = 3;
		panel.add(textFieldIdentificacion, gbc_textFieldIdentificacion);
		textFieldIdentificacion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldTelefono = new JTextField();
		GridBagConstraints gbc_textFieldTelefono = new GridBagConstraints();
		gbc_textFieldTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono.gridx = 2;
		gbc_textFieldTelefono.gridy = 4;
		panel.add(textFieldTelefono, gbc_textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Inicio contrato:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldInicioContrato = new JTextField();
		GridBagConstraints gbc_textFieldInicioContrato = new GridBagConstraints();
		gbc_textFieldInicioContrato.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldInicioContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldInicioContrato.gridx = 2;
		gbc_textFieldInicioContrato.gridy = 5;
		panel.add(textFieldInicioContrato, gbc_textFieldInicioContrato);
		textFieldInicioContrato.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 6;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		textFieldUsuario = new JTextField();
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.gridx = 2;
		gbc_textFieldUsuario.gridy = 6;
		panel.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 7;
		panel.add(lblPassword, gbc_lblPassword);
		
		passwordFieldEmpleado = new JPasswordField();
		GridBagConstraints gbc_passwordFieldEmpleado = new GridBagConstraints();
		gbc_passwordFieldEmpleado.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldEmpleado.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldEmpleado.gridx = 2;
		gbc_passwordFieldEmpleado.gridy = 7;
		panel.add(passwordFieldEmpleado, gbc_passwordFieldEmpleado);
		
		JLabel lblHotel = new JLabel("Hotel:");
		GridBagConstraints gbc_lblHotel = new GridBagConstraints();
		gbc_lblHotel.anchor = GridBagConstraints.EAST;
		gbc_lblHotel.insets = new Insets(0, 0, 0, 5);
		gbc_lblHotel.gridx = 1;
		gbc_lblHotel.gridy = 8;
		panel.add(lblHotel, gbc_lblHotel);
		
		textFieldHotel = new JTextField();
		GridBagConstraints gbc_textFieldHotel = new GridBagConstraints();
		gbc_textFieldHotel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHotel.gridx = 2;
		gbc_textFieldHotel.gridy = 8;
		panel.add(textFieldHotel, gbc_textFieldHotel);
		textFieldHotel.setColumns(10);
	}

}
