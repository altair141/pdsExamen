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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RecetaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression contenido;
	public final IntegerExpression idRceId;
	public final AssociationExpression idRce;
	
	public RecetaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		contenido = new StringExpression("contenido", this);
		idRceId = new IntegerExpression("idRce.idRce", this);
		idRce = new AssociationExpression("idRce", this);
	}
	
	public RecetaCriteria(PersistentSession session) {
		this(session.createCriteria(Receta.class));
	}
	
	public RecetaCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public RceCriteria createIdRceCriteria() {
		return new RceCriteria(createCriteria("idRce"));
	}
	
	public Receta uniqueReceta() {
		return (Receta) super.uniqueResult();
	}
	
	public Receta[] listReceta() {
		java.util.List list = super.list();
		return (Receta[]) list.toArray(new Receta[list.size()]);
	}
}

