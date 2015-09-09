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

public class PacienteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idPaciente;
	public final StringExpression nroFichaMedica;
	public final IntegerExpression idPersonaId;
	public final AssociationExpression idPersona;
	public final CollectionExpression reserva;
	public final IntegerExpression hceId;
	public final AssociationExpression hce;
	
	public PacienteDetachedCriteria() {
		super(orm.Paciente.class, orm.PacienteCriteria.class);
		idPaciente = new IntegerExpression("idPaciente", this.getDetachedCriteria());
		nroFichaMedica = new StringExpression("nroFichaMedica", this.getDetachedCriteria());
		idPersonaId = new IntegerExpression("idPersona.idPersona", this.getDetachedCriteria());
		idPersona = new AssociationExpression("idPersona", this.getDetachedCriteria());
		reserva = new CollectionExpression("ORM_Reserva", this.getDetachedCriteria());
		hceId = new IntegerExpression("hce.idPaciente", this.getDetachedCriteria());
		hce = new AssociationExpression("hce", this.getDetachedCriteria());
	}
	
	public PacienteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.PacienteCriteria.class);
		idPaciente = new IntegerExpression("idPaciente", this.getDetachedCriteria());
		nroFichaMedica = new StringExpression("nroFichaMedica", this.getDetachedCriteria());
		idPersonaId = new IntegerExpression("idPersona.idPersona", this.getDetachedCriteria());
		idPersona = new AssociationExpression("idPersona", this.getDetachedCriteria());
		reserva = new CollectionExpression("ORM_Reserva", this.getDetachedCriteria());
		hceId = new IntegerExpression("hce.idPaciente", this.getDetachedCriteria());
		hce = new AssociationExpression("hce", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria createIdPersonaCriteria() {
		return new PersonaDetachedCriteria(createCriteria("idPersona"));
	}
	
	public ReservaDetachedCriteria createReservaCriteria() {
		return new ReservaDetachedCriteria(createCriteria("ORM_Reserva"));
	}
	
	public HceDetachedCriteria createHceCriteria() {
		return new HceDetachedCriteria(createCriteria("hce"));
	}
	
	public Paciente uniquePaciente(PersistentSession session) {
		return (Paciente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Paciente[] listPaciente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Paciente[]) list.toArray(new Paciente[list.size()]);
	}
}

