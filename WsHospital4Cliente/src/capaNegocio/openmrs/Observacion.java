package capaNegocio.openmrs;

public class Observacion {
	private String persona;
	private String fecha;
	private String concepto;
	private String encuentro;
	
	
	public Observacion() {
		super();
	}


	public Observacion(String persona, String fecha, String concepto,
			String encuentro) {
		super();
		this.persona = persona;
		this.fecha = fecha;
		this.concepto = concepto;
		this.encuentro = encuentro;
	}


	public String getPersona() {
		return persona;
	}


	public void setPersona(String persona) {
		this.persona = persona;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public String getEncuentro() {
		return encuentro;
	}


	public void setEncuentro(String encuentro) {
		this.encuentro = encuentro;
	}
	
}
