
<?php
$fecha="";
$tipoHora="";
$medico="";
$especialidad="";
$box="";
$nombreHospital="";
if(isset($idHoraMedica)){

	$jsonHoraMedica=Yii::app()->cliente->obtenerHoraMedica($idHoraMedica);
	echo $jsonHoraMedica;
	if(strcmp($jsonHoraMedica,"{\"results\":[]}") !== 0){
		$hora=json_decode($jsonHoraMedica,TRUE);
		var_dump($hora);
		$fecha=$hora["results"][0]["fecha"];
		$tipoHora=$hora["results"][0]["asp"];
		$medico=$hora["results"][0]["medico"]["persona"]["nombre"];
		if(isset($hora["results"][0]["medico"]["persona"]["apellidos"])){
	    	$medico= $medico." ".$hora["results"][0]["medico"]["persona"]["apellidos"];
		}
		$especialidad=$hora["results"][0]["medico"]["especialidad"]["nombre"];
		$box=$hora["results"][0]["box"]["nroHabitacion"];
		$nombreHospital=$hora["results"][0]["box"]["establecimiento"]["nombre"];
		if(strcmp($tipoHora,"true")!==0){
			$tipoHora="Control";
		}else{
			$tipoHora="APS";
		}
	}
}


?>

<div class="container">
	<div class="jumbotron">
		<center>
			<h2>Detalle Hora Médica</h2>
		</center>
		<br>
		<div class="row">
			<div class="well well-long span11">
				<div class="controls" >
					<div class="span5" >
						<center>
							<h3>
								<b>Hora Médica</b>
							</h3>
						</center>
						<div class="controls">
							<label class="span2" for="fecha"><b>Fecha y
								hora:</b></label>							
							<input type="text" class="span2" id="fecha"
									placeholder="Fecha y Hora" disabled value="<?php echo $fecha; ?>">
						</div>
						<div class="controls">
							<label class="span2" for="tipo"><b>Tipo de
								hora:</b></label>
							
							<input type="text" class="span2" id="tipo"
									placeholder="Tipo de hora médica" disabled value="<?php echo $tipoHora; ?>">
						</div>
					</div>
				</div>		
				<div class="controls">
					<div class="span5" >	
						<center>
							<h3>
								<b>Médico</b>
							</h3>
						</center>
						<div class="controls">
							<label class="span2" for="medico"><b>Médico:</b></label>
							<input type="text" class="span3" id="medico"
									placeholder="Médico" disabled value="<?php echo $medico; ?>">
						</div>
						<div class="controls">
							<label class="span2" for="especialidad"><b>Especialidad:</b></label>
							<input type="text" class="span3" id="especialidad"
									placeholder="Especialidad" disabled value="<?php echo $especialidad; ?>">
						</div>
					</div>	
				</div>					
			</div>			
		</div>

		<div class="row">
			<div class="well well-long span11">
				<div class="controls" >
					<div class="span5"  >
						<center>
							<h3>
								<b>Establecimiento</b>
							</h3>
						</center>
						<div class="controls">
							<label class="span2" for="box"><b>Box:</b></label>							
							<input type="text" class="span3" id="box"
									placeholder="número del box" disabled value="<?php echo $box; ?>">
						</div>
						<div class="controls">
							<label class="span2" for="hospital"><b>Nombre
								Hospital:</b></label>
							<input type="text" class="span3" id="hospital"
									placeholder="Nombre del hospital" disabled value="<?php echo $nombreHospital; ?>">
						</div>
					</div>
				</div>
				<div class="controls">						
					<div class="span5">
						<center>
							<h3>
								<b>Opciones</b>
							</h3>
							<form class="form-horizontal" method="post" >
								<div hidden>
									<input type="text" class="form-control" id="idHoraMedica"
										name="idHoraMedica" value="<?php echo $idHoraMedica; ?>" /> <input type="text" 
										class="form-control" id="idPaciente" name="idPaciente" value="<?php echo $idPaciente; ?>"/>
								</div>
								<button type="submit" class="btn btn-success">Registrar
									RCE</button>

							</form>
						</center>
					</div>
				</div>
			</div>			
		</div>
		<br>
		<div class="text-right">
			<a href="listaPacientes" class="btn btn-default ">Volver</a>
		</div>
	</div>	
</div>


			
	