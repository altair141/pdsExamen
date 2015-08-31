package capaNegocio.fichamedicaDomain;

/**
 * Created by altair141 on 30-08-2015.
 */
public class DiagnosticoVO {
    private int id;
    private String nombre;
    private String uuid;



    public DiagnosticoVO() {
        super();
    }
    public DiagnosticoVO(int id) {
        super();
        this.id = id;
    }
    public DiagnosticoVO(int id, String nombre, String uuid) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.uuid = uuid;
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
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
