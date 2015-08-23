package capaNegocio.fichamedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.CertificadoVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;
import capaNegocio.fichamedicaDomain.RceVO;

public class Rce {
	public String registrarRce(RceVO rceVo) {

		try {
			PersistentTransaction ts = orm.Taller2PersistentManager.instance()
					.getSession().beginTransaction();
			orm.Rce rce = orm.RceDAO.createRce();
			rce.setAlergia(rceVo.getAlergia());
			rce.setAnamnesis(rceVo.getAnamnesis());
			// caso cierre
			// rce.setCierreCaso();
			rce.setExamenFisico(rceVo.getExamenFisico());
			rce.setHipotesisDiagnostico(rceVo.getHipotesisDiagnostico());
			// actividad
			orm.Actividad actividad = orm.ActividadDAO
					.getActividadByORMID(rceVo.getIdActividad().getId());
			rce.setIdActividad(actividad);
			// diagnostico
			orm.Diagnostico diagnostico = orm.DiagnosticoDAO
					.getDiagnosticoByORMID(rceVo.getIdDiagnostico().getId());
			rce.setIdDiagnostico(diagnostico);
			// hce
			orm.Hce hce = orm.HceDAO.getHceByORMID(rceVo.getIdHce().getId());
			rce.setIdHce(hce);
			rce.setIdHoraMedica(rceVo.getIdHoraMedica());
			orm.Procedimiento procedimiento = orm.ProcedimientoDAO
					.getProcedimientoByORMID(rceVo.getIdProcedimiento().getId());
			rce.setIdProcedimiento(procedimiento);
			rce.setIndicacionCierreCaso(rceVo.getIndicacionCierreCaso());
			rce.setIndicacionMedica(rceVo.getIndicacionCierreCaso());
			rce.setPacienteCronico(rceVo.getPacienteCronico());
			rce.setPacienteGes(rceVo.getPacienteGes());
			rce.setPatologiaGes(rceVo.getPatologiaGes());
			rce.setReceta(rceVo.getReceta());
			rce.setTipoEncuentro(rceVo.getTipoEncuentro());
			rce.setUuid(rceVo.getUuid());

			for (int i = 0; i < rceVo.getListaCertificados().size(); i++) {
				orm.Certificado certificado = orm.CertificadoDAO
						.getCertificadoByORMID(rceVo.getListaCertificados()
								.get(i).getId());
				rce.certificado.add(certificado);
			}
			if (orm.RceDAO.save(rce)) {
				ts.commit();
				return rce.getIdRce() + "";
			}

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "no registrado";
	}
	
	public List<RceVO> obtenerRce(List<RceVO>listaRceVO){
		List<RceVO>listaRce=new ArrayList<RceVO>();
		
		for(RceVO rce: listaRceVO){
			//rce contiene solo las id de los rce
			try {
				orm.Rce rcebd=orm.RceDAO.getRceByORMID(rce.getIdRce());
				RceVO rceVo=new RceVO();
				rceVo.setIdRce(rcebd.getIdRce());
				rceVo.setTipoEncuentro(rcebd.getTipoEncuentro());
				Diagnostico diagnostico=new Diagnostico();
				DiagnosticoVO diag=diagnostico.obtenerDiagnosticoPorId(rcebd.getIdDiagnostico().getIdDiagnostico());
				
				rceVo.setAlergia(rcebd.getAlergia());
				rceVo.setAnamnesis(rcebd.getAnamnesis());
				rceVo.setExamenFisico(rcebd.getExamenFisico());
				rceVo.setHipotesisDiagnostico(rcebd.getHipotesisDiagnostico());
				rceVo.setIdDiagnostico(diag);
				Actividad actividad=new Actividad();
				ActividadVO actividadVO=actividad.obtenerActividadPorId(rcebd.getIdActividad().getId());
				rceVo.setIdActividad(actividadVO);
				Hce hce=new Hce();
				HceVO hceVo=hce.ontenerHcePorId(rcebd.getIdHce().getIdHce());
				rceVo.setIdHce(hceVo);
				rceVo.setIdHoraMedica(rcebd.getIdHoraMedica());
				Procedimiento proce=new Procedimiento();
				ProcedimientoVO procedimientoVo=proce.obtenerProcedimientoPorId(rcebd.getIdProcedimiento().getId());
				rceVo.setIdProcedimiento(procedimientoVo);
				rceVo.setIndicacionCierreCaso(rcebd.getIndicacionCierreCaso());
				rceVo.setIndicacionMedica(rcebd.getIndicacionMedica());
				rceVo.setPacienteCronico(rcebd.getPacienteCronico());
				rceVo.setPacienteGes(rcebd.getPacienteGes());
				rceVo.setPatologiaGes(rcebd.getPatologiaGes());
				rceVo.setReceta(rcebd.getReceta());
				rceVo.setUuid(rcebd.getUuid());
				List<CertificadoVO> listaCertificados=new ArrayList<CertificadoVO>();
				for(orm.Certificado certificado: rcebd.certificado.toArray()){
					CertificadoVO certificadoVo=new CertificadoVO();
					certificadoVo.setId(certificado.getId());
					listaCertificados.add(certificadoVo);
				}
					
				
				rceVo.setListaCertificados(listaCertificados);
				
				listaRce.add(rceVo);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listaRce;
	}
	
	
}
