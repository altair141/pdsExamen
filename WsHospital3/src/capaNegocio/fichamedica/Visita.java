package capaNegocio.fichamedica;

import java.util.Date;

import utilitario.Transformar;
import capaNegocio.fichamedicaDomain.VisitaVO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Visita {
public String registrarVisitaOpenmrs(VisitaVO visita) {
		
		String mensaje="no registrado";
		String paciente=visita.getUuidPaciente();
		String tipoVisita=visita.getUuidVisitType();
		Date fechaDate=visita.getStartDateTime();
		String fecha=Transformar.dateTimetoString2(fechaDate);
		System.out.println(fecha);
		
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/visit");
			
			String input = "{\"patient\":\""+paciente+"\", \"visitType\":\""+tipoVisita+"\" ,\"startDatetime\" :\"" + fecha+"\" }";
			
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
