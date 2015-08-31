package capaNegocio.fichamedicaDomain;

/**
 * Created by altair141 on 30-08-2015.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RceVO {
    private int idRce;
    private String tipoEncuentro;
    private String uuid;
    private HceVO idHce;
    private int idHoraMedica;
    private String anamnesis;
    private String alergia;
    private String examenFisico;
    private String indicacionMedica;
    private String indicacionCierreCaso;
    private String hipotesisDiagnostico;
    private String pacienteGes;
    private String patologiaGes;
    private String pacienteCronico;
    private String receta;
    private DiagnosticoVO idDiagnostico;
    private ActividadVO idActividad;
    private ProcedimientoVO idProcedimiento;
    //cierrecaso
    private String tipoCierre;
    private String destino;
    private Date fechaAtencion;
    private String horaInicioAtencion;
    private Date fechaCierreClinico;
    private String horaCierreClienico;
    private String tiempoControl;
    private List<CertificadoVO> listaCertificados=new ArrayList<CertificadoVO>();


    public RceVO() {
        super();
    }


    public RceVO(int idRce, String tipoEncuentro, String uuid, HceVO idHce,
                 int idHoraMedica, String anamnesis, String alergia,
                 String examenFisico, String indicacionMedica,
                 String indicacionCierreCaso, String hipotesisDiagnostico,
                 String pacienteGes, String patologiaGes, String pacienteCronico,
                 String receta, DiagnosticoVO idDiagnostico,
                 ActividadVO idActividad, ProcedimientoVO idProcedimiento,
                 String tipoCierre, String destino, Date fechaAtencion,
                 String horaInicioAtencion, Date fechaCierreClinico,
                 String horaCierreClienico, String tiempoControl,
                 List<CertificadoVO> listaCertificados) {
        super();
        this.idRce = idRce;
        this.tipoEncuentro = tipoEncuentro;
        this.uuid = uuid;
        this.idHce = idHce;
        this.idHoraMedica = idHoraMedica;
        this.anamnesis = anamnesis;
        this.alergia = alergia;
        this.examenFisico = examenFisico;
        this.indicacionMedica = indicacionMedica;
        this.indicacionCierreCaso = indicacionCierreCaso;
        this.hipotesisDiagnostico = hipotesisDiagnostico;
        this.pacienteGes = pacienteGes;
        this.patologiaGes = patologiaGes;
        this.pacienteCronico = pacienteCronico;
        this.receta = receta;
        this.idDiagnostico = idDiagnostico;
        this.idActividad = idActividad;
        this.idProcedimiento = idProcedimiento;
        this.tipoCierre = tipoCierre;
        this.destino = destino;
        this.fechaAtencion = fechaAtencion;
        this.horaInicioAtencion = horaInicioAtencion;
        this.fechaCierreClinico = fechaCierreClinico;
        this.horaCierreClienico = horaCierreClienico;
        this.tiempoControl = tiempoControl;
        this.listaCertificados = listaCertificados;
    }


    public RceVO(int idRce) {
        super();
        this.idRce = idRce;
    }


    public int getIdRce() {
        return idRce;
    }
    public void setIdRce(int idRce) {
        this.idRce = idRce;
    }
    public String getTipoEncuentro() {
        return tipoEncuentro;
    }
    public void setTipoEncuentro(String tipoEncuentro) {
        this.tipoEncuentro = tipoEncuentro;
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public HceVO getIdHce() {
        return idHce;
    }
    public void setIdHce(HceVO idHce) {
        this.idHce = idHce;
    }
    public int getIdHoraMedica() {
        return idHoraMedica;
    }
    public void setIdHoraMedica(int idHoraMedica) {
        this.idHoraMedica = idHoraMedica;
    }
    public String getAnamnesis() {
        return anamnesis;
    }
    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }
    public String getAlergia() {
        return alergia;
    }
    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    public String getExamenFisico() {
        return examenFisico;
    }
    public void setExamenFisico(String examenFisico) {
        this.examenFisico = examenFisico;
    }
    public String getIndicacionMedica() {
        return indicacionMedica;
    }
    public void setIndicacionMedica(String indicacionMedica) {
        this.indicacionMedica = indicacionMedica;
    }
    public String getIndicacionCierreCaso() {
        return indicacionCierreCaso;
    }
    public void setIndicacionCierreCaso(String indicacionCierreCaso) {
        this.indicacionCierreCaso = indicacionCierreCaso;
    }
    public String getHipotesisDiagnostico() {
        return hipotesisDiagnostico;
    }
    public void setHipotesisDiagnostico(String hipotesisDiagnostico) {
        this.hipotesisDiagnostico = hipotesisDiagnostico;
    }
    public String getPacienteGes() {
        return pacienteGes;
    }
    public void setPacienteGes(String pacienteGes) {
        this.pacienteGes = pacienteGes;
    }
    public String getPatologiaGes() {
        return patologiaGes;
    }
    public void setPatologiaGes(String patologiaGes) {
        this.patologiaGes = patologiaGes;
    }
    public String getPacienteCronico() {
        return pacienteCronico;
    }
    public void setPacienteCronico(String pacienteCronico) {
        this.pacienteCronico = pacienteCronico;
    }
    public String getReceta() {
        return receta;
    }
    public void setReceta(String receta) {
        this.receta = receta;
    }
    public DiagnosticoVO getIdDiagnostico() {
        return idDiagnostico;
    }
    public void setIdDiagnostico(DiagnosticoVO idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
    public ActividadVO getIdActividad() {
        return idActividad;
    }
    public void setIdActividad(ActividadVO idActividad) {
        this.idActividad = idActividad;
    }
    public ProcedimientoVO getIdProcedimiento() {
        return idProcedimiento;
    }
    public void setIdProcedimiento(ProcedimientoVO idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }
    public List<CertificadoVO> getListaCertificados() {
        return listaCertificados;
    }
    public void setListaCertificados(List<CertificadoVO> listaCertificados) {
        this.listaCertificados = listaCertificados;
    }
    public void agregarCertificado(CertificadoVO certificado){
        this.listaCertificados.add(certificado);
    }


    public String getTipoCierre() {
        return tipoCierre;
    }


    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }


    public String getDestino() {
        return destino;
    }


    public void setDestino(String destino) {
        this.destino = destino;
    }


    public Date getFechaAtencion() {
        return fechaAtencion;
    }


    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }


    public String getHoraInicioAtencion() {
        return horaInicioAtencion;
    }


    public void setHoraInicioAtencion(String horaInicioAtencion) {
        this.horaInicioAtencion = horaInicioAtencion;
    }


    public Date getFechaCierreClinico() {
        return fechaCierreClinico;
    }


    public void setFechaCierreClinico(Date fechaCierreClinico) {
        this.fechaCierreClinico = fechaCierreClinico;
    }


    public String getHoraCierreClienico() {
        return horaCierreClienico;
    }


    public void setHoraCierreClienico(String horaCierreClienico) {
        this.horaCierreClienico = horaCierreClienico;
    }


    public String getTiempoControl() {
        return tiempoControl;
    }


    public void setTiempoControl(String tiempoControl) {
        this.tiempoControl = tiempoControl;
    }

}
