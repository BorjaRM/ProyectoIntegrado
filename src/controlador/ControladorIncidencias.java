package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BD;
import vista.IncidenciasView;
import vista.Marco;
import vista.NuevaIncidenciaView;

public class ControladorIncidencias implements ActionListener {
	private BD modelo;
	private Marco frame;
	private IncidenciasView iv;
	private NuevaIncidenciaView niv;
	private final boolean esAdministrador;
	private int refHotel;

	public ControladorIncidencias(Marco frame, BD modelo, boolean esAdministrador, int refHotel){
		this.frame=frame;
		this.modelo=modelo;
		this.esAdministrador=esAdministrador;
		this.refHotel=refHotel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
			case "Ver Incidencias": preparaIncidenciasView(); break;
			case "Nueva Incidencia": preparaNuevaIncidenciaView(); break;
			case "Incidencia Resuelta": /* **************************************************************************** */ break;
			case "Enviar": /* **************************************************************************** */ break;
			case "Cancelar": cancelar(); break;
		}
	}
	
	public void preparaIncidenciasView(){
		frame.creaIncidenciasView(this);
		this.iv=frame.getIv();
		frame.muestraIncidenciasView();
	}

	public void preparaNuevaIncidenciaView(){
		frame.creaNuevaIncidenciaView(this);
		this.niv=frame.getNiv();
		frame.muestraNuevaIncidenciaView();
	}
	
	public void cancelar(){
		if(iv == null){
			if(esAdministrador)
				frame.muestraPrincipalAdminView();		
			else
				frame.muestraPrincipalEmpleadoView();
		}else
			frame.muestraIncidenciasView();
	}
	
}