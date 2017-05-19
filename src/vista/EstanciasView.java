package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorEstancias;
import interfaces.IControladorEstancias;
import modelo.vo.EstanciaVO;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class EstanciasView extends JPanel implements IControladorEstancias{
	private JTable table;
	private JButton btnNuevaEstancia;
	private JButton btnModificarEstancia;
	private JButton btnEliminarEstancia;

	/**
	 * Create the panel.
	 */
	public EstanciasView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel botonera = new JPanel();
		FlowLayout flowLayout = (FlowLayout) botonera.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setVgap(15);
		add(botonera, BorderLayout.NORTH);
		
		btnNuevaEstancia = new JButton("Nueva Estancia");
		botonera.add(btnNuevaEstancia);
		
		btnEliminarEstancia = new JButton("Eliminar Estancia");
		botonera.add(btnEliminarEstancia);
		
		btnModificarEstancia = new JButton("Modificar Estancia");
		botonera.add(btnModificarEstancia);
		
		JPanel panel_Tabla = new JPanel();
		add(panel_Tabla, BorderLayout.CENTER);
		panel_Tabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Tabla.add(scrollPane);
		
		/*String[] colHeader = {"Nombre","Tipo","Camas","Aseo","A/C","Wifi","Precio"};
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);*/
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	@Override
	public void estableceControlador(ControladorEstancias controlador) {
		this.btnNuevaEstancia.addActionListener(controlador);
		this.btnModificarEstancia.addActionListener(controlador);
		this.btnEliminarEstancia.addActionListener(controlador);
	}
	
	public void ocultaBotonNuevaEstancia(){
		this.btnNuevaEstancia.setVisible(false);
	}
	
	public void ocultaBotonModificarEstancia(){
		this.btnModificarEstancia.setVisible(false);
	}

	public void ocultaBotonEliminarEstancia(){
		this.btnEliminarEstancia.setVisible(false);
	}
	
	public void muestraTablaEstancias(ArrayList<EstanciaVO> estancias){
		String[] cabecero = {"Nombre","Tipo","Camas","Aseo","A/C","Wifi","Precio"};
		DefaultTableModel dtm = new DefaultTableModel(cabecero,0);
		
		//añadimos cada fila de datos a la tabla
		for(EstanciaVO e: estancias){
			// falta programar
		}


	}

}
