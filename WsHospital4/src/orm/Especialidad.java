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
 * especialidad del médico
 */
public class Especialidad {
	public Especialidad() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_ESPECIALIDAD_MEDICO) {
			return ORM_medico;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idEspecialidad;
	
	private String nombreEspecialidad;
	
	private java.util.Set ORM_medico = new java.util.HashSet();
	
	/**
	 * identificador especialidad
	 */
	private void setIdEspecialidad(int value) {
		this.idEspecialidad = value;
	}
	
	/**
	 * identificador especialidad
	 */
	public int getIdEspecialidad() {
		return idEspecialidad;
	}
	
	public int getORMID() {
		return getIdEspecialidad();
	}
	
	/**
	 * nombre de la especialidad de un médico
	 */
	public void setNombreEspecialidad(String value) {
		this.nombreEspecialidad = value;
	}
	
	/**
	 * nombre de la especialidad de un médico
	 */
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	
	private void setORM_Medico(java.util.Set value) {
		this.ORM_medico = value;
	}
	
	private java.util.Set getORM_Medico() {
		return ORM_medico;
	}
	
	public final orm.MedicoSetCollection medico = new orm.MedicoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_ESPECIALIDAD_MEDICO, orm.ORMConstants.KEY_MEDICO_ESPECIALIDAD, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdEspecialidad());
	}
	
}
