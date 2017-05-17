package controlador;

import modelo.BD;
import vista.ClientesView;
import vista.ModificarClienteView;
import vista.NuevoClienteView;

public class ControladorClientes {
	private BD modelo;
	private ClientesView cv;
	private ModificarClienteView mcv;
	private NuevoClienteView ncv;
	
	public ControladorClientes(BD modelo){
		this.modelo=modelo;
	}
	
	public void setCv(ClientesView cv) {
		this.cv = cv;
	}

	public void setMcv(ModificarClienteView mcv) {
		this.mcv = mcv;
	}

	public void setNcv(NuevoClienteView ncv) {
		this.ncv = ncv;
	}

}
