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

public class ActividadCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression tipoActividad;
	public final IntegerExpression idDiagnosticoId;
	public final AssociationExpression idDiagnostico;
	public final CollectionExpression rceidRce;
	
	public ActividadCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipoActividad = new StringExpression("tipoActividad", this);
		idDiagnosticoId = new IntegerExpression("idDiagnostico.idDiagnostico", this);
		idDiagnostico = new AssociationExpression("idDiagnostico", this);
		rceidRce = new CollectionExpression("ORM_RceidRce", this);
	}
	
	public ActividadCriteria(PersistentSession session) {
		this(session.createCriteria(Actividad.class));
	}
	
	public ActividadCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public DiagnosticoCriteria createIdDiagnosticoCriteria() {
		return new DiagnosticoCriteria(createCriteria("idDiagnostico"));
	}
	
	public RceCriteria createRceidRceCriteria() {
		return new RceCriteria(createCriteria("ORM_RceidRce"));
	}
	
	public Actividad uniqueActividad() {
		return (Actividad) super.uniqueResult();
	}
	
	public Actividad[] listActividad() {
		java.util.List list = super.list();
		return (Actividad[]) list.toArray(new Actividad[list.size()]);
	}
}

