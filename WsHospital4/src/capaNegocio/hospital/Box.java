package capaNegocio.hospital;

import org.orm.PersistentException;

import capaNegocio.hospitalDomain.BoxVO;


public class Box {
	public BoxVO buscarBoxPorId(int id){
		BoxVO boxVo=new BoxVO();
		
		try {
			orm.Box box=orm.BoxDAO.getBoxByORMID(id);
			boxVo.setBox(id);
			boxVo.setNroHabitacion(box.getNroHabitacion());
			
			return boxVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(NullPointerException e){
			return null;
		}
		
		
	}
}
