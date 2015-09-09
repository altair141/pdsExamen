/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteTaller2Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery(null, null);
			// Delete the persistent object
			orm.PersonaDAO.delete(lormPersona);
			orm.Reserva lormReserva = orm.ReservaDAO.loadReservaByQuery(null, null);
			// Delete the persistent object
			orm.ReservaDAO.delete(lormReserva);
			orm.Paciente lormPaciente = orm.PacienteDAO.loadPacienteByQuery(null, null);
			// Delete the persistent object
			orm.PacienteDAO.delete(lormPaciente);
			orm.HoraMedica lormHoraMedica = orm.HoraMedicaDAO.loadHoraMedicaByQuery(null, null);
			// Delete the persistent object
			orm.HoraMedicaDAO.delete(lormHoraMedica);
			orm.Medico lormMedico = orm.MedicoDAO.loadMedicoByQuery(null, null);
			// Delete the persistent object
			orm.MedicoDAO.delete(lormMedico);
			orm.Especialidad lormEspecialidad = orm.EspecialidadDAO.loadEspecialidadByQuery(null, null);
			// Delete the persistent object
			orm.EspecialidadDAO.delete(lormEspecialidad);
			orm.Box lormBox = orm.BoxDAO.loadBoxByQuery(null, null);
			// Delete the persistent object
			orm.BoxDAO.delete(lormBox);
			orm.DirectorHospital lormDirectorHospital = orm.DirectorHospitalDAO.loadDirectorHospitalByQuery(null, null);
			// Delete the persistent object
			orm.DirectorHospitalDAO.delete(lormDirectorHospital);
			orm.Reporte lormReporte = orm.ReporteDAO.loadReporteByQuery(null, null);
			// Delete the persistent object
			orm.ReporteDAO.delete(lormReporte);
			orm.TipoReporte lormTipoReporte = orm.TipoReporteDAO.loadTipoReporteByQuery(null, null);
			// Delete the persistent object
			orm.TipoReporteDAO.delete(lormTipoReporte);
			orm.Rce lormRce = orm.RceDAO.loadRceByQuery(null, null);
			// Delete the persistent object
			orm.RceDAO.delete(lormRce);
			orm.Hce lormHce = orm.HceDAO.loadHceByQuery(null, null);
			// Delete the persistent object
			orm.HceDAO.delete(lormHce);
			orm.Certificado lormCertificado = orm.CertificadoDAO.loadCertificadoByQuery(null, null);
			// Delete the persistent object
			orm.CertificadoDAO.delete(lormCertificado);
			orm.Actividad lormActividad = orm.ActividadDAO.loadActividadByQuery(null, null);
			// Delete the persistent object
			orm.ActividadDAO.delete(lormActividad);
			orm.Procedimiento lormProcedimiento = orm.ProcedimientoDAO.loadProcedimientoByQuery(null, null);
			// Delete the persistent object
			orm.ProcedimientoDAO.delete(lormProcedimiento);
			orm.Diagnostico lormDiagnostico = orm.DiagnosticoDAO.loadDiagnosticoByQuery(null, null);
			// Delete the persistent object
			orm.DiagnosticoDAO.delete(lormDiagnostico);
			orm.Receta lormReceta = orm.RecetaDAO.loadRecetaByQuery(null, null);
			// Delete the persistent object
			orm.RecetaDAO.delete(lormReceta);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteTaller2Data deleteTaller2Data = new DeleteTaller2Data();
			try {
				deleteTaller2Data.deleteTestData();
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
