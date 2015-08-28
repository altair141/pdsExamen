package capaNegocio.hospitalDomain;

import java.util.Date;

import capaNegocio.personasDomain.DirectorHospitalVO;

public class ReporteVO {

	private int id;
	private DirectorHospitalVO director;
	private Date fecha;
	private String resultado;
	private TipoReporteVO tipo;
		
	public ReporteVO() {
		super();
	}

	public ReporteVO(int id) {
		super();
		this.id = id;
	}

	public ReporteVO(int id, DirectorHospitalVO director, Date fecha,
			String resultado, TipoReporteVO tipo) {
		super();
		this.id = id;
		this.director = director;
		this.fecha = fecha;
		this.resultado = resultado;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DirectorHospitalVO getDirector() {
		return director;
	}

	public void setDirector(DirectorHospitalVO director) {
		this.director = director;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public TipoReporteVO getTipo() {
		return tipo;
	}

	public void setTipo(TipoReporteVO tipo) {
		this.tipo = tipo;
	}
	
	
	


}
