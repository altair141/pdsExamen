package capaNegocio.openmrs;

public class PacienteOpen {

	private String personUUid;
	private String identifier;
	
	private String identifierType;
	private String location;
	
	public PacienteOpen() {
		super();
		this.identifierType = "8d79403a-c2cc-11de-8d13-0010c6dffd0f";
		this.location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
	}
	public PacienteOpen(String personUUid, String identifier,
			String identifierType, String location) {
		super();
		this.personUUid = personUUid;
		this.identifier = identifier;
		this.identifierType = identifierType;
		this.location = location;
	}
	public String getPersonUUid() {
		return personUUid;
	}
	public void setPersonUUid(String personUUid) {
		this.personUUid = personUUid;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getIdentifierType() {
		return identifierType;
	}

	public String getLocation() {
		return location;
	}

}
