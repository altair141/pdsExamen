package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilitario.Transformar;
import capaNegocio.fichaMedicaDomain.ActividadVO;
import capaNegocio.fichaMedicaDomain.CertificadoVO;
import capaNegocio.fichaMedicaDomain.DiagnosticoVO;
import capaNegocio.fichaMedicaDomain.HceVO;
import capaNegocio.fichaMedicaDomain.ProcedimientoVO;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.fichaMedicaDomain.RecetaVO;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.openmrs.Concepto;
import capaNegocio.openmrs.EncuentroVO;
import capaNegocio.openmrs.Observacion;
import capaNegocio.openmrs.PersonaOpen;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PacienteVO;
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
		ServicioProxy s = new ServicioProxy();
		try {

			RceVO r = new RceVO();
			// actividad

			// String idActividad = request.getParameter("actividad");
			String actividadArray[] = request.getParameterValues("actividad");
			for (int i = 0; i < actividadArray.length; i++) {
				ActividadVO actividad = new ActividadVO();
				String activi[] = actividadArray[i].split("\\.");
				System.out.println(activi[1]);
				actividad.setId(Transformar.stringToInt(activi[1]));
				r.agregarActividad(actividad);
			}

			String pricedimientoArray[] = request
					.getParameterValues("procedimiento");
			for (int i = 0; i < pricedimientoArray.length; i++) {
				ProcedimientoVO procedimiento = new ProcedimientoVO();
				String procedi[] = pricedimientoArray[i].split("\\.");
				procedimiento.setId(Transformar.stringToInt(procedi[1]));
				r.agregarProcedimiento(procedimiento);
				;
			}
			// procedimiento

			String diagnosticoArray[] = request
					.getParameterValues("diagnostico");
			for (int i = 0; i < diagnosticoArray.length; i++) {
				DiagnosticoVO diagnostico = new DiagnosticoVO();
				diagnostico.setId(Transformar.stringToInt(diagnosticoArray[i]));
				r.agregarDiagnostico(diagnostico);
			}

			// diagnostico

			// ----------------------------------------------certificados------------------------------------------

			CertificadoVO certi = new CertificadoVO();
			String ce1 = request.getParameter("certialcoholemiaradio");
			certi.setId(Transformar.stringToInt(ce1));
			r.agregarCertificado(certi);
			CertificadoVO certi2 = new CertificadoVO();
			String ce2 = request.getParameter("certivfamiliarradio");
			certi2.setId(Transformar.stringToInt(ce2));
			r.agregarCertificado(certi2);
			CertificadoVO certi3 = new CertificadoVO();
			String ce3 = request.getParameter("certidrogasradio");
			certi3.setId(Transformar.stringToInt(ce3));
			r.agregarCertificado(certi3);
			CertificadoVO certi4 = new CertificadoVO();
			String ce4 = request.getParameter("certilecionesradio");
			certi4.setId(Transformar.stringToInt(ce4));
			r.agregarCertificado(certi4);
			CertificadoVO certi5 = new CertificadoVO();
			String ce5 = request.getParameter("certisuicidioradio");
			certi5.setId(Transformar.stringToInt(ce5));
			r.agregarCertificado(certi5);
			CertificadoVO certi6 = new CertificadoVO();
			String ce6 = request.getParameter("certianimalradio");
			certi6.setId(Transformar.stringToInt(ce6));
			r.agregarCertificado(certi6);
			CertificadoVO certi7 = new CertificadoVO();
			String ce7 = request.getParameter("certiotrosradio");
			certi7.setId(Transformar.stringToInt(ce7));
			r.agregarCertificado(certi7);
			CertificadoVO certi8 = new CertificadoVO();
			String ce8 = request.getParameter("certivgeneroradio");
			certi8.setId(Transformar.stringToInt(ce8));
			r.agregarCertificado(certi8);
			CertificadoVO certi9 = new CertificadoVO();
			String ce9 = request.getParameter("certisaludcompatibleradio");
			certi9.setId(Transformar.stringToInt(ce9));
			r.agregarCertificado(certi9);
			CertificadoVO certi10 = new CertificadoVO();
			String ce10 = request.getParameter("certiatenciondiagnosticoradio");
			certi10.setId(Transformar.stringToInt(ce10));
			r.agregarCertificado(certi10);
			CertificadoVO certi11 = new CertificadoVO();
			String ce11 = request.getParameter("certiatencionprofecionalradio");
			certi11.setId(Transformar.stringToInt(ce11));
			r.agregarCertificado(certi11);
			CertificadoVO certi12 = new CertificadoVO();
			String ce12 = request.getParameter("certiderivacioninternaradio");
			certi12.setId(Transformar.stringToInt(ce12));
			r.agregarCertificado(certi12);
			CertificadoVO certi13 = new CertificadoVO();
			String ce13 = request.getParameter("certicitacionkntradio");
			certi13.setId(Transformar.stringToInt(ce13));
			r.agregarCertificado(certi13);
			CertificadoVO certi14 = new CertificadoVO();
			String ce14 = request.getParameter("certiordencuracionradio");
			certi14.setId(Transformar.stringToInt(ce14));
			r.agregarCertificado(certi14);
			CertificadoVO certi15 = new CertificadoVO();
			String ce15 = request.getParameter("certiordencitacionradio");
			certi15.setId(Transformar.stringToInt(ce15));
			r.agregarCertificado(certi15);

			// -------------------------------------------fin
			// certificados------------------------------------------
			// tipo encuentro
			String tipoEncuentro = request.getParameter("cierreAdmin");
			r.setTipoEncuentro(tipoEncuentro);

			// hce
			HceVO hce = new HceVO();
			String idhce = request.getParameter("idhce");
			hce.setId(Transformar.stringToInt(idhce));
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

			String idHoraMedica = request.getParameter("idHoraMedica");

			String jsonHora = s.obtenerHoraMedica(idHoraMedica);
			HoraMedicaVO hVo = Transformar.jsonToHoraMedica(jsonHora);
			r.setIdHoraMedica(hVo);
			String tiempoControl = request.getParameter("tiempoControl");
			r.setTiempoControl(tiempoControl);
			// falta el paso de crear el encuentro en openmrs

			// actividad
			// procedimiento
			// diagnostico
			// certificado
			String tipoCierre = request.getParameter("tipoCierre");
			r.setTipoCierre(tipoCierre);
			String destino = request.getParameter("destino");
			r.setDestino(destino);
			String fechaAtencion = request.getParameter("fechaAtencion");
			Date fechaAten = Transformar.stringToDate(fechaAtencion);
			r.setFechaAtencion(fechaAten);
			String horaInicioAtencion = request
					.getParameter("horaInicioAtencion");
			r.setHoraInicioAtencion(horaInicioAtencion);
			String fechaCierreClinico = request
					.getParameter("fechaCierreClinico");
			Date fechaCierre = Transformar.stringToDate(fechaCierreClinico);
			r.setFechaCierreClinico(fechaCierre);
			String horaCierreCLinico = request
					.getParameter("horaCierreCLinico");
			r.setHoraCierreClienico(horaCierreCLinico);

			String receta = request.getParameter("receta");
			r.setReceta(receta);

			String jsonRce = Transformar.rce1(r);

			String identificadorRce = s.registrarRce(jsonRce);
			System.out.println(identificadorRce);

			MedicoVO medico = hVo.getMedico();
			EncuentroVO en = new EncuentroVO();
			String uuidEncuentro = "";
			String boleanHora = s.horaesAps(idHoraMedica);
			uuidEncuentro = Transformar.tipoEncuentro(boleanHora);

			String idPaciente = request.getParameter("idPaciente");
			System.out.println(idPaciente);
			String paciente = s.buscarPacienteId(idPaciente);
			System.out.println(paciente);
			PacienteVO p = Transformar.pacienteVO(paciente);

			String uuidPaciente = s.registrarPacienteOpen(idPaciente);
			String uuidMedico = s.registrarMedicoOpenmrs(medico.getId() + "");
			en.setPaciente(uuidPaciente);
			en.setMedico(uuidMedico);
			en.setTipoEncuentro(uuidEncuentro);
			en.setFechaTime(Transformar.dateTimetoString2(fechaAten) + " "
					+ horaInicioAtencion + ":00");
			String encuentroJson = Transformar.encuentro(en);
			uuidEncuentro=s.registrarEncuentro(encuentroJson);

			
			
			
			/*
			Concepto con1 = new Concepto();
			con1.setName(examenfisico);
			con1.setTipoConcepto(3);
			con1.asignarconceptClass(con1.getTipoConcepto());
			System.out.println(con1.getConceptClass());
			
			String jsonConcepto1 = Transformar.concepto(con1);
			
			String uuidCon1 = s.registrarConcepto(jsonConcepto1);
			if (uuidCon1 != "{\"results\":[]}") {
				Observacion obs1 = new Observacion();
				obs1.setConcepto(uuidCon1);
				obs1.setEncuentro(uuidEncuentro);
				obs1.setFecha(fechaAtencion);
				obs1.setPersona(uuidPaciente);
				String jsonObservacion1 = Transformar.observacion(obs1);
				s.registrarObservacion(jsonObservacion1);
			}

			*/
			fechaAtencion="2015-09-01";
			Concepto con1 = new Concepto();
			con1.setName(examenfisico);
			con1.setTipoConcepto(3);
			con1.asignarconceptClass(con1.getTipoConcepto());
			String jsonConcepto1 = Transformar.concepto(con1);
			String uuidCon1 = s.registrarConcepto(jsonConcepto1);
			if (uuidCon1 != "{\"results\":[]}") {
				Observacion obs1 = new Observacion();
				obs1.setConcepto(uuidCon1);
				obs1.setEncuentro(uuidEncuentro);
				obs1.setFecha(fechaAtencion);
				obs1.setPersona(uuidPaciente);
				String jsonObservacion1 = Transformar.observacion(obs1);
				s.registrarObservacion(jsonObservacion1);
			}
			Concepto con2 = new Concepto();
			con2.setName(alergia);
			con2.setTipoConcepto(2);
			con2.asignarconceptClass(con2.getTipoConcepto());
			String jsonConcepto2 = Transformar.concepto(con2);
			String uuidCon2 = s.registrarConcepto(jsonConcepto2);
			if (uuidCon2 != "{\"results\":[]}") {
				Observacion obs2 = new Observacion();
				obs2.setConcepto(uuidCon2);
				obs2.setEncuentro(uuidEncuentro);
				obs2.setFecha(fechaAtencion);
				obs2.setPersona(uuidPaciente);
				String jsonObservacion2 = Transformar.observacion(obs2);
				s.registrarObservacion(jsonObservacion2);
			}
			Concepto con3 = new Concepto();
			con3.setName(anamnesis);
			con3.setTipoConcepto(1);
			con3.asignarconceptClass(con3.getTipoConcepto());
			String jsonConcepto3 = Transformar.concepto(con3);
			String uuidCon3 = s.registrarConcepto(jsonConcepto3);
			if (uuidCon3 != "{\"results\":[]}") {
				Observacion obs3 = new Observacion();
				obs3.setConcepto(uuidCon3);
				obs3.setEncuentro(uuidEncuentro);
				obs3.setFecha(fechaAtencion);
				obs3.setPersona(uuidPaciente);
				String jsonObservacion3 = Transformar.observacion(obs3);
				s.registrarObservacion(jsonObservacion3);
			}
			Concepto con4 = new Concepto();
			con4.setName(indicacionmedica);
			con4.setTipoConcepto(4);
			con4.asignarconceptClass(con4.getTipoConcepto());
			String jsonConcepto4 = Transformar.concepto(con4);
			String uuidCon4 = s.registrarConcepto(jsonConcepto4);
			if (uuidCon4 != "{\"results\":[]}") {
				Observacion obs4 = new Observacion();
				obs4.setConcepto(uuidCon4);
				obs4.setEncuentro(uuidEncuentro);
				obs4.setFecha(fechaAtencion);
				obs4.setPersona(uuidPaciente);
				String jsonObservacion4 = Transformar.observacion(obs4);
				s.registrarObservacion(jsonObservacion4);
			}
			Concepto con5 = new Concepto();
			con5.setName(indicacioncierremedico);
			con5.setTipoConcepto(5);
			con5.asignarconceptClass(con5.getTipoConcepto());
			String jsonConcepto5 = Transformar.concepto(con5);
			String uuidCon5 = s.registrarConcepto(jsonConcepto5);
			if (uuidCon5 != "{\"results\":[]}") {
				Observacion obs5 = new Observacion();
				obs5.setConcepto(uuidCon5);
				obs5.setEncuentro(uuidEncuentro);
				obs5.setFecha(fechaAtencion);
				obs5.setPersona(uuidPaciente);
				String jsonObservacion5 = Transformar.observacion(obs5);
				s.registrarObservacion(jsonObservacion5);
			}
			Concepto con6 = new Concepto();
			con6.setName(hipotesisdiagnostico);
			con6.setTipoConcepto(6);
			con6.asignarconceptClass(con6.getTipoConcepto());
			String jsonConcepto6 = Transformar.concepto(con6);
			String uuidCon6 = s.registrarConcepto(jsonConcepto6);
			if (uuidCon6 != "{\"results\":[]}") {
				Observacion obs6 = new Observacion();
				obs6.setConcepto(uuidCon6);
				obs6.setEncuentro(uuidEncuentro);
				obs6.setFecha(fechaAtencion);
				obs6.setPersona(uuidPaciente);
				String jsonObservacion6 = Transformar.observacion(obs6);
				System.out.println(s.registrarObservacion(jsonObservacion6));
			}

			
			if(pacienteges.equals("si")){
				
				Observacion obs8 = new Observacion();
				obs8.setConcepto("76d0726d-d245-4b5f-a391-83a77afc4da2");
				obs8.setEncuentro(uuidEncuentro);
				obs8.setFecha(fechaAtencion);
				obs8.setPersona(uuidPaciente);
				String jsonObservacion8 = Transformar.observacion(obs8);
				System.out.println(s.registrarObservacion(jsonObservacion8));
				
			}else{
				
				Observacion obs8 = new Observacion();
				obs8.setConcepto("05f89026-cfe2-46cb-acdd-3942fb2f2d4e");
				obs8.setEncuentro(uuidEncuentro);
				obs8.setFecha(fechaAtencion);
				obs8.setPersona(uuidPaciente);
				String jsonObservacion8 = Transformar.observacion(obs8);
				System.out.println(s.registrarObservacion(jsonObservacion8));
			}
		
				
			
			
			if(patologiages.equals("si")){
				
				Observacion obs9 = new Observacion();
				obs9.setConcepto("76d0726d-d245-4b5f-a391-83a77afc4da2");
				obs9.setEncuentro(uuidEncuentro);
				obs9.setFecha(fechaAtencion);
				obs9.setPersona(uuidPaciente);
				String jsonObservacion9 = Transformar.observacion(obs9);
				System.out.println(s.registrarObservacion(jsonObservacion9));
			}else{
				Observacion obs9 = new Observacion();
				obs9.setConcepto("f4d6f5bf-d7f7-49e3-92e7-f01612d245c9");
				obs9.setEncuentro(uuidEncuentro);
				obs9.setFecha(fechaAtencion);
				obs9.setPersona(uuidPaciente);
				String jsonObservacion9 = Transformar.observacion(obs9);
				System.out.println(s.registrarObservacion(jsonObservacion9));
			}
		
				
			
			if (pacientecronico.equals("si")) {
				Observacion obs10 = new Observacion();
				obs10.setConcepto("ffb86f13-a6a6-428a-ac0d-838144009def");
				obs10.setEncuentro(uuidEncuentro);
				obs10.setFecha(fechaAtencion);
				obs10.setPersona(uuidPaciente);
				String jsonObservacion10 = Transformar.observacion(obs10);
				s.registrarObservacion(jsonObservacion10);
			}else{
				Observacion obs10 = new Observacion();
				obs10.setConcepto("f4d6f5bf-d7f7-49e3-92e7-f01612d245c9");
				obs10.setEncuentro(uuidEncuentro);
				obs10.setFecha(fechaAtencion);
				obs10.setPersona(uuidPaciente);
				String jsonObservacion10 = Transformar.observacion(obs10);
				s.registrarObservacion(jsonObservacion10);
			}
			Concepto con11 = new Concepto();
			con11.setName(receta);
			con11.setTipoConcepto(3);
			con11.asignarconceptClass(con11.getTipoConcepto());
			String jsonConcepto11 = Transformar.concepto(con11);
			String uuidCon11 = s.registrarConcepto(jsonConcepto11);
			if (uuidCon11 != "{\"results\":[]}") {
				Observacion obs11 = new Observacion();
				obs11.setConcepto(uuidCon11);
				obs11.setEncuentro(uuidEncuentro);
				obs11.setFecha(fechaAtencion);
				obs11.setPersona(uuidPaciente);
				String jsonObservacion11 = Transformar.observacion(obs11);
				s.registrarObservacion(jsonObservacion11);
			}

			/*Concepto con15 = new Concepto();
			con15.setName(tipoCierre);
			con15.setTipoConcepto(15);
			con15.asignarconceptClass(con15.getTipoConcepto());
			String jsonConcepto15 = Transformar.concepto(con15);
			String uuidCon15 = s.registrarConcepto(jsonConcepto15);
			if (uuidCon15 != "{\"results\":[]}") {
				Observacion obs15 = new Observacion();
				obs15.setConcepto(uuidCon15);
				obs15.setEncuentro(uuidEncuentro);
				obs15.setFecha(fechaAtencion);
				obs15.setPersona(uuidPaciente);
				String jsonObservacion15 = Transformar.observacion(obs15);
				s.registrarObservacion(jsonObservacion15);
			}*/
			
			if (destino.equals("domicilio")) {
				Observacion obs16 = new Observacion();
				obs16.setConcepto("5f9ff6f5-949f-4e6e-ad8c-be106bf66cf9");
				obs16.setEncuentro(uuidEncuentro);
				obs16.setFecha(fechaAtencion);
				obs16.setPersona(uuidPaciente);
				String jsonObservacion16 = Transformar.observacion(obs16);
				s.registrarObservacion(jsonObservacion16);

			}else{
				Observacion obs16 = new Observacion();
				obs16.setConcepto("5f9ff6f5-949f-4e6e-ad8c-be106bf66cf9");
				obs16.setEncuentro(uuidEncuentro);
				obs16.setFecha(fechaAtencion);
				obs16.setPersona(uuidPaciente);
				String jsonObservacion16 = Transformar.observacion(obs16);
				s.registrarObservacion(jsonObservacion16);
			}
		
			if (tiempoControl.equals("No corresponde")) {
				Observacion obs21 = new Observacion();
				obs21.setConcepto("232e28e7-6933-4b01-a1be-5899b6e9f70d");
				obs21.setEncuentro(uuidEncuentro);
				obs21.setFecha(fechaAtencion);
				obs21.setPersona(uuidPaciente);
				String jsonObservacion21 = Transformar.observacion(obs21);
				s.registrarObservacion(jsonObservacion21);
			}
			
			if (tipoEncuentro.equals("CATEGORIZADO")) {
				Observacion obs22 = new Observacion();
				obs22.setConcepto("f80346bd-714b-4748-bb50-93a9e3b1bf8d");
				obs22.setEncuentro(uuidEncuentro);
				obs22.setFecha(fechaAtencion);
				obs22.setPersona(uuidPaciente);
				String jsonObservacion22 = Transformar.observacion(obs22);
				s.registrarObservacion(jsonObservacion22);
			}

			Concepto con7 = new Concepto();
			/*
			for (DiagnosticoVO diag : r.getListaDiagnostico()) {
				if (diag.getId() == 1) {
					Observacion obs7 = new Observacion();
					obs7.setConcepto("951fbf4b-5ea3-4132-8762-61a6e56b88c4");
					obs7.setEncuentro(uuidEncuentro);
					obs7.setFecha(fechaAtencion);
					obs7.setPersona(uuidPaciente);
					String jsonObservacion7 = Transformar.observacion(obs7);
					s.registrarObservacion(jsonObservacion7);

				} else if (diag.getId() == 2) {
					Observacion obs7 = new Observacion();
					obs7.setConcepto(uuidCon22);
					obs7.setEncuentro(uuidEncuentro);
					obs7.setFecha(fechaAtencion);
					obs7.setPersona(uuidPaciente);
					String jsonObservacion7 = Transformar.observacion(obs7);
					s.registrarObservacion(jsonObservacion7);

				} else if (diag.getId() == 3) {
					Observacion obs7 = new Observacion();
					obs7.setConcepto(uuidCon22);
					obs7.setEncuentro(uuidEncuentro);
					obs7.setFecha(fechaAtencion);
					obs7.setPersona(uuidPaciente);
					String jsonObservacion7 = Transformar.observacion(obs7);
					s.registrarObservacion(jsonObservacion7);

				} else if (diag.getId() == 4) {
					Observacion obs7 = new Observacion();
					obs7.setConcepto(uuidCon22);
					obs7.setEncuentro(uuidEncuentro);
					obs7.setFecha(fechaAtencion);
					obs7.setPersona(uuidPaciente);
					String jsonObservacion7 = Transformar.observacion(obs7);
					s.registrarObservacion(jsonObservacion7);

				} else if (diag.getId() == 5) {
					Observacion obs7 = new Observacion();
					obs7.setConcepto(uuidCon22);
					obs7.setEncuentro(uuidEncuentro);
					obs7.setFecha(fechaAtencion);
					obs7.setPersona(uuidPaciente);
					String jsonObservacion7 = Transformar.observacion(obs7);
					s.registrarObservacion(jsonObservacion7);

				} else if (diag.getId() == 6) {
					Observacion obs7 = new Observacion();
					obs7.setConcepto(uuidCon22);
					obs7.setEncuentro(uuidEncuentro);
					obs7.setFecha(fechaAtencion);
					obs7.setPersona(uuidPaciente);
					String jsonObservacion7 = Transformar.observacion(obs7);
					s.registrarObservacion(jsonObservacion7);

				} else if (diag.getId() == 7) {
					Observacion obs7 = new Observacion();
					obs7.setConcepto(uuidCon22);
					obs7.setEncuentro(uuidEncuentro);
					obs7.setFecha(fechaAtencion);
					obs7.setPersona(uuidPaciente);
					String jsonObservacion7 = Transformar.observacion(obs7);
					s.registrarObservacion(jsonObservacion7);

				}
				
			}
			
			*/

			// ------------------------------------------------
			Concepto con12 = new Concepto();
			if (ce1.equals("1")) {

					Observacion obs12 = new Observacion();
					obs12.setConcepto("29c4005a-f35a-43b4-bd7d-8efdcbdfa5c3");
					obs12.setEncuentro(uuidEncuentro);
					obs12.setFecha(fechaAtencion);
					obs12.setPersona(uuidPaciente);
					String jsonObservacion12 = Transformar.observacion(obs12);
					System.out.println(s.registrarObservacion(jsonObservacion12));
				
			} else if (ce1.equals("2")) {

				
				
					Observacion obs12 = new Observacion();
					obs12.setConcepto("66880686-10e1-4606-99e6-f23ea2b5c658");
					obs12.setEncuentro(uuidEncuentro);
					obs12.setFecha(fechaAtencion);
					obs12.setPersona(uuidPaciente);
					String jsonObservacion12 = Transformar.observacion(obs12);
					System.out.println(s.registrarObservacion(jsonObservacion12));
				
			}
			
			Concepto con28 = new Concepto();
			if (ce2.equals("3")) {

					Observacion obs = new Observacion();
					obs.setConcepto("679d0ffb-d847-4af6-9ed4-73ac0c44d9be");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
			} else if (ce2.equals("4")) {

				
					Observacion obs = new Observacion();
					obs.setConcepto("719e4fd4-92b4-4ef7-8f34-2d7d9322bcc7");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}

			Concepto con29 = new Concepto();
			if (ce3.equals("5")) {

				Observacion obs = new Observacion();
					obs.setConcepto("5a1f2176-9a75-4d15-b36f-ef283e4e3f62");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce3.equals("6")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("88465fa5-d38b-4499-8db5-2141868d78a7");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}

			Concepto con30 = new Concepto();
			if (ce4.equals("7")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("6db01a87-4cf0-413c-b34f-9a803f723fc1");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce4.equals("8")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("1ae5869f-a0ec-4a3a-9352-a6916053cea4");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con31 = new Concepto();
			if (ce5.equals("9")) {

					Observacion obs = new Observacion();
					obs.setConcepto("f4fb17e5-4dae-4b1a-b03e-7426c1b2c52e");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce5.equals("10")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("6be14eeb-19e8-4bd2-8376-01c50bad4d5f");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con32 = new Concepto();
			if (ce6.equals("11")) {

					Observacion obs = new Observacion();
					obs.setConcepto("8f804196-8f59-4e81-8c07-42a663d8572d");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce6.equals("12")) {

				
				
					Observacion obs = new Observacion();
					obs.setConcepto("2b7f47e7-a11f-400f-86dc-47b87c9acc1f");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con33 = new Concepto();
			if (ce7.equals("13")) {

				
					Observacion obs = new Observacion();
					obs.setConcepto("c193b328-d8d1-46d3-982d-43932b2fb507");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce7.equals("14")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("eceb9549-fc94-45cf-aac4-6a9946c9bbc1");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con34 = new Concepto();
			if (ce8.equals("15")) {

		
					Observacion obs = new Observacion();
					obs.setConcepto("c6e49435-ec26-4b7c-883a-99051779d26e");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce8.equals("16")) {

				
					Observacion obs = new Observacion();
					obs.setConcepto("59c4ee8b-86e3-48e8-9c67-1a73c0f794c4");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					s.registrarObservacion(jsonObservacion);
				
			}
			Concepto con35 = new Concepto();
			if (ce9.equals("17")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("83b3245d-bb7b-4a91-afbc-6349fa71155d");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce9.equals("18")) {

					Observacion obs = new Observacion();
					obs.setConcepto("9efe02bc-53ef-4ae1-b8bb-5ce02b75b19e");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con36 = new Concepto();
			if (ce10.equals("19")) {

					Observacion obs = new Observacion();
					obs.setConcepto("aadc6edd-732b-4efa-9953-efa206b75360");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce10.equals("20")) {

				
					Observacion obs = new Observacion();
					obs.setConcepto("12c5cd70-d393-4548-8614-70c197ab48fe");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con37 = new Concepto();
			if (ce11.equals("21")) {

					Observacion obs = new Observacion();
					obs.setConcepto("8417ca05-34d4-4cde-a588-4ab91091b8bf");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce11.equals("22")) {

				
					Observacion obs = new Observacion();
					obs.setConcepto("77f0cb4b-707a-466d-9235-1d113f57664d");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con38 = new Concepto();
			if (ce12.equals("23")) {

				Observacion obs = new Observacion();
					obs.setConcepto("85918227-a0b5-49d0-b1c9-ca6eb12384a2");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce12.equals("24")) {

				
					Observacion obs = new Observacion();
					obs.setConcepto("04872d29-d1e8-453a-ba1e-8853544e9f50");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con39 = new Concepto();
			if (ce13.equals("25")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("1d5b5f61-0c61-4aa4-b064-d3e4e1b82691");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce13.equals("26")) {

		
					Observacion obs = new Observacion();
					obs.setConcepto("d2716e27-fe91-4088-b187-7d5772be3ac9");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con40 = new Concepto();
			if (ce14.equals("27")) {

			
					Observacion obs = new Observacion();
					obs.setConcepto("097a1c0e-1784-4258-abc1-f8a15163c732");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce14.equals("28")) {

				
					Observacion obs = new Observacion();
					obs.setConcepto("e7836d77-ecb9-4845-adb7-159a8ac030ca");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			Concepto con41 = new Concepto();
			if (ce15.equals("29")) {

					Observacion obs = new Observacion();
					obs.setConcepto("097a1c0e-1784-4258-abc1-f8a15163c732");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			} else if (ce15.equals("30")) {

					Observacion obs = new Observacion();
					obs.setConcepto("ebcbe5da-0750-44f2-8e95-1a6094292b6c");
					obs.setEncuentro(uuidEncuentro);
					obs.setFecha(fechaAtencion);
					obs.setPersona(uuidPaciente);
					String jsonObservacion = Transformar.observacion(obs);
					System.out.println(s.registrarObservacion(jsonObservacion));
				
			}
			
		
			

			if (identificadorRce.equals("no registrado")
					|| identificadorRce.equals("error no registrado")) {
				request.setAttribute("resultado",
						"Falla detectada al crear RCE, Cierre de caso médico no registrado");
				getServletContext().getRequestDispatcher("/inicio.jsp")
						.forward(request, response);
			}
			request.setAttribute("resultado", "RCE creado exitosamente");
			getServletContext().getRequestDispatcher("/inicio.jsp").forward(
					request, response);

		} catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("resultado", "ERROR al crear RCE");
			getServletContext().getRequestDispatcher("/inicio.jsp").forward(
					request, response);
		}
	}

}
