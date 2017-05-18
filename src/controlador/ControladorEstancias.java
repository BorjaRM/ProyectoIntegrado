package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BD;
import vista.EstanciasView;
import vista.Marco;
import vista.ModificarEstanciaView;
import vista.NuevaEstanciaView;

public class ControladorEstancias implements ActionListener {
	private BD modelo;
	private Marco frame;
	private EstanciasView esv;
	private NuevaEstanciaView nesv;
	private ModificarEstanciaView mesv;
	private final boolean esAdministrador;
	
	public ControladorEstancias(Marco frame, BD modelo, boolean esAdministrador){
		this.frame=frame;
		this.modelo=modelo;
		this.esAdministrador=esAdministrador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver Estancias": preparaEstanciasView(); break;
			case "Nueva Estancia": preparaNuevaEstanciaView(); break;
			case "Modificar Estancia": preparaModificarEstanciaView(); break;
			case "Eliminar Estancia":/* **************************************************************************** */ break;
			case "Nueva zona comun":/* **************************************************************************** */ break;
			case "Nueva habitacion":/* **************************************************************************** */ break;
			case "Modificar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
	}
	
	public void preparaEstanciasView(){
		frame.creaEstanciasView(this);
		this.esv=frame.getEsv();
		if(!esAdministrador){
			esv.ocultaBotonNuevaEstancia();
			esv.ocultaBotonModificarEstancia();
			esv.ocultaBotonEliminarEstancia();
		}
		frame.muestraEstanciasView();
	}
	
	public void preparaNuevaEstanciaView(){
		frame.creaNuevaEstanciaView(this);
		this.nesv=frame.getNesv();
		frame.muestraNuevaEstanciaView();
	}
	
	public void insertarHabitacion(){
		
	}
	
	public void insertarZonaComun(){
		
	}
	
	public void preparaModificarEstanciaView(){
		frame.creaModificaEstanciaView(this);
		this.mesv=frame.getMesv();
		frame.muestraModificaEstancia();
	}
	
	public void modificarEstancia(){
		
	}
	
	public void eliminarEstancia(){
		
	}
	
	public void cancelar(){
		if(esv == null){
			frame.muestraPrincipalView(esAdministrador);
		}else
			frame.muestraEstanciasView();
	}


}