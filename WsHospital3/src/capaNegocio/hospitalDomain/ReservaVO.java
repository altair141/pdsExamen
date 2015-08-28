package capaNegocio.hospitalDomain;

import capaNegocio.hospital.HoraMedica;
import capaNegocio.personas.Paciente;
import capaNegocio.personas.Persona;

public class ReservaVO {
	private int id;
	private Paciente paciente;
	private HoraMedica horaMedica;
	private Persona personaRegistra;
	public ReservaVO() {
		super();
	}
	public ReservaVO(int id) {
		super();
		this.id = id;
	}
	public ReservaVO(int id, Paciente paciente, HoraMedica horaMedica,
			Persona personaRegistra) {
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
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public HoraMedica getHoraMedica() {
		return horaMedica;
	}
	public void setHoraMedica(HoraMedica horaMedica) {
		this.horaMedica = horaMedica;
	}
	public Persona getPersonaRegistra() {
		return personaRegistra;
	}
	public void setPersonaRegistra(Persona personaRegistra) {
		this.personaRegistra = personaRegistra;
	}
	

}
