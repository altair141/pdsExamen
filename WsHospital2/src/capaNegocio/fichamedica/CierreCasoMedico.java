package capaNegocio.fichamedica;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capaNegocio.fichamedicaDomain.CierreCasoMedicoVO;


public class CierreCasoMedico {

	public String registrarCierreCasoMedico(CierreCasoMedicoVO cierreVo){
		
		try {
			PersistentTransaction ts = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
			orm.CierreCaso cierre=orm.CierreCasoDAO.createCierreCaso();
			cierre.setDestino(cierreVo.getDestino());
			cierre.setFechaAtencion(cierreVo.getFechaAtencion());
			cierre.setFechaCierreClinico(cierreVo.getFechaCierreClinico());
			cierre.setHoraCierreClinico(cierreVo.getHoraCierreClienico());
			cierre.setHoraInicioAtencion(cierreVo.getHoraInicioAtencion());
			cierre.setTiempoControl(cierreVo.getTiempoControl());
			cierre.setTipoCierre(cierreVo.getTipoCierre());
			orm.Rce rce=orm.RceDAO.getRceByORMID(cierre.getIdRce().getIdRce());
			cierre.setIdRce(rce);
			
			if(orm.CierreCasoDAO.save(cierre)){
				ts.commit();
				return cierre.getId()+"";
				
			}				
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"";
	}
	}
