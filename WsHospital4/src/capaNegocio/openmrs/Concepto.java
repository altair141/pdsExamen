package capaNegocio.openmrs;

import utilitario.Transformar;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Concepto {

	private String conceptClass;
	// names
	private String name;
	private String conceptNameType;
	private int tipoConcepto;
	private String datatype;

	public Concepto() {
		this.datatype = "8d4a4c94-c2cc-11de-8d13-0010c6dffd0f";
	}

	public Concepto(String conceptClass, String name,
			int tipoConcepto) {
		super();
		this.conceptClass = conceptClass;
		this.name = name;
		
		this.tipoConcepto = tipoConcepto;
		this.datatype = "8d4a4c94-c2cc-11de-8d13-0010c6dffd0f";
		
	}

	public String getConceptClass() {
		return conceptClass;
	}

	public void setConceptClass(String conceptClass) {
		this.conceptClass = conceptClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getConceptNameType() {
		return conceptNameType;
	}

	public void setConceptNameType(String conceptNameType) {
		this.conceptNameType = conceptNameType;
	}

	public int getTipoConcepto() {
		return tipoConcepto;
	}

	public void setTipoConcepto(int tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public void asignarconceptClass(int idTipo) {
		switch (idTipo) {
		case 1:
			// anamnesis
			this.conceptClass = "fc90f153-b7d7-427c-ae37-6cad54cdd8ff";
			break;
		case 2:
			// alergia
			this.conceptClass = "3fb16ad0-d586-4858-8262-4eb21b6b03cc";
			break;
		case 3:
			// examen fisico
			this.conceptClass = "6455e6c2-a9a5-467a-9c50-929db5b75f22";
			break;
		case 4:
			// indicacionmedica
			this.conceptClass = "374d1a3d-8790-44a9-a435-0d50500cbedd";
			break;
		case 5:
			// indicacion cierre caso clinico
			this.conceptClass = "b59236c4-5cb4-42fe-a134-c2ded781e10e";
			break;
		case 6:
			// hipotesis diagnostico
			this.conceptClass = "4d0fc0e3-ecb8-4c30-ad8d-dcc5064c577d";
			break;
		case 7:
			// diagnostico
			this.conceptClass = "4f5f8002-1815-479b-b5bc-75a732d210eb";
			break;
		case 8:
			// paciente ges
			this.conceptClass = "15757973-2ef8-4f84-9e13-f63d6b570a8c";
			break;
		case 9:
			// patologia ges
			this.conceptClass = "e36d44fb-4ce2-4a8b-9926-2c42849bf495";
			break;
		case 10:
			// paciente cronico
			this.conceptClass = "b6ce1ddb-109a-4f0a-bb0d-bf237da6b8db";
			break;

		case 11:
			// receta
			this.conceptClass = "e60d1a13-c37b-45b5-99e8-e05999546994";
			break;
		case 12:
			// certificado
			this.conceptClass = "d589096b-28e6-4f2c-ace7-25937a9588ec";
			break;

		case 13:
			// actividades
			this.conceptClass = "da9e328f-c847-4963-bc36-410ee7682d8a";
			break;
		case 14:
			// procedimiento
			this.conceptClass = "db960f4a-92da-4cbf-9954-94a1a273f722";
			break;
		case 15:
			// tipocierreclinico
			this.conceptClass = "8b6e6c45-eaf9-4daf-a5b1-1625bb5b2cd7";
			break;
		case 16:
			// destino
			this.conceptClass = "8ec113e2-ba7d-466a-a035-c4c8f4d8a096";
			break;
		case 17:
			// fecha atencion
			this.conceptClass = "99bf93e0-972e-44db-9a8d-b2195d59fe12";
			break;
		case 18:
			// hora atencion
			this.conceptClass = "795ecf59-c579-4efa-88ca-04f135049cab";
			break;
		case 19:
			// fecha cierreClinico
			this.conceptClass = "b10eae99-3607-4410-a42a-c9625229467e";
			break;
		case 20:
			// hora cierre clinico
			this.conceptClass = "46fb14fe-9d9b-47b8-8aea-12d1f1b4ac47";
			break;
		case 21:
			// tiempoControl
			this.conceptClass = "28058f18-de94-457a-9680-b20539195e29";
			break;
		case 22:
			// cierre Administro
			this.conceptClass = "5df4fd23-e5f6-4533-9584-12d3dfc4470c";
			break;
		default:
			this.conceptClass = "8d4907b2-c2cc-11de-8d13-0010c6dffd0f";
			break;
		}
	}

	public String registrarConcepto(Concepto concepto){
		String mensaje="no registrado";

		//9fed5cb8-2af5-4ba2-a475-a2d8bc604d50 aps
		//8af7f6b9-832e-4ff7-9a26-12817abd4bc2 control
		try {

			ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create(clientConfig);
			client.addFilter(new HTTPBasicAuthFilter("admin", "Admin123"));
			WebResource webResource = client
					.resource("http://localhost:8080/openmrs/ws/rest/v1/concept");
			
			String input = "{\"conceptClass\":\""+concepto.getConceptClass()+"\",\"names\":[{\"conceptNameType\":\"FULLY_SPECIFIED\",\"locale\":\"en\",\"name\":\""+concepto.getName()+"\"}],\"datatype\":\""+concepto.getDatatype()+"\"}";
			
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
	// {"conceptClass":"fc90f153-b7d7-427c-ae37-6cad54cdd8ff","names":[{"conceptNameType":"FULLY_SPECIFIED","locale":"en","name":"Brown-Kelly-Paterson syndrome"}],"datatype":"8d4a4c94-c2cc-11de-8d13-0010c6dffd0f"}
}
