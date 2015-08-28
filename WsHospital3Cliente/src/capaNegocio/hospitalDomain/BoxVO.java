package capaNegocio.hospitalDomain;

public class BoxVO {
	private int Box;
	private String nroHabitacion;
	private EstablecimientoVO establecimiento;
	public BoxVO() {
		super();
	}
	public BoxVO(int box) {
		super();
		Box = box;
	}
	public BoxVO(int box, String nroHabitacion, EstablecimientoVO establecimiento) {
		super();
		Box = box;
		this.nroHabitacion = nroHabitacion;
		this.establecimiento = establecimiento;
	}
	public int getBox() {
		return Box;
	}
	public void setBox(int box) {
		Box = box;
	}
	public String getNroHabitacion() {
		return nroHabitacion;
	}
	public void setNroHabitacion(String nroHabitacion) {
		this.nroHabitacion = nroHabitacion;
	}
	public EstablecimientoVO getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(EstablecimientoVO establecimiento) {
		this.establecimiento = establecimiento;
	}

}
