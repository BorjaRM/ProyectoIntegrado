package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BD;
import modelo.dao.ClienteDAO;
import vista.Marco;
import vista.NuevaReservaView;
import vista.ReservasView;

public class ControladorReservas implements ActionListener {
	private BD modelo;
	private Marco frame;
	private NuevaReservaView nrv;
	private ReservasView rv;
	private final boolean esAdministrador;
	private ClienteDAO cd;
	
	public ControladorReservas(Marco frame, BD modelo, boolean esAdministrador){
		this.frame=frame;
		this.modelo = modelo;
		this.esAdministrador=esAdministrador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver Reservas": preparaReservasView(); break;
			case "Nueva Reserva": preparaNuevaReservaView(); break;
			case "Anular Reserva": /* **************************************************************************** */ break;
			case "Enviar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
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
			frame.muestraPrincipalView(esAdministrador);
		}else
			frame.muestraReservasView();
	}
}