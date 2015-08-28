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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RceDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idRce;
	public final StringExpression tipoEncuentro;
	public final StringExpression uuid;
	public final IntegerExpression idHceId;
	public final AssociationExpression idHce;
	public final IntegerExpression idHoraMedica;
	public final StringExpression anamnesis;
	public final StringExpression alergia;
	public final StringExpression examenFisico;
	public final StringExpression indicacionMedica;
	public final StringExpression indicacionCierreCaso;
	public final StringExpression hipotesisDiagnostico;
	public final StringExpression pacienteGes;
	public final StringExpression patologiaGes;
	public final StringExpression pacienteCronico;
	public final StringExpression receta;
	public final IntegerExpression idDiagnosticoId;
	public final AssociationExpression idDiagnostico;
	public final IntegerExpression idActividadId;
	public final AssociationExpression idActividad;
	public final IntegerExpression idProcedimientoId;
	public final AssociationExpression idProcedimiento;
	public final StringExpression tipoCierre;
	public final StringExpression destino;
	public final DateExpression fechaAtencion;
	public final StringExpression horaInicioAtencion;
	public final DateExpression fechaCierreClinico;
	public final StringExpression horaCierreClinico;
	public final StringExpression tiempoControl;
	public final CollectionExpression certificado;
	
	public RceDetachedCriteria() {
		super(orm.Rce.class, orm.RceCriteria.class);
		idRce = new IntegerExpression("idRce", this.getDetachedCriteria());
		tipoEncuentro = new StringExpression("tipoEncuentro", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		idHceId = new IntegerExpression("idHce.idHce", this.getDetachedCriteria());
		idHce = new AssociationExpression("idHce", this.getDetachedCriteria());
		idHoraMedica = new IntegerExpression("idHoraMedica", this.getDetachedCriteria());
		anamnesis = new StringExpression("anamnesis", this.getDetachedCriteria());
		alergia = new StringExpression("alergia", this.getDetachedCriteria());
		examenFisico = new StringExpression("examenFisico", this.getDetachedCriteria());
		indicacionMedica = new StringExpression("indicacionMedica", this.getDetachedCriteria());
		indicacionCierreCaso = new StringExpression("indicacionCierreCaso", this.getDetachedCriteria());
		hipotesisDiagnostico = new StringExpression("hipotesisDiagnostico", this.getDetachedCriteria());
		pacienteGes = new StringExpression("pacienteGes", this.getDetachedCriteria());
		patologiaGes = new StringExpression("patologiaGes", this.getDetachedCriteria());
		pacienteCronico = new StringExpression("pacienteCronico", this.getDetachedCriteria());
		receta = new StringExpression("receta", this.getDetachedCriteria());
		idDiagnosticoId = new IntegerExpression("idDiagnostico.idDiagnostico", this.getDetachedCriteria());
		idDiagnostico = new AssociationExpression("idDiagnostico", this.getDetachedCriteria());
		idActividadId = new IntegerExpression("idActividad.id", this.getDetachedCriteria());
		idActividad = new AssociationExpression("idActividad", this.getDetachedCriteria());
		idProcedimientoId = new IntegerExpression("idProcedimiento.id", this.getDetachedCriteria());
		idProcedimiento = new AssociationExpression("idProcedimiento", this.getDetachedCriteria());
		tipoCierre = new StringExpression("tipoCierre", this.getDetachedCriteria());
		destino = new StringExpression("destino", this.getDetachedCriteria());
		fechaAtencion = new DateExpression("fechaAtencion", this.getDetachedCriteria());
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this.getDetachedCriteria());
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this.getDetachedCriteria());
		horaCierreClinico = new StringExpression("horaCierreClinico", this.getDetachedCriteria());
		tiempoControl = new StringExpression("tiempoControl", this.getDetachedCriteria());
		certificado = new CollectionExpression("ORM_Certificado", this.getDetachedCriteria());
	}
	
	public RceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.RceCriteria.class);
		idRce = new IntegerExpression("idRce", this.getDetachedCriteria());
		tipoEncuentro = new StringExpression("tipoEncuentro", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		idHceId = new IntegerExpression("idHce.idHce", this.getDetachedCriteria());
		idHce = new AssociationExpression("idHce", this.getDetachedCriteria());
		idHoraMedica = new IntegerExpression("idHoraMedica", this.getDetachedCriteria());
		anamnesis = new StringExpression("anamnesis", this.getDetachedCriteria());
		alergia = new StringExpression("alergia", this.getDetachedCriteria());
		examenFisico = new StringExpression("examenFisico", this.getDetachedCriteria());
		indicacionMedica = new StringExpression("indicacionMedica", this.getDetachedCriteria());
		indicacionCierreCaso = new StringExpression("indicacionCierreCaso", this.getDetachedCriteria());
		hipotesisDiagnostico = new StringExpression("hipotesisDiagnostico", this.getDetachedCriteria());
		pacienteGes = new StringExpression("pacienteGes", this.getDetachedCriteria());
		patologiaGes = new StringExpression("patologiaGes", this.getDetachedCriteria());
		pacienteCronico = new StringExpression("pacienteCronico", this.getDetachedCriteria());
		receta = new StringExpression("receta", this.getDetachedCriteria());
		idDiagnosticoId = new IntegerExpression("idDiagnostico.idDiagnostico", this.getDetachedCriteria());
		idDiagnostico = new AssociationExpression("idDiagnostico", this.getDetachedCriteria());
		idActividadId = new IntegerExpression("idActividad.id", this.getDetachedCriteria());
		idActividad = new AssociationExpression("idActividad", this.getDetachedCriteria());
		idProcedimientoId = new IntegerExpression("idProcedimiento.id", this.getDetachedCriteria());
		idProcedimiento = new AssociationExpression("idProcedimiento", this.getDetachedCriteria());
		tipoCierre = new StringExpression("tipoCierre", this.getDetachedCriteria());
		destino = new StringExpression("destino", this.getDetachedCriteria());
		fechaAtencion = new DateExpression("fechaAtencion", this.getDetachedCriteria());
		horaInicioAtencion = new StringExpression("horaInicioAtencion", this.getDetachedCriteria());
		fechaCierreClinico = new DateExpression("fechaCierreClinico", this.getDetachedCriteria());
		horaCierreClinico = new StringExpression("horaCierreClinico", this.getDetachedCriteria());
		tiempoControl = new StringExpression("tiempoControl", this.getDetachedCriteria());
		certificado = new CollectionExpression("ORM_Certificado", this.getDetachedCriteria());
	}
	
	public HceDetachedCriteria createIdHceCriteria() {
		return new HceDetachedCriteria(createCriteria("idHce"));
	}
	
	public DiagnosticoDetachedCriteria createIdDiagnosticoCriteria() {
		return new DiagnosticoDetachedCriteria(createCriteria("idDiagnostico"));
	}
	
	public ActividadDetachedCriteria createIdActividadCriteria() {
		return new ActividadDetachedCriteria(createCriteria("idActividad"));
	}
	
	public ProcedimientoDetachedCriteria createIdProcedimientoCriteria() {
		return new ProcedimientoDetachedCriteria(createCriteria("idProcedimiento"));
	}
	
	public CertificadoDetachedCriteria createCertificadoCriteria() {
		return new CertificadoDetachedCriteria(createCriteria("ORM_Certificado"));
	}
	
	public Rce uniqueRce(PersistentSession session) {
		return (Rce) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Rce[] listRce(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Rce[]) list.toArray(new Rce[list.size()]);
	}
}

