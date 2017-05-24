package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorUsuarios;
import modelo.vo.HotelVO;

public class NuevoHotelView extends JPanel {
	private JTextField text_nombre;
	private JTextField text_telefono;
	private JTextField text_calle;
	private JTextField text_cp;
	private JTextField text_numero;
	private JTextField text_ciudad;
	private JTextField text_pais;
	private JButton btnEnviar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public NuevoHotelView(ResourceBundle bundle) {
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lbl_nombre = new JLabel(bundle.getString("jLblHotNombre"));
		panel.add(lbl_nombre);
		
		text_nombre = new JTextField();
		text_nombre.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(text_nombre);
		text_nombre.setColumns(10);
		
		JLabel lbl_telf = new JLabel(bundle.getString("jLblHotTelefono"));
		panel.add(lbl_telf);
		
		text_telefono = new JTextField();
		text_telefono.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(text_telefono);
		text_telefono.setColumns(10);
		
		JLabel lbl_calle = new JLabel(bundle.getString("jLblHotCalle"));
		panel.add(lbl_calle);
		
		text_calle = new JTextField();
		text_calle.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(text_calle);
		text_calle.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel(bundle.getString("jLblHotNumero"));
		panel.add(lblNewLabel_3);
		
		text_numero = new JTextField();
		text_numero.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(text_numero);
		text_numero.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel(bundle.getString("jLblHotCodPost"));
		panel.add(lblNewLabel_4);
		
		text_cp = new JTextField();
		text_cp.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(text_cp);
		text_cp.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(bundle.getString("jLblHotCiudad"));
		panel.add(lblNewLabel_5);
		
		text_ciudad = new JTextField();
		text_ciudad.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(text_ciudad);
		text_ciudad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel(bundle.getString("jLblHotPais"));
		panel.add(lblNewLabel_6);
		
		text_pais = new JTextField();
		text_pais.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(text_pais);
		text_pais.setColumns(10);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);
		
		JPanel Botonera = new JPanel();
		FlowLayout flowLayout = (FlowLayout) Botonera.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(Botonera, BorderLayout.SOUTH);
		
		btnEnviar = new JButton(bundle.getString("btnEnviarHot"));
		btnEnviar.setActionCommand("enviar");
		Botonera.add(btnEnviar);
		
		btnCancelar = new JButton(bundle.getString("btnCancelarHot"));
		btnCancelar.setActionCommand("cancelar");
		Botonera.add(btnCancelar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);

	}
	
	public void estableceControlador(ControladorUsuarios controlador) {
		this.btnEnviar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}
	
	public HotelVO enviarDatos(){
		HotelVO h = null;
		try{
			String nombre=this.text_nombre.getText();
			String telefono=this.text_telefono.getText();
			String calle=this.text_calle.getText();
			int numero=Integer.parseInt(this.text_numero.getText());
			int cp=Integer.parseInt(this.text_cp.getText());
			String ciudad=this.text_ciudad.getText();
			String pais=this.text_pais.getText();
			h = new HotelVO(0,nombre,telefono,calle,numero,cp,ciudad,pais);
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Faltan datos o son incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return h;
	}

}
