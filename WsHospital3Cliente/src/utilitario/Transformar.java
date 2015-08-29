package utilitario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.CertificadoVO;
//import capaNegocio.fichamedicaDomain.CierreCasoMedicoVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;
import capaNegocio.fichamedicaDomain.RceVO;
import capaNegocio.hospitalDomain.BoxVO;
import capaNegocio.hospitalDomain.EncuentroVO;
import capaNegocio.hospitalDomain.EstablecimientoVO;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.personasDomain.EspecialidadVO;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Transformar {

	public static String persona(capaNegocio.personasDomain.PersonaVO persona) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(persona);
		System.out.println(listaResultado);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static String personas(
			List<capaNegocio.personasDomain.PersonaVO> personas) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(personas);
		return listaResultado;
	}

	public static PersonaVO jsonToPersonaLocal(String json) {
		System.out.println(json);
		PersonaVO persona = new PersonaVO();
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		for (int i = 0; i < jarray.size(); i++) {
			jobject = jarray.get(i).getAsJsonObject();
			persona.setId(jobject.get("id").getAsInt());
			persona.setApellidos(jobject.get("apellidos").getAsString());
			persona.setDireccion(jobject.get("direccion").getAsString());
			persona.setEstado(jobject.get("estado").getAsString());
			Date fechaNacimiento = stringToDate(jobject.get("fechaNacimiento")
					.getAsString());
			persona.setFechaNacimiento(fechaNacimiento);
			persona.setNombre(jobject.get("nombre").getAsString());
			persona.setUuid(jobject.get("uuid").getAsString());
			break;
		}

		return persona;
	}

	public static PersonaVO jsonToPersonaLocalsinUuid(String json) {
		System.out.println(json);
		PersonaVO persona = new PersonaVO();
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		for (int i = 0; i < jarray.size(); i++) {
			jobject = jarray.get(i).getAsJsonObject();
			persona.setId(jobject.get("id").getAsInt());
			persona.setApellidos(jobject.get("apellidos").getAsString());
			persona.setDireccion(jobject.get("direccion").getAsString());
			persona.setEstado(jobject.get("estado").getAsString());
			String fecha = jobject.get("fechaNacimiento").getAsString();
			System.out.println("esta es la fecha naci" + fecha);
			Date fechaNacimiento = stringToDate(fecha);
			persona.setFechaNacimiento(fechaNacimiento);
			persona.setNombre(jobject.get("nombre").getAsString());

			break;
		}

		return persona;
	}

	public static PersonaVO jsonOpenToPersonaLocal(String json) {
		System.out.println(json);
		PersonaVO persona = new PersonaVO();
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		for (int i = 0; i < jarray.size(); i++) {
			jobject = jarray.get(i).getAsJsonObject();
			persona.setApellidos(jobject.get("apellidos").getAsString());
			persona.setDireccion(jobject.get("direccion").getAsString());
			persona.setEstado(jobject.get("estado").getAsString());
			Date fechaNacimiento = stringToDate(jobject.get("fechaNacimiento")
					.getAsString());
			persona.setFechaNacimiento(fechaNacimiento);
			persona.setNombre(jobject.get("nombre").getAsString());
			persona.setUuid(jobject.get("uuid").getAsString());
			break;
		}

		return persona;
	}

	public static PersonaVO jsonToOpenmrsPersona(String jsonNombrePersona,
			String jsonPersona, String jsonDireccionPersona) {
		String nombre = "";
		String nombre2 = "";
		String apellido = "";
		String apellido2 = "";
		String uuid = "";
		String fechaNacimiento = "";
		String direccion = "";
		String pais = "";

		PersonaVO persona = new PersonaVO();
		JsonElement jelement = new JsonParser().parse(jsonNombrePersona);
		JsonObject jobject = jelement.getAsJsonObject();

		JsonArray jarray = jobject.getAsJsonArray("results");

		jobject = jarray.get(0).getAsJsonObject();

		nombre = jobject.get("givenName").getAsString();
		if (nombre == null) {
			nombre = "";
		}
		try {
			nombre2 = jobject.get("middleName").getAsString();
		} catch (NullPointerException e) {
			nombre2 = "";
		}
		try {
			apellido = jobject.get("familyName").getAsString();
		} catch (NullPointerException e) {
			apellido = "";
		} catch (UnsupportedOperationException e) {
			apellido = "";
		}

		try {
			apellido2 = jobject.get("familyName2").getAsString();
		} catch (NullPointerException e) {
			apellido2 = "";
		} catch (UnsupportedOperationException e) {
			apellido2 = "";
		}

		nombre = nombre + " " + nombre2;
		apellido = apellido + " " + apellido2;
		JsonElement jelement2 = new JsonParser().parse(jsonPersona);
		JsonObject jobject2 = jelement2.getAsJsonObject();

		JsonArray jarray2 = jobject2.getAsJsonArray("results");

		jobject2 = jarray2.get(0).getAsJsonObject();
		uuid = jobject2.get("uuid").getAsString();
		try {
			fechaNacimiento = jobject2.get("birthdate").getAsString();
			persona.setFechaNacimiento(stringToDate(fechaNacimiento));
		} catch (NullPointerException e) {

		} catch (UnsupportedOperationException e) {

		}

		JsonElement jelement3 = new JsonParser().parse(jsonDireccionPersona);
		JsonObject jobject3 = jelement3.getAsJsonObject();
		JsonArray jarray3 = jobject3.getAsJsonArray("results");
		jobject3 = jarray3.get(0).getAsJsonObject();
		direccion = jobject3.get("display").getAsString();
		try {
			pais = jobject3.get("country").getAsString();
		} catch (NullPointerException e) {
			pais = "";
		} catch (UnsupportedOperationException e) {
			pais = "";
		}
		direccion = direccion + ", " + pais;

		persona.setApellidos(apellido);
		persona.setNombre(nombre);
		persona.setDireccion(direccion);

		persona.setUuid(uuid);
		persona.setEstado("true");

		return persona;
	}

	// -----------------------------persona---------------------------------------------------------------------

	// ----------------------------paciente--------------------------------------------------------------------

	public static String paciente(capaNegocio.personasDomain.PacienteVO paciente) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(paciente);

		return "{\"results\":[" + listaResultado + "]}";

	}

	public static String pacientes(
			List<capaNegocio.personasDomain.PacienteVO> pacientes) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(pacientes);
		return listaResultado;
	}

	public static PacienteVO pacienteConPersonaSinidSinUuid(String jsonPaciente) {
		PersonaVO persona = new PersonaVO();
		PacienteVO paciente = new PacienteVO();
		JsonElement jelement = new JsonParser().parse(jsonPaciente);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		jobject = jarray.get(0).getAsJsonObject();
		paciente.setNroFicha(jobject.get("nroFicha").getAsString());
		JsonObject personaJson = jobject.get("persona").getAsJsonObject();
		persona.setApellidos(personaJson.get("apellidos").getAsString());
		persona.setDireccion(personaJson.get("direccion").getAsString());
		persona.setEstado(personaJson.get("estado").getAsString());
		Date fechaNacimiento = stringToDate(personaJson.get("fechaNacimiento")
				.getAsString());
		persona.setFechaNacimiento(fechaNacimiento);
		persona.setNombre(personaJson.get("nombre").getAsString());
		paciente.setPersona(persona);
		return paciente;
	}

	public static PacienteVO jsonOpenmrsPaciente(String jsonPaciente) {
		PacienteVO paciente = new PacienteVO();
		JsonElement jelement = new JsonParser().parse(jsonPaciente);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		jobject = jarray.get(0).getAsJsonObject();
		paciente.setNroFicha(jobject.get("display").getAsString());
		return paciente;
	}

	public static PacienteVO jsonbdPaciente(String jsonPaciente) {
		PacienteVO paciente = new PacienteVO();
		JsonElement jelement = new JsonParser().parse(jsonPaciente);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		jobject = jarray.get(0).getAsJsonObject();
		paciente.setNroFicha(jobject.get("nroFicha").getAsString());
		return paciente;
	}

	// -----------------------------paciente----------------------------------------------------------------------

	// --------------------------------------rce--------------------------------------------------------------------

	public static RceVO jsonToRce(String json) {
		RceVO rce = new RceVO();
		try {

			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			rce.setTipoEncuentro(jobject.get("tipoEncuentro").getAsString());
			rce.setIdHoraMedica(stringToInt(jobject.get("idHoraMedica")
					.getAsString()));
			rce.setAnamnesis(jobject.get("anamnesis").getAsString());
			rce.setAlergia(jobject.get("alergia").getAsString());
			rce.setExamenFisico(jobject.get("examenFisico").getAsString());
			rce.setIndicacionMedica(jobject.get("indicacionMedica")
					.getAsString());
			rce.setIndicacionCierreCaso(jobject.get("indicacionCierreCaso")
					.getAsString());
			rce.setHipotesisDiagnostico(jobject.get("hipotesisDiagnostico")
					.getAsString());
			rce.setPacienteGes(jobject.get("pacienteGes").getAsString());
			rce.setPatologiaGes(jobject.get("patologiaGes").getAsString());
			rce.setPacienteCronico(jobject.get("pacienteCronico").getAsString());
			rce.setReceta(jobject.get("receta").getAsString());

			JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
			String idHce = hceJson.get("id").getAsString();
			HceVO hce = new HceVO(stringToInt(idHce));
			rce.setIdHce(hce);

			JsonObject diagnosticojson = jobject.get("idDiagnostico")
					.getAsJsonObject();
			String idDiagnostico = diagnosticojson.get("id").getAsString();
			DiagnosticoVO diagnostico = new DiagnosticoVO(
					stringToInt(idDiagnostico));
			rce.setIdDiagnostico(diagnostico);

			JsonObject actividadjson = jobject.get("idActividad")
					.getAsJsonObject();
			String idActividad = actividadjson.get("id").getAsString();
			ActividadVO actividad = new ActividadVO(stringToInt(idActividad));
			rce.setIdActividad(actividad);

			JsonObject procedimientojson = jobject.get("idProcedimiento")
					.getAsJsonObject();
			String idprocedimiento = procedimientojson.get("id").getAsString();
			ProcedimientoVO procedimiento = new ProcedimientoVO(
					stringToInt(idprocedimiento));
			rce.setIdProcedimiento(procedimiento);

			JsonArray listaCertificadosjson = jobject
					.getAsJsonArray("listaCertificados");

			for (int i = 0; i < listaCertificadosjson.size(); i++) {
				JsonObject certificadosJson = listaCertificadosjson.get(i)
						.getAsJsonObject();
				String idCertificado = certificadosJson.get("id").getAsString();
				CertificadoVO certificado = new CertificadoVO(
						stringToInt(idCertificado));
				rce.agregarCertificado(certificado);

			}

			return rce;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		}

	}

	public static String Rce(capaNegocio.fichamedicaDomain.RceVO rce) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(rce);
		return "{\"results\":[" + listaResultado + "]}";

	}
	public static String Rce2(capaNegocio.fichamedicaDomain.RceVO rce) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
				.create();
		String listaResultado = gson.toJson(rce);
		return "{\"results\":[" + listaResultado + "]}";

	}
	// --------------------------------------rce------------
	// --------------------------------------------------------
	// --------------------------------------cierre caso
	// medico----------------------------------------------------

	/*public static String cierreCaso(
			capaNegocio.fichamedicaDomain.CierreCasoMedicoVO cierreCaso) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(cierreCaso);
		return "{\"results\":[" + listaResultado + "]}";

	}*/
