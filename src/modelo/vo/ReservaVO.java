package modelo.vo;

public class ReservaVO {
	private String codigo;
	private String inicio;
	private String fin;
	private String regimen;
	private String cod_cliente;
	private String cod_usuario;
	private String cod_habitacion;
	
	public ReservaVO(String cod, String ini, String fin, String reg, String cli, String user,String hab){
		codigo=cod;
		inicio=ini;
		this.fin=fin;
		regimen=reg;
		cod_cliente=cli;
		cod_usuario=user;
		cod_habitacion = hab;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(String cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getCod_habitacion() {
		return cod_habitacion;
	}

	public void setCod_habitacion(String cod_habitacion) {
		this.cod_habitacion = cod_habitacion;
	}

}
