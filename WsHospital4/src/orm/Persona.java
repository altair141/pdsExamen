/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package orm;

/**
 * persona, ser humano
 */
public class Persona {
	public Persona() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_PERSONA_RESERVA) {
			return ORM_reserva;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idPersona;
	
	private String nombre;
	
	private String apellidos;
	
	private java.util.Date fechaNacimiento;
	
	private String direccion;
	
	private String estado;
	
	private String rut;
	
	private String sexo;
	
	private java.util.Set ORM_reserva = new java.util.HashSet();
	
	private orm.Paciente paciente;
	
	private orm.Medico medico;
	
	private orm.DirectorHospital directorHospital;
	
	/**
	 * identificador de la persona
	 */
	private void setIdPersona(int value) {
		this.idPersona = value;
	}
	
	/**
	 * identificador de la persona
	 */
	public int getIdPersona() {
		return idPersona;
	}
	
	public int getORMID() {
		return getIdPersona();
	}
	
	/**
	 * nombres de la persona
	 */
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	/**
	 * nombres de la persona
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * apellidos de la persona
	 */
	public void setApellidos(String value) {
		this.apellidos = value;
	}
	
	/**
	 * apellidos de la persona
	 */
	public String getApellidos() {
		return apellidos;
	}
	
	/**
	 * fecha de nacimiento de la persona
	 */
	public void setFechaNacimiento(java.util.Date value) {
		this.fechaNacimiento = value;
	}
	
	/**
	 * fecha de nacimiento de la persona
	 */
	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * dirección de la persona
	 */
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	/**
	 * dirección de la persona
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * estado de la persona, activo o no activo
	 */
	public void setEstado(String value) {
		this.estado = value;
	}
	
	/**
	 * estado de la persona, activo o no activo
	 */
	public String getEstado() {
		return estado;
	}
	
	public void setRut(String value) {
		this.rut = value;
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setSexo(String value) {
		this.sexo = value;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	private void setORM_Reserva(java.util.Set value) {
		this.ORM_reserva = value;
	}
	
	private java.util.Set getORM_Reserva() {
		return ORM_reserva;
	}
	
	public final orm.ReservaSetCollection reserva = new orm.ReservaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_PERSONA_RESERVA, orm.ORMConstants.KEY_RESERVA_IDPERSONAREGISTRA, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPaciente(orm.Paciente value) {
		if (this.paciente != value) {
			orm.Paciente lpaciente = this.paciente;
			this.paciente = value;
			if (value != null) {
				paciente.setIdPersona(this);
			}
			if (lpaciente != null && lpaciente.getIdPersona() == this) {
				lpaciente.setIdPersona(null);
			}
		}
	}
	
	public orm.Paciente getPaciente() {
		return paciente;
	}
	
	public void setMedico(orm.Medico value) {
		if (this.medico != value) {
			orm.Medico lmedico = this.medico;
			this.medico = value;
			if (value != null) {
				medico.setIdPersona(this);
			}
			if (lmedico != null && lmedico.getIdPersona() == this) {
				lmedico.setIdPersona(null);
			}
		}
	}
	
	public orm.Medico getMedico() {
		return medico;
	}
	
	public void setDirectorHospital(orm.DirectorHospital value) {
		if (this.directorHospital != value) {
			orm.DirectorHospital ldirectorHospital = this.directorHospital;
			this.directorHospital = value;
			if (value != null) {
				directorHospital.setIdPersona(this);
			}
			if (ldirectorHospital != null && ldirectorHospital.getIdPersona() == this) {
				ldirectorHospital.setIdPersona(null);
			}
		}
	}
	
	public orm.DirectorHospital getDirectorHospital() {
		return directorHospital;
	}
	
	public String toString() {
		return String.valueOf(getIdPersona());
	}
	
}
