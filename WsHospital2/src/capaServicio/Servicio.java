package capaServicio;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import utilitario.Transformar;
import capaNegocio.fichamedica.CierreCasoMedico;
import capaNegocio.fichamedica.Hce;
import capaNegocio.fichamedica.Rce;
import capaNegocio.fichamedicaDomain.CierreCasoMedicoVO;
import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.RceVO;
import capaNegocio.hospital.HoraMedica;
import capaNegocio.hospital.Reserva;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.personas.Medico;
import capaNegocio.personas.Paciente;
import capaNegocio.personas.Persona;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;
import capaNegocio.rest.Openmrs;
import capaNegocio.rest.PacienteOpen;

public class Servicio {

	/**
	 * @param uuid
	 *            String uuid obtenida de openmrs *
	 * @return response String Json con la respuesta de la información de la
	 *         persona
	 **/
	public String personaNameRest(String uuid) {
		// /openmrs/ws/rest/v1/encounter?patient=aa992eb6-30f7-4a38-894c-bbad84f35def
		return Openmrs.personaNameRest(uuid);
	}

	/**
	 * @param uuid
	 *            String uuid obtenida de openmrs
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         paciente
	 **/
	public String pacienteUuidRest(String uuid) {
		// /openmrs/ws/rest/v1/encounter?patient=aa992eb6-30f7-4a38-894c-bbad84f35def
		return Openmrs.pacienteUuidRest(uuid);

	}

	/**
	 * @param uuid
	 *            String nombre del paciente
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         paciente
	 **/
	public String pacienteRest(String uuid) {
		return Openmrs.pacienteRest(uuid);

	}

	/**
	 * @param uuid
	 *            String nombre del médico
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         médico
	 **/
	public String medicoRest(String uuid) {
		return Openmrs.medicoRest(uuid);
	}

	/**
	 * @param uuid
	 *            String identificador del médico
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         médico
	 **/
	public String medicoUuidRest(String uuid) {
		return Openmrs.medicoUuidRest(uuid);
	}

	/**
	 * @param uuid
	 *            String nombre del concepto
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         concepto
	 **/
	public String conceptoRest(String uuid) {
		return Openmrs.conceptoRest(uuid);
	}

	/**
	 * @param uuid
	 *            String identificador del concepto
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         concepto
	 **/
	public String conceptoUuidRest(String uuid) {
		return Openmrs.conceptoUuidRest(uuid);
	}

	/**
	 * @param uuid
	 *            String identificador del paciente
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         encuentro
	 **/
	public String encuentroPorPacienteUuidRest(String uuid) {
		return Openmrs.encuentroPorPacienteUuidRest(uuid);
	}

	/**
	 * @param uuid
	 *            String identificador del encuentro
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         encuentro
	 **/
	public String encuentroUuidRest(String uuid) {
		return Openmrs.encuentroUuidRest(uuid);
	}

	/**
	 * @param uuid
	 *            String identificador de la visita
	 * 
	 * @return response String Json con la respuesta de la información de la
	 *         visita
	 **/
	public String visitaUuidRest(String uuid) {
		return Openmrs.visitaUuidRest(uuid);
	}

	/**
	 * @param uuid
	 *            String identificador del paciente
	 * 
	 * @return response String Json con la respuesta de la información de la
	 *         visita
	 **/
	public String visitaPorPacienteUuidRest(String uuid) {
		return Openmrs.visitaPorPacienteUuidRest(uuid);
	}

	/**
	 * @param nombre
	 *            String nombre del paciente
	 * 
	 * @return response String Json con la respuesta de la información del
	 *         paciente
	 **/
	public String buscarPacientePorNombre(String nombre) {
		List<PersonaVO> persona;
		try {
			persona = Openmrs.buscarPacientePorNombre(nombre);
		} catch (NullPointerException e) {
			return "no encontrado";
		}
		return Transformar.personas(persona);
	}

	// -----------------------------personas--------------------------------------------------------------
	/**
	 * registra la persona a partir del json contenedor de sus datos
	 * 
	 * @param jsonPersona
	 * @return id de la persona en la bd local
	 */
	public String registrarPersona(String jsonPersona) {
		PersonaVO persona = Transformar.jsonToPersonaLocalsinUuid(jsonPersona);

		Persona personaLocal = new Persona();
		String respuestaOpen = personaLocal.registrarPersonaOpenmrs(persona);
		System.out.println(respuestaOpen);
		if (respuestaOpen.equals("no registrado")) {
			return "no registrado en openmrs";// retorna el uuid en caso de que
												// se registre correctamente
		}

		persona.setUuid(respuestaOpen);
		String respuesta = personaLocal.registrarPersona(persona);
		if (respuesta.equals("no registrado")) {
			return "no registrado";// retorna el id en caso de que sea correcto
									// el registro
		}

		return respuesta;
	}

