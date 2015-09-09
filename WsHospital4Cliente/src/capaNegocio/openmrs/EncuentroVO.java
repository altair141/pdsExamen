package capaNegocio.openmrs;

public class EncuentroVO {
	private String fechaTime;
	private String paciente;
	private String medico;
	private String tipoEncuentro;

	

	public EncuentroVO(String fechaTime, String paciente, String medico,
			String tipoEncuentro) {
		super();
		this.fechaTime = fechaTime;
		this.paciente = paciente;
		this.medico = medico;
		this.tipoEncuentro = tipoEncuentro;
	}

	public EncuentroVO() {
		super();
	}

	public String getFechaTime() {
		return fechaTime;
	}

	public void setFechaTime(String fechaTime) {
		this.fechaTime = fechaTime;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getTipoEncuentro() {
		return tipoEncuentro;
	}

	public void setTipoEncuentro(String tipoEncuentro) {
		this.tipoEncuentro = tipoEncuentro;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	
}
