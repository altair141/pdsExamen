/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListTaller2Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Persona...");
		orm.Persona[] ormPersonas = orm.PersonaDAO.listPersonaByQuery(null, null);
		int length = Math.min(ormPersonas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormPersonas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Reserva...");
		orm.Reserva[] ormReservas = orm.ReservaDAO.listReservaByQuery(null, null);
		length = Math.min(ormReservas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormReservas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Paciente...");
		orm.Paciente[] ormPacientes = orm.PacienteDAO.listPacienteByQuery(null, null);
		length = Math.min(ormPacientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormPacientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing HoraMedica...");
		orm.HoraMedica[] ormHoraMedicas = orm.HoraMedicaDAO.listHoraMedicaByQuery(null, null);
		length = Math.min(ormHoraMedicas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormHoraMedicas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Medico...");
		orm.Medico[] ormMedicos = orm.MedicoDAO.listMedicoByQuery(null, null);
		length = Math.min(ormMedicos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormMedicos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Especialidad...");
		orm.Especialidad[] ormEspecialidads = orm.EspecialidadDAO.listEspecialidadByQuery(null, null);
		length = Math.min(ormEspecialidads.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormEspecialidads[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Box...");
		orm.Box[] ormBoxs = orm.BoxDAO.listBoxByQuery(null, null);
		length = Math.min(ormBoxs.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormBoxs[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing DirectorHospital...");
		orm.DirectorHospital[] ormDirectorHospitals = orm.DirectorHospitalDAO.listDirectorHospitalByQuery(null, null);
		length = Math.min(ormDirectorHospitals.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormDirectorHospitals[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Reporte...");
		orm.Reporte[] ormReportes = orm.ReporteDAO.listReporteByQuery(null, null);
		length = Math.min(ormReportes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormReportes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TipoReporte...");
		orm.TipoReporte[] ormTipoReportes = orm.TipoReporteDAO.listTipoReporteByQuery(null, null);
		length = Math.min(ormTipoReportes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormTipoReportes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Rce...");
		orm.Rce[] ormRces = orm.RceDAO.listRceByQuery(null, null);
		length = Math.min(ormRces.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormRces[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Hce...");
		orm.Hce[] ormHces = orm.HceDAO.listHceByQuery(null, null);
		length = Math.min(ormHces.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormHces[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Certificado...");
		orm.Certificado[] ormCertificados = orm.CertificadoDAO.listCertificadoByQuery(null, null);
		length = Math.min(ormCertificados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormCertificados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Actividad...");
		orm.Actividad[] ormActividads = orm.ActividadDAO.listActividadByQuery(null, null);
		length = Math.min(ormActividads.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormActividads[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Procedimiento...");
		orm.Procedimiento[] ormProcedimientos = orm.ProcedimientoDAO.listProcedimientoByQuery(null, null);
		length = Math.min(ormProcedimientos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormProcedimientos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing CierreCaso...");
		orm.CierreCaso[] ormCierreCasos = orm.CierreCasoDAO.listCierreCasoByQuery(null, null);
		length = Math.min(ormCierreCasos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormCierreCasos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Diagnostico...");
		orm.Diagnostico[] ormDiagnosticos = orm.DiagnosticoDAO.listDiagnosticoByQuery(null, null);
		length = Math.min(ormDiagnosticos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormDiagnosticos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Establecimiento...");
		orm.Establecimiento[] ormEstablecimientos = orm.EstablecimientoDAO.listEstablecimientoByQuery(null, null);
		length = Math.min(ormEstablecimientos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormEstablecimientos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Persona by Criteria...");
		orm.PersonaCriteria lormPersonaCriteria = new orm.PersonaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormPersonaCriteria.idPersona.eq();
		lormPersonaCriteria.setMaxResults(ROW_COUNT);
		orm.Persona[] ormPersonas = lormPersonaCriteria.listPersona();
		int length =ormPersonas== null ? 0 : Math.min(ormPersonas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormPersonas[i]);
		}
		System.out.println(length + " Persona record(s) retrieved."); 
		
		System.out.println("Listing Reserva by Criteria...");
		orm.ReservaCriteria lormReservaCriteria = new orm.ReservaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormReservaCriteria.idReserva.eq();
		lormReservaCriteria.setMaxResults(ROW_COUNT);
		orm.Reserva[] ormReservas = lormReservaCriteria.listReserva();
		length =ormReservas== null ? 0 : Math.min(ormReservas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormReservas[i]);
		}
		System.out.println(length + " Reserva record(s) retrieved."); 
		
		System.out.println("Listing Paciente by Criteria...");
		orm.PacienteCriteria lormPacienteCriteria = new orm.PacienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormPacienteCriteria.idPaciente.eq();
		lormPacienteCriteria.setMaxResults(ROW_COUNT);
		orm.Paciente[] ormPacientes = lormPacienteCriteria.listPaciente();
		length =ormPacientes== null ? 0 : Math.min(ormPacientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormPacientes[i]);
		}
		System.out.println(length + " Paciente record(s) retrieved."); 
		
		System.out.println("Listing HoraMedica by Criteria...");
		orm.HoraMedicaCriteria lormHoraMedicaCriteria = new orm.HoraMedicaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormHoraMedicaCriteria.idHora.eq();
		lormHoraMedicaCriteria.setMaxResults(ROW_COUNT);
		orm.HoraMedica[] ormHoraMedicas = lormHoraMedicaCriteria.listHoraMedica();
		length =ormHoraMedicas== null ? 0 : Math.min(ormHoraMedicas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormHoraMedicas[i]);
		}
		System.out.println(length + " HoraMedica record(s) retrieved."); 
		
		System.out.println("Listing Medico by Criteria...");
		orm.MedicoCriteria lormMedicoCriteria = new orm.MedicoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormMedicoCriteria.idMedico.eq();
		lormMedicoCriteria.setMaxResults(ROW_COUNT);
		orm.Medico[] ormMedicos = lormMedicoCriteria.listMedico();
		length =ormMedicos== null ? 0 : Math.min(ormMedicos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormMedicos[i]);
		}
		System.out.println(length + " Medico record(s) retrieved."); 
		
		System.out.println("Listing Especialidad by Criteria...");
		orm.EspecialidadCriteria lormEspecialidadCriteria = new orm.EspecialidadCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormEspecialidadCriteria.idEspecialidad.eq();
		lormEspecialidadCriteria.setMaxResults(ROW_COUNT);
		orm.Especialidad[] ormEspecialidads = lormEspecialidadCriteria.listEspecialidad();
		length =ormEspecialidads== null ? 0 : Math.min(ormEspecialidads.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormEspecialidads[i]);
		}
		System.out.println(length + " Especialidad record(s) retrieved."); 
		
		System.out.println("Listing Box by Criteria...");
		orm.BoxCriteria lormBoxCriteria = new orm.BoxCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormBoxCriteria.idHabitacion.eq();
		lormBoxCriteria.setMaxResults(ROW_COUNT);
		orm.Box[] ormBoxs = lormBoxCriteria.listBox();
		length =ormBoxs== null ? 0 : Math.min(ormBoxs.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormBoxs[i]);
		}
		System.out.println(length + " Box record(s) retrieved."); 
		
		System.out.println("Listing DirectorHospital by Criteria...");
		orm.DirectorHospitalCriteria lormDirectorHospitalCriteria = new orm.DirectorHospitalCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormDirectorHospitalCriteria.id.eq();
		lormDirectorHospitalCriteria.setMaxResults(ROW_COUNT);
		orm.DirectorHospital[] ormDirectorHospitals = lormDirectorHospitalCriteria.listDirectorHospital();
		length =ormDirectorHospitals== null ? 0 : Math.min(ormDirectorHospitals.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormDirectorHospitals[i]);
		}
		System.out.println(length + " DirectorHospital record(s) retrieved."); 
		
		System.out.println("Listing Reporte by Criteria...");
		orm.ReporteCriteria lormReporteCriteria = new orm.ReporteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormReporteCriteria.id.eq();
		lormReporteCriteria.setMaxResults(ROW_COUNT);
		orm.Reporte[] ormReportes = lormReporteCriteria.listReporte();
		length =ormReportes== null ? 0 : Math.min(ormReportes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormReportes[i]);
		}
		System.out.println(length + " Reporte record(s) retrieved."); 
		
		System.out.println("Listing TipoReporte by Criteria...");
		orm.TipoReporteCriteria lormTipoReporteCriteria = new orm.TipoReporteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormTipoReporteCriteria.id.eq();
		lormTipoReporteCriteria.setMaxResults(ROW_COUNT);
		orm.TipoReporte[] ormTipoReportes = lormTipoReporteCriteria.listTipoReporte();
		length =ormTipoReportes== null ? 0 : Math.min(ormTipoReportes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormTipoReportes[i]);
		}
		System.out.println(length + " TipoReporte record(s) retrieved."); 
		
		System.out.println("Listing Rce by Criteria...");
		orm.RceCriteria lormRceCriteria = new orm.RceCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormRceCriteria.idRce.eq();
		lormRceCriteria.setMaxResults(ROW_COUNT);
		orm.Rce[] ormRces = lormRceCriteria.listRce();
		length =ormRces== null ? 0 : Math.min(ormRces.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormRces[i]);
		}
		System.out.println(length + " Rce record(s) retrieved."); 
		
		System.out.println("Listing Hce by Criteria...");
		orm.HceCriteria lormHceCriteria = new orm.HceCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormHceCriteria.idHce.eq();
		lormHceCriteria.setMaxResults(ROW_COUNT);
		orm.Hce[] ormHces = lormHceCriteria.listHce();
		length =ormHces== null ? 0 : Math.min(ormHces.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormHces[i]);
		}
		System.out.println(length + " Hce record(s) retrieved."); 
		
		System.out.println("Listing Certificado by Criteria...");
		orm.CertificadoCriteria lormCertificadoCriteria = new orm.CertificadoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormCertificadoCriteria.id.eq();
		lormCertificadoCriteria.setMaxResults(ROW_COUNT);
		orm.Certificado[] ormCertificados = lormCertificadoCriteria.listCertificado();
		length =ormCertificados== null ? 0 : Math.min(ormCertificados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormCertificados[i]);
		}
		System.out.println(length + " Certificado record(s) retrieved."); 
		
		System.out.println("Listing Actividad by Criteria...");
		orm.ActividadCriteria lormActividadCriteria = new orm.ActividadCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormActividadCriteria.id.eq();
		lormActividadCriteria.setMaxResults(ROW_COUNT);
		orm.Actividad[] ormActividads = lormActividadCriteria.listActividad();
		length =ormActividads== null ? 0 : Math.min(ormActividads.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormActividads[i]);
		}
		System.out.println(length + " Actividad record(s) retrieved."); 
		
		System.out.println("Listing Procedimiento by Criteria...");
		orm.ProcedimientoCriteria lormProcedimientoCriteria = new orm.ProcedimientoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormProcedimientoCriteria.id.eq();
		lormProcedimientoCriteria.setMaxResults(ROW_COUNT);
		orm.Procedimiento[] ormProcedimientos = lormProcedimientoCriteria.listProcedimiento();
		length =ormProcedimientos== null ? 0 : Math.min(ormProcedimientos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormProcedimientos[i]);
		}
		System.out.println(length + " Procedimiento record(s) retrieved."); 
		
		System.out.println("Listing CierreCaso by Criteria...");
		orm.CierreCasoCriteria lormCierreCasoCriteria = new orm.CierreCasoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormCierreCasoCriteria.id.eq();
		lormCierreCasoCriteria.setMaxResults(ROW_COUNT);
		orm.CierreCaso[] ormCierreCasos = lormCierreCasoCriteria.listCierreCaso();
		length =ormCierreCasos== null ? 0 : Math.min(ormCierreCasos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormCierreCasos[i]);
		}
		System.out.println(length + " CierreCaso record(s) retrieved."); 
		
		System.out.println("Listing Diagnostico by Criteria...");
		orm.DiagnosticoCriteria lormDiagnosticoCriteria = new orm.DiagnosticoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormDiagnosticoCriteria.idDiagnostico.eq();
		lormDiagnosticoCriteria.setMaxResults(ROW_COUNT);
		orm.Diagnostico[] ormDiagnosticos = lormDiagnosticoCriteria.listDiagnostico();
		length =ormDiagnosticos== null ? 0 : Math.min(ormDiagnosticos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormDiagnosticos[i]);
		}
		System.out.println(length + " Diagnostico record(s) retrieved."); 
		
		System.out.println("Listing Establecimiento by Criteria...");
		orm.EstablecimientoCriteria lormEstablecimientoCriteria = new orm.EstablecimientoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormEstablecimientoCriteria.id.eq();
		lormEstablecimientoCriteria.setMaxResults(ROW_COUNT);
		orm.Establecimiento[] ormEstablecimientos = lormEstablecimientoCriteria.listEstablecimiento();
		length =ormEstablecimientos== null ? 0 : Math.min(ormEstablecimientos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormEstablecimientos[i]);
		}
		System.out.println(length + " Establecimiento record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListTaller2Data listTaller2Data = new ListTaller2Data();
			try {
				listTaller2Data.listTestData();
				//listTaller2Data.listByCriteria();
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
