package capaNegocio.personasDomain;

import java.util.Date;

public class MedicoVO extends PersonaVO{
	public int id;
	public EspecialidadVO especialidad;
	
	
	public MedicoVO() {
		super();
	}

	public MedicoVO(int id) {
		super();
		this.id = id;
	}
	
	public MedicoVO(int id, EspecialidadVO especialidad) {
		super();
		this.id = id;
		this.especialidad = especialidad;	
	}

	
	

	public MedicoVO(int idPersona, String nombre, String apellidos,
			Date fechaNacimiento, String direccion, String estado, String rut,
			String sexo, int id, EspecialidadVO especialidad) {
		super(idPersona, nombre, apellidos, fechaNacimiento, direccion, estado,
				rut, sexo);
		this.id = id;
		this.especialidad = especialidad;
	}

	public MedicoVO(String rut) {
		super(rut);
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EspecialidadVO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadVO especialidad) {
		this.especialidad = especialidad;
	}

}
