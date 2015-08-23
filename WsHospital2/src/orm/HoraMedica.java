/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

/**
 * horas medicas
 */
public class HoraMedica {
	public HoraMedica() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_HORAMEDICA_IDMEDICO) {
			this.idMedico = (orm.Medico) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_HORAMEDICA_IDBOX) {
			this.idBox = (orm.Box) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_HORAMEDICA_IDESTABLECIMIENTO) {
			this.idEstablecimiento = (orm.Establecimiento) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_HORAMEDICA_RESERVA) {
			this.reserva = (orm.Reserva) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idHora;
	
	private orm.Medico idMedico;
	
	private orm.Box idBox;
	
	private String asp;
	
	private java.sql.Timestamp fecha;
	
	private String uuid;
	
	private orm.Establecimiento idEstablecimiento;
	
	private orm.Reserva reserva;
	
	/**
	 * identificador hora medica
	 */
	private void setIdHora(int value) {
		this.idHora = value;
	}
	
	/**
	 * identificador hora medica
	 */
	public int getIdHora() {
		return idHora;
	}
	
	public int getORMID() {
		return getIdHora();
	}
	
	/**
	 * hora medica aps o no aps
	 */
	public void setAsp(String value) {
		this.asp = value;
	}
	
	/**
	 * hora medica aps o no aps
	 */
	public String getAsp() {
		return asp;
	}
	
	/**
	 * fecha hora medica
	 */
	public void setFecha(java.sql.Timestamp value) {
		this.fecha = value;
	}
	
	/**
	 * fecha hora medica
	 */
	public java.sql.Timestamp getFecha() {
		return fecha;
	}
	
	/**
	 * identificador de búsqueda openmrs
	 */
	public void setUuid(String value) {
		this.uuid = value;
	}
	
	/**
	 * identificador de búsqueda openmrs
	 */
	public String getUuid() {
		return uuid;
	}
	
	public void setIdMedico(orm.Medico value) {
		if (idMedico != null) {
			idMedico.horaMedica.remove(this);
		}
		if (value != null) {
			value.horaMedica.add(this);
		}
	}
	
	public orm.Medico getIdMedico() {
		return idMedico;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdMedico(orm.Medico value) {
		this.idMedico = value;
	}
	
	private orm.Medico getORM_IdMedico() {
		return idMedico;
	}
	
	public void setIdBox(orm.Box value) {
		if (idBox != null) {
			idBox.horaMedica.remove(this);
		}
		if (value != null) {
			value.horaMedica.add(this);
		}
	}
	
	public orm.Box getIdBox() {
		return idBox;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdBox(orm.Box value) {
		this.idBox = value;
	}
	
	private orm.Box getORM_IdBox() {
		return idBox;
	}
	
	public void setIdEstablecimiento(orm.Establecimiento value) {
		if (idEstablecimiento != null) {
			idEstablecimiento.horaMedica.remove(this);
		}
		if (value != null) {
			value.horaMedica.add(this);
		}
	}
	
	public orm.Establecimiento getIdEstablecimiento() {
		return idEstablecimiento;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_IdEstablecimiento(orm.Establecimiento value) {
		this.idEstablecimiento = value;
	}
	
	private orm.Establecimiento getORM_IdEstablecimiento() {
		return idEstablecimiento;
	}
	
	public void setReserva(orm.Reserva value) {
		if (this.reserva != value) {
			orm.Reserva lreserva = this.reserva;
			this.reserva = value;
			if (value != null) {
				reserva.setIdHoraMedica(this);
			}
			if (lreserva != null) {
				lreserva.setIdHoraMedica(null);
			}
		}
	}
	
	public orm.Reserva getReserva() {
		return reserva;
	}
	
	public String toString() {
		return String.valueOf(getIdHora());
	}
	
}
