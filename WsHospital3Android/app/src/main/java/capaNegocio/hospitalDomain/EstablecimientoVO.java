package capaNegocio.hospitalDomain;

/**
 * Created by altair141 on 30-08-2015.
 */
public class EstablecimientoVO {
    private int id;
    private String nombre;

    public EstablecimientoVO() {
        super();
    }
    public EstablecimientoVO(int id) {
        super();
        this.id = id;
    }
    public EstablecimientoVO(int id, String nombre) {
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

