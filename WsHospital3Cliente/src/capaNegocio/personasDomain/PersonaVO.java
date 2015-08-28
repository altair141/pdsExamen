package capaNegocio.personasDomain;

import java.util.Date;

public class PersonaVO {
	private int id;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String direccion;
	private String estado;
	private String uuid;
	
	
	
	
	public PersonaVO(int id) {
		super();
		this.id = id;
	}


	
	public PersonaVO(String uuid) {
		super();
		this.uuid = uuid;
	}



	public PersonaVO() {
		super();
	}


	public PersonaVO(int id, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, String estado, String uuid) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.estado = estado;
		this.uuid = uuid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	


}
