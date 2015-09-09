package capaNegocio.personas;

import java.util.Date;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import utilitario.Transformar;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import capaNegocio.openmrs.PersonaOpen;
import capaNegocio.personasDomain.PersonaVO;

public class Persona {

	/**
	 * metodo que permite registrar una persona en la bd local
	 * @param personaVO objeto con los datos de la persona a guardar en la db local
	 * @return int con el id de la persona registrada
	 */
	public int registrarPersonaBdLocal(PersonaVO personaVO) {
		try {
			PersistentTransaction ts = orm.Taller2PersistentManager.instance()
					.getSession().beginTransaction();
			orm.Persona persona = orm.PersonaDAO.createPersona();
			persona.setApellidos(personaVO.getApellidos());
			persona.setDireccion(personaVO.getDireccion());
			persona.setEstado(personaVO.getEstado());
			Date fecha = personaVO.getFechaNacimiento();
			persona.setFechaNacimiento(fecha);
			persona.setNombre(personaVO.getNombre());
			persona.setRut(personaVO.getRut());
			persona.setSexo(personaVO.getSexo());
			if (orm.PersonaDAO.save(persona)) {
				ts.commit();
				// se cambia el estado de la hora medica para que sea aos
				return persona.getIdPersona();
			}
			return 0;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return 0;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	/**
	 * obtiene persona por el id 
	 * @param personaVO objeto que contiene el id de la persona
	 * @return objeto con los datos de la persona.
	 */
	public PersonaVO obtenerPersonasId(PersonaVO personaVO) {
		PersonaVO personaVo=new PersonaVO();
		try {
			orm.Persona persona = orm.PersonaDAO.getPersonaByORMID(personaVO
					.getIdPersona());
			personaVo.setIdPersona(persona.getIdPersona()); 
			personaVo.setApellidos(persona.getApellidos());
			personaVo.setDireccion(persona.getDireccion());
			personaVo.setEstado(persona.getEstado());
			personaVo.setFechaNacimiento(persona.getFechaNacimiento());
			personaVo.setNombre(persona.getNombre());
			personaVo.setRut(persona.getRut());
			personaVo.setSexo(persona.getSexo());

			return personaVo;
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
	 * obtiene la persona a traves de la busqueda por rut
	 * @param personaVO obtejo que contiene el rut de la persona
	 * @return objeto con los datos de la persona.
	 */
	public PersonaVO obtenerPersonaPorRut(PersonaVO personaVO) {
		PersonaVO personaVo=new PersonaVO();
		try {
			orm.Persona listaPersonas[] = orm.PersonaDAO.listPersonaByQuery(
					null, null);
			for (orm.Persona persona : listaPersonas) {
				if (persona.getRut().equals(personaVO.getRut())) {
					personaVo.setIdPersona(persona.getIdPersona()); 
					personaVo.setApellidos(persona.getApellidos());
					personaVo.setDireccion(persona.getDireccion());
					personaVo.setEstado(persona.getEstado());
					personaVo.setFechaNacimiento(persona.getFechaNacimiento());
					personaVo.setNombre(persona.getNombre());
					personaVo.setRut(persona.getRut());
					personaVo.setSexo(persona.getSexo());

					return personaVo;
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
	 * resgistrar persona en la bd de openmrs
	 * 
	 * @param personaVO
	 * @return
	 */
	public String registrarPersonaOpenmrs(PersonaOpen persona) {
		String sexo=persona.getSexo();
		String fecha=persona.getFecha();
		String nombre=persona.getNombre();
		String apellido=persona.getApellido();
		String direccion=persona.getDireccion();
		String mensaje="no registrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/person");

			String input = "{\"gender\":\""+sexo+"\", \"birthdate\":\""+fecha+"\" ,\"names\": [{\"givenName\":\""+nombre+"\", \"familyName\":\""+apellido+"\"}],\"addresses\":[{\"preferred\":\"true\",\"address1\":\""+direccion+"\"}]}";

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			if(response.getStatus() == 201){
				String respuesta="{\"results\":["+response.getEntity(String.class)+"]}";
				String personaUuid=Transformar.jsonPersonaUuid(respuesta);
			return personaUuid;
			}else{
				return mensaje;
			}

		  } catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		  }
	}

}
