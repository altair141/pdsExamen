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

public class EspecialidadCriteria extends AbstractORMCriteria {
	public final IntegerExpression idEspecialidad;
	public final StringExpression nombreEspecialidad;
	public final CollectionExpression medico;
	
	public EspecialidadCriteria(Criteria criteria) {
		super(criteria);
		idEspecialidad = new IntegerExpression("idEspecialidad", this);
		nombreEspecialidad = new StringExpression("nombreEspecialidad", this);
		medico = new CollectionExpression("ORM_Medico", this);
	}
	
	public EspecialidadCriteria(PersistentSession session) {
		this(session.createCriteria(Especialidad.class));
	}
	
	public EspecialidadCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public MedicoCriteria createMedicoCriteria() {
		return new MedicoCriteria(createCriteria("ORM_Medico"));
	}
	
	public Especialidad uniqueEspecialidad() {
		return (Especialidad) super.uniqueResult();
	}
	
	public Especialidad[] listEspecialidad() {
		java.util.List list = super.list();
		return (Especialidad[]) list.toArray(new Especialidad[list.size()]);
	}
}

