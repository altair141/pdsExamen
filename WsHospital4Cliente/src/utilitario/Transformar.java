package utilitario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import capaNegocio.fichaMedicaDomain.ActividadVO;
import capaNegocio.fichaMedicaDomain.CertificadoVO;
import capaNegocio.fichaMedicaDomain.DiagnosticoVO;
import capaNegocio.fichaMedicaDomain.HceVO;
import capaNegocio.fichaMedicaDomain.ProcedimientoVO;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.fichaMedicaDomain.RecetaVO;
import capaNegocio.hospitalDomain.BoxVO;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.openmrs.EncuentroVO;
import capaNegocio.openmrs.PacienteOpen;
import capaNegocio.openmrs.PersonaOpen;
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
	public static String paciente(capaNegocio.personasDomain.PacienteVO paciente) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(paciente);
		return "{\"results\":[" + listaResultado + "]}";

	}

	public static String listaPacientes(
			List<capaNegocio.personasDomain.PacienteVO> paciente) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(paciente);
		return "{\"results\":[" + listaResultado + "]}";

	}


	public static String Observacion(capaNegocio.openmrs.Observacion obs) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(obs);
		return "{\"results\":[" + listaResultado + "]}";

	}
	public static String concepto(capaNegocio.openmrs.Concepto concepto) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(concepto);
		return "{\"results\":[" + listaResultado + "]}";

	}
	public static String observacion(capaNegocio.openmrs.Observacion obs) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(obs);
		return "{\"results\":[" + listaResultado + "]}";

	}
	public static String encuentro(EncuentroVO encuentro){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
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
	public static PacienteVO pacienteVO(String jsonPaciente) {

		PacienteVO paciente = new PacienteVO();
		JsonElement jelement = new JsonParser().parse(jsonPaciente);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		jobject = jarray.get(0).getAsJsonObject();
		paciente.setId(jobject.get("id").getAsInt());
		paciente.setNroFicha(jobject.get("nroFicha").getAsString());
		paciente.setIdPersona(jobject.get("idPersona").getAsInt());
		paciente.setApellidos(jobject.get("apellidos").getAsString());
		paciente.setDireccion(jobject.get("direccion").getAsString());
		paciente.setRut(jobject.get("rut").getAsString());
		paciente.setEstado(jobject.get("estado").getAsString());
		Date fechaNacimiento = stringToDate2(jobject.get("fechaNacimiento")
				.getAsString());
		paciente.setFechaNacimiento(fechaNacimiento);
		paciente.setNombre(jobject.get("nombre").getAsString());
		paciente.setSexo(jobject.get("sexo").getAsString());
		return paciente;
	}

	public static List<PacienteVO> listaPacienteVO(String jsonPaciente) {

		List<PacienteVO> pacientes=new ArrayList<PacienteVO>();
		JsonElement jelement = new JsonParser().parse(jsonPaciente);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("results");
		for (int i = 0; i < jarray.size(); i++) {
			PacienteVO paciente = new PacienteVO();
		jobject = jarray.get(i).getAsJsonObject();
		paciente.setId(jobject.get("id").getAsInt());
		paciente.setNroFicha(jobject.get("nroFicha").getAsString());
		paciente.setIdPersona(jobject.get("idPersona").getAsInt());
		paciente.setApellidos(jobject.get("apellidos").getAsString());
		paciente.setDireccion(jobject.get("direccion").getAsString());
		paciente.setRut(jobject.get("rut").getAsString());
		paciente.setEstado(jobject.get("estado").getAsString());
		Date fechaNacimiento = stringToDate2(jobject.get("fechaNacimiento")
				.getAsString());
		paciente.setFechaNacimiento(fechaNacimiento);
		paciente.setNombre(jobject.get("nombre").getAsString());
		paciente.setSexo(jobject.get("sexo").getAsString());
		pacientes.add(paciente);
		}
		return pacientes;
	}
	// ----------------------------------------fechas-----------------------------------------------------
	public static Date stringToDate(String fecha) {
		System.out.println("yyyy-MM-dd HH:mm:ss " + validarFecha(fecha));
		System.out.println("MMM dd, yyyy " + validarFecha2(fecha));
		System.out.println("yyyy-MM-dd" + validarFecha3(fecha));
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

	public static Date stringToDate2(String fecha) {
		if (validarFecha(fecha)) {
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

	public static String datetoString(Date fecha) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String reportDate = df.format(fecha);
		return reportDate;
	}

	public static String dateTimetoString2(Date fecha) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String reportDate = df.format(fecha);
		return reportDate;
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
//--------------------------------------------horaMedica----------------------------------------------
	public static String horaMedicaToJson(HoraMedicaVO horaMedica) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(horaMedica);
		return "{\"results\":[" + listaResultado + "]}";	
	}
	public static String horasMedicas(
			List<capaNegocio.hospitalDomain.HoraMedicaVO> horas) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		String listaResultado = gson.toJson(horas);
		return "{\"results\":" + listaResultado + "}";
	}
	// ----------------------------------------openmrs---------------------------------------------

	public static String personaOpentoJson(PersonaOpen personaOpen) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(personaOpen);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static String pacienteOpentoJson(PacienteOpen pacienteOpen) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(pacienteOpen);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static PacienteOpen jsonTopacienteOpen(String jsonPersona) {
		try {
			PacienteOpen paciente = new PacienteOpen();
			JsonElement jelement = new JsonParser().parse(jsonPersona);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			paciente.setIdentifier(jobject.get("identifier").getAsString());
			paciente.setPersonUUid(jobject.get("personUUid").getAsString());

			return paciente;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static PersonaOpen jsonTopersonaOpen(String jsonPersona) {
		try {
			PersonaOpen persona = new PersonaOpen();
			JsonElement jelement = new JsonParser().parse(jsonPersona);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			persona.setApellido(jobject.get("apellido").getAsString());
			persona.setDireccion(jobject.get("direccion").getAsString());
			persona.setFecha(jobject.get("fecha").getAsString());
			persona.setNombre(jobject.get("nombre").getAsString());
			persona.setSexo(jobject.get("sexo").getAsString());
			return persona;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static String jsonPersonaUuid(String jsonOpen) {
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

	// --------------------------------rce----------------------------------------------------------
	public static String rce(List<capaNegocio.fichaMedicaDomain.RceVO> rce) {
		Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(rce);
		return "{\"results\":" + listaResultado + "}";

	}
	public static String rce1(capaNegocio.fichaMedicaDomain.RceVO rce) {
		Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(rce);
		return "{\"results\":[" + listaResultado + "]}";

	}
	public static String diagnosticoLista(
			List<capaNegocio.fichaMedicaDomain.DiagnosticoVO> diagnosticos) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(diagnosticos);
		return "{\"results\":" + listaResultado + "}";
	}

	public static String diagnostico(
			capaNegocio.fichaMedicaDomain.DiagnosticoVO diagnostico) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(diagnostico);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static String actividadLista(
			List<capaNegocio.fichaMedicaDomain.ActividadVO> actividades) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(actividades);
		return "{\"results\":" + listaResultado + "}";
	}

	public static String procedimientosLista(
			List<capaNegocio.fichaMedicaDomain.ProcedimientoVO> procedimientos) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(procedimientos);
		return "{\"results\":" + listaResultado + "}";
	}
	
	public static String procedimiento(
			capaNegocio.fichaMedicaDomain.ProcedimientoVO procedimiento) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(procedimiento);
		return "{\"results\":[" + listaResultado + "]}";
	}
	
	public static String actividad(
			capaNegocio.fichaMedicaDomain.ActividadVO actividad) {
		Gson gson = new Gson();
		String listaResultado = gson.toJson(actividad);
		return "{\"results\":[" + listaResultado + "]}";
	}

	public static RceVO jsonToRce(String json) {
		RceVO rce = new RceVO();
		try {
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();

			String tipoEncuentro = jobject.get("tipoEncuentro").getAsString();
			System.out.println("0 "+tipoEncuentro);
			rce.setTipoEncuentro(tipoEncuentro);
			int idRce=jobject.get("idRce").getAsInt();
			rce.setIdRce(idRce);
		
			JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
			String idHce = hceJson.get("id").getAsString();
			System.out.println("2 "+idHce);
			HceVO hce = new HceVO(stringToInt(idHce));
			rce.setIdHce(hce);

			
			JsonObject horaMedicaJson = jobject.get("idHoraMedica").getAsJsonObject();
			String idHoraMedica = horaMedicaJson.get("id").getAsString();
			System.out.println("3 "+idHoraMedica);
			HoraMedicaVO horaMedica=new HoraMedicaVO(stringToInt(idHoraMedica));
			rce.setIdHoraMedica(horaMedica);
			
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
			JsonArray listaDiagnosticosjson = jobject.getAsJsonArray("listaDiagnostico");
			for (int i = 0; i < listaDiagnosticosjson.size(); i++) {
				JsonObject diagnosticoJson = listaDiagnosticosjson.get(i).getAsJsonObject();
				String idDiagnostico = diagnosticoJson.get("id").getAsString();
				System.out.println((24+i)+" "+ idDiagnostico);
				DiagnosticoVO diagnostico = new DiagnosticoVO(stringToInt(idDiagnostico));
				rce.agregarDiagnostico(diagnostico);
			}
			
			
			JsonArray listaActividadjson = jobject.getAsJsonArray("listaActividad");
			for (int i = 0; i < listaActividadjson.size(); i++) {
				JsonObject actividadjson = listaActividadjson.get(i).getAsJsonObject();
				String idActividad = actividadjson.get("id").getAsString();
				System.out.println((24+i)+" "+ idActividad);
				ActividadVO actividad = new ActividadVO(stringToInt(idActividad));
				rce.agregarActividad(actividad);
			}
			
			
			JsonArray listaProcedimientojson = jobject.getAsJsonArray("listaProcedimiento");
			for (int i = 0; i < listaProcedimientojson.size(); i++) {
				JsonObject procedimientojson = listaProcedimientojson.get(i).getAsJsonObject();
				String idProcedimiento = procedimientojson.get("id").getAsString();
				System.out.println((24+i)+" "+ idProcedimiento);
				ProcedimientoVO procedimiento = new ProcedimientoVO(stringToInt(idProcedimiento));
				rce.agregarProcedimiento(procedimiento);
			}
			
			
			return rce;
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
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

		
			JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
			String idHce = hceJson.get("id").getAsString();
			System.out.println("2 "+idHce);
			HceVO hce = new HceVO(stringToInt(idHce));
			rce.setIdHce(hce);

			
			JsonObject horaMedicaJson = jobject.get("idHoraMedica").getAsJsonObject();
			String idHoraMedica = horaMedicaJson.get("id").getAsString();
			System.out.println("3 "+idHoraMedica);
			HoraMedicaVO horaMedica=new HoraMedicaVO(stringToInt(idHoraMedica));
			rce.setIdHoraMedica(horaMedica);
			
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
			JsonArray listaDiagnosticosjson = jobject.getAsJsonArray("listaDiagnostico");
			for (int i = 0; i < listaDiagnosticosjson.size(); i++) {
				JsonObject diagnosticoJson = listaDiagnosticosjson.get(i).getAsJsonObject();
				String idDiagnostico = diagnosticoJson.get("id").getAsString();
				System.out.println((24+i)+" "+ idDiagnostico);
				DiagnosticoVO diagnostico = new DiagnosticoVO(stringToInt(idDiagnostico));
				rce.agregarDiagnostico(diagnostico);
			}
			
			
			JsonArray listaActividadjson = jobject.getAsJsonArray("listaActividad");
			for (int i = 0; i < listaActividadjson.size(); i++) {
				JsonObject actividadjson = listaActividadjson.get(i).getAsJsonObject();
				String idActividad = actividadjson.get("id").getAsString();
				System.out.println((24+i)+" "+ idActividad);
				ActividadVO actividad = new ActividadVO(stringToInt(idActividad));
				rce.agregarActividad(actividad);
			}
			
			
			JsonArray listaProcedimientojson = jobject.getAsJsonArray("listaProcedimiento");
			for (int i = 0; i < listaProcedimientojson.size(); i++) {
				JsonObject procedimientojson = listaProcedimientojson.get(i).getAsJsonObject();
				String idProcedimiento = procedimientojson.get("id").getAsString();
				System.out.println((24+i)+" "+ idProcedimiento);
				ProcedimientoVO procedimiento = new ProcedimientoVO(stringToInt(idProcedimiento));
				rce.agregarProcedimiento(procedimiento);
			}
			
			
			return rce;
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	public static String receta(capaNegocio.fichaMedicaDomain.RecetaVO receta) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String listaResultado = gson.toJson(receta);
		return "{\"results\":[" + listaResultado + "]}";

	}
	public static RecetaVO jsonToreceta(String json){
		RecetaVO receta=new RecetaVO();
		try{
			
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			receta.setContenido(jobject.get("contenido").getAsString());
			JsonObject rceJson= jobject.get("rce").getAsJsonObject();
			RceVO rce=new RceVO(rceJson.get("idRce").getAsInt());
			receta.setRce(rce);
			return receta;
			
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static RecetaVO jsonToreceta2(String json){
		RecetaVO receta=new RecetaVO();
		try{
			
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			receta.setContenido(jobject.get("contenido").getAsString());
			receta.setId(jobject.get("id").getAsInt());
			JsonObject rceJson= jobject.get("rce").getAsJsonObject();
			RceVO rce=new RceVO(rceJson.get("id").getAsInt());
			receta.setRce(rce);
			return receta;
			
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	// -----------------------------otras
	// validaciones-----------------------------------------------------
/**
 * metodo que permite validar si es un numero o no lo es
 * @param texto string texto a comprobar si es numero o no
 * @return bolean true si es verdadero, false caso contrario
 */
	public static boolean validarNumero(String texto) {
		if (texto.matches("[0-9]*")) {
			return true;
		}
		return false;
	}
	/**
	 * metodo que permite parsear de string a int
	 * @param texto string cadena de caracteres a parsear a int
	 * @return int numero parseado
	 */
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
	
	/**
	 * metodo que permite parsear de json a HoraMedicaVO
	 * @param jsonHoraMedica
	 * @return objeto HoraMedicaVO con todos los datos
	 */
	public static HoraMedicaVO jsonToHoraMedica(String jsonHoraMedica) {
		HoraMedicaVO horaMedica = new HoraMedicaVO();
		try {
			JsonElement jelement = new JsonParser().parse(jsonHoraMedica);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			horaMedica.setAsp(jobject.get("asp").getAsString());
			horaMedica.setId(jobject.get("id").getAsInt());			
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

		

			
			
			medico.setId(medi.get("id").getAsInt());
			try {
				medico.setApellidos(medi.get("apellidos").getAsString());
			} catch (NullPointerException e) {

			} catch (UnsupportedOperationException e) {

			} catch (IllegalStateException e) {

			}
			medico.setNombre(medi.get("nombre").getAsString());
			medico.setEstado(medi.get("estado").getAsString());					

			JsonObject boxJson = jobject.get("box").getAsJsonObject();
			BoxVO box = new BoxVO();
			box.setBox(boxJson.get("Box").getAsInt());
			box.setNroHabitacion(boxJson.get("nroHabitacion").getAsString());

			
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
	public static List<RceVO> jsonToRce3(String json) {
		List<RceVO> lista=new ArrayList<RceVO>();
		try {
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int j = 0; j < jarray.size(); j++) {
			jobject = jarray.get(j).getAsJsonObject();
			RceVO rce = new RceVO();
			String tipoEncuentro = jobject.get("tipoEncuentro").getAsString();
			System.out.println("0 "+tipoEncuentro);
			rce.setTipoEncuentro(tipoEncuentro);
			int idRce=jobject.get("idRce").getAsInt();
			rce.setIdRce(idRce);
			JsonObject hceJson = jobject.get("idHce").getAsJsonObject();
			String idHce = hceJson.get("id").getAsString();
			System.out.println("2 "+idHce);
			HceVO hce = new HceVO(stringToInt(idHce));
			rce.setIdHce(hce);

			
			JsonObject horaMedicaJson = jobject.get("idHoraMedica").getAsJsonObject();
			String idHoraMedica = horaMedicaJson.get("id").getAsString();
			System.out.println("3 "+idHoraMedica);
			HoraMedicaVO horaMedica=new HoraMedicaVO(stringToInt(idHoraMedica));
			rce.setIdHoraMedica(horaMedica);
			
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
			JsonArray listaDiagnosticosjson = jobject.getAsJsonArray("listaDiagnostico");
			for (int i = 0; i < listaDiagnosticosjson.size(); i++) {
				JsonObject diagnosticoJson = listaDiagnosticosjson.get(i).getAsJsonObject();
				String idDiagnostico = diagnosticoJson.get("id").getAsString();
				System.out.println((24+i)+" "+ idDiagnostico);
				DiagnosticoVO diagnostico = new DiagnosticoVO(stringToInt(idDiagnostico));
				rce.agregarDiagnostico(diagnostico);
			}
			
			
			JsonArray listaActividadjson = jobject.getAsJsonArray("listaActividad");
			for (int i = 0; i < listaActividadjson.size(); i++) {
				JsonObject actividadjson = listaActividadjson.get(i).getAsJsonObject();
				String idActividad = actividadjson.get("id").getAsString();
				System.out.println((24+i)+" "+ idActividad);
				ActividadVO actividad = new ActividadVO(stringToInt(idActividad));
				rce.agregarActividad(actividad);
			}
			
			
			JsonArray listaProcedimientojson = jobject.getAsJsonArray("listaProcedimiento");
			for (int i = 0; i < listaProcedimientojson.size(); i++) {
				JsonObject procedimientojson = listaProcedimientojson.get(i).getAsJsonObject();
				String idProcedimiento = procedimientojson.get("id").getAsString();
				System.out.println((24+i)+" "+ idProcedimiento);
				ProcedimientoVO procedimiento = new ProcedimientoVO(stringToInt(idProcedimiento));
				rce.agregarProcedimiento(procedimiento);
			}
			lista.add(rce);
			}
			return lista;
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
	
	public static List<DiagnosticoVO> jsonToDiagnostico(String listaDiagnostico){
		List<DiagnosticoVO> listaDiagnosticoVo=new ArrayList<DiagnosticoVO>();
		try{
			JsonElement jelement = new JsonParser().parse(listaDiagnostico);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int j = 0; j < jarray.size(); j++) {
				DiagnosticoVO diagnostico=new DiagnosticoVO();
				jobject = jarray.get(j).getAsJsonObject();
				diagnostico.setId(jobject.get("id").getAsInt());
				diagnostico.setNombre(jobject.get("nombre").getAsString());
				listaDiagnosticoVo.add(diagnostico);
			}
			return listaDiagnosticoVo;
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	
	public static List<ActividadVO> jsonToActividad(String listaActividad){
		List<ActividadVO> listaActividadVo=new ArrayList<ActividadVO>();
		try{
			JsonElement jelement = new JsonParser().parse(listaActividad);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int j = 0; j < jarray.size(); j++) {
				ActividadVO actividad=new ActividadVO();
				jobject = jarray.get(j).getAsJsonObject();
				actividad.setId(jobject.get("id").getAsInt());
				actividad.setNombreActividad(jobject.get("nombreActividad").getAsString());
				listaActividadVo.add(actividad);
			}
			return listaActividadVo;
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	
	public static List<ProcedimientoVO> jsonToProcedimiento(String listaProcedimiento){
		List<ProcedimientoVO> listaProcedimientoVo=new ArrayList<ProcedimientoVO>();
		try{
			JsonElement jelement = new JsonParser().parse(listaProcedimiento);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int j = 0; j < jarray.size(); j++) {
				ProcedimientoVO procedimiento=new ProcedimientoVO();
				jobject = jarray.get(j).getAsJsonObject();
				procedimiento.setId(jobject.get("id").getAsInt());
				procedimiento.setNombre(jobject.get("nombre").getAsString());
				listaProcedimientoVo.add(procedimiento);
			}
			return listaProcedimientoVo;
		} catch (NullPointerException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}

	public static List<ActividadVO> jsonToActividad2(String jsonActividad) {
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
	public static List<ProcedimientoVO> jsonToProcedimiento2(
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

	public static List<DiagnosticoVO> jsonToDiagnostico2(String jsonDiagnostico) {
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
	
	public static RecetaVO jsonToReceta(String jsonReceta){
		try {
			JsonElement jelement = new JsonParser().parse(jsonReceta);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			jobject = jarray.get(0).getAsJsonObject();
			RecetaVO receta=new RecetaVO();
			receta.setContenido(jobject.get("contenido").getAsString());
			receta.setId(jobject.get("id").getAsInt());
			return receta;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	public static List<RecetaVO> jsonToListaReceta(String jsonReceta){
		List<RecetaVO> lista=new ArrayList<RecetaVO>();
		try {
			JsonElement jelement = new JsonParser().parse(jsonReceta);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("results");
			for (int i = 0; i < jarray.size(); i++) {
			jobject = jarray.get(i).getAsJsonObject();
			RecetaVO receta=new RecetaVO();
			receta.setContenido(jobject.get("contenido").getAsString());
			receta.setId(jobject.get("id").getAsInt());
			lista.add(receta);
			}
			return lista;
		} catch (NullPointerException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		} catch (IllegalStateException e) {
			return null;
		}
	}
	
}
