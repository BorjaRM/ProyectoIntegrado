package modelo.vo;

public abstract class EstanciaVO {
	private int id;
	private int cod_hotel;
	private TipoEstancia tipo;

	public EstanciaVO(int id, int cod, TipoEstancia tipo){
		this.id=id;
		cod_hotel=cod;
		this.tipo=tipo;
	}
	
	public EstanciaVO(int cod, TipoEstancia tipo){
		cod_hotel=cod;
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

	public TipoEstancia getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstancia tipo) {
		this.tipo = tipo;
	}
	
}
