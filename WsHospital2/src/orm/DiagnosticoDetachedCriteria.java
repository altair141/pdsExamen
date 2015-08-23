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

public class DiagnosticoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idDiagnostico;
	public final StringExpression nombre;
	public final StringExpression uuid;
	public final CollectionExpression rce;
	public final CollectionExpression actividad;
	public final CollectionExpression procedimiento;
	
	public DiagnosticoDetachedCriteria() {
		super(orm.Diagnostico.class, orm.DiagnosticoCriteria.class);
		idDiagnostico = new IntegerExpression("idDiagnostico", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
		actividad = new CollectionExpression("ORM_Actividad", this.getDetachedCriteria());
		procedimiento = new CollectionExpression("ORM_Procedimiento", this.getDetachedCriteria());
	}
	
	public DiagnosticoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.DiagnosticoCriteria.class);
		idDiagnostico = new IntegerExpression("idDiagnostico", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
		actividad = new CollectionExpression("ORM_Actividad", this.getDetachedCriteria());
		procedimiento = new CollectionExpression("ORM_Procedimiento", this.getDetachedCriteria());
	}
	
	public RceDetachedCriteria createRceCriteria() {
		return new RceDetachedCriteria(createCriteria("ORM_Rce"));
	}
	
	public ActividadDetachedCriteria createActividadCriteria() {
		return new ActividadDetachedCriteria(createCriteria("ORM_Actividad"));
	}
	
	public ProcedimientoDetachedCriteria createProcedimientoCriteria() {
		return new ProcedimientoDetachedCriteria(createCriteria("ORM_Procedimiento"));
	}
	
	public Diagnostico uniqueDiagnostico(PersistentSession session) {
		return (Diagnostico) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Diagnostico[] listDiagnostico(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Diagnostico[]) list.toArray(new Diagnostico[list.size()]);
	}
}

