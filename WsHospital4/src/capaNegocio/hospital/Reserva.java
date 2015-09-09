package capaNegocio.hospital;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;


import capaNegocio.hospitalDomain.HoraMedicaVO;
import capaNegocio.personas.Medico;
import capaNegocio.personasDomain.MedicoVO;

public class Reserva {
	public List<HoraMedicaVO> buscarHoraMedicaPorIdPaciente(int id){
		Medico medi=new Medico();
		
		List<HoraMedicaVO> listahoraMedicaVo=new ArrayList<HoraMedicaVO>();
		
		try {
			orm.Reserva listaReserva[]=orm.ReservaDAO.listReservaByQuery(null, null);			
			for(orm.Reserva reserva:listaReserva){
				if(reserva.getIdPaciente().getIdPaciente()==id){
					orm.HoraMedica hMedica=orm.HoraMedicaDAO.getHoraMedicaByORMID(reserva.getIdHoraMedica().getIdHora());
					HoraMedicaVO hMeVo=new HoraMedicaVO();
					hMeVo.setId(hMedica.getIdHora());
					hMeVo.setAsp(hMedica.getAsp());
					hMeVo.setFecha(hMedica.getFecha());			
					MedicoVO medico=medi.buscarMedicoPorId(hMedica.getIdMedico().getIdMedico());
					hMeVo.setMedico(medico);
					
					listahoraMedicaVo.add(hMeVo);
				}
			}
			return listahoraMedicaVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
}
