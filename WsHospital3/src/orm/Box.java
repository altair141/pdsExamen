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
 * habitación del hospital
 */
public class Box {
	public Box() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_BOX_HORAMEDICA) {
			return ORM_horaMedica;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_BOX_IDESTABLECIMIENTO) {
			this.idEstablecimiento = (orm.Establecimiento) owner;
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
	
	private int idHabitacion;
	
	private String nroHabitacion;
	
	private orm.Establecimiento idEstablecimiento;
	
	private java.util.Set ORM_horaMedica = new java.util.HashSet();
	
	/**
	 * identificador del box
	 */
	private void setIdHabitacion(int value) {
		this.idHabitacion = value;
	}
	
	/**
	 * identificador del box
	 */
	public int getIdHabitacion() {
		return idHabitacion;
	}
	
	public int getORMID() {
		return getIdHabitacion();
	}
	
	/**
	 * número de la habitación
	 */
	public void setNroHabitacion(String value) {
		this.nroHabitacion = value;
	}
	
	/**
	 * número de la habitación
	 */
	public String getNroHabitacion() {
		return nroHabitacion;
	}
	
	public void setIdEstablecimiento(orm.Establecimiento value) {
		if (idEstablecimiento != null) {
			idEstablecimiento.box.remove(this);
		}
		if (value != null) {
			value.box.add(this);
		}
	}
	
	public orm.Establecimiento getIdEstablecimiento() {
		return idEstablecimiento;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdEstablecimiento(orm.Establecimiento value) {
		this.idEstablecimiento = value;
	}
	
	private orm.Establecimiento getORM_IdEstablecimiento() {
		return idEstablecimiento;
	}
	
	private void setORM_HoraMedica(java.util.Set value) {
		this.ORM_horaMedica = value;
	}
	
	private java.util.Set getORM_HoraMedica() {
		return ORM_horaMedica;
	}
	
	public final orm.HoraMedicaSetCollection horaMedica = new orm.HoraMedicaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_BOX_HORAMEDICA, orm.ORMConstants.KEY_HORAMEDICA_IDBOX, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIdHabitacion());
	}
	
}
