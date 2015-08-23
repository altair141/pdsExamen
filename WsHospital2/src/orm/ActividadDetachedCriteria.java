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

public class ActividadDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression tipoActividad;
	public final IntegerExpression idDiagnosticoId;
	public final AssociationExpression idDiagnostico;
	public final CollectionExpression rce;
	
	public ActividadDetachedCriteria() {
		super(orm.Actividad.class, orm.ActividadCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoActividad = new StringExpression("tipoActividad", this.getDetachedCriteria());
		idDiagnosticoId = new IntegerExpression("idDiagnostico.idDiagnostico", this.getDetachedCriteria());
		idDiagnostico = new AssociationExpression("idDiagnostico", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
	}
	
	public ActividadDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ActividadCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoActividad = new StringExpression("tipoActividad", this.getDetachedCriteria());
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
	
	public Actividad uniqueActividad(PersistentSession session) {
		return (Actividad) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Actividad[] listActividad(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Actividad[]) list.toArray(new Actividad[list.size()]);
	}
}

