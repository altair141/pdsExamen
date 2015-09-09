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

public class RceCriteria extends AbstractORMCriteria {
	public final IntegerExpression idRce;
	public final StringExpression tipoEncuentro;
	public final IntegerExpression idHceId;
	public final AssociationExpression idHce;
	public final IntegerExpression idHoraMedicaId;
	public final AssociationExpression idHoraMedica;
	public final StringExpression anamnesis;
	public final StringExpression alergia;
	public final StringExpression examenFisico;
	public final StringExpression indicacionMedica;
	public final StringExpression indicacionCierreCaso;
	public final StringExpression hipotesisDiagnostico;
	public final StringExpression pacienteGes;
	public final StringExpression patologiaGes;
	public final StringExpression pacienteCronico;
	public final StringExpression tipoCierre;
	public final StringExpression destino;
	public final DateExpression fechaAtencion;
	public final StringExpression horaInicioAtencion;
	public final DateExpression fechaCierreClinico;
	public final StringExpression horaCierreClinico;
	public final StringExpression tiempoControl;
	public final CollectionExpression certificado;
	public final CollectionExpression actividad;
	public final CollectionExpression procedimiento;
	public final CollectionExpression diagnosticoidDiagnostico;
	public final CollectionExpression receta;
	
	public RceCriteria(Criteria criteria) {
		super(criteria);
		idRce = new IntegerExpression("idRce", this);
		tipoEncuentro = new StringExpression("tipoEncuentro", this);
		idHceId = new IntegerExpression("idHce.idHce", this);
		idHce = new AssociationExpression("idHce", this);
		idHoraMedicaId = new IntegerExpression("idHoraMedica.idHora", this);
		idHoraMedica = new AssociationExpression("idHoraMedica", this);
		anamnesis = new StringExpression("anamnesis", this);
		alergia = new StringExpression("alergia", this);
		examenFisico = new StringExpression("examenFisico", this);
		indicacionMedica = new StringExpression("indicacionMedica", this);
		indicacionCierreCaso = new StringExpression("indicacionCierreCaso", this);
		hipotesisDiagnostico = new StringExpression("hipotesisDiagnostico", this);
		pacienteGes = new StringExpression("pacienteGes", this);
		patologiaGes = new StringExpression("patologiaGes", this);
		pacienteCronico = new StringExpression("pacienteCronico", this);
		tipoCierre = new StringExpression("tipoCierre", this);
		destino = new StringExpression("destino", this);
		fechaAtencion = new DateExpression("fechaAtencion", this);
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this);
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this);
		horaCierreClinico = new StringExpression("horaCierreClinico", this);
		tiempoControl = new StringExpression("tiempoControl", this);
		certificado = new CollectionExpression("ORM_Certificado", this);
		actividad = new CollectionExpression("ORM_Actividad", this);
		procedimiento = new CollectionExpression("ORM_Procedimiento", this);
		diagnosticoidDiagnostico = new CollectionExpression("ORM_DiagnosticoidDiagnostico", this);
		receta = new CollectionExpression("ORM_Receta", this);
	}
	
	public RceCriteria(PersistentSession session) {
		this(session.createCriteria(Rce.class));
	}
	
	public RceCriteria() throws PersistentException {
		this(orm.Taller2PersistentManager.instance().getSession());
	}
	
	public HceCriteria createIdHceCriteria() {
		return new HceCriteria(createCriteria("idHce"));
	}
	
	public HoraMedicaCriteria createIdHoraMedicaCriteria() {
		return new HoraMedicaCriteria(createCriteria("idHoraMedica"));
	}
	
	public CertificadoCriteria createCertificadoCriteria() {
		return new CertificadoCriteria(createCriteria("ORM_Certificado"));
	}
	
	public ActividadCriteria createActividadCriteria() {
		return new ActividadCriteria(createCriteria("ORM_Actividad"));
	}
	
	public ProcedimientoCriteria createProcedimientoCriteria() {
		return new ProcedimientoCriteria(createCriteria("ORM_Procedimiento"));
	}
	
	public DiagnosticoCriteria createDiagnosticoidDiagnosticoCriteria() {
		return new DiagnosticoCriteria(createCriteria("ORM_DiagnosticoidDiagnostico"));
	}
	
	public RecetaCriteria createRecetaCriteria() {
		return new RecetaCriteria(createCriteria("ORM_Receta"));
	}
	
	public Rce uniqueRce() {
		return (Rce) super.uniqueResult();
	}
	
	public Rce[] listRce() {
		java.util.List list = super.list();
		return (Rce[]) list.toArray(new Rce[list.size()]);
	}
}

