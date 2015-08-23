package capaNegocio.hospital;

import java.util.Date;

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

	}
