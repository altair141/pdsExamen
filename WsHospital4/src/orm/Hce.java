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
 * historial clínico electrónico
 */
public class Hce {
	public Hce() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_HCE_RCE) {
			return ORM_rce;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idHce;
	
	private orm.Paciente idPaciente;
	
	private java.util.Set ORM_rce = new java.util.HashSet();
	
	private void setIdHce(int value) {
		this.idHce = value;
	}
	
	public int getIdHce() {
		return idHce;
	}
	
	public int getORMID() {
		return getIdHce();
	}
	
	public void setIdPaciente(orm.Paciente value) {
		if (this.idPaciente != value) {
			orm.Paciente lidPaciente = this.idPaciente;
			this.idPaciente = value;
			if (value != null) {
				idPaciente.setHce(this);
			}
			if (lidPaciente != null && lidPaciente.getHce() == this) {
				lidPaciente.setHce(null);
			}
		}
	}
	
	public orm.Paciente getIdPaciente() {
		return idPaciente;
	}
	
	private void setORM_Rce(java.util.Set value) {
		this.ORM_rce = value;
	}
	
	private java.util.Set getORM_Rce() {
		return ORM_rce;
	}
	
	public final orm.RceSetCollection rce = new orm.RceSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_HCE_RCE, orm.ORMConstants.KEY_RCE_IDHCE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdHce());
	}
	
}
