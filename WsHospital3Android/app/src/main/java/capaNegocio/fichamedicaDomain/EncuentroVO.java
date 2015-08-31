package capaNegocio.fichamedicaDomain;

/**
 * Created by altair141 on 30-08-2015.
 */
public class EncuentroVO {
    private String fechaTime;
    private String paciente;
    private String tipoEncuentro;

    public EncuentroVO(String fechaTime, String paciente, String tipoEncuentro) {
        super();
        this.fechaTime = fechaTime;
        this.paciente = paciente;
        this.tipoEncuentro = tipoEncuentro;
    }
    public EncuentroVO() {
        super();
    }
    public String getFechaTime() {
        return fechaTime;
    }
    public void setFechaTime(String fechaTime) {
        this.fechaTime = fechaTime;
    }
    public String getPaciente() {
        return paciente;
    }
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
    public String getTipoEncuentro() {
        return tipoEncuentro;
    }
    public void setTipoEncuentro(String tipoEncuentro) {
        this.tipoEncuentro = tipoEncuentro;
    }

}
