package capaNegocio.fichamedicaDomain;

/**
 * Created by altair141 on 30-08-2015.
 */
import java.util.Date;
public class VisitaVO {
    private String uuidPaciente;
    private String uuidVisitType;
    private Date startDateTime;
    public VisitaVO(String uuidPaciente, String uuidVisitType,
                    Date startDateTieme) {
        super();
        this.uuidPaciente = uuidPaciente;
        this.uuidVisitType = uuidVisitType;
        this.startDateTime = startDateTieme;
    }

    public VisitaVO() {
        super();
    }

    public String getUuidPaciente() {
        return uuidPaciente;
    }
    public void setUuidPaciente(String uuidPaciente) {
        this.uuidPaciente = uuidPaciente;
    }
    public String getUuidVisitType() {
        return uuidVisitType;
    }
    public void setUuidVisitType(String uuidVisitType) {
        this.uuidVisitType = uuidVisitType;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

}
