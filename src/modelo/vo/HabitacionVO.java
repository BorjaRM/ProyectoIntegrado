package modelo.vo;

public class HabitacionVO extends EstanciaVO{
	private String clasificacion;
	private int plazas;
	private int precio;
	private String descripcion;
	private int cod_reserva;
	
	public HabitacionVO(int id, int cod_est,String nom,String tipo,String clase, int plazas, int precio, String desc, int cod_res){
		super(id,cod_est,nom,tipo);
		this.clasificacion=clase;
		this.plazas=plazas;
		this.precio=precio;
		descripcion=desc;
		cod_reserva=cod_res;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCod_reserva() {
		return cod_reserva;
	}

	public void setCod_reserva(int cod_reserva) {
		this.cod_reserva = cod_reserva;
	}
	
}
