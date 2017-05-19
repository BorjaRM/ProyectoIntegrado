package modelo.vo;

public class EmpleadoVO {
	private int codigo;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String identificacion;
	private String telefono;
	private int salario;
	private String seguridad_social;
	private String fecha_alta;
	private int lugar_trabajo;
	
	public EmpleadoVO(int cod, String nom, String ap1, String ap2, String id, String tlf, int salario, String ss, String fAlta, int trabaja){
		codigo=cod;
		nombre=nom;
		apellido1=ap1;
		apellido2=ap2;
		identificacion=id;
		telefono=tlf;
		this.salario=salario;
		seguridad_social=ss;
		fecha_alta=fAlta;
		lugar_trabajo=trabaja;
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getSeguridad_social() {
		return seguridad_social;
	}

	public void setSeguridad_social(String seguridad_social) {
		this.seguridad_social = seguridad_social;
	}

	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public int getLugar_trabajo() {
		return lugar_trabajo;
	}

	public void setLugar_trabajo(int lugar_trabajo) {
		this.lugar_trabajo = lugar_trabajo;
	}
	
	
}
