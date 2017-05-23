package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorClientes;
import interfaces.IControladorClientes;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ModificarClienteView extends JPanel implements IControladorClientes{
	private JTextField txt_Nombre;
	private JTextField txt_Apellidos;
	private JTextField txt_Identificacion;
	private JTextField txt_FechaNacimiento;
	private JTextField txt_Telefono;
	private JTextField txt_Email;
	private JTextField txt_Nacionalidad;
	private JButton btnModificar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public ModificarClienteView(ResourceBundle bundle) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Botones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_Botones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_Botones, BorderLayout.SOUTH);
		
		btnModificar = new JButton(bundle.getString("btnModCliEnviar"));
		btnModificar.setActionCommand("Modificar");
		panel_Botones.add(btnModificar);
		
		btnCancelar = new JButton(bundle.getString("btnModCliCancelar"));
		btnCancelar.setActionCommand("Cancelar");
		panel_Botones.add(btnCancelar);
		
		JPanel panel_Informacion = new JPanel();
		add(panel_Informacion, BorderLayout.CENTER);
		panel_Informacion.setLayout(new BoxLayout(panel_Informacion, BoxLayout.Y_AXIS));
		
		JLabel lblNombre = new JLabel(bundle.getString("jLblModCliNomb"));
		panel_Informacion.add(lblNombre);
		
		txt_Nombre = new JTextField();
		panel_Informacion.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel(bundle.getString("jLblModCliApell"));
		panel_Informacion.add(lblApellidos);
		
		txt_Apellidos = new JTextField();
		panel_Informacion.add(txt_Apellidos);
		txt_Apellidos.setColumns(10);
		
		JLabel lblIndentificacion = new JLabel(bundle.getString("jLblModCliID"));
		panel_Informacion.add(lblIndentificacion);
		
		txt_Identificacion = new JTextField();
		panel_Informacion.add(txt_Identificacion);
		txt_Identificacion.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel(bundle.getString("jLblModCliFechNacim"));
		panel_Informacion.add(lblFechaDeNacimiento);
		
		txt_FechaNacimiento = new JTextField();
		panel_Informacion.add(txt_FechaNacimiento);
		txt_FechaNacimiento.setColumns(10);
		
		JLabel lblTelefono = new JLabel(bundle.getString("jLblModCliTelef"));
		panel_Informacion.add(lblTelefono);
		
		txt_Telefono = new JTextField();
		panel_Informacion.add(txt_Telefono);
		txt_Telefono.setColumns(10);
		
		JLabel lblEmail = new JLabel(bundle.getString("jLblModCliEmail"));
		panel_Informacion.add(lblEmail);
		
		txt_Email = new JTextField();
		panel_Informacion.add(txt_Email);
		txt_Email.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel(bundle.getString("jLblModCliNacion"));
		panel_Informacion.add(lblNacionalidad);
		
		txt_Nacionalidad = new JTextField();
		panel_Informacion.add(txt_Nacionalidad);
		txt_Nacionalidad.setColumns(10);

	}

	public void estableceControlador(ControladorClientes controlador){
		this.btnModificar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}
}

