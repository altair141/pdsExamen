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
 * tipo de reporte
 */
public class TipoReporte {
	public TipoReporte() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_TIPOREPORTE_REPORTE) {
			return ORM_reporte;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String tipo;
	
	private java.util.Set ORM_reporte = new java.util.HashSet();
	
	/**
	 * identificador del tipo de reporte
	 */
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * identificador del tipo de reporte
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * nombre del tipo de reporte
	 */
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	/**
	 * nombre del tipo de reporte
	 */
	public String getTipo() {
		return tipo;
	}
	
	private void setORM_Reporte(java.util.Set value) {
		this.ORM_reporte = value;
	}
	
	private java.util.Set getORM_Reporte() {
		return ORM_reporte;
	}
	
	public final orm.ReporteSetCollection reporte = new orm.ReporteSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_TIPOREPORTE_REPORTE, orm.ORMConstants.KEY_REPORTE_IDTIPOREPORTE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
