package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilitario.Transformar;
import capaNegocio.personasDomain.PacienteVO;
import capaServicio.ServicioProxy;

/**
 * Servlet implementation class RCE
 */
@WebServlet(name = "RCE", urlPatterns = { "/RCE" })
public class RCE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RCE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String paciente = request.getAttribute("listaPacientes").toString();
			getServletContext().getRequestDispatcher("/inicio.jsp").forward(
					request, response);

		} catch (NullPointerException e) {
			response.sendRedirect("BuscarPaciente");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idPaciente = request.getParameter("idPaciente");
		String idHora = request.getParameter("idHoraMedica");
		ServicioProxy s = new ServicioProxy();
		String paciente = s.buscarPacienteBdLocalId(idPaciente);
		String actividades=s.obtenerListaActividades();
		System.out.println(actividades);
		
		String procedimientos=s.obtenerListaProcedimientos();
		System.out.println(procedimientos);
		String diagnosticos=s.obtenerListaDiagnosticos();
		System.out.println(diagnosticos);
		PacienteVO pacienteVo = Transformar.jsonbdPaciente(paciente);
		request.setAttribute("paciente", pacienteVo.getNroFicha());
		String idHce=s.obtenerIdHCE(idPaciente);
		request.setAttribute("hce", idHce);
		request.setAttribute("procedimientos", procedimientos);
		request.setAttribute("actividades", actividades);
		request.setAttribute("diagnosticos", diagnosticos);
		
		//obtener diagnosticos, procedimientos y actividades
		
		
		
		getServletContext().getRequestDispatcher("/rce.jsp").forward(request,
				response);
	}

}
