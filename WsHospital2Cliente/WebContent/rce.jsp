<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RCE</title>

<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/formulario.js"></script>
<script src="js/gestionDatos.js"></script>
<link href="css/default.css" rel="stylesheet">

</head>
<body>


	<%
		String folio = "";//request.getAttribute("display").toString();
		String idhce = "";// request.getAttribute("idHce").toString();
		String idHoraMedica = "";
		String id="0";
		try{
			folio=request.getAttribute("paciente").toString();
			idhce=request.getAttribute("hce").toString();
			idHoraMedica=request.getParameter("idHoraMedica");
			id=request.getParameter("idPaciente");
		}catch(NullPointerException e){
			
		}
	%>
	<div class="container">
		<div class="jumbotron">

			<div class="row">
				<div class="col-lg-8">
					<b>1.- Datos Atención Urgencia del día</b> 
					

				</div>
				<!-- InicioBotones-->
				<div class="col-lg-2">
					<form action="DetallePaciente" method="POST">
						<input  name="idPersona" hidden class="idPaciente"
							value="<%=id%>"> <input class="btn btn-default"
							type="submit" value="Ver Datos Paciente">
					</form>
				</div>
				<div class="col-lg-1">

					<input hidden name="idHce" class="idPaciente" value="<%=idhce%>">
					<button type="button" class="btn btn-default" data-toggle="modal"
						data-target="#exampleModal" data-whatever="@fat">Ver
						historial Clínico</button>

				</div>
			</div>
			<!-- finbotones-->
			<br />
			<div class="input-group">
				<span class="input-group-addon">Folio Urgencia:</span> <input
					type="text" class="form-control" disabled value="<%=folio%>" >
				<span class="input-group-addon"></span>
			</div>


			<!--      formulario    -->
			<form method="post" action="CrearRce">
				<input type="text" name="idhce" value="<%=idhce%>" hidden> <input
					type="text" name="idHoraMedica" value="<%=idHoraMedica%>" hidden>
				<div class="row">
					

				</div>

				<br>
				<ul class="nav nav-tabs">

					<li role="presentation" class="active"><a href="#">REGISTRO
							CLÍNICO</a></li>

				</ul>

				<br>

				<div class="row">
					<div class="col-lg-6">
						<textarea class="form-control" rows="3" placeholder="ANAMNESIS"
							name="anamnesis"></textarea>

					</div>
					<div class="col-lg-6">
						<textarea class="form-control" rows="3" placeholder="ALERGIAS"
							name="alergias"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<textarea class="form-control" rows="3"
							placeholder="EXAMEN FÍSICO" name="examenFisico"></textarea>

					</div>
					<div class="col-lg-6">
						<textarea class="form-control" rows="3"
							placeholder="INDICACIÓN MÉDICA" name="indicaMedica"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<textarea class="form-control" rows="3"
							placeholder="INDICACIÓN CIERRE CASO CLÍNICO"
							name="indicaCierreCasoClinico"></textarea>

					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<textarea class="form-control" rows="2"
							placeholder="HIPÓTESIS DIAGNOSTICO" name="hipoDiagnostico"></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<%
							

						
						%>
						<select class="form-control" id="selecdiag" name="diagnostico">
							<option hidden value="0">Diagnostico</option>
							<%
							/*	JsonElement jelement = new JsonParser().parse(listaConceptos);
								JsonObject jobject = jelement.getAsJsonObject();

								JsonArray jarray = jobject.getAsJsonArray("results");

								for (int i = 0; i < jarray.size(); i++) {
									jobject = jarray.get(i).getAsJsonObject();
									String uuidCon = jobject.get("uuid").getAsString();
									String nombres = jobject.get("display").getAsString();*/
							%>
							<option value=""></option>
							<%
							//	}
							%>
						</select>
					</div>
					<div class="col-lg-6">Sin Detalle GES Cita Actual</div>
				</div>
				<div class="row">
					<div class="col-lg-6">

						<div class="col-lg-1">
							<b>Receta</b>
						</div>
						<div class="clearfix visible-lg"></div>

						<div class="col-lg-7">
							<b>Tipo Paciente y Tipo Medicamento</b>
						</div>
						<div class="clearfix visible-lg"></div>
						<br>
						<div class="col-lg-5">
							Paciente GES: <label class="radio-inline"> <input
								type="radio" name="paciGESradio" value="si">si
							</label> <label class="radio-inline"><input type="radio"
								name="paciGESradio" value="no">no</label>
						</div>
						<div class="col-lg-6">
							Patología GES: <label class="radio-inline"><input
								type="radio" name="patoloGESradio" value="si">si</label> <label
								class="radio-inline"><input type="radio"
								name="patoloGESradio" value="no">no</label>
						</div>
						<div class="clearfix visible-lg"></div>
						<br>
						<div class="col-lg-6">
							Paciente Crónico: <label class="radio-inline"><input
								type="radio" name="paciCroniradio" value="si">si</label> <label
								class="radio-inline"><input type="radio"
								name="paciCroniradio" value="no">no</label>
						</div>
						<div class="col-lg-6">Validez:</div>

						<div class="clearfix visible-lg"></div>

						<div class="col-lg-11">
							<br>
							<textarea class="form-control" rows="3"
								placeholder="RECETA EN MODO TEXTO" name="receta"></textarea>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="col-lg-1">
							<b>Certificados</b>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-11" style="overflow: scroll; height: 200px;">
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									value="1" name="certialcoholemiaradio">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certialcoholemiaradio" value="2">No Alcoholemia</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certivfamiliarradio" value="3">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certivfamiliarradio" value="4">No V.
									Intrafamiliar</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certidrogasradio" value="5">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certidrogasradio" value="6">No Drogas</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certilecionesradio" value="7">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certilecionesradio" value="8">No Lesiones</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certisuicidioradio" value="9">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certisuicidioradio" value="10">No Suicidio</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certianimalradio" value="11">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certianimalradio" value="12">No Animal</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certiotrosradio" value="13">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certiotrosradio" value="14">No Otros ML</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certivgeneroradio" value="15">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certivgeneroradio" value="16">No V. Género</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certisaludcompatibleradio" value="17">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certisaludcompatibleradio" value="18">No Salud
									Compatible</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio-inline"><input type="radio"
									name="certiatenciondiagnosticoradio" value="19">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certiatenciondiagnosticoradio" value="20">No
									Atención Diagnóstica</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio-inline"><input type="radio"
									name="certiatencionprofecionalradio" value="21">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certiatencionprofecionalradio" value="22">No
									Atención Profesional</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-8">
								<label class="radio-inline"><input type="radio"
									name="certiderivacioninternaradio" value="23">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certiderivacioninternaradio" value="24">No
									Derivación Interna</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certicitacionkntradio" value="25">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certicitacionkntradio" value="26">No Citacion a
									KNT</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certiordencuracionradio" value="27">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certiordencuracionradio" value="28">No Orden
									Curación</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio"
									name="certiordencitacionradio" value="29">sí</label> <label
									class="radio-inline"><input type="radio"
									name="certiordencitacionradio" value="30">No Orden
									Citación</label>
							</div>

						</div>
					</div>
				</div>

				<br>
				<div class="row">
					<div class="col-lg-6">

						<div class="col-lg-6">
							<b>Actividades</b>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-9">
							<div class="input-group">
								<span class="input-group-addon">Buscar Actividades:</span> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-12">
							<select multiple class="form-control" id="sel2"
								style="height: 150px;" name="actividad">
								<option value="1">ATENCIONES SALA IRA ERA</option>
								<option value="2">CIERRES ADMINISTRATIVOS ESPECIALES</option>
								<option value="3">CONSULTA</option>
								<option value="4">CONSULTAS MORBILIDAD URGENCIA</option>
								<option value="5">ODON. PROCEDIMIENTOS
									MEDICO-QUIRURGICO</option>
								<option value="6">ODONTOLOGIA GENERAL</option>
								<option value="7">ODONTOLOGIA INGRESOS</option>
								<option value="8">ODONTOLOGIA URGENCIA</option>
							</select>
						</div>

					</div>
					<div class="col-lg-6">



						<div class="col-lg-6">
							<b>Procedimientos</b>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-9">
							<div class="input-group">
								<span class="input-group-addon">Buscar Procedimientos:</span> <input
									type="text" class="form-control">
							</div>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-12">
							<select multiple class="form-control" id="sel2"
								style="height: 150px;" name=procedimiento>
								<option value="1">CARDIOLOGIA</option>
								<option value="2">CURACIONES</option>
								<option value="3">DERMATOLOGIA Y TEGUMENTOS</option>
								<option value="4">GATROENTEROLOGIA</option>
								<option value="5">GINECOLOGIA Y OBSTETRICIA</option>
								<option value="6">INFORMES MEDICOS</option>
								<option value="7">KINESIOLOGIA RESP.</option>
								<option value="8">MISCELANEOS</option>
							</select>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-12">
						<b>Cierre Caso</b>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Tipo Cierre Clínico:</div>
					<div class="col-lg-9">
						<select class="form-control" id="sel2" name="tipoCierre">
							<option value="0">...</option>
							<option value="Con atención">Con atención</option>
							<option value="No se atendio">No se atendio</option>
							<option value="No asiste">No asiste</option>
						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Destino:</div>
					<div class="col-lg-9">
						<select class="form-control" id="sel2" name="destino">
							<option value="0">...</option>
							<option value="Domicilio">Domicilio</option>
							<option value="Internado">Internado</option>

						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Fecha Atención:</div>
					<div class="col-lg-5">
						<input type="date" class="form-control" name="fechaAtencion" max="2015-08-12">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Hora Inicio Atención:</div>
					<div class="col-lg-5">
						<input type="time" class="form-control" name="horaInicioAtencion">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Fecha Cierre Clínico:</div>
					<div class="col-lg-5">
						<input type="date" class="form-control" name="fechaCierreClinico">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Hora Cierre Clínico:</div>
					<div class="col-lg-5">
						<input type="time" class="form-control" name="horaCierreCLinico">

					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Tiempo Control:</div>
					<div class="col-lg-9">
						<select class="form-control" id="sel2" name="tiempoControl">
							<option value="0">...</option>
							<option value="No corresponde">No corresponde</option>
							<option value="proxima visita">Proxima visita</option>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-6">
						<b>Realice el Cierre Administrativo al realizar el Cierre
							Clínico</b>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-3">Realizar Cierre Administrativo:</div>
					<div class="col-lg-3">
						<label class="radio-inline"><input type="radio"
							name="cierreAdmin" value="CIERRE ADMINISTRATIVO">sí</label> <label
							class="radio-inline"><input type="radio"
							name="cierreAdmin" value="CATEGORIZADO">No</label>
					</div>


				</div>

				<div class="row">
					<div class="col-lg-2">

						<input hidden name="idPaciente" class="idPaciente">
						<button class="btn btn-default" type="submit">GRABAR</button>

					</div>
					<div class="col-lg-2">

						<input hidden name="idPaciente" class="idPaciente"> <input
							class="btn btn-default" type="reset" value="LIMPIAR">

					</div>

				</div>

			</form>







		</div>
	</div>


	<div>
		<%
			//String hce = //ws.obtenerRces(idhce);
			
		%>


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
							
							String matriz[][]=new String[5][5];//TransformarJson.hce(hce);
							
							for (int i = 0; i < matriz[0].length; i++) {
								%>
								<tr>
								<td><%=matriz[0][i] %></td>
								<td><%=matriz[1][i]%></td>
								<td><%=matriz[2][i] %></td>
								<td><%=matriz[4][i]%></td>
								<td><%=matriz[3][i] %></td>
								
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


</body>
</html>