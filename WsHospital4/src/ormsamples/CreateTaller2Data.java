/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateTaller2Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.createPersona();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : directorHospital, medico, paciente, reserva, sexo, rut, estado, nombre
			orm.PersonaDAO.save(lormPersona);
			orm.Reserva lormReserva = orm.ReservaDAO.createReserva();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idPersonaRegistra, idHoraMedica, idPaciente
			orm.ReservaDAO.save(lormReserva);
			orm.Paciente lormPaciente = orm.PacienteDAO.createPaciente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : hce, reserva, idPersona, nroFichaMedica
			orm.PacienteDAO.save(lormPaciente);
			orm.HoraMedica lormHoraMedica = orm.HoraMedicaDAO.createHoraMedica();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rce, reserva, fecha, asp, idBox, idMedico
			orm.HoraMedicaDAO.save(lormHoraMedica);
			orm.Medico lormMedico = orm.MedicoDAO.createMedico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : horaMedica, idPersona, especialidad
			orm.MedicoDAO.save(lormMedico);
			orm.Especialidad lormEspecialidad = orm.EspecialidadDAO.createEspecialidad();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : medico, nombreEspecialidad
			orm.EspecialidadDAO.save(lormEspecialidad);
			orm.Box lormBox = orm.BoxDAO.createBox();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : horaMedica, nroHabitacion
			orm.BoxDAO.save(lormBox);
			orm.DirectorHospital lormDirectorHospital = orm.DirectorHospitalDAO.createDirectorHospital();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : reporte, idPersona
			orm.DirectorHospitalDAO.save(lormDirectorHospital);
			orm.Reporte lormReporte = orm.ReporteDAO.createReporte();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idTipoReporte, resultado, fecha, idDirectorHospital
			orm.ReporteDAO.save(lormReporte);
			orm.TipoReporte lormTipoReporte = orm.TipoReporteDAO.createTipoReporte();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : reporte, tipo
			orm.TipoReporteDAO.save(lormTipoReporte);
			orm.Rce lormRce = orm.RceDAO.createRce();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : receta, diagnosticoidDiagnostico, procedimiento, actividad, certificado, tiempoControl, horaInicioAtencion, fechaAtencion, destino, tipoCierre, pacienteCronico, patologiaGes, pacienteGes, hipotesisDiagnostico, indicacionCierreCaso, indicacionMedica, examenFisico, alergia, anamnesis, idHoraMedica, idHce, tipoEncuentro
			orm.RceDAO.save(lormRce);
			orm.Hce lormHce = orm.HceDAO.createHce();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rce, idPaciente
			orm.HceDAO.save(lormHce);
			orm.Certificado lormCertificado = orm.CertificadoDAO.createCertificado();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rceidRce, tipoCertificado
			orm.CertificadoDAO.save(lormCertificado);
			orm.Actividad lormActividad = orm.ActividadDAO.createActividad();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rceidRce, idDiagnostico, tipoActividad
			orm.ActividadDAO.save(lormActividad);
			orm.Procedimiento lormProcedimiento = orm.ProcedimientoDAO.createProcedimiento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rceidRce, idDiagnostico, tipoProcedimiento
			orm.ProcedimientoDAO.save(lormProcedimiento);
			orm.Diagnostico lormDiagnostico = orm.DiagnosticoDAO.createDiagnostico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : procedimiento, actividad, rceidRce, nombre
			orm.DiagnosticoDAO.save(lormDiagnostico);
			orm.Receta lormReceta = orm.RecetaDAO.createReceta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idRce, contenido
			orm.RecetaDAO.save(lormReceta);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTaller2Data createTaller2Data = new CreateTaller2Data();
			try {
				createTaller2Data.createTestData();
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
