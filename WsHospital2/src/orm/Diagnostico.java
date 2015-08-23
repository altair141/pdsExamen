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
 * diagnostico médico
 */
public class Diagnostico {
	public Diagnostico() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_DIAGNOSTICO_RCE) {
			return ORM_rce;
		}
		else if (key == orm.ORMConstants.KEY_DIAGNOSTICO_ACTIVIDAD) {
			return ORM_actividad;
		}
		else if (key == orm.ORMConstants.KEY_DIAGNOSTICO_PROCEDIMIENTO) {
			return ORM_procedimiento;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idDiagnostico;
	
	private String nombre;
	
	private String uuid;
	
	private java.util.Set ORM_rce = new java.util.HashSet();
	
	private java.util.Set ORM_actividad = new java.util.HashSet();
	
	private java.util.Set ORM_procedimiento = new java.util.HashSet();
	
	/**
	 * identificador del diagnostico
	 */
	private void setIdDiagnostico(int value) {
		this.idDiagnostico = value;
	}
	
	/**
	 * identificador del diagnostico
	 */
	public int getIdDiagnostico() {
		return idDiagnostico;
	}
	
	public int getORMID() {
		return getIdDiagnostico();
	}
	
	/**
	 * nombre del diagnostico
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 * nombre del diagnostico
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * identificador del diagnostico en openmrs
	 */
	public void setUuid(String value) {
		this.uuid = value;
	}
	
	/**
	 * identificador del diagnostico en openmrs
	 */
	public String getUuid() {
		return uuid;
	}
	
	private void setORM_Rce(java.util.Set value) {
		this.ORM_rce = value;
	}
	
	private java.util.Set getORM_Rce() {
		return ORM_rce;
	}
	
	public final orm.RceSetCollection rce = new orm.RceSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_DIAGNOSTICO_RCE, orm.ORMConstants.KEY_RCE_IDDIAGNOSTICO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Actividad(java.util.Set value) {
		this.ORM_actividad = value;
	}
	
	private java.util.Set getORM_Actividad() {
		return ORM_actividad;
	}
	
	public final orm.ActividadSetCollection actividad = new orm.ActividadSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_DIAGNOSTICO_ACTIVIDAD, orm.ORMConstants.KEY_ACTIVIDAD_IDDIAGNOSTICO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Procedimiento(java.util.Set value) {
		this.ORM_procedimiento = value;
	}
	
	private java.util.Set getORM_Procedimiento() {
		return ORM_procedimiento;
	}
	
	public final orm.ProcedimientoSetCollection procedimiento = new orm.ProcedimientoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_DIAGNOSTICO_PROCEDIMIENTO, orm.ORMConstants.KEY_PROCEDIMIENTO_IDDIAGNOSTICO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdDiagnostico());
	}
	
}
