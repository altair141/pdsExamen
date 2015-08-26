

<?php
$ficha="";
$jsonpaciente = "{\"results\":[{\"id\":0,\"persona\":{\"id\":0}}]}";
$jsonlistaHoras = "{\"results\":[]}";
$resumen = "";
$estadoCaso = "";
$establecimiento = "";
$fecha = "";
$horaMedica = "";
$medico = "";
$hora = "";
$jsonPersona;
$listaHoras;

if(isset($idPaciente)){
	$jsonPersona=Yii::app()->cliente->buscarPacienteBdLocalId($idPaciente);
	$paciente=json_decode($jsonPersona,TRUE);
	//echo $jsonPersona;
	//var_dump($paciente);
	$ficha=$paciente["results"][0]["nroFicha"];
	if(strcmp($jsonPersona, $jsonpaciente) !== 0){
		$jsonlistaHoras=Yii::app()->cliente->buscarHorasPorIdPaciente($idPaciente);
		//echo $jsonlistaHoras;
		$listaHoras=json_decode($jsonlistaHoras,TRUE);
		//var_dump($listaHoras);
	}
}

?>
<script>
function seleccionado(id,hospital,fecha,medico) {
$("#formAbrirHora").show();
var idHora = document.getElementById("idHora");
var nombreHospital = document.getElementById("nHospital");
var fech= document.getElementById("fechaHora");
var nombreMedico=document.getElementById("nMedico");
idHora.value = id.innerHTML;
nombreHospital.value = hospital.innerHTML;
fech.value=fecha.innerHTML;
nombreMedico.value=medico.innerHTML;
}
</script>
<div class="container">
	<div class="jumbotron">
		<center>
			<h2>Horas Médicas</h2>
			<h2>
				<b><?php echo $ficha ?></b>
			</h2>

		</center>
		<br>

		<div class="row">
			<div class="well well-long span8">
				<div class="controls">
				<br>
				<table class="table table-striped">
					<thead>
						<tr>
							<th hidden>id</th>
							<th>Establecimiento</th>
							<th>Fecha</th>
							<th>Medico</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						
						<?php 
						if(isset($listaHoras)){
							for($i=0;$i<count($listaHoras["results"]);$i++){
								$apellido="";
								if(isset($listaHoras["results"][$i]["medico"]["persona"]["apellidos"])){
									$apellido=$listaHoras["results"][$i]["medico"]["persona"]["apellidos"];
								}
								//
							echo "<tr>";
							echo "<td hidden id='id".$i."'>".$listaHoras["results"][$i]["id"]."</td>";
							echo "<td id='hospital".$i."'>".$listaHoras["results"][$i]["establecimiento"]["nombre"]." ".$apellido."</td>";
							echo "<td id='fecha".$i."'>".$listaHoras["results"][$i]["fecha"]."</td>";
							echo "<td id='medico".$i."'>".$listaHoras["results"][$i]["medico"]["persona"]["nombre"]."  </td>";
							echo "<td style='width: 10%;'><button type='button' class='btn btn-default text-right' onclick='seleccionado(id".$i.",hospital".$i.",fecha".$i.",medico".$i.");'>Seleccionar</button></td>";
							echo "</tr>";
							}
						}
						?>
								
							
						</tbody>
					</table>

					<br>
				</div>
			</div>

				<div class="span3" >
					<div class="span1"> 
							<form action="HoraMedicaAps" method="POST">
							<div hidden>
								<input type="text" name="idPaciente"
									value="<?php echo $idPaciente; ?>" />
							</div>
								<button type="submit" class="btn btn-success">Ver Horas
									APS</button>
							</form>
					</div>
					<div class="span1">
							<form action="HoraMedicaControl" method="POST">
							<div hidden>
								<input hidden type="text" name="idPaciente"
									value="<?php echo $idPaciente; ?>" /> 
							</div>
								<button type="submit" class="btn btn-success">ver Horas
									Control</button>
							</form>
					</div>	
				</div>
				

			</div>


			<br>
			<div class="row">
			<div class="span8 well well-long ">

				<div class="controls">
					<form method="post" id="formAbrirHora"
						hidden>
						<h2>Opción seleccionada</h2>
						<div class="controls">
							
						
							<div hidden>
								<input type="text" class="form-control" id="idHora" hidden
									name="idHora"> <input type="text"
									class="form-control" id="idPaciente" hidden name="idPaciente" value="<?php echo $idPaciente; ?>">
							</div>
						
							<div class="controls ">
								<label class="span2" for="exampleInputEmail1">Establecimiento:</label>
								
								 <input
									type="text" class="span6" id="nHospital" disabled>
							</div>
							
							<div class="controls ">
								<label class="span2" for="exampleInputEmail1">Fecha:</label> <input
											type="text" class="span6" id="fechaHora" disabled>
							</div>
							<div class="controls ">
								<label class="span2" for="exampleInputEmail1">Médico:</label> <input
											type="text" class="span6" id="nMedico" disabled>
							</div>
						</div>	
						<div class="controls">
							<div class="text-right">
								<button type="submit" name="detalleHora" class="btn btn-success ">Ver
									detalle</button>
							</div>
						</div>

					</form>
				</div>
			</div>
			</div>
		
			<div class="row">
				<div class="text-right">
					<a href="listaPacientes" class="btn btn-default ">Volver</a>
				</div>
			</div>
	</div>
	</div>
	