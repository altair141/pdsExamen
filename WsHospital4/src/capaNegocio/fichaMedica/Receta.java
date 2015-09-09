package capaNegocio.fichaMedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capaNegocio.fichaMedicaDomain.RecetaVO;

public class Receta {
	/**
	 * metodo que permite registrar una receta medica
	 * 
	 * @param recetaVo
	 *            objeto con los datos de la receta
	 * @return string con el id de la receta
	 */

	public String registrarReceta(RecetaVO recetaVo)throws PersistentException{
		PersistentTransaction ts = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
		try {			
			orm.Receta receta = orm.RecetaDAO.createReceta();
			receta.setContenido(recetaVo.getContenido());
			orm.Rce rce = orm.RceDAO.loadRceByORMID(recetaVo.getRce().getIdRce());
			receta.setIdRce(rce);
			orm.RecetaDAO.save(receta);
			ts.commit();
			orm.RecetaDAO.refresh(receta);
			//rce.receta.add(receta);
			orm.RceDAO.refresh(rce);
			return  "registrado";
		
		} catch (Exception e) {
			ts.rollback();
		}
		return null;
	}
	
	public List<RecetaVO>buscarRecetasPoridRce(int id){
		List<RecetaVO> recetaList=new ArrayList<RecetaVO>();
		
		try {
			orm.Receta listaReceta[]=orm.RecetaDAO.listRecetaByQuery(null, null);
			
			for(orm.Receta receta : listaReceta){
				RecetaVO recetaVo=new RecetaVO();
				if(receta.getIdRce().getIdRce()==id){
					recetaVo.setContenido(receta.getContenido());
					recetaVo.setId(receta.getId());
					recetaList.add(recetaVo);
				}
			}
			return recetaList;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(NullPointerException e){
			return null;
		}
		
	}
	public RecetaVO obtenerReceta(int id){
		try {
			orm.Receta receta=orm.RecetaDAO.getRecetaByORMID(id);
			RecetaVO recetaVo=new RecetaVO();
			recetaVo.setContenido(receta.getContenido());
			recetaVo.setId(receta.getId());
			return recetaVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(NullPointerException e){
			return null;
		}
	}
}
