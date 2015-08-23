package capaNegocio.fichamedica;

import org.orm.PersistentException;

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
}
