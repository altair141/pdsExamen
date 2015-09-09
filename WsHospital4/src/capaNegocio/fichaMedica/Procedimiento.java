package capaNegocio.fichaMedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import capaNegocio.fichaMedica.Diagnostico;
import capaNegocio.fichaMedicaDomain.DiagnosticoVO;
import capaNegocio.fichaMedicaDomain.ProcedimientoVO;


public class Procedimiento {
	/**
	 * metodo que entrega la lista de procedimientos
	 * @return lista de procedimientos 
	 */
	public List<ProcedimientoVO> listaProcedimientos(){
		List<ProcedimientoVO> lista=new ArrayList<ProcedimientoVO>();
		Diagnostico diag=new Diagnostico();
		try {
			orm.Procedimiento[]  listaProcedimientos=orm.ProcedimientoDAO.listProcedimientoByQuery(null, null);
			for(orm.Procedimiento procedimiento:listaProcedimientos ){
				ProcedimientoVO actiVo=new ProcedimientoVO();
				actiVo.setId(procedimiento.getId());
				actiVo.setNombre(procedimiento.getTipoProcedimiento());
				DiagnosticoVO d=diag.obtenerDiagnosticoPorId(procedimiento.getIdDiagnostico().getIdDiagnostico());
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
	 * metodo que permite obtener procedimientos mediante la busqueda por id
	 * @param id int con el identificador del procedimiento de la bd
	 * @return objeto con los datos del procedimiento
	 */
	public ProcedimientoVO obtenerProcedimientoPorId(int id) {
		ProcedimientoVO procedimientoVO=new ProcedimientoVO (); 
		
		try {
			orm.Procedimiento procedimiento=orm.ProcedimientoDAO.getProcedimientoByORMID(id);
			procedimientoVO.setId(id);
			procedimientoVO.setNombre(procedimiento.getTipoProcedimiento());
			Diagnostico diagnostico=new Diagnostico();
			DiagnosticoVO diag=diagnostico.obtenerDiagnosticoPorId(procedimiento.getIdDiagnostico().getIdDiagnostico());
			procedimientoVO.setDiagnostico(diag);
			
			return procedimientoVO;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
