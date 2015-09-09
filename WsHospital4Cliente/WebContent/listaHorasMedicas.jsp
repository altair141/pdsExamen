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
<title>Horas Médicas</title>
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
		String listaHoras = "{\"results\":[]}";
		String resumen = "";
		String estadoCaso = "";
		String establecimiento = "";
		String fecha = "";
		String horaMedica = "";
		String medico = "";
		String hora = "";
		String idPaciente="";
		try {
			paciente = request.getAttribute("paciente").toString();
			idPaciente=request.getParameter("idPaciente");
			listaHoras = request.getAttribute("listaHoras").toString();

		} catch (NullPointerException e) {

		}
	%>


	<div class="container">
		<div class="jumbotron">
			<center>
				<h2>Horas Médicas</h2>
				<h2>
					<b><%=paciente%></b>
				</h2>

			</center>
			<br>
			<script>
function seleccionado(id,fecha,medico) {
	$("#formAbrirHora").show();
	var idHora = document.getElementById("idHora");
	
	var fech= document.getElementById("fechaHora");
	var nombreMedico=document.getElementById("nMedico");
	idHora.value = id.innerHTML;
	
	fech.value=fecha.innerHTML;
	nombreMedico.value=medico.innerHTML;
}
</script>
			<div class="row">
				<div class="col-lg-12 fondo">
					<br>
					<table class="table table-striped">
						<thead>
							<tr>
								<th hidden>id</th>
				
								<th>Fecha</th>
								<th>Medico</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<%
								if (!listaHoras.equals("{\"results\":[]}")
										&& (!paciente
												.equals("{\"results\":[{\"id\":0,\"persona\":{\"id\":0}}]}"))) {
									String id = "";
									JsonElement jelement = new JsonParser().parse(listaHoras);
									JsonObject jobject = jelement.getAsJsonObject();
									JsonArray jarray = jobject.getAsJsonArray("results");
									for (int i = 0; i < jarray.size(); i++) {
										jobject = jarray.get(i).getAsJsonObject();
										fecha = jobject.get("fecha").getAsString();
										id = jobject.get("id").getAsString();
										JsonObject medicoJson = jobject.get("medico")
												.getAsJsonObject();
										

										medico = medicoJson.get("nombre").getAsString();
										String apellidos = "";
										try {
											
											apellidos = medicoJson.get("apellidos").getAsString();
											medico += " " + apellidos;
										} catch (NullPointerException e) {
											apellidos = "";
										}
							%>
							<tr>
								<td hidden id="id<%=i%>"><%=id%></td>								
								<td id="fecha<%=i%>"><%=fecha%></td>
								<td id="medico<%=i%>"><%=medico%></td>
								<td style='width: 10%;'>
									<button type='button' class='btn btn-info text-right'
										onclick="seleccionado(id<%=i%>,fecha<%=i%>,medico<%=i%>);">Seleccionar</button>

								</td>
								<%
									}
									}
								%>
							
						</tbody>
					</table>

					<br>
				</div>
		

			</div>
			<br>
			<div class="row">
				<div class="col-lg-12 fondo">
					<form method="post" id="formAbrirHora" action="DetalleHoraMedica"
						hidden>
						<h2>Hora seleccionada</h2>
						<div class="row">
							<div class=" col-lg-12">
								<div class="row">
									<div class="form-group" hidden>
										<input type="text" class="form-control" id="idHora" hidden
											name="idHora"> <input type="text"
											class="form-control" id="idPaciente" hidden name="idPaciente" value="<%=idPaciente%>">
									</div>
								</div>
								
								<div class="row">
									<div class="form-group col-lg-10">
										<label for="exampleInputEmail1">Fecha:</label> <input
											type="text" class="form-control" id="fechaHora" disabled>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-lg-10">
										<label for="exampleInputEmail1">Médico:</label> <input
											type="text" class="form-control" id="nMedico" disabled>
									</div>
								</div>

							</div>
						</div>
						<div class="row">
							<div class="form-group col-lg-5">
								<button type="submit" class="btn btn-success">Ver
									detalle</button>
							</div>
						</div>

					</form>
				</div>
			</div>
			<div class="text-right">
				<a href="BuscarPaciente" class="btn btn-default ">Volver</a>
			</div>
		</div>
	</div>
</body>
</html>