package capaNegocio.hospital;

import org.orm.PersistentException;

import capaNegocio.hospitalDomain.BoxVO;
import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.personas.Medico;
import capaNegocio.personasDomain.MedicoVO;

public class HoraMedica {
	public HoraMedicaVO buscarHoraMedicaPorId(int id){
		HoraMedicaVO horaVo=new HoraMedicaVO();
		Medico medico=new Medico();
		Box box=new Box();
		try {
			orm.HoraMedica hora=orm.HoraMedicaDAO.getHoraMedicaByORMID(id);
			horaVo.setAsp(hora.getAsp());
			BoxVO boxVo=box.buscarBoxPorId(hora.getIdBox().getIdHabitacion());
			horaVo.setBox(boxVo);
			horaVo.setFecha(hora.getFecha());
			horaVo.setId(id);
			horaVo.setUuid(hora.getUuid());
			MedicoVO medicoVO=medico.buscarMedicoPorId(hora.getIdMedico().getIdMedico());
			horaVo.setMedico(medicoVO);			
			return horaVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(NullPointerException e){
			return null;
		}
		
	}
	
	public boolean esAps(String aps) {
		try {
			if (aps.equalsIgnoreCase("true") || aps.equalsIgnoreCase("false")) {
				return Boolean.parseBoolean(aps);
			}
		} catch (NullPointerException e) {
			return false;
		}
		return false;
	}

	public boolean horaEsTipo(int idHoraMedica){
		
		try {
			orm.HoraMedica hora=orm.HoraMedicaDAO.getHoraMedicaByORMID(idHoraMedica);
			if(hora.getAsp().equals("true")||(hora.getAsp().equals("false"))){
				return Boolean.parseBoolean(hora.getAsp());
			}
			return false;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch(NullPointerException e){
			return false;
		}
		
	}

}
