package modelo.vo;

public enum TipoHabitacion {
	ESTANDAR("Estandar"),
	ADAPTADA("Adaptada"),
	SUITE("Suite"),
	SUITE_ADAPTADA("Suite Adaptada");		
	
	private String tipo;
	
	private TipoHabitacion(String tipo){
		this.tipo=tipo;
	}
	
	public String toString(){
		return tipo;
	}
		
}