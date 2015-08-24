package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilitario.Transformar;
import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.CertificadoVO;
import capaNegocio.fichamedicaDomain.CierreCasoMedicoVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;
import capaNegocio.fichamedicaDomain.RceVO;
import capaServicio.ServicioProxy;

/**
 * Servlet implementation class CrearRce
 */
@WebServlet(name = "CrearRce", urlPatterns = { "/CrearRce" })
public class CrearRce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearRce() {
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
		try {
			RceVO r = new RceVO();
			// actividad
			ActividadVO actividad = new ActividadVO();
			String idActividad = request.getParameter("actividad");
			String activi[]=idActividad.split("\\.");
			System.out.println(activi[1]);
			actividad.setId(Transformar.StringToInt(activi[1]));
			r.setIdActividad(actividad);
			// procedimiento
			ProcedimientoVO procedimiento = new ProcedimientoVO();
			String idProcedimiento = request.getParameter("procedimiento");
			String procedi[]=idProcedimiento.split("\\.");
			System.out.println(procedi[1]);
			procedimiento.setId(Transformar.StringToInt(procedi[1]));
			r.setIdProcedimiento(procedimiento);
			// diagnostico
			DiagnosticoVO diagnostico = new DiagnosticoVO();
			String idDiagnostico = request.getParameter("diagnostico");
			diagnostico.setId(Transformar.StringToInt(idDiagnostico));
			r.setIdDiagnostico(diagnostico);

			// ----------------------------------------------certificados------------------------------------------
			CertificadoVO certi = new CertificadoVO();
			String ce1 = request.getParameter("certialcoholemiaradio");
			certi.setId(Transformar.StringToInt(ce1));
			r.agregarCertificado(certi);
			CertificadoVO certi2 = new CertificadoVO();
			String ce2 = request.getParameter("certivfamiliarradio");
			certi2.setId(Transformar.StringToInt(ce2));
			r.agregarCertificado(certi2);
			CertificadoVO certi3 = new CertificadoVO();
			String ce3 = request.getParameter("certidrogasradio");
			certi3.setId(Transformar.StringToInt(ce3));
			r.agregarCertificado(certi3);
			CertificadoVO certi4 = new CertificadoVO();
			String ce4 = request.getParameter("certilecionesradio");
			certi4.setId(Transformar.StringToInt(ce4));
			r.agregarCertificado(certi4);
			CertificadoVO certi5 = new CertificadoVO();
			String ce5 = request.getParameter("certisuicidioradio");
			certi5.setId(Transformar.StringToInt(ce5));
			r.agregarCertificado(certi5);
			CertificadoVO certi6 = new CertificadoVO();
			String ce6 = request.getParameter("certianimalradio");
			certi6.setId(Transformar.StringToInt(ce6));
			r.agregarCertificado(certi6);
			CertificadoVO certi7 = new CertificadoVO();
			String ce7 = request.getParameter("certiotrosradio");
			certi7.setId(Transformar.StringToInt(ce7));
			r.agregarCertificado(certi7);
			CertificadoVO certi8 = new CertificadoVO();
			String ce8 = request.getParameter("certivgeneroradio");
			certi8.setId(Transformar.StringToInt(ce8));
			r.agregarCertificado(certi8);
			CertificadoVO certi9 = new CertificadoVO();
			String ce9 = request.getParameter("certisaludcompatibleradio");
			certi9.setId(Transformar.StringToInt(ce9));
			r.agregarCertificado(certi9);
			CertificadoVO certi10 = new CertificadoVO();
			String ce10 = request.getParameter("certiatenciondiagnosticoradio");
			certi10.setId(Transformar.StringToInt(ce10));
			r.agregarCertificado(certi10);
			CertificadoVO certi11 = new CertificadoVO();
			String ce11 = request.getParameter("certiatencionprofecionalradio");
			certi11.setId(Transformar.StringToInt(ce11));
			r.agregarCertificado(certi11);
			CertificadoVO certi12 = new CertificadoVO();
			String ce12 = request.getParameter("certiderivacioninternaradio");
			certi12.setId(Transformar.StringToInt(ce12));
			r.agregarCertificado(certi12);
			CertificadoVO certi13 = new CertificadoVO();
			String ce13 = request.getParameter("certicitacionkntradio");
			certi13.setId(Transformar.StringToInt(ce13));
			r.agregarCertificado(certi13);
			CertificadoVO certi14 = new CertificadoVO();
			String ce14 = request.getParameter("certiordencuracionradio");
			certi14.setId(Transformar.StringToInt(ce14));
			r.agregarCertificado(certi14);
			CertificadoVO certi15 = new CertificadoVO();
			String ce15 = request.getParameter("certiordencitacionradio");
			certi15.setId(Transformar.StringToInt(ce15));
			r.agregarCertificado(certi15);
	
			// -------------------------------------------fin
			// certificados------------------------------------------
			// tipo encuentro
			String tipoEncuentro = request.getParameter("cierreAdmin");
			r.setTipoEncuentro(tipoEncuentro);
			// hce
			HceVO hce = new HceVO();
			String idhce = request.getParameter("idhce");
			hce.setId(Transformar.StringToInt(idhce));
			r.setIdHce(hce);

			String anamnesis = request.getParameter("anamnesis");
			r.setAnamnesis(anamnesis);
			String alergia = request.getParameter("alergias");
			r.setAlergia(alergia);
			String examenfisico = request.getParameter("examenFisico");
			r.setExamenFisico(examenfisico);
			String indicacionmedica = request.getParameter("indicaMedica");
			r.setIndicacionMedica(indicacionmedica);
			String indicacioncierremedico = request
					.getParameter("indicaCierreCasoClinico");
			r.setIndicacionCierreCaso(indicacioncierremedico);
			String hipotesisdiagnostico = request
					.getParameter("hipoDiagnostico");
			r.setHipotesisDiagnostico(hipotesisdiagnostico);
			String pacienteges = request.getParameter("paciGESradio");
			r.setPacienteGes(pacienteges);
			String patologiages = request.getParameter("patoloGESradio");
			r.setPatologiaGes(patologiages);
			String pacientecronico = request.getParameter("paciCroniradio");
			r.setPacienteCronico(pacientecronico);
			String receta = request.getParameter("receta");
			r.setReceta(receta);
			String idHoraMedica = request.getParameter("idHoraMedica");
			r.setIdHoraMedica(Transformar.StringToInt(idHoraMedica));

			// falta el paso de crear el encuentro en openmrs
			r.setUuid("ddsdkjnmlml423");
			// actividad
			// procedimiento
			// diagnostico
			// certificado

			ServicioProxy s = new ServicioProxy();
			String jsonRce = Transformar.Rce(r);
			String idRce = s.registrarRce(jsonRce);
			System.out.println("id rce" + idRce);
			r.setIdRce(Transformar.StringToInt(idRce));
		System.out.println("probando id rce "+r.getIdRce());
			// ----------------------------fin
			// rce------------------------------------
			try {
				CierreCasoMedicoVO ci = new CierreCasoMedicoVO();

				String tipoCierre = request.getParameter("tipoCierre");
				ci.setTipoCierre(tipoCierre);
				String destino = request.getParameter("destino");
				ci.setDestino(destino);
				String fechaAtencion = request.getParameter("fechaAtencion");
				Date fechaAten = Transformar.stringToDate(fechaAtencion);
				ci.setFechaAtencion(fechaAten);
				String horaInicioAtencion = request
						.getParameter("horaInicioAtencion");
				ci.setHoraInicioAtencion(horaInicioAtencion);
				String fechaCierreClinico = request
						.getParameter("fechaCierreClinico");
				Date fechaCierre = Transformar.stringToDate(fechaCierreClinico);
				ci.setFechaCierreClinico(fechaCierre);
				String horaCierreCLinico = request
						.getParameter("horaCierreCLinico");
				ci.setHoraCierreClienico(horaCierreCLinico);
				String tiempoControl = request.getParameter("tiempoControl");
				ci.setTiempoControl(tiempoControl);
				ci.setRce(r);
				System.out.println("asdads rce ci "+ci.getRce().getIdRce());
				String jsonCasoCierre = Transformar.cierreCaso(ci);
				System.out.println(jsonCasoCierre);
				String resultad = s.registrarCierreCasoMedico(jsonCasoCierre);
				System.out.println("resultado caso cierre"+resultad);
				if(resultad.equals("no registrado")||resultad.equals("error no registrado")){

					request.setAttribute("resultado", "Falla detectada al crear RCE, Cierre de caso médico no registrado");				
					getServletContext().getRequestDispatcher("/inicio.jsp")
							.forward(request, response);
				}
				request.setAttribute("resultado", "RCE creado exitosamente");				
				getServletContext().getRequestDispatcher("/inicio.jsp")
						.forward(request, response);
			} catch (NullPointerException e) {
				e.printStackTrace();
				request.setAttribute("resultado", "ERROR al crear RCE");
				getServletContext().getRequestDispatcher("/inicio.jsp")
						.forward(request, response);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("resultado", "ERROR al crear RCE");
			getServletContext().getRequestDispatcher("/inicio.jsp").forward(
					request, response);
		}
	}

}
