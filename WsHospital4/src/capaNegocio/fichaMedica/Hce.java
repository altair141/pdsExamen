package capaNegocio.fichaMedica;

import java.util.ArrayList;
import java.util.List;
import org.orm.PersistentException;
import capaNegocio.fichaMedicaDomain.HceVO;
import capaNegocio.fichaMedicaDomain.RceVO;
import capaNegocio.personas.Paciente;
import capaNegocio.personasDomain.PacienteVO;

public class Hce {
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
	
	/**
	 * metodo para obtener hce, lista de rce
	 * @param hce objeto con el id del hce a buscar
	 * @return lista de objetos con datos de los rce 
	 */
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
	public HceVO obtenerHcePorId(int id) {
		HceVO hce = new HceVO();
		Paciente paciente = new Paciente();
		try {
			orm.Hce hcebd = orm.HceDAO.getHceByORMID(id);
			hce.setId(id);
			PacienteVO paci = paciente.obtenerPacientePorId(hcebd.getIdPaciente().getIdPaciente());
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
			PacienteVO paci = paciente.obtenerPacientePorId(hcebd.getIdPaciente().getIdPaciente());
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
