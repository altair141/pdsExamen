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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BoxCriteria extends AbstractORMCriteria {
	public final IntegerExpression idHabitacion;
	public final StringExpression nroHabitacion;
	public final IntegerExpression idEstablecimientoId;
	public final AssociationExpression idEstablecimiento;
	public final CollectionExpression horaMedica;
	
	public BoxCriteria(Criteria criteria) {
		super(criteria);
		idHabitacion = new IntegerExpression("idHabitacion", this);
		nroHabitacion = new StringExpression("nroHabitacion", this);
		idEstablecimientoId = new IntegerExpression("idEstablecimiento.id", this);
		idEstablecimiento = new AssociationExpression("idEstablecimiento", this);
		horaMedica = new CollectionExpression("ORM_HoraMedica", this);
	}
	
	public BoxCriteria(PersistentSession session) {
		this(session.createCriteria(Box.class));
	}
	
	public BoxCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public EstablecimientoCriteria createIdEstablecimientoCriteria() {
		return new EstablecimientoCriteria(createCriteria("idEstablecimiento"));
	}
	
	public HoraMedicaCriteria createHoraMedicaCriteria() {
		return new HoraMedicaCriteria(createCriteria("ORM_HoraMedica"));
	}
	
	public Box uniqueBox() {
		return (Box) super.uniqueResult();
	}
	
	public Box[] listBox() {
		java.util.List list = super.list();
		return (Box[]) list.toArray(new Box[list.size()]);
	}
}

