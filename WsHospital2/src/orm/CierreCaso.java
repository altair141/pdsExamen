/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

/**
 * cierre del caso
 */
public class CierreCaso {
	public CierreCaso() {
	}
	
	private int id;
	
	private String tipoCierre;
	
	private String destino;
	
	private java.util.Date fechaAtencion;
	
	private String horaInicioAtencion;
	
	private java.util.Date fechaCierreClinico;
	
	private String horaCierreClinico;
	
	private String tiempoControl;
	
	private orm.Rce idRce;
	
	/**
	 * identificador cierre de caso
	 */
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * identificador cierre de caso
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * tipo cierre de caso, representa el estado de la atención recibida por parte del médico
	 */
	public void setTipoCierre(String value) {
		this.tipoCierre = value;
	}
	
	/**
	 * tipo cierre de caso, representa el estado de la atención recibida por parte del médico
	 */
	public String getTipoCierre() {
		return tipoCierre;
	}
	
	/**
	 * lugar al cual se derivará el paciente luego de realizar la consulta médica
	 */
	public void setDestino(String value) {
		this.destino = value;
	}
	
	/**
	 * lugar al cual se derivará el paciente luego de realizar la consulta médica
	 */
	public String getDestino() {
		return destino;
	}
	
	/**
	 * fecha de atención médica
	 */
	public void setFechaAtencion(java.util.Date value) {
		this.fechaAtencion = value;
	}
	
	/**
	 * fecha de atención médica
	 */
	public java.util.Date getFechaAtencion() {
		return fechaAtencion;
	}
	
	/**
	 * hora de inicio de la atención medica
	 */
	public void setHoraInicioAtencion(String value) {
		this.horaInicioAtencion = value;
	}
	
	/**
	 * hora de inicio de la atención medica
	 */
	public String getHoraInicioAtencion() {
		return horaInicioAtencion;
	}
	
	/**
	 * fecha de termino del caso clinico
	 */
	public void setFechaCierreClinico(java.util.Date value) {
		this.fechaCierreClinico = value;
	}
	
	/**
	 * fecha de termino del caso clinico
	 */
	public java.util.Date getFechaCierreClinico() {
		return fechaCierreClinico;
	}
	
	/**
	 * hora de termino del caso clinico
	 */
	public void setHoraCierreClinico(String value) {
		this.horaCierreClinico = value;
	}
	
	/**
	 * hora de termino del caso clinico
	 */
	public String getHoraCierreClinico() {
		return horaCierreClinico;
	}
	
	/**
	 * tiempo de seguimiento de controles posteriores
	 */
	public void setTiempoControl(String value) {
		this.tiempoControl = value;
	}
	
	/**
	 * tiempo de seguimiento de controles posteriores
	 */
	public String getTiempoControl() {
		return tiempoControl;
	}
	
	public void setIdRce(orm.Rce value) {
		if (this.idRce != value) {
			orm.Rce lidRce = this.idRce;
			this.idRce = value;
			if (value != null) {
				idRce.setCierreCaso(this);
			}
			if (lidRce != null) {
				lidRce.setCierreCaso(null);
			}
		}
	}
	
	public orm.Rce getIdRce() {
		return idRce;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
