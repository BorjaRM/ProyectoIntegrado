package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorReservas;
import interfaces.IControladorReservas;
import modelo.vo.ClienteVO;
import modelo.vo.ReservaVO;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.Box;

public class ReservasView extends JPanel implements IControladorReservas{
	private JTable table;
	private JButton btnNuevaReserva;
	private JButton btnCancelarReserva;

	/**
	 * Create the panel.
	 */
	public ReservasView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		btnNuevaReserva = new JButton("Nueva Reserva");
		btnNuevaReserva.setActionCommand("Nueva Reserva");
		panel.add(btnNuevaReserva);
		
		btnCancelarReserva = new JButton("Anular Reserva");
		btnCancelarReserva.setActionCommand("Anular Reserva");
		panel.add(btnCancelarReserva);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		String[] colHeader = {"ID","Cliente","Habitacion","Check-In","Check-Out","Noches","Pension"};
		DefaultTableModel table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		scrollPane.setViewportView(table);
	}

	@Override
	public void estableceControlador(ControladorReservas controlador) {
		this.btnNuevaReserva.addActionListener(controlador);
		this.btnCancelarReserva.addActionListener(controlador);
	}
	
	public void rellenaListaReservas(ArrayList <ReservaVO> reserva){
		DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
		Object[] fila = new Object[modeloTabla.getColumnCount()];
		
		for (int i = 0 ; i < reserva.size(); i++ ){
			fila[0] = reserva.get(i).getCodigo();
			fila[1] = reserva.get(i).getInicio();
			fila[2] = reserva.get(i).getFin();
			fila[3] = reserva.get(i).getRegimen();
			fila[4] = reserva.get(i).getCod_cliente();
			fila[5] = reserva.get(i).getCod_usuario();
			fila[6] = reserva.get(i).getCod_habitacion();
			modeloTabla.addRow(fila);
		}
		table.setModel(modeloTabla);
			
	}

}