package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorReservas;
import idiomas.Idiomas;
import interfaces.IControladorReservas;
import modelo.vo.ClienteVO;
import modelo.vo.HabitacionVO;
import modelo.vo.ReservaVO;

public class ReservasView extends JPanel implements IControladorReservas{
	private JTable table;
	private JButton btnNuevaReserva;
	private JButton btnCancelarReserva;
	private DefaultTableModel table_model;
	private JScrollPane scrollPane;
	ResourceBundle bundle;
	
	/**
	 * Create the panel.
	 */
	public ReservasView() {
		bundle = Idiomas.getBundle();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		btnNuevaReserva = new JButton(bundle.getString("btnNewRsrv"));
		btnNuevaReserva.setActionCommand("Nueva Reserva");
		panel.add(btnNuevaReserva);
		
		btnCancelarReserva = new JButton(bundle.getString("btnRmvRsrv"));
		btnCancelarReserva.setActionCommand("Anular Reserva");
		panel.add(btnCancelarReserva);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
	}

	@Override
	public void estableceControlador(ControladorReservas controlador) {
		this.btnNuevaReserva.addActionListener(controlador);
		this.btnCancelarReserva.addActionListener(controlador);
	}
	
	
	public void rellenaListaReservas(ArrayList <ReservaVO> reservas, ArrayList<ClienteVO> clientes, ArrayList<HabitacionVO> habitaciones){
		String[] colHeader = {bundle.getString("jTblRsrvID"),bundle.getString("jTblRsrvCli"),bundle.getString("jTblRsrvHabi"),bundle.getString("jTblRsrvCheckIn"),bundle.getString("jTblRsrvCheckOut"),bundle.getString("jTblRsrvNoches"),bundle.getString("jTblRsrvPension")};
		table_model = new DefaultTableModel(colHeader,0);
		table = new JTable(table_model);
		table.setName("Reservas");
		scrollPane.setViewportView(table);
		DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
		Object[] fila = new Object[modeloTabla.getColumnCount()];
		
		for(int i=0;i<reservas.size();i++){
			LocalDate fechaLlegada = LocalDate.parse(reservas.get(i).getInicio().toString());
			LocalDate fechaSalida = LocalDate.parse(reservas.get(i).getFin().toString());
			fila[0] = reservas.get(i).getCodigo();
			fila[3] = reservas.get(i).getInicio();
			fila[4] = reservas.get(i).getFin();
			fila[5] = ChronoUnit.DAYS.between(fechaLlegada, fechaSalida);
			fila[6] = reservas.get(i).getRegimen();	
			for(int x=0;x<clientes.size();x++){
				if(reservas.get(i).getCod_cliente().equals(clientes.get(x).getCodigo())){
					fila[1] = clientes.get(x).getNombre()+" "+clientes.get(x).getApellidos();
				}
			}
			for(int y=0;y<habitaciones.size();y++){
				int codigoHabitacion = Integer.parseInt(reservas.get(i).getCod_habitacion());
				if(codigoHabitacion == habitaciones.get(y).getId()){
				fila[2] = habitaciones.get(y).getNombre();
				}
			}
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
	
	
}