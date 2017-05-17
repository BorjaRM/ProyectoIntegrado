package modelo.vo;

public class HabitacionVO extends EstanciaVO{
	private String nombre;
	private TipoHabitacion clasificacion;
	private int plazas;
	private int precio;
	private String descripcion;
	private int cod_reserva;
	
	public HabitacionVO(int id, int cod_est, TipoHabitacion tipo,String nom, int plazas, int precio, String desc, int cod_res){
		super(id,cod_est,TipoEstancia.HABITACION);
		nombre=nom;
		this.clasificacion=tipo;
		this.plazas=plazas;
		this.precio=precio;
		descripcion=desc;
		cod_reserva=cod_res;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoHabitacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(TipoHabitacion tipo) {
		this.clasificacion = tipo;
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
