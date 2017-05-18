package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.ControladorIncidencias;
import interfaces.IControladorIncidencias;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class NuevaIncidenciaView extends JPanel implements IControladorIncidencias{
	private JComboBox comboBox;
	private JButton btnEnviar;
	private JButton btnCancelar;

	
	public NuevaIncidenciaView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(5, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		String [] nombresLista = {"Habitacion 1", "SPA"};
		
		Component horizontalStrut = Box.createHorizontalStrut(150);
		panel_2.add(horizontalStrut, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(100);
		panel_2.add(horizontalStrut_1, BorderLayout.WEST);
		
		comboBox = new JComboBox(nombresLista);
		panel_2.add(comboBox, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(60);
		panel_3.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("Descripcion de la Incidencia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
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
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setActionCommand("Enviar");
		panel_4.add(btnEnviar);
		
		btnCancelar = new JButton("Cancelar");
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

}
