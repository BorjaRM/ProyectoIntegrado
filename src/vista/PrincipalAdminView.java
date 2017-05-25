package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import controlador.ControladorUsuarios;
import modelo.vo.HotelVO;

public class PrincipalAdminView extends JPanel {
	private JButton btn_nuevoHotel;
	private JButton btn_eliminarHotel;
	private JComboBox<HotelVO> desplegableHoteles;
	private JList<String> incidenciasList;
	private JLabel txt_clientes;
	private JLabel txt_empleados;
	private JLabel txt_reservas;
	private JLabel txt_hab;
	private JLabel txt_incidencias;

	/**
	 * Create the panel.
	 */
	public PrincipalAdminView(ResourceBundle bundle) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel(bundle.getString("jLblSelectHotel"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		horizontalBox.add(lblNewLabel);
		
		desplegableHoteles = new JComboBox<HotelVO>();
		desplegableHoteles.setActionCommand("Nueva referencia hotel");
		horizontalBox.add(desplegableHoteles);
		
		btn_nuevoHotel = new JButton(bundle.getString("btnAddHotel"));
		btn_nuevoHotel.setActionCommand("nuevo hotel");
		panel.add(btn_nuevoHotel);
		
		btn_eliminarHotel = new JButton(bundle.getString("btnRmvHotel"));
		btn_eliminarHotel.setActionCommand("eliminar hotel");
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
		
		JLabel lblNewLabel_1 = new JLabel(bundle.getString("jLblClientes"));
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(bundle.getString("jLblEmpleados"));
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(bundle.getString("jLblReservas"));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(bundle.getString("jLblHabitaciones"));
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(bundle.getString("jLblIncidencias"));
		panel_4.add(lblNewLabel_5);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		txt_clientes = new JLabel("New label");
		panel_5.add(txt_clientes);
		
		txt_empleados = new JLabel("New label");
		panel_5.add(txt_empleados);
		
		txt_reservas = new JLabel("New label");
		panel_5.add(txt_reservas);
		
		txt_hab = new JLabel("New label");
		panel_5.add(txt_hab);
		
		txt_incidencias = new JLabel("New label");
		panel_5.add(txt_incidencias);
		
		incidenciasList = new JList<String>();		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -20, SpringLayout.WEST, scrollPane);
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, panel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 180, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, -20, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, -20, SpringLayout.EAST, panel_1);
		panel_1.add(scrollPane);
		scrollPane.setViewportView(incidenciasList);
	}
	
	public void estableceControlador(ControladorUsuarios controlador) {
		this.btn_nuevoHotel.addActionListener(controlador);
		this.btn_eliminarHotel.addActionListener(controlador);
		this.desplegableHoteles.addActionListener(controlador);
	}
	
	public void rellenaDesplegableHoteles(ArrayList<HotelVO> hoteles){
		desplegableHoteles.removeAllItems();
		for(HotelVO hotel: hoteles){
			this.desplegableHoteles.addItem(hotel);
		}
	}
	
	public void rellenaListaIncidencias(ArrayList<String> incidencias){
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		if(!incidencias.isEmpty()){
			//Añadimos los datos
			listModel.addElement("Incidencias activas:");
			for(String incidencia: incidencias){
				listModel.addElement(incidencia);
			}
		}else{
			listModel.addElement("No hay incidencias activas");
		}
		//Añadimos el modelo a la lista
		incidenciasList.setModel(listModel);
	}

	public JComboBox<HotelVO> getDesplegableHoteles() {
		return desplegableHoteles;
	}

	public JLabel getTxt_clientes() {
		return txt_clientes;
	}

	public JLabel getTxt_empleados() {
		return txt_empleados;
	}

	public JLabel getTxt_reservas() {
		return txt_reservas;
	}

	public JLabel getTxt_hab() {
		return txt_hab;
	}

	public JLabel getTxt_incidencias() {
		return txt_incidencias;
	}	

}
