<?php 
$folio="";
if(isset($idPaciente)){
	//echo $idPaciente;
	$idHce=Yii::app()->cliente->obtenerIdHCE($idPaciente);
	$jsonPacien=Yii::app()->cliente->buscarPacienteBdLocalId($idPaciente);
	$pacien=json_decode($jsonPacien,TRUE);
	$folio=$pacien["results"][0]["nroFicha"];
//	echo $idHce;
}
$rce="";
$jsonRce="";
if(isset($idRce)){
	$rce=Yii::app()->cliente->obtenerRcePorId($idRce);
	$jsonRce=json_decode($rce,TRUE);
}
$idHoraMedica="";
if(isset($idHoraMedica)){
//echo $idHoraMedica;
}
date_default_timezone_set("America/Argentina/Buenos_Aires" ) ; 
$horas = date('h:i a',time() - 3600*date('I')); 

date_default_timezone_set("America/Argentina/Buenos_Aires" ) ; 
$tiempo = getdate(time()); 
$dia = $tiempo['wday']; 
$dia_mes=$tiempo['mday']; 
$mes = $tiempo['mon']; 
$year = $tiempo['year']; 
$hora= $tiempo['hours']; 
$minutos = $tiempo['minutes']; 
$segundos = $tiempo['seconds']; 


switch ($dia){ 
case "1": $dia_nombre="Lunes"; break; 
case "2": $dia_nombre="Martes"; break; 
case "3": $dia_nombre="Mi&eacute;rcoles"; break; 
case "4": $dia_nombre="Jueves"; break; 
case "5": $dia_nombre="Viernes"; break; 
case "6": $dia_nombre="S&aacute;bado"; break; 
case "0": $dia_nombre="Domingo"; break; 
} 
switch($mes){ 
case "1": $mes_nombre="Enero"; break; 
case "2": $mes_nombre="Febrero"; break; 
case "3": $mes_nombre="Marzo"; break; 
case "4": $mes_nombre="Abril"; break; 
case "5": $mes_nombre="Mayo"; break; 
case "6": $mes_nombre="Junio"; break; 
case "7": $mes_nombre="Julio"; break; 
case "8": $mes_nombre="Agosto"; break; 
case "9": $mes_nombre="Septiembre"; break; 
case "10": $mes_nombre="Octubre"; break; 
case "11": $mes_nombre="Noviembre"; break; 
case "12": $mes_nombre="Diciembre"; break; 
} 
//echo $dia_nombre." ".$dia_mes." de ".$mes_nombre." de ".$year."  "; ?>
<?php
 //echo  $horas;
			?>

			<?php 

					//echo $dia_nombre." ".$dia_mes." de ".$mes_nombre." de ".$year."  "; ?>
					<?php
 					//echo  $horas?>
				
<div class="container">
		<div class="jumbotron">
