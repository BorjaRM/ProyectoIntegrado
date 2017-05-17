package controlador;

import modelo.BD;
import vista.NuevaReservaView;
import vista.ReservasView;

public class ControladorReservas {

	private BD modelo;
	private NuevaReservaView nr;
	private ReservasView rv;
	
	
	public ControladorReservas(BD modelo){
		this.modelo = modelo;
	}


	public NuevaReservaView getNr() {
		return nr;
	}


	public void setNr(NuevaReservaView nr) {
		this.nr = nr;
	}


	public ReservasView getRv() {
		return rv;
	}


	public void setRv(ReservasView rv) {
		this.rv = rv;
	}
	
}
