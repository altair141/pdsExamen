package capaNegocio.fichamedica;

import utilitario.Transformar;
import capaNegocio.fichamedicaDomain.EncuentroVO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Encuentro {

public String registrarEncuentroOpenmrs(EncuentroVO encuentro) {
		
		String mensaje="no registrado";
		String fecha=encuentro.getFechaTime();
		String paciente=encuentro.getPaciente();
		String tipoencuentro=encuentro.getTipoEncuentro();
		System.out.println(fecha);
		//9fed5cb8-2af5-4ba2-a475-a2d8bc604d50 aps
		//8af7f6b9-832e-4ff7-9a26-12817abd4bc2 control
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/encounter");
			
			String input = "{\"encounterDatetime\" :\"" + fecha+"\",\"patient\":\""+paciente+"\", \"encounterType\":\""+tipoencuentro+"\" }";
			
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
