package utilitario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.CertificadoVO;
//import capaNegocio.fichamedicaDomain.CierreCasoMedicoVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.EncuentroVO;
import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;
import capaNegocio.fichamedicaDomain.RceVO;
import capaNegocio.fichamedicaDomain.VisitaVO;
import capaNegocio.hospitalDomain.BoxVO;
import capaNegocio.hospitalDomain.EstablecimientoVO;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.personasDomain.EspecialidadVO;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;
import capaNegocio.rest.Openmrs;

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
		return "{\"results\":" + listaResultado + "}";
	}

	public static String medicos(
			List<capaNegocio.personasDomain.PersonaVO> medicos) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(medicos);
		return "{\"results\":" + listaResultado + "}";
	}

	public static String jsonPersonaUud(String jsonOpen) {
		try {

			JsonElement jelement = new JsonParser().parse(jsonOpen);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			String persona = jobject.get("uuid").getAsString();

			return persona;
		} catch (NullPointerException e) {

			return "no encontrado";
		} catch (UnsupportedOperationException e) {
			return "no encontrado";
		} catch (IllegalStateException e) {
			return "no encontrado";
		}
	}

	public static PersonaVO jsonToPersonaLocal(String json) {
		try {
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
				try {
					String fecha = jobject.get("fechaNacimiento").getAsString();
					Date fechaP = stringToDate(fecha);
					persona.setFechaNacimiento(fechaP);
				} catch (NullPointerException e) {

				}
				persona.setNombre(jobject.get("nombre").getAsString());
				persona.setUuid(jobject.get("uuid").getAsString());
				break;
			}

			return persona;
		} catch (NullPointerException e) {

			return null;
		} catch (UnsupportedOperationException e) {

			return null;
		} catch (IllegalStateException e) {

			return null;
		}
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
		try {
			PersonaVO persona = new PersonaVO();
			JsonElement jelement = new JsonParser().parse(jsonNombrePersona);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");

			jobject = jarray.get(0).getAsJsonObject();

			nombre = jobject.get("givenName").getAsString();
			System.out.println("probando" + nombre);
			if (nombre == null) {
				nombre = "";
			}
			try {
				nombre2 = jobject.get("middleName").getAsString();
			} catch (NullPointerException e) {
				nombre2 = "";
			} catch (UnsupportedOperationException e) {
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
				System.out.println("fecha" + persona.getFechaNacimiento());
			} catch (NullPointerException e) {
				System.out.println("error1 fecha");
			} catch (UnsupportedOperationException e) {
				System.out.println("error2 fecha");
			}

			JsonElement jelement3 = new JsonParser()
					.parse(jsonDireccionPersona);
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
		} catch (NullPointerException e) {
			System.out.println("error1 persona");
			return null;
		} catch (UnsupportedOperationException e) {

			System.out.println("error2 personas");
			return null;
		} catch (IllegalStateException e) {

			System.out.println("error3 persona");
			return null;
		}
	}

	// -----------------------------persona---------------------------------------------------------------------

	// ----------------------------paciente--------------------------------------------------------------------

	public static String paciente(capaNegocio.personasDomain.PacienteVO paciente) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(paciente);
		return "{\"results\":[" + listaResultado + "]}";

	}

	public static String pacientes(
			List<capaNegocio.personasDomain.PacienteVO> pacientes) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
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

	public static PacienteVO jsonBDPaciente(String jsonPaciente) {
		try {
			PersonaVO persona = new PersonaVO();
			PacienteVO paciente = new PacienteVO();
			JsonElement jelement = new JsonParser().parse(jsonPaciente);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			String nroFicha = jobject.get("nroFicha").getAsString();
			System.out.println(nroFicha);
			paciente.setNroFicha(nroFicha);
			int id = stringToInt(jobject.get("id").getAsString());
			System.out.println(id);
			paciente.setId(id);
			JsonObject personaJson = jobject.get("persona").getAsJsonObject();
			int idPersona = stringToInt(personaJson.get("id").getAsString());
			System.out.println(idPersona);
			persona.setId(idPersona);
			String apellidos = personaJson.get("apellidos").getAsString();
			persona.setApellidos(apellidos);
			System.out.println(apellidos);
			String direccion = personaJson.get("direccion").getAsString();
			System.out.println(direccion);
			persona.setDireccion(direccion);
			String estado = personaJson.get("estado").getAsString();
			System.out.println(estado);
			persona.setEstado(estado);
			String uuid = personaJson.get("uuid").getAsString();
			System.out.println(uuid);
			persona.setUuid(uuid);
			String fecha = personaJson.get("fechaNacimiento").getAsString();
			System.out.println("fechaTras" + fecha);
			try {
				Date fechaNacimiento = stringToDate(fecha);
				persona.setFechaNacimiento(fechaNacimiento);
			} catch (NullPointerException e) {
				System.out.println("error ql");
			}
			persona.setNombre(personaJson.get("nombre").getAsString());

			paciente.setPersona(persona);
			return paciente;
		} catch (NullPointerException e) {

			System.out.println("error nulo");
			return null;
		} catch (UnsupportedOperationException e) {
			System.out.println("error no soportado");
			return null;
		} catch (IllegalStateException e) {
			System.out.println("error ileal");
			return null;
		}
	}

	// -----------------------------paciente----------------------------------------------------------------------

	// --------------------------------------rce--------------------------------------------------------------------

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

	public static RceVO jsonToRce(String json) {
		System.out.println("puede ser " + json);
		RceVO rce = new RceVO();
		try {

			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();

			rce.setTipoEncuentro(jobject.get("tipoEncuentro").getAsString());
			rce.setUuid(jobject.get("uuid").getAsString());

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
			// -------------------------------

			rce.setDestino(jobject.get("destino").getAsString());
			Date fechaAten = stringToDate(jobject.get("fechaAtencion")
					.getAsString());
			rce.setFechaAtencion(fechaAten);
			Date fechaCierre = stringToDate(jobject.get("fechaCierreClinico")
					.getAsString());
			rce.setFechaCierreClinico(fechaCierre);

			rce.setHoraCierreClienico(jobject.get("horaCierreClienico")
					.getAsString());
			rce.setHoraInicioAtencion(jobject.get("horaInicioAtencion")
					.getAsString());
			rce.setTiempoControl(jobject.get("tiempoControl").getAsString());
			rce.setTipoCierre(jobject.get("tipoCierre").getAsString());

			// ---------------------------------------

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
		Gson gson = new Gson();
		String listaResultado = gson.toJson(rce);
		return "{\"results\":[" + listaResultado + "]}";

	}

	public static String Rce(List<capaNegocio.fichamedicaDomain.RceVO> rce) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(rce);
		return "{\"results\":" + listaResultado + "}";

	}

	// --------------------------------------rce--------------------------------------------------------------------
	// --------------------------------------cierre caso
	// medico----------------------------------------------------
	/*
	 * public static CierreCasoMedicoVO cierreCasoMedico(String json) { try {
	 * 
	 * CierreCasoMedicoVO cierreCaso = new CierreCasoMedicoVO(); JsonElement
	 * jelement = new JsonParser().parse(json); JsonObject jobject =
	 * jelement.getAsJsonObject(); JsonArray jarray =
	 * jobject.getAsJsonArray("results"); jobject =
	 * jarray.get(0).getAsJsonObject();
	 * cierreCaso.setDestino(jobject.get("destino").getAsString()); Date
	 * fechaAten = stringToDate(jobject.get("fechaAtencion") .getAsString());
	 * cierreCaso.setFechaAtencion(fechaAten); Date fechaCierre =
	 * stringToDate(jobject.get("fechaCierreClinico") .getAsString());
	 * cierreCaso.setFechaCierreClinico(fechaCierre);
	 * 
	 * cierreCaso.setHoraCierreClienico(jobject.get("horaCierreClienico")
	 * .getAsString());
	 * cierreCaso.setHoraInicioAtencion(jobject.get("horaInicioAtencion")
	 * .getAsString()); cierreCaso.setTiempoControl(jobject.get("tiempoControl")
	 * .getAsString());
	 * cierreCaso.setTipoCierre(jobject.get("tipoCierre").getAsString());
	 * JsonObject personaJson = jobject.get("rce").getAsJsonObject(); RceVO rce
	 * = new RceVO(stringToInt(personaJson.get("idRce") .getAsString()));
	 * System.
	 * out.println("transformacion"+personaJson.get("idRce").getAsString());
	 * cierreCaso.setRce(rce);
	 * 
	 * return cierreCaso; } catch (NullPointerException e) {
	 * e.printStackTrace(); return null; } catch (UnsupportedOperationException
	 * e) { e.printStackTrace(); return null; } }
	 */
	// --------------------------------------cierre caso
	// medico----------------------------------------------------

	// ---------------------------medico----------------------------------------------------------------------------

	public static MedicoVO jsonToMedico(String jsonMedico) {
		PersonaVO persona = new PersonaVO();
		MedicoVO medicoVo = new MedicoVO();
		JsonElement jelement = new JsonParser().parse(jsonMedico);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		jobject = jarray.get(0).getAsJsonObject();
		String uuid = jobject.get("uuid").getAsString();
		String NombreNoPersona = jobject.get("display").getAsString();
		// try catch para la parte de la persona en caso de que exista
		try {
			JsonObject personaJson = jobject.get("person").getAsJsonObject();
			String uuidPersona = personaJson.get("uuid").getAsString();
			System.out.println("uuid persona medico " + uuidPersona);
			String jsonPersonaOpen = Openmrs.persona(uuidPersona);

			// obtiene los datos del nombre de la persona
			String jsonPersonaNombre = Openmrs.personaNameRest(uuidPersona);

			// obtiene la direccion de la persona
			String jsonPersonaDireccion = Openmrs.personaDireccion(uuidPersona);
			if ((jsonPersonaDireccion.equals("no encontrado"))
					&& (jsonPersonaNombre.equals("no encontrado"))
					&& (jsonPersonaOpen.equals("no encontrado"))) {

				persona.setNombre(NombreNoPersona);
				System.out.println("nombre asd " + persona.getNombre());
			} else {

				PersonaVO personaNombres = jsonNombreMedico(jsonPersonaNombre);
				persona.setNombre(personaNombres.getNombre());
				persona.setApellidos(personaNombres.getApellidos());
				PersonaVO personaDireccion = jsonDireccionMedico(jsonPersonaDireccion);
				persona.setDireccion(personaDireccion.getDireccion());
				PersonaVO personaDatos = jsonDatosMedico(jsonPersonaOpen);
				persona.setFechaNacimiento(personaDatos.getFechaNacimiento());
				/*
				 * persona = jsonToOpenmrsPersona(jsonPersonaNombre,
				 * jsonPersonaOpen, jsonPersonaDireccion);
				 */
				// System.out.println("nombre de la persona "+persona.getNombre());
			}
			// fin try
		} catch (NullPointerException e) {
			persona.setNombre(NombreNoPersona);
			System.out.println("error1 ");
		} catch (UnsupportedOperationException e) {
			persona.setNombre(NombreNoPersona);
			System.out.println("error2 ");
		} catch (IllegalStateException e) {
			persona.setNombre(NombreNoPersona);
			System.out.println("error3");
		}
		// inicio catch en el cual se le asigna a la persona el valor del nombre
		// como nombrenopersona
		persona.setEstado("true");

		persona.setUuid(uuid);
		System.out.println("uuid de la persona " + persona.getUuid());
		EspecialidadVO especialidad = new EspecialidadVO(1);
		medicoVo.setEspecialidad(especialidad);
		EstablecimientoVO hospital = new EstablecimientoVO(1);
		medicoVo.setHospital(hospital);
		medicoVo.setPersona(persona);
		System.out.println("id especialidad"
				+ medicoVo.getEspecialidad().getId());
		System.out.println("id hospital" + medicoVo.getHospital().getId());
		return medicoVo;
	}

	// ---------------------------medico----------------------------------------------------------------------------

	public static Date stringToDate(String fecha) {
		System.out.println("yyyy-MM-dd HH:mm:ss "+validarFecha(fecha));
		System.out.println("MMM dd, yyyy "+validarFecha2(fecha));
		System.out.println("yyyy-MM-dd"+validarFecha3(fecha));
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

	public static PersonaVO jsonDatosMedico(String jsonDatosMedico) {
		PersonaVO persona = new PersonaVO();
		try {
			JsonElement jelement = new JsonParser().parse(jsonDatosMedico);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			String fecha = jobject.get("birthdate").getAsString();
			persona.setFechaNacimiento(stringToDate(fecha));
			return persona;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static PersonaVO jsonDireccionMedico(String jsonDireccionMedico) {
		PersonaVO persona = new PersonaVO();
		String direccion = "";
		String pais = "";
		try {
			JsonElement jelement = new JsonParser().parse(jsonDireccionMedico);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			direccion = jobject.get("display").getAsString();
			pais = jobject.get("country").getAsString();
			direccion = direccion + pais;
			persona.setDireccion(direccion);
			return persona;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static String horaMedica(
			capaNegocio.hospitalDomain.HoraMedicaVO horaMedica) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(horaMedica);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static PersonaVO jsonNombreMedico(String jsonNombreMedico) {
		PersonaVO persona = new PersonaVO();
		try {
			JsonElement jelement = new JsonParser().parse(jsonNombreMedico);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			String nombre = jobject.get("givenName").getAsString();
			persona.setNombre(nombre);
			String apellido = jobject.get("familyName").getAsString();
			String apellido2 = "";
			try {
				apellido2 = jobject.get("familyName2").getAsString();
			} catch (NullPointerException e) {
				apellido2 = "";
			} catch (UnsupportedOperationException e) {
				apellido2 = "";
			} catch (IllegalStateException e) {
				apellido2 = "";
			}
			String apellidos = apellido + apellido2;
			persona.setApellidos(apellidos);

			return persona;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
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

	public static String horasMedicas(
			List<capaNegocio.hospitalDomain.HoraMedicaVO> horas) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(horas);
		return "{\"results\":" + listaResultado + "}";
	}

	public static String dateTimetoString(Date fecha) {
		DateFormat df = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
		String reportDate = df.format(fecha);
		return reportDate;
	}

	public static String dateTimetoString2(Date fecha) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reportDate = df.format(fecha);
		return reportDate;
	}

	public static String datetoString(Date fecha) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String reportDate = df.format(fecha);
		return reportDate;
	}

	public static String diagnosticoLista(
			List<capaNegocio.fichamedicaDomain.DiagnosticoVO> diagnosticos) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(diagnosticos);
		return "{\"results\":" + listaResultado + "}";
	}

	public static String diagnostico(
			capaNegocio.fichamedicaDomain.DiagnosticoVO diagnostico) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(diagnostico);
		return "{\"results\":[" + listaResultado + "]}";
	}
	public static String actividadLista(
			List<capaNegocio.fichamedicaDomain.ActividadVO> actividades) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(actividades);
		return "{\"results\":" + listaResultado + "}";
	}

	public static String actividad(
			capaNegocio.fichamedicaDomain.ActividadVO actividad) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(actividad);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static String procedimientosLista(
			List<capaNegocio.fichamedicaDomain.ProcedimientoVO> procedimientos) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(procedimientos);
		return "{\"results\":" + listaResultado + "}";
	}
	public static String procedimiento(
			capaNegocio.fichamedicaDomain.ProcedimientoVO procedimiento) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(procedimiento);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static VisitaVO jsonVisita(String jsonVisita) {
		VisitaVO visita = new VisitaVO();
		JsonElement jelement = new JsonParser().parse(jsonVisita);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		jobject = jarray.get(0).getAsJsonObject();
		Date fecha = Transformar.stringToDate(jobject.get("startDateTime")
				.getAsString());
		visita.setStartDateTime(fecha);
		visita.setUuidVisitType(jobject.get("uuidVisitType").getAsString());
		visita.setUuidPaciente(jobject.get("uuidPaciente").getAsString());
		return visita;

	}

	public static String visita(VisitaVO visita) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(visita);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static EncuentroVO jsonEncuentro(String jsonEncuentro) {
		EncuentroVO encuentro = new EncuentroVO();
		JsonElement jelement = new JsonParser().parse(jsonEncuentro);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		jobject = jarray.get(0).getAsJsonObject();

		encuentro.setFechaTime(jobject.get("fechaTime").getAsString());
		encuentro.setTipoEncuentro(jobject.get("tipoEncuentro").getAsString());
		encuentro.setPaciente(jobject.get("paciente").getAsString());
		return encuentro;

	}

	public static String encuentro(EncuentroVO encuentro) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(encuentro);
		return "{\"results\":[" + listaResultado + "]}";
	}

}
