/**
 * Servicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package capaServicio;

public interface Servicio extends java.rmi.Remote {
    public java.lang.String registrarEncuentro(java.lang.String jsonEncuentro) throws java.rmi.RemoteException;
    public java.lang.String registrarMedicoOpenmrs(java.lang.String idMedico) throws java.rmi.RemoteException;
    public java.lang.String registrarPacienteOpen(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String obtenerListaPacientes() throws java.rmi.RemoteException;
    public java.lang.String obtenerHoraMedica(java.lang.String idHora) throws java.rmi.RemoteException;
    public java.lang.String buscarHorasPorIdPaciente(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String obtenerListaProcedimientos() throws java.rmi.RemoteException;
    public java.lang.String obtenerListaDiagnosticos() throws java.rmi.RemoteException;
    public java.lang.String obtenerListaActividades() throws java.rmi.RemoteException;
    public java.lang.String obtenerDiagnosticoporId(java.lang.String idDiagnostico) throws java.rmi.RemoteException;
    public java.lang.String obtenerActividadporId(java.lang.String idActividad) throws java.rmi.RemoteException;
    public java.lang.String obtenerHcePacientePorNombre(java.lang.String fichaMedica) throws java.rmi.RemoteException;
    public java.lang.String obtenerListaDiagnosticosPorId(java.lang.String listaDiagnostico) throws java.rmi.RemoteException;
    public java.lang.String obtenerListaActividadPorId(java.lang.String listaActividad) throws java.rmi.RemoteException;
    public java.lang.String obtenerListaProcedimientoPorId(java.lang.String listaProcedimiento) throws java.rmi.RemoteException;
    public java.lang.String obtenerRceCompleto(java.lang.String idRce) throws java.rmi.RemoteException;
    public java.lang.String buscarRecetasPoridRce(java.lang.String idRce) throws java.rmi.RemoteException;
    public java.lang.String registrarConcepto(java.lang.String jsonConcepto) throws java.rmi.RemoteException;
    public java.lang.String registrarObservacion(java.lang.String jsonObservacion) throws java.rmi.RemoteException;
    public java.lang.String horaesAps(java.lang.String idHoramedica) throws java.rmi.RemoteException;
    public java.lang.String buscarPacienteId(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String obtenerPaciente(java.lang.String rut) throws java.rmi.RemoteException;
    public java.lang.String obtenerHCE(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String obtenerIdHCE(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String registrarRce(java.lang.String json) throws java.rmi.RemoteException;
    public java.lang.String registrarReceta(java.lang.String json) throws java.rmi.RemoteException;
    public java.lang.String obtenerRcePorId(java.lang.String idRce) throws java.rmi.RemoteException;
    public java.lang.String buscarReceta(java.lang.String idReceta) throws java.rmi.RemoteException;
}
