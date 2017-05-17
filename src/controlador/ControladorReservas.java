<<<<<<< HEAD
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
=======

package controlador;

public class ControladorReservas {

}
>>>>>>> 022fb508a18d1369d3285f6c82d759f25d20a3a5
