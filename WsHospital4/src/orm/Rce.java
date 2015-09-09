/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package orm;

/**
 * registro clínico electrónico
 */
public class Rce {
	public Rce() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_RCE_CERTIFICADO) {
			return ORM_certificado;
		}
		else if (key == orm.ORMConstants.KEY_RCE_ACTIVIDAD) {
			return ORM_actividad;
		}
		else if (key == orm.ORMConstants.KEY_RCE_PROCEDIMIENTO) {
			return ORM_procedimiento;
		}
		else if (key == orm.ORMConstants.KEY_RCE_DIAGNOSTICOIDDIAGNOSTICO) {
			return ORM_diagnosticoidDiagnostico;
		}
		else if (key == orm.ORMConstants.KEY_RCE_RECETA) {
			return ORM_receta;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_RCE_IDHCE) {
			this.idHce = (orm.Hce) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_RCE_IDHORAMEDICA) {
			this.idHoraMedica = (orm.HoraMedica) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idRce;
	
	private String tipoEncuentro;
	
	private orm.Hce idHce;
	
	private orm.HoraMedica idHoraMedica;
	
	private String anamnesis;
	
	private String alergia;
	
	private String examenFisico;
	
	private String indicacionMedica;
	
	private String indicacionCierreCaso;
	
	private String hipotesisDiagnostico;
	
	private String pacienteGes;
	
	private String patologiaGes;
	
	private String pacienteCronico;
	
	private String tipoCierre;
	
	private String destino;
	
	private java.util.Date fechaAtencion;
	
	private String horaInicioAtencion;
	
	private java.util.Date fechaCierreClinico;
	
	private String horaCierreClinico;
	
	private String tiempoControl;
	
	private java.util.Set ORM_certificado = new java.util.HashSet();
	
	private java.util.Set ORM_actividad = new java.util.HashSet();
	
	private java.util.Set ORM_procedimiento = new java.util.HashSet();
	
	private java.util.Set ORM_diagnosticoidDiagnostico = new java.util.HashSet();
	
	private java.util.Set ORM_receta = new java.util.HashSet();
	
	/**
	 * id registro clínico electrónico
	 */
	private void setIdRce(int value) {
		this.idRce = value;
	}
	
	/**
	 * id registro clínico electrónico
	 */
	public int getIdRce() {
		return idRce;
	}
	
	public int getORMID() {
		return getIdRce();
	}
	
	/**
	 * tipo de encuentro
	 */
	public void setTipoEncuentro(String value) {
		this.tipoEncuentro = value;
	}
	
	/**
	 * tipo de encuentro
	 */
	public String getTipoEncuentro() {
		return tipoEncuentro;
	}
	
	/**
	 * anamnesis de del rce, término empleado para referirse a la información proporcionada por el propio paciente
	 *  
	 */
	public void setAnamnesis(String value) {
		this.anamnesis = value;
	}
	
	/**
	 * anamnesis de del rce, término empleado para referirse a la información proporcionada por el propio paciente
	 *  
	 */
	public String getAnamnesis() {
		return anamnesis;
	}
	
	/**
	 * alergias que posee el paciente
	 */
	public void setAlergia(String value) {
		this.alergia = value;
	}
	
	/**
	 * alergias que posee el paciente
	 */
	public String getAlergia() {
		return alergia;
	}
	
	/**
	 * datos examen físico del paciente
	 */
	public void setExamenFisico(String value) {
		this.examenFisico = value;
	}
	
	/**
	 * datos examen físico del paciente
	 */
	public String getExamenFisico() {
		return examenFisico;
	}
	
	/**
	 * indicaciones proporcionadas por el médico
	 */
	public void setIndicacionMedica(String value) {
		this.indicacionMedica = value;
	}
	
	/**
	 * indicaciones proporcionadas por el médico
	 */
	public String getIndicacionMedica() {
		return indicacionMedica;
	}
	
	/**
	 * indicaciones del médico para cerrar el caso
	 */
	public void setIndicacionCierreCaso(String value) {
		this.indicacionCierreCaso = value;
	}
	
	/**
	 * indicaciones del médico para cerrar el caso
	 */
	public String getIndicacionCierreCaso() {
		return indicacionCierreCaso;
	}
	
	/**
	 * hipótesis de cual es la enfermedad que posee el paciente
	 */
	public void setHipotesisDiagnostico(String value) {
		this.hipotesisDiagnostico = value;
	}
	
	/**
	 * hipótesis de cual es la enfermedad que posee el paciente
	 */
	public String getHipotesisDiagnostico() {
		return hipotesisDiagnostico;
	}
	
	/**
	 * paciente con Garantías Explícitas en Salud
	 */
	public void setPacienteGes(String value) {
		this.pacienteGes = value;
	}
	
	/**
	 * paciente con Garantías Explícitas en Salud
	 */
	public String getPacienteGes() {
		return pacienteGes;
	}
	
	/**
	 * enfermedad que garantizada en el AUGE
	 */
	public void setPatologiaGes(String value) {
		this.patologiaGes = value;
	}
	
	/**
	 * enfermedad que garantizada en el AUGE
	 */
	public String getPatologiaGes() {
		return patologiaGes;
	}
	
	/**
	 * paciente con enfermedad con un tiempo mayor de seis meses desde que dicha enfermedad fue diagnosticada
	 */
	public void setPacienteCronico(String value) {
		this.pacienteCronico = value;
	}
	
	/**
	 * paciente con enfermedad con un tiempo mayor de seis meses desde que dicha enfermedad fue diagnosticada
	 */
	public String getPacienteCronico() {
		return pacienteCronico;
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
	
	public void setIdHce(orm.Hce value) {
		if (idHce != null) {
			idHce.rce.remove(this);
		}
		if (value != null) {
			value.rce.add(this);
		}
	}
	
	public orm.Hce getIdHce() {
		return idHce;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdHce(orm.Hce value) {
		this.idHce = value;
	}
	
	private orm.Hce getORM_IdHce() {
		return idHce;
	}
	
	public void setIdHoraMedica(orm.HoraMedica value) {
		if (idHoraMedica != null) {
			idHoraMedica.rce.remove(this);
		}
		if (value != null) {
			value.rce.add(this);
		}
	}
	
	public orm.HoraMedica getIdHoraMedica() {
		return idHoraMedica;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdHoraMedica(orm.HoraMedica value) {
		this.idHoraMedica = value;
	}
	
	private orm.HoraMedica getORM_IdHoraMedica() {
		return idHoraMedica;
	}
	
	private void setORM_Certificado(java.util.Set value) {
		this.ORM_certificado = value;
	}
	
	private java.util.Set getORM_Certificado() {
		return ORM_certificado;
	}
	
	public final orm.CertificadoSetCollection certificado = new orm.CertificadoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_RCE_CERTIFICADO, orm.ORMConstants.KEY_CERTIFICADO_RCEIDRCE, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Actividad(java.util.Set value) {
		this.ORM_actividad = value;
	}
	
	private java.util.Set getORM_Actividad() {
		return ORM_actividad;
	}
	
	public final orm.ActividadSetCollection actividad = new orm.ActividadSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_RCE_ACTIVIDAD, orm.ORMConstants.KEY_ACTIVIDAD_RCEIDRCE, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Procedimiento(java.util.Set value) {
		this.ORM_procedimiento = value;
	}
	
	private java.util.Set getORM_Procedimiento() {
		return ORM_procedimiento;
	}
	
	public final orm.ProcedimientoSetCollection procedimiento = new orm.ProcedimientoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_RCE_PROCEDIMIENTO, orm.ORMConstants.KEY_PROCEDIMIENTO_RCEIDRCE, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_DiagnosticoidDiagnostico(java.util.Set value) {
		this.ORM_diagnosticoidDiagnostico = value;
	}
	
	private java.util.Set getORM_DiagnosticoidDiagnostico() {
		return ORM_diagnosticoidDiagnostico;
	}
	
	public final orm.DiagnosticoSetCollection diagnosticoidDiagnostico = new orm.DiagnosticoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_RCE_DIAGNOSTICOIDDIAGNOSTICO, orm.ORMConstants.KEY_DIAGNOSTICO_RCEIDRCE, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Receta(java.util.Set value) {
		this.ORM_receta = value;
	}
	
	private java.util.Set getORM_Receta() {
		return ORM_receta;
	}
	
	public final orm.RecetaSetCollection receta = new orm.RecetaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_RCE_RECETA, orm.ORMConstants.KEY_RECETA_IDRCE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdRce());
	}
	
}
