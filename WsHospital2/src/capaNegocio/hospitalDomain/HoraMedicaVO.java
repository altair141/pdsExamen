package capaNegocio.hospitalDomain;

import java.util.Date;

import capaNegocio.personasDomain.MedicoVO;


public class HoraMedicaVO {
	private int id;
	private MedicoVO medico;
	private BoxVO box;
	private String asp;
	private Date fecha;
	private EstablecimientoVO establecimiento;
	private String uuid;
	public HoraMedicaVO() {
		super();
	}
	public HoraMedicaVO(int id) {
		super();
		this.id = id;
	}
	public HoraMedicaVO(int id, MedicoVO medico, BoxVO box, String asp, Date fecha,
			EstablecimientoVO establecimiento, String uuid) {
		super();
		this.id = id;
		this.medico = medico;
		this.box = box;
		this.asp = asp;
		this.fecha = fecha;
		this.establecimiento = establecimiento;
		this.uuid = uuid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MedicoVO getMedico() {
		return medico;
	}
	public void setMedico(MedicoVO medico) {
		this.medico = medico;
	}
	public BoxVO getBox() {
		return box;
	}
	public void setBox(BoxVO box) {
		this.box = box;
	}
	public String getAsp() {
		return asp;
	}
	public void setAsp(String asp) {
		this.asp = asp;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstablecimientoVO getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(EstablecimientoVO establecimiento) {
		this.establecimiento = establecimiento;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
