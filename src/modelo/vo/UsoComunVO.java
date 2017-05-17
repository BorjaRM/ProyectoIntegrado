package modelo.vo;

public class UsoComunVO extends EstanciaVO{
	private String nombre;
	
	public UsoComunVO(int id, int cod_est, String nom) {
		super(id, cod_est,TipoEstancia.USO_COMUN);
		nombre=nom;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

