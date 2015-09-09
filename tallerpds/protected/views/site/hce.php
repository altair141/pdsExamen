	
<?php
$ficha="";
$establecimiento="";
$estadoCaso="";
$resumen="";
$prestador="";
$fecha="";
$id="";
if(isset($idPaciente)){
$jsonPaciente=Yii::app()->cliente->buscarPacienteBdLocalId($idPaciente);
//echo $jsonPaciente;
$id=$idPaciente;
$paciente=json_decode($jsonPaciente,TRUE);
//var_dump($paciente);
$ficha=$paciente["results"][0]["nroFicha"]." - ".$paciente["results"][0]["nombre"]." ".$paciente["results"][0]["apellidos"];
$jsonHce=Yii::app()->cliente->obtenerHCE($idPaciente);
//echo $jsonHce;
$hce=json_decode($jsonHce,TRUE);
//var_dump($hce);

}

?>
	<div class="container">
		<div class="jumbotron">
			<center>
				<h2>Historial Clínico Electrónico</h2>
				<h2>
					<b><?php echo $ficha; ?> </b>
				</h2>

			</center>
			<br>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>BOX</th>
						<th>FECHA</th>
						<th>PRESTADOR</th>
					
						<th>ESTADO DEL CASO</th>
						<th hidden ></th>
					</tr>
				</thead>
				<tbody>
					<?php
					if(strcmp($jsonHce,"{\"results\":[]}")!==0){
						
						for($i=0;$i<count($hce["results"]);$i++){

							$establecimiento="";
							$estadoCaso="";
							$resumen="";
							$prestador="";
							$fecha="";
							$idRce="";
						
							$estadoCaso=$hce["results"][$i]["tipoEncuentro"];
							$horaId=$hce["results"][$i]["idHoraMedica"]["id"];
							$idRce=$hce["results"][$i]["idRce"];
							$idHo=$horaId."";
							if(isset($idPaciente)){
								if(strcmp($idHo,"0")!==0){	
									$hora=Yii::app()->cliente->obtenerHoraMedica($idHo);							
										if(isset($hora)){
											$horajson=json_decode($hora,TRUE);
											//var_dump($horajson);
												if(isset($horajson)){
													$fecha=$horajson["results"][0]["fecha"];
													$establecimiento=$horajson["results"][0]["box"]["nroHabitacion"];
													$prestador=$horajson["results"][0]["medico"]["nombre"];
													if(isset($horajson["results"][0]["medico"]["apellidos"])){
														$prestador=$prestador." ".$horajson["results"][0]["medico"]["apellidos"];
													}	
												}
										}
								}			
							}
							
							
					echo "<tr>";
					echo "<td>".$establecimiento."</td>";
					echo "<td>".$fecha."</td>";
					echo "<td>".$prestador."</td>";
				
					echo "<td>".$estadoCaso."</td>";
					echo '<td><form  method="post" id="formAbrirRCE"><div hidden><input hidden type="text" name="idRce" value="'.$idRce.'"><input hidden type="text" name="idPaciente" value="'.$idPaciente.'"></div><button type="submit" name="abrirRce" class="btn btn-success text-right"> Abrir RCE</button></form></td>	';
					echo "</tr>";
				}
				}
					?>
				</tbody>
			</table>

			<div class="text-right">
				<a href="listaPacientes" class="btn btn-default ">Volver</a>
			</div>
		</div>
	</div>