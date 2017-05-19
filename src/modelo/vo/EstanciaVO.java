package modelo.vo;

public class EstanciaVO {
	private int id;
	private int cod_hotel;
	private String nombre;
	private String tipo;

	public EstanciaVO(int id, int cod, String nombre,String tipo){
		this.id=id;
		cod_hotel=cod;
		this.nombre=nombre;
		this.tipo=tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCod_hotel() {
		return cod_hotel;
	}

	public void setCod_hotel(int cod_hotel) {
		this.cod_hotel = cod_hotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
