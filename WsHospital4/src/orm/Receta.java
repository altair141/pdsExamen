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

public class Receta {
	public Receta() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_RECETA_IDRCE) {
			this.idRce = (orm.Rce) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private String contenido;
	
	private orm.Rce idRce;
	
	/**
	 * identificador receta
	 */
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * identificador receta
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * contenido de la receta
	 */
	public void setContenido(String value) {
		this.contenido = value;
	}
	
	/**
	 * contenido de la receta
	 */
	public String getContenido() {
		return contenido;
	}
	
	public void setIdRce(orm.Rce value) {
		if (idRce != null) {
			idRce.receta.remove(this);
		}
		if (value != null) {
			value.receta.add(this);
		}
	}
	
	public orm.Rce getIdRce() {
		return idRce;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdRce(orm.Rce value) {
		this.idRce = value;
	}
	
	private orm.Rce getORM_IdRce() {
		return idRce;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
