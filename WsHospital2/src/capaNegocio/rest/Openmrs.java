package capaNegocio.rest;

import java.util.ArrayList;
import java.util.List;

import utilitario.Transformar;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PersonaVO;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Openmrs {
	
	/*
	 * @param uuid String uuid obtenida de openmrs
	 * 
	 * @return response String Json con la respuesta de la información de la
	 * persona
	 */
	public static String personaNameRest(String uuid) {
		// /openmrs/ws/rest/v1/encounter?patient=aa992eb6-30f7-4a38-894c-bbad84f35def
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/person"
							+ "/" + uuid + "/name");
			
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
	 * @param uuid String uuid obtenida de openmrs
	 * 
	 * @return response String Json con la respuesta de la información del
	 * paciente
	 */
	public static String pacienteUuidRest(String uuid) {
		// /openmrs/ws/rest/v1/encounter?patient=aa992eb6-30f7-4a38-894c-bbad84f35def
		
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/patient"
							+ "/" + uuid);

		
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					return mensaje;
				}
				mensaje="{\"results\":["+response+"]}";
				return mensaje;
			}
			return mensaje;
		} catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		}

	}
	
	/*
	 * @param uuid String nombre del paciente
	 * 
	 * @return response String Json con la respuesta de la información del
	 * paciente
	 */
	public static String pacienteRest(String uuid) {
		// /openmrs/ws/rest/v1/encounter?patient=aa992eb6-30f7-4a38-894c-bbad84f35def
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/patient"
							+ "/?q=" + uuid);
			
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
	/*
	 * @param uuid String nombre del médico
	 * 
	 * @return response String Json con la respuesta de la información del
	 * médico
	 */
	public static String medicoRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/provider"
							+ "/?q=" + uuid);
			
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
	public static List<PersonaVO> busquedaOpenmedicoRest(String uuid) {
		List<PersonaVO> medicos=new ArrayList<PersonaVO>();
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/provider"
							+ "/?q=" + uuid);
			
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					return null;
				}
				mensaje=response;
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		System.out.println("medico opne"+mensaje);
		if(mensaje != null || !mensaje.isEmpty() || mensaje.length() != 0||!mensaje.equals("no encontrado")){

			JsonElement jelement = new JsonParser().parse(mensaje);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");
			
			for (int i = 0; i < jarray.size(); i++) {
				jobject = jarray.get(i).getAsJsonObject();
				PersonaVO medico=new PersonaVO(jobject.get("uuid").getAsString());
				System.out.println(medico.getUuid());
				medicos.add(medico);
			}	
		}
		
		return medicos;
	}
	/*
	 * @param uuid String identificador del médico
	 * 
	 * @return response String Json con la respuesta de la información del
	 * médico
	 */
	public static String medicoUuidRest(String uuid) throws UniformInterfaceException {
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
				mensaje="{\"results\":["+response+"]}";
				return mensaje;
			}
			return mensaje;
		} catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		}
	}
	

	/*
	 * @param uuid String nombre del concepto
	 * 
	 * @return response String Json con la respuesta de la información del
	 * concepto
	 */
	public static String conceptoRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/concept"
							+ "/?q=" + uuid);
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
	 * @param uuid String identificador del concepto
	 * 
	 * @return response String Json con la respuesta de la información del
	 * concepto
	 */
	public static String conceptoUuidRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/concept"
							+ "/" + uuid);
		
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					return mensaje;
				}
				mensaje="{\"results\":["+response+"]}";
				return mensaje;
			}
			return mensaje;
		} catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		}
	}
	/*
	 * @param uuid String nombre del concepto
	 * 
	 * @return response String Json con la respuesta de la información del
	 * concepto a partir del nombre
	 */
	public static String conceptoNameRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/concept"
							+ "/" + uuid + "/name");
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
	 * @param uuid String identificador del paciente
	 * 
	 * @return response String Json con la respuesta de la información del
	 * encuentro
	 */
	public static String encuentroPorPacienteUuidRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "encounter?patient=" + uuid);
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
	 * @param uuid String identificador del encuentro
	 * 
	 * @return response String Json con la respuesta de la información del
	 * encuentro
	 */
	public static String encuentroUuidRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "encounter/" + uuid);
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					return mensaje;
				}
				mensaje="{\"results\":["+response+"]}";
				return mensaje;
			}
			return mensaje;
		} catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		}
	}

	/*
	 * @param uuid String identificador de la visita
	 * 
	 * @return response String Json con la respuesta de la información de la
	 * visita
	 */
	public static String visitaUuidRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "visit/" + uuid);
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
	 * @param uuid String identificador del paciente
	 * 
	 * @return response String Json con la respuesta de la información de la
	 * visita
	 */
	public static String visitaPorPacienteUuidRest(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "visit?patient=" + uuid);
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
	 * @param uuid String nombre de la persona
	 * 
	 * @return response String Json con la respuesta de la información del paciente
	 * 
	 */
	public static List<PersonaVO> buscarPacientePorNombre(String nombre) {
		String persona = "no encontrado";
		List<PersonaVO>listaPersona=new ArrayList<PersonaVO>();
		String[] arrayUuid = null;
		String pacientes = "";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "person/?q=" + nombre);
			persona = resource.get(String.class);

		} catch (Exception e) {

			e.printStackTrace();

		}
		if (persona != null || !persona.isEmpty() || persona.length() != 0||!persona.equals("no encontrado")) {

			JsonElement jelement = new JsonParser().parse(persona);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");
			arrayUuid = new String[jarray.size()];
			for (int i = 0; i < jarray.size(); i++) {
				jobject = jarray.get(i).getAsJsonObject();
				String uuid = jobject.get("uuid").getAsString();
				
				arrayUuid[i] = uuid;
			}
		}
		if (arrayUuid != null) {

			for (int i = 0; i < arrayUuid.length; i++) {
				String estado = pacienteUuidRest(arrayUuid[i]);
				
				if (!"no encontrado".equals(estado)) {
					JsonElement jelement = new JsonParser().parse(estado);
					JsonObject jobject = jelement.getAsJsonObject();
					JsonArray jarray = jobject.getAsJsonArray("results");
					jobject = jarray.get(0).getAsJsonObject();
					PersonaVO personaVo=new PersonaVO(jobject.get("uuid").getAsString());
					listaPersona.add(personaVo);
												
				}
				
			}
			
		}

		return listaPersona;
	}

	/*
	 * @param uuid String nombre de la persona
	 * 
	 * @return response String Json con la respuesta de la información de la persona
	 * 
	 */
	public static String buscarPesona(String nombre) {
		String persona = "no encontrado";
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "person/?q=" + nombre);
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
	 * @param uuid String identificador de la persona
	 * 
	 * @return response String Json con la respuesta de la información de la persona
	 * 
	 */
	public static String persona(String uuid) {
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "person/" + uuid);
			ClientResponse responses = resource.accept("application/json").get(
					ClientResponse.class);
			if (responses.getStatus() == 200) {
				String response = resource.get(String.class);
				response = resource.get(String.class);
				if(response.equals("{\"results\":[]}")){
					return mensaje;
				}
				mensaje="{\"results\":["+response+"]}";
				return mensaje;
			}
			return mensaje;
		} catch (Exception e) {

			e.printStackTrace();
			return mensaje;
		}
	}

	/*
	 * @param uuid String identificador de la persona
	 * 
	 * @return response String Json con la respuesta de la información de la persona
	 * 
	 */
	public static String personaDireccion(String uuid) {
		String persona = "no encontrado";
		String mensaje="no encontrado";
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource resource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/"
							+ "person/" + uuid+"/address");
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
	
	
	// --------------------------------------------finget------------------------------------------------------
}
