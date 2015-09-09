package capaNegocio.openmrs;

public class MedicoOpen {
	private String personUUid;
	private String identifier;
	public MedicoOpen(String personUUid, String identifier) {
		super();
		this.personUUid = personUUid;
		this.identifier = identifier;
	}
	public MedicoOpen() {
		super();
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

}
