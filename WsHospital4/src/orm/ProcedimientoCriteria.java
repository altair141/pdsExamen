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

public class ProcedimientoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression tipoProcedimiento;
	public final IntegerExpression idDiagnosticoId;
	public final AssociationExpression idDiagnostico;
	public final CollectionExpression rceidRce;
	
	public ProcedimientoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipoProcedimiento = new StringExpression("tipoProcedimiento", this);
		idDiagnosticoId = new IntegerExpression("idDiagnostico.idDiagnostico", this);
		idDiagnostico = new AssociationExpression("idDiagnostico", this);
		rceidRce = new CollectionExpression("ORM_RceidRce", this);
	}
	
	public ProcedimientoCriteria(PersistentSession session) {
		this(session.createCriteria(Procedimiento.class));
	}
	
	public ProcedimientoCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public DiagnosticoCriteria createIdDiagnosticoCriteria() {
		return new DiagnosticoCriteria(createCriteria("idDiagnostico"));
	}
	
	public RceCriteria createRceidRceCriteria() {
		return new RceCriteria(createCriteria("ORM_RceidRce"));
	}
	
	public Procedimiento uniqueProcedimiento() {
		return (Procedimiento) super.uniqueResult();
	}
	
	public Procedimiento[] listProcedimiento() {
		java.util.List list = super.list();
		return (Procedimiento[]) list.toArray(new Procedimiento[list.size()]);
	}
}

