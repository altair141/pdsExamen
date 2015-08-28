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

public class RceDAO {
	public static Rce loadRceByORMID(int idRce) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadRceByORMID(session, idRce);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce getRceByORMID(int idRce) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getRceByORMID(session, idRce);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce loadRceByORMID(int idRce, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadRceByORMID(session, idRce, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce getRceByORMID(int idRce, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getRceByORMID(session, idRce, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce loadRceByORMID(PersistentSession session, int idRce) throws PersistentException {
		try {
			return (Rce) session.load(orm.Rce.class, new Integer(idRce));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce getRceByORMID(PersistentSession session, int idRce) throws PersistentException {
		try {
			return (Rce) session.get(orm.Rce.class, new Integer(idRce));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce loadRceByORMID(PersistentSession session, int idRce, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Rce) session.load(orm.Rce.class, new Integer(idRce), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce getRceByORMID(PersistentSession session, int idRce, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Rce) session.get(orm.Rce.class, new Integer(idRce), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRce(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryRce(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRce(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryRce(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce[] listRceByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listRceByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce[] listRceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listRceByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryRce(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Rce as Rce");
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
	
	public static List queryRce(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Rce as Rce");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Rce", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce[] listRceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRce(session, condition, orderBy);
			return (Rce[]) list.toArray(new Rce[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce[] listRceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRce(session, condition, orderBy, lockMode);
			return (Rce[]) list.toArray(new Rce[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce loadRceByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadRceByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce loadRceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadRceByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce loadRceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Rce[] rces = listRceByQuery(session, condition, orderBy);
		if (rces != null && rces.length > 0)
			return rces[0];
		else
			return null;
	}
	
	public static Rce loadRceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Rce[] rces = listRceByQuery(session, condition, orderBy, lockMode);
		if (rces != null && rces.length > 0)
			return rces[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateRceByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateRceByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateRceByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateRceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Rce as Rce");
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
	
	public static java.util.Iterator iterateRceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Rce as Rce");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Rce", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce createRce() {
		return new orm.Rce();
	}
	
	public static boolean save(orm.Rce rce) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().saveObject(rce);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Rce rce) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().deleteObject(rce);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Rce rce)throws PersistentException {
		try {
			if(rce.getIdHce() != null) {
				rce.getIdHce().rce.remove(rce);
			}
			
			if(rce.getIdDiagnostico() != null) {
				rce.getIdDiagnostico().rce.remove(rce);
			}
			
			if(rce.getIdActividad() != null) {
				rce.getIdActividad().rce.remove(rce);
			}
			
			if(rce.getIdProcedimiento() != null) {
				rce.getIdProcedimiento().rce.remove(rce);
			}
			
			orm.Certificado[] lCertificados = rce.certificado.toArray();
			for(int i = 0; i < lCertificados.length; i++) {
				lCertificados[i].rceidRce.remove(rce);
			}
			return delete(rce);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Rce rce, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(rce.getIdHce() != null) {
				rce.getIdHce().rce.remove(rce);
			}
			
			if(rce.getIdDiagnostico() != null) {
				rce.getIdDiagnostico().rce.remove(rce);
			}
			
			if(rce.getIdActividad() != null) {
				rce.getIdActividad().rce.remove(rce);
			}
			
			if(rce.getIdProcedimiento() != null) {
				rce.getIdProcedimiento().rce.remove(rce);
			}
			
			orm.Certificado[] lCertificados = rce.certificado.toArray();
			for(int i = 0; i < lCertificados.length; i++) {
				lCertificados[i].rceidRce.remove(rce);
			}
			try {
				session.delete(rce);
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
	
	public static boolean refresh(orm.Rce rce) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().refresh(rce);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Rce rce) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().evict(rce);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Rce loadRceByCriteria(RceCriteria rceCriteria) {
		Rce[] rces = listRceByCriteria(rceCriteria);
		if(rces == null || rces.length == 0) {
			return null;
		}
		return rces[0];
	}
	
	public static Rce[] listRceByCriteria(RceCriteria rceCriteria) {
		return rceCriteria.listRce();
	}
}
