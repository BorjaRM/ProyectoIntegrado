package modelo.vo;

/* En principio los servicios disponibles vendran predeterminados en la aplicacion,
 * como lo hago?
 */

public class ServicioVO {
	private int codigo;
	private String nombre;
	
	public ServicioVO(int cod, String nom){
		codigo=cod;
		nombre=nom;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
