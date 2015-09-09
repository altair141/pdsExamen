package capaNegocio.personas;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;






import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import capaNegocio.openmrs.MedicoOpen;
import capaNegocio.openmrs.PacienteOpen;
import capaNegocio.personasDomain.EspecialidadVO;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PersonaVO;

public class Medico {

	/**
	 * metodo para registrar medico 
	 * @param medicoVo objeto con los datos de los medicos
	 * @return int entero con el id del medico creado en bd
	 */
	public int registrarMedicoBdLocal(MedicoVO medicoVo) {
		String mensaje = "no registrado";

		try {
			PersistentTransaction ts = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
			orm.Medico medico = orm.MedicoDAO.createMedico();
			orm.Especialidad especialidad = orm.EspecialidadDAO.getEspecialidadByORMID(medicoVo.getEspecialidad().getId());

			orm.Persona persona = orm.PersonaDAO.getPersonaByORMID(medicoVo.getIdPersona());
			medico.setEspecialidad(especialidad);
			medico.setIdPersona(persona);
			if (orm.MedicoDAO.save(medico)) {
				ts.commit();
				return medico.getIdMedico() ;
			}
			return 0;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (NullPointerException e) {
			return 0;
		}
	}
	
	
	/**
	 * registrar medico en openmrs
	 * @param paciente objeto con los datos del medico
	 * @return string con el uuid del medico
	 */
	public String registrarMedicoOpenmrs(MedicoOpen medico) {
		String persona = medico.getPersonUUid();
		String identificador = medico.getIdentifier();
		
		String mensaje = "no registrado";

		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/provider");

			String input = "{\"person\": \"" + persona+ "\", "
							+"\"identifier\":\""+identificador+"\""
							+"}";
			//
			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {

				return "{\"results\":[sdf]}";
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
	 * buscar medico por el id
	 * @param id int con el id del medico
	 * @return objeto con los datos del medico
	 */
	public MedicoVO buscarMedicoPorId(int id){
		MedicoVO medicoVo=new MedicoVO();
		Persona persona=new Persona();
		
		Especialidad especialidad=new Especialidad();
		try {
			orm.Medico medico=orm.MedicoDAO.getMedicoByORMID(id);
			medicoVo.setId(id);
			EspecialidadVO especialidadVo=especialidad.buscarEspecialidadPorId(medico.getEspecialidad().getIdEspecialidad());
			medicoVo.setEspecialidad(especialidadVo);
			PersonaVO personaVO=new PersonaVO();
			personaVO.setIdPersona(medico.getIdPersona().getIdPersona());
			 personaVO=persona.obtenerPersonasId(personaVO); 
			 medicoVo.setApellidos(personaVO.getApellidos());					
			 medicoVo.setDireccion(personaVO.getDireccion());
			 medicoVo.setEstado(personaVO.getEstado());
			 medicoVo.setFechaNacimiento(personaVO.getFechaNacimiento());
			 medicoVo.setIdPersona(personaVO.getIdPersona());
			 medicoVo.setNombre(personaVO.getNombre());
			 medicoVo.setRut(personaVO.getRut());
			 medicoVo.setSexo(personaVO.getSexo());
			return medicoVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	/*
	 * @param uuid String nombre del médico
	 * 
	 * @return response String Json con la respuesta de la información del
	 * médico
	 */
	public  String medicoRest(String id) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/provider"
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
			return mensaje;
		}
	}
	/*
	 * @param uuid String nombre del médico
	 * 
	 * @return response String Json con la respuesta de la información del
	 * médico
	 */
	public  String medicoUuid(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/provider"
							+ "/" + uuid);
			
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
			return mensaje;
		}
	}
	public boolean validarMedicoOpen(String idMedico){
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/provider"
							+ "/?q=" + idMedico);
			
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					return false;
				}
				
				return true;
			}
			return false;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
}
