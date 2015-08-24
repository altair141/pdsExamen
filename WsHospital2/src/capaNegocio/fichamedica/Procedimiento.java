package capaNegocio.fichamedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import capaNegocio.fichamedicaDomain.ActividadVO;
import capaNegocio.fichamedicaDomain.DiagnosticoVO;
import capaNegocio.fichamedicaDomain.ProcedimientoVO;

public class Procedimiento {

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
}
