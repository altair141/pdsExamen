package capaNegocio.fichamedicaDomain;

/**
 * Created by altair141 on 06-09-2015.
 */
public class DiagnosticoVO {
    private int id;
    private String nombre;


    public DiagnosticoVO() {
        super();
    }
    public DiagnosticoVO(int id) {
        super();
        this.id = id;
    }
    public DiagnosticoVO(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
