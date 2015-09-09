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

public class DiagnosticoCriteria extends AbstractORMCriteria {
	public final IntegerExpression idDiagnostico;
	public final StringExpression nombre;
	public final CollectionExpression rceidRce;
	public final CollectionExpression actividad;
	public final CollectionExpression procedimiento;
	
	public DiagnosticoCriteria(Criteria criteria) {
		super(criteria);
		idDiagnostico = new IntegerExpression("idDiagnostico", this);
		nombre = new StringExpression("nombre", this);
		rceidRce = new CollectionExpression("ORM_RceidRce", this);
		actividad = new CollectionExpression("ORM_Actividad", this);
		procedimiento = new CollectionExpression("ORM_Procedimiento", this);
	}
	
	public DiagnosticoCriteria(PersistentSession session) {
		this(session.createCriteria(Diagnostico.class));
	}
	
	public DiagnosticoCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public RceCriteria createRceidRceCriteria() {
		return new RceCriteria(createCriteria("ORM_RceidRce"));
	}
	
	public ActividadCriteria createActividadCriteria() {
		return new ActividadCriteria(createCriteria("ORM_Actividad"));
	}
	
	public ProcedimientoCriteria createProcedimientoCriteria() {
		return new ProcedimientoCriteria(createCriteria("ORM_Procedimiento"));
	}
	
	public Diagnostico uniqueDiagnostico() {
		return (Diagnostico) super.uniqueResult();
	}
	
	public Diagnostico[] listDiagnostico() {
		java.util.List list = super.list();
		return (Diagnostico[]) list.toArray(new Diagnostico[list.size()]);
	}
}

