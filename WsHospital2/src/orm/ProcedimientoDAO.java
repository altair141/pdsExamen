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

public class ProcedimientoDAO {
	public static Procedimiento loadProcedimientoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadProcedimientoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento getProcedimientoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getProcedimientoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento loadProcedimientoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadProcedimientoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento getProcedimientoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getProcedimientoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento loadProcedimientoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Procedimiento) session.load(orm.Procedimiento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento getProcedimientoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Procedimiento) session.get(orm.Procedimiento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento loadProcedimientoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Procedimiento) session.load(orm.Procedimiento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento getProcedimientoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Procedimiento) session.get(orm.Procedimiento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProcedimiento(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryProcedimiento(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProcedimiento(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryProcedimiento(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento[] listProcedimientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listProcedimientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento[] listProcedimientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listProcedimientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProcedimiento(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Procedimiento as Procedimiento");
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
	
	public static List queryProcedimiento(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Procedimiento as Procedimiento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Procedimiento", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento[] listProcedimientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProcedimiento(session, condition, orderBy);
			return (Procedimiento[]) list.toArray(new Procedimiento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento[] listProcedimientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProcedimiento(session, condition, orderBy, lockMode);
			return (Procedimiento[]) list.toArray(new Procedimiento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento loadProcedimientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadProcedimientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento loadProcedimientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadProcedimientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento loadProcedimientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Procedimiento[] procedimientos = listProcedimientoByQuery(session, condition, orderBy);
		if (procedimientos != null && procedimientos.length > 0)
			return procedimientos[0];
		else
			return null;
	}
	
	public static Procedimiento loadProcedimientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Procedimiento[] procedimientos = listProcedimientoByQuery(session, condition, orderBy, lockMode);
		if (procedimientos != null && procedimientos.length > 0)
			return procedimientos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProcedimientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateProcedimientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProcedimientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateProcedimientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProcedimientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Procedimiento as Procedimiento");
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
	
	public static java.util.Iterator iterateProcedimientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Procedimiento as Procedimiento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Procedimiento", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento createProcedimiento() {
		return new orm.Procedimiento();
	}
	
	public static boolean save(orm.Procedimiento procedimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().saveObject(procedimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Procedimiento procedimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().deleteObject(procedimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Procedimiento procedimiento)throws PersistentException {
		try {
			if(procedimiento.getIdDiagnostico() != null) {
				procedimiento.getIdDiagnostico().procedimiento.remove(procedimiento);
			}
			
			orm.Rce[] lRces = procedimiento.rce.toArray();
			for(int i = 0; i < lRces.length; i++) {
				lRces[i].setIdProcedimiento(null);
			}
			return delete(procedimiento);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Procedimiento procedimiento, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(procedimiento.getIdDiagnostico() != null) {
				procedimiento.getIdDiagnostico().procedimiento.remove(procedimiento);
			}
			
			orm.Rce[] lRces = procedimiento.rce.toArray();
			for(int i = 0; i < lRces.length; i++) {
				lRces[i].setIdProcedimiento(null);
			}
			try {
				session.delete(procedimiento);
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
	
	public static boolean refresh(orm.Procedimiento procedimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().refresh(procedimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Procedimiento procedimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().evict(procedimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Procedimiento loadProcedimientoByCriteria(ProcedimientoCriteria procedimientoCriteria) {
		Procedimiento[] procedimientos = listProcedimientoByCriteria(procedimientoCriteria);
		if(procedimientos == null || procedimientos.length == 0) {
			return null;
		}
		return procedimientos[0];
	}
	
	public static Procedimiento[] listProcedimientoByCriteria(ProcedimientoCriteria procedimientoCriteria) {
		return procedimientoCriteria.listProcedimiento();
	}
}
