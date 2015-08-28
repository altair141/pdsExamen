/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTaller2Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery(null, null);
			// Update the properties of the persistent object
			orm.PersonaDAO.save(lormPersona);
			orm.Reserva lormReserva = orm.ReservaDAO.loadReservaByQuery(null, null);
			// Update the properties of the persistent object
			orm.ReservaDAO.save(lormReserva);
			orm.Paciente lormPaciente = orm.PacienteDAO.loadPacienteByQuery(null, null);
			// Update the properties of the persistent object
			orm.PacienteDAO.save(lormPaciente);
			orm.HoraMedica lormHoraMedica = orm.HoraMedicaDAO.loadHoraMedicaByQuery(null, null);
			// Update the properties of the persistent object
			orm.HoraMedicaDAO.save(lormHoraMedica);
			orm.Medico lormMedico = orm.MedicoDAO.loadMedicoByQuery(null, null);
			// Update the properties of the persistent object
			orm.MedicoDAO.save(lormMedico);
			orm.Especialidad lormEspecialidad = orm.EspecialidadDAO.loadEspecialidadByQuery(null, null);
			// Update the properties of the persistent object
			orm.EspecialidadDAO.save(lormEspecialidad);
			orm.Box lormBox = orm.BoxDAO.loadBoxByQuery(null, null);
			// Update the properties of the persistent object
			orm.BoxDAO.save(lormBox);
			orm.DirectorHospital lormDirectorHospital = orm.DirectorHospitalDAO.loadDirectorHospitalByQuery(null, null);
			// Update the properties of the persistent object
			orm.DirectorHospitalDAO.save(lormDirectorHospital);
			orm.Reporte lormReporte = orm.ReporteDAO.loadReporteByQuery(null, null);
			// Update the properties of the persistent object
			orm.ReporteDAO.save(lormReporte);
			orm.TipoReporte lormTipoReporte = orm.TipoReporteDAO.loadTipoReporteByQuery(null, null);
			// Update the properties of the persistent object
			orm.TipoReporteDAO.save(lormTipoReporte);
			orm.Rce lormRce = orm.RceDAO.loadRceByQuery(null, null);
			// Update the properties of the persistent object
			orm.RceDAO.save(lormRce);
			orm.Hce lormHce = orm.HceDAO.loadHceByQuery(null, null);
			// Update the properties of the persistent object
			orm.HceDAO.save(lormHce);
			orm.Certificado lormCertificado = orm.CertificadoDAO.loadCertificadoByQuery(null, null);
			// Update the properties of the persistent object
			orm.CertificadoDAO.save(lormCertificado);
			orm.Actividad lormActividad = orm.ActividadDAO.loadActividadByQuery(null, null);
			// Update the properties of the persistent object
			orm.ActividadDAO.save(lormActividad);
			orm.Procedimiento lormProcedimiento = orm.ProcedimientoDAO.loadProcedimientoByQuery(null, null);
			// Update the properties of the persistent object
			orm.ProcedimientoDAO.save(lormProcedimiento);
			orm.Diagnostico lormDiagnostico = orm.DiagnosticoDAO.loadDiagnosticoByQuery(null, null);
			// Update the properties of the persistent object
			orm.DiagnosticoDAO.save(lormDiagnostico);
			orm.Establecimiento lormEstablecimiento = orm.EstablecimientoDAO.loadEstablecimientoByQuery(null, null);
			// Update the properties of the persistent object
			orm.EstablecimientoDAO.save(lormEstablecimiento);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Persona by PersonaCriteria");
		orm.PersonaCriteria lormPersonaCriteria = new orm.PersonaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormPersonaCriteria.idPersona.eq();
		System.out.println(lormPersonaCriteria.uniquePersona());
		
		System.out.println("Retrieving Reserva by ReservaCriteria");
		orm.ReservaCriteria lormReservaCriteria = new orm.ReservaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormReservaCriteria.idReserva.eq();
		System.out.println(lormReservaCriteria.uniqueReserva());
		
		System.out.println("Retrieving Paciente by PacienteCriteria");
		orm.PacienteCriteria lormPacienteCriteria = new orm.PacienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormPacienteCriteria.idPaciente.eq();
		System.out.println(lormPacienteCriteria.uniquePaciente());
		
		System.out.println("Retrieving HoraMedica by HoraMedicaCriteria");
		orm.HoraMedicaCriteria lormHoraMedicaCriteria = new orm.HoraMedicaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormHoraMedicaCriteria.idHora.eq();
		System.out.println(lormHoraMedicaCriteria.uniqueHoraMedica());
		
		System.out.println("Retrieving Medico by MedicoCriteria");
		orm.MedicoCriteria lormMedicoCriteria = new orm.MedicoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormMedicoCriteria.idMedico.eq();
		System.out.println(lormMedicoCriteria.uniqueMedico());
		
		System.out.println("Retrieving Especialidad by EspecialidadCriteria");
		orm.EspecialidadCriteria lormEspecialidadCriteria = new orm.EspecialidadCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormEspecialidadCriteria.idEspecialidad.eq();
		System.out.println(lormEspecialidadCriteria.uniqueEspecialidad());
		
		System.out.println("Retrieving Box by BoxCriteria");
		orm.BoxCriteria lormBoxCriteria = new orm.BoxCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormBoxCriteria.idHabitacion.eq();
		System.out.println(lormBoxCriteria.uniqueBox());
		
		System.out.println("Retrieving DirectorHospital by DirectorHospitalCriteria");
		orm.DirectorHospitalCriteria lormDirectorHospitalCriteria = new orm.DirectorHospitalCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormDirectorHospitalCriteria.id.eq();
		System.out.println(lormDirectorHospitalCriteria.uniqueDirectorHospital());
		
		System.out.println("Retrieving Reporte by ReporteCriteria");
		orm.ReporteCriteria lormReporteCriteria = new orm.ReporteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormReporteCriteria.id.eq();
		System.out.println(lormReporteCriteria.uniqueReporte());
		
		System.out.println("Retrieving TipoReporte by TipoReporteCriteria");
		orm.TipoReporteCriteria lormTipoReporteCriteria = new orm.TipoReporteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormTipoReporteCriteria.id.eq();
		System.out.println(lormTipoReporteCriteria.uniqueTipoReporte());
		
		System.out.println("Retrieving Rce by RceCriteria");
		orm.RceCriteria lormRceCriteria = new orm.RceCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormRceCriteria.idRce.eq();
		System.out.println(lormRceCriteria.uniqueRce());
		
		System.out.println("Retrieving Hce by HceCriteria");
		orm.HceCriteria lormHceCriteria = new orm.HceCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormHceCriteria.idHce.eq();
		System.out.println(lormHceCriteria.uniqueHce());
		
		System.out.println("Retrieving Certificado by CertificadoCriteria");
		orm.CertificadoCriteria lormCertificadoCriteria = new orm.CertificadoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormCertificadoCriteria.id.eq();
		System.out.println(lormCertificadoCriteria.uniqueCertificado());
		
		System.out.println("Retrieving Actividad by ActividadCriteria");
		orm.ActividadCriteria lormActividadCriteria = new orm.ActividadCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormActividadCriteria.id.eq();
		System.out.println(lormActividadCriteria.uniqueActividad());
		
		System.out.println("Retrieving Procedimiento by ProcedimientoCriteria");
		orm.ProcedimientoCriteria lormProcedimientoCriteria = new orm.ProcedimientoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormProcedimientoCriteria.id.eq();
		System.out.println(lormProcedimientoCriteria.uniqueProcedimiento());
		
		System.out.println("Retrieving Diagnostico by DiagnosticoCriteria");
		orm.DiagnosticoCriteria lormDiagnosticoCriteria = new orm.DiagnosticoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormDiagnosticoCriteria.idDiagnostico.eq();
		System.out.println(lormDiagnosticoCriteria.uniqueDiagnostico());
		
		System.out.println("Retrieving Establecimiento by EstablecimientoCriteria");
		orm.EstablecimientoCriteria lormEstablecimientoCriteria = new orm.EstablecimientoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormEstablecimientoCriteria.id.eq();
		System.out.println(lormEstablecimientoCriteria.uniqueEstablecimiento());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTaller2Data retrieveAndUpdateTaller2Data = new RetrieveAndUpdateTaller2Data();
			try {
				retrieveAndUpdateTaller2Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateTaller2Data.retrieveByCriteria();
			}
			finally {
				orm.Taller2PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
