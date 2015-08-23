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

public class CierreCasoDAO {
	public static CierreCaso loadCierreCasoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCierreCasoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso getCierreCasoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getCierreCasoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso loadCierreCasoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCierreCasoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso getCierreCasoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getCierreCasoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso loadCierreCasoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (CierreCaso) session.load(orm.CierreCaso.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso getCierreCasoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (CierreCaso) session.get(orm.CierreCaso.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso loadCierreCasoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CierreCaso) session.load(orm.CierreCaso.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso getCierreCasoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CierreCaso) session.get(orm.CierreCaso.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCierreCaso(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryCierreCaso(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCierreCaso(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryCierreCaso(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso[] listCierreCasoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listCierreCasoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso[] listCierreCasoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listCierreCasoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryCierreCaso(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.CierreCaso as CierreCaso");
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
	
	public static List queryCierreCaso(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.CierreCaso as CierreCaso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CierreCaso", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso[] listCierreCasoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCierreCaso(session, condition, orderBy);
			return (CierreCaso[]) list.toArray(new CierreCaso[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso[] listCierreCasoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCierreCaso(session, condition, orderBy, lockMode);
			return (CierreCaso[]) list.toArray(new CierreCaso[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso loadCierreCasoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCierreCasoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso loadCierreCasoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadCierreCasoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso loadCierreCasoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CierreCaso[] cierreCasos = listCierreCasoByQuery(session, condition, orderBy);
		if (cierreCasos != null && cierreCasos.length > 0)
			return cierreCasos[0];
		else
			return null;
	}
	
	public static CierreCaso loadCierreCasoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CierreCaso[] cierreCasos = listCierreCasoByQuery(session, condition, orderBy, lockMode);
		if (cierreCasos != null && cierreCasos.length > 0)
			return cierreCasos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCierreCasoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateCierreCasoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCierreCasoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateCierreCasoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCierreCasoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.CierreCaso as CierreCaso");
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
	
	public static java.util.Iterator iterateCierreCasoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.CierreCaso as CierreCaso");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CierreCaso", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso createCierreCaso() {
		return new orm.CierreCaso();
	}
	
	public static boolean save(orm.CierreCaso cierreCaso) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().saveObject(cierreCaso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.CierreCaso cierreCaso) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().deleteObject(cierreCaso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.CierreCaso cierreCaso)throws PersistentException {
		try {
			if(cierreCaso.getIdRce() != null) {
				cierreCaso.getIdRce().setCierreCaso(null);
			}
			
			return delete(cierreCaso);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.CierreCaso cierreCaso, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(cierreCaso.getIdRce() != null) {
				cierreCaso.getIdRce().setCierreCaso(null);
			}
			
			try {
				session.delete(cierreCaso);
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
	
	public static boolean refresh(orm.CierreCaso cierreCaso) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().refresh(cierreCaso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.CierreCaso cierreCaso) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().evict(cierreCaso);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CierreCaso loadCierreCasoByCriteria(CierreCasoCriteria cierreCasoCriteria) {
		CierreCaso[] cierreCasos = listCierreCasoByCriteria(cierreCasoCriteria);
		if(cierreCasos == null || cierreCasos.length == 0) {
			return null;
		}
		return cierreCasos[0];
	}
	
	public static CierreCaso[] listCierreCasoByCriteria(CierreCasoCriteria cierreCasoCriteria) {
		return cierreCasoCriteria.listCierreCaso();
	}
}
