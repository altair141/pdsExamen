package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilitario.Transformar;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaServicio.ServicioProxy;

/**
 * Servlet implementation class DetalleHoraMedica
 */
@WebServlet(name = "DetalleHoraMedica", urlPatterns = { "/DetalleHoraMedica" })
public class DetalleHoraMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetalleHoraMedica() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idHoraMedica = request.getParameter("idHora");
		ServicioProxy s = new ServicioProxy();
		String horaMedica = s.obtenerHoraMedica(idHoraMedica);
		System.out.println("jsonmedica"+horaMedica);
		HoraMedicaVO hMedica = Transformar.jsonTOHoraMedica(horaMedica);
		
		String fecha = Transformar.datetoStringHoraMedica(hMedica.getFecha());
		System.out.println(fecha);
		String tipo = "";
		if(hMedica.getAsp().equals("true")){
			tipo="APS";
		}else{
			tipo="CONTROL";
		}
		
		String box =hMedica.getBox().getNroHabitacion();
		String nombreHospital = hMedica.getBox().getEstablecimiento().getNombre();
		String medico = hMedica.getMedico().getPersona().getNombre();
		String apellido="";
		try{
			apellido=hMedica.getMedico().getPersona().getApellidos();
			if(apellido!=null){
			medico+=" "+apellido;
			}
		}catch(NullPointerException e){
			
		}
		
		String especialidad = hMedica.getMedico().getEspecialidad().getNombre();
		System.out.println(especialidad);
		request.setAttribute("fecha", fecha);
		request.setAttribute("tipo", tipo);
		request.setAttribute("medico", medico);
		request.setAttribute("especialidad", especialidad);
		request.setAttribute("box", box);
		request.setAttribute("nombreHospital", nombreHospital);
		
		getServletContext().getRequestDispatcher("/horaMedica.jsp").forward(
				request, response);
	}

}
