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

public class DiagnosticoDAO {
	public static Diagnostico loadDiagnosticoByORMID(int idDiagnostico) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadDiagnosticoByORMID(session, idDiagnostico);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico getDiagnosticoByORMID(int idDiagnostico) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getDiagnosticoByORMID(session, idDiagnostico);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico loadDiagnosticoByORMID(int idDiagnostico, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadDiagnosticoByORMID(session, idDiagnostico, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico getDiagnosticoByORMID(int idDiagnostico, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getDiagnosticoByORMID(session, idDiagnostico, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico loadDiagnosticoByORMID(PersistentSession session, int idDiagnostico) throws PersistentException {
		try {
			return (Diagnostico) session.load(orm.Diagnostico.class, new Integer(idDiagnostico));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico getDiagnosticoByORMID(PersistentSession session, int idDiagnostico) throws PersistentException {
		try {
			return (Diagnostico) session.get(orm.Diagnostico.class, new Integer(idDiagnostico));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico loadDiagnosticoByORMID(PersistentSession session, int idDiagnostico, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Diagnostico) session.load(orm.Diagnostico.class, new Integer(idDiagnostico), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico getDiagnosticoByORMID(PersistentSession session, int idDiagnostico, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Diagnostico) session.get(orm.Diagnostico.class, new Integer(idDiagnostico), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDiagnostico(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryDiagnostico(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDiagnostico(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryDiagnostico(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico[] listDiagnosticoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listDiagnosticoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico[] listDiagnosticoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listDiagnosticoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDiagnostico(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Diagnostico as Diagnostico");
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
	
	public static List queryDiagnostico(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Diagnostico as Diagnostico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Diagnostico", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico[] listDiagnosticoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDiagnostico(session, condition, orderBy);
			return (Diagnostico[]) list.toArray(new Diagnostico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico[] listDiagnosticoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDiagnostico(session, condition, orderBy, lockMode);
			return (Diagnostico[]) list.toArray(new Diagnostico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico loadDiagnosticoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadDiagnosticoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico loadDiagnosticoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadDiagnosticoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico loadDiagnosticoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Diagnostico[] diagnosticos = listDiagnosticoByQuery(session, condition, orderBy);
		if (diagnosticos != null && diagnosticos.length > 0)
			return diagnosticos[0];
		else
			return null;
	}
	
	public static Diagnostico loadDiagnosticoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Diagnostico[] diagnosticos = listDiagnosticoByQuery(session, condition, orderBy, lockMode);
		if (diagnosticos != null && diagnosticos.length > 0)
			return diagnosticos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDiagnosticoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateDiagnosticoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDiagnosticoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateDiagnosticoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDiagnosticoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Diagnostico as Diagnostico");
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
	
	public static java.util.Iterator iterateDiagnosticoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Diagnostico as Diagnostico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Diagnostico", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico createDiagnostico() {
		return new orm.Diagnostico();
	}
	
	public static boolean save(orm.Diagnostico diagnostico) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().saveObject(diagnostico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Diagnostico diagnostico) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().deleteObject(diagnostico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Diagnostico diagnostico)throws PersistentException {
		try {
			orm.Rce[] lRces = diagnostico.rce.toArray();
			for(int i = 0; i < lRces.length; i++) {
				lRces[i].setIdDiagnostico(null);
			}
			orm.Actividad[] lActividads = diagnostico.actividad.toArray();
			for(int i = 0; i < lActividads.length; i++) {
				lActividads[i].setIdDiagnostico(null);
			}
			orm.Procedimiento[] lProcedimientos = diagnostico.procedimiento.toArray();
			for(int i = 0; i < lProcedimientos.length; i++) {
				lProcedimientos[i].setIdDiagnostico(null);
			}
			return delete(diagnostico);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Diagnostico diagnostico, org.orm.PersistentSession session)throws PersistentException {
		try {
			orm.Rce[] lRces = diagnostico.rce.toArray();
			for(int i = 0; i < lRces.length; i++) {
				lRces[i].setIdDiagnostico(null);
			}
			orm.Actividad[] lActividads = diagnostico.actividad.toArray();
			for(int i = 0; i < lActividads.length; i++) {
				lActividads[i].setIdDiagnostico(null);
			}
			orm.Procedimiento[] lProcedimientos = diagnostico.procedimiento.toArray();
			for(int i = 0; i < lProcedimientos.length; i++) {
				lProcedimientos[i].setIdDiagnostico(null);
			}
			try {
				session.delete(diagnostico);
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
	
	public static boolean refresh(orm.Diagnostico diagnostico) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().refresh(diagnostico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Diagnostico diagnostico) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().evict(diagnostico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Diagnostico loadDiagnosticoByCriteria(DiagnosticoCriteria diagnosticoCriteria) {
		Diagnostico[] diagnosticos = listDiagnosticoByCriteria(diagnosticoCriteria);
		if(diagnosticos == null || diagnosticos.length == 0) {
			return null;
		}
		return diagnosticos[0];
	}
	
	public static Diagnostico[] listDiagnosticoByCriteria(DiagnosticoCriteria diagnosticoCriteria) {
		return diagnosticoCriteria.listDiagnostico();
	}
}
