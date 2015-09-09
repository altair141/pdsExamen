package capaNegocio.hospitalDomain;

/**
 * Created by altair141 on 06-09-2015.
 */
public class BoxVO {
    private int Box;
    private String nroHabitacion;

    public BoxVO() {
        super();
    }
    public BoxVO(int box) {
        super();
        Box = box;
    }
    public BoxVO(int box, String nroHabitacion) {
        super();
        Box = box;
        this.nroHabitacion = nroHabitacion;

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

}
