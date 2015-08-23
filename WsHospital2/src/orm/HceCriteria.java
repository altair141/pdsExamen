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

public class HceCriteria extends AbstractORMCriteria {
	public final IntegerExpression idHce;
	public final IntegerExpression idPacienteId;
	public final AssociationExpression idPaciente;
	public final CollectionExpression rce;
	
	public HceCriteria(Criteria criteria) {
		super(criteria);
		idHce = new IntegerExpression("idHce", this);
		idPacienteId = new IntegerExpression("idPaciente.idPaciente", this);
		idPaciente = new AssociationExpression("idPaciente", this);
		rce = new CollectionExpression("ORM_Rce", this);
	}
	
	public HceCriteria(PersistentSession session) {
		this(session.createCriteria(Hce.class));
	}
	
	public HceCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public PacienteCriteria createIdPacienteCriteria() {
		return new PacienteCriteria(createCriteria("idPaciente"));
	}
	
	public RceCriteria createRceCriteria() {
		return new RceCriteria(createCriteria("ORM_Rce"));
	}
	
	public Hce uniqueHce() {
		return (Hce) super.uniqueResult();
	}
	
	public Hce[] listHce() {
		java.util.List list = super.list();
		return (Hce[]) list.toArray(new Hce[list.size()]);
	}
}

