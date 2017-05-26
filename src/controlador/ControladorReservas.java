package controlador;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import modelo.dao.ClienteDAO;
import modelo.dao.HabitacionDAO;
import modelo.dao.ReservaDAO;
import modelo.vo.ClienteVO;
import modelo.vo.HabitacionVO;
import modelo.vo.ReservaVO;
import vista.NuevaReservaView;
import vista.ReservasView;

public class ControladorReservas extends Controlador implements PropertyChangeListener{
	private NuevaReservaView nrv;
	private ReservasView rv;
	private ReservaDAO rd;
	private int posicionSeleccionada;
	String newFechaLlegada;
	String newFechaSalida;

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
			inicio = transformaFecha(nrv.getDateChooserLlegada().getDate().getTime());
			fin = transformaFecha(nrv.getDateChooserSalida().getDate().getTime());
			clienteSeleccionado = (ClienteVO) nrv.getListaClientes().getSelectedItem();
			habSeleccionada = (HabitacionVO) nrv.getListaHabitaciones().getSelectedItem();
			ReservaVO reserva = new ReservaVO("",inicio,fin,nrv.getListaPension().getSelectedItem().toString(),
					clienteSeleccionado.getCodigo(),Controlador.refUsuario,String.valueOf(habSeleccionada.getId()));
			modeloReserva.nuevaReserva(reserva);
		}catch (Exception e){
			 e.printStackTrace();
		}
	}
	
	public String  transformaFecha(long oldDate ){
		String newDate;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return newDate=sdf.format(oldDate);
	}
	
	
	private void eliminaReserva(){
		posicionSeleccionada = rv.getTable().getSelectedRow();
		if(posicionSeleccionada != -1){
		ReservaDAO modeloReserva = new ReservaDAO();
		modeloReserva.eliminarReserva(posicionSeleccionada,refHotel);
		rellenaTabla();
		}else{
			JOptionPane.showMessageDialog(null, "ERROR, Primero Selecciona Una Reserva");
		}
	}
	
	public void rellenaTabla(){
		ReservaDAO modeloReserva = new ReservaDAO();
		ClienteDAO modeloCliente = new ClienteDAO();
		HabitacionDAO modeloHabitacion = new HabitacionDAO();
		ArrayList <ReservaVO> reservas = modeloReserva.consultaReservas(refHotel);
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
		frame.muestraNuevaReservaView();
	}
	
	public void llenaComboBoxClientes(){
		ClienteDAO modeloCliente = new ClienteDAO();
		ArrayList <ClienteVO> clientes = modeloCliente.rellenaYConsigueArrayClientes();
		nrv.llenaComboBoxClientes(clientes);
	}
	
	public void llenaComboBoxHabitaciones(String newFechaLlegada, String newFechaSalida){
		HabitacionDAO modeloHabitacion = new HabitacionDAO();
		ArrayList <HabitacionVO> habitaciones = modeloHabitacion.getHabitacionesLibresEntreDosFechas(newFechaLlegada,newFechaSalida,refHotel);
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

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		System.out.println("ha ocurrido algo");
		if(e.getPropertyName().equals("date")){
			JDateChooser source = (JDateChooser) e.getSource();
			JDateChooser llegada = nrv.getDateChooserLlegada();
			JDateChooser salida = nrv.getDateChooserSalida();
			if(llegada == source){
				Date fechaLlegada = (Date) e.getNewValue();
				this.newFechaLlegada = transformaFecha((long)fechaLlegada.getTime());
				System.out.println("has cambiado llegada "+newFechaLlegada);
				salida.setMinSelectableDate(fechaLlegada);
			}else if(salida == source){
				Date fechaSalida = (Date) e.getNewValue();
				this.newFechaSalida = transformaFecha((long)fechaSalida.getTime());
				System.out.println("has cambiado salida "+newFechaSalida);
			}
			System.out.println(newFechaLlegada+" - "+newFechaSalida);
			if(newFechaLlegada != null && newFechaSalida != null){
				System.out.println("rellenando");
				llenaComboBoxHabitaciones(newFechaLlegada,newFechaSalida);
			}
		}
	}
}