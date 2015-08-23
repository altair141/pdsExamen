package capaNegocio.fichamedica;

import org.orm.PersistentException;

import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;

public class Actividad {
	public ActividadVO obtenerActividadPorId(int idActividad) {
		ActividadVO actividadVO = new ActividadVO();
		Diagnostico diagnostico = new Diagnostico();
		try {
			orm.Actividad acti = orm.ActividadDAO
					.getActividadByORMID(idActividad);
			actividadVO.setId(idActividad);
			actividadVO.setNombreActividad(acti.getTipoActividad());
			DiagnosticoVO diag = diagnostico.obtenerDiagnosticoPorId(acti
					.getIdDiagnostico().getIdDiagnostico());
			actividadVO.setDiagnostico(diag);
			return actividadVO;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
