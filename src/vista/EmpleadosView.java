package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEmpleados;
import interfaces.IControladorEmpleados;
import modelo.vo.EmpleadoVO;

public class EmpleadosView extends JPanel implements IControladorEmpleados{
	private JTable table;
	private JButton btnNuevoEmpleado;
	private JButton btnEliminarEmpleado;
	private JButton btnModificarEmpleado;
	JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public EmpleadosView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(30);
		add(panel, BorderLayout.NORTH);
		
		btnNuevoEmpleado = new JButton("Nuevo empleado");
		btnNuevoEmpleado.setActionCommand("Nuevo empleado");
		panel.add(btnNuevoEmpleado);
		
		btnEliminarEmpleado = new JButton("Eliminar Empleado");
		btnEliminarEmpleado.setActionCommand("Eliminar Empleado");
		panel.add(btnEliminarEmpleado);
		
		btnModificarEmpleado = new JButton("Modificar Empleado");
		btnModificarEmpleado.setActionCommand("Modificar Empleado");
		panel.add(btnModificarEmpleado);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		JPanel panel_Tabla = new JPanel();
		add(panel_Tabla, BorderLayout.CENTER);
		panel_Tabla.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_Tabla.add(scrollPane);
		
		
		}
	
	public void rellenaListaEmpleados(ArrayList <EmpleadoVO> empleados){
		
		String[] colHeader = {"ID","Nombre","Apellidos","Telefono","Inicio contrato"};
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
		Object[] fila = new Object[modeloTabla.getColumnCount()];
		
		for (int i = 0 ; i < empleados.size(); i++ ){
			fila[0] = empleados.get(i).getIdentificacion();
			fila[1] = empleados.get(i).getNombre();
			fila[2] = empleados.get(i).getApellido1();
			fila[3] = empleados.get(i).getTelefono();
			fila[4] = empleados.get(i).getFecha_alta();
			modeloTabla.addRow(fila);
		}
		table.setModel(modeloTabla);
			
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	@Override
	public void estableceControlador(ControladorEmpleados controlador) {
		this.btnNuevoEmpleado.addActionListener(controlador);
		this.btnModificarEmpleado.addActionListener(controlador);
		this.btnEliminarEmpleado.addActionListener(controlador);
	}

}
