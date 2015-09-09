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

public class RceDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public RceDetachedCriteria() {
		super(orm.Rce.class, orm.RceCriteria.class);
		idRce = new IntegerExpression("idRce", this.getDetachedCriteria());
		tipoEncuentro = new StringExpression("tipoEncuentro", this.getDetachedCriteria());
		idHceId = new IntegerExpression("idHce.idHce", this.getDetachedCriteria());
		idHce = new AssociationExpression("idHce", this.getDetachedCriteria());
		idHoraMedicaId = new IntegerExpression("idHoraMedica.idHora", this.getDetachedCriteria());
		idHoraMedica = new AssociationExpression("idHoraMedica", this.getDetachedCriteria());
		anamnesis = new StringExpression("anamnesis", this.getDetachedCriteria());
		alergia = new StringExpression("alergia", this.getDetachedCriteria());
		examenFisico = new StringExpression("examenFisico", this.getDetachedCriteria());
		indicacionMedica = new StringExpression("indicacionMedica", this.getDetachedCriteria());
		indicacionCierreCaso = new StringExpression("indicacionCierreCaso", this.getDetachedCriteria());
		hipotesisDiagnostico = new StringExpression("hipotesisDiagnostico", this.getDetachedCriteria());
		pacienteGes = new StringExpression("pacienteGes", this.getDetachedCriteria());
		patologiaGes = new StringExpression("patologiaGes", this.getDetachedCriteria());
		pacienteCronico = new StringExpression("pacienteCronico", this.getDetachedCriteria());
		tipoCierre = new StringExpression("tipoCierre", this.getDetachedCriteria());
		destino = new StringExpression("destino", this.getDetachedCriteria());
		fechaAtencion = new DateExpression("fechaAtencion", this.getDetachedCriteria());
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this.getDetachedCriteria());
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this.getDetachedCriteria());
		horaCierreClinico = new StringExpression("horaCierreClinico", this.getDetachedCriteria());
		tiempoControl = new StringExpression("tiempoControl", this.getDetachedCriteria());
		certificado = new CollectionExpression("ORM_Certificado", this.getDetachedCriteria());
		actividad = new CollectionExpression("ORM_Actividad", this.getDetachedCriteria());
		procedimiento = new CollectionExpression("ORM_Procedimiento", this.getDetachedCriteria());
		diagnosticoidDiagnostico = new CollectionExpression("ORM_DiagnosticoidDiagnostico", this.getDetachedCriteria());
		receta = new CollectionExpression("ORM_Receta", this.getDetachedCriteria());
	}
	
	public RceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.RceCriteria.class);
		idRce = new IntegerExpression("idRce", this.getDetachedCriteria());
		tipoEncuentro = new StringExpression("tipoEncuentro", this.getDetachedCriteria());
		idHceId = new IntegerExpression("idHce.idHce", this.getDetachedCriteria());
		idHce = new AssociationExpression("idHce", this.getDetachedCriteria());
		idHoraMedicaId = new IntegerExpression("idHoraMedica.idHora", this.getDetachedCriteria());
		idHoraMedica = new AssociationExpression("idHoraMedica", this.getDetachedCriteria());
		anamnesis = new StringExpression("anamnesis", this.getDetachedCriteria());
		alergia = new StringExpression("alergia", this.getDetachedCriteria());
		examenFisico = new StringExpression("examenFisico", this.getDetachedCriteria());
		indicacionMedica = new StringExpression("indicacionMedica", this.getDetachedCriteria());
		indicacionCierreCaso = new StringExpression("indicacionCierreCaso", this.getDetachedCriteria());
		hipotesisDiagnostico = new StringExpression("hipotesisDiagnostico", this.getDetachedCriteria());
		pacienteGes = new StringExpression("pacienteGes", this.getDetachedCriteria());
		patologiaGes = new StringExpression("patologiaGes", this.getDetachedCriteria());
		pacienteCronico = new StringExpression("pacienteCronico", this.getDetachedCriteria());
		tipoCierre = new StringExpression("tipoCierre", this.getDetachedCriteria());
		destino = new StringExpression("destino", this.getDetachedCriteria());
		fechaAtencion = new DateExpression("fechaAtencion", this.getDetachedCriteria());
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this.getDetachedCriteria());
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this.getDetachedCriteria());
		horaCierreClinico = new StringExpression("horaCierreClinico", this.getDetachedCriteria());
		tiempoControl = new StringExpression("tiempoControl", this.getDetachedCriteria());
		certificado = new CollectionExpression("ORM_Certificado", this.getDetachedCriteria());
		actividad = new CollectionExpression("ORM_Actividad", this.getDetachedCriteria());
		procedimiento = new CollectionExpression("ORM_Procedimiento", this.getDetachedCriteria());
		diagnosticoidDiagnostico = new CollectionExpression("ORM_DiagnosticoidDiagnostico", this.getDetachedCriteria());
		receta = new CollectionExpression("ORM_Receta", this.getDetachedCriteria());
	}
	
	public HceDetachedCriteria createIdHceCriteria() {
		return new HceDetachedCriteria(createCriteria("idHce"));
	}
	
	public HoraMedicaDetachedCriteria createIdHoraMedicaCriteria() {
		return new HoraMedicaDetachedCriteria(createCriteria("idHoraMedica"));
	}
	
	public CertificadoDetachedCriteria createCertificadoCriteria() {
		return new CertificadoDetachedCriteria(createCriteria("ORM_Certificado"));
	}
	
	public ActividadDetachedCriteria createActividadCriteria() {
		return new ActividadDetachedCriteria(createCriteria("ORM_Actividad"));
	}
	
	public ProcedimientoDetachedCriteria createProcedimientoCriteria() {
		return new ProcedimientoDetachedCriteria(createCriteria("ORM_Procedimiento"));
	}
	
	public DiagnosticoDetachedCriteria createDiagnosticoidDiagnosticoCriteria() {
		return new DiagnosticoDetachedCriteria(createCriteria("ORM_DiagnosticoidDiagnostico"));
	}
	
	public RecetaDetachedCriteria createRecetaCriteria() {
		return new RecetaDetachedCriteria(createCriteria("ORM_Receta"));
	}
	
	public Rce uniqueRce(PersistentSession session) {
		return (Rce) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Rce[] listRce(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Rce[]) list.toArray(new Rce[list.size()]);
	}
}

