package capaNegocio.personasDomain;

import capaNegocio.hospitalDomain.EstablecimientoVO;



public class MedicoVO {
	public int id;
	public EspecialidadVO especialidad;
	public EstablecimientoVO hospital;
	public PersonaVO persona;
	
	
	
	public MedicoVO() {
		super();
	}



	public MedicoVO(int id) {
		super();
		this.id = id;
	}



	public MedicoVO(int id, EspecialidadVO especialidad, EstablecimientoVO hospital,
			PersonaVO persona) {
		super();
		this.id = id;
		this.especialidad = especialidad;
		this.hospital = hospital;
		this.persona = persona;
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



	public EstablecimientoVO getHospital() {
		return hospital;
	}



	public void setHospital(EstablecimientoVO hospital) {
		this.hospital = hospital;
	}



	public PersonaVO getPersona() {
		return persona;
	}



	public void setPersona(PersonaVO persona) {
		this.persona = persona;
	}
	
	
	
	

}
