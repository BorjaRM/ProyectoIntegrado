package modelo.vo;

public class ReservaVO {
	private String codigo;
	private String inicio;
	private String fin;
	private Regimenes regimen;
	private String cod_cliente;
	private String cod_usuario;
	
	public ReservaVO(String cod, String ini, String fin, Regimenes reg, String cli, String user){
		codigo=cod;
		inicio=ini;
		this.fin=fin;
		regimen=reg;
		cod_cliente=cli;
		cod_usuario=user;
	}
	
	private enum Regimenes{
		ALOJAMIENTO,DESAYUNO,MEDIA,COMPLETA
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

	public Regimenes getRegimen() {
		return regimen;
	}

	public void setRegimen(Regimenes regimen) {
		this.regimen = regimen;
	}

	public String getCliente() {
		return cod_cliente;
	}

	public void setCliente(String cliente) {
		this.cod_cliente = cliente;
	}

	public String getUsuario() {
		return cod_usuario;
	}

	public void setUsuario(String usuario) {
		this.cod_usuario = usuario;
	}

}
