<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="capaServicio.ServicioProxy"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Historial Clínico Electrónico</title>
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
		String paciente = "{\"results\":[{\"id\":0,\"persona\":{\"id\":0}}]}";
		String listaRce = "{\"results\":[]}";
		String resumen = "";
		String estadoCaso = "";
		String establecimiento = "";
		String fecha = "";
		String horaMedica = "";
		String medico = "";
		String hora = "";
		try {
			paciente = request.getAttribute("paciente").toString();

			listaRce = request.getAttribute("listaRce").toString();

		} catch (NullPointerException e) {

		}
	%>
	<div class="container">
		<div class="jumbotron">
			<center>
				<h2>Historial Clínico Electrónico</h2>
				<h2>
					<b><%=paciente%></b>
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
					<%
						if (!listaRce.equals("{\"results\":[]}")
								&& (!paciente
										.equals("{\"results\":[{\"id\":0,\"persona\":{\"id\":0}}]}"))) {
							String nombreMedico = "";
							try {
								JsonElement jelement = new JsonParser().parse(listaRce);
								JsonObject jobject = jelement.getAsJsonObject();
								JsonArray jarray = jobject.getAsJsonArray("results");
								for (int i = 0; i < jarray.size(); i++) {
									jobject = jarray.get(i).getAsJsonObject();
									estadoCaso = jobject.get("tipoEncuentro").getAsString();
									horaMedica = jobject.get("idHoraMedica").getAsString();
									ServicioProxy s = new ServicioProxy();
									hora = s.obtenerHoraMedica(horaMedica);

									//hay que obtener lahora medica del ws
									JsonObject diagnosticoJson = jobject.get(
											"idDiagnostico").getAsJsonObject();
									resumen = diagnosticoJson.get("nombre").getAsString();
									//--------------hora medica--------------------------
									//si la hora medica es igual a 0 no hace nada 
									if (!hora.equals("{\"results\":[]}")) {
										String apellidos = "";
										try {
											JsonElement jelement2 = new JsonParser()
													.parse(hora);
											JsonObject jobject2 = jelement2
													.getAsJsonObject();
											JsonArray jarray2 = jobject2
													.getAsJsonArray("results");
											jobject2 = jarray2.get(0).getAsJsonObject();
											fecha = jobject2.get("fecha").getAsString();
											JsonObject boxJson = jobject2.get("box")
													.getAsJsonObject();
											JsonObject establecimientoJson = boxJson.get(
													"establecimiento").getAsJsonObject();

											establecimiento = establecimientoJson.get(
													"nombre").getAsString();
											JsonObject medicoJson = jobject2.get("medico")
													.getAsJsonObject();
											JsonObject personaJson = medicoJson.get(
													"persona").getAsJsonObject();

											nombreMedico = personaJson.get("nombre")
													.getAsString();
											apellidos = personaJson.get("apellido")
													.getAsString();

											nombreMedico += " " + apellidos;
										} catch (NullPointerException e) {

										} catch (UnsupportedOperationException e) {

										} catch (IllegalStateException e) {

										}
										medico = nombreMedico;
									}
					%>
					<tr>
						<td><%=establecimiento%></td>
						<td><%=fecha%></td>
						<td><%=medico%></td>
						<td><%=resumen%></td>
						<td><%=estadoCaso%></td>
						<td></td>
					</tr>
					<%
						}
							} catch (NullPointerException e) {

							}

						}//fin if
					%>
				</tbody>
			</table>

			<div class="text-right">
				<a href="BuscarPaciente" class="btn btn-default ">Volver</a>
			</div>
		</div>
	</div>
</body>
</html>