
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="capaServicio.ServicioProxy"%>
<%@page import="utilitario.Transformar"%>
<%@page import="capaNegocio.personasDomain.PacienteVO"%>
<%@page import="java.util.List"%>

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
								lista = s.obtenerPaciente(paciente);//s.(paciente);
								if (lista.equals("no encontrado")) {
									lista = "{\"results\":[]}";
								}

							} catch (NullPointerException e) {
								lista = s.obtenerListaPacientes();
								if (lista.equals("no encontrado")) {
									lista = "{\"results\":[]}";
								}
							}
							if (!lista.equals("no encontrado")
									|| !lista.equals("{\"results\":[]}")) {

								try {
									List<PacienteVO> listaPacientes = Transformar
											.listaPacienteVO(lista);
									for (int i = 0; i < listaPacientes.size(); i++) {
										String uuid = listaPacientes.get(i).getId() + "";
										String nombres = listaPacientes.get(i).getNombre()
												+" "+ listaPacientes.get(i).getApellidos();
						%>

						<tr>
							<td hidden id="uuid<%=i%>"><%=uuid%></td>
							<td id='nombre<%=i%>'><%=nombres%></td>
							<td style='width: 10%;'>
								<form method="post" id="formAbrirRCE" action="DetallePaciente"
									>
									<div class="row">
										<div class="form-group" hidden>
											<input type="text" class="form-control" id="uuid"
												name="idPersona" hidden value="<%=uuid%>">
										</div>										
									</div>

									<div class="row">
										<div class="form-group col-lg-5">
											<button type="submit" class="btn btn-success">Ver
												detalle</button>
										</div>
									</div>
								</form>
								
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
		</div>
	</div>
</body>
</html>