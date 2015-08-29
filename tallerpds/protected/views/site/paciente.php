<?php
$this->pageTitle=Yii::app()->name ;

?>

<!-- copiar lo mismo de listaPacientes.jsp-->

<?php 
$jsonPersona="";
$nombre="";
$apellido="";
$fechaNaci="";
$direccion="";
$ficha="";

if(isset($uuid)){
$jsonPersona=Yii::app()->cliente->buscarPacienteBdLocalId($uuid);
//echo ($jsonPersona);
$paciente=json_decode($jsonPersona,TRUE);
//var_dump($paciente);
$nombre=$paciente["results"][0]["persona"]["nombre"];
$apellido=$paciente["results"][0]["persona"]["apellidos"];
$fechaNaci=$paciente["results"][0]["persona"]["fechaNacimiento"];
$direccion=$paciente["results"][0]["persona"]["direccion"];
$ficha=$paciente["results"][0]["nroFicha"];
$id=$paciente["results"][0]["id"];
}


?>

<div class="container">
		<div class="jumbotron">
			
			<br>
			
				<div class="span7" >
				<center>
				<h2>Detalles del Paciente</h2>

			</center>
					<div class="well well-long span6">
						<div class="controls ">
							<label class="span2" for="nombre"><b>Nombres:</b></label>
								
							<input type="text" class="span4" id="nombre"
										placeholder="nombre del paciente" disabled value="<?php echo $nombre; ?>">
						</div>
						<div class="controls">
							<label class="span2" for="apellidos"><b>Apellidos:</b></label>
						
								<input type="text" class="span4" id="apellidos"
									placeholder="apellidos del paciente" disabled value="<?php echo $apellido; ?>">
						</div>
						
						<div class="controls">
							<label class="span2" for="direccion"><b>Dirección:</b></label>
							
							<input type="text" class="span4" id="direccion"
									placeholder="dirección del paciente" disabled value="<?php echo $direccion; ?>">
						</div>
						<div class="controls ">
							<label class="span2" for="fichaClinica"><b>Ficha
								Clínica:</b></label>
							
							<input type="text" class="span4" id="fichaClinica"
									placeholder="ficha clínica del paciente" disabled value="<?php echo $ficha; ?>">
						</div>
						<div class="controls ">
						<label class="span2" for="fechaNacimiento"><b>Fecha
								de nacimiento:</b></label>
					
						<input type="text" class="span4" id="fechaNacimiento"
									placeholder="fecha de nacimiento del paciente" disabled value="<?php echo $fechaNaci; ?>">
						</div>
						<div class="text-right">
							<a href="listaPacientes" class="btn btn-default ">Volver</a>
						</div>
					</div>


				</div> 
				<div class="span4" >
				<br><br>
					<!--primera fila de botones -->
				<div class="span2">
					<form method="POST" >
						<div hidden>
							<input  type="text" name="idPaciente" value="<?php echo $id; ?>" />
						</div>
						<button type="submit" name="hora" class="btn btn-success">Ver Horas médicas</button>
					</form>
				</div>
				<div class="span2">	
					<form  method="POST" class="span2">
						<div hidden>
							<input hidden type="text" name="idPaciente" value="<?php echo $id; ?>"/> 
							<input type="text" hidden name="idHoraMedica" value="0" />
						</div>
								<button type="submit" name="rce" class="btn btn-success">Registrar RCE</button>
					</form>
				</div>	
					<!--fin primera fila de botones -->
					<!--segunda fila de botones -->
				<div class="form-inline">
					<center>
						<div class="form-group">
							<form  method="POST">
								<div hidden>
									<input hidden type="text" name="idPaciente" value="<?php echo $id; ?>"/>
								</div>
									<button type="submit" name="hce" class="btn btn-success">Ver HCE</button>
							</form>
						</div>
					</center>
				</div>

			
				</div>
			

		</div>
	</div>