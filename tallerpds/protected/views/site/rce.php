
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
$idHoraMedica="";
if(isset($idHoraMedica)){
//echo $idHoraMedica;
}
date_default_timezone_set("America/Argentina/Buenos_Aires" ) ; 
$horas = date('h:i a',time() - 3600*date('I')); 
$diagnostico=Yii::app()->cliente->obtenerListaDiagnosticos();
$actividades=Yii::app()->cliente->obtenerListaActividades();
$procedimientos =Yii::app()->cliente->obtenerListaProcedimientos();
$jsonDiagnostico=json_decode($diagnostico,TRUE);
$jsonActividades=json_decode($actividades,TRUE);
$jsonProcedimientos=json_decode($procedimientos,TRUE);
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

					
						<button type="button" class="btn btn-success" data-toggle="modal"
							data-target="#exampleModal" data-whatever="@fat">Ver
							historial Clínico</button>
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
			<div hidden>
				<input type="text" name="idhce" value="<?php echo $idHce ?>" hidden> <input
					type="text" name="idHoraMedica" value="<?php echo $idHoraMedica; ?>" hidden>
					</div>
				<div class="well well-long">

				<br>
				<ul class="nav nav-tabs">

					<li role="presentation" class="active"><a href="#">REGISTRO
							CLÍNICO</a></li>

				</ul>

				<br>

				<div class="row">
					<div class="span5">
						<textarea  class="span5" rows="3" placeholder="ANAMNESIS"
							name="anamnesis"></textarea>

					</div>
					<div class="span5">
						<textarea class="span6" rows="3" placeholder="ALERGIAS"
							name="alergias"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="span5">
						<textarea class="span5" rows="3"
							placeholder="EXAMEN FÍSICO" name="examenFisico"></textarea>

					</div>
					<div class="span6">
						<textarea class="span6" rows="3"
							placeholder="INDICACIÓN MÉDICA" name="indicaMedica"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="span5">
						<textarea class="span5" rows="3"
							placeholder="INDICACIÓN CIERRE CASO CLÍNICO"
							name="indicaCierreCasoClinico"></textarea>

					</div>
				
					<div class="span6">
						<textarea class="span6" rows="3"
							placeholder="HIPÓTESIS DIAGNOSTICO" name="hipoDiagnostico"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="span6">
						
						<select class="span4" id="selecdiag" name="diagnostico">
							<option hidden value="0">Diagnosticos</option>
							<?php if(isset($jsonDiagnostico)): ?>
								<?php for($i=0;$i<count($jsonDiagnostico["results"]);$i++): ?>
									<?php $iddiagnostico=$jsonDiagnostico["results"][$i]["id"]; 
										  $nombrediagnostico=$jsonDiagnostico["results"][$i]["nombre"]; 
									?>
							<option value="<?php echo $iddiagnostico?>"><?php echo $nombrediagnostico ?></option>
								<?php endfor; ?>
						<?php endif;?>
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
						
						<div class="radio inline">
							<label class="radio inline"><b>Paciente GES:</b> </label>
							<label class="radio inline"> <input
								type="radio" name="paciGESradio" value="si">si
							</label> <label class="radio inline"><input type="radio"
								name="paciGESradio" value="no">no</label>
						</div>
						<div class="radio inline">
							<label class="radio inline"><b>Patología GES:</b></label> <label class="radio inline"><input
								type="radio" name="patoloGESradio" value="si">si</label> <label
								class="radio inline"><input type="radio"
								name="patoloGESradio" value="no">no</label>
						</div>
						
						<div class="radio inline">
							<label class="radio inline"><b>Paciente Crónico:</b></label>
							 <label class="radio inline"><input
								type="radio" name="paciCroniradio" value="si">si
							</label> <label class="radio inline"><input type="radio"
								name="paciCroniradio" value="no">no</label>
						</div>
						<div class="radio inline">Validez:</div>

						<div class="clearfix visible-lg"></div>

						<div class="col-lg-11">
							<br>
							<textarea class="span5" rows="3"
								placeholder="RECETA EN MODO TEXTO" name="receta"></textarea>
						</div>
					</div>
					<div class="span5">
						<div class="span5">
							<b>Certificados</b>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-11" style="overflow: scroll; height: 200px;">
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									value="1" name="certialcoholemiaradio">sí</label> <label
									class="radio inline"><input type="radio"
									name="certialcoholemiaradio" value="2">No Alcoholemia</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certivfamiliarradio" value="3">sí</label> <label
									class="radio inline"><input type="radio"
									name="certivfamiliarradio" value="4">No V.
									Intrafamiliar</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certidrogasradio" value="5">sí</label> <label
									class="radio inline"><input type="radio"
									name="certidrogasradio" value="6">No Drogas</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certilecionesradio" value="7">sí</label> <label
									class="radio inline"><input type="radio"
									name="certilecionesradio" value="8">No Lesiones</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certisuicidioradio" value="9">sí</label> <label
									class="radio inline"><input type="radio"
									name="certisuicidioradio" value="10">No Suicidio</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certianimalradio" value="11">sí</label> <label
									class="radio inline"><input type="radio"
									name="certianimalradio" value="12">No Animal</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certiotrosradio" value="13">sí</label> <label
									class="radio inline"><input type="radio"
									name="certiotrosradio" value="14">No Otros ML</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certivgeneroradio" value="15">sí</label> <label
									class="radio inline"><input type="radio"
									name="certivgeneroradio" value="16">No V. Género</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certisaludcompatibleradio" value="17">sí</label> <label
									class="radio inline"><input type="radio"
									name="certisaludcompatibleradio" value="18">No Salud
									Compatible</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio inline"><input type="radio"
									name="certiatenciondiagnosticoradio" value="19">sí</label> <label
									class="radio inline"><input type="radio"
									name="certiatenciondiagnosticoradio" value="20">No
									Atención Diagnóstica</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio inline"><input type="radio"
									name="certiatencionprofecionalradio" value="21">sí</label> <label
									class="radio inline"><input type="radio"
									name="certiatencionprofecionalradio" value="22">No
									Atención Profesional</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio inline"><input type="radio"
									name="certiderivacioninternaradio" value="23">sí</label> <label
									class="radio inline"><input type="radio"
									name="certiderivacioninternaradio" value="24">No
									Derivación Interna</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certicitacionkntradio" value="25">sí</label> <label
									class="radio inline"><input type="radio"
									name="certicitacionkntradio" value="26">No Citacion a
									KNT</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certiordencuracionradio" value="27">sí</label> <label
									class="radio inline"><input type="radio"
									name="certiordencuracionradio" value="28">No Orden
									Curación</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio inline"><input type="radio"
									name="certiordencitacionradio" value="29">sí</label> <label
									class="radio inline"><input type="radio"
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
						<div class="span6 ">
							<div class="input group">
								<span class="input-group-addon">Buscar Actividades:</span> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="span6">
							<select class="span4" id="actividades" name="actividad">
								<option hidden value="0">Actividades</option>
								<?php if(isset($jsonActividades)): ?>
								<?php for($i=0;$i<count($jsonActividades["results"]);$i++): ?>
									<?php $idActividad=$jsonActividades["results"][$i]["id"]; 
										  $nombreActividad=$jsonActividades["results"][$i]["nombreActividad"]; 
										  $iddiag=$jsonActividades["results"][$i]["diagnostico"]["id"];
									?>
								<option value="<?php echo $iddiag?>.<?php echo $idActividad?>"><?php echo $nombreActividad?></option>
									<?php endfor; ?>
								<?php endif; ?>
							</select>
						</div>

					</div>
					<div class="span5">



						<div class="span5">
							<b>Procedimientos</b>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="span5">
							<div class="input group">
								<span class="input-group-addon">Buscar Procedimientos:</span> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="span5">
							<select class="span4" id="procedimientos"
								name=procedimiento>
								<option hidden value="0">Procedimientos</option>
								<?php if(isset($jsonProcedimientos)): ?>
								<?php for($i=0;$i<count($jsonProcedimientos["results"]);$i++): ?>
									<?php $idproce=$jsonProcedimientos["results"][$i]["id"]; 
										  $nombreproce=$jsonProcedimientos["results"][$i]["nombre"]; 
										  $iddiag=$jsonProcedimientos["results"][$i]["diagnostico"]["id"];
									?>
								<option value="<?php echo $iddiag?>.<?php echo $idproce?>"><?php echo $nombreproce?></option>
								<?php endfor; ?>
								<?php endif; ?>
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
						<select class="span6" id="tipoCierre" name="tipoCierre">
							<option value="0">...</option>
							<option value="Con atención">Con atención</option>
							<option value="No se atendio">No se atendio</option>
							<option value="No asiste">No asiste</option>
						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Destino:</div>
					<div class="span8">
						<select class="span6" id="destino" name="destino">
							<option value="0">...</option>
							<option value="Domicilio">Domicilio</option>
							<option value="Internado">Internado</option>

						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Fecha Atención:</div>
					<div class="span8">
						<input type="date" class="form-control" name="fechaAtencion"
							max="2015-08-12">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Hora Inicio Atención:</div>
					<div class="span8">
						<input type="time" class="form-control" name="horaInicioAtencion">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Fecha Cierre Clínico:</div>
					<div class="span8">
						<input type="date" class="form-control" name="fechaCierreClinico">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Hora Cierre Clínico:</div>
					<div class="span8">
						<input type="time" class="form-control" name="horaCierreCLinico">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span2">Tiempo Control:</div>
					<div class="span8">
						<select class="span6" id="tiempoControl"
							name="tiempoControl">
							<option value="0">...</option>
							<option value="No corresponde">No corresponde</option>
							<option value="proxima visita">Proxima visita</option>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="span6">
						<b>Realice el Cierre Administrativo al realizar el Cierre
							Clínico</b>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="span3">Realizar Cierre Administrativo:</div>
					<div class="span3">
						<label class="radio inline"><input type="radio"
							name="cierreAdmin" value="CIERRE ADMINISTRATIVO">sí</label> <label
							class="radio inline"><input type="radio"
							name="cierreAdmin" value="CATEGORIZADO">No</label>
					</div>


				</div>
				<br>
				<div class="row">
					<div class="span2">

						<input hidden name="idPaciente" class="idPaciente">
						<button class="btn btn-success" name="rceGuardar" type="submit">GRABAR</button>

					</div>
					<div class="span2">

						<input hidden name="idPaciente" class="idPaciente"> <input
							class="btn btn-default" type="reset" value="LIMPIAR">

					</div>

				</div>
				</div>
			</form>







		</div>
	</div>


	<div>


		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">Totas las
							atenciones</h4>
					</div>
					<div class="modal-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ESTABLECIMIENTO</th>
									<th>FECHA</th>
									<th>PRESTADOR</th>
									<th>RESUMEN</th>
									<th>ESTADO DEL CASO</th>
								</tr>
							</thead>
							<tbody>
								<%
									String matriz[][] = new String[5][5];//TransformarJson.hce(hce);

									for (int i = 0; i < matriz[0].length; i++) {
								%>
								<tr>
									<td><%=matriz[0][i]%></td>
									<td><%=matriz[1][i]%></td>
									<td><%=matriz[2][i]%></td>
									<td><%=matriz[4][i]%></td>
									<td><%=matriz[3][i]%></td>

								</tr>
								<%
									}
								%>

							</tbody>
						</table>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div>
	</div>						
