package capaServicio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import utilitario.Transformar;
import capaNegocio.fichaMedica.Hce;
import capaNegocio.fichaMedica.Rce;
import capaNegocio.fichaMedica.Receta;
import capaNegocio.fichaMedicaDomain.HceVO;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.fichaMedicaDomain.RecetaVO;
import capaNegocio.fichaMedica.Procedimiento;
import capaNegocio.fichaMedicaDomain.ProcedimientoVO;
import capaNegocio.fichaMedica.Diagnostico;
import capaNegocio.fichaMedicaDomain.DiagnosticoVO;
import capaNegocio.fichaMedica.Actividad;
import capaNegocio.fichaMedicaDomain.ActividadVO;
import capaNegocio.hospital.HoraMedica;
import capaNegocio.hospital.Reserva;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.openmrs.Concepto;
import capaNegocio.openmrs.Encuentro;
import capaNegocio.openmrs.MedicoOpen;
import capaNegocio.openmrs.Observacion;
import capaNegocio.openmrs.PacienteOpen;
import capaNegocio.openmrs.PersonaOpen;
import capaNegocio.personas.Medico;
import capaNegocio.personas.Paciente;
import capaNegocio.personas.Persona;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;

public class Servicio {

	/**
	 * metodo que permite obtener la lista de pacientes almacenados en la bd del
	 * sistema
	 * 
	 * @return json con la lista de pacientes y sus datos correspondientes
	 */
	public String obtenerListaPacientes() {
		Paciente p = new Paciente();
		try {
			List<PacienteVO> listaPaciente = p.obtenerListaPacientes();
			if (listaPaciente.size() != 0) {
				String respuesta = Transformar.listaPacientes(listaPaciente);
				return respuesta;
			} else {
				return "{\"results\":[]}";
			}
		} catch (NullPointerException e) {
			return "{\"results\":[]}";
		}
	}

	/**
	 * metodo que permite buscar en la bd local si es que exite un paciente a
	 * partir de su identificador
	 * 
	 * @param idPaciente
	 *            identificador del paciente
	 * @return json con los datos del paciente
	 */

	public String buscarPacienteId(String idPaciente) {
		if (Transformar.validarNumero(idPaciente)) {
			int id = Integer.parseInt(idPaciente);
			Paciente paciente = new Paciente();
			PacienteVO pacienteVO = paciente.obtenerPacientePorId(id);
			if (pacienteVO == null) {
				return "{\"results\":[]}";
			}
			return Transformar.paciente(pacienteVO);
		}
		return "{\"results\":[]}";

	}

	/**
	 * metodo que permite saber si es o no es aps una hora medica a partir del
	 * 1d
	 * 
	 * @param idHoramedica
	 * @return
	 */
	public String horaesAps(String idHoramedica) {

		if (Transformar.validarNumero(idHoramedica)) {
			int id = Integer.parseInt(idHoramedica);
			HoraMedica h = new HoraMedica();
			boolean aps = h.horaEsTipo(id);
			if (aps) {
				return "true";
			} else {
				return "false";
			}
		}
		return "false";
	}

