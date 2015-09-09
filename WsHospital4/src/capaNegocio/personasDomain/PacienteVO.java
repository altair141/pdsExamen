package capaNegocio.personasDomain;

import java.util.Date;

public class PacienteVO extends PersonaVO{
	private int id;
	private String nroFicha;
	
	
	public PacienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PacienteVO(int id) {
		super();
		this.id = id;
	}


	public PacienteVO(int id, String nroFicha) {
		super();
		this.id = id;
		this.nroFicha = nroFicha;
	}


	
	public PacienteVO(int idPersona, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, String estado, String rut,
			String sexo, int id, String nroFicha) {
		super(idPersona, nombre, apellidos, fechaNacimiento, direccion, estado,
				rut, sexo);
		this.id = id;
		this.nroFicha = nroFicha;
	}


	public PacienteVO(int idPersona, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, String estado, String rut,
			String sexo) {
		super(idPersona, nombre, apellidos, fechaNacimiento, direccion, estado, rut,
				sexo);
		// TODO Auto-generated constructor stub
	}


	public PacienteVO(int idPersona,int paciente) {
		super(idPersona);
		// TODO Auto-generated constructor stub
		this.id=paciente;
	}
	public PacienteVO(String rut) {
		super(rut);
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNroFicha() {
		return nroFicha;
	}


	public void setNroFicha(String nroFicha) {
		this.nroFicha = nroFicha;
	}

	
	


}
