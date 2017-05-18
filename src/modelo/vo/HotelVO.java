package modelo.vo;

public class HotelVO {
	private int codigo;
	private String nombre;
	private String telefono;
	private String calle;
	private int numero;
	private int cp;
	private String ciudad;
	private String pais;
	
	public HotelVO(int cod, String nom, String telf, String calle, int n, int cp, String ciudad, String pais){
		codigo=cod;
		nombre=nom;
		telefono=telf;
		this.calle=calle;
		numero=n;
		this.cp=cp;
		this.ciudad=ciudad;
		this.pais=pais;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
		
}
