package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilitario.Transformar;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.fichaMedicaDomain.RecetaVO;
import capaNegocio.personasDomain.PacienteVO;
import capaServicio.ServicioProxy;

/**
 * Servlet implementation class AbrirRce
 */
@WebServlet(name = "AbrirRce", urlPatterns = { "/AbrirRce" })
public class AbrirRce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbrirRce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/listaPacientes.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicioProxy s=new ServicioProxy();
		try{
			//--------------------datos paciente-------------------------
			String idRce=request.getParameter("idRce");
			System.out.println("abrir "+idRce );
			String idPaciente=request.getParameter("idPaciente");
			System.out.println("abrir "+idPaciente);
			request.setAttribute("idPaciente", idPaciente);
			String paciente=s.buscarPacienteId(idPaciente);
			System.out.println("abrir "+ paciente);
			PacienteVO pacienteVo=Transformar.pacienteVO(paciente);
			request.setAttribute("paciente", pacienteVo.getNroFicha()+"-"+pacienteVo.getNombre()+" "+pacienteVo.getApellidos());
			//--------------------datos paciente-------------------------
			
			String rce=s.obtenerRcePorId(idRce);
			System.out.println(rce);
			RceVO rceVo=Transformar.jsonToRce(rce);
			System.out.println(rceVo.getIdRce());
			
			request.setAttribute("id", rceVo.getIdRce());
			request.setAttribute("tipoEncuentro", rceVo.getTipoEncuentro());
			
			request.setAttribute("idHce", rceVo.getIdHce().getId());
			request.setAttribute("idHoraMedica", rceVo.getIdHoraMedica().getId());
			request.setAttribute("anamnesis", rceVo.getAnamnesis());
			request.setAttribute("alergia", rceVo.getAlergia());
			request.setAttribute("examenFisico", rceVo.getExamenFisico());
			request.setAttribute("indicacionMedica", rceVo.getIndicacionMedica());
			request.setAttribute("indicacionCierreCaso", rceVo.getIndicacionCierreCaso());
			request.setAttribute("hipotesisDiagnostico", rceVo.getHipotesisDiagnostico());
			request.setAttribute("pacienteGes", rceVo.getPacienteGes());
			request.setAttribute("patologiaGes", rceVo.getPatologiaGes());
			request.setAttribute("pacienteCronico", rceVo.getPacienteCronico());
			
			
			
			request.setAttribute("tipoCierre", rceVo.getTipoCierre());
			request.setAttribute("destino", rceVo.getDestino());
			String fechaAntencion=Transformar.datetoString(rceVo.getFechaAtencion());
			request.setAttribute("fechaAtencion",fechaAntencion );
			request.setAttribute("horaInicioAtencion", rceVo.getHoraInicioAtencion());
			String fechaCierre=Transformar.datetoString(rceVo.getFechaCierreClinico());
			request.setAttribute("fechaCierreClinico", fechaCierre);
			request.setAttribute("horaCierreClinico", rceVo.getHoraCierreClienico());
			request.setAttribute("tiempoControl", rceVo.getTiempoControl());
			
			String certificado=Transformar.certificadoCual(rceVo.getListaCertificados().get(0).getId()+"");
			request.setAttribute(certificado, rceVo.getListaCertificados().get(0).getId());
			String certificado2=Transformar.certificadoCual(rceVo.getListaCertificados().get(1).getId()+"");
			request.setAttribute(certificado2, rceVo.getListaCertificados().get(1).getId());
			String certificado3=Transformar.certificadoCual(rceVo.getListaCertificados().get(2).getId()+"");
			request.setAttribute(certificado3, rceVo.getListaCertificados().get(2).getId());
			String certificado4=Transformar.certificadoCual(rceVo.getListaCertificados().get(3).getId()+"");
			request.setAttribute(certificado4, rceVo.getListaCertificados().get(3).getId());
			String certificado5=Transformar.certificadoCual(rceVo.getListaCertificados().get(4).getId()+"");
			request.setAttribute(certificado5, rceVo.getListaCertificados().get(4).getId());
			String certificado6=Transformar.certificadoCual(rceVo.getListaCertificados().get(5).getId()+"");
			request.setAttribute(certificado6, rceVo.getListaCertificados().get(5).getId());
			String certificado7=Transformar.certificadoCual( rceVo.getListaCertificados().get(6).getId()+"");
			request.setAttribute(certificado7, rceVo.getListaCertificados().get(6).getId());
			String certificado8=Transformar.certificadoCual( rceVo.getListaCertificados().get(7).getId()+"");
			request.setAttribute(certificado8, rceVo.getListaCertificados().get(7).getId());
			String certificado9=Transformar.certificadoCual(rceVo.getListaCertificados().get(8).getId()+"");
			request.setAttribute(certificado9, rceVo.getListaCertificados().get(8).getId());
			String certificado10=Transformar.certificadoCual(rceVo.getListaCertificados().get(9).getId()+"");
			request.setAttribute(certificado10, rceVo.getListaCertificados().get(9).getId());
			String certificado11=Transformar.certificadoCual(rceVo.getListaCertificados().get(10).getId()+"");
			request.setAttribute(certificado11, rceVo.getListaCertificados().get(10).getId());
			String certificado12=Transformar.certificadoCual(rceVo.getListaCertificados().get(11).getId()+"");
			request.setAttribute(certificado12, rceVo.getListaCertificados().get(11).getId());
			String certificado13=Transformar.certificadoCual(rceVo.getListaCertificados().get(12).getId()+"");
			request.setAttribute(certificado13, rceVo.getListaCertificados().get(12).getId());
			String certificado14=Transformar.certificadoCual(rceVo.getListaCertificados().get(13).getId()+"");
			request.setAttribute(certificado14, rceVo.getListaCertificados().get(13).getId());
			String certificado15=Transformar.certificadoCual(rceVo.getListaCertificados().get(14).getId()+"");
			request.setAttribute(certificado15, rceVo.getListaCertificados().get(14).getId());
			
			
			String listaActividad=Transformar.actividadLista(rceVo.getListaActividad());
			request.setAttribute("listaActividad", listaActividad);
			String listaDiagnosticos=Transformar.diagnosticoLista(rceVo.getListaDiagnostico());
			request.setAttribute("listaDiagnostico", listaDiagnosticos);
			String listaProcedimiento=Transformar.procedimientosLista(rceVo.getListaProcedimiento());
			request.setAttribute("listaProcedimiento",listaProcedimiento);
			/*
			 * 
			 * 
			 * request.setAttribute("idProcedimiento", rceVo.getIdProcedimiento().getId());
			 * 
			 */
			
			String recetas=s.buscarRecetasPoridRce(idRce);
			List<RecetaVO>lista=Transformar.jsonToListaReceta(recetas);
			String listaReceta="";
			for(int i=0;i<lista.size();i++){
				listaReceta+=lista.get(i).getContenido();
			}
			
			request.setAttribute("receta", listaReceta);
			
			getServletContext().getRequestDispatcher("/abrirRce.jsp").forward(request,
					response);
		}catch(NullPointerException e){
			
			
		}catch(IllegalStateException e){
			
		
		}
	}

}
