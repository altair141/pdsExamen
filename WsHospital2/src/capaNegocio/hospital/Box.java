package capaNegocio.hospital;

import org.orm.PersistentException;

import capaNegocio.hospitalDomain.BoxVO;
import capaNegocio.hospitalDomain.EstablecimientoVO;

public class Box {
	public BoxVO buscarBoxPorId(int id){
		BoxVO boxVo=new BoxVO();
		Establecimiento establecimiento=new Establecimiento();
		try {
			orm.Box box=orm.BoxDAO.getBoxByORMID(id);
			boxVo.setBox(id);
			boxVo.setNroHabitacion(box.getNroHabitacion());
			EstablecimientoVO hospital=establecimiento.buscarHospitalPorId(box.getIdEstablecimiento().getId());
			boxVo.setEstablecimiento(hospital);
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
