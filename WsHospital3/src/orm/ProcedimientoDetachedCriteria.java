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

public class ProcedimientoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression tipoProcedimiento;
	public final IntegerExpression idDiagnosticoId;
	public final AssociationExpression idDiagnostico;
	public final CollectionExpression rce;
	
	public ProcedimientoDetachedCriteria() {
		super(orm.Procedimiento.class, orm.ProcedimientoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoProcedimiento = new StringExpression("tipoProcedimiento", this.getDetachedCriteria());
		idDiagnosticoId = new IntegerExpression("idDiagnostico.idDiagnostico", this.getDetachedCriteria());
		idDiagnostico = new AssociationExpression("idDiagnostico", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
	}
	
	public ProcedimientoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ProcedimientoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoProcedimiento = new StringExpression("tipoProcedimiento", this.getDetachedCriteria());
		idDiagnosticoId = new IntegerExpression("idDiagnostico.idDiagnostico", this.getDetachedCriteria());
		idDiagnostico = new AssociationExpression("idDiagnostico", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
	}
	
	public DiagnosticoDetachedCriteria createIdDiagnosticoCriteria() {
		return new DiagnosticoDetachedCriteria(createCriteria("idDiagnostico"));
	}
	
	public RceDetachedCriteria createRceCriteria() {
		return new RceDetachedCriteria(createCriteria("ORM_Rce"));
	}
	
	public Procedimiento uniqueProcedimiento(PersistentSession session) {
		return (Procedimiento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Procedimiento[] listProcedimiento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Procedimiento[]) list.toArray(new Procedimiento[list.size()]);
	}
}

