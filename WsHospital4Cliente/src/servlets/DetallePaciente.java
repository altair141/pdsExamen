package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import capaServicio.ServicioProxy;

/**
 * Servlet implementation class DetallePaciente
 */
@WebServlet(name = "DetallePaciente", urlPatterns = { "/DetallePaciente" })
public class DetallePaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallePaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try{
	    		String paciente=request.getAttribute("listaPacientes").toString();
	    		getServletContext().getRequestDispatcher("/inicio.jsp").forward(request,
	    				response);
	    	
	    		}catch(NullPointerException e){
	    			response.sendRedirect("BuscarPaciente");
	    		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String idPersona=request.getParameter("idPersona");
		
		ServicioProxy s=new ServicioProxy();
		String jsonPaciente=s.buscarPacienteId(idPersona);
		request.setAttribute("paciente", jsonPaciente);
		
		getServletContext().getRequestDispatcher("/paciente.jsp").forward(request,
				response);
	}

}
