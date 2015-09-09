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
 * procedimientos médicos
 */
public class Procedimiento {
	public Procedimiento() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_PROCEDIMIENTO_RCEIDRCE) {
			return ORM_rceidRce;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_PROCEDIMIENTO_IDDIAGNOSTICO) {
			this.idDiagnostico = (orm.Diagnostico) owner;
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
	
	private int id;
	
	private String tipoProcedimiento;
	
	private orm.Diagnostico idDiagnostico;
	
	private java.util.Set ORM_rceidRce = new java.util.HashSet();
	
	/**
	 * identificador del proceso medico
	 */
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * identificador del proceso medico
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * nombre del procedimiento realizado en el paciente
	 */
	public void setTipoProcedimiento(String value) {
		this.tipoProcedimiento = value;
	}
	
	/**
	 * nombre del procedimiento realizado en el paciente
	 */
	public String getTipoProcedimiento() {
		return tipoProcedimiento;
	}
	
	private void setORM_RceidRce(java.util.Set value) {
		this.ORM_rceidRce = value;
	}
	
	private java.util.Set getORM_RceidRce() {
		return ORM_rceidRce;
	}
	
	public final orm.RceSetCollection rceidRce = new orm.RceSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_PROCEDIMIENTO_RCEIDRCE, orm.ORMConstants.KEY_RCE_PROCEDIMIENTO, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setIdDiagnostico(orm.Diagnostico value) {
		if (idDiagnostico != null) {
			idDiagnostico.procedimiento.remove(this);
		}
		if (value != null) {
			value.procedimiento.add(this);
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