	/**
	 * almacena en la bd local los datos de la persona a partir de la uuid de la
	 * persona almacenada en openmrs
	 * 
	 * @param uuid
	 *            identificador obtenido de la bd de openmrs
	 * @return el id de la persona almacenada en la bd local
	 */
	public String sincronizarPersonaToLocal(String uuid) {

		String jsonPersonaOpen = Openmrs.persona(uuid);
		String jsonPersonaNombre = Openmrs.personaNameRest(uuid);
		String jsonPersonaDireccion = Openmrs.personaDireccion(uuid);
		System.out.println(jsonPersonaOpen);
		PersonaVO persona = Transformar.jsonToOpenmrsPersona(jsonPersonaNombre,
				jsonPersonaOpen, jsonPersonaDireccion);
		Persona p = new Persona();

		return p.registrarPersona(persona);
	}

	/**
	 * busca en la bd a la persona a partir de su id en la bd local
	 * 
	 * @param id
	 * @return json con los datos de la persona
	 */
	public String buscarPersonaPorIdLocal(String id) {
		int idPersonaLocal = Transformar.stringToInt(id);
		PersonaVO p = new PersonaVO(idPersonaLocal);
		Persona per = new Persona();
		return per.obtenerPersonasId(p);

	}

	/**
	 * busca una persona a partir del uuid que es obtenido mediante la
	 * sincronizacion con openmrs
	 * 
	 * @param uuid
	 *            identificador de la persona en la bd de openmrs
	 * @return json con los datos de la persona
	 */
	public String buscarPersonaLocalPorUuid(String uuid) {
		PersonaVO per = new PersonaVO(uuid);
		Persona p = new Persona();
		return p.obtenerPersonaUuid(per);

	}

	/**
	 * obtiene todas las personas almacenadas en la bd local
	 * 
	 * @return json con la lista de las personas almacenadas en la bd local
	 */
	public String mostrarPersonas() {
		Persona p = new Persona();
		// al parsear los datos hay que modificar la forma de hacerlo estan sin
		// el results
		return p.obtenerListaPersonas();
	}

	// -----------------------------personas--------------------------------------------------------------

	// -----------------------------pacientes--------------------------------------------------------------

	/**
	 * obtiene la lista de pacientes almacenada en la bd local
	 * 
	 * @return json con la lista de pacientes en la db
	 */
	public String mostrarPacientes() {
		Paciente p = new Paciente();
		return p.obtenerListaPacientes();
	}

	/**
	 * registra el paciente a partir de los datos de la persona, paciente y el
	 * hce correspondiente a dicho paciente
	 * 
	 * @param jsonPaciente
	 * @return idHce
	 */
	public String registrarPaciente(String jsonPaciente) {
		try {
			// parsea json a un paciente con su persona
			PacienteVO paciente = Transformar
					.pacienteConPersonaSinidSinUuid(jsonPaciente);

			PersonaVO persona = paciente.getPersona();
			paciente.setPersona(null);

			Persona personaLocal = new Persona();
			Paciente pacienteLocal = new Paciente();
			// se registra la persona en open mrs y retorna la uuid unica de la
			// persona
			String respuestaOpen = personaLocal
					.registrarPersonaOpenmrs(persona);

			if (respuestaOpen.equals("no registrado")) {
				return "no registrado en openmrs";// retorna el uuid en caso de
													// que se registre
													// correctamente
			}
			//registrar paciente en open
			
			PacienteOpen paci=new PacienteOpen();
			paci.setPersonUUid(respuestaOpen);
			paci.setIdentifier(paciente.getNroFicha());
			pacienteLocal.registrarPacienteOpenmrs(paci);
			persona.setUuid(respuestaOpen);
			// se registra la persona en la bd local y retorna la id unica de la
			// persona
			String respuesta = personaLocal.registrarPersona(persona);
			if (respuesta.equals("no registrado")) {
				return "no registrado en bd Local";// retorna el id en caso de
													// que sea correcto el
													// registro
			}
			// se agrega la id a la persona
			persona.setId(Transformar.stringToInt(respuesta));
			// se agrega la persona al paciente
			paciente.setPersona(persona);
			// se registra el paciente y retorna su id
			String idPaciente = pacienteLocal.registrarPaciente(paciente);
			System.out.println(idPaciente);
			if (idPaciente.equals("no registrado")) {
				return "no registrado en bd Local";
			}
			paciente.setId(Transformar.stringToInt(idPaciente));
			// registrar Hce
			Hce hce = new Hce();
			String idHce = hce.registrarHce(paciente);
			System.out.println("dato hce " + idHce);
			return idHce;

		} catch (NullPointerException e) {
			return "no registrado";
		}

	}

