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
 * Servlet implementation class HoraMedica
 */
@WebServlet(name = "HoraMedica", urlPatterns = { "/HoraMedica" })
public class HoraMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoraMedica() {
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

		ServicioProxy s = new ServicioProxy();
		String paciente = s.buscarPacienteId(idPaciente);
		PacienteVO pacienteVo=Transformar.pacienteVO(paciente);
		request.setAttribute("paciente", pacienteVo.getNroFicha()+"-"+pacienteVo.getNombre()+" "+pacienteVo.getApellidos());
		String listaHoras=s.buscarHorasPorIdPaciente(idPaciente);
		request.setAttribute("listaHoras", listaHoras);
		getServletContext().getRequestDispatcher("/listaHorasMedicas.jsp").forward(
				request, response);
	}

}
