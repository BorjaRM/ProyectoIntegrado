package modelo.vo;

public class IncidenciaVO {
	private int codigo;
	private String descripcion;
	
	public IncidenciaVO(int cod, String desc){
		codigo=cod;
		descripcion=desc;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
