package junit;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import utilitario.Transformar;
import capaNegocio.fichamedica.Encuentro;
import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.CertificadoVO;
//import capaNegocio.fichamedicaDomain.CierreCasoMedicoVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.EncuentroVO;
import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;
import capaNegocio.fichamedicaDomain.RceVO;
import capaNegocio.fichamedicaDomain.VisitaVO;
import capaNegocio.hospital.HoraMedica;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.personas.Paciente;
import capaNegocio.personas.Persona;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;
import capaNegocio.rest.PacienteOpen;
import capaServicio.Servicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ServicioTest {


	@Test
	public void testPersonaNameRest() {
		Servicio s = new Servicio();
		String respuesta = s
				.personaNameRest("34a906f3-7284-4458-bccf-d647958318e7");
		System.out.println(respuesta);
		assertTrue(respuesta != "no encontrado");
	}

	@Test
	public void testPacienteUuidRest() {
		Servicio s = new Servicio();
		String respuesta = s
				.pacienteUuidRest("34a906f3-7284-4458-bccf-d647958318e7");
		System.out.println(respuesta);
		assertTrue(respuesta != "no encontrado");
	}

	@Test
	public void testRegistrarPaciente() {
		String json = "";
		PersonaVO p = new PersonaVO();
		p.setApellidos("Cisternas");
		p.setDireccion("serca de la ufro");
		p.setEstado("true");
		Date fecha = Transformar.stringToDate("1996-03-29");
		p.setFechaNacimiento(fecha);
		p.setNombre("ema");

		json = Transformar.persona(p);
		Servicio s = new Servicio();
		System.out.println(s.registrarPersona(json));

	}

	@Test
	public void testSincronizarPersona() {

		Servicio s = new Servicio();
		System.out
				.println(s
						.sincronizarPersonaToLocal("aa992eb6-30f7-4a38-894c-bbad84f35def"));
	}

	@Test
	public void testbuscarPersonaPorIdLocal() {
		Servicio s = new Servicio();
		System.out.println(s.buscarPersonaPorIdLocal("3"));
	}

	@Test
	public void testbuscarPersonaLocalPorUuid() {
		Servicio s = new Servicio();
		System.out.println(s.buscarPersonaLocalPorUuid("zds"));
	}

	@Test
	public void mostrarPacientes() {
		Servicio s = new Servicio();
		System.out.println(s.mostrarPacientes());
	}

	@Test
	public void registrarPaciente() {
		// se crea el paciente
		PersonaVO p = new PersonaVO();
		p.setApellidos("Cisternas");
		p.setDireccion("serca de la ufro");
		p.setEstado("true");
		Date fecha = Transformar.stringToDate("1996-03-29");
		p.setFechaNacimiento(fecha);
		p.setNombre("ema");

		PacienteVO paciente = new PacienteVO();

		paciente.setNroFicha("141asd");
		paciente.setPersona(p);
		String respuesta = Transformar.paciente(paciente);
		System.out.println(respuesta);
		// fin creacion paciente
		Servicio s = new Servicio();
		System.out.println("id hce" + s.registrarPaciente(respuesta));

	}

	@Test
	public void TestsincronizarPaciente() {
		Servicio s = new Servicio();
		s.sincronizarPaciente("aa992eb6-30f7-4a38-894c-bbad84f35def");
	}
/*
	@Test
	public void testCierre() {
		RceVO rcevo = new RceVO();
		String tipoCierre = "asd";
		String destino = "asdd";
		String fechaAtencion = "2015-08-19";
		String horaInicioAtencion = "12:40";
		String fechaCierreClinico = "2015-09-19";
		String horaCierreCLinico = "13:00";
		String tiempoControl = "no teiene";
		rcevo.setAlergia("trabajar");
		rcevo.setAnamnesis("no se");
		rcevo.setExamenFisico("exelente");
		rcevo.setHipotesisDiagnostico("flojera");
		ActividadVO idActividad = new ActividadVO(1);
		rcevo.setIdActividad(idActividad);
		DiagnosticoVO idDiagnostico = new DiagnosticoVO(1);
		rcevo.setIdDiagnostico(idDiagnostico);
		HceVO idHce = new HceVO(1);
		Paciente p=new Paciente();
		
				
		PersonaVO per=p.obtenerPersonaPorIdPaciente(4);
		String uuidPaciente=per.getUuid();
		rcevo.setIdHce(idHce);
		rcevo.setIdHoraMedica(0);
		HoraMedica h=new HoraMedica();
		boolean aps=h.horaEsTipo(1);
		System.out.println("boleano "+aps);
		String uuidRce="";
		String uuidencuentro="";
		if(aps){
			uuidencuentro="9fed5cb8-2af5-4ba2-a475-a2d8bc604d50";
		}else{
			uuidencuentro="8af7f6b9-832e-4ff7-9a26-12817abd4bc2";
		}
		EncuentroVO encuentroVo=new EncuentroVO();
		encuentroVo.setTipoEncuentro(uuidencuentro); 
		encuentroVo.setPaciente(uuidPaciente);
		encuentroVo.setFechaTime(fechaAtencion+" "+horaInicioAtencion+":00");
		Encuentro encuentro=new Encuentro();
		 uuidRce=encuentro.registrarEncuentroOpenmrs(encuentroVo);
		 System.out.println("uuid rce open"+uuidRce);
		 rcevo.setUuid(uuidRce);
		 
	
		ProcedimientoVO procedimiento = new ProcedimientoVO(1);
		rcevo.setIdProcedimiento(procedimiento);
		rcevo.setIndicacionCierreCaso("asdasdas");
		rcevo.setIndicacionMedica("asdasads");
		rcevo.setPacienteCronico("si");
		rcevo.setPacienteGes("no");
		rcevo.setPatologiaGes("no");
		rcevo.setReceta("no tiene receta");
		rcevo.setTipoEncuentro("primera vez");

		CertificadoVO certificado1 = new CertificadoVO(1);
		CertificadoVO certificado2 = new CertificadoVO(3);
		CertificadoVO certificado3 = new CertificadoVO(5);
		CertificadoVO certificado4 = new CertificadoVO(7);
		CertificadoVO certificado5 = new CertificadoVO(9);
		CertificadoVO certificado6 = new CertificadoVO(11);
		rcevo.agregarCertificado(certificado1);
		rcevo.agregarCertificado(certificado2);
		rcevo.agregarCertificado(certificado3);
		rcevo.agregarCertificado(certificado4);
		rcevo.agregarCertificado(certificado5);
		rcevo.agregarCertificado(certificado6);

		String asd = Transformar.Rce(rcevo);
		Servicio s = new Servicio();
		 
		 String id=s.registrarRce(asd);
		RceVO rceVo = Transformar.jsonToRce(asd);
		rcevo.setIdRce(Transformar.stringToInt(id));
		System.out.println(asd);

	
		
		Date fechINi=Transformar.stringToDate(fechaAtencion);
		Date fechaCie=Transformar.stringToDate(fechaCierreClinico);
		
		CierreCasoMedicoVO cie=new CierreCasoMedicoVO();
		cie.setDestino(destino);
		cie.setFechaAtencion(fechINi);
		cie.setFechaCierreClinico(fechaCie);
		cie.setHoraCierreClienico(horaCierreCLinico);
		cie.setHoraInicioAtencion(horaInicioAtencion);
		System.out.println(rcevo.getIdRce());
		cie.setRce(rcevo);
		cie.setTiempoControl(tiempoControl);
		cie.setTipoCierre(tipoCierre);
		String jsonCierre=Transformar.cierreCaso(cie);
		System.out.println(jsonCierre);
		System.out.println(s.registrarCierreCasoMedico(jsonCierre));
	}*/

	@Test
	public void testSincronizarPaciente() {
		Servicio s = new Servicio();

		String listaPacientes = s.buscarPacientePorNombre("");
		System.out.println(listaPacientes);

		try {
			JsonElement jelement = new JsonParser().parse(listaPacientes);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");

			for (int i = 0; i < jarray.size(); i++) {
				jobject = jarray.get(i).getAsJsonObject();
				String uuid = jobject.get("uuid").getAsString();

				System.out.println("sincroni" + s.sincronizarPaciente(uuid));
			}
		} catch (NullPointerException e) {
			System.out.println("errornulo");
		} catch (UnsupportedOperationException e) {
			System.out.println("error estructura");

		}

	}

	@Test
	public void testSincronizarMedico() {
		Servicio s = new Servicio();
		String listaMedicos = s.buscarMedicoOpen("");
		System.out.println("lista:: " + listaMedicos);

		try {
			JsonElement jelement = new JsonParser().parse(listaMedicos);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");

			for (int i = 0; i < jarray.size(); i++) {
				jobject = jarray.get(i).getAsJsonObject();
				String uuid = jobject.get("uuid").getAsString();
				System.out.println(uuid);
				s.sincronizarMedicoToLocal(uuid);

			}
		} catch (NullPointerException e) {
			System.out.println("errornulo");
		} catch (UnsupportedOperationException e) {
			System.out.println("error estructura");

		}

		// crear todo nuevamente

		try {
			JsonElement jelement = new JsonParser().parse(listaMedicos);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");

			for (int i = 0; i < jarray.size(); i++) {
				jobject = jarray.get(i).getAsJsonObject();
				String uuid = jobject.get("uuid").getAsString();
				System.out.println("medico: " + s.medicoUuidRest(uuid));
				s.sincronizarMedicoToLocal(uuid);
			}
		} catch (NullPointerException e) {
			System.out.println("error nulo");
		} catch (UnsupportedOperationException e) {
			System.out.println("error soporte");
		}
	}

	@Test
	public void testBuscarPacienteBdLocal() {
		Servicio s = new Servicio();
		System.out.println("asdf"+s.buscarPacienteBdLocal("pa"));

	}

	@Test
	public void testMostrarPaciente() {
		Servicio s = new Servicio();
		System.out.println(s.mostrarPacientes());
	}

	@Test
	public void testBuscarPacienteBdLocalId() {
		Servicio s = new Servicio();
		PacienteVO pa=Transformar.jsonBDPaciente(s.buscarPacienteBdLocalId("3"));
		System.out.println(pa.getPersona().getUuid());
		
		// {"results":[{"id":0,"persona":{"id":0}}]}
	}

	@Test
	public void testObtenerHCE() {
		Servicio s = new Servicio();
		System.out.println("asd" + s.obtenerHCE("3"));
	}

	@Test
	public void testobtenerIdHCE() {
		Servicio s = new Servicio();
		System.out.println("asd" + s.obtenerIdHCE("3"));
	}

	@Test
	public void testobtenerHoraMedica() {
		Servicio s = new Servicio();

		String hora = s.obtenerHoraMedica("1");
		System.out.println(hora);
		JsonElement jelement2 = new JsonParser().parse(hora);
		JsonObject jobject2 = jelement2.getAsJsonObject();
		JsonArray jarray2 = jobject2.getAsJsonArray("results");
		jobject2 = jarray2.get(0).getAsJsonObject();
		JsonObject boxJson = jobject2.get("box").getAsJsonObject();
		JsonObject establecimientoJson = boxJson.get("establecimiento")
				.getAsJsonObject();
		System.out.println(establecimientoJson.get("nombre").getAsString());
	}

	@Test
	public void buscarHorasPorIdPaciente() {
		Servicio s = new Servicio();
		System.out.println(s.buscarHorasPorIdPaciente("1"));
	}

	@Test
	public void buscarHoraAPSPorIdPaciente() {
		Servicio s = new Servicio();
		System.out.println(s.buscarHorasAPSPorIdPaciente("1"));
	}

	@Test
	public void buscarHorasControlPorIdPaciente() {
		Servicio s = new Servicio();
		System.out.println(s.buscarHorasControlPorIdPaciente("1"));
	}

	@Test
	public void pacienteopen() {
		PacienteOpen p = new PacienteOpen();
		p.setIdentifier("12236");
		p.setPersonUUid("19a2b3f8-4467-4266-8f8a-44b014faae3a");
		Paciente pac = new Paciente();
		System.out.println(pac.registrarPacienteOpenmrs(p));

	}

	@Test
	public void personaopen() {
		PersonaVO p = new PersonaVO();
		p.setApellidos("Scarlet");
		p.setDireccion("florencia, italia");
		p.setEstado("F");
		Date fecha = Transformar.stringToDate("1969-03-29");
		p.setFechaNacimiento(fecha);
		p.setNombre("Elsa");
		Persona per = new Persona();
		String res = per.registrarPersonaOpenmrs(p);
		System.out.println(res);

		PacienteOpen ps = new PacienteOpen();
		ps.setIdentifier("12236");
		ps.setPersonUUid(res);
		Paciente pac = new Paciente();
		System.out.println(pac.registrarPacienteOpenmrs(ps));
		/*
		 * try {
		 * 
		 * ClientConfig clientConfig = new DefaultClientConfig(); Client client
		 * = Client.create(clientConfig); client.addFilter(new
		 * HTTPBasicAuthFilter("admin", "Admin123")); WebResource webResource =
		 * client .resource("http://localhost:8080/openmrs/ws/rest/v1/person");
		 * 
		 * String input =
		 * "{\"gender\":\"M\", \"birthdate\":\"1978-12-04\" ,\"names\": [{\"givenName\":\"johnathan\", \"familyName\":\"Confort\"}],\"addresses\":[{\"preferred\":\"true\",\"address1\":\"av.nunca viva\"}]}"
		 * ;
		 * 
		 * ClientResponse response = webResource.type("application/json")
		 * .post(ClientResponse.class, input);
		 * 
		 * if (response.getStatus() != 201) { throw new
		 * RuntimeException("Failed : HTTP error code : " +
		 * response.getStatus()); }
		 * 
		 * System.out.println("Output from Server .... \n"); String output =
		 * response.getEntity(String.class); System.out.println(output);
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */
	}

	@Test
	public void provadno() {
		String horaMedica = "Aug 12, 2015";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateInString = "2014-02-12 12:00:00";
		Date date = null;

		String json = "{\"results\":[{\"id\":1,\"medico\":{\"id\":1,\"especialidad\":{\"id\":1,\"nombre\":\"médicina general\"},\"hospital\":{\"id\":1,\"nombre\":\"hospital regional\"},\"persona\":{\"id\":5,\"nombre\":\"1 - dr. casa\",\"estado\":\"true\",\"uuid\":\"84c3facf-c11c-460d-9f7e-420cc88adab2\"}},\"box\":{\"Box\":1,\"nroHabitacion\":\"12-4\",\"establecimiento\":{\"id\":1,\"nombre\":\"hospital regional\"}},\"asp\":\"true\",\"fecha\":\"2015-08-20 12:00:00\",\"uuid\":\"asdsfstdrgtrt\"}]}";
		HoraMedicaVO h = Transformar.jsonTOHoraMedica(json);
		try {

			date = formatter.parse(dateInString);
			h.setFecha(date);

			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(h);
		String respuesta = "{\"results\":[" + listaResultado + "]}";

		System.out.println(respuesta);
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
	public void registrarVisita(){
		Servicio s = new Servicio();
		String fechaHtml="2015-08-29";
		String horaHtml="14:30";
		String complementoHora=":00";
		String fechaCompleta=fechaHtml+" "+horaHtml+complementoHora;
		Date fechaCom=Transformar.stringToDate(fechaCompleta);
		String uuidPaciente="34a906f3-7284-4458-bccf-d647958318e7";
		String uuidTipo="73bbb069-9781-4afc-a9d1-54b6b2270e01";
		VisitaVO visita=new VisitaVO();
		visita.setUuidPaciente(uuidPaciente);
		visita.setStartDateTime(fechaCom);
		visita.setUuidVisitType(uuidTipo);
		
		String jsonVisita=Transformar.visita(visita);
		System.out.println(jsonVisita);
		System.out.println(s.registrarVisita(jsonVisita));
	}
	@Test
	public void registrarEcuentro(){
		Servicio s = new Servicio();
		String fechaHtml="2015-08-26";
		String horaHtml="14:30";
		String complementoHora=":00";
		String fechaCompleta=fechaHtml+" "+horaHtml+complementoHora;
		Date fechaCom=Transformar.stringToDate(fechaCompleta);
		String uuidPaciente="34a906f3-7284-4458-bccf-d647958318e7";
		String uuidTipo="9fed5cb8-2af5-4ba2-a475-a2d8bc604d50";
		EncuentroVO encuentro=new EncuentroVO();
		encuentro.setPaciente(uuidPaciente);
		encuentro.setFechaTime(fechaCompleta);
		encuentro.setTipoEncuentro(uuidTipo);
		
		String jsonVisita=Transformar.encuentro(encuentro);
		System.out.println(jsonVisita);
		System.out.println(s.registrarEncuentro(jsonVisita));
	}
	
	@Test
	public void azar(){
		String texto = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while (i < 38) {
			char c = (char) r.nextInt(255);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				texto += c;
				i++;
			}
		}
		System.out.println(texto);
	}
	@Test
	public void obtenerRceId(){
		Servicio s = new Servicio();
		System.out.println(s.obtenerRcePorId("1"));
	}
	@Test
	public void obtenerHcePacientePorNombre(){
		Servicio s=new Servicio();
		System.out.println(s.obtenerHcePacientePorNombre("12236 - Elsa Scarlet"));
	}
}

