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
  
  public java.lang.String buscarPersonaPorIdLocal(java.lang.String id) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarPersonaPorIdLocal(id);
  }
  
  public java.lang.String buscarPersonaLocalPorUuid(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarPersonaLocalPorUuid(uuid);
  }
  
  public java.lang.String sincronizarPersonaToLocal(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.sincronizarPersonaToLocal(uuid);
  }
  
  public java.lang.String buscarPacientePorNombre(java.lang.String nombre) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarPacientePorNombre(nombre);
  }
  
  public java.lang.String visitaPorPacienteUuidRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.visitaPorPacienteUuidRest(uuid);
  }
  
  public java.lang.String encuentroUuidRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.encuentroUuidRest(uuid);
  }
  
  public java.lang.String encuentroPorPacienteUuidRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.encuentroPorPacienteUuidRest(uuid);
  }
  
  public java.lang.String registrarPaciente(java.lang.String jsonPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarPaciente(jsonPaciente);
  }
  
  public java.lang.String sincronizarPaciente(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.sincronizarPaciente(uuid);
  }
  
  public java.lang.String buscarPacienteBdLocalId(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarPacienteBdLocalId(idPaciente);
  }
  
  public java.lang.String buscarPacienteBdLocal(java.lang.String nombre) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarPacienteBdLocal(nombre);
  }
  
  public java.lang.String sincronizarMedicoToLocal(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.sincronizarMedicoToLocal(uuid);
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
  
  public java.lang.String buscarHorasAPSPorIdPaciente(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarHorasAPSPorIdPaciente(idPaciente);
  }
  
  public java.lang.String buscarHorasControlPorIdPaciente(java.lang.String idPaciente) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarHorasControlPorIdPaciente(idPaciente);
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
  
  public java.lang.String obtenerListaProcedimientos() throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerListaProcedimientos();
  }
  
  public java.lang.String registrarEncuentro(java.lang.String jsonEncuentro) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarEncuentro(jsonEncuentro);
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
  
  public java.lang.String obtenerProcedimientosporId(java.lang.String idProcedimiento) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerProcedimientosporId(idProcedimiento);
  }
  
  public java.lang.String obtenerHcePacientePorNombre(java.lang.String fichaMedica) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerHcePacientePorNombre(fichaMedica);
  }
  
  public java.lang.String registrarPersona(java.lang.String jsonPersona) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarPersona(jsonPersona);
  }
  
  public java.lang.String medicoUuidRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.medicoUuidRest(uuid);
  }
  
  public java.lang.String mostrarPersonas() throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.mostrarPersonas();
  }
  
  public java.lang.String mostrarPacientes() throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.mostrarPacientes();
  }
  
  public java.lang.String buscarMedicoOpen(java.lang.String nombre) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.buscarMedicoOpen(nombre);
  }
  
  public java.lang.String registrarRce(java.lang.String json) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarRce(json);
  }
  
  public java.lang.String medicoRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.medicoRest(uuid);
  }
  
  public java.lang.String personaNameRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.personaNameRest(uuid);
  }
  
  public java.lang.String pacienteRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.pacienteRest(uuid);
  }
  
  public java.lang.String visitaUuidRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.visitaUuidRest(uuid);
  }
  
  public java.lang.String pacienteUuidRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.pacienteUuidRest(uuid);
  }
  
  public java.lang.String conceptoRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.conceptoRest(uuid);
  }
  
  public java.lang.String conceptoUuidRest(java.lang.String uuid) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.conceptoUuidRest(uuid);
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
  
  public java.lang.String registrarVisita(java.lang.String jsonVisita) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.registrarVisita(jsonVisita);
  }
  
  public java.lang.String horaesAps(java.lang.String idHoramedica) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.horaesAps(idHoramedica);
  }
  
  public java.lang.String obtenerRcePorId(java.lang.String idRce) throws java.rmi.RemoteException{
    if (servicio == null)
      _initServicioProxy();
    return servicio.obtenerRcePorId(idRce);
  }
  
  
}