package capaNegocio.fichamedicaDomain;

import java.util.Date;

import capaNegocio.fichamedica.Rce;

public class CierreCasoMedicoVO {
	private int id;
	private String tipoCierre;
	private String destino;
	private Date fechaAtencion;
	private String horaInicioAtencion;
	private Date fechaCierreClinico;
	private String horaCierreClienico;
	private String tiempoControl;
	private RceVO rce;
	public CierreCasoMedicoVO(int id) {
		super();
		this.id = id;
	}
	public CierreCasoMedicoVO() {
		super();
	}
	public CierreCasoMedicoVO(int id, String tipoCierre, String destino,
			Date fechaAtencion, String horaInicioAtencion,
			Date fechaCierreClinico, String horaCierreClienico,
			String tiempoControl, RceVO rce) {
		super();
		this.id = id;
		this.tipoCierre = tipoCierre;
		this.destino = destino;
		this.fechaAtencion = fechaAtencion;
		this.horaInicioAtencion = horaInicioAtencion;
		this.fechaCierreClinico = fechaCierreClinico;
		this.horaCierreClienico = horaCierreClienico;
		this.tiempoControl = tiempoControl;
		this.rce = rce;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoCierre() {
		return tipoCierre;
	}
	public void setTipoCierre(String tipoCierre) {
		this.tipoCierre = tipoCierre;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	public String getHoraInicioAtencion() {
		return horaInicioAtencion;
	}
	public void setHoraInicioAtencion(String horaInicioAtencion) {
		this.horaInicioAtencion = horaInicioAtencion;
	}
	public Date getFechaCierreClinico() {
		return fechaCierreClinico;
	}
	public void setFechaCierreClinico(Date fechaCierreClinico) {
		this.fechaCierreClinico = fechaCierreClinico;
	}
	public String getHoraCierreClienico() {
		return horaCierreClienico;
	}
	public void setHoraCierreClienico(String horaCierreClienico) {
		this.horaCierreClienico = horaCierreClienico;
	}
	public String getTiempoControl() {
		return tiempoControl;
	}
	public void setTiempoControl(String tiempoControl) {
		this.tiempoControl = tiempoControl;
	}
	public RceVO getRce() {
		return rce;
	}
	public void setRce(RceVO rce) {
		this.rce = rce;
	}
	
	

}
