package capaNegocio.fichaMedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import capaNegocio.fichaMedica.Diagnostico;
import capaNegocio.fichaMedicaDomain.ActividadVO;
import capaNegocio.fichaMedicaDomain.DiagnosticoVO;


/**
 * 
 * @author altair141
 *
 */
public class Actividad {
	
	/**
	 * metodo que devuelve la lista de actividades
	 * @return lista de objetos que devuelve una lista de actividades con sus datos correspondientes
	 */
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
	/**
	 * metodo que permite obtener una actividad a partir del id proporcionado como parametro
	 * @param idActividad int correspondiente al identificador de la base de datos de la actividad
	 * @return objeto con los datos correspondientes a la actividad
	 */
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
