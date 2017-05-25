package controlador;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.ClienteDAO;
import modelo.dao.HabitacionDAO;
import modelo.dao.ReservaDAO;
import modelo.vo.ClienteVO;
import modelo.vo.HabitacionVO;
import modelo.vo.ReservaVO;
import vista.NuevaReservaView;
import vista.ReservasView;

public class ControladorReservas extends Controlador{
	private NuevaReservaView nrv;
	private ReservasView rv;
	private ReservaDAO rd;
	private int posicionSeleccionada;

	public ControladorReservas(){
		frame.estableceControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand().toLowerCase()){
			case "ver reservas": preparaReservasView(); break;
			case "nueva reserva": preparaNuevaReservaView(); break;
			case "anular reserva": eliminaReserva(); break;
			case "enviar": insertaReserva(); preparaReservasView(); break;
			case "cancelar": cancelar(); break;
		}
	}
	
	private void insertaReserva() {
		ReservaDAO modeloReserva = new ReservaDAO();
		ClienteVO clienteSeleccionado = null;
		HabitacionVO habSeleccionada = null;
		String inicio = null;
		String fin = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
			inicio = sdf.format(nrv.getDateChooserLlegada().getDate().getTime());
			fin = sdf.format(nrv.getDateChooserSalida().getDate().getTime());
			clienteSeleccionado = (ClienteVO) nrv.getListaClientes().getSelectedItem();
			habSeleccionada = (HabitacionVO) nrv.getListaHabitaciones().getSelectedItem();
			ReservaVO reserva = new ReservaVO("",inicio,fin,nrv.getListaPension().getSelectedItem().toString(),
					clienteSeleccionado.getCodigo(),Controlador.refUsuario,String.valueOf(habSeleccionada.getId()));
			modeloReserva.nuevaReserva(reserva);
		}catch (Exception e){
			 e.printStackTrace();
		}
	}
	
	
	private void eliminaReserva(){
		posicionSeleccionada = rv.getTable().getSelectedRow();
		if(posicionSeleccionada != -1){
		ReservaDAO modeloReserva = new ReservaDAO();
		modeloReserva.eliminarReserva(posicionSeleccionada);
		rellenaTabla();
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, Primero Selecciona Una Reserva");
		}
	}
	
	public void rellenaTabla(){
		ReservaDAO modeloReserva = new ReservaDAO();
		ClienteDAO modeloCliente = new ClienteDAO();
		HabitacionDAO modeloHabitacion = new HabitacionDAO();
		ArrayList <ReservaVO> reservas = modeloReserva.consultaReservas();
		ArrayList <ClienteVO> clientes = modeloCliente.rellenaYConsigueArrayClientes();
		ArrayList <HabitacionVO> habitaciones = modeloHabitacion.getHabitaciones(refHotel);
		rv.rellenaListaReservas(reservas, clientes, habitaciones);
	}

	public void preparaReservasView(){
		frame.creaReservasView(this);
		this.rv=frame.getRv();
		rellenaTabla();
		frame.muestraReservasView();
		
	}
	
	public void preparaNuevaReservaView(){
		frame.creaNuevaReservaView(this);
		this.nrv=frame.getNrv();
		llenaComboBoxClientes();
		llenaComboBoxHabitaciones();
		frame.muestraNuevaReservaView();
	}
	
	public void llenaComboBoxClientes(){
		ClienteDAO modeloCliente = new ClienteDAO();
		ArrayList <ClienteVO> clientes = modeloCliente.rellenaYConsigueArrayClientes();
		nrv.llenaComboBoxClientes(clientes);
	}
	
	public void llenaComboBoxHabitaciones(){
		HabitacionDAO modeloHabitacion = new HabitacionDAO();
		ArrayList <HabitacionVO> habitaciones = modeloHabitacion.getHabitaciones(refHotel);
		nrv.llenaComboBoxHabitaciones(habitaciones);
	}
	
	public void cancelar(){
		if(rv == null){
			if(esAdministrador)
				frame.muestraPrincipalAdminView();		
			else
				frame.muestraPrincipalEmpleadoView();
		}else
			frame.muestraReservasView();
	}
}