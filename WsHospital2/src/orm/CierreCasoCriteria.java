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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CierreCasoCriteria extends AbstractORMCriteria {
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
	
	public CierreCasoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipoCierre = new StringExpression("tipoCierre", this);
		destino = new StringExpression("destino", this);
		fechaAtencion = new DateExpression("fechaAtencion", this);
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this);
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this);
		horaCierreClinico = new StringExpression("horaCierreClinico", this);
		tiempoControl = new StringExpression("tiempoControl", this);
		idRceId = new IntegerExpression("idRce.idRce", this);
		idRce = new AssociationExpression("idRce", this);
	}
	
	public CierreCasoCriteria(PersistentSession session) {
		this(session.createCriteria(CierreCaso.class));
	}
	
	public CierreCasoCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public RceCriteria createIdRceCriteria() {
		return new RceCriteria(createCriteria("idRce"));
	}
	
	public CierreCaso uniqueCierreCaso() {
		return (CierreCaso) super.uniqueResult();
	}
	
	public CierreCaso[] listCierreCaso() {
		java.util.List list = super.list();
		return (CierreCaso[]) list.toArray(new CierreCaso[list.size()]);
	}
}

