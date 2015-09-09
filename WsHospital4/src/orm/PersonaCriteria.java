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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PersonaCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPersona;
	public final StringExpression nombre;
	public final StringExpression apellidos;
	public final DateExpression fechaNacimiento;
	public final StringExpression direccion;
	public final StringExpression estado;
	public final StringExpression rut;
	public final StringExpression sexo;
	public final CollectionExpression reserva;
	public final IntegerExpression pacienteId;
	public final AssociationExpression paciente;
	public final IntegerExpression medicoId;
	public final AssociationExpression medico;
	public final IntegerExpression directorHospitalId;
	public final AssociationExpression directorHospital;
	
	public PersonaCriteria(Criteria criteria) {
		super(criteria);
		idPersona = new IntegerExpression("idPersona", this);
		nombre = new StringExpression("nombre", this);
		apellidos = new StringExpression("apellidos", this);
		fechaNacimiento = new DateExpression("fechaNacimiento", this);
		direccion = new StringExpression("direccion", this);
		estado = new StringExpression("estado", this);
		rut = new StringExpression("rut", this);
		sexo = new StringExpression("sexo", this);
		reserva = new CollectionExpression("ORM_Reserva", this);
		pacienteId = new IntegerExpression("paciente.idPersona", this);
		paciente = new AssociationExpression("paciente", this);
		medicoId = new IntegerExpression("medico.idPersona", this);
		medico = new AssociationExpression("medico", this);
		directorHospitalId = new IntegerExpression("directorHospital.idPersona", this);
		directorHospital = new AssociationExpression("directorHospital", this);
	}
	
	public PersonaCriteria(PersistentSession session) {
		this(session.createCriteria(Persona.class));
	}
	
	public PersonaCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public ReservaCriteria createReservaCriteria() {
		return new ReservaCriteria(createCriteria("ORM_Reserva"));
	}
	
	public PacienteCriteria createPacienteCriteria() {
		return new PacienteCriteria(createCriteria("paciente"));
	}
	
	public MedicoCriteria createMedicoCriteria() {
		return new MedicoCriteria(createCriteria("medico"));
	}
	
	public DirectorHospitalCriteria createDirectorHospitalCriteria() {
		return new DirectorHospitalCriteria(createCriteria("directorHospital"));
	}
	
	public Persona uniquePersona() {
		return (Persona) super.uniqueResult();
	}
	
	public Persona[] listPersona() {
		java.util.List list = super.list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

