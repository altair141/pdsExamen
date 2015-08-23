package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import capaNegocio.personasDomain.PersonaVO;
import capaServicio.Servicio;
import capaServicio.ServicioProxy;

/**
 * Servlet implementation class Inicio
 */
@WebServlet(name = "Inicio", urlPatterns = { "/Inicio" })
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("token", "segundo");
		// codigo para sincronizar todos los datos de openmrs
		ServicioProxy s = new ServicioProxy();
		
		//sincroniza pacientes

		String listaPacientes = s.buscarPacientePorNombre("");
		
		try {
			JsonElement jelement = new JsonParser().parse(listaPacientes);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");

			for (int i = 0; i < jarray.size(); i++) {
				jobject = jarray.get(i).getAsJsonObject();
				String uuid = jobject.get("uuid").getAsString();
				
				System.out.println(uuid);
				System.out.println("sincroni" + s.sincronizarPaciente(uuid));
			}
		} catch (NullPointerException e) {
			System.out.println("errornulo");
		} catch (UnsupportedOperationException e) {
			System.out.println("error estructura");

		}
		//sincroniza medicos
		String listaMedicos=s.buscarMedicoOpen("");
		System.out.println("lista:: "+listaMedicos);

		try {
			JsonElement jelement = new JsonParser().parse(listaMedicos);
			JsonObject jobject = jelement.getAsJsonObject();

			JsonArray jarray = jobject.getAsJsonArray("results");

			for (int i = 0; i < jarray.size(); i++) {
				jobject = jarray.get(i).getAsJsonObject();
				String uuid = jobject.get("uuid").getAsString();
				System.out.println(uuid);
				s.sincronizarMedicoToLocal(uuid);
				
				
			}
		} catch (NullPointerException e) {
			System.out.println("errornulo");
		} catch (UnsupportedOperationException e) {
			System.out.println("error estructura");

		}
		getServletContext().getRequestDispatcher("/inicio.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
