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

public class CertificadoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression tipoCertificado;
	public final CollectionExpression rceidRce;
	
	public CertificadoDetachedCriteria() {
		super(orm.Certificado.class, orm.CertificadoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoCertificado = new StringExpression("tipoCertificado", this.getDetachedCriteria());
		rceidRce = new CollectionExpression("ORM_RceidRce", this.getDetachedCriteria());
	}
	
	public CertificadoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.CertificadoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipoCertificado = new StringExpression("tipoCertificado", this.getDetachedCriteria());
		rceidRce = new CollectionExpression("ORM_RceidRce", this.getDetachedCriteria());
	}
	
	public RceDetachedCriteria createRceidRceCriteria() {
		return new RceDetachedCriteria(createCriteria("ORM_RceidRce"));
	}
	
	public Certificado uniqueCertificado(PersistentSession session) {
		return (Certificado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Certificado[] listCertificado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Certificado[]) list.toArray(new Certificado[list.size()]);
	}
}

