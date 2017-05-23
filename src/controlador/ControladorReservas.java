package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.BD;
import modelo.dao.ClienteDAO;
import modelo.dao.ReservaDAO;
import modelo.vo.ClienteVO;
import modelo.vo.ReservaVO;
import vista.Marco;
import vista.NuevaReservaView;
import vista.ReservasView;

public class ControladorReservas extends Controlador{
	private NuevaReservaView nrv;
	private ReservasView rv;
	private ReservaDAO rd;

	public ControladorReservas(){
		frame.estableceControlador(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand().toLowerCase()){
			case "ver reservas": preparaReservasView(); break;
			case "nueva reserva": preparaNuevaReservaView(); break;
			case "anular reserva": /* **************************************************************************** */ break;
			case "enviar": /* **************************************************************************** */ break;
			case "cancelar": cancelar(); break;
		}
	}
	
	private void insertaCliente() {
		ReservaDAO modeloReserva = new ReservaDAO();
		ReservaVO reserva = new ReservaVO("",nrv.getListaClientes().getSelectedItem().toString(),
				nrv.getListaHabitaciones().getSelectedItem().toString(),nrv.getDateChooserLlegada().getDate().toString(),
				nrv.getDateChooserSalida().getDate().toString(),
				nrv.getListaPension().getSelectedItem().toString(),"");
		
		modeloReserva.nuevaReserva(reserva);
		}

	public void preparaReservasView(){
		frame.creaReservasView(this);
		this.rv=frame.getRv();
		frame.muestraReservasView();
	}
	
	public void preparaNuevaReservaView(){
		frame.creaNuevaReservaView(this);
		this.nrv=frame.getNrv();
		frame.muestraNuevaReservaView();
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