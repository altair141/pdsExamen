package capaNegocio.hospitalDomain;

import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;

public class ReservaVO {
	private int id;
	private PacienteVO paciente;
	private HoraMedicaVO horaMedica;
	private PersonaVO personaRegistra;
	public ReservaVO() {
		super();
	}
	public ReservaVO(int id) {
		super();
		this.id = id;
	}
	public ReservaVO(int id, PacienteVO paciente, HoraMedicaVO horaMedica,
			PersonaVO personaRegistra) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.horaMedica = horaMedica;
		this.personaRegistra = personaRegistra;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PacienteVO getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteVO paciente) {
		this.paciente = paciente;
	}
	public HoraMedicaVO getHoraMedica() {
		return horaMedica;
	}
	public void setHoraMedica(HoraMedicaVO horaMedica) {
		this.horaMedica = horaMedica;
	}
	public PersonaVO getPersonaRegistra() {
		return personaRegistra;
	}
	public void setPersonaRegistra(PersonaVO personaRegistra) {
		this.personaRegistra = personaRegistra;
	}

}
