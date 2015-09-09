package capaNegocio.fichaMedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capaNegocio.fichaMedicaDomain.ActividadVO;
import capaNegocio.fichaMedicaDomain.CertificadoVO;
import capaNegocio.fichaMedicaDomain.DiagnosticoVO;
import capaNegocio.fichaMedicaDomain.HceVO;
import capaNegocio.fichaMedicaDomain.ProcedimientoVO;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.fichaMedicaDomain.RecetaVO;
import capaNegocio.hospital.HoraMedica;
import capaNegocio.hospitalDomain.HoraMedicaVO;

public class Rce {

	/**
	 * metodo que permite registrar un rce en la bd
	 * 
	 * @param rceVo
	 *            objeto que contiene los datos del rce
	 * @return String id del rce almacenado
	 * @throws PersistentException
	 */

	public String registrarRce(RceVO rceVo) throws PersistentException {

		PersistentTransaction ts = orm.Taller2PersistentManager.instance()
				.getSession().beginTransaction();
		try {
			orm.Rce rce = orm.RceDAO.createRce();
			rce.setAlergia(rceVo.getAlergia());
			rce.setAnamnesis(rceVo.getAnamnesis());
			// caso cierre
			// rce.setCierreCaso();
			rce.setExamenFisico(rceVo.getExamenFisico());
			rce.setHipotesisDiagnostico(rceVo.getHipotesisDiagnostico());
			// actividad

			// diagnostico

			// hce
			orm.Hce hce = orm.HceDAO.getHceByORMID(rceVo.getIdHce().getId());
			rce.setIdHce(hce);
			orm.HoraMedica horaM = orm.HoraMedicaDAO.getHoraMedicaByORMID(rceVo
					.getIdHoraMedica().getId());
			rce.setIdHoraMedica(horaM);

			rce.setIndicacionCierreCaso(rceVo.getIndicacionCierreCaso());
			rce.setIndicacionMedica(rceVo.getIndicacionCierreCaso());
			rce.setPacienteCronico(rceVo.getPacienteCronico());
			rce.setPacienteGes(rceVo.getPacienteGes());
			rce.setPatologiaGes(rceVo.getPatologiaGes());

			rce.setTipoEncuentro(rceVo.getTipoEncuentro());

			rce.setTipoCierre(rceVo.getTipoCierre());
			rce.setDestino(rceVo.getDestino());
			rce.setFechaAtencion(rceVo.getFechaAtencion());
			rce.setHoraInicioAtencion(rceVo.getHoraInicioAtencion());
			rce.setFechaCierreClinico(rceVo.getFechaCierreClinico());
			rce.setHoraCierreClinico(rceVo.getHoraCierreClienico());
			rce.setTiempoControl(rceVo.getTiempoControl());

			for (int i = 0; i < rceVo.getListaActividad().size(); i++) {
				orm.Actividad actividad = orm.ActividadDAO
						.getActividadByORMID(rceVo.getListaActividad().get(i)
								.getId());
				rce.actividad.add(actividad);
			}
			for (int i = 0; i < rceVo.getListaDiagnostico().size(); i++) {
				orm.Diagnostico diagnostico = orm.DiagnosticoDAO
						.getDiagnosticoByORMID(rceVo.getListaDiagnostico()
								.get(i).getId());
				rce.diagnosticoidDiagnostico.add(diagnostico);
			}
			for (int i = 0; i < rceVo.getListaProcedimiento().size(); i++) {
				orm.Procedimiento procedimiento = orm.ProcedimientoDAO
						.getProcedimientoByORMID(rceVo.getListaProcedimiento()
								.get(i).getId());
				rce.procedimiento.add(procedimiento);
			}

			for (int i = 0; i < rceVo.getListaCertificados().size(); i++) {
				orm.Certificado certificado = orm.CertificadoDAO
						.getCertificadoByORMID(rceVo.getListaCertificados()
								.get(i).getId());
				rce.certificado.add(certificado);
			}
			
			orm.RceDAO.save(rce);
			
			if(rceVo.getReceta()!=null||rceVo.getReceta().length()>0){
			orm.Receta receta= orm.RecetaDAO.createReceta();
			receta.setContenido(rceVo.getReceta());	
			System.out.println(rceVo.getReceta());
			rce.receta.add(receta); 
			orm.RecetaDAO.save(receta);
			orm.RecetaDAO.refresh(receta);
			}
			
		
			ts.commit();
			
			orm.RceDAO.refresh(rce);
			
			/*orm.RceDAO.save(rce);
			ts.commit();
			orm.RceDAO.refresh(rce);
			
			orm.Receta receta = orm.RecetaDAO.createReceta();
			receta.setContenido(rceVo.getReceta());			
			orm.RecetaDAO.save(receta);
			rce.receta.add(receta);
			ts.commit();
			orm.RecetaDAO.refresh(receta);*/
			/*orm.RceDAO.save(rce);
			ts.commit();
			orm.RceDAO.refresh(rce);
			
			orm.Receta receta = orm.RecetaDAO.createReceta();
			receta.setContenido(rceVo.getReceta());
			rce.receta.add(receta);
			orm.RecetaDAO.save(receta);
			ts.commit();
			orm.RecetaDAO.refresh(receta);
			*/
			
			
			
			
			return  "registrado";//rce.getIdRce() +

		} catch (Exception e) {
			// TODO Auto-generated catch block
			ts.rollback();
		}

		return "no registrado";
	}

