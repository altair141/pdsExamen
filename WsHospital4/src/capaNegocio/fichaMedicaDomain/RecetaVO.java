package capaNegocio.fichaMedicaDomain;

public class RecetaVO {
	private int id;
	private String contenido;
	private RceVO rce;
	
	
	public RecetaVO(int id, String contenido, RceVO rce) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.rce = rce;
	}
	public RecetaVO() {
		super();
	}
	public RecetaVO(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public RceVO getRce() {
		return rce;
	}
	public void setRce(RceVO rce) {
		this.rce = rce;
	}
	
	
}
