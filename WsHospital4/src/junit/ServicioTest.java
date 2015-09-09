package junit;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import utilitario.Transformar;
import capaNegocio.fichaMedicaDomain.ActividadVO;
import capaNegocio.fichaMedicaDomain.CertificadoVO;
import capaNegocio.fichaMedicaDomain.DiagnosticoVO;
import capaNegocio.fichaMedicaDomain.HceVO;
import capaNegocio.fichaMedicaDomain.ProcedimientoVO;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.fichaMedicaDomain.RecetaVO;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.openmrs.Concepto;
import capaNegocio.openmrs.Observacion;
import capaNegocio.openmrs.PacienteOpen;
import capaNegocio.openmrs.PersonaOpen;
import capaNegocio.personas.Medico;
import capaNegocio.personas.Paciente;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;
import capaServicio.Servicio;

public class ServicioTest {

	@Test
	public void obtenerListaPacientestest() {
		Servicio s=new Servicio();
		System.out.println(s.obtenerListaPacientes());
	}
	
	
	@Test
	public void obtenerPaciente(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerPaciente("1819975"));
	}
	@Test
	public void pacienteJson() {
		Paciente pa= new Paciente();
		PacienteVO paciente=pa.obtenerPacientePorId(1);		
		String json =Transformar.paciente(paciente);
		System.out.println(json);
		PacienteVO p=Transformar.pacienteVO(json);
		
		System.out.println(Transformar.paciente(p));
	}
	
	@Test
	public void registrarPacienteOpenTest() {
		
		Paciente paciente=new Paciente();
		////System.out.println(paciente.validarPaciente("141f"));
		Servicio s=new Servicio();
		
		System.out.println(s.registrarPacienteOpen("1"));
		
		
		//System.out.println(Transformar.paciente(p));
		//Servicio s = new Servicio();		
		//System.out.println( s.registrarPacienteOpen(jsonPaciente));

	}
	
	@Test
	public void obtenerHoraMedica(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerHoraMedica("1"));
		
	}	
	
	@Test
	public void obtenerHCE(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerHCE("1"));
	}
	@Test
	public void obtenerIdHCe(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerIdHCE("1"));
	}
	
	@Test
	public void buscarHorasPorIdPaciente(){
		Servicio s=new Servicio();
		System.out.println(s.buscarHorasPorIdPaciente("1"));
	}
	
	@Test
	public void testobtenerListaProcedimientos() {
		Servicio s = new Servicio();
		System.out.println(s.obtenerListaProcedimientos());
	}

	@Test
	public void testobtenerListaActividades() {
		Servicio s = new Servicio();
		System.out.println(s.obtenerListaActividades());
	}

	@Test
	public void testobtenerListaDiagnosticos() {
		Servicio s = new Servicio();
		System.out.println(s.obtenerListaDiagnosticos());
	}
	
	@Test
	public void obtenerHcePacientePorNombre(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerHcePacientePorNombre("141"));
	}
	@Test
	public void registrarMedicoOpenmrs(){
		//Medico m=new Medico();
		//System.out.println(m.validarMedicoOpen("1"));
		
		Servicio s=new Servicio();
		System.out.println(s.registrarMedicoOpenmrs("1"));
	}
	
	@Test
	public void registrarRce(){
		RceVO rcevo=new RceVO();
		rcevo.setAlergia("alergia");
		rcevo.setAnamnesis("anamnesis");
		rcevo.setDestino("destino");
		rcevo.setExamenFisico("examenfisico");
		rcevo.setFechaAtencion(new Date());
		rcevo.setFechaCierreClinico(new Date());
		rcevo.setHipotesisDiagnostico("hipotesisdiagnostico");
		rcevo.setHoraCierreClienico("horacierre");
		rcevo.setHoraInicioAtencion("horainicio");
		HceVO idHce=new HceVO(1);
		rcevo.setIdHce(idHce);
		HoraMedicaVO idHoraMedica=new HoraMedicaVO(1);
		
		rcevo.setIdHoraMedica(idHoraMedica);
		rcevo.setIndicacionCierreCaso("indicacioncierre");
		rcevo.setIndicacionMedica("indicacionmedica");
		rcevo.setPacienteCronico("pacientecronico");
		rcevo.setPacienteGes("pacienteges");
		rcevo.setPatologiaGes("patologiages");
		rcevo.setTiempoControl("tiempocontro");
		rcevo.setTipoCierre("tiempocierre");
		rcevo.setTipoEncuentro("tipoencuentro");
		
		CertificadoVO certificado1 = new CertificadoVO(1);
		CertificadoVO certificado2 = new CertificadoVO(3);
		CertificadoVO certificado3 = new CertificadoVO(5);
		CertificadoVO certificado4 = new CertificadoVO(7);
		CertificadoVO certificado5 = new CertificadoVO(9);
		CertificadoVO certificado6 = new CertificadoVO(11);
		CertificadoVO certificado7 = new CertificadoVO(13);
		CertificadoVO certificado8 = new CertificadoVO(15);
		CertificadoVO certificado9 = new CertificadoVO(16);
		CertificadoVO certificado10 = new CertificadoVO(18);
		CertificadoVO certificado11 = new CertificadoVO(20);
		CertificadoVO certificado12= new CertificadoVO(21);
		CertificadoVO certificado13 = new CertificadoVO(23);
		CertificadoVO certificado14= new CertificadoVO(25);
		CertificadoVO certificado15= new CertificadoVO(27);
		rcevo.agregarCertificado(certificado1);
		rcevo.agregarCertificado(certificado2);
		rcevo.agregarCertificado(certificado3);
		rcevo.agregarCertificado(certificado4);
		rcevo.agregarCertificado(certificado5);
		rcevo.agregarCertificado(certificado6);
		rcevo.agregarCertificado(certificado7);
		rcevo.agregarCertificado(certificado8);
		rcevo.agregarCertificado(certificado9);
		rcevo.agregarCertificado(certificado10);
		rcevo.agregarCertificado(certificado11);
		rcevo.agregarCertificado(certificado12);
		rcevo.agregarCertificado(certificado13);
		rcevo.agregarCertificado(certificado14);
		rcevo.agregarCertificado(certificado15);
		
		ActividadVO actividad1=new ActividadVO(1);
		ActividadVO actividad2=new ActividadVO(2);
		ActividadVO actividad3=new ActividadVO(3);
		rcevo.agregarActividad(actividad1);
		rcevo.agregarActividad(actividad2);
		rcevo.agregarActividad(actividad3);

		
		ProcedimientoVO procedimiento1=new ProcedimientoVO(1);
		ProcedimientoVO procedimiento2=new ProcedimientoVO(2);
		rcevo.agregarProcedimiento(procedimiento1);
		rcevo.agregarProcedimiento(procedimiento2);
	

		
		DiagnosticoVO diagnostico1=new DiagnosticoVO(1);

		rcevo.agregarDiagnostico(diagnostico1);



		String json=Transformar.rce1(rcevo);
		System.out.println(json);
		Servicio s=new Servicio();
		System.out.println("id rce "+s.registrarRce(json));
		//RceVO rce=Transformar.jsonToRce2(json);
		
		//System.out.println(Transformar.rce1(rce));
	}
	
	@Test
	public void receta(){
		RecetaVO receta=new RecetaVO();
		receta.setContenido("medicamentos asdasd");
		RceVO rce=new RceVO(1);
		receta.setRce(rce);
		String jsonreceta=Transformar.receta(receta);
		System.out.println("json receta"+jsonreceta);
		Servicio s=new Servicio();
		System.out.println(s.registrarReceta(jsonreceta));
	}
	@Test
	public void obtenerPacienteID(){
		Servicio s=new Servicio();
		System.out.println(s.buscarPacienteId("2"));
	}
	@Test
	public void obtenerRce(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerRcePorId("1"));
	}
	
	@Test
	public void obtenerRceCompleto(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerRceCompleto("18"));
	}
	@Test
	public void diagnostico(){
		Servicio s=new Servicio();
		String listaActi=s.obtenerListaActividades();
		System.out.println(listaActi);
		List<ActividadVO>lis=Transformar.jsonToActividad2(listaActi);
		listaActi=Transformar.actividadLista(lis);
		System.out.println(listaActi); 
	}
	
	@Test
	public void obtenerReceta(){
		Servicio s=new Servicio();
		System.out.println(s.buscarReceta("6"));
		
	}
	@Test
	public void listaReceta(){
		Servicio s=new Servicio();
		System.out.println(s.buscarRecetasPoridRce("20"));
	}
	@Test
	public void registrarConcepto(){
		Concepto conce=new Concepto();
		conce.setName("conceptoPruebas anamnesis");
		conce.setTipoConcepto(1);
		//String jsonConcepto=Transformar.concepto(conce);
		System.out.println(conce.getConceptClass());
		System.out.println(conce.getDatatype());
		System.out.println(conce.getName());
		conce.asignarconceptClass(conce.getTipoConcepto());
		System.out.println(conce.getConceptClass());
		System.out.println(conce.registrarConcepto(conce));
	}
	@Test
	public void registrarObs(){
		Observacion obs=new Observacion();
		obs.setConcepto("05f89026-cfe2-46cb-acdd-3942fb2f2d4e");
		obs.setEncuentro("8d8fefbb-7919-4a79-90c2-6252c3f7e1b8");
		obs.setFecha("2015-08-01");
		obs.setPersona("66c24658-0941-4d00-b952-ed4bc2c9a8b8");
		String json=Transformar.observacion(obs);
		System.out.println(json);
		Observacion ob=Transformar.jsonToObservacion(json);
		if(ob==null){
			System.out.println("no funk");
		}
		//System.out.println(obs.registrarObservacion(obs));
	}
}



