package controlador;

import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
	private static final String refEmpleadoS = null;
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
			case "enviar": insertaReserva(); break;
			case "cancelar": cancelar(); break;
		}
	}
	
	private void insertaReserva() {
		ReservaDAO modeloReserva = new ReservaDAO();
		String refEmpeladoS = String.valueOf(refEmpleado);
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date dob = null;
		    dob = nrv.getDateChooserLlegada().getDate();
		    } catch (Exception e) {
		    	System.out.println("NO PODÉS");
		          e.printStackTrace();
		}
		ReservaVO reserva = new ReservaVO("",nrv.getDateChooserLlegada().getDate().toString(),
				nrv.getDateChooserSalida().getDate().toString(),
				nrv.getListaPension().getSelectedItem().toString(),
				nrv.getListaClientes().getSelectedItem().toString(),refEmpleadoS,
				nrv.getListaHabitaciones().getSelectedItem().toString());
		
		modeloReserva.nuevaReserva(reserva);
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
	
	public void eliminarReserva(){
		//Eliminar reserva seleccionada y volver a mostar reservasView
	}
	
	public void insertarReserva(){
		//Insertar reserva y volver a mostrar reservasView
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