package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controlador.ControladorIncidencias;
import idiomas.Idiomas;
import interfaces.IControladorIncidencias;
import modelo.dao.IncidenciaDAO;
import modelo.vo.EstanciaVO;
import modelo.vo.IncidenciaVO;


public class NuevaIncidenciaView extends JPanel implements IControladorIncidencias{
	private JComboBox<EstanciaVO> comboBox;
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JTextArea textArea;
	private ArrayList <EstanciaVO> misEstancias;
	private int cod_estancia=0;
	ResourceBundle bundle;
	private int posSeleccio=0;
	private IncidenciaDAO inc=new IncidenciaDAO();
	
	public NuevaIncidenciaView() {
		bundle = Idiomas.getBundle();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(5, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
				
		Component horizontalStrut = Box.createHorizontalStrut(150);
		panel_2.add(horizontalStrut, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(100);
		panel_2.add(horizontalStrut_1, BorderLayout.WEST);
		
		comboBox = new JComboBox<EstanciaVO>();
		panel_2.add(comboBox, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(60);
		panel_3.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel(bundle.getString("jLblRegInciDesc"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		textArea.setBackground(Color.WHITE);
		textArea.setTabSize(0);
		textArea.setForeground(Color.BLACK);
		panel_3.add(textArea);
		
		Component verticalStrut_1 = Box.createVerticalStrut(50);
		panel_3.add(verticalStrut_1);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_4, BorderLayout.SOUTH);
		
		btnEnviar = new JButton(bundle.getString("btnRegInciEnviar"));
		btnEnviar.setActionCommand("Enviar");
		panel_4.add(btnEnviar);
		
		btnCancelar = new JButton(bundle.getString("btnRegInciCancel"));
		btnCancelar.setActionCommand("Cancelar");
		panel_4.add(btnCancelar);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.WEST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_3);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.EAST);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_6.add(horizontalStrut_2);
	
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);

	}

	@Override
	public void estableceControlador(ControladorIncidencias controlador) {
		this.btnEnviar.addActionListener(controlador);
		this.btnCancelar.addActionListener(controlador);
	}
	public void rellenaComboBox(ArrayList <EstanciaVO> Estancias){
		comboBox.removeAllItems();
		for (int i = 0 ; i < Estancias.size(); i++){
			System.err.println(Estancias.get(i).getNombre());
			comboBox.addItem(Estancias.get(i));
		}	
	}

	public JComboBox<EstanciaVO> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<EstanciaVO> comboBox) {
		this.comboBox = comboBox;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	

}