/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTaller2Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.createPersona();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : directorHospital, medico, paciente, reserva, uuid, estado, nombre
			orm.PersonaDAO.save(lormPersona);
			orm.Reserva lormReserva = orm.ReservaDAO.createReserva();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idPersonaRegistra, idHoraMedica, idPaciente
			orm.ReservaDAO.save(lormReserva);
			orm.Paciente lormPaciente = orm.PacienteDAO.createPaciente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : hce, reserva, idPersona, nroFichaMedica
			orm.PacienteDAO.save(lormPaciente);
			orm.HoraMedica lormHoraMedica = orm.HoraMedicaDAO.createHoraMedica();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : reserva, idEstablecimiento, uuid, fecha, asp, idBox, idMedico
			orm.HoraMedicaDAO.save(lormHoraMedica);
			orm.Medico lormMedico = orm.MedicoDAO.createMedico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : horaMedica, idEstablecimiento, idPersona, especialidad
			orm.MedicoDAO.save(lormMedico);
			orm.Especialidad lormEspecialidad = orm.EspecialidadDAO.createEspecialidad();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : medico, nombreEspecialidad
			orm.EspecialidadDAO.save(lormEspecialidad);
			orm.Box lormBox = orm.BoxDAO.createBox();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : horaMedica, idEstablecimiento, nroHabitacion
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
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : cierreCaso, certificado, idProcedimiento, idActividad, idDiagnostico, receta, pacienteCronico, patologiaGes, pacienteGes, hipotesisDiagnostico, indicacionCierreCaso, indicacionMedica, examenFisico, alergia, anamnesis, idHce, uuid, tipoEncuentro
			orm.RceDAO.save(lormRce);
			orm.Hce lormHce = orm.HceDAO.createHce();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rce, idPaciente
			orm.HceDAO.save(lormHce);
			orm.Certificado lormCertificado = orm.CertificadoDAO.createCertificado();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rceidRce, tipoCertificado
			orm.CertificadoDAO.save(lormCertificado);
			orm.Actividad lormActividad = orm.ActividadDAO.createActividad();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rce, idDiagnostico, tipoActividad
			orm.ActividadDAO.save(lormActividad);
			orm.Procedimiento lormProcedimiento = orm.ProcedimientoDAO.createProcedimiento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : rce, idDiagnostico, tipoProcedimiento
			orm.ProcedimientoDAO.save(lormProcedimiento);
			orm.CierreCaso lormCierreCaso = orm.CierreCasoDAO.createCierreCaso();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : idRce, tiempoControl, horaInicioAtencion, fechaAtencion, destino, tipoCierre
			orm.CierreCasoDAO.save(lormCierreCaso);
			orm.Diagnostico lormDiagnostico = orm.DiagnosticoDAO.createDiagnostico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : procedimiento, actividad, rce, uuid, nombre
			orm.DiagnosticoDAO.save(lormDiagnostico);
			orm.Establecimiento lormEstablecimiento = orm.EstablecimientoDAO.createEstablecimiento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : box, horaMedica, medico, nombre
			orm.EstablecimientoDAO.save(lormEstablecimiento);
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
