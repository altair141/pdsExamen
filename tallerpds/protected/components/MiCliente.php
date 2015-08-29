<?php
class MiCliente extends CApplicationComponent{
	private $client =null;
	public $ws_url;
	private function getClienteInt() {
        if($this->client == null)
        {
                // para que reconozca nuevas funciones del WS 
                ini_set (  'soap.wsdl_cache_enable'  ,  0  );
                ini_set (  'soap.wsdl_cache_ttl'  ,  0  );
                $this->client = new SoapClient("http://localhost:8080/WsHospital3/services/Servicio?wsdl");
        }
        return $this->client;
    }

     
        public function listaPacientes(){
           
            return $this->getClienteInt()->mostrarPacientes()->mostrarPacientesReturn;
        }
        public function buscarPacienteBdLocal($nombrePaciente){
            $param= array("nombre"=>$nombrePaciente);
            return $this->getClienteInt()->buscarPacienteBdLocal($param)->buscarPacienteBdLocalReturn;
        }
        public function buscarPacienteBdLocalId($uuidPersona){
            $param=array("idPaciente"=>$uuidPersona);
            return $this->getClienteInt()->buscarPacienteBdLocalId($param)->buscarPacienteBdLocalIdReturn;
        }
        public function buscarHorasPorIdPaciente($idPaciente){
            $param=array("idPaciente"=>$idPaciente);
            return $this->getClienteInt()->buscarHorasPorIdPaciente($param)->buscarHorasPorIdPacienteReturn;

        }
        public function obtenerHoraMedica($idHoraMedica){
            $param=array("idHora"=>$idHoraMedica);
            return $this->getClienteInt()->obtenerHoraMedica($param)->obtenerHoraMedicaReturn;

        }
        public function obtenerHCE($idPaciente){
            $param=array("idPaciente"=>$idPaciente);
            return $this->getClienteInt()->obtenerHCE($param)->obtenerHCEReturn;
        }
        public function obtenerIdHCE($idPaciente){
            $param=array("idPaciente"=>$idPaciente);
            return $this->getClienteInt()->obtenerIdHCE($param)->obtenerIdHCEReturn;
        }
        public function obtenerListaProcedimientos(){
            return $this->getClienteInt()->obtenerListaProcedimientos()->obtenerListaProcedimientosReturn;
        }
        public function obtenerListaDiagnosticos(){
            return $this->getClienteInt()->obtenerListaDiagnosticos()->obtenerListaDiagnosticosReturn;
        }
        public function obtenerListaActividades(){
            return $this->getClienteInt()->obtenerListaActividades()->obtenerListaActividadesReturn;
        }
        public function obtenerRcePorId($idRce){
            $param=array("idRce"=>$idRce);
            return $this->getClienteInt()->obtenerRcePorId($param)->obtenerRcePorIdReturn;
        }        

        public function obtenerDiagnosticoporId($idDiagnostico){
             $param=array("idDiagnostico"=>$idDiagnostico);
            return $this->getClienteInt()->obtenerDiagnosticoporId($param)->obtenerDiagnosticoporIdReturn;
        }
        public function obtenerActividadporId($idActividad){
            $param=array("idActividad"=>$idActividad);
            return $this->getClienteInt()->obtenerActividadporId($param)->obtenerActividadporIdReturn;
        }
        public function obtenerProcedimientosporId($idProcedimiento){
            $param=array("idProcedimiento"=>$idProcedimiento);
            return $this->getClienteInt()->obtenerProcedimientosporId($param)->obtenerProcedimientosporIdReturn;
        }
    }
?>
