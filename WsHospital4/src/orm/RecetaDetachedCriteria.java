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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RecetaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression contenido;
	public final IntegerExpression idRceId;
	public final AssociationExpression idRce;
	
	public RecetaDetachedCriteria() {
		super(orm.Receta.class, orm.RecetaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		idRceId = new IntegerExpression("idRce.idRce", this.getDetachedCriteria());
		idRce = new AssociationExpression("idRce", this.getDetachedCriteria());
	}
	
	public RecetaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.RecetaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		contenido = new StringExpression("contenido", this.getDetachedCriteria());
		idRceId = new IntegerExpression("idRce.idRce", this.getDetachedCriteria());
		idRce = new AssociationExpression("idRce", this.getDetachedCriteria());
	}
	
	public RceDetachedCriteria createIdRceCriteria() {
		return new RceDetachedCriteria(createCriteria("idRce"));
	}
	
	public Receta uniqueReceta(PersistentSession session) {
		return (Receta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Receta[] listReceta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Receta[]) list.toArray(new Receta[list.size()]);
	}
}

