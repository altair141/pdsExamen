package capaNegocio.personasDomain;

public class PacienteVO {
	private int id;
	private String nroFicha;
	private PersonaVO persona;
	
	
	public PacienteVO() {
		super();
	}


	public PacienteVO(int id) {
		super();
		this.id = id;
	}


	public PacienteVO(int id, String nroFicha, PersonaVO persona) {
		super();
		this.id = id;
		this.nroFicha = nroFicha;
		this.persona = persona;
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


	public PersonaVO getPersona() {
		return persona;
	}


	public void setPersona(PersonaVO persona) {
		this.persona = persona;
	}

	
	



}
