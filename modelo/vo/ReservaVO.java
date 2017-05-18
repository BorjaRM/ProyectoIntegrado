package modelo.vo;

import modelo.dao.TipoRegimenDAO;

public class ReservaVO {
	private String codigo;
	private String inicio;
	private String fin;
	private TipoRegimenDAO regimen;
	private String cod_cliente;
	private String cod_usuario;
	private String cod_habitacion;
	
	public ReservaVO(String cod, String ini, String fin, TipoRegimenDAO reg, String cli, String user, String hab){
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

	public TipoRegimenDAO getRegimen() {
		return regimen;
	}

	public void setRegimen(TipoRegimenDAO regimen) {
		this.regimen = regimen;
	}
	
	public String getHabitacion(){
		return cod_habitacion;
	}
	
	public void setHabitacion(String habitacion){
		this.cod_habitacion = habitacion;
	}

}
