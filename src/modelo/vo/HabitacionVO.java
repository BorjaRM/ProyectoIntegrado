package modelo.vo;

public class HabitacionVO extends EstanciaVO{
	private String clasificacion;
	private int plazas;
	private int precio;
	private String descripcion;
	
	public HabitacionVO(int id, int cod_est,String nom,String tipo,String clase, int plazas, int precio, String desc){
		super(id,cod_est,nom,tipo);
		this.clasificacion=clase.toLowerCase();
		this.plazas=plazas;
		this.precio=precio;
		descripcion=desc.toLowerCase();;
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
}
