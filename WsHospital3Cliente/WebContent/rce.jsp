<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="capaNegocio.fichamedicaDomain.DiagnosticoVO"%>
<%@page import="capaNegocio.fichamedicaDomain.ActividadVO"%>
<%@page import="capaNegocio.fichamedicaDomain.ProcedimientoVO"%>
<%@page import="utilitario.Transformar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

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
			String id = "0";
			String procedimientos = "";
			String actividades = "";
			String diagnosticos = "";
			List<DiagnosticoVO> diagnostico = new ArrayList<DiagnosticoVO>();
			List<ActividadVO> actividad = new ArrayList<ActividadVO>();
			List<ProcedimientoVO> procedimiento = new ArrayList<ProcedimientoVO>();
			try {
		folio = request.getAttribute("paciente").toString();
		idhce = request.getAttribute("hce").toString();
		
		idHoraMedica = request.getParameter("idHoraMedica");
		id = request.getParameter("idPaciente");
		procedimientos = request.getAttribute("procedimientos")
		.toString();
		actividades = request.getAttribute("actividades").toString();
		diagnosticos = request.getAttribute("diagnosticos").toString();

		try {
			diagnostico = Transformar.jsonToDiagnostico(diagnosticos);
			procedimiento = Transformar.jsonToProcedimiento(procedimientos);
			actividad = Transformar.jsonToActividad(actividades);

		} catch (NullPointerException e) {

		} catch (UnsupportedOperationException e) {

		} catch (IllegalStateException e) {

		}

			} catch (NullPointerException e) {

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
						<input name="idPersona" hidden class="idPaciente" value="<%=id%>">
						<input class="btn btn-default" type="submit"
							value="Ver Datos Paciente">
					</form>
				</div>
				<div class="col-lg-1">
					<form action="HCE" method="POST">
						<input name="idPaciente" hidden class="idPaciente" value="<%=id%>">
						<input class="btn btn-default" type="submit"
							value="Ver historial Clínico">
					</form>	
					
					

				</div>
			</div>
			<!-- finbotones-->
			<br />
			<div class="input-group">
				<span class="input-group-addon">Folio Urgencia:</span> <input
					type="text" class="form-control" disabled value="<%=folio%>">
				<span class="input-group-addon"></span>
			</div>
	<%
	String uuidEncuentro=Transformar.azarTexto();
	%>

			<!--      formulario    -->
			<form method="post" action="CrearRce">
			<input name="uuidEncuentro" hidden type="text" value="<%=uuidEncuentro %>" >
				<input name="idPaciente" hidden class="idPaciente" value="<%=id%>">
				<input type="text" name="idhce" value="<%=idhce%>" hidden> <input
					type="text" name="idHoraMedica" value="<%=idHoraMedica%>" hidden>
				<div class="row"></div>

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
							<option hidden value="0">Diagnosticos</option>
							<%
								if (diagnostico!= null) {
										for (DiagnosticoVO diag : diagnostico) {
									 	String iddiagnostico=diag.getId()+"";									
									    String nombrediagnostico=diag.getNombre();
							%>
							<option value="<%=iddiagnostico%>"><%=nombrediagnostico%></option>
							<%
								}
																						}
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
							<select class="form-control" id="actividades" name="actividad">
								<option hidden value="0">Actividades</option>
								<%
									if (actividad != null) {
										for (ActividadVO acti : actividad) {
											String iddiagnostico = acti.getDiagnostico().getId() + "";
											String idActividad = acti.getId() + "";
											String nombreActividad = acti.getNombreActividad();
								%>
								<option value="<%=iddiagnostico%>.<%=idActividad%>"><%=nombreActividad%></option>
								<%
									}
									}
								%>
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
							<select class="form-control" id="procedimientos"
								name=procedimiento>
								<option hidden value="0">Procedimientos</option>
								<%
									if (procedimiento != null) {
										for (ProcedimientoVO proce : procedimiento) {
											String iddiagnostico = proce.getDiagnostico().getId() + "";
											String idproce = proce.getId() + "";
											String nombreproce = proce.getNombre();
								%>
								<option value="<%=iddiagnostico%>.<%=idproce%>"><%=nombreproce%></option>
								<%
									}
									}
								%>
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
						<select class="form-control" id="tipoCierre" name="tipoCierre">
							<option value="0">...</option>
							<option value="Con atención">Con atención</option>
							<option value="No se atendio">No se atendio</option>
							<option value="No asiste">No asiste</option>
						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Destino:</div>
					<div class="col-lg-9">
						<select class="form-control" id="destino" name="destino">
							<option value="0">...</option>
							<option value="Domicilio">Domicilio</option>
							<option value="Internado">Internado</option>

						</select>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Fecha Atención:</div>
					<div class="col-lg-5">
						<input type="date" class="form-control" name="fechaAtencion"
							max="2015-08-12">

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
						<select class="form-control" id="tiempoControl"
							name="tiempoControl">
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


	


</body>
</html>