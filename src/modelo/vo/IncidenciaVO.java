package modelo.vo;

public class IncidenciaVO {
	private int codigo;
	private String descripcion;
	private String estado;
	private String fecha;
	private int cod_estancia;
	
	public IncidenciaVO(int cod, String desc, String est, String fe, int codE){
		codigo=cod;
		descripcion=desc;
		estado=est;
		fecha=fe;
		cod_estancia=codE;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public int getCod_estancia() {
		return cod_estancia;
	}

	public void setCod_estancia(int cod_estancia) {
		this.cod_estancia = cod_estancia;
	}
	
}
