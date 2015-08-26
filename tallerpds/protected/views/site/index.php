
<?php
/* @var $this SiteController */

$this->pageTitle=Yii::app()->name;
?>
<?php
/* $params = array ("idJugador" => "13");
    $client = new SoapClient("http://localhost:8080/WsHospital2/services/Servicio?wsdl");   
    $response =  $client->mostrarPacientes();
    var_dump($response);
     $res = $response->mostrarPacientesReturn;
   echo $respuesta="{\"results\":".$res."}";*/
  
?>


 <br>
  <?php //$jso= Yii::app()->cliente->buscarPacienteBdLocal('pa');
 // echo $jso;
  //$json=json_decode($jso,TRUE);
  //echo count($json);
  //var_dump($json);
  //echo $json["results"][0]["nroFicha"];
  ?>



	<div class="container">
		<div class="jumbotron">
			<center>
				<form action="index" method="POST">
					<h2>Buscar paciente</h2>
					<div class="form-inline">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Buscar paciente" aria-describedby="sizing-addon2"
								name="textoBusqueda" id="textBusqueda">
						</div>


						<button type="submit" class="btn btn-default"
							id="btn-BusquedaPaciente" name="btn_busqueda">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							Buscar
						</button>
					</div>
				</form>
			</center>


			<br />
  	<script>
function seleccionado(datoPersona,id) {
	$("#formAbrirRCE").show();
	var id = document.getElementById("uuid");
	var nombre = document.getElementById("datosPaciente");
	id.value = uuid.innerHTML;
	nombre.value = datoPersona.innerHTML;

}
</script>

			<div id="resultadoBusPaciente">
				<center>
					<h2>Resultado de la búsqueda</h2>

				</center>
				<table class="table table-striped">
					<thead>
						<tr>
							<th hidden>uuid</th>
							<th>Nombres y Apellidos</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="tabla-busqueda">
						<!--deberia ser un for con los datos obtenidos mediante ajax-->
						
						<?php
						$jsonPacientes="no encontrado";
						if(isset($_POST["btn_busqueda"])){
							//$param=array("nombre"=>$_POST["textoBusqueda"]);
							$nom= $_POST["textoBusqueda"];												
							$jsonPacient= Yii::app()->cliente->buscarPacienteBdLocal($nom);
							if( strcmp($jsonPacient, "no encontrado")!==0){
							$pacientes=json_decode($jsonPacient,TRUE);
							 
 							
 							//var_dump($pacientes);
 							for($i=0;$i<count($pacientes["results"]);$i++){
 								echo "<tr>";
 								echo"<td hidden id='uuid".$i."'>".$pacientes["results"][$i]["persona"]["uuid"]."</td>";
 								echo "<td id='nombre".$i."'>".$pacientes["results"][$i]["persona"]["nombre"]." ".$pacientes["results"][$i]["persona"]["apellidos"]."</td>";
 								echo "<td style='width: 10%;'><button type='button' class='btn btn-default text-right' onclick='seleccionado(nombre".$i.",uuid".$i.")'>Seleccionar</button></td>";
 								echo"</tr>";
 							}
 						}
						
							
						}else{

 							 $jsonPacientes=Yii::app()->cliente->listaPacientes();
 							 if( strcmp($jsonPacientes, "no encontrado")!==0){
 							$pacientes=json_decode($jsonPacientes,TRUE);
 							//var_dump($pacientes);
 							for($i=0;$i<count($pacientes);$i++){
 								echo "<tr>";
 								echo"<td hidden id='uuid".$i."'>".$pacientes[$i]["persona"]["uuid"]."</td>";
 								echo "<td id='nombre".$i."'>".$pacientes[$i]["persona"]["nombre"]." ".$pacientes[$i]["persona"]["apellidos"]."</td>";
 								echo "<td style='width: 10%;'><button type='button' class='btn btn-default text-right' onclick='seleccionado(nombre".$i.",uuid".$i.")'>Seleccionar</button></td>";
 								echo"</tr>";
 							}
 						}
						}
						
						?>	

					</tbody>
				</table>
			</div>
			<br /> <br />




			<form method="post" id="formAbrirRCE" action="index" hidden>
				<div class="row">
					<div class="form-group" hidden>
						<input type="text" class="form-control" id="uuid" name="idPersona"
							hidden>
					</div>

					<div class="form-group col-lg-5">
						<label for="exampleInputEmail1">Paciente:</label> <input
							type="text" class="form-control" id="datosPaciente" disabled>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-lg-5">
						<button type="submit" name="btn" class="btn btn-default">Ver detalle</button>
					</div>
				</div>
			</form>
		</div>
	</div>