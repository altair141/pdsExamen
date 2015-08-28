package capaNegocio.hospital;

import org.orm.PersistentException;

import capaNegocio.hospitalDomain.EstablecimientoVO;

public class Establecimiento {

	public EstablecimientoVO buscarHospitalPorId(int id){
		EstablecimientoVO establecimientoVO=new EstablecimientoVO ();
		try {
			orm.Establecimiento establecimiento=orm.EstablecimientoDAO.getEstablecimientoByORMID(id);
			establecimientoVO.setNombre(establecimiento.getNombre());
			establecimientoVO.setId(id);			
			return establecimientoVO ;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(NullPointerException e){
			return null;
		}
		
		
	}

}
