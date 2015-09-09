package capaNegocio.openmrs;

import utilitario.Transformar;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Observacion {

	private String persona;
	private String fecha;
	private String concepto;
	private String encuentro;
	
	
	public Observacion() {
		super();
	}


	public Observacion(String persona, String fecha, String concepto,
			String encuentro) {
		super();
		this.persona = persona;
		this.fecha = fecha;
		this.concepto = concepto;
		this.encuentro = encuentro;
	}


	public String getPersona() {
		return persona;
	}


	public void setPersona(String persona) {
		this.persona = persona;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public String getEncuentro() {
		return encuentro;
	}


	public void setEncuentro(String encuentro) {
		this.encuentro = encuentro;
	}
	
	/**
	 * metodo que permite registrar una observacion en openmrs
	 * @param obs Observacion objeto con los datos a almacenar
	 * @return uuid de la observacion registrada
	 */
	
	public String registrarObservacion(Observacion obs){
		
		String mensaje="no registrado";

		//9fed5cb8-2af5-4ba2-a475-a2d8bc604d50 aps
		//8af7f6b9-832e-4ff7-9a26-12817abd4bc2 control
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/obs/234234efsdfsdfsdfsdf");
			
			String input = "{\"obsDatetime\": \""+obs.getFecha()+"\" ,  \"person\": \""+obs.getPersona()+"\",\"concept\": \""+obs.getConcepto()+"\",\"encounter\":\""+obs.getEncuentro()+"\" }";
			
			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			if(response.getStatus() == 200){
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
