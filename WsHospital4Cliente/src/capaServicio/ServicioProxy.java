package capaServicio;

public class ServicioProxy implements capaServicio.Servicio {
  private String _endpoint = null;
  private capaServicio.Servicio servicio = null;
  
  public ServicioProxy() {
    _initServicioProxy();
  }
  
  public ServicioProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioProxy();
  }
  
  private void _initServicioProxy() {
    try {
      servicio = (new capaServicio.ServicioServiceLocator()).getServicio();
      if (servicio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicio != null)
      ((javax.xml.rpc.Stub)servicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public capaServicio.Servicio getServicio() {
    if (servicio == null)
      _initServicioProxy();
    return servicio;
  }
  
  public java.lang.String registrarEncuentro(java.lang.String jsonEncuentro) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarEncuentro(jsonEncuentro);
  }
  
  public java.lang.String registrarMedicoOpenmrs(java.lang.String idMedico) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarMedicoOpenmrs(idMedico);
  }
  
  public java.lang.String registrarPacienteOpen(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarPacienteOpen(idPaciente);
  }
  
  public java.lang.String obtenerListaPacientes() throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaPacientes();
  }
  
  public java.lang.String obtenerHoraMedica(java.lang.String idHora) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerHoraMedica(idHora);
  }
  
  public java.lang.String buscarHorasPorIdPaciente(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarHorasPorIdPaciente(idPaciente);
  }
  
  public java.lang.String obtenerListaProcedimientos() throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaProcedimientos();
  }
  
  public java.lang.String obtenerListaDiagnosticos() throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaDiagnosticos();
  }
  
  public java.lang.String obtenerListaActividades() throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaActividades();
  }
  
  public java.lang.String obtenerDiagnosticoporId(java.lang.String idDiagnostico) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerDiagnosticoporId(idDiagnostico);
  }
  
  public java.lang.String obtenerActividadporId(java.lang.String idActividad) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerActividadporId(idActividad);
  }
  
  public java.lang.String obtenerHcePacientePorNombre(java.lang.String fichaMedica) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerHcePacientePorNombre(fichaMedica);
  }
  
  public java.lang.String obtenerListaDiagnosticosPorId(java.lang.String listaDiagnostico) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaDiagnosticosPorId(listaDiagnostico);
  }
  
  public java.lang.String obtenerListaActividadPorId(java.lang.String listaActividad) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaActividadPorId(listaActividad);
  }
  
  public java.lang.String obtenerListaProcedimientoPorId(java.lang.String listaProcedimiento) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaProcedimientoPorId(listaProcedimiento);
  }
  
  public java.lang.String obtenerRceCompleto(java.lang.String idRce) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerRceCompleto(idRce);
  }
  
  public java.lang.String buscarRecetasPoridRce(java.lang.String idRce) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarRecetasPoridRce(idRce);
  }
  
  public java.lang.String registrarConcepto(java.lang.String jsonConcepto) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarConcepto(jsonConcepto);
  }
  
  public java.lang.String registrarObservacion(java.lang.String jsonObservacion) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarObservacion(jsonObservacion);
  }
  
  public java.lang.String horaesAps(java.lang.String idHoramedica) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.horaesAps(idHoramedica);
  }
  
  public java.lang.String buscarPacienteId(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarPacienteId(idPaciente);
  }
  
  public java.lang.String obtenerPaciente(java.lang.String rut) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerPaciente(rut);
  }
  
  public java.lang.String obtenerHCE(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerHCE(idPaciente);
  }
  
  public java.lang.String obtenerIdHCE(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerIdHCE(idPaciente);
  }
  
  public java.lang.String registrarRce(java.lang.String json) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarRce(json);
  }
  
  public java.lang.String registrarReceta(java.lang.String json) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarReceta(json);
  }
  
  public java.lang.String obtenerRcePorId(java.lang.String idRce) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerRcePorId(idRce);
  }
  
  public java.lang.String buscarReceta(java.lang.String idReceta) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarReceta(idReceta);
  }
  
  
}