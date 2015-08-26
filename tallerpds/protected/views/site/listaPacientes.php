<?php
/* @var $this SiteController */

$this->pageTitle=Yii::app()->name;
?>
	<div class="container">
		<div class="jumbotron">
			<center>
				<form class="" action="listaPacientes.ml" method="POST">
					<h2>Buscar paciente</h2>
					<div class="controls">
						<div class="input-prepend">

							<input type="text" class="form-control input-medium search-query"
								placeholder="Buscar paciente" aria-describedby="sizing-addon2"
								name="textoBusqueda" id="textBusqueda">
						</div>

						<div class="input-prepend">
						<button type="submit" class="btn btn-default"
							id="btn-BusquedaPaciente" name="btn_busqueda">							
							 <span class="icon-search"></span>
							Buscar
						</button>
						</div>
					</div>
				</form>
			</center>


			<br />
  	<script>
function seleccionado(datoPersona,uuid) {
	$("#formAbrirRCE").show();
	var id = document.getElementById("uuid");
	var nombre = document.getElementById("datosPaciente");
	id.value = uuid.innerHTML;
	nombre.value = datoPersona.innerHTML;

}
</script>

			<div id="resultadoBusPaciente" class="well well-small form-inline">
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
 								echo"<td hidden id='uuid".$i."'>".$pacientes["results"][$i]["persona"]["id"]."</td>";
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
 								echo"<td hidden id='uuid".$i."'>".$pacientes[$i]["persona"]["id"]."</td>";
 								echo "<td id='nombre".$i."'>".$pacientes[$i]["persona"]["nombre"]." ".$pacientes[$i]["persona"]["apellidos"]."</td>";
 								echo "<td style='width: 10%;'><button type='button' class='btn btn-default text-right' onclick='seleccionado(nombre".$i.", uuid".$i.")'>Seleccionar</button></td>";
 								echo"</tr>";
 							}
 						}
						}
						
						?>	

					</tbody>
				</table>
			</div>

			<form method="post" id="formAbrirRCE"  class="well well-small form-inline" hidden>
			<br>
				<div class="row">
					<div class="form-group" hidden>
						<input type="text" class="form-control" id="uuid" name="idPersona">
					</div>

					<div class="form-group col-lg-5 span-6">
						<label for="exampleInputEmail1"><b>Paciente:</b></label> <input
							type="text" class="form-control" id="datosPaciente" disabled>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="form-group col-lg-5 span-6">
						<button type="submit" name="btn" class="btn btn-success">Ver detalle</button>
					</div>
				</div>
			</form>
		</div>
	</div>