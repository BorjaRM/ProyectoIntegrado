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
	private JTable tabla_empleados;
	private DefaultTableModel empleados_model;
	String[] empleados_head = {"ID","Nombre","Apellidos","Telefono","Inicio contrato"};
	private JButton btnNuevoEmpleado;
	private JButton btnEliminarEmpleado;
	private JButton btnModificarEmpleado;

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
		
		
		//Creamos la tabla que contiene los empleados
		JScrollPane scrollPane = new JScrollPane();
		empleados_model = new DefaultTableModel(empleados_head,0);
		tabla_empleados = new JTable(empleados_model);
		tabla_empleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla_empleados.setFillsViewportHeight(true);
		scrollPane.setViewportView(tabla_empleados);	
		panel_Tabla.add(scrollPane);
		}
	
	public void rellenaListaEmpleados(ArrayList <EmpleadoVO> empleados){
		empleados_model = new DefaultTableModel(empleados_head,0);
		Object[] fila = new Object[empleados_model.getColumnCount()];
		
		for (int i = 0 ; i < empleados.size(); i++ ){
			fila[0] = empleados.get(i).getIdentificacion();
			fila[1] = empleados.get(i).getNombre();
			fila[2] = empleados.get(i).getApellido1();
			fila[3] = empleados.get(i).getTelefono();
			fila[4] = empleados.get(i).getFecha_alta();
			empleados_model.addRow(fila);
		}
		tabla_empleados.setModel(empleados_model);
			
	}
	
	public JTable getTable() {
		return tabla_empleados;
	}

	public void setTable(JTable table) {
		this.tabla_empleados = table;
	}

	@Override
	public void estableceControlador(ControladorEmpleados controlador) {
		this.btnNuevoEmpleado.addActionListener(controlador);
		this.btnModificarEmpleado.addActionListener(controlador);
		this.btnEliminarEmpleado.addActionListener(controlador);
		this.tabla_empleados.getSelectionModel().addListSelectionListener(controlador);
	}

}
