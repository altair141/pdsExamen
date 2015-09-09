package capaNegocio.fichaMedicaDomain;



public class ActividadVO {
	private int id;
	private String nombreActividad;
	private DiagnosticoVO diagnostico;
	
	public ActividadVO() {
		super();
	}
	public ActividadVO(int id) {
		super();
		this.id = id;
	}
	public ActividadVO(int id, String nombreActividad, DiagnosticoVO diagnostico) {
		super();
		this.id = id;
		this.nombreActividad = nombreActividad;
		this.diagnostico = diagnostico;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public DiagnosticoVO getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(DiagnosticoVO diagnostico) {
		this.diagnostico = diagnostico;
	}

}
