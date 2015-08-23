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
 * registro clínico electrónico
 */
public class Rce {
	public Rce() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_RCE_CERTIFICADO) {
			return ORM_certificado;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_RCE_IDHCE) {
			this.idHce = (orm.Hce) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_RCE_IDACTIVIDAD) {
			this.idActividad = (orm.Actividad) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_RCE_IDPROCEDIMIENTO) {
			this.idProcedimiento = (orm.Procedimiento) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_RCE_IDDIAGNOSTICO) {
			this.idDiagnostico = (orm.Diagnostico) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_RCE_CIERRECASO) {
			this.cierreCaso = (orm.CierreCaso) owner;
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
	
	private String uuid;
	
	private orm.Hce idHce;
	
	private Integer idHoraMedica;
	
	private String anamnesis;
	
	private String alergia;
	
	private String examenFisico;
	
	private String indicacionMedica;
	
	private String indicacionCierreCaso;
	
	private String hipotesisDiagnostico;
	
	private String pacienteGes;
	
	private String patologiaGes;
	
	private String pacienteCronico;
	
	private String receta;
	
	private orm.Diagnostico idDiagnostico;
	
	private orm.Actividad idActividad;
	
	private orm.Procedimiento idProcedimiento;
	
	private java.util.Set ORM_certificado = new java.util.HashSet();
	
	private orm.CierreCaso cierreCaso;
	
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
	 * identificador único de rce
	 */
	public void setUuid(String value) {
		this.uuid = value;
	}
	
	/**
	 * identificador único de rce
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * identificar de la hora medica
	 */
	public void setIdHoraMedica(int value) {
		setIdHoraMedica(new Integer(value));
	}
	
	/**
	 * identificar de la hora medica
	 */
	public void setIdHoraMedica(Integer value) {
		this.idHoraMedica = value;
	}
	
	/**
	 * identificar de la hora medica
	 */
	public Integer getIdHoraMedica() {
		return idHoraMedica;
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
	 * transacción terapéutica entre el médico y su paciente
	 */
	public void setReceta(String value) {
		this.receta = value;
	}
	
	/**
	 * transacción terapéutica entre el médico y su paciente
	 */
	public String getReceta() {
		return receta;
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
	
	public void setIdActividad(orm.Actividad value) {
		if (idActividad != null) {
			idActividad.rce.remove(this);
		}
		if (value != null) {
			value.rce.add(this);
		}
	}
	
	public orm.Actividad getIdActividad() {
		return idActividad;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdActividad(orm.Actividad value) {
		this.idActividad = value;
	}
	
	private orm.Actividad getORM_IdActividad() {
		return idActividad;
	}
	
	public void setIdProcedimiento(orm.Procedimiento value) {
		if (idProcedimiento != null) {
			idProcedimiento.rce.remove(this);
		}
		if (value != null) {
			value.rce.add(this);
		}
	}
	
	public orm.Procedimiento getIdProcedimiento() {
		return idProcedimiento;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdProcedimiento(orm.Procedimiento value) {
		this.idProcedimiento = value;
	}
	
	private orm.Procedimiento getORM_IdProcedimiento() {
		return idProcedimiento;
	}
	
	public void setIdDiagnostico(orm.Diagnostico value) {
		if (idDiagnostico != null) {
			idDiagnostico.rce.remove(this);
		}
		if (value != null) {
			value.rce.add(this);
		}
	}
	
	public orm.Diagnostico getIdDiagnostico() {
		return idDiagnostico;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdDiagnostico(orm.Diagnostico value) {
		this.idDiagnostico = value;
	}
	
	private orm.Diagnostico getORM_IdDiagnostico() {
		return idDiagnostico;
	}
	
	private void setORM_Certificado(java.util.Set value) {
		this.ORM_certificado = value;
	}
	
	private java.util.Set getORM_Certificado() {
		return ORM_certificado;
	}
	
	public final orm.CertificadoSetCollection certificado = new orm.CertificadoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_RCE_CERTIFICADO, orm.ORMConstants.KEY_CERTIFICADO_RCEIDRCE, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setCierreCaso(orm.CierreCaso value) {
		if (this.cierreCaso != value) {
			orm.CierreCaso lcierreCaso = this.cierreCaso;
			this.cierreCaso = value;
			if (value != null) {
				cierreCaso.setIdRce(this);
			}
			if (lcierreCaso != null) {
				lcierreCaso.setIdRce(null);
			}
		}
	}
	
	public orm.CierreCaso getCierreCaso() {
		return cierreCaso;
	}
	
	public String toString() {
		return String.valueOf(getIdRce());
	}
	
}
