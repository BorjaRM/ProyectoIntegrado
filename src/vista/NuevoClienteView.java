package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorClientes;
import interfaces.IControladorClientes;
import com.toedter.calendar.JDateChooser;

public class NuevoClienteView extends JPanel  implements IControladorClientes{
	private JTextField txt_Nombre;
	private JTextField txt_Apellidos;
	private JTextField txt_Identificacion;
	private JTextField txt_Telefono;
	private JTextField txt_Email;
	private JTextField txt_Nacionalidad;
	private JDateChooser dateChooser;
	private JButton btnEnviar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public NuevoClienteView(ResourceBundle bundle) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Botones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_Botones.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_Botones, BorderLayout.SOUTH);
		
		btnEnviar = new JButton(bundle.getString("btnRegCliEnviar"));
		btnEnviar.setActionCommand("Enviar");
		panel_Botones.add(btnEnviar);
		
		btnCancelar = new JButton(bundle.getString("btnRegCliCancelar"));
		btnCancelar.setActionCommand("Cancelar");
		panel_Botones.add(btnCancelar);
		
		JPanel panel_Informacion = new JPanel();
		add(panel_Informacion, BorderLayout.CENTER);
		panel_Informacion.setLayout(new BoxLayout(panel_Informacion, BoxLayout.Y_AXIS));
		
		JLabel lblNombre = new JLabel(bundle.getString("jLblRegCliNomb"));
		panel_Informacion.add(lblNombre);
		
		txt_Nombre = new JTextField();
		panel_Informacion.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel(bundle.getString("jLblRegCliApell"));
		panel_Informacion.add(lblApellidos);
		
		txt_Apellidos = new JTextField();
		panel_Informacion.add(txt_Apellidos);
		txt_Apellidos.setColumns(10);
		
		JLabel lblIndentificacion = new JLabel(bundle.getString("jLblRegCliID"));
		panel_Informacion.add(lblIndentificacion);
		
		txt_Identificacion = new JTextField();
		panel_Informacion.add(txt_Identificacion);
		txt_Identificacion.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel(bundle.getString("jLblRegCliFechNacim"));
		panel_Informacion.add(lblFechaDeNacimiento);
		
		dateChooser = new JDateChooser();
		panel_Informacion.add(dateChooser);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblTelefono = new JLabel(bundle.getString("jLblRegCliTelef"));
		panel_Informacion.add(lblTelefono);
		
		txt_Telefono = new JTextField();
		panel_Informacion.add(txt_Telefono);
		txt_Telefono.setColumns(10);
		
		JLabel lblEmail = new JLabel(bundle.getString("jLblRegCliEmail"));
		panel_Informacion.add(lblEmail);
		
		txt_Email = new JTextField();
		panel_Informacion.add(txt_Email);
		txt_Email.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel(bundle.getString("jLblRegCliNacion"));
		panel_Informacion.add(lblNacionalidad);
		
		txt_Nacionalidad = new JTextField();
		panel_Informacion.add(txt_Nacionalidad);
		txt_Nacionalidad.setColumns(10);
	}
	
	public void estableceControlador(ControladorClientes controlador){
		this.btnEnviar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}

	public JTextField getTxt_Nombre() {
		return txt_Nombre;
	}

	public void setTxt_Nombre(JTextField txt_Nombre) {
		this.txt_Nombre = txt_Nombre;
	}

	public JTextField getTxt_Apellidos() {
		return txt_Apellidos;
	}

	public void setTxt_Apellidos(JTextField txt_Apellidos) {
		this.txt_Apellidos = txt_Apellidos;
	}

	public JTextField getTxt_Identificacion() {
		return txt_Identificacion;
	}

	public void setTxt_Identificacion(JTextField txt_Identificacion) {
		this.txt_Identificacion = txt_Identificacion;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	public JTextField getTxt_Telefono() {
		return txt_Telefono;
	}

	public void setTxt_Telefono(JTextField txt_Telefono) {
		this.txt_Telefono = txt_Telefono;
	}

	public JTextField getTxt_Email() {
		return txt_Email;
	}

	public void setTxt_Email(JTextField txt_Email) {
		this.txt_Email = txt_Email;
	}

	public JTextField getTxt_Nacionalidad() {
		return txt_Nacionalidad;
	}

	public void setTxt_Nacionalidad(JTextField txt_Nacionalidad) {
		this.txt_Nacionalidad = txt_Nacionalidad;
	}

}

