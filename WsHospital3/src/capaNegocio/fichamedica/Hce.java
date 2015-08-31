package capaNegocio.fichamedica;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import capaNegocio.fichamedicaDomain.HceVO;
import capaNegocio.fichamedicaDomain.RceVO;
import capaNegocio.personas.Paciente;
import capaNegocio.personasDomain.PacienteVO;

public class Hce {
	public String registrarHce(PacienteVO pacienteVO) {
		String mensaje = "no encontrado";
		try {
			PersistentTransaction ts = orm.Taller2PersistentManager.instance()
					.getSession().beginTransaction();
			orm.Paciente paciente = orm.PacienteDAO
					.getPacienteByORMID(pacienteVO.getId());
			orm.Hce hce = orm.HceDAO.createHce();

			System.out.println("pacientes datos id" + paciente.getIdPaciente());
			hce.setIdPaciente(paciente);

			if (orm.HceDAO.save(hce)) {
				ts.commit();
				return hce.getIdHce() + "";
			}
			return mensaje;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mensaje;
		}
	}

	/**
	 * recibe como parametro un objeto de tipo paciente y retorna el id del hce
	 * @param paciente 
	 * @return int id del hce del paciente
	 */
	public int obtenerIdHce(PacienteVO paciente) {
		int idhce = 0;
		try {
			orm.Hce[] listaHce = orm.HceDAO.listHceByQuery(null, null);
			for (orm.Hce hce : listaHce) {
				if (hce.getIdPaciente().getIdPaciente() == paciente.getId()) {
					idhce = hce.getIdHce();
					break;
				}

			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idhce;
	}

	public List<RceVO> obtenerHce(HceVO hce) {
		List<RceVO> listaRceVO = new ArrayList<RceVO>();
		
		try {
			orm.Rce listaRce[] = orm.RceDAO.listRceByQuery(null, null);
			for (orm.Rce rce : listaRce) {
				if (rce.getIdHce().getIdHce() == hce.getId()) {
					System.out.println("id enviado "+hce.getId());
					System.out.println("id encontrado "+rce.getIdHce().getIdHce() );
					Rce rceM=new Rce();
					RceVO rceVO = rceM.obtenerRcePorId(rce.getIdRce());					
					listaRceVO.add(rceVO);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return listaRceVO;
	}

	/**
	 * se recibe el id del hce del paciente y devuelve el hce del paciente
	 * @param id
	 * @return objeto HceVO con los datos correspondientes 
	 */
	public HceVO ontenerHcePorId(int id) {
		HceVO hce = new HceVO();
		Paciente paciente = new Paciente();
		try {
			orm.Hce hcebd = orm.HceDAO.getHceByORMID(id);
			hce.setId(id);
			PacienteVO paci = paciente.obtenerPacientePorIdPaciente(hcebd.getIdPaciente().getIdPaciente());
			hce.setPaciente(paci);
			return hce;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(NullPointerException e ){
			return null;
		}
	}

}
