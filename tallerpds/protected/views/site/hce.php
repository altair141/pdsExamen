	
<?php
$ficha="";
$establecimiento="";
$estadoCaso="";
$resumen="";
$prestador="";
$fecha="";
if(isset($idPaciente)){
$jsonPaciente=Yii::app()->cliente->buscarPacienteBdLocalId($idPaciente);
//echo $jsonPaciente;
$paciente=json_decode($jsonPaciente,TRUE);
//var_dump($paciente);
$ficha=$paciente["results"][0]["nroFicha"];
$jsonHce=Yii::app()->cliente->obtenerHCE($idPaciente);
echo $jsonHce;
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
						<th>ESTABLECIMIENTO</th>
						<th>FECHA</th>
						<th>PRESTADOR</th>
						<th>RESUMEN</th>
						<th>ESTADO DEL CASO</th>
					</tr>
				</thead>
				<tbody>
					<?php
					if(strcmp($jsonHce,"{\"results\":[]}")!==0){
						var_dump($hce);
						for($i=0;$i<count($hce["results"]);$i++){
							$establecimiento="";
							$estadoCaso="";
							$resumen="";
							$prestador="";
							$fecha="";
							$horaId="";
							$resumen=$hce["results"][$i]["idDiagnostico"]["nombre"];
							$estadoCaso=$hce["results"][$i]["tipoEncuentro"];
							$horaId=$hce["results"][$i]["idHoraMedica"];
							$idHo=$horaId."";
							var_dump($idHo);
					echo "<tr>";
					echo "<td><%=establecimiento%></td>";
					echo "<td><%=fecha%></td>";
					echo "<td><%=medico%></td>";
					echo "<td>".$resumen."</td>";
					echo "<td>".$estadoCaso."</td>";
					echo "<td></td>";
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