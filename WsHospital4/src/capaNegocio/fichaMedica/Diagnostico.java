package capaNegocio.fichaMedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;



import capaNegocio.fichaMedicaDomain.DiagnosticoVO;


public class Diagnostico {
	/**
	 * metodo que permite obtener el diagnostico a travez del id como parametro
	 * @param idDiagnostico int con el identificador del diagnostico
	 * @return objeto con los datos del diagnostico
	 */
	public DiagnosticoVO obtenerDiagnosticoPorId(int idDiagnostico) {
		DiagnosticoVO diagnostico = new DiagnosticoVO();
		try {
			orm.Diagnostico diag = orm.DiagnosticoDAO.getDiagnosticoByORMID(idDiagnostico);
			diagnostico.setId(idDiagnostico);
			diagnostico.setNombre(diag.getNombre());			
			return diagnostico;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}
	
	/**
	 * metodo que entrega la lista de diagnosticos
	 * @return lista con objetos que contienen los datos de los diagnosticos
	 */
	public List<DiagnosticoVO> listaDiagnosticos(){
		List<DiagnosticoVO> lista=new ArrayList<DiagnosticoVO>();
		try {
			orm.Diagnostico[]  listadiagnosticos=orm.DiagnosticoDAO.listDiagnosticoByQuery(null, null);
			for(orm.Diagnostico diagnostico:listadiagnosticos ){
				DiagnosticoVO diagVo=new DiagnosticoVO();
				diagVo.setId(diagnostico.getIdDiagnostico());
				diagVo.setNombre(diagnostico.getNombre());				
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
