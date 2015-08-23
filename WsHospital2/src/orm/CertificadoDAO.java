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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class CertificadoDAO {
	public static Certificado loadCertificadoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCertificadoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado getCertificadoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getCertificadoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado loadCertificadoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCertificadoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado getCertificadoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getCertificadoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado loadCertificadoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Certificado) session.load(orm.Certificado.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado getCertificadoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Certificado) session.get(orm.Certificado.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado loadCertificadoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Certificado) session.load(orm.Certificado.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado getCertificadoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Certificado) session.get(orm.Certificado.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCertificado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryCertificado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCertificado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryCertificado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado[] listCertificadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listCertificadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado[] listCertificadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listCertificadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCertificado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Certificado as Certificado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCertificado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Certificado as Certificado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Certificado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado[] listCertificadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCertificado(session, condition, orderBy);
			return (Certificado[]) list.toArray(new Certificado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado[] listCertificadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCertificado(session, condition, orderBy, lockMode);
			return (Certificado[]) list.toArray(new Certificado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado loadCertificadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCertificadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado loadCertificadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCertificadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado loadCertificadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Certificado[] certificados = listCertificadoByQuery(session, condition, orderBy);
		if (certificados != null && certificados.length > 0)
			return certificados[0];
		else
			return null;
	}
	
	public static Certificado loadCertificadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Certificado[] certificados = listCertificadoByQuery(session, condition, orderBy, lockMode);
		if (certificados != null && certificados.length > 0)
			return certificados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCertificadoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateCertificadoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCertificadoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateCertificadoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCertificadoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Certificado as Certificado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCertificadoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Certificado as Certificado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Certificado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado createCertificado() {
		return new orm.Certificado();
	}
	
	public static boolean save(orm.Certificado certificado) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().saveObject(certificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Certificado certificado) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().deleteObject(certificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Certificado certificado)throws PersistentException {
		try {
			orm.Rce[] lRceidRces = certificado.rceidRce.toArray();
			for(int i = 0; i < lRceidRces.length; i++) {
				lRceidRces[i].certificado.remove(certificado);
			}
			return delete(certificado);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Certificado certificado, org.orm.PersistentSession session)throws PersistentException {
		try {
			orm.Rce[] lRceidRces = certificado.rceidRce.toArray();
			for(int i = 0; i < lRceidRces.length; i++) {
				lRceidRces[i].certificado.remove(certificado);
			}
			try {
				session.delete(certificado);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(orm.Certificado certificado) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().refresh(certificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Certificado certificado) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().evict(certificado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Certificado loadCertificadoByCriteria(CertificadoCriteria certificadoCriteria) {
		Certificado[] certificados = listCertificadoByCriteria(certificadoCriteria);
		if(certificados == null || certificados.length == 0) {
			return null;
		}
		return certificados[0];
	}
	
	public static Certificado[] listCertificadoByCriteria(CertificadoCriteria certificadoCriteria) {
		return certificadoCriteria.listCertificado();
	}
}
