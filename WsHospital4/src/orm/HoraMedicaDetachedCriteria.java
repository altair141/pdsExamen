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

public class HoraMedicaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idHora;
	public final IntegerExpression idMedicoId;
	public final AssociationExpression idMedico;
	public final IntegerExpression idBoxId;
	public final AssociationExpression idBox;
	public final StringExpression asp;
	public final TimestampExpression fecha;
	public final IntegerExpression reservaId;
	public final AssociationExpression reserva;
	public final CollectionExpression rce;
	
	public HoraMedicaDetachedCriteria() {
		super(orm.HoraMedica.class, orm.HoraMedicaCriteria.class);
		idHora = new IntegerExpression("idHora", this.getDetachedCriteria());
		idMedicoId = new IntegerExpression("idMedico.idMedico", this.getDetachedCriteria());
		idMedico = new AssociationExpression("idMedico", this.getDetachedCriteria());
		idBoxId = new IntegerExpression("idBox.idHabitacion", this.getDetachedCriteria());
		idBox = new AssociationExpression("idBox", this.getDetachedCriteria());
		asp = new StringExpression("asp", this.getDetachedCriteria());
		fecha = new TimestampExpression("fecha", this.getDetachedCriteria());
		reservaId = new IntegerExpression("reserva.idHora", this.getDetachedCriteria());
		reserva = new AssociationExpression("reserva", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
	}
	
	public HoraMedicaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.HoraMedicaCriteria.class);
		idHora = new IntegerExpression("idHora", this.getDetachedCriteria());
		idMedicoId = new IntegerExpression("idMedico.idMedico", this.getDetachedCriteria());
		idMedico = new AssociationExpression("idMedico", this.getDetachedCriteria());
		idBoxId = new IntegerExpression("idBox.idHabitacion", this.getDetachedCriteria());
		idBox = new AssociationExpression("idBox", this.getDetachedCriteria());
		asp = new StringExpression("asp", this.getDetachedCriteria());
		fecha = new TimestampExpression("fecha", this.getDetachedCriteria());
		reservaId = new IntegerExpression("reserva.idHora", this.getDetachedCriteria());
		reserva = new AssociationExpression("reserva", this.getDetachedCriteria());
		rce = new CollectionExpression("ORM_Rce", this.getDetachedCriteria());
	}
	
	public MedicoDetachedCriteria createIdMedicoCriteria() {
		return new MedicoDetachedCriteria(createCriteria("idMedico"));
	}
	
	public BoxDetachedCriteria createIdBoxCriteria() {
		return new BoxDetachedCriteria(createCriteria("idBox"));
	}
	
	public ReservaDetachedCriteria createReservaCriteria() {
		return new ReservaDetachedCriteria(createCriteria("reserva"));
	}
	
	public RceDetachedCriteria createRceCriteria() {
		return new RceDetachedCriteria(createCriteria("ORM_Rce"));
	}
	
	public HoraMedica uniqueHoraMedica(PersistentSession session) {
		return (HoraMedica) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public HoraMedica[] listHoraMedica(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (HoraMedica[]) list.toArray(new HoraMedica[list.size()]);
	}
}

