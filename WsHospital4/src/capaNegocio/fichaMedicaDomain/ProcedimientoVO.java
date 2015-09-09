package capaNegocio.fichaMedicaDomain;

public class ProcedimientoVO {
	private int id;
	private String nombre;
	private DiagnosticoVO diagnostico;
	public ProcedimientoVO() {
		super();
	}
	public ProcedimientoVO(int id) {
		super();
		this.id = id;
	}
	public ProcedimientoVO(int id, String nombre, DiagnosticoVO diagnostico) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.diagnostico = diagnostico;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DiagnosticoVO getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(DiagnosticoVO diagnostico) {
		this.diagnostico = diagnostico;
	}

}
