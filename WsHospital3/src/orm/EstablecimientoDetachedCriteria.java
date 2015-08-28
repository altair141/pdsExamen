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

public class EstablecimientoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression nombre;
	public final CollectionExpression medico;
	public final CollectionExpression horaMedica;
	public final CollectionExpression box;
	
	public EstablecimientoDetachedCriteria() {
		super(orm.Establecimiento.class, orm.EstablecimientoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		medico = new CollectionExpression("ORM_Medico", this.getDetachedCriteria());
		horaMedica = new CollectionExpression("ORM_HoraMedica", this.getDetachedCriteria());
		box = new CollectionExpression("ORM_Box", this.getDetachedCriteria());
	}
	
	public EstablecimientoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.EstablecimientoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		medico = new CollectionExpression("ORM_Medico", this.getDetachedCriteria());
		horaMedica = new CollectionExpression("ORM_HoraMedica", this.getDetachedCriteria());
		box = new CollectionExpression("ORM_Box", this.getDetachedCriteria());
	}
	
	public MedicoDetachedCriteria createMedicoCriteria() {
		return new MedicoDetachedCriteria(createCriteria("ORM_Medico"));
	}
	
	public HoraMedicaDetachedCriteria createHoraMedicaCriteria() {
		return new HoraMedicaDetachedCriteria(createCriteria("ORM_HoraMedica"));
	}
	
	public BoxDetachedCriteria createBoxCriteria() {
		return new BoxDetachedCriteria(createCriteria("ORM_Box"));
	}
	
	public Establecimiento uniqueEstablecimiento(PersistentSession session) {
		return (Establecimiento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Establecimiento[] listEstablecimiento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Establecimiento[]) list.toArray(new Establecimiento[list.size()]);
	}
}

