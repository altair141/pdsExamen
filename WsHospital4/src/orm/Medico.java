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
 * médico
 */
public class Medico {
	public Medico() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_MEDICO_HORAMEDICA) {
			return ORM_horaMedica;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_MEDICO_ESPECIALIDAD) {
			this.especialidad = (orm.Especialidad) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_MEDICO_IDPERSONA) {
			this.idPersona = (orm.Persona) owner;
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
	
	private int idMedico;
	
	private orm.Especialidad especialidad;
	
	private orm.Persona idPersona;
	
	private java.util.Set ORM_horaMedica = new java.util.HashSet();
	
	/**
	 * identificadorMedico
	 */
	private void setIdMedico(int value) {
		this.idMedico = value;
	}
	
	/**
	 * identificadorMedico
	 */
	public int getIdMedico() {
		return idMedico;
	}
	
	public int getORMID() {
		return getIdMedico();
	}
	
	public void setEspecialidad(orm.Especialidad value) {
		if (especialidad != null) {
			especialidad.medico.remove(this);
		}
		if (value != null) {
			value.medico.add(this);
		}
	}
	
	public orm.Especialidad getEspecialidad() {
		return especialidad;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Especialidad(orm.Especialidad value) {
		this.especialidad = value;
	}
	
	private orm.Especialidad getORM_Especialidad() {
		return especialidad;
	}
	
	public void setIdPersona(orm.Persona value) {
		if (this.idPersona != value) {
			orm.Persona lidPersona = this.idPersona;
			this.idPersona = value;
			if (value != null) {
				idPersona.setMedico(this);
			}
			if (lidPersona != null && lidPersona.getMedico() == this) {
				lidPersona.setMedico(null);
			}
		}
	}
	
	public orm.Persona getIdPersona() {
		return idPersona;
	}
	
	private void setORM_HoraMedica(java.util.Set value) {
		this.ORM_horaMedica = value;
	}
	
	private java.util.Set getORM_HoraMedica() {
		return ORM_horaMedica;
	}
	
	public final orm.HoraMedicaSetCollection horaMedica = new orm.HoraMedicaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_MEDICO_HORAMEDICA, orm.ORMConstants.KEY_HORAMEDICA_IDMEDICO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdMedico());
	}
	
}
