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
 * certificados
 */
public class Certificado {
	public Certificado() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_CERTIFICADO_RCEIDRCE) {
			return ORM_rceidRce;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String tipoCertificado;
	
	private java.util.Set ORM_rceidRce = new java.util.HashSet();
	
	/**
	 * identificador del certificado
	 */
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * identificador del certificado
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * tipo de certificado
	 */
	public void setTipoCertificado(String value) {
		this.tipoCertificado = value;
	}
	
	/**
	 * tipo de certificado
	 */
	public String getTipoCertificado() {
		return tipoCertificado;
	}
	
	private void setORM_RceidRce(java.util.Set value) {
		this.ORM_rceidRce = value;
	}
	
	private java.util.Set getORM_RceidRce() {
		return ORM_rceidRce;
	}
	
	public final orm.RceSetCollection rceidRce = new orm.RceSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_CERTIFICADO_RCEIDRCE, orm.ORMConstants.KEY_RCE_CERTIFICADO, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
