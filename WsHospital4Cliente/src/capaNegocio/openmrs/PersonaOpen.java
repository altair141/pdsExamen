package capaNegocio.openmrs;

public class PersonaOpen {
	String sexo;
	String fecha;
	String nombre;
	String apellido;
	String direccion;
	
	
	public PersonaOpen() {
		super();
	}
	public PersonaOpen(String sexo, String fecha, String nombre,
			String apellido, String direccion) {
		super();
		this.sexo = sexo;
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
