package capaNegocio.personas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import utilitario.Transformar;
import capaNegocio.personasDomain.PersonaVO;

public class Persona {

	/**
	 * 
	 * @param personaVO
	 * @return
	 */
	public String registrarPersona(PersonaVO personaVO) {
		/*
		 * String bus=obtenerPersonaUuid(personaVO);
		 * if(!bus.equals("no encontrado")){ String
		 * json=this.obtenerPersonasId(personaVO); PersonaVO
		 * per=Transformar.jsonToPersonaLocal(json); return per.getId()+""; }
		 */
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
			persona.setUuid(personaVO.getUuid());

			if (orm.PersonaDAO.save(persona)) {
				ts.commit();
				// se cambia el estado de la hora medica para que sea aos
				return persona.getIdPersona() + "";
			}
			return "no registrado";
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return "no registrado";
		} catch (NullPointerException e) {
			return "no registrado";
		}

	}

	/**
	 * obtener personas por busqueda mediante la id en la bd local
	 * 
	 * @param personaVO
	 * @return
	 */
	public String obtenerPersonasId(PersonaVO personaVO) {
		String respuesta = "no encontrado";
		try {
			orm.Persona persona = orm.PersonaDAO.getPersonaByORMID(personaVO
					.getId());
			personaVO.setApellidos(persona.getApellidos());
			personaVO.setDireccion(persona.getDireccion());
			personaVO.setEstado(persona.getEstado());
			personaVO.setFechaNacimiento(persona.getFechaNacimiento());
			personaVO.setNombre(persona.getNombre());
			personaVO.setUuid(persona.getUuid());
			respuesta = Transformar.persona(personaVO);
			return respuesta;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return respuesta;
	}

	/**
	 * obtener personas por busqueda mediante la id en la bd local
	 * 
	 * @param personaVO
	 * @return
	 */
	public PersonaVO obtenerPersonaId(int id) {
		String respuesta = "no encontrado";
		PersonaVO personaVO = new PersonaVO();
		try {
			orm.Persona persona = orm.PersonaDAO.getPersonaByORMID(id);
			personaVO.setApellidos(persona.getApellidos());
			personaVO.setDireccion(persona.getDireccion());
			personaVO.setEstado(persona.getEstado());
			personaVO.setFechaNacimiento(persona.getFechaNacimiento());
			personaVO.setNombre(persona.getNombre());
			personaVO.setUuid(persona.getUuid());
			personaVO.setId(id);			
			return personaVO;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			return null;
		}	
	}

	public String obtenerPersonaUuid(PersonaVO personaVO) {
		String respuesta = "no encontrado";
		try {
			orm.Persona listaPersona[] = orm.PersonaDAO.listPersonaByQuery(
					null, null);
			for (orm.Persona persona : listaPersona) {
				if (persona.getUuid().equals(personaVO.getUuid())) {
					personaVO.setId(persona.getIdPersona());
					personaVO.setApellidos(persona.getApellidos());
					personaVO.setDireccion(persona.getDireccion());
					personaVO.setEstado(persona.getEstado());
					personaVO.setFechaNacimiento(persona.getFechaNacimiento());
					personaVO.setNombre(persona.getNombre());
					personaVO.setUuid(persona.getUuid());
					respuesta = Transformar.persona(personaVO);
					break;
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {

		}

		return respuesta;
	}

	public String obtenerListaPersonas() {
		String respuesta = "no encontrado";
		List<PersonaVO> listaPersonas = new ArrayList<PersonaVO>();
		try {
			orm.Persona listaPersona[] = orm.PersonaDAO.listPersonaByQuery(
					null, null);
			for (orm.Persona persona : listaPersona) {
				PersonaVO personaVO = new PersonaVO();
				personaVO.setId(persona.getIdPersona());
				personaVO.setApellidos(persona.getApellidos());
				personaVO.setDireccion(persona.getDireccion());
				personaVO.setEstado(persona.getEstado());
				personaVO.setFechaNacimiento(persona.getFechaNacimiento());
				personaVO.setNombre(persona.getNombre());
				personaVO.setUuid(persona.getUuid());
				listaPersonas.add(personaVO);

			}

			respuesta = Transformar.personas(listaPersonas);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return respuesta;
	}

	/**
	 * resgistrar persona en la bd de openmrs
	 * 
	 * @param personaVO
	 * @return
	 */
	public String registrarPersonaOpenmrs(PersonaVO persona) {
		String sexo=persona.getEstado();
		String fecha=Transformar.datetoString(persona.getFechaNacimiento());
		String nombre=persona.getNombre();
		String apellido=persona.getApellidos();
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
				String personaUuid=Transformar.jsonPersonaUud(respuesta);
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
