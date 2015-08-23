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

public class EstablecimientoDAO {
	public static Establecimiento loadEstablecimientoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadEstablecimientoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento getEstablecimientoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getEstablecimientoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento loadEstablecimientoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadEstablecimientoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento getEstablecimientoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return getEstablecimientoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento loadEstablecimientoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Establecimiento) session.load(orm.Establecimiento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento getEstablecimientoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Establecimiento) session.get(orm.Establecimiento.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento loadEstablecimientoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Establecimiento) session.load(orm.Establecimiento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento getEstablecimientoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Establecimiento) session.get(orm.Establecimiento.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEstablecimiento(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryEstablecimiento(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEstablecimiento(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return queryEstablecimiento(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento[] listEstablecimientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listEstablecimientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento[] listEstablecimientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return listEstablecimientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEstablecimiento(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Establecimiento as Establecimiento");
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
	
	public static List queryEstablecimiento(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Establecimiento as Establecimiento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Establecimiento", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento[] listEstablecimientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryEstablecimiento(session, condition, orderBy);
			return (Establecimiento[]) list.toArray(new Establecimiento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento[] listEstablecimientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryEstablecimiento(session, condition, orderBy, lockMode);
			return (Establecimiento[]) list.toArray(new Establecimiento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento loadEstablecimientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadEstablecimientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento loadEstablecimientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return loadEstablecimientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento loadEstablecimientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Establecimiento[] establecimientos = listEstablecimientoByQuery(session, condition, orderBy);
		if (establecimientos != null && establecimientos.length > 0)
			return establecimientos[0];
		else
			return null;
	}
	
	public static Establecimiento loadEstablecimientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Establecimiento[] establecimientos = listEstablecimientoByQuery(session, condition, orderBy, lockMode);
		if (establecimientos != null && establecimientos.length > 0)
			return establecimientos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEstablecimientoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateEstablecimientoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEstablecimientoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller2PersistentManager.instance().getSession();
			return iterateEstablecimientoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEstablecimientoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Establecimiento as Establecimiento");
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
	
	public static java.util.Iterator iterateEstablecimientoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Establecimiento as Establecimiento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Establecimiento", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento createEstablecimiento() {
		return new orm.Establecimiento();
	}
	
	public static boolean save(orm.Establecimiento establecimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().saveObject(establecimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Establecimiento establecimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().deleteObject(establecimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Establecimiento establecimiento)throws PersistentException {
		try {
			orm.Medico[] lMedicos = establecimiento.medico.toArray();
			for(int i = 0; i < lMedicos.length; i++) {
				lMedicos[i].setIdEstablecimiento(null);
			}
			orm.HoraMedica[] lHoraMedicas = establecimiento.horaMedica.toArray();
			for(int i = 0; i < lHoraMedicas.length; i++) {
				lHoraMedicas[i].setIdEstablecimiento(null);
			}
			orm.Box[] lBoxs = establecimiento.box.toArray();
			for(int i = 0; i < lBoxs.length; i++) {
				lBoxs[i].setIdEstablecimiento(null);
			}
			return delete(establecimiento);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Establecimiento establecimiento, org.orm.PersistentSession session)throws PersistentException {
		try {
			orm.Medico[] lMedicos = establecimiento.medico.toArray();
			for(int i = 0; i < lMedicos.length; i++) {
				lMedicos[i].setIdEstablecimiento(null);
			}
			orm.HoraMedica[] lHoraMedicas = establecimiento.horaMedica.toArray();
			for(int i = 0; i < lHoraMedicas.length; i++) {
				lHoraMedicas[i].setIdEstablecimiento(null);
			}
			orm.Box[] lBoxs = establecimiento.box.toArray();
			for(int i = 0; i < lBoxs.length; i++) {
				lBoxs[i].setIdEstablecimiento(null);
			}
			try {
				session.delete(establecimiento);
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
	
	public static boolean refresh(orm.Establecimiento establecimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().refresh(establecimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Establecimiento establecimiento) throws PersistentException {
		try {
			orm.Taller2PersistentManager.instance().getSession().evict(establecimiento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Establecimiento loadEstablecimientoByCriteria(EstablecimientoCriteria establecimientoCriteria) {
		Establecimiento[] establecimientos = listEstablecimientoByCriteria(establecimientoCriteria);
		if(establecimientos == null || establecimientos.length == 0) {
			return null;
		}
		return establecimientos[0];
	}
	
	public static Establecimiento[] listEstablecimientoByCriteria(EstablecimientoCriteria establecimientoCriteria) {
		return establecimientoCriteria.listEstablecimiento();
	}
}
