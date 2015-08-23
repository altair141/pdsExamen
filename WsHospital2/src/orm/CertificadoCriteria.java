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

public class CertificadoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression tipoCertificado;
	public final CollectionExpression rceidRce;
	
	public CertificadoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipoCertificado = new StringExpression("tipoCertificado", this);
		rceidRce = new CollectionExpression("ORM_RceidRce", this);
	}
	
	public CertificadoCriteria(PersistentSession session) {
		this(session.createCriteria(Certificado.class));
	}
	
	public CertificadoCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public RceCriteria createRceidRceCriteria() {
		return new RceCriteria(createCriteria("ORM_RceidRce"));
	}
	
	public Certificado uniqueCertificado() {
		return (Certificado) super.uniqueResult();
	}
	
	public Certificado[] listCertificado() {
		java.util.List list = super.list();
		return (Certificado[]) list.toArray(new Certificado[list.size()]);
	}
}

