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

public class EstablecimientoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final CollectionExpression medico;
	public final CollectionExpression horaMedica;
	public final CollectionExpression box;
	
	public EstablecimientoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		nombre = new StringExpression("nombre", this);
		medico = new CollectionExpression("ORM_Medico", this);
		horaMedica = new CollectionExpression("ORM_HoraMedica", this);
		box = new CollectionExpression("ORM_Box", this);
	}
	
	public EstablecimientoCriteria(PersistentSession session) {
		this(session.createCriteria(Establecimiento.class));
	}
	
	public EstablecimientoCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public MedicoCriteria createMedicoCriteria() {
		return new MedicoCriteria(createCriteria("ORM_Medico"));
	}
	
	public HoraMedicaCriteria createHoraMedicaCriteria() {
		return new HoraMedicaCriteria(createCriteria("ORM_HoraMedica"));
	}
	
	public BoxCriteria createBoxCriteria() {
		return new BoxCriteria(createCriteria("ORM_Box"));
	}
	
	public Establecimiento uniqueEstablecimiento() {
		return (Establecimiento) super.uniqueResult();
	}
	
	public Establecimiento[] listEstablecimiento() {
		java.util.List list = super.list();
		return (Establecimiento[]) list.toArray(new Establecimiento[list.size()]);
	}
}

