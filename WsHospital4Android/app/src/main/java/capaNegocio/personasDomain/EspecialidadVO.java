package capaNegocio.personasDomain;

/**
 * Created by altair141 on 06-09-2015.
 */
public class EspecialidadVO {
    public int id;
    public String nombre;


    public EspecialidadVO() {
        super();
    }


    public EspecialidadVO(int id) {
        super();
        this.id = id;
    }

    public EspecialidadVO(int id, String nombre) {
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
