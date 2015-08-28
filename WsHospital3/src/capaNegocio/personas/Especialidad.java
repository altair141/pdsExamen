package capaNegocio.personas;

import org.orm.PersistentException;

import capaNegocio.personasDomain.EspecialidadVO;

public class Especialidad {
	public EspecialidadVO buscarEspecialidadPorId(int id) {
		EspecialidadVO especialidadVo = new EspecialidadVO();
		try {
			orm.Especialidad especialidad = orm.EspecialidadDAO
					.getEspecialidadByORMID(id);
			especialidadVo.setId(id);
			especialidadVo.setNombre(especialidad.getNombreEspecialidad());
			return especialidadVo;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}


}