	public String sincronizarPaciente(String uuid) {

		Persona p = new Persona();
		Paciente paci = new Paciente();
		PersonaVO per = new PersonaVO(uuid);
		// busca si ya se encuentra registrado en la bd local la persona con la
		// uuid recibida
		String buscarPersona = p.obtenerPersonaUuid(per);

		if (!buscarPersona.equals("no encontrado")) {
			return "ya registrado en bd local";
		} else {
			// obtiene los datos de la persona
			String jsonPersonaOpen = Openmrs.persona(uuid);
			if (jsonPersonaOpen.equals("no encontrado")) {
				return "no registrado";
			}
			System.out.println("dato "+jsonPersonaOpen);
			// obtiene los datos del nombre de la persona
			String jsonPersonaNombre = Openmrs.personaNameRest(uuid);
			if (jsonPersonaNombre.equals("no encontrado")) {
				return "no registrado";
			}
			System.out.println("nombre"+jsonPersonaNombre);
			// obtiene la direccion de la persona
			String jsonPersonaDireccion = Openmrs.personaDireccion(uuid);
			if (jsonPersonaDireccion.equals("no encontrado")) {
				return "no registrado";
			}
			System.out.println("direccion "+jsonPersonaDireccion);
			// transforma los datos de la persona openmrs a la local
			PersonaVO persona = Transformar.jsonToOpenmrsPersona(
					jsonPersonaNombre, jsonPersonaOpen, jsonPersonaDireccion);

			String jsonPaciente = Openmrs.pacienteUuidRest(uuid);
			PacienteVO paciente = Transformar.jsonOpenmrsPaciente(jsonPaciente);
			if (paciente == null) {
				System.out.println("paciente nulo");
				return "no registrado";
			}
			String idPersona = p.registrarPersona(persona);
			if (idPersona.equals("no encontrado")) {
				return "no registrado";
			}

			persona.setId(Transformar.stringToInt(idPersona));
			paciente.setPersona(persona);

			String idPaciente = paci.registrarPaciente(paciente);
			paciente.setId(Transformar.stringToInt(idPaciente));
			Hce hce = new Hce();
			String idHce = hce.registrarHce(paciente);
			System.out.println("dato hce " + idHce);
			return idHce;

		}
	}

	public String buscarPacienteBdLocalId(String idPaciente) {
		int id = Transformar.stringToInt(idPaciente);
		Paciente paciente = new Paciente();
		PacienteVO pacienteVO = paciente.obtenerPacientePorIdPaciente(id);
		PersonaVO personaVO = paciente.obtenerPersonaPorIdPaciente(id);
		pacienteVO.setPersona(personaVO);
		return Transformar.paciente(pacienteVO);

	}

	public String buscarPacienteBdLocal(String nombre) {
		Paciente paciente = new Paciente();
		// se busca al paciente en openmrs, se obtiene el uuid
		List<PersonaVO> lista = Openmrs.buscarPacientePorNombre(nombre);
		List<PacienteVO> listaPacientes = new ArrayList<PacienteVO>();
		// se recorre la lista de pacientes obtenidos con el parametro de
		// busqueda
		for (PersonaVO persona : lista) {
			try {
				// se optiene la info de la bd si es que se encuentra y se
				// agrega a la lista
				PacienteVO paci = Transformar.jsonBDPaciente(paciente
						.obtenerPacienteUuid(persona));
				listaPacientes.add(paci);
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println("error nulo s");
			} catch (UnsupportedOperationException e) {
				e.printStackTrace();
				System.out.println("error no soportado s");
			} catch (IllegalStateException e) {
				System.out.println("error ileal s");
			}

		}
		if (listaPacientes.size() == 0 || listaPacientes == null) {
			return "no encontrado";
		}

		String respuesta = Transformar.pacientes(listaPacientes);
		return "{\"results\":" + respuesta + "}";
	}

	/**
	 * 
	 * @param uuid
	 *            de la persona de openmrs
	 * @return
	 */
	public String sincronizarMedicoToLocal(String uuid) {

		// PersonaVO persona=new PersonaVO(uuid);
		String mensaje = "no encontrado";
		String res = "";

		Medico me = new Medico();
		// busca al medico en la bd local
		res = me.buscarMedicoUuid(uuid);
		// si res es igual al mensaje retorna que ya ha sido registrado
		if (!res.equals(mensaje)) {
			return "ya registrado";
			// sino se sincroniza
		} else {
			String openMedico = Openmrs.medicoUuidRest(uuid);
			System.out.println("json medico" + openMedico);
			if (openMedico.equals("no encontrado")) {
				return "no registrado";
			}
			MedicoVO medico = Transformar.jsonToMedico(openMedico);

			mensaje = me.sincronizarMedico(medico);
		}

		return mensaje;
	}

