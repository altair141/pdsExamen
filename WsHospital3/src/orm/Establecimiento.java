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

public class Establecimiento {
	public Establecimiento() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_ESTABLECIMIENTO_MEDICO) {
			return ORM_medico;
		}
		else if (key == orm.ORMConstants.KEY_ESTABLECIMIENTO_HORAMEDICA) {
			return ORM_horaMedica;
		}
		else if (key == orm.ORMConstants.KEY_ESTABLECIMIENTO_BOX) {
			return ORM_box;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String nombre;
	
	private java.util.Set ORM_medico = new java.util.HashSet();
	
	private java.util.Set ORM_horaMedica = new java.util.HashSet();
	
	private java.util.Set ORM_box = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * nombre del establecimiento
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 * nombre del establecimiento
	 */
	public String getNombre() {
		return nombre;
	}
	
	private void setORM_Medico(java.util.Set value) {
		this.ORM_medico = value;
	}
	
	private java.util.Set getORM_Medico() {
		return ORM_medico;
	}
	
	public final orm.MedicoSetCollection medico = new orm.MedicoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_ESTABLECIMIENTO_MEDICO, orm.ORMConstants.KEY_MEDICO_IDESTABLECIMIENTO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_HoraMedica(java.util.Set value) {
		this.ORM_horaMedica = value;
	}
	
	private java.util.Set getORM_HoraMedica() {
		return ORM_horaMedica;
	}
	
	public final orm.HoraMedicaSetCollection horaMedica = new orm.HoraMedicaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_ESTABLECIMIENTO_HORAMEDICA, orm.ORMConstants.KEY_HORAMEDICA_IDESTABLECIMIENTO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Box(java.util.Set value) {
		this.ORM_box = value;
	}
	
	private java.util.Set getORM_Box() {
		return ORM_box;
	}
	
	public final orm.BoxSetCollection box = new orm.BoxSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_ESTABLECIMIENTO_BOX, orm.ORMConstants.KEY_BOX_IDESTABLECIMIENTO, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
