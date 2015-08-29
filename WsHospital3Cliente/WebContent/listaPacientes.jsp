
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
<title>Lista de pacientes</title>
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
	<div class="container">
		<div class="jumbotron">
			<center>
				<form action="BuscarPaciente" method="POST">
					<h2>Buscar paciente</h2>
					<div class="form-inline">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Buscar paciente" aria-describedby="sizing-addon2"
								name="textoBusqueda" id="textBusqueda">
						</div>


						<button type="submit" class="btn btn-default"
							id="btn-BusquedaPaciente">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							Buscar
						</button>
					</div>
				</form>
			</center>


			<br />

			<script>
function seleccionado(uuid, datoPersona) {
	$("#formAbrirRCE").show();
	var id = document.getElementById("uuid");
	var nombre = document.getElementById("datosPaciente");
	id.value = uuid.innerHTML;
	nombre.value = datoPersona.innerHTML;

}
</script>

			<div id="resultadoBusPaciente">
				<center>
					<h2>Resultado de la búsqueda</h2>

				</center>
				<table class="table table-striped">
					<thead>
						<tr>
							<th hidden>uuid</th>
							<th>Nombres y Apellidos</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="tabla-busqueda">
						<!--deberia ser un for con los datos obtenidos mediante ajax-->
						<%
							ServicioProxy s = new ServicioProxy();

							String lista = "";
							try {
								String paciente = request.getAttribute("listaPacientes")
										.toString();
								lista = s.buscarPacienteBdLocal(paciente);
								if (lista.equals("no encontrado")) {
									lista = "{\"results\":[" + "" + "]}";
								}

							} catch (NullPointerException e) {
								lista = s.mostrarPacientes();
								if (lista.equals("no encontrado")) {
									lista = "{\"results\":[" + "" + "]}";
								} else {
									lista = "{\"results\":" + lista + "}";
								}
							}
							if (!lista.equals("no encontrado")
									|| !lista.equals("{\"results\":[" + "" + "]}")) {

								try {
									JsonElement jelement = new JsonParser().parse(lista);
									JsonObject jobject = jelement.getAsJsonObject();

									JsonArray jarray = jobject.getAsJsonArray("results");

									for (int i = 0; i < jarray.size(); i++) {
										jobject = jarray.get(i).getAsJsonObject();
										String uuid = jobject.get("id").getAsString();
										String nombres = jobject.get("nroFicha").getAsString();
						%>

						<tr>
							<td hidden id="uuid<%=i%>"><%=uuid%></td>
							<td id='nombre<%=i%>'><%=nombres%></td>
							<td style='width: 10%;'>
								<button type='button' class='btn btn-success text-right'
									onclick="seleccionado(uuid<%=i%>,nombre<%=i%>);">Seleccionar</button>

							</td>
						</tr>
						<%
							}
								} catch (NullPointerException e) {

								} catch (UnsupportedOperationException e) {

								} catch (IllegalStateException e) {

								}
							} 
						%>
					</tbody>
				</table>
			</div>
			<br /> <br />




			<form method="post" id="formAbrirRCE" action="DetallePaciente" hidden>
				<div class="row">
					<div class="form-group" hidden>
						<input type="text" class="form-control" id="uuid" name="idPersona"
							hidden>
					</div>

					<div class="form-group col-lg-5">
						<label for="exampleInputEmail1">Paciente:</label> <input
							type="text" class="form-control" id="datosPaciente" disabled>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-lg-5">
						<button type="submit" class="btn btn-success">Ver detalle</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>