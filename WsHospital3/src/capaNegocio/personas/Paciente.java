package capaNegocio.personas;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import utilitario.Transformar;
import capaNegocio.personasDomain.PacienteVO;
import capaNegocio.personasDomain.PersonaVO;
import capaNegocio.rest.PacienteOpen;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Paciente {

	/**
	 * registra en la bd local un paciente
	 * 
	 * @param pacienteVO
	 *            objeto que contiene la informacion de la persona
	 * @return String con el id del paciente
	 */
	public String registrarPaciente(PacienteVO pacienteVO) {
		
		try {
			PersistentTransaction ts = orm.Taller2PersistentManager.instance()
					.getSession().beginTransaction();
			orm.Paciente paciente = orm.PacienteDAO.createPaciente();
			paciente.setNroFichaMedica(pacienteVO.getNroFicha());
			orm.Persona persona = orm.PersonaDAO.getPersonaByORMID(pacienteVO
					.getPersona().getId());
			paciente.setIdPersona(persona);

			if (orm.PacienteDAO.save(paciente)) {
				ts.commit();
				return paciente.getIdPaciente() + "";
			}

			return "no registrado";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "no registrado";
		}

	}

	/**
	 * obtiene un paciente a partir del id de la bd local
	 * 
	 * @param pacienteVO
	 *            objeto que contiene la id del paciente
	 * @return json con los datos del paciente asi como el de la persona
	 */
	public String obtenerPacienteId(PacienteVO pacienteVO) {
		String respuesta = "no encontrado";

		try {
			orm.Paciente paciente = orm.PacienteDAO
					.getPacienteByORMID(pacienteVO.getId());
			orm.Persona persona = orm.PersonaDAO.getPersonaByORMID(paciente
					.getIdPersona().getIdPersona());
			PersonaVO per = new PersonaVO(persona.getIdPersona());
			Persona person = new Persona();
			String personaJson = person.obtenerPersonasId(per);
			pacienteVO.setNroFicha(paciente.getNroFichaMedica());
			pacienteVO.setPersona(Transformar.jsonToPersonaLocal(personaJson));
			respuesta = Transformar.paciente(pacienteVO);
			return respuesta;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return respuesta;
		}

	}

	/**
	 * obtiene el paciente mediante el id de la persona
	 * 
	 * @param id
	 * @return objeto que contiene los datos del paciente
	 */
	public PacienteVO obtenerPacientePorIdPersona(int id) {
		PacienteVO pacienteVO = new PacienteVO();

		try {
			orm.Paciente listaPacientes[] = orm.PacienteDAO
					.listPacienteByQuery(null, null);
			for (orm.Paciente paciente : listaPacientes) {
				if (paciente.getIdPersona().getIdPersona() == id) {
					pacienteVO.setNroFicha(paciente.getNroFichaMedica());
					pacienteVO.setId(id);

					return pacienteVO;
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
	 * obtiene el paciente mediante la uuid de la persona
	 * 
	 * @param personaVO
	 *            objeto que contiene la uuid de la persona
	 * @return json con los datos del paciente
	 */
	public String obtenerPacienteUuid(PersonaVO personaVO) {
		try {
			Persona p = new Persona();
			String personaJson = p.obtenerPersonaUuid(personaVO);
			System.out.println("paciente" + personaJson);
			PersonaVO persona = Transformar.jsonToPersonaLocal(personaJson);
			PacienteVO paciente = obtenerPacientePorIdPersona(persona.getId());
			paciente.setPersona(persona);
			String respuesta = Transformar.paciente(paciente);

			return respuesta;
		} catch (NullPointerException e) {

			return null;
		} catch (UnsupportedOperationException e) {

			return null;
		} catch (IllegalStateException e) {

			return null;
		}
	}

	/**
	 * obtiene lista de pacientes en la bd local
	 * 
	 * @return json con la lista de pacientes junto con sus datos
	 */
	public String obtenerListaPacientes() {
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
				persona.setId(paciente.getIdPersona().getIdPersona());
				String jsonPersona = per.obtenerPersonasId(persona);
				persona = Transformar.jsonToPersonaLocal(jsonPersona);
				pacienteVo.setPersona(persona);
				listaPaciente.add(pacienteVo);
			}
			return Transformar.pacientes(listaPaciente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return respuesta;
		}
	}
	public PacienteVO obtenerPacientePorIdPaciente(int id){
		PacienteVO pacienteVO=new PacienteVO(); 
		orm.Paciente listaPacientes[];
		try {
			listaPacientes = orm.PacienteDAO.listPacienteByQuery(null, null);
			for (orm.Paciente paciente : listaPacientes) {
				if(paciente.getIdPaciente()==id){
					pacienteVO.setId(id);
					pacienteVO.setNroFicha(paciente.getNroFichaMedica());
					break;
				}
			}
			return pacienteVO;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	public PersonaVO obtenerPersonaPorIdPaciente(int id) {
		PersonaVO persona = new PersonaVO();
		orm.Paciente listaPacientes[];
		try {
			listaPacientes = orm.PacienteDAO.listPacienteByQuery(null, null);
			for (orm.Paciente paciente : listaPacientes) {
				if(paciente.getIdPaciente()==id){
					orm.Persona per=orm.PersonaDAO.getPersonaByORMID(paciente.getIdPersona().getIdPersona());
					persona.setId(per.getIdPersona());
					persona.setDireccion(per.getDireccion());
					persona.setApellidos(per.getApellidos());
					persona.setEstado(per.getEstado());
					persona.setFechaNacimiento(per.getFechaNacimiento());
					persona.setNombre(per.getNombre());
					persona.setUuid(per.getUuid());
					break;
				}

			}
			return persona;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}			
	}

	/**
	 * resgistrar paciente en la bd de openmrs
	 * 
	 * @param pacienteVO
	 * @return
	 */
	public String registrarPacienteOpenmrs(PacienteOpen paciente) {
		String persona=paciente.getPersonUUid();
		String identificador=paciente.getIdentifier();
		String tipo=paciente.getIdentifierType();
		String localizacion=paciente.getLocation();
		String mensaje="no registrado";
		/*
		 * {"person": "5131784a-ac5f-4f2a-aaa3-ad0ebb927db1", //se optiene al crear una persona
		 * "identifiers": [{"identifier":"1234", //es creado por mi
		 *  "identifierType":"8d79403a-c2cc-11de-8d13-0010c6dffd0f", //es la uuid de la tabla patient_identifier_type
		 *  "location":"8d6c993e-c2cc-11de-8d13-0010c6dffd0f",// es la uuid de la tabla location
		 *   "preferred":true}]}// es un dato xalla que tiene que estar es predeterminado
		 * 
		 */
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/patient");

			String input = "{\"person\": \""+persona+"\", \"identifiers\": [{\"identifier\":\""+identificador+"\",  \"identifierType\":\""+tipo+"\",\"location\":\""+localizacion+"\", \"preferred\":true}]}";
//
			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			if(response.getStatus() == 201){
				String respuesta="{\"results\":["+response.getEntity(String.class)+"]}";
				
			return respuesta;
			}else{
				return mensaje;
			}

		  } catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		  }
		

	}


}
