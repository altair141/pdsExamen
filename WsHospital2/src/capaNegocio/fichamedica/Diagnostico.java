package capaNegocio.fichamedica;

import org.orm.PersistentException;

import capaNegocio.fichamedicaDomain.DiagnosticoVO;

public class Diagnostico {

	public DiagnosticoVO obtenerDiagnosticoPorId(int idDiagnostico) {
		DiagnosticoVO diagnostico = new DiagnosticoVO();
		try {
			orm.Diagnostico diag = orm.DiagnosticoDAO.getDiagnosticoByORMID(idDiagnostico);
			diagnostico.setId(idDiagnostico);
			diagnostico.setNombre(diag.getNombre());
			diagnostico.setUuid(diag.getUuid());
			return diagnostico;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}
	
	
	
}