	public String buscarMedicoOpen(String nombre) {
		List<PersonaVO> medico;
		try {
			medico = Openmrs.busquedaOpenmedicoRest(nombre);
		} catch (NullPointerException e) {
			return "no encontrado";
		}
		return Transformar.medicos(medico);
	}

	/**
	 * registra el rce de un paciente
	 * 
	 * @param json
	 *            son los datos pertinentes del rce
	 * @return id del rce almacenado en la bd local
	 */
	public String registrarRce(String json) {
		try {
			RceVO rceVo = Transformar.jsonToRce(json);
			Rce rce = new Rce();
			String idRce = rce.registrarRce(rceVo);
			// falta la uuid agregar para almacenar
			return idRce;
		} catch (NullPointerException e) {
			return "no registrado";
		}
	}

	public String registrarCierreCasoMedico(String json) {
		try {
			CierreCasoMedicoVO cierreCaso = Transformar.cierreCasoMedico(json);

			CierreCasoMedico cierre = new CierreCasoMedico();
			String idCierre = cierre.registrarCierreCasoMedico(cierreCaso);

			return idCierre;
		} catch (NullPointerException e) {
			return "no registrado";
		}
	}

	public String obtenerHCE(String idPaciente) {
		int idPaci = Transformar.stringToInt(idPaciente);
		PacienteVO paciente = new PacienteVO(idPaci);

		Hce hce = new Hce();
		int idHce = hce.obtenerIdHce(paciente);
		System.out.println(idHce);
		HceVO hceVO = new HceVO(idHce);
		List<RceVO> listaRceVO = hce.obtenerHce(hceVO);
		Rce rce = new Rce();

		List<RceVO> listaRce = rce.obtenerRce(listaRceVO);
		String respuesta = Transformar.Rce(listaRce);
		return respuesta;
	}

	public String obtenerHoraMedica(String idHora) {
		int id = Transformar.stringToInt(idHora);
		HoraMedica hora = new HoraMedica();
		String respuesta = "";
		try {
			HoraMedicaVO horaVo = hora.buscarHoraMedicaPorId(id);
			if (horaVo == null) {
				return "{\"results\":[]}";
			}
			respuesta = Transformar.horaMedica(horaVo);
		} catch (NullPointerException e) {
			respuesta = "{\"results\":[]}";
		}

		return respuesta;
	}

	public String buscarHorasPorIdPaciente(String idPaciente) {
		int id = Transformar.stringToInt(idPaciente);
		Reserva r = new Reserva();
		try {
			List<HoraMedicaVO> listaHoras = r.buscarHoraMedicaPorIdPaciente(id);
			if (listaHoras != null) {
				return Transformar.horasMedicas(listaHoras);
			} else {
				return "{\"results\":[]}";
			}
		} catch (NullPointerException e) {
			return "{\"results\":[]}";
		}
	}
	public String buscarHorasAPSPorIdPaciente(String idPaciente) {
		int id = Transformar.stringToInt(idPaciente);
		Reserva r = new Reserva();
		try {
			List<HoraMedicaVO> listaHoras = r.buscarHoraMedicaApsPorIdPaciente(id);
			if (listaHoras != null) {
				return Transformar.horasMedicas(listaHoras);
			} else {
				return "{\"results\":[]}";
			}
		} catch (NullPointerException e) {
			return "{\"results\":[]}";
		}
	}
	public String buscarHorasControlPorIdPaciente(String idPaciente) {
		int id = Transformar.stringToInt(idPaciente);
		Reserva r = new Reserva();
		try {
			List<HoraMedicaVO> listaHoras = r.buscarHoraMedicaControlPorIdPaciente(id);
			if (listaHoras != null) {
				return Transformar.horasMedicas(listaHoras);
			} else {
				return "{\"results\":[]}";
			}
		} catch (NullPointerException e) {
			return "{\"results\":[]}";
		}
	}
	public String obtenerIdHCE(String idPaciente){
		int idPaci = Transformar.stringToInt(idPaciente);
		PacienteVO paciente = new PacienteVO(idPaci);

		Hce hce = new Hce();
		int idHce = hce.obtenerIdHce(paciente);
		return idHce+"";
	}
}
