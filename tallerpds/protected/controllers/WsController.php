<?php

class WsController extends CController
{
//url web service http://localhost/yii/testapplication/index.php/ws/quote?wsdl
	//deduccion el nombre del controlador en este caso WsController eliminando el "Controller" del nombre otorga parte de la ruta en este caso es ws=> "WsController"
public function actions()
    {
        return array(
            'quote'=>array(
                'class'=>'CWebServiceAction',
            ),
        );
    }

    /**
     * @param float radio
	 * @return float
     * @soap
     */
    function areaCirculo($radio) {
		return (pow($radio, 2) * M_PI);
	}

	/**
     * @param float radio
	 * @return float
     * @soap
     */

	function perimetroCirculo($var) {
		$radio=floatval($var);
		return (2 * M_PI * $radio);
	}

	/**
    * @param string $empleado              <----- defines el tipo de argumento
    * @return string                       <----- defines tipo de retorno    
    * @soap                                <----- declara este metodo como "remoto"
 	**/
	public function calcularNomina($empleado){
		$dato = json_encode(array(123=>"unodostres"));
  		return $dato;
	}

	 /***
     @param string $argX 
     @return string  
     @soap
     */
    public function getObtenerMensajeRemoto($argX)
    {
    	$prices=array("as"=>"hola", 'GOOGLE'=>"350");
     
        return isset($prices[$argX])?$prices[$argX]:0;
    }

    /**
     * @param string the symbol of the stock
     * @return float the stock price
     * @soap
     */
 	 public function getPrice($symbol)
    {
        $prices=array('IBM'=>"100", 'GOOGLE'=>"350");
        return isset($prices[$symbol])?$prices[$symbol]:0;
        //...return stock price for $symbol
    } 

   /**
     * @param string the symbol of the stock
     * @return string the stock price
     * @soap
     */
    public function asdf($asd){
         $params = array ("idJugador" => "13");
    $clientes = new SoapClient("http://localhost:8080/WsHospital2/services/Servicio?wsdl");   
    $response =  $clientes->mostrarPacientes();
    //var_dump($response);
     $res = $response->mostrarPacientesReturn;
  $respuesta="{\"results\":".$res."}";
  
   return $respuesta;
    }
}

?>