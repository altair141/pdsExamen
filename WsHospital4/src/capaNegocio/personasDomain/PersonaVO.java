package capaNegocio.personasDomain;

import java.util.Date;

public class PersonaVO {
	private int idPersona;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String direccion;
	private String estado;
	private String rut;
	private String sexo;

	public PersonaVO(int idPersona, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, String estado, String rut,
			String sexo) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.estado = estado;
		this.rut = rut;
		this.sexo = sexo;
	}

	public PersonaVO(int idPersona) {
		super();
		this.idPersona = idPersona;
	}

	public PersonaVO(String rut) {
		super();
		this.rut = rut;
	}

	public PersonaVO() {
		super();
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
