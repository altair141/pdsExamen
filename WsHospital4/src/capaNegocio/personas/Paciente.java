package capaNegocio.personas;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import capaNegocio.fichaMedica.Hce;
import capaNegocio.fichaMedicaDomain.HceVO;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.openmrs.PacienteOpen;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;

public class Paciente {
	/**
	 * metodo que permite registrarPaciente
	 * @param pacienteVO objeto que contiene los datos del paciente
	 * @return int identificador del paciente en la bd
	 */
	public int registrarPaciente(PacienteVO pacienteVO) {

		try {
			PersistentTransaction ts = orm.Taller2PersistentManager.instance()
					.getSession().beginTransaction();
			orm.Paciente paciente = orm.PacienteDAO.createPaciente();
			paciente.setNroFichaMedica(pacienteVO.getNroFicha());
			orm.Persona persona = orm.PersonaDAO.getPersonaByORMID(pacienteVO
					.getIdPersona());
			paciente.setIdPersona(persona);

			if (orm.PacienteDAO.save(paciente)) {
				ts.commit();
				return paciente.getIdPaciente();
			}

			return 0;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
/**
 * metodo que permite almacenar al paciente en la bd de openmrs
 * @param paciente objeto que contiene los datos del paciente
 * @return string con el resultado de la operacion de almacenamiento
 */
	public String registrarPacienteOpenmrs(PacienteOpen paciente) {
		
		String persona = paciente.getPersonUUid();
		String identificador = paciente.getIdentifier();
		String tipo = paciente.getIdentifierType();
		String localizacion = paciente.getLocation();
		String mensaje = "no registrado";

		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/patient");

			String input = "{\"person\": \"" + persona
					+ "\", \"identifiers\": [{\"identifier\":\""
					+ identificador + "\",  \"identifierType\":\"" + tipo
					+ "\",\"location\":\"" + localizacion
					+ "\", \"preferred\":true}]}";
			//
			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {

				return "{\"results\":[]}";
				// throw new RuntimeException("Failed : HTTP error code : "
				// + response.getStatus());

			} else if (response.getStatus() == 201) {
				String respuesta = "{\"results\":["
						+ response.getEntity(String.class) + "]}";

				return respuesta;
			} else {
				return mensaje;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		}
	}

	/**
	 * obtiene lista de pacientes en la bd local
	 * 
	 * @return json con la lista de pacientes junto con sus datos
	 */
	public List<PacienteVO> obtenerListaPacientes() {
		String respuesta = "no encontrado";
		List<PacienteVO> listaPaciente = new ArrayList<PacienteVO>();
		Persona per = new Persona();
		orm.Paciente listaPacientes[];
		try {
			listaPacientes = orm.PacienteDAO.listPacienteByQuery(null, null);
			for (orm.Paciente paciente : listaPacientes) {
				PacienteVO pacienteVo = new PacienteVO();
				PersonaVO persona = new PersonaVO();
				pacienteVo.setNroFicha(paciente.getNroFichaMedica());
				pacienteVo.setId(paciente.getIdPaciente());

				persona.setIdPersona(paciente.getIdPersona().getIdPersona());
				PersonaVO personaVO = per.obtenerPersonasId(persona);
				// datos persona
				pacienteVo.setApellidos(personaVO.getApellidos());
				pacienteVo.setDireccion(personaVO.getDireccion());
				pacienteVo.setEstado(personaVO.getEstado());
				pacienteVo.setFechaNacimiento(personaVO.getFechaNacimiento());
				pacienteVo.setIdPersona(personaVO.getIdPersona());
				pacienteVo.setNombre(personaVO.getNombre());
				pacienteVo.setRut(personaVO.getRut());
				pacienteVo.setSexo(personaVO.getSexo());
				listaPaciente.add(pacienteVo);
			}
			return listaPaciente;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * obtiene el paciente mediante el id de la persona
	 * 
	 * @param id
	 * @return objeto que contiene los datos del paciente
	 */
	public PacienteVO obtenerPacientePorIdPersona(int id) {
		PacienteVO pacienteVo = new PacienteVO();
		Persona p = new Persona();
		try {
			orm.Paciente listaPacientes[] = orm.PacienteDAO
					.listPacienteByQuery(null, null);
			for (orm.Paciente paciente : listaPacientes) {
				if (paciente.getIdPersona().getIdPersona() == id) {
					pacienteVo.setNroFicha(paciente.getNroFichaMedica());
					pacienteVo.setId(id);
					PersonaVO persona = new PersonaVO();
					persona.setIdPersona(id);
					PersonaVO personaVO = p.obtenerPersonasId(persona);
					// datos persona
					pacienteVo.setApellidos(personaVO.getApellidos());
					pacienteVo.setDireccion(personaVO.getDireccion());
					pacienteVo.setEstado(personaVO.getEstado());
					pacienteVo.setFechaNacimiento(personaVO
							.getFechaNacimiento());
					pacienteVo.setIdPersona(personaVO.getIdPersona());
					pacienteVo.setNombre(personaVO.getNombre());
					pacienteVo.setRut(personaVO.getRut());
					pacienteVo.setSexo(personaVO.getSexo());
					return pacienteVo;
				}
			}
			return null;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * obtiene el paciente mediante el rut de la persona
	 * 
	 * @param id
	 * @return objeto que contiene los datos del paciente
	 */
	public PacienteVO obtenerPacientePorRutPersona(String rut) {
		PacienteVO pacienteVo = new PacienteVO();
		Persona p = new Persona();
		try {
			orm.Paciente listaPacientes[] = orm.PacienteDAO
					.listPacienteByQuery(null, null);
			for (orm.Paciente paciente : listaPacientes) {

				PersonaVO persona = new PersonaVO();
				persona.setIdPersona(paciente.getIdPersona().getIdPersona());
				PersonaVO personaVO = p.obtenerPersonasId(persona);
				if (personaVO.getRut().equalsIgnoreCase(rut)) {

					pacienteVo.setNroFicha(paciente.getNroFichaMedica());
					pacienteVo.setId(paciente.getIdPaciente());

					// datos persona
					pacienteVo.setApellidos(personaVO.getApellidos());
					pacienteVo.setDireccion(personaVO.getDireccion());
					pacienteVo.setEstado(personaVO.getEstado());
					pacienteVo.setFechaNacimiento(personaVO
							.getFechaNacimiento());
					pacienteVo.setIdPersona(personaVO.getIdPersona());
					pacienteVo.setNombre(personaVO.getNombre());
					pacienteVo.setRut(personaVO.getRut());
					pacienteVo.setSexo(personaVO.getSexo());
					return pacienteVo;

				}

			}
			return null;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * obtiene el paciente mediante el id del paciente
	 * 
	 * @param id
	 * @return objeto que contiene los datos del paciente
	 */
	public PacienteVO obtenerPacientePorId(int id) {
		PacienteVO pacienteVo = new PacienteVO();
		Persona p = new Persona();
		try {

			orm.Paciente paciente = orm.PacienteDAO.getPacienteByORMID(id);
			if (paciente != null) {
				pacienteVo.setNroFicha(paciente.getNroFichaMedica());
				pacienteVo.setId(paciente.getIdPaciente());
				PersonaVO persona = new PersonaVO();
				persona.setIdPersona(paciente.getIdPersona().getIdPersona());
				PersonaVO personaVO = p.obtenerPersonasId(persona);
				// datos persona
				pacienteVo.setApellidos(personaVO.getApellidos());
				pacienteVo.setDireccion(personaVO.getDireccion());
				pacienteVo.setEstado(personaVO.getEstado());
				pacienteVo.setFechaNacimiento(personaVO.getFechaNacimiento());
				pacienteVo.setIdPersona(personaVO.getIdPersona());
				pacienteVo.setNombre(personaVO.getNombre());
				pacienteVo.setRut(personaVO.getRut());
				pacienteVo.setSexo(personaVO.getSexo());
				return pacienteVo;
			}
			return null;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * metodo que permite validar al paciente, existe o no existe en la bd de openmrs
	 * @param nroFicha string con el numero de ficha del paciente o identificador del paciente
	 * @return boolean resultado de la existencia en la bd de openmrs
	 */
	public boolean validarPaciente(String nroFicha){
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/patient"
							+ "/?q=" +nroFicha);
			
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					//return mensaje;
					return false;
				}
				mensaje=response;
				//return mensaje;
				return true;
			}
			//return mensaje;
			return false;
		} catch (Exception e) {

			e.printStackTrace();
			//return "no encontrado";
			return false;
		}

	}
	/**
	 * metodo que obtiene el hce del paciente mediante la busqueda por el indentificador del paciente o ficha medica
	 * @param fichaMedica String con el indentificador del paciente
	 * @return lista de objetos con los datos de los rce
	 */
	public List<RceVO> obtenerhce(String fichaMedica) {
		int idHce = 0;
		Hce hce = new Hce();
		try {
			orm.Paciente listaPacientes[] = orm.PacienteDAO
					.listPacienteByQuery(null, null);
			for (orm.Paciente paciente : listaPacientes) {
				
				if (paciente.getNroFichaMedica().equals(fichaMedica)) {
					
					PacienteVO p = new PacienteVO();
					p.setId(paciente.getIdPaciente());

					idHce = hce.obtenerIdHce(p);
					
					break;
				}
			}

		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NullPointerException e) {

		}
		if (idHce != 0) {
			HceVO hceVo = hce.ontenerHcePorId(idHce);
			
			List<RceVO> listRce = hce.obtenerHce(hceVo);			
			return listRce;
		} else {
			return null;
		}
	}
	
	/**
	 * metodo para obtener la uuid del paciente
	 * @param uuid String nombre del paciente	 * 
	 * @return response String Json con la respuesta de la información del
	 * paciente
	 */
	public String pacienteRest(String id) {
		// /openmrs/ws/rest/v1/encounter?patient=aa992eb6-30f7-4a38-894c-bbad84f35def
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/patient"
							+ "/?q=" + id);
			
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					return mensaje;
				}
				mensaje=response;
				return mensaje;
			}
			return mensaje;
		} catch (Exception e) {

			e.printStackTrace();
			return "no encontrado";
		}

	}
}
