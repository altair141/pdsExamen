/**
 * Servicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package capaServicio;

public interface Servicio extends java.rmi.Remote {
    public java.lang.String buscarPersonaPorIdLocal(java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.String buscarPersonaLocalPorUuid(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String sincronizarPersonaToLocal(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String buscarPacientePorNombre(java.lang.String nombre) throws java.rmi.RemoteException;
    public java.lang.String visitaPorPacienteUuidRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String encuentroUuidRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String encuentroPorPacienteUuidRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String registrarPaciente(java.lang.String jsonPaciente) throws java.rmi.RemoteException;
    public java.lang.String sincronizarPaciente(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String buscarPacienteBdLocalId(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String buscarPacienteBdLocal(java.lang.String nombre) throws java.rmi.RemoteException;
    public java.lang.String sincronizarMedicoToLocal(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String registrarCierreCasoMedico(java.lang.String json) throws java.rmi.RemoteException;
    public java.lang.String obtenerHoraMedica(java.lang.String idHora) throws java.rmi.RemoteException;
    public java.lang.String buscarHorasPorIdPaciente(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String buscarHorasAPSPorIdPaciente(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String buscarHorasControlPorIdPaciente(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String obtenerListaDiagnosticos() throws java.rmi.RemoteException;
    public java.lang.String obtenerListaActividades() throws java.rmi.RemoteException;
    public java.lang.String obtenerListaProcedimientos() throws java.rmi.RemoteException;
    public java.lang.String registrarPersona(java.lang.String jsonPersona) throws java.rmi.RemoteException;
    public java.lang.String medicoUuidRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String mostrarPersonas() throws java.rmi.RemoteException;
    public java.lang.String mostrarPacientes() throws java.rmi.RemoteException;
    public java.lang.String buscarMedicoOpen(java.lang.String nombre) throws java.rmi.RemoteException;
    public java.lang.String registrarRce(java.lang.String json) throws java.rmi.RemoteException;
    public java.lang.String pacienteRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String medicoRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String personaNameRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String visitaUuidRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String pacienteUuidRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String conceptoRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String conceptoUuidRest(java.lang.String uuid) throws java.rmi.RemoteException;
    public java.lang.String obtenerHCE(java.lang.String idPaciente) throws java.rmi.RemoteException;
    public java.lang.String obtenerIdHCE(java.lang.String idPaciente) throws java.rmi.RemoteException;
}
