package junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import capaNegocio.personasDomain.PersonaVO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class Openmrs {

	@Test
	public void personaNameRestTest() {
		String respuesta=capaNegocio.rest.Openmrs.personaNameRest("aa992eb6-30f7-4a38-8bad84f35def");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
		
	}
	
	@Test
	public void pacienteUuidRestTest() {
		String respuesta=capaNegocio.rest.Openmrs.pacienteUuidRest("aa992eb6-30f7-4a38-894c-bbad84f35def");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
		
	}
	@Test
	public void pacienteRestTest() {
		String respuesta=capaNegocio.rest.Openmrs.pacienteRest("pablo");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
		
	}
	@Test
	public void medicoUuidRestTest() {
		String respuesta=capaNegocio.rest.Openmrs.medicoUuidRest("865d0545-2260-4f09-bb18-fd7202f7b0cc");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
		
	}@Test
	public void testPacienteRest() {
		String respuesta=capaNegocio.rest.Openmrs.pacienteRest("pablo");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testMedicoRest() {
		String respuesta=capaNegocio.rest.Openmrs.medicoRest("walter");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testMedicoUuidRest() {
		String respuesta=capaNegocio.rest.Openmrs.medicoUuidRest("865d0545-2260-4f09-bb18-fd7202f7b0cc");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testConceptoRest() {
		String respuesta=capaNegocio.rest.Openmrs.conceptoRest("hiv");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testConceptoUuidRest() {
		String respuesta=capaNegocio.rest.Openmrs.conceptoUuidRest("8e17b70f-08ab-11e5-b8b6-2089841041bc");
		System.out.println("concepto"+respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testConceptoNameRest() {
		String respuesta=capaNegocio.rest.Openmrs.conceptoNameRest("8e17b70f-08ab-11e5-b8b6-2089841041bc");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testEncuentroPorPacienteUuidRest() {
		String respuesta=capaNegocio.rest.Openmrs.encuentroPorPacienteUuidRest("aa992eb6-30f7-4a38-894c-bbad84f35def");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testEncuentroUuidRest() {
		String respuesta=capaNegocio.rest.Openmrs.encuentroUuidRest("3e3f6656-7fc6-408f-8b29-c073a346ad12");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testVisitaUuidRest() {
		String respuesta=capaNegocio.rest.Openmrs.visitaUuidRest("c0438378-76a9-4abe-b420-ec44325b27b4");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testVisitaPorPacienteUuidRest() {
		String respuesta=capaNegocio.rest.Openmrs.visitaPorPacienteUuidRest("aa992eb6-30f7-4a38-894c-bbad84f35def");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testBuscarPacientePorNombre() {
		List<PersonaVO> respuesta=capaNegocio.rest.Openmrs.buscarPacientePorNombre("pablo");
		System.out.println(respuesta);
		//assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testBuscarPesona() {
		String respuesta=capaNegocio.rest.Openmrs.buscarPesona("pablo");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testPersona() {
		String respuesta=capaNegocio.rest.Openmrs.persona("aa992eb6-30f7-4a38-894c-bbad84f35def");
		System.out.println("persona"+respuesta);
		assertTrue(respuesta!="no encontrado");
	}

	@Test
	public void testPersonaDireccion() {
		String respuesta=capaNegocio.rest.Openmrs.personaDireccion("aa992eb6-30f7-4a38-894c-bbad84f35def");
		System.out.println(respuesta);
		assertTrue(respuesta!="no encontrado");
	}

}
