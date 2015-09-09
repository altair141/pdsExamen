package capaNegocio.personasDomain;

import java.util.Date;

public class DirectorHospitalVO extends PersonaVO{
	private int id;

	public DirectorHospitalVO(int id) {
		super();
		this.id = id;
	}

	public DirectorHospitalVO() {
		super();
	}

	

	public DirectorHospitalVO(int idPersona, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, String estado, String rut,
			String sexo, int id) {
		super(idPersona, nombre, apellidos, fechaNacimiento, direccion, estado,
				rut, sexo);
		this.id = id;
	}

	public DirectorHospitalVO(String rut) {
		super(rut);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
