package capaNegocio.personasDomain;



public class DirectorHospitalVO {
	private int id;
	private PersonaVO persona;
	public DirectorHospitalVO() {
		super();
	}
	public DirectorHospitalVO(int id) {
		super();
		this.id = id;
	}
	public DirectorHospitalVO(int id, PersonaVO persona) {
		super();
		this.id = id;
		this.persona = persona;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PersonaVO getPersona() {
		return persona;
	}
	public void setPersona(PersonaVO persona) {
		this.persona = persona;
	}
	
	

}
