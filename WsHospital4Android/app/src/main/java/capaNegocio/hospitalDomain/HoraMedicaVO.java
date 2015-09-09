package capaNegocio.hospitalDomain;

import java.util.Date;
import capaNegocio.personasDomain.MedicoVO;
/**
 * Created by altair141 on 06-09-2015.
 */
public class HoraMedicaVO {
    private int id;
    private MedicoVO medico;
    private BoxVO box;
    private String asp;
    private Date fecha;

    private String uuid;
    public HoraMedicaVO() {
        super();
    }
    public HoraMedicaVO(int id) {
        super();
        this.id = id;
    }
    public HoraMedicaVO(int id, MedicoVO medico, BoxVO box, String asp, Date fecha) {
        super();
        this.id = id;
        this.medico = medico;
        this.box = box;
        this.asp = asp;
        this.fecha = fecha;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public MedicoVO getMedico() {
        return medico;
    }
    public void setMedico(MedicoVO medico) {
        this.medico = medico;
    }
    public BoxVO getBox() {
        return box;
    }
    public void setBox(BoxVO box) {
        this.box = box;
    }
    public String getAsp() {
        return asp;
    }
    public void setAsp(String asp) {
        this.asp = asp;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