	/**
	 * metodo que permite obtener la informacion de un paciente
	 * 
	 * @param rut
	 *            String con el rut de la persona
	 * @return json con los datos de la persona al cual le pertenece el rut
	 */
	public String obtenerPaciente(String rut) {
		if (rut != null) {
			try {
				Paciente p = new Paciente();

				PacienteVO paciente = p.obtenerPacientePorRutPersona(rut);
				if (paciente == null) {
					return "{\"results\":[]}";
				}
				String respuesta = Transformar.paciente(paciente);
				if (respuesta == null) {
					return "{\"results\":[]}";
				}
				return respuesta;
			} catch (NullPointerException e) {
				return "{\"results\":[]}";
			}
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite registrar un paciente en openmrs
	 * 
	 * @param idPaciente
	 *            String con el id del paciente a guardar en openmrs
	 * @return json con los datos del paciente almacenado
	 */
	public String registrarPacienteOpen(String idPaciente) {
		Paciente p = new Paciente();
		Persona persona = new Persona();
		if (idPaciente != null) {
			boolean idBolean = Transformar.validarNumero(idPaciente);
			if (idBolean) {
				int id = Integer.parseInt(idPaciente);
				PacienteVO paciente = p.obtenerPacientePorId(id);

				if (!p.validarPaciente(paciente.getNroFicha())) {
					PersonaOpen personaOpen = new PersonaOpen();
					personaOpen.setApellido(paciente.getApellidos());
					personaOpen.setDireccion(paciente.getDireccion());
					personaOpen.setFecha(Transformar.datetoString(paciente
							.getFechaNacimiento()));
					personaOpen.setNombre(paciente.getNombre());
					personaOpen.setSexo(paciente.getSexo());
					String uuidPersona = persona
							.registrarPersonaOpenmrs(personaOpen);
					System.out.println(uuidPersona);
					PacienteOpen pacienteOpen = new PacienteOpen();
					pacienteOpen.setPersonUUid(uuidPersona);
					pacienteOpen.setIdentifier(paciente.getNroFicha());
					String respuesta = p.registrarPacienteOpenmrs(pacienteOpen);
					return respuesta;
				} else {

					// obtener el uuid
					String pacienteUuid = p
							.pacienteRest(paciente.getNroFicha());
					return Transformar.pacienteUuid(pacienteUuid);
				}
			}
			// Paciente paciente=Transformar.jsonToPaciente(jsonPaciente);
			return "{\"results\":[]}";// p.registrarPacienteOpenmrs(paciente);
		} else {
			return "{\"results\":[]}";
		}
	}

	/**
	 * metodo que permite registrar el encuentro en openmrs
	 * 
	 * @param jsonEncuentro
	 *            json con los datos necesarios
	 * @return string con el uuid del encuentro almacenado
	 */
	public String registrarEncuentro(String jsonEncuentro) {
		Encuentro encuentro = new Encuentro();
		Encuentro encuentroVo = Transformar.jsonEncuentro(jsonEncuentro);
		String resultado = encuentro.registrarEncuentroOpenmrs(encuentroVo);
		if (resultado.equals("no registrado")) {
			resultado = "{\"results\":[]}";
		}
		return resultado;
	}

	/**
	 * metodo que permite registrar un medico en openMrs
	 * 
	 * @param idMedico
	 *            identificador del medico en la bd local
	 * @return json con los datos registrados en openmrs
	 */
	public String registrarMedicoOpenmrs(String idMedico) {

		if (idMedico != null) {
			Medico medico = new Medico();
			Persona persona = new Persona();
			if (Transformar.validarNumero(idMedico)) {
				int id = Integer.parseInt(idMedico);
				MedicoVO medicoVo = medico.buscarMedicoPorId(id);
				if (!medico.validarMedicoOpen(medicoVo.getId() + "")) {
					PersonaOpen personaOpen = new PersonaOpen();
					personaOpen.setApellido(medicoVo.getApellidos());
					personaOpen.setDireccion(medicoVo.getDireccion());
					personaOpen.setFecha(Transformar.datetoString(medicoVo
							.getFechaNacimiento()));
					personaOpen.setNombre(medicoVo.getNombre());
					personaOpen.setSexo(medicoVo.getSexo());
					String uuidPersona = persona
							.registrarPersonaOpenmrs(personaOpen);
					System.out.println(uuidPersona);

					MedicoOpen medicoOpen = new MedicoOpen();
					medicoOpen.setIdentifier(medicoVo.getId() + "");
					medicoOpen.setPersonUUid(uuidPersona);
					return medico.registrarMedicoOpenmrs(medicoOpen);
				} else {
					String medicoUuidOpen = medico.medicoRest(medicoVo.getId()
							+ "");

					String uuidMedico = Transformar
							.pacienteUuid(medicoUuidOpen);
					String openUuidMedico = "{\"results\":["
							+ medico.medicoUuid(uuidMedico) + "]}";
					return Transformar.obtenerUuidPersonaMedico(openUuidMedico);
				}
			}
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite obtener la hora medica a partir de su identificador
	 * 
	 * @param idHora
	 *            string identificador de la hora
	 * @return json con los datos de la hora medica
	 */
	public String obtenerHoraMedica(String idHora) {
		String respuesta = "{\"results\":[]}";
		if (Transformar.validarNumero(idHora)) {
			int id = Integer.parseInt(idHora);
			HoraMedica hora = new HoraMedica();

			try {
				HoraMedicaVO horaVo = hora.buscarHoraMedicaPorId(id);
				if (horaVo == null) {
					return respuesta;
				}
				respuesta = Transformar.horaMedicaToJson(horaVo);
			} catch (NullPointerException e) {

			}
		}
		return respuesta;
	}

	/**
	 * a partir del id del paciente se obtiene la lista de rce correspondiente
	 * al historial clinico electronico
	 * 
	 * @param idPaciente
	 *            id del paciente
	 * @return string con los datos del hce
	 */
	public String obtenerHCE(String idPaciente) {
		if (Transformar.validarNumero(idPaciente)) {
			int idPaci = Integer.parseInt(idPaciente);

			PacienteVO paciente = new PacienteVO(idPaci);

			Hce hce = new Hce();
			int idHce = hce.obtenerIdHce(paciente);
			System.out.println(idHce);
			HceVO hceVO = new HceVO(idHce);
			List<RceVO> listaRceVO = hce.obtenerHce(hceVO);
			Rce rce = new Rce();

			List<RceVO> listaRce = rce.obtenerRce(listaRceVO);
			String respuesta = Transformar.rce(listaRce);
			return respuesta;
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite obtener el id del hce de un paciente a partir del id
	 * del paciente
	 * 
	 * @param idPaciente
	 *            String que representa al identificador del paciente
	 * @return identificador del hce del paciente
	 */
	public String obtenerIdHCE(String idPaciente) {
		if (Transformar.validarNumero(idPaciente)) {
			int idPaci = Integer.parseInt(idPaciente);
			PacienteVO paciente = new PacienteVO(idPaci);

			Hce hce = new Hce();
			int idHce = hce.obtenerIdHce(paciente);
			return idHce + "";
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite buscar las horas medicas a partir del id del paciente
	 * 
	 * @param idPaciente
	 *            id del paciente
	 * @return string con la lista de las horas medicas
	 */
	public String buscarHorasPorIdPaciente(String idPaciente) {
		if (Transformar.validarNumero(idPaciente)) {
			int id = Integer.parseInt(idPaciente);
			Reserva r = new Reserva();
			try {
				List<HoraMedicaVO> listaHoras = r
						.buscarHoraMedicaPorIdPaciente(id);
				if (listaHoras != null) {
					return Transformar.horasMedicas(listaHoras);
				} else {
					return "{\"results\":[]}";
				}
			} catch (NullPointerException e) {
				return "{\"results\":[]}";
			}
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite obtener la lista de procedimientos
	 * 
	 * @return
	 */
	public String obtenerListaProcedimientos() {
		try {
			Procedimiento d = new Procedimiento();
			List<ProcedimientoVO> lista = d.listaProcedimientos();
			if (lista == null) {
				return "{\"results\":[]}";
			}
			return Transformar.procedimientosLista(lista);
		} catch (NullPointerException e) {
			return "{\"results\":[]}";
		}
	}

	/**
	 * metodo que permite obtener la lista de diagnosticos
	 * 
	 * @return lista de diagnosticos json
	 */

	public String obtenerListaDiagnosticos() {
		try {
			Diagnostico d = new Diagnostico();
			List<DiagnosticoVO> lista = d.listaDiagnosticos();
			if (lista == null) {
				return "{\"results\":[]}";
			}
			return Transformar.diagnosticoLista(lista);
		} catch (NullPointerException e) {
			return "{\"results\":[]}";
		}
	}

	/**
	 * metodo que permite obtener la lista de actividades
	 * 
	 * @return json con la lista de actividades
	 */
	public String obtenerListaActividades() {
		try {
			Actividad d = new Actividad();
			List<ActividadVO> lista = d.listaActividades();
			if (lista == null) {
				return "{\"results\":[]}";
			}
			return Transformar.actividadLista(lista);
		} catch (NullPointerException e) {
			return "{\"results\":[]}";
		}
	}

	/**
	 * metodo que obtiene los diagnosticos por id
	 * 
	 * @param idDiagnostico
	 *            identificador del diagnostico
	 * @return json con los datos del diagnostico
	 */
	public String obtenerDiagnosticoporId(String idDiagnostico) {
		if (Transformar.validarNumero(idDiagnostico)) {
			int id = Integer.parseInt(idDiagnostico);
			Diagnostico diag = new Diagnostico();
			try {
				DiagnosticoVO diagnostico = diag.obtenerDiagnosticoPorId(id);
				if (diagnostico == null) {
					return "{\"results\":[]}";
				}
				return Transformar.diagnostico(diagnostico);
			} catch (NullPointerException e) {
				return "{\"results\":[]}";
			} catch (IllegalStateException e) {
				return "{\"results\":[]}";
			}
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que obtiene la actividad a partir del identificador
	 * 
	 * @param idActividad
	 *            string con el id de la actividad
	 * @return
	 */
	public String obtenerActividadporId(String idActividad) {
		if (Transformar.validarNumero(idActividad)) {
			int id = Integer.parseInt(idActividad);
			Actividad diag = new Actividad();
			try {
				ActividadVO actividad = diag.obtenerActividadPorId(id);
				if (actividad == null) {
					return "{\"results\":[]}";
				}
				return Transformar.actividad(actividad);
			} catch (NullPointerException e) {
				return "{\"results\":[]}";
			} catch (IllegalStateException e) {
				return "{\"results\":[]}";
			}
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que obtiene el hce del paciente por la ficha medica
	 * 
	 * @param fichaMedica
	 *            string con la ficha medica
	 * @return lista de rce con sus datos correspondientes
	 */
	public String obtenerHcePacientePorNombre(String fichaMedica) {

		String respuesta = "";
		Paciente paciente = new Paciente();
		List<RceVO> listaRce = paciente.obtenerhce(fichaMedica);
		respuesta = Transformar.rce(listaRce);

		if (respuesta != null) {
			return respuesta;
		} else {
			return "{\"results\":[]}";
		}
	}

	/**
	 * registra el rce de un paciente
	 * 
	 * @param json
	 *            son los datos pertinentes del rce
	 * @return id del rce almacenado en la bd local
	 */
	public String registrarRce(String json) {
		System.out.println(json);
		if (json != null) {
			try {
				RceVO rceVo = Transformar.jsonToRce2(json);
				Rce rce = new Rce();
				String idRce = rce.registrarRce(rceVo);
				// falta la uuid agregar para almacenar
				return idRce;
			} catch (NullPointerException e) {
				return "no registrado";
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "no registrado";
			}
		}
		return "no registrado";
	}

	/**
	 * metodo que permite registrar una receta
	 * 
	 * @param json
	 *            String con los datos de la receta
	 * @return
	 */
	public String registrarReceta(String json) {
		if (json != null) {
			Receta receta = new Receta();
			try {
				RecetaVO recetaVo = Transformar.jsonToreceta(json);
				String idreceta = receta.registrarReceta(recetaVo);
				return idreceta;
			} catch (NullPointerException | PersistentException e) {
				return "no registrado";
			}

		}
		return "no registrado";
	}

	/**
	 * metodo que permite obter el rce a partir de su id
	 * 
	 * @param idRce
	 *            string con el identificador del rce a buscar
	 * @return json con la lista de informacion del rce
	 */
	public String obtenerRcePorId(String idRce) {
		if (Transformar.validarNumero(idRce)) {
			int id = Integer.parseInt(idRce);
			Rce rce = new Rce();
			RceVO rceVo = rce.obtenerRcePorId(id);
			if (rceVo == null) {
				return "{\"results\":[]}";
			}
			return Transformar.rce1(rceVo);
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que obtiene lista de objetos con los datos de los diagnosticos
	 * 
	 * @param listaDiagnostico
	 *            json con lista de id de diagnosticos
	 * @return json con lista de datos de los diagnosticos
	 */
	public String obtenerListaDiagnosticosPorId(String listaDiagnostico) {
		if (listaDiagnostico != null) {
			List<DiagnosticoVO> listadiagnostico = Transformar
					.jsonToDiagnostico(listaDiagnostico);
			List<DiagnosticoVO> lista = new ArrayList<DiagnosticoVO>();
			Diagnostico diagnostico = new Diagnostico();
			for (int i = 0; i < listadiagnostico.size(); i++) {
				DiagnosticoVO diag = diagnostico
						.obtenerDiagnosticoPorId(listadiagnostico.get(i)
								.getId());
				lista.add(diag);
			}

			return Transformar.diagnosticoLista(lista);
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite obtener lista de actividades mediante la busqueda por
	 * una lista de id
	 * 
	 * @param listaActividad
	 *            json con lista de id de actividades
	 * @return json de actividades con sus datos
	 */
	public String obtenerListaActividadPorId(String listaActividad) {
		if (listaActividad != null) {
			List<ActividadVO> listaActividadVO = Transformar
					.jsonToActividad(listaActividad);
			List<ActividadVO> lista = new ArrayList<ActividadVO>();
			Actividad actividad = new Actividad();
			for (int i = 0; i < listaActividadVO.size(); i++) {
				ActividadVO diag = actividad
						.obtenerActividadPorId(listaActividadVO.get(i).getId());
				lista.add(diag);
			}

			return Transformar.actividadLista(lista);
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite obtener lista de procedimientos mediante lista de id
	 * de procedimientos
	 * 
	 * @param listaProcedimiento
	 *            json con lista de id de procedimientos
	 * @return json con lista de datos de procedimientos
	 */
	public String obtenerListaProcedimientoPorId(String listaProcedimiento) {
		if (listaProcedimiento != null) {
			List<ProcedimientoVO> listaProcedimientoVO = Transformar
					.jsonToProcedimiento(listaProcedimiento);
			List<ProcedimientoVO> lista = new ArrayList<ProcedimientoVO>();
			Procedimiento procedimiento = new Procedimiento();
			for (int i = 0; i < listaProcedimientoVO.size(); i++) {
				ProcedimientoVO diag = procedimiento
						.obtenerProcedimientoPorId(listaProcedimientoVO.get(i)
								.getId());
				lista.add(diag);
			}

			return Transformar.procedimientosLista(lista);
		}
		return "{\"results\":[]}";
	}

	/**
	 * metodo que permite obtener el rce completo con todos sus datos
	 * @param idRce string identificador del rce
	 * @return string con el json completo de datos
	 */
	public String obtenerRceCompleto(String idRce) {
		if (Transformar.validarNumero(idRce)) {
			int id = Integer.parseInt(idRce);
			Rce rce = new Rce();
			RceVO rceVo = rce.obtenerRceCompletoPorId(id);
			if (rceVo == null) {
				return "{\"results\":[]}";
			}
			return Transformar.rce1(rceVo);
		}
		return "{\"results\":[]}";
	}
/**
 * metodo que permite buscar la receta 
 * @param idReceta string con el identificador de la receta
 * @return string con json con datos de la receta
 */
	public String buscarReceta(String idReceta) {
		if (Transformar.validarNumero(idReceta)) {
			int id = Integer.parseInt(idReceta);
			Receta r = new Receta();
			RecetaVO receta = r.obtenerReceta(id);
			if(receta==null){
				return "{\"results\":[]}";
			}
			return Transformar.receta(receta);
		}
		return "{\"results\":[]}";
	}
	/**
	 * metodo que permite obtener las recetas que tiene un rce
	 * @param idRce string con el identificador del rce
	 * @return lista de recetas en parseado a json
	 */
	public String buscarRecetasPoridRce(String idRce){
		if(Transformar.validarNumero(idRce)){
			int id=Integer.parseInt(idRce);
			Receta r=new Receta();
			List<RecetaVO> lista=r.buscarRecetasPoridRce(id);
			if(lista.size()==0|| lista==null){
				return "{\"results\":[]}";
			}
			return Transformar.listaReceta(lista);
		}
		return "{\"results\":[]}";
	}
	/**
	 * metodo que permite registrar un concepto en openmrs
	 * @param jsonConcepto string json con los datos del concepto
	 * @return string con el uuid del concepto
	 */
	public String registrarConcepto(String jsonConcepto){
		if(jsonConcepto!=null){
			Concepto c=Transformar.jsonToConcepto(jsonConcepto);
			if(c==null){
				return "{\"results\":[]}";
			}
			return c.registrarConcepto(c);
			
		}
		return "{\"results\":[]}";
	}
	/**
	 * metodo que permite registar una observacion en openmrs
	 * @param jsonObservacion string con json de datos a registrar
	 * @return string uuid de la observacion
	 */
	public String registrarObservacion(String jsonObservacion){
		if(jsonObservacion!=null){
			Observacion obs=Transformar.jsonToObservacion(jsonObservacion);
			
			if(obs==null){
				return "{\"results\":[]}";
			}
			return obs.registrarObservacion(obs);
		}
		return "{\"results\":[]}";
	}
}
