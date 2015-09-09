package capaNegocio.fichaMedicaDomain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import capaNegocio.hospitalDomain.HoraMedicaVO;

public class RceVO {
	private int idRce;
	private String tipoEncuentro;
	private String receta;
	private HceVO idHce;
	private HoraMedicaVO idHoraMedica;
	private String anamnesis;
	private String alergia;
	private String examenFisico;
	private String indicacionMedica;
	private String indicacionCierreCaso;
	private String hipotesisDiagnostico;
	private String pacienteGes;
	private String patologiaGes;
	private String pacienteCronico;

	// cierrecaso
	private String tipoCierre;
	private String destino;
	private Date fechaAtencion;
	private String horaInicioAtencion;
	private Date fechaCierreClinico;
	private String horaCierreClienico;
	private String tiempoControl;
	private List<DiagnosticoVO> listaDiagnostico = new ArrayList<DiagnosticoVO>();
	private List<ActividadVO> listaActividad = new ArrayList<ActividadVO>();
	private List<ProcedimientoVO> listaProcedimiento = new ArrayList<ProcedimientoVO>();
	private List<CertificadoVO> listaCertificados = new ArrayList<CertificadoVO>();

	public RceVO() {
		super();
	}

	public RceVO(int idRce) {
		super();
		this.idRce = idRce;
	}

	public RceVO(int idRce, String tipoEncuentro, HceVO idHce,
			HoraMedicaVO idHoraMedica, String anamnesis, String alergia,
			String examenFisico, String indicacionMedica,
			String indicacionCierreCaso, String hipotesisDiagnostico,
			String pacienteGes, String patologiaGes, String pacienteCronico,
			String receta, String tipoCierre, String destino,
			Date fechaAtencion, String horaInicioAtencion,
			Date fechaCierreClinico, String horaCierreClienico,
			String tiempoControl, List<DiagnosticoVO> listaDiagnostico,
			List<ActividadVO> listaActividad,
			List<ProcedimientoVO> listaProcedimiento,
			List<CertificadoVO> listaCertificados) {
		super();
		this.idRce = idRce;
		this.receta=receta;
		this.tipoEncuentro = tipoEncuentro;
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

		this.tipoCierre = tipoCierre;
		this.destino = destino;
		this.fechaAtencion = fechaAtencion;
		this.horaInicioAtencion = horaInicioAtencion;
		this.fechaCierreClinico = fechaCierreClinico;
		this.horaCierreClienico = horaCierreClienico;
		this.tiempoControl = tiempoControl;
		this.listaDiagnostico = listaDiagnostico;
		this.listaActividad = listaActividad;
		this.listaProcedimiento = listaProcedimiento;
		this.listaCertificados = listaCertificados;
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

	public HceVO getIdHce() {
		return idHce;
	}

	public void setIdHce(HceVO idHce) {
		this.idHce = idHce;
	}

	public HoraMedicaVO getIdHoraMedica() {
		return idHoraMedica;
	}

	public void setIdHoraMedica(HoraMedicaVO idHoraMedica) {
		this.idHoraMedica = idHoraMedica;
	}

	public String getAnamnesis() {
		return anamnesis;
	}

	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}

	
	
	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
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

	public List<DiagnosticoVO> getListaDiagnostico() {
		return listaDiagnostico;
	}

	public void setListaDiagnostico(List<DiagnosticoVO> listaDiagnostico) {
		this.listaDiagnostico = listaDiagnostico;
	}

	public List<ActividadVO> getListaActividad() {
		return listaActividad;
	}

	public void setListaActividad(List<ActividadVO> listaActividad) {
		this.listaActividad = listaActividad;
	}

	public List<ProcedimientoVO> getListaProcedimiento() {
		return listaProcedimiento;
	}

	public void setListaProcedimiento(List<ProcedimientoVO> listaProcedimiento) {
		this.listaProcedimiento = listaProcedimiento;
	}

	public List<CertificadoVO> getListaCertificados() {
		return listaCertificados;
	}

	public void setListaCertificados(List<CertificadoVO> listaCertificados) {
		this.listaCertificados = listaCertificados;
	}

	public void agregarCertificado(CertificadoVO certificado) {
		this.listaCertificados.add(certificado);
	}

	public void agregarProcedimiento(ProcedimientoVO procedimiento) {
		this.listaProcedimiento.add(procedimiento);
	}

	public void agregarActividad(ActividadVO actividad) {
		this.listaActividad.add(actividad);
	}

	public void agregarDiagnostico(DiagnosticoVO diagnostico) {
		this.listaDiagnostico.add(diagnostico);
	}

}
