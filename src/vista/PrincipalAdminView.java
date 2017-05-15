package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.SpringLayout;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class PrincipalAdminView extends JPanel {
	private JTextField textClientes;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PrincipalAdminView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut);
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Hotel");
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JButton btn_nuevoHotel = new JButton("Nuevo Hotel");
		panel.add(btn_nuevoHotel);
		
		JButton btn_eliminarHotel = new JButton("Eliminar Hotel");
		panel.add(btn_eliminarHotel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		FormLayout fl_panel_3 = new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("72px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),});
		panel_3.setLayout(fl_panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes:");
		panel_3.add(lblNewLabel_1, "1, 1, left, default");
		
		textClientes = new JTextField();
		panel_3.add(textClientes, "3, 1, fill, default");
		textClientes.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Empleados:");
		panel_3.add(lblNewLabel_2, "1, 3, left, default");
		
		textField_1 = new JTextField();
		panel_3.add(textField_1, "3, 3");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Reservas:");
		panel_3.add(lblNewLabel_3, "1, 5");
		
		textField_2 = new JTextField();
		panel_3.add(textField_2, "3, 5");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Habitaciones:");
		panel_3.add(lblNewLabel_4, "1, 7, left, default");
		
		textField_3 = new JTextField();
		panel_3.add(textField_3, "3, 7");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Incidencias:");
		panel_3.add(lblNewLabel_5, "1, 9, left, default");
		
		textField_4 = new JTextField();
		panel_3.add(textField_4, "3, 9");
		textField_4.setColumns(10);
		
		JList list = new JList();
		panel_1.add(list);
		
	}
}
