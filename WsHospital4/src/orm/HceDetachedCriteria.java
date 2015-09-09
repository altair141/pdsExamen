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

public class HceDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idHce;
	public final IntegerExpression idPacienteId;
	public final AssociationExpression idPaciente;
	public final CollectionExpression rce;
	
	public HceDetachedCriteria() {
		super(orm.Hce.class, orm.HceCriteria.class);
		idHce = new IntegerExpression("idHce", this.getDetachedCriteria());
		idPacienteId = new IntegerExpression("idPaciente.idPaciente", this.getDetachedCriteria());
		idPaciente = new AssociationExpression("idPaciente", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
	}
	
	public HceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.HceCriteria.class);
		idHce = new IntegerExpression("idHce", this.getDetachedCriteria());
		idPacienteId = new IntegerExpression("idPaciente.idPaciente", this.getDetachedCriteria());
		idPaciente = new AssociationExpression("idPaciente", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
	}
	
	public PacienteDetachedCriteria createIdPacienteCriteria() {
		return new PacienteDetachedCriteria(createCriteria("idPaciente"));
	}
	
	public RceDetachedCriteria createRceCriteria() {
		return new RceDetachedCriteria(createCriteria("ORM_Rce"));
	}
	
	public Hce uniqueHce(PersistentSession session) {
		return (Hce) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Hce[] listHce(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Hce[]) list.toArray(new Hce[list.size()]);
	}
}