<div class="well well-long">
			<div class="row" >

				<div class="span6">
					<b>1.- Datos Atención Urgencia del día</b>


				</div>
				<!-- InicioBotones-->
				<div class="pull-right">
				
					<div  class="span2">
						<form  method="POST">
							<input name="idPersona" hidden class="idPaciente" value="<?php echo $idPaciente; ?>">
							<button enabled class="btn btn-success" type="submit" name="btn">Ver Datos Paciente</button>
						</form>
					</div>
					<div class="span2">
							<form  method="POST">
							<input name="idPaciente" hidden class="idPaciente" value="<?php echo $idPaciente; ?>">
							<button enabled class="btn btn-success" type="submit" name="hce">Ver
							historial Clínico</button>
						</form>
					
						
					</div>
				</div>	
							
							
			</div>



			<!-- finbotones-->
			<br />
			
			<div class="input-group">
				<span class="input-group-addon">Folio Urgencia:</span> <input
					type="text" class="span7" disabled value="<?php echo $folio?>">
				<span class="input-group-addon"></span>
			</div>
			</div>

			<!--      formulario    -->
			<form method="post" >
			
				<div class="well well-long">

				<br>
				<ul class="nav nav-tabs">

					<li role="presentation" class="active"><a href="#">REGISTRO
							CLÍNICO</a></li>

				</ul>

				<br>

				<div class="row">
					<div class="span5">
						<textarea  disabled class="span5" rows="3" placeholder="ANAMNESIS" style="  resize: none;"
							name="anamnesis">
							<?php if(isset($idRce)): ?>
								<?php echo $jsonRce["results"][0]["anamnesis"]; ?>
							<?php endif; ?>	
							</textarea>

					</div>
					<div class="span5">
						<textarea disabled class="span6" rows="3" placeholder="ALERGIAS" style="  resize: none;"
							name="alergias">
							<?php if(isset($idRce)): ?>
								<?php echo $jsonRce["results"][0]["alergia"]; ?>
							<?php endif; ?>	
							</textarea>
					</div>
				</div>
				<div class="row">
					<div class="span5">
						<textarea style="  resize: none;" disabled class="span5" rows="3"
							placeholder="EXAMEN FÍSICO" name="examenFisico">
							<?php if(isset($idRce)): ?>
								<?php echo $jsonRce["results"][0]["examenFisico"]; ?>
							<?php endif; ?>	
							</textarea>
						

					</div>
					<div class="span6">
						<textarea style="  resize: none;" disabled class="span6" rows="3"
							placeholder="INDICACIÓN MÉDICA" name="indicaMedica">
							<?php if(isset($idRce)): ?>
								<?php echo $jsonRce["results"][0]["indicacionMedica"]; ?>
							<?php endif; ?>	
							</textarea>
							
					</div>
				</div>
				<div class="row">
					<div class="span5">
						<textarea style="  resize: none;" disabled class="span5" rows="3"
							placeholder="INDICACIÓN CIERRE CASO CLÍNICO"
							name="indicaCierreCasoClinico">
							<?php if(isset($idRce)): ?>
								<?php echo $jsonRce["results"][0]["indicacionCierreCaso"]; ?>
							<?php endif; ?>	
							</textarea>

					</div>
				
					<div class="span6">
						<textarea style="  resize: none;" disabled class="span6" rows="3"
							placeholder="HIPÓTESIS DIAGNOSTICO" name="hipoDiagnostico">
							<?php if(isset($idRce)): ?>
								<?php echo $jsonRce["results"][0]["hipotesisDiagnostico"]; ?>
							<?php endif; ?>	
							</textarea>
					</div>
				</div>
				<div class="row">
					<div class="span6">
						
						<select disabled class="span4" id="selecdiag" name="diagnostico">
							<?php if(isset($idRce)): ?>
								<?php $idDiag=Yii::app()->cliente->obtenerDiagnosticoporId($jsonRce["results"][0]["idDiagnostico"]["id"]);
								$nombre= json_decode($idDiag,TRUE);
								 $diagnosticoNombre=$nombre["results"][0]["nombre"];
								  ?>
							<?php endif; ?>	

							<option hidden value="0"><?php echo $diagnosticoNombre; ?></option>
							
						</select>
					</div>
					<div class="col-lg-6">Sin Detalle GES Cita Actual</div>
				</div>
				<div class="row">
					<div class="span6">
					<br>
						<div class="span6">
							<b>Receta</b>
						</div>
						<div class="clearfix visible-lg"></div>

						<div class="col-lg-7">
							<b>Tipo Paciente y Tipo Medicamento</b>
						</div>
						<?php 
						$pacienteGes=$jsonRce["results"][0]["pacienteGes"];
						$patologiaGes=$jsonRce["results"][0]["patologiaGes"];
						$pacienteCronico=$jsonRce["results"][0]["pacienteCronico"];
						?>
						<div class="radio inline">
							<label class="radio inline"><b>Paciente GES:</b> </label>
							<label class="radio inline"> <input <?php if($pacienteGes=="si"):?>checked<?php endif;?>
								type="radio" name="paciGESradio" value="si">si
							</label> <label class="radio inline"><input type="radio" <?php if($pacienteGes=="no"):?>checked<?php endif;?>
								name="paciGESradio" value="no">no</label>
						</div>
						<div class="radio inline">
							<label class="radio inline"><b>Patología GES:</b></label> <label class="radio inline"><input <?php if($patologiaGes=="si"):?>checked<?php endif;?>
								type="radio" name="patoloGESradio" value="si">si</label> <label
								class="radio inline"><input type="radio" <?php if($patologiaGes=="no"):?>checked<?php endif;?>
								name="patoloGESradio" value="no">no</label>
						</div>
						
						<div class="radio inline">
							<label class="radio inline"><b>Paciente Cronico:</b></label>
							 <label class="radio inline"><input <?php if($pacienteCronico=="si"):?>checked<?php endif;?>
								type="radio" name="paciCroniradio" value="si">si
							</label> <label class="radio inline"><input type="radio" <?php if($pacienteCronico=="no"):?>checked<?php endif;?>
								name="paciCroniradio" value="no">no</label>
						</div>
						<div class="radio inline">Validez:</div>

						<div class="clearfix visible-lg"></div>

						<div class="col-lg-11">
							<br>
							<textarea style="  resize: none;" disabled class="span5" rows="3"
								placeholder="RECETA EN MODO TEXTO" name="receta">
								<?php if(isset($idRce)): ?>
								<?php echo $jsonRce["results"][0]["receta"]; ?>
								<?php endif; ?>	
							</textarea>
								</textarea>
						</div>
					</div>
					<div class="span5">
						<div class="span5">
							<b>Certificados</b>
						</div>


						<?php 
						
						for($i=0;$i<15;$i++){
							$certificado=$jsonRce["results"][0]["listaCertificados"][$i]["id"];
							if($certificado=="1"||$certificado=="2"){
				                $certificado1=$certificado;
				            }elseif($certificado=="3"||$certificado=="4"){
				                $certificado2=$certificado;
				            }elseif($certificado=="5"||$certificado=="6"){
				                $certificado3=$certificado;
				            }elseif($certificado=="7"||$certificado=="8"){
				                $certificado4=$certificado;
				            }elseif($certificado=="9"||$certificado=="10"){
				                $certificado5=$certificado;
				            }elseif($certificado=="11"||$certificado=="12"){
				                $certificado6=$certificado;
				            }elseif($certificado=="13"||$certificado=="14"){
				                $certificado7=$certificado;
				            }elseif($certificado=="15"||$certificado=="16"){
				                $certificado8=$certificado;
				            }elseif($certificado=="17"||$certificado=="18"){
				                $certificado9=$certificado;
				            }elseif($certificado=="19"||$certificado=="20"){
				                $certificado10=$certificado;
				            }elseif($certificado=="21"||$certificado=="22"){
				                $certificado11=$certificado;
				            }elseif($certificado=="23"||$certificado=="24"){
				                $certificado12=$certificado;
				            }elseif($certificado=="25"||$certificado=="26"){
				                $certificado13=$certificado;
				            }elseif($certificado=="27"||$certificado=="28"){
				                $certificado14=$certificado;
				            }elseif ($certificado=="29"||$certificado=="30"){
				                $certificado15=$certificado;
				            }  
						}

										
						?>


						<div class="clearfix visible-lg"></div>
						<div class="col-lg-11" style="overflow: scroll; height: 200px;">
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado1=="1"):?>checked<?php endif;?>
									value="1" name="certialcoholemiaradio">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado1=="2"):?>checked<?php endif;?>
									name="certialcoholemiaradio" value="2">No Alcoholemia</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado2=="3"):?>checked<?php endif;?>
									name="certivfamiliarradio" value="3">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado2=="4"):?>checked<?php endif;?>
									name="certivfamiliarradio" value="4">No V.
									Intrafamiliar</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado3=="5"):?>checked<?php endif;?>
									name="certidrogasradio" value="5">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado3=="6"):?>checked<?php endif;?>
									name="certidrogasradio" value="6">No Drogas</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado4=="7"):?>checked<?php endif;?>
									name="certilecionesradio" value="7">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado4=="8"):?>checked<?php endif;?>
									name="certilecionesradio" value="8">No Lesiones</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado5=="9"):?>checked<?php endif;?>
									name="certisuicidioradio" value="9">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado5=="10"):?>checked<?php endif;?>
									name="certisuicidioradio" value="10">No Suicidio</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado6=="11"):?>checked<?php endif;?>
									name="certianimalradio" value="11">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado6=="12"):?>checked<?php endif;?>
									name="certianimalradio" value="12">No Animal</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado7=="13"):?>checked<?php endif;?>
									name="certiotrosradio" value="13">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado7=="14"):?>checked<?php endif;?>
									name="certiotrosradio" value="14">No Otros ML</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado8=="15"):?>checked<?php endif;?>
									name="certivgeneroradio" value="15">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado8=="16"):?>checked<?php endif;?>
									name="certivgeneroradio" value="16">No V. Género</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado9=="17"):?>checked<?php endif;?>
									name="certisaludcompatibleradio" value="17">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado9=="18"):?>checked<?php endif;?>
									name="certisaludcompatibleradio" value="18">No Salud
									Compatible</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio inline"><input type="radio" <?php if($certificado10=="19"):?>checked<?php endif;?>
									name="certiatenciondiagnosticoradio" value="19">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado10=="20"):?>checked<?php endif;?>
									name="certiatenciondiagnosticoradio" value="20">No
									Atención Diagnóstica</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio inline"><input type="radio" <?php if($certificado11=="21"):?>checked<?php endif;?>
									name="certiatencionprofecionalradio" value="21">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado11=="22"):?>checked<?php endif;?>
									name="certiatencionprofecionalradio" value="22">No
									Atención Profesional</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio inline"><input type="radio" <?php if($certificado12=="23"):?>checked<?php endif;?>
									name="certiderivacioninternaradio" value="23">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado12=="24"):?>checked<?php endif;?>
									name="certiderivacioninternaradio" value="24">No
									Derivación Interna</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado13=="25"):?>checked<?php endif;?>
									name="certicitacionkntradio" value="25">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado13=="26"):?>checked<?php endif;?>
									name="certicitacionkntradio" value="26">No Citacion a
									KNT</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado14=="27"):?>checked<?php endif;?>
									name="certiordencuracionradio" value="27">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado14=="28"):?>checked<?php endif;?>
									name="certiordencuracionradio" value="28">No Orden
									Curación</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio" <?php if($certificado15=="29"):?>checked<?php endif;?>
									name="certiordencitacionradio" value="29">sí</label> <label
									class="radio inline"><input type="radio" <?php if($certificado15=="30"):?>checked<?php endif;?>
									name="certiordencitacionradio" value="30">No Orden
									Citación</label>
							</div>

						</div>
					</div>
				</div>
				
				<script>
					$(function() {
						$("#selecdiag").change(function() {
							$("#procedimientos").prop('selectedIndex',0);
							$('#actividades').prop('selectedIndex',0);
							mostrarActividadPorDiagnostico();
							mostrarProcedimientoPorDiagnostico();
						});
					});
					//idem a la funcion de abajo
					function mostrarProcedimientoPorDiagnostico() {
						var valor = $("#selecdiag").val();

						var largolista = document
								.getElementById("procedimientos");
						$("#procedimientos option").each(function() {
							var diagActi = $(this).attr("value");
							var idActi = diagActi.split(".");
							
							if (idActi[0] === valor) {
								$(this).show();
							} else {
								$(this).hide();
							}

						});

					}
					function mostrarActividadPorDiagnostico() {
						
						//obtiene el valor de la etiqueta del diagnostico
						var valor = $("#selecdiag").val();
						//se selecciona la etiqueta correspondiente al select
						var largolista = document.getElementById("actividades");
					
						//recorre la lista de opciones
						$("#actividades option").each(function() {

							var diagActi = $(this).attr("value");
							var idActi = diagActi.split(".");
							
							if (idActi[0] === valor) {
								$(this).show();
							} else {
								$(this).hide();
							}

						});

					}
				</script>
				<br>
				<div class="row">
					<div class="span6">

						<div class="span6">
							<b>Actividades</b>
						</div>
						<div class="clearfix visible-lg"></div>
						
						<div class="clearfix visible-lg"></div>
						<div class="span6">
							<select disabled class="span4" id="actividades" name="actividad">
							<?php if(isset($idRce)): ?>
								<?php $idActi=Yii::app()->cliente->obtenerActividadporId($jsonRce["results"][0]["idActividad"]["id"]);
								$nombreA= json_decode($idActi,TRUE);
								 $actividadNombre=$nombreA["results"][0]["nombreActividad"];
								  ?>
							<?php endif; ?>	
								<option hidden value=""><?php echo $actividadNombre ?></option>
								
							</select>
						</div>

					</div>
					<div class="span5">



						<div class="span5">
							<b>Procedimientos</b>
						</div>
						
						<div class="clearfix visible-lg"></div>
						<div class="span5">
							<select disabled class="span4" id="procedimientos"
								name=procedimiento>
									<?php if(isset($idRce)): ?>
								<?php $idProce=Yii::app()->cliente->obtenerProcedimientosporId($jsonRce["results"][0]["idProcedimiento"]["id"]);
								$nombreP= json_decode($idProce,TRUE);
								 $proceNombre=$nombreP["results"][0]["nombre"];
								  ?>
							<?php endif; ?>	
								<option hidden value="0"><?php echo $proceNombre?></option>
								
							</select>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="span12">
						<b>Cierre Caso</b>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Tipo Cierre Clínico:</div>
					<div class="span8">
						<select disabled class="span6" id="tipoCierre" name="tipoCierre">
							<?php if(isset($idRce)): ?>
								<option value="0"><?php echo $jsonRce["results"][0]["tipoCierre"]; ?></option>
							<?php endif; ?>	
						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Destino:</div>
					<div class="span8">
						<select disabled class="span6" id="destino" name="destino">
							<?php if(isset($idRce)): ?>
								<option value="0"><?php echo $jsonRce["results"][0]["destino"]; ?></option>
							<?php endif; ?>	
							

						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Fecha Atención:</div>
					<div class="span8">
					<?php $fechaIni="";
					if(isset($idRce)): ?>
								<?php $fechaIni= $jsonRce["results"][0]["fechaAtencion"]; ?>
							<?php endif; ?>
						<input disabled type="text" value="<?php echo $fechaIni?>" class="form-control" name="fechaAtencion"
							>

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Hora Inicio Atención:</div>
					<div class="span8">
					<?php $horaIni="";
					if(isset($idRce)): ?>
								<?php $horaIni= $jsonRce["results"][0]["horaInicioAtencion"]; ?>
							<?php endif; ?>
						<input disabled type="text" value="<?php echo $horaIni?>" class="form-control" name="horaInicioAtencion">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Fecha Cierre Clínico:</div>
					<div class="span8">
					<?php $fechaCi="";
					if(isset($idRce)): ?>
								<?php $fechaCi= $jsonRce["results"][0]["fechaCierreClinico"]; ?>
							<?php endif; ?>
						<input disabled type="text" value="<?php echo $fechaCi?>" class="form-control" name="fechaCierreClinico">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Hora Cierre Clínico:</div>
					<div class="span8">
					<?php $horaCi="";
					if(isset($idRce)): ?>
								<?php $horaCi= $jsonRce["results"][0]["horaCierreClienico"]; ?>
							<?php endif; ?>
						<input disabled type="text" class="form-control" value="<?php echo $horaCi?>" name="horaCierreCLinico">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Tiempo Control:</div>
					<div class="span8">
						<select disabled class="span6" id="tiempoControl"
							name="tiempoControl">
							<?php if(isset($idRce)): ?>
								<option value="0"><?php echo $jsonRce["results"][0]["tiempoControl"]; ?></option>
							<?php endif; ?>	
							
						</select>
					</div>
				</div>
				<br>
				<div class="row">

				<?php 
				$tipoEncuentro=$jsonRce["results"][0]["tipoEncuentro"];

				?>
					<div class="span6">
						<b>Realice el Cierre Administrativo al realizar el Cierre
							Clínico</b>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span3">Realizar Cierre Administrativo:</div>
					<div class="span3">
						<label class="radio inline"><input type="radio" <?php if($tipoEncuentro=="CIERRE ADMINISTRATIVO"):?>checked<?php endif;?>
							name="cierreAdmin" value="CIERRE ADMINISTRATIVO">sí</label> <label
							class="radio inline"><input type="radio" <?php if($tipoEncuentro=="CATEGORIZADO"):?>checked<?php endif;?>
							name="cierreAdmin" value="CATEGORIZADO">No</label>
					</div>


				</div>
				<br>
				<div class="row">
					<div class="col-lg-2">
	
						
					</div>
					<div class="text-right" >

					<input name="idPaciente" hidden  class="idPaciente" value="<?php echo $idPaciente?>">
					<button type="button" onclick="myFunction()" class="btn btn-primary">Imprimir</button>
					<input type="submit" class="btn btn-default" value="volver">
					</div>

				</div>

				</div>
			</form>

		</div>
	</div>
<script>
function myFunction() {
    window.print();
}
</script>