/*
	public static CierreCasoMedicoVO cierreCasoMedico(String json) {
		try {

			CierreCasoMedicoVO cierreCaso = new CierreCasoMedicoVO();
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			cierreCaso.setDestino(jobject.get("destino").getAsString());
			Date fechaAten = stringToDate(jobject.get("fechaAtencion")
					.getAsString());
			cierreCaso.setFechaAtencion(fechaAten);
			Date fechaCierre = stringToDate(jobject.get("fechaCierreClinico")
					.getAsString());
			cierreCaso.setFechaCierreClinico(fechaCierre);

			cierreCaso.setHoraCierreClienico(jobject.get("horaCierreClinico")
					.getAsString());
			cierreCaso.setHoraInicioAtencion(jobject.get("horaInicioAtencion")
					.getAsString());
			cierreCaso.setTiempoControl(jobject.get("tiempoControl")
					.getAsString());
			cierreCaso.setTipoCierre(jobject.get("tipoCierre").getAsString());
			JsonObject personaJson = jobject.get("rce").getAsJsonObject();
			RceVO rce = new RceVO(StringToInt(personaJson.get("idRce")
					.getAsString()));
			cierreCaso.setRce(rce);

			return cierreCaso;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		}
	}*/

	// --------------------------------------cierre caso
	// medico----------------------------------------------------

	// ---------------------------medico----------------------------------------------------------------------------

	// ---------------------------medico----------------------------------------------------------------------------

	public static Date stringToDate(String fecha) {
		System.out.println(validarFecha(fecha));
		System.out.println(validarFecha2(fecha));
		System.out.println(validarFecha3(fecha));
		if (validarFecha3(fecha)) {
			try {

				DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str1 = fecha;
				Date date = f.parse(str1);
				return date;

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (NullPointerException c) {
				return null;
			}

		} else if (validarFecha2(fecha)) {
			try {

				DateFormat f = new SimpleDateFormat("MMM dd, yyyy");
				String str1 = fecha;
				Date date = f.parse(str1);
				return date;

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (NullPointerException c) {
				return null;
			}
		} else if (validarFecha(fecha)) {
			try {

				DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
				String str1 = fecha;
				Date date = f.parse(str1);
				return date;

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (NullPointerException c) {
				return null;
			}
		}

		return null;
	}

	public static boolean validarFecha(String fecha) {
		try {
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			String str1 = fecha;
			Date date = f.parse(str1);
			return true;
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException c) {
			return false;
		}

	}

	public static int stringToInt(String texto) {
		try {
			int numero = Integer.parseInt(texto);
			return numero;
		} catch (NumberFormatException e) {
			return -1;
		} catch (NullPointerException e) {
			return -1;
		}
	}

	public static HoraMedicaVO jsonTOHoraMedica(String jsonHoraMedica) {
		HoraMedicaVO horaMedica = new HoraMedicaVO();
		try {
			JsonElement jelement = new JsonParser().parse(jsonHoraMedica);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			horaMedica.setAsp(jobject.get("asp").getAsString());
			horaMedica.setId(jobject.get("id").getAsInt());
			horaMedica.setUuid(jobject.get("uuid").getAsString());
			Date fecha = stringToDate(jobject.get("fecha").getAsString());
			horaMedica.setFecha(fecha);

			MedicoVO medico = new MedicoVO();
			JsonObject medi = jobject.get("medico").getAsJsonObject();
			medico.setId(medi.get("id").getAsInt());

			EspecialidadVO especialidad = new EspecialidadVO();
			JsonObject especi = medi.get("especialidad").getAsJsonObject();
			especialidad.setId(especi.get("id").getAsInt());
			especialidad.setNombre(especi.get("nombre").getAsString());
			medico.setEspecialidad(especialidad);

			EstablecimientoVO hospital = new EstablecimientoVO();
			JsonObject hospi = medi.get("hospital").getAsJsonObject();
			hospital.setId(hospi.get("id").getAsInt());
			hospital.setNombre(hospi.get("nombre").getAsString());
			medico.setHospital(hospital);

			PersonaVO persona = new PersonaVO();
			JsonObject person = medi.get("persona").getAsJsonObject();
			persona.setId(person.get("id").getAsInt());
			try {
				persona.setApellidos(person.get("apellidos").getAsString());
			} catch (NullPointerException e) {

			} catch (UnsupportedOperationException e) {

			} catch (IllegalStateException e) {

			}
			persona.setNombre(person.get("nombre").getAsString());
			persona.setEstado(person.get("estado").getAsString());
			persona.setUuid(person.get("uuid").getAsString());
			medico.setPersona(persona);

			JsonObject boxJson = jobject.get("box").getAsJsonObject();
			BoxVO box = new BoxVO();
			box.setBox(boxJson.get("Box").getAsInt());
			box.setNroHabitacion(boxJson.get("nroHabitacion").getAsString());

			EstablecimientoVO hospital2 = new EstablecimientoVO();
			JsonObject hospi2 = boxJson.get("establecimiento")
					.getAsJsonObject();
			hospital2.setId(hospi2.get("id").getAsInt());
			hospital2.setNombre(hospi2.get("nombre").getAsString());
			box.setEstablecimiento(hospital2);
			horaMedica.setBox(box);
			horaMedica.setMedico(medico);
			return horaMedica;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static boolean validarFecha2(String fecha) {
		try {
			DateFormat f = new SimpleDateFormat("MMM dd, yyyy");
			String str1 = fecha;
			Date date = f.parse(str1);
			return true;
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException c) {
			return false;
		}

	}

	public static boolean validarFecha3(String fecha) {
		try {
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str1 = fecha;
			Date date = f.parse(str1);
			return true;
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException c) {
			return false;
		}

	}

	public static String datetoStringHoraMedica(Date fecha) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reportDate = df.format(fecha);
		return reportDate;
	}
	public static String datetoStringRce(Date fecha) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String reportDate = df.format(fecha);
		return reportDate;
	}
	public static List<DiagnosticoVO> jsonToDiagnostico(String jsonDiagnostico) {
		List<DiagnosticoVO> listaDiagnostico = new ArrayList<DiagnosticoVO>();

		try {
			JsonElement jelement = new JsonParser().parse(jsonDiagnostico);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int i = 0; i < jarray.size(); i++) {
				DiagnosticoVO diagnostico = new DiagnosticoVO();
				jobject = jarray.get(i).getAsJsonObject();
				diagnostico.setNombre(jobject.get("nombre").getAsString());
				diagnostico.setId(jobject.get("id").getAsInt());
				diagnostico.setUuid(jobject.get("uuid").getAsString());
				listaDiagnostico.add(diagnostico);
			}
			return listaDiagnostico;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static DiagnosticoVO jsonToDiagnosticoNoLista(String jsonDiagnostico) {
		DiagnosticoVO diagnostico = new DiagnosticoVO();

		try {
			JsonElement jelement = new JsonParser().parse(jsonDiagnostico);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			
			
				jobject = jarray.get(0).getAsJsonObject();
				diagnostico.setNombre(jobject.get("nombre").getAsString());
				diagnostico.setId(jobject.get("id").getAsInt());
				diagnostico.setUuid(jobject.get("uuid").getAsString());
				
			
			return diagnostico;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	public static List<ActividadVO> jsonToActividad(String jsonActividad) {
		List<ActividadVO> listaActividad = new ArrayList<ActividadVO>();

		try {

			JsonElement jelement = new JsonParser().parse(jsonActividad);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int i = 0; i < jarray.size(); i++) {
				ActividadVO actividad = new ActividadVO();
				DiagnosticoVO diagnostico = new DiagnosticoVO();
				jobject = jarray.get(i).getAsJsonObject();
				actividad.setNombreActividad(jobject.get("nombreActividad")
						.getAsString());
				System.out.println(actividad.getNombreActividad());
				actividad.setId(jobject.get("id").getAsInt());
				JsonObject diagnostic = jobject.get("diagnostico")
						.getAsJsonObject();
				diagnostico.setId(diagnostic.get("id").getAsInt());
				diagnostico.setNombre(diagnostic.get("nombre").getAsString());
				diagnostico.setUuid(diagnostic.get("uuid").getAsString());
				actividad.setDiagnostico(diagnostico);
				listaActividad.add(actividad);
			}

			return listaActividad;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	public static ActividadVO jsonToActividadNoLista(String jsonActividad) {
		

		try {

			JsonElement jelement = new JsonParser().parse(jsonActividad);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
		
				ActividadVO actividad = new ActividadVO();
				DiagnosticoVO diagnostico = new DiagnosticoVO();
				jobject = jarray.get(0).getAsJsonObject();
				actividad.setNombreActividad(jobject.get("nombreActividad")
						.getAsString());
				System.out.println(actividad.getNombreActividad());
				actividad.setId(jobject.get("id").getAsInt());
				JsonObject diagnostic = jobject.get("diagnostico")
						.getAsJsonObject();
				diagnostico.setId(diagnostic.get("id").getAsInt());
				diagnostico.setNombre(diagnostic.get("nombre").getAsString());
				diagnostico.setUuid(diagnostic.get("uuid").getAsString());
				actividad.setDiagnostico(diagnostico);

			return actividad;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	public static List<ProcedimientoVO> jsonToProcedimiento(
			String jsonProcedimiento) {
		List<ProcedimientoVO> listaProcedimiento = new ArrayList<ProcedimientoVO>();

		try {

			JsonElement jelement = new JsonParser().parse(jsonProcedimiento);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int i = 0; i < jarray.size(); i++) {
				ProcedimientoVO procedimiento = new ProcedimientoVO();
				DiagnosticoVO diagnostico = new DiagnosticoVO();
				jobject = jarray.get(i).getAsJsonObject();
				procedimiento.setNombre(jobject.get("nombre").getAsString());
				procedimiento.setId(jobject.get("id").getAsInt());
				JsonObject diagnostic = jobject.get("diagnostico")
						.getAsJsonObject();
				diagnostico.setId(diagnostic.get("id").getAsInt());
				diagnostico.setNombre(diagnostic.get("nombre").getAsString());
				diagnostico.setUuid(diagnostic.get("uuid").getAsString());
				procedimiento.setDiagnostico(diagnostico);
				listaProcedimiento.add(procedimiento);
			}
			return listaProcedimiento;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static ProcedimientoVO jsonToProcedimientoNoLista(
			String jsonProcedimiento) {
	
		try {

			JsonElement jelement = new JsonParser().parse(jsonProcedimiento);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");
			
				ProcedimientoVO procedimiento = new ProcedimientoVO();
				DiagnosticoVO diagnostico = new DiagnosticoVO();
				jobject = jarray.get(0).getAsJsonObject();
				procedimiento.setNombre(jobject.get("nombre").getAsString());
				procedimiento.setId(jobject.get("id").getAsInt());
				JsonObject diagnostic = jobject.get("diagnostico")
						.getAsJsonObject();
				diagnostico.setId(diagnostic.get("id").getAsInt());
				diagnostico.setNombre(diagnostic.get("nombre").getAsString());
				diagnostico.setUuid(diagnostic.get("uuid").getAsString());
				procedimiento.setDiagnostico(diagnostico);
				
			
			return procedimiento;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	
	public static String jsonPacienteUuid(String jsonPaciente) {

		try {
			JsonElement jelement = new JsonParser().parse(jsonPaciente);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			JsonObject persona = jobject.get("persona").getAsJsonObject();
			String paciente = persona.get("uuid").getAsString();

			return paciente;
		} catch (NullPointerException e) {
			return "no encontrado";
		} catch (UnsupportedOperationException e) {
			return "no encontrado";
		} catch (IllegalStateException e) {
			return "no encontrado";
		}
	}

	public static String encuentro(EncuentroVO encuentro) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(encuentro);
		return "{\"results\":[" + listaResultado + "]}";

	}

	public static String tipoEncuentro(String boleanHora) {
		if (boleanHora.equals("true")) {
			return "9fed5cb8-2af5-4ba2-a475-a2d8bc604d50";
		} else {

			return "8af7f6b9-832e-4ff7-9a26-12817abd4bc2";
		}
	}

	public static String azarTexto() {
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
		return texto;
	}
	public static RceVO jsonToRce2(String json) {
		RceVO rce = new RceVO();
		try {
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();

			String tipoEncuentro = jobject.get("tipoEncuentro").getAsString();
			System.out.println("0 "+tipoEncuentro);
			rce.setTipoEncuentro(tipoEncuentro);

			String uuid = jobject.get("uuid").getAsString();
			System.out.println("1 "+uuid);
			rce.setUuid(uuid);

			JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
			String idHce = hceJson.get("id").getAsString();
			System.out.println("2 "+idHce);
			HceVO hce = new HceVO(stringToInt(idHce));
			rce.setIdHce(hce);

			String idHoraMedica = jobject.get("idHoraMedica").getAsString();
			System.out.println("3 "+idHoraMedica);
			rce.setIdHoraMedica(stringToInt(idHoraMedica));
			
			String anamnesis=jobject.get("anamnesis").getAsString();
			System.out.println("4 "+anamnesis);
			rce.setAnamnesis(anamnesis);
			
			String alergia=jobject.get("alergia").getAsString();
			System.out.println("5 "+alergia);
			rce.setAlergia(alergia);
			
			String examenFisico=jobject.get("examenFisico").getAsString();
			System.out.println("6 "+examenFisico);			
			rce.setExamenFisico(examenFisico);
			
			String indicacionMedica=jobject.get("indicacionMedica").getAsString();
			System.out.println("7 "+indicacionMedica);
			rce.setIndicacionMedica(indicacionMedica);
			
			String indicacionCasocierre=jobject.get("indicacionCierreCaso").getAsString();
			System.out.println("8 "+indicacionCasocierre);
			rce.setIndicacionCierreCaso(indicacionCasocierre);
			
			String hipotesisDiagnos=jobject.get("hipotesisDiagnostico").getAsString();
			System.out.println("9 "+hipotesisDiagnos);
			rce.setHipotesisDiagnostico(hipotesisDiagnos);
			
			String pacienteGes=jobject.get("pacienteGes").getAsString();
			System.out.println("10 "+pacienteGes);
			rce.setPacienteGes(pacienteGes);
			
			String patologiaGes=jobject.get("patologiaGes").getAsString();
			System.out.println("11 "+patologiaGes);
			rce.setPatologiaGes(patologiaGes);
			
			String pacienteCroni=jobject.get("pacienteCronico").getAsString();
			System.out.println("12 "+pacienteCroni);
			rce.setPacienteCronico(pacienteCroni);
			
			String receta=jobject.get("receta").getAsString();
			System.out.println("13 "+receta);
			rce.setReceta(receta);	
			
			JsonObject diagnosticojson = jobject.get("idDiagnostico").getAsJsonObject();
			String idDiagnostico = diagnosticojson.get("id").getAsString();
			System.out.println("14 "+idDiagnostico);
			DiagnosticoVO diagnostico = new DiagnosticoVO(stringToInt(idDiagnostico));
			rce.setIdDiagnostico(diagnostico);
			
			JsonObject actividadjson = jobject.get("idActividad").getAsJsonObject();
			String idActividad = actividadjson.get("id").getAsString();
			System.out.println("15 "+idActividad);
			ActividadVO actividad = new ActividadVO(stringToInt(idActividad));
			rce.setIdActividad(actividad);
			
			
			JsonObject procedimientojson = jobject.get("idProcedimiento").getAsJsonObject();
			String idprocedimiento = procedimientojson.get("id").getAsString();
			System.out.println("16 "+idprocedimiento);
			ProcedimientoVO procedimiento = new ProcedimientoVO(stringToInt(idprocedimiento));
			rce.setIdProcedimiento(procedimiento);
			
			String tipoCierre=jobject.get("tipoCierre").getAsString();
			System.out.println("17 "+tipoCierre);
			rce.setTipoCierre(tipoCierre);
			
			String destino=jobject.get("destino").getAsString();
			System.out.println("18 "+destino);
			rce.setDestino(destino);
			
			
			String fecha=jobject.get("fechaAtencion").getAsString();
			System.out.println("19 "+ fecha);
			Date fechaAten = stringToDate(fecha);
			rce.setFechaAtencion(fechaAten);
			
			String horaInicio=jobject.get("horaInicioAtencion").getAsString();
			System.out.println("20"+ horaInicio);
			rce.setHoraInicioAtencion(horaInicio);
			
			String fechaFin=jobject.get("fechaCierreClinico").getAsString();
			System.out.println("21 "+fechaFin);
			Date fechaCierre = stringToDate(fechaFin);
			rce.setFechaCierreClinico(fechaCierre);
			
			String horaFin=jobject.get("horaCierreClienico").getAsString();
			System.out.println("22 "+horaFin); 
			rce.setHoraCierreClienico(horaFin);
			String tiempoControl=jobject.get("tiempoControl").getAsString();
			System.out.println("23 "+tiempoControl);
			rce.setTiempoControl(tiempoControl); 
			JsonArray listaCertificadosjson = jobject.getAsJsonArray("listaCertificados");

			for (int i = 0; i < listaCertificadosjson.size(); i++) {
				JsonObject certificadosJson = listaCertificadosjson.get(i).getAsJsonObject();
				String idCertificado = certificadosJson.get("id").getAsString();
				System.out.println((24+i)+" "+ idCertificado);
				CertificadoVO certificado = new CertificadoVO(stringToInt(idCertificado));
				rce.agregarCertificado(certificado);

			}
			
			return rce;
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	/**
	 * 
	 * @param json string con el json de datos del rce con id de la bd local
	 * @return objeto rce
	 */
	public static RceVO jsonToRce3(String json) {
		RceVO rce = new RceVO();
		try {
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();

			String tipoEncuentro = jobject.get("tipoEncuentro").getAsString();
			System.out.println("0 "+tipoEncuentro);
			rce.setTipoEncuentro(tipoEncuentro);
			
			String id=jobject.get("idRce").getAsString();
			System.out.println(id);
			rce.setIdRce(stringToInt(id));
			String uuid = jobject.get("uuid").getAsString();
			System.out.println("1 "+uuid);
			rce.setUuid(uuid);

			JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
			String idHce = hceJson.get("id").getAsString();
			System.out.println("2 "+idHce);
			
			HceVO hce = new HceVO(stringToInt(idHce));
			rce.setIdHce(hce);

			String idHoraMedica = jobject.get("idHoraMedica").getAsString();
			System.out.println("3 "+idHoraMedica);
			rce.setIdHoraMedica(stringToInt(idHoraMedica));
			
			String anamnesis=jobject.get("anamnesis").getAsString();
			System.out.println("4 "+anamnesis);
			rce.setAnamnesis(anamnesis);
			
			String alergia=jobject.get("alergia").getAsString();
			System.out.println("5 "+alergia);
			rce.setAlergia(alergia);
			
			String examenFisico=jobject.get("examenFisico").getAsString();
			System.out.println("6 "+examenFisico);			
			rce.setExamenFisico(examenFisico);
			
			String indicacionMedica=jobject.get("indicacionMedica").getAsString();
			System.out.println("7 "+indicacionMedica);
			rce.setIndicacionMedica(indicacionMedica);
			
			String indicacionCasocierre=jobject.get("indicacionCierreCaso").getAsString();
			System.out.println("8 "+indicacionCasocierre);
			rce.setIndicacionCierreCaso(indicacionCasocierre);
			
			String hipotesisDiagnos=jobject.get("hipotesisDiagnostico").getAsString();
			System.out.println("9 "+hipotesisDiagnos);
			rce.setHipotesisDiagnostico(hipotesisDiagnos);
			
			String pacienteGes=jobject.get("pacienteGes").getAsString();
			System.out.println("10 "+pacienteGes);
			rce.setPacienteGes(pacienteGes);
			
			String patologiaGes=jobject.get("patologiaGes").getAsString();
			System.out.println("11 "+patologiaGes);
			rce.setPatologiaGes(patologiaGes);
			
			String pacienteCroni=jobject.get("pacienteCronico").getAsString();
			System.out.println("12 "+pacienteCroni);
			rce.setPacienteCronico(pacienteCroni);
			
			String receta=jobject.get("receta").getAsString();
			System.out.println("13 "+receta);
			rce.setReceta(receta);	
			
			JsonObject diagnosticojson = jobject.get("idDiagnostico").getAsJsonObject();
			String idDiagnostico = diagnosticojson.get("id").getAsString();
			System.out.println("14 "+idDiagnostico);
			DiagnosticoVO diagnostico = new DiagnosticoVO(stringToInt(idDiagnostico));
			rce.setIdDiagnostico(diagnostico);
			
			JsonObject actividadjson = jobject.get("idActividad").getAsJsonObject();
			String idActividad = actividadjson.get("id").getAsString();
			System.out.println("15 "+idActividad);
			ActividadVO actividad = new ActividadVO(stringToInt(idActividad));
			rce.setIdActividad(actividad);
			
			
			JsonObject procedimientojson = jobject.get("idProcedimiento").getAsJsonObject();
			String idprocedimiento = procedimientojson.get("id").getAsString();
			System.out.println("16 "+idprocedimiento);
			ProcedimientoVO procedimiento = new ProcedimientoVO(stringToInt(idprocedimiento));
			rce.setIdProcedimiento(procedimiento);
			
			String tipoCierre=jobject.get("tipoCierre").getAsString();
			System.out.println("17 "+tipoCierre);
			rce.setTipoCierre(tipoCierre);
			
			String destino=jobject.get("destino").getAsString();
			System.out.println("18 "+destino);
			rce.setDestino(destino);
			
			
			String fecha=jobject.get("fechaAtencion").getAsString();
			System.out.println("19 "+ fecha);
			Date fechaAten = stringToDate(fecha);
			rce.setFechaAtencion(fechaAten);
			
			String horaInicio=jobject.get("horaInicioAtencion").getAsString();
			System.out.println("20"+ horaInicio);
			rce.setHoraInicioAtencion(horaInicio);
			
			String fechaFin=jobject.get("fechaCierreClinico").getAsString();
			System.out.println("21 "+fechaFin);
			Date fechaCierre = stringToDate(fechaFin);
			rce.setFechaCierreClinico(fechaCierre);
			
			String horaFin=jobject.get("horaCierreClienico").getAsString();
			System.out.println("22 "+horaFin); 
			rce.setHoraCierreClienico(horaFin);
			String tiempoControl=jobject.get("tiempoControl").getAsString();
			System.out.println("23 "+tiempoControl);
			rce.setTiempoControl(tiempoControl); 
			JsonArray listaCertificadosjson = jobject.getAsJsonArray("listaCertificados");

			for (int i = 0; i < listaCertificadosjson.size(); i++) {
				JsonObject certificadosJson = listaCertificadosjson.get(i).getAsJsonObject();
				String idCertificado = certificadosJson.get("id").getAsString();
				System.out.println((24+i)+" "+ idCertificado);
				CertificadoVO certificado = new CertificadoVO(stringToInt(idCertificado));
				rce.agregarCertificado(certificado);

			}
			
			return rce;
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static String certificadoCual(String idCertificado){
		if(idCertificado.equals("1")||idCertificado.equals("2")){
			return "certificado1";
		}else if(idCertificado.equals("3")||idCertificado.equals("4")){
			return "certificado2";
		}else if(idCertificado.equals("5")||idCertificado.equals("6")){
			return "certificado3";
		}else if(idCertificado.equals("7")||idCertificado.equals("8")){
			return "certificado4";
		}else if(idCertificado.equals("9")||idCertificado.equals("10")){
			return "certificado5";
		}else if(idCertificado.equals("11")||idCertificado.equals("12")){
			return "certificado6";
		}else if(idCertificado.equals("13")||idCertificado.equals("14")){
			return "certificado7";
		}else if(idCertificado.equals("15")||idCertificado.equals("16")){
			return "certificado8";
		}else if(idCertificado.equals("17")||idCertificado.equals("18")){
			return "certificado9";
		}else if(idCertificado.equals("19")||idCertificado.equals("20")){
			return "certificado10";
		}else if(idCertificado.equals("21")||idCertificado.equals("22")){
			return "certificado11";
		}else if(idCertificado.equals("23")||idCertificado.equals("24")){
			return "certificado12";
		}else if(idCertificado.equals("25")||idCertificado.equals("26")){
			return "certificado13";
		}else if(idCertificado.equals("27")||idCertificado.equals("28")){
			return "certificado14";
		}else {
			return "certificado15";
		}
		
	}

}
