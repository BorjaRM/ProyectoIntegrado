package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;

import controlador.Controlador;
import controlador.ControladorUsuarios;
import modelo.vo.HotelVO;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class PrincipalAdminView extends JPanel {
	private JButton btn_nuevoHotel;
	private JButton btn_eliminarHotel;
	private JComboBox<HotelVO> desplegableHoteles;

	/**
	 * Create the panel.
	 */
	public PrincipalAdminView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Selecciona hotel:  ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblNewLabel);
		
		desplegableHoteles = new JComboBox<HotelVO>();
		desplegableHoteles.setActionCommand("Nueva referencia hotel");
		horizontalBox.add(desplegableHoteles);
		
		btn_nuevoHotel = new JButton("Nuevo Hotel");
		panel.add(btn_nuevoHotel);
		
		btn_eliminarHotel = new JButton("Eliminar Hotel");
		panel.add(btn_eliminarHotel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 25, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 20, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, 223, SpringLayout.NORTH, panel_1);
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Clientes:");
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Empelados:");
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Reservas:");
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Habitaciones libres:");
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Incidencias activas:");
		panel_4.add(lblNewLabel_5);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JLabel txt_clientes = new JLabel("New label");
		panel_5.add(txt_clientes);
		
		JLabel txt_empleados = new JLabel("New label");
		panel_5.add(txt_empleados);
		
		JLabel txt_reservas = new JLabel("New label");
		panel_5.add(txt_reservas);
		
		JLabel txt_hab = new JLabel("New label");
		panel_5.add(txt_hab);
		
		JLabel txt_incidencias = new JLabel("New label");
		panel_5.add(txt_incidencias);
		
		JList list = new JList();		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -20, SpringLayout.WEST, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 180, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, -20, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, -20, SpringLayout.EAST, panel_1);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(list);
	}
	
	public void estableceControlador(ControladorUsuarios controlador) {
		this.btn_nuevoHotel.addActionListener(controlador);
		this.btn_eliminarHotel.addActionListener(controlador);
	}
	
	public void estableceControlador(Controlador controlador) {
		this.desplegableHoteles.addActionListener(controlador);
	}
	
	public void rellenaDesplegableHoteles(ArrayList<HotelVO> hoteles){
		desplegableHoteles.removeAllItems();
		for(HotelVO hotel: hoteles){
			this.desplegableHoteles.addItem(hotel);
		}
	}

	public JComboBox<HotelVO> getDesplegableHoteles() {
		return desplegableHoteles;
	}	

}
