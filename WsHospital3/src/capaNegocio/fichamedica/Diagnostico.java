package capaNegocio.fichamedica;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<DiagnosticoVO> listaDiagnosticos(){
		List<DiagnosticoVO> lista=new ArrayList<DiagnosticoVO>();
		try {
			orm.Diagnostico[]  listadiagnosticos=orm.DiagnosticoDAO.listDiagnosticoByQuery(null, null);
			for(orm.Diagnostico diagnostico:listadiagnosticos ){
				DiagnosticoVO diagVo=new DiagnosticoVO();
				diagVo.setId(diagnostico.getIdDiagnostico());
				diagVo.setNombre(diagnostico.getNombre());
				diagVo.setUuid(diagnostico.getUuid());
				lista.add(diagVo);
			}
			
			return lista;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	

}
