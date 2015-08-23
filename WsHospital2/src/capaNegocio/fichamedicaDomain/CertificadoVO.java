package capaNegocio.fichamedicaDomain;

public class CertificadoVO {
	private int id;
	private String nombre;
	public CertificadoVO() {
		super();
	}
	public CertificadoVO(int id) {
		super();
		this.id = id;
	}
	public CertificadoVO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	
	
	

}
