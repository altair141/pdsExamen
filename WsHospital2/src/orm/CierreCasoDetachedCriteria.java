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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CierreCasoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression tipoCierre;
	public final StringExpression destino;
	public final DateExpression fechaAtencion;
	public final StringExpression horaInicioAtencion;
	public final DateExpression fechaCierreClinico;
	public final StringExpression horaCierreClinico;
	public final StringExpression tiempoControl;
	public final IntegerExpression idRceId;
	public final AssociationExpression idRce;
	
	public CierreCasoDetachedCriteria() {
		super(orm.CierreCaso.class, orm.CierreCasoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoCierre = new StringExpression("tipoCierre", this.getDetachedCriteria());
		destino = new StringExpression("destino", this.getDetachedCriteria());
		fechaAtencion = new DateExpression("fechaAtencion", this.getDetachedCriteria());
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this.getDetachedCriteria());
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this.getDetachedCriteria());
		horaCierreClinico = new StringExpression("horaCierreClinico", this.getDetachedCriteria());
		tiempoControl = new StringExpression("tiempoControl", this.getDetachedCriteria());
		idRceId = new IntegerExpression("idRce.idRce", this.getDetachedCriteria());
		idRce = new AssociationExpression("idRce", this.getDetachedCriteria());
	}
	
	public CierreCasoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.CierreCasoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoCierre = new StringExpression("tipoCierre", this.getDetachedCriteria());
		destino = new StringExpression("destino", this.getDetachedCriteria());
		fechaAtencion = new DateExpression("fechaAtencion", this.getDetachedCriteria());
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this.getDetachedCriteria());
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this.getDetachedCriteria());
		horaCierreClinico = new StringExpression("horaCierreClinico", this.getDetachedCriteria());
		tiempoControl = new StringExpression("tiempoControl", this.getDetachedCriteria());
		idRceId = new IntegerExpression("idRce.idRce", this.getDetachedCriteria());
		idRce = new AssociationExpression("idRce", this.getDetachedCriteria());
	}
	
	public RceDetachedCriteria createIdRceCriteria() {
		return new RceDetachedCriteria(createCriteria("idRce"));
	}
	
	public CierreCaso uniqueCierreCaso(PersistentSession session) {
		return (CierreCaso) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public CierreCaso[] listCierreCaso(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (CierreCaso[]) list.toArray(new CierreCaso[list.size()]);
	}
}

