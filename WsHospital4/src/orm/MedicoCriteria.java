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

public class MedicoCriteria extends AbstractORMCriteria {
	public final IntegerExpression idMedico;
	public final IntegerExpression especialidadId;
	public final AssociationExpression especialidad;
	public final IntegerExpression idPersonaId;
	public final AssociationExpression idPersona;
	public final CollectionExpression horaMedica;
	
	public MedicoCriteria(Criteria criteria) {
		super(criteria);
		idMedico = new IntegerExpression("idMedico", this);
		especialidadId = new IntegerExpression("especialidad.idEspecialidad", this);
		especialidad = new AssociationExpression("especialidad", this);
		idPersonaId = new IntegerExpression("idPersona.idPersona", this);
		idPersona = new AssociationExpression("idPersona", this);
		horaMedica = new CollectionExpression("ORM_HoraMedica", this);
	}
	
	public MedicoCriteria(PersistentSession session) {
		this(session.createCriteria(Medico.class));
	}
	
	public MedicoCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public EspecialidadCriteria createEspecialidadCriteria() {
		return new EspecialidadCriteria(createCriteria("especialidad"));
	}
	
	public PersonaCriteria createIdPersonaCriteria() {
		return new PersonaCriteria(createCriteria("idPersona"));
	}
	
	public HoraMedicaCriteria createHoraMedicaCriteria() {
		return new HoraMedicaCriteria(createCriteria("ORM_HoraMedica"));
	}
	
	public Medico uniqueMedico() {
		return (Medico) super.uniqueResult();
	}
	
	public Medico[] listMedico() {
		java.util.List list = super.list();
		return (Medico[]) list.toArray(new Medico[list.size()]);
	}
}