	/**
	 * metodo para obtener lista de rce
	 * 
	 * @param listaRceVO
	 *            objeto con el id del rce
	 * @return List con la lista de rce y sus datos correspondientes
	 */
	public List<RceVO> obtenerRce(List<RceVO> listaRceVO) {
		List<RceVO> listaRce = new ArrayList<RceVO>();

		for (RceVO rce : listaRceVO) {
			// rce contiene solo las id de los rce
			try {
				orm.Rce rcebd = orm.RceDAO.getRceByORMID(rce.getIdRce());
				RceVO rceVo = new RceVO();
				rceVo.setIdRce(rcebd.getIdRce());
				rceVo.setTipoEncuentro(rcebd.getTipoEncuentro());

				rceVo.setAlergia(rcebd.getAlergia());
				rceVo.setAnamnesis(rcebd.getAnamnesis());
				rceVo.setExamenFisico(rcebd.getExamenFisico());
				rceVo.setHipotesisDiagnostico(rcebd.getHipotesisDiagnostico());

				Hce hce = new Hce();
				HceVO hceVo = hce.obtenerHcePorId(rcebd.getIdHce().getIdHce());
				rceVo.setIdHce(hceVo);
				HoraMedicaVO horaMedica = new HoraMedicaVO(rcebd
						.getIdHoraMedica().getIdHora());
				rceVo.setIdHoraMedica(horaMedica);

				rceVo.setIndicacionCierreCaso(rcebd.getIndicacionCierreCaso());
				rceVo.setIndicacionMedica(rcebd.getIndicacionMedica());
				rceVo.setPacienteCronico(rcebd.getPacienteCronico());
				rceVo.setPacienteGes(rcebd.getPacienteGes());
				rceVo.setPatologiaGes(rcebd.getPatologiaGes());

				rceVo.setTipoCierre(rcebd.getTipoCierre());
				rceVo.setDestino(rcebd.getDestino());
				rceVo.setFechaAtencion(rcebd.getFechaAtencion());
				rceVo.setHoraInicioAtencion(rcebd.getHoraInicioAtencion());
				rceVo.setFechaCierreClinico(rcebd.getFechaCierreClinico());
				rceVo.setHoraCierreClienico(rcebd.getHoraCierreClinico());
				rceVo.setTiempoControl(rcebd.getTiempoControl());

				List<CertificadoVO> listaCertificados = new ArrayList<CertificadoVO>();
				for (orm.Certificado certificado : rcebd.certificado.toArray()) {
					CertificadoVO certificadoVo = new CertificadoVO();
					certificadoVo.setId(certificado.getId());
					listaCertificados.add(certificadoVo);
				}
				rceVo.setListaCertificados(listaCertificados);

				List<DiagnosticoVO> listaDiagnosticos = new ArrayList<DiagnosticoVO>();
				for (orm.Diagnostico diagnostico : rcebd.diagnosticoidDiagnostico
						.toArray()) {
					DiagnosticoVO diagnosticoVO = new DiagnosticoVO();
					diagnosticoVO.setId(diagnostico.getIdDiagnostico());
					listaDiagnosticos.add(diagnosticoVO);
				}
				rceVo.setListaDiagnostico(listaDiagnosticos);

				List<ActividadVO> listaActividades = new ArrayList<ActividadVO>();
				for (orm.Actividad actividad : rcebd.actividad.toArray()) {
					ActividadVO actividadVO = new ActividadVO();
					actividadVO.setId(actividad.getId());
					listaActividades.add(actividadVO);
				}
				rceVo.setListaActividad(listaActividades);

				List<ProcedimientoVO> listaProcedimientos = new ArrayList<ProcedimientoVO>();
				for (orm.Procedimiento procedimiento : rcebd.procedimiento
						.toArray()) {
					ProcedimientoVO procedimientoVo = new ProcedimientoVO();
					procedimientoVo.setId(procedimiento.getId());
					listaProcedimientos.add(procedimientoVo);
				}
				rceVo.setListaProcedimiento(listaProcedimientos);

				listaRce.add(rceVo);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}

		return listaRce;
	}

	/**
	 * metodo para obtener la informacion del rce
	 * 
	 * @param id
	 *            int con el id del rce
	 * @return RCEVO objeto que contiene los datos del rce
	 */

	public RceVO obtenerRcePorId(int id) {
		try {

			orm.Rce rcebd = orm.RceDAO.getRceByORMID(id);

			RceVO rceVo = new RceVO();
			rceVo.setIdRce(rcebd.getIdRce());
			rceVo.setTipoEncuentro(rcebd.getTipoEncuentro());

			rceVo.setAlergia(rcebd.getAlergia());
			rceVo.setAnamnesis(rcebd.getAnamnesis());
			rceVo.setExamenFisico(rcebd.getExamenFisico());
			rceVo.setHipotesisDiagnostico(rcebd.getHipotesisDiagnostico());

			Hce hce = new Hce();
			HceVO hceVo = hce.obtenerHcePorId(rcebd.getIdHce().getIdHce());
			rceVo.setIdHce(hceVo);

			HoraMedica hMedica = new HoraMedica();
			HoraMedicaVO horaMedica = hMedica.buscarHoraMedicaPorId(rcebd
					.getIdHoraMedica().getIdHora());

			rceVo.setIdHoraMedica(horaMedica);

			rceVo.setIndicacionCierreCaso(rcebd.getIndicacionCierreCaso());
			rceVo.setIndicacionMedica(rcebd.getIndicacionMedica());
			rceVo.setPacienteCronico(rcebd.getPacienteCronico());
			rceVo.setPacienteGes(rcebd.getPacienteGes());
			rceVo.setPatologiaGes(rcebd.getPatologiaGes());

			rceVo.setTipoCierre(rcebd.getTipoCierre());
			rceVo.setDestino(rcebd.getDestino());
			rceVo.setFechaAtencion(rcebd.getFechaAtencion());
			rceVo.setHoraInicioAtencion(rcebd.getHoraInicioAtencion());
			rceVo.setFechaCierreClinico(rcebd.getFechaCierreClinico());
			rceVo.setHoraCierreClienico(rcebd.getHoraCierreClinico());
			rceVo.setTiempoControl(rcebd.getTiempoControl());

			List<CertificadoVO> listaCertificados = new ArrayList<CertificadoVO>();
			for (orm.Certificado certificado : rcebd.certificado.toArray()) {
				CertificadoVO certificadoVo = new CertificadoVO();
				certificadoVo.setId(certificado.getId());
				listaCertificados.add(certificadoVo);
			}
			rceVo.setListaCertificados(listaCertificados);

			List<DiagnosticoVO> listaDiagnosticos = new ArrayList<DiagnosticoVO>();
			for (orm.Diagnostico diagnostico : rcebd.diagnosticoidDiagnostico
					.toArray()) {
				DiagnosticoVO diagnosticoVO = new DiagnosticoVO();
				diagnosticoVO.setId(diagnostico.getIdDiagnostico());
				listaDiagnosticos.add(diagnosticoVO);
			}
			rceVo.setListaDiagnostico(listaDiagnosticos);

			List<ActividadVO> listaActividades = new ArrayList<ActividadVO>();
			for (orm.Actividad actividad : rcebd.actividad.toArray()) {
				ActividadVO actividadVO = new ActividadVO();
				actividadVO.setId(actividad.getId());
				listaActividades.add(actividadVO);
			}
			rceVo.setListaActividad(listaActividades);

			List<ProcedimientoVO> listaProcedimientos = new ArrayList<ProcedimientoVO>();
			for (orm.Procedimiento procedimiento : rcebd.procedimiento
					.toArray()) {
				ProcedimientoVO procedimientoVo = new ProcedimientoVO();
				procedimientoVo.setId(procedimiento.getId());
				listaProcedimientos.add(procedimientoVo);
			}
			rceVo.setListaProcedimiento(listaProcedimientos);

			return rceVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	public RceVO obtenerRceCompletoPorId(int id){
		
		try{
			orm.Rce rcebd = orm.RceDAO.getRceByORMID(id);
			RceVO rceVo = new RceVO();
			rceVo.setIdRce(rcebd.getIdRce());
			rceVo.setTipoEncuentro(rcebd.getTipoEncuentro());

			rceVo.setAlergia(rcebd.getAlergia());
			rceVo.setAnamnesis(rcebd.getAnamnesis());
			rceVo.setExamenFisico(rcebd.getExamenFisico());
			rceVo.setHipotesisDiagnostico(rcebd.getHipotesisDiagnostico());

			Hce hce = new Hce();
			HceVO hceVo = hce.obtenerHcePorId(rcebd.getIdHce().getIdHce());
			rceVo.setIdHce(hceVo);

			HoraMedica hMedica = new HoraMedica();
			HoraMedicaVO horaMedica = hMedica.buscarHoraMedicaPorId(rcebd
					.getIdHoraMedica().getIdHora());

			rceVo.setIdHoraMedica(horaMedica);

			rceVo.setIndicacionCierreCaso(rcebd.getIndicacionCierreCaso());
			rceVo.setIndicacionMedica(rcebd.getIndicacionMedica());
			rceVo.setPacienteCronico(rcebd.getPacienteCronico());
			rceVo.setPacienteGes(rcebd.getPacienteGes());
			rceVo.setPatologiaGes(rcebd.getPatologiaGes());

			rceVo.setTipoCierre(rcebd.getTipoCierre());
			rceVo.setDestino(rcebd.getDestino());
			rceVo.setFechaAtencion(rcebd.getFechaAtencion());
			rceVo.setHoraInicioAtencion(rcebd.getHoraInicioAtencion());
			rceVo.setFechaCierreClinico(rcebd.getFechaCierreClinico());
			rceVo.setHoraCierreClienico(rcebd.getHoraCierreClinico());
			rceVo.setTiempoControl(rcebd.getTiempoControl());

			List<CertificadoVO> listaCertificados = new ArrayList<CertificadoVO>();
			for (orm.Certificado certificado : rcebd.certificado.toArray()) {
				CertificadoVO certificadoVo = new CertificadoVO();
				certificadoVo.setId(certificado.getId());
				certificadoVo.setNombre(certificado.getTipoCertificado());
				listaCertificados.add(certificadoVo);
			}
			rceVo.setListaCertificados(listaCertificados);

			List<DiagnosticoVO> listaDiagnosticos = new ArrayList<DiagnosticoVO>();
			for (orm.Diagnostico diagnostico : rcebd.diagnosticoidDiagnostico.toArray()) {
				DiagnosticoVO diagnosticoVO = new DiagnosticoVO();
				diagnosticoVO.setId(diagnostico.getIdDiagnostico());
				diagnosticoVO.setNombre(diagnostico.getNombre());
				listaDiagnosticos.add(diagnosticoVO);
			}
			rceVo.setListaDiagnostico(listaDiagnosticos);

			List<ActividadVO> listaActividades = new ArrayList<ActividadVO>();
			for (orm.Actividad actividad : rcebd.actividad.toArray()) {
				ActividadVO actividadVO = new ActividadVO();
				actividadVO.setId(actividad.getId());
				actividadVO.setNombreActividad(actividad.getTipoActividad());
				listaActividades.add(actividadVO);
			}
			rceVo.setListaActividad(listaActividades);

			List<ProcedimientoVO> listaProcedimientos = new ArrayList<ProcedimientoVO>();
			for (orm.Procedimiento procedimiento : rcebd.procedimiento
					.toArray()) {
				ProcedimientoVO procedimientoVo = new ProcedimientoVO();
				procedimientoVo.setId(procedimiento.getId());
				procedimientoVo.setNombre(procedimiento.getTipoProcedimiento());
				listaProcedimientos.add(procedimientoVo);
			}
			rceVo.setListaProcedimiento(listaProcedimientos);
			Receta r=new Receta();
			List<RecetaVO> listaReceta=new ArrayList<RecetaVO>();
			listaReceta=r.buscarRecetasPoridRce(rceVo.getIdRce());
			rceVo.setListaReceta(listaReceta);
			
			return rceVo;
			
		}catch(NullPointerException | PersistentException e){
			return null;
		}
	}

}
