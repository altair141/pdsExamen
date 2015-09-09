package capaNegocio.fichaMedicaDomain;

import capaNegocio.personasDomain.PacienteVO;

public class HceVO {
	private int id;
	private PacienteVO paciente;
	public HceVO() {
		super();
	}
	public HceVO(int id) {
		super();
		this.id = id;
	}
	public HceVO(int id, PacienteVO paciente) {
		super();
		this.id = id;
		this.paciente = paciente;
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

}
