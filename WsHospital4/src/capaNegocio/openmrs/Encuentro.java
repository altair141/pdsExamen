package capaNegocio.openmrs;

import utilitario.Transformar;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Encuentro {
	private String fechaTime;
	private String paciente;
	private String medico;
	private String tipoEncuentro;

	

	public Encuentro(String fechaTime, String paciente, String medico,
			String tipoEncuentro) {
		super();
		this.fechaTime = fechaTime;
		this.paciente = paciente;
		this.medico = medico;
		this.tipoEncuentro = tipoEncuentro;
	}

	public Encuentro() {
		super();
	}

	public String getFechaTime() {
		return fechaTime;
	}

	public void setFechaTime(String fechaTime) {
		this.fechaTime = fechaTime;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getTipoEncuentro() {
		return tipoEncuentro;
	}

	public void setTipoEncuentro(String tipoEncuentro) {
		this.tipoEncuentro = tipoEncuentro;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	
public String registrarEncuentroOpenmrs(Encuentro encuentro) {
		
		String mensaje="no registrado";
		String fecha=encuentro.getFechaTime();
		String pacienteEncuentro=encuentro.getPaciente();
		String medicoEncuentro=encuentro.getMedico();
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
			
			String input = "{\"encounterDatetime\" :\"" + fecha+"\",\"patient\":\""+pacienteEncuentro+"\", \"encounterType\":\""+tipoencuentro+"\",\"provider\":\""+medicoEncuentro+"\" }";
			
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
