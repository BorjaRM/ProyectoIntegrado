package modelo.vo;

public class ClienteVO {
	private String codigo;
	private String nombre;
	private String apellidos;
	private String identificacion;
	private String fecha_nacimiento;
	private String telefono;
	private String nacionalidad;
	private String email;
	private String fecha_alta;
	
	public ClienteVO(String cod, String nom, String aps, String id, String fNac, String tlf, String nac, String email, String fAlta){
		codigo=cod;
		nombre=nom;
		apellidos=aps;
		identificacion=id;
		fecha_nacimiento=fNac;
		telefono=tlf;
		nacionalidad=nac;
		this.email=email;
		fecha_alta=fAlta;
	}
	
	public ClienteVO(String nom, String aps, String id, String fNac, String tlf, String nac, String email, String fAlta){
		nombre=nom;
		apellidos=aps;
		identificacion=id;
		fecha_nacimiento=fNac;
		telefono=tlf;
		nacionalidad=nac;
		this.email=email;
		fecha_alta=fAlta;
	}
	
	@Override
	public String toString(){
		return this.nombre+" "+this.apellidos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

}
