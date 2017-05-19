package modelo.vo;

public class UsuarioVO {
	private String nombre;
	private String contrasena;
	private int cod_empleado;
	
	public UsuarioVO(String nom,String pwd, int emp){
		nombre=nom;
		contrasena=pwd;
		cod_empleado=emp;
	}
	
	public UsuarioVO(String nom,String pwd){
		nombre=nom;
		contrasena=pwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getEmpleado() {
		return cod_empleado;
	}

	public void setEmpleado(int empleado) {
		this.cod_empleado = empleado;
	}
	
}
