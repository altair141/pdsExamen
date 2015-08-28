package capaNegocio.fichamedica;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<ActividadVO> listaActividades(){
		List<ActividadVO> lista=new ArrayList<ActividadVO>();
		Diagnostico diag=new Diagnostico();
		try {
			orm.Actividad[]  listaActividades=orm.ActividadDAO.listActividadByQuery(null, null);
			for(orm.Actividad actividad:listaActividades ){
				ActividadVO actiVo=new ActividadVO();
				actiVo.setId(actividad.getId());
				actiVo.setNombreActividad(actividad.getTipoActividad());
				DiagnosticoVO d=diag.obtenerDiagnosticoPorId(actividad.getIdDiagnostico().getIdDiagnostico());
				actiVo.setDiagnostico(d);								
				lista.add(actiVo);
			}
			
			return lista;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

}
