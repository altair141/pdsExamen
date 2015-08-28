package capaNegocio.personas;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import utilitario.Transformar;
import capaNegocio.hospital.Establecimiento;
import capaNegocio.hospitalDomain.EstablecimientoVO;
import capaNegocio.personasDomain.EspecialidadVO;
import capaNegocio.personasDomain.MedicoVO;
import capaNegocio.personasDomain.PersonaVO;

public class Medico {
	public String buscarMedicoUuid(String uuid) {
		String mensaje = "no encontrado";
		try {
			orm.Medico medi[] = orm.MedicoDAO.listMedicoByQuery(null, null);
			for (orm.Medico medico : medi) {
				if (medico.getIdPersona().getUuid().equals(uuid)) {
					System.out.println(medico.getIdPersona().getUuid());
					mensaje = "encontrado";
					break;
				}
			}

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			return mensaje;
		}

		return mensaje;
	}
	public String sincronizarMedico(MedicoVO medico){
		String mensaje="no sincronizado";
		
		Persona persona=new Persona();
		PersonaVO personaVo=medico.getPersona();		
		String idPersona=persona.registrarPersona(personaVo);
		System.out.println(idPersona);
		personaVo.setId(Transformar.stringToInt(idPersona));
		medico.setPersona(personaVo);
		String idMedico=registrarMedico(medico);
		if(idMedico.equals("no registrado")){
			return mensaje;
		}else{
			mensaje=idMedico;
		}
	return mensaje;	
	}
	
	public String registrarMedico(MedicoVO medicoVo){
		String mensaje="no registrado";
		
			try {
				PersistentTransaction ts = orm.Taller2PersistentManager.instance().getSession().beginTransaction();
				orm.Medico medico=orm.MedicoDAO.createMedico();
				
				orm.Especialidad especialidad=orm.EspecialidadDAO.getEspecialidadByORMID(medicoVo.getEspecialidad().getId());
				orm.Establecimiento hospital=orm.EstablecimientoDAO.getEstablecimientoByORMID(medicoVo.getHospital().getId());
				orm.Persona persona=orm.PersonaDAO.getPersonaByORMID(medicoVo.getPersona().getId());
				medico.setEspecialidad(especialidad);
				medico.setIdEstablecimiento(hospital);
				medico.setIdPersona(persona);
				if(orm.MedicoDAO.save(medico)){
					ts.commit();
					return medico.getIdMedico()+""; 				
				}
				return mensaje;
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return mensaje;
			}catch(NullPointerException e){
				return mensaje;
			}		
	}
	
	public MedicoVO buscarMedicoPorId(int id){
		MedicoVO medicoVo=new MedicoVO();
		Persona persona=new Persona();
		Establecimiento hospital=new Establecimiento();
		Especialidad especialidad=new Especialidad();
		try {
			orm.Medico medico=orm.MedicoDAO.getMedicoByORMID(id);
			medicoVo.setId(id);
			EspecialidadVO especialidadVo=especialidad.buscarEspecialidadPorId(medico.getEspecialidad().getIdEspecialidad());
			medicoVo.setEspecialidad(especialidadVo);
			PersonaVO personaVo=new PersonaVO(); 
			personaVo=persona.obtenerPersonaId(medico.getIdPersona().getIdPersona());
			medicoVo.setPersona(personaVo);
			EstablecimientoVO hopitalVo=hospital.buscarHospitalPorId(medico.getIdEstablecimiento().getId());			
			medicoVo.setHospital(hopitalVo);
			
			return medicoVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
