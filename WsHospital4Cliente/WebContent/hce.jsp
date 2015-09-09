<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="capaServicio.ServicioProxy"%>
<%@page import="utilitario.Transformar"%>
<%@page import="java.util.List"%>
<%@page import="capaNegocio.fichaMedicaDomain.RceVO"%>
<%@page import="capaNegocio.hospitalDomain.HoraMedicaVO"%>

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
		
		String estadoCaso = "";

		String fecha = "";
		String box="";
		String medico = "";
		String hora = "";
		String idPaciente="";
		try {
			paciente = request.getAttribute("paciente").toString();
			idPaciente=request.getAttribute("idPaciente").toString();
			
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
						<th hidden></th>
						<th>Box</th>
						<th>FECHA</th>
						<th>PRESTADOR</th>
	
						<th>ESTADO DEL CASO</th>
					</tr>
				</thead>
				<tbody>
					<%	ServicioProxy s = new ServicioProxy();
						String idRce = "";
						if (!listaRce.equals("{\"results\":[]}")
								&& (!paciente
										.equals("{\"results\":[{\"id\":0,\"persona\":{\"id\":0}}]}"))) {
							String nombreMedico = "";

							try {
								List<RceVO>listaRceHce=Transformar.jsonToRce3(listaRce);
							
								for (int i = 0; i < listaRceHce.size(); i++) {
								String idHora=listaRceHce.get(i).getIdHoraMedica().getId()+"";
									hora=s.obtenerHoraMedica(idHora);
									HoraMedicaVO horaMedica = Transformar.jsonToHoraMedica(hora);
									idRce=listaRceHce.get(i).getIdRce()+"";
									estadoCaso=listaRceHce.get(i).getTipoEncuentro();
									
									//hay que obtener lahora medica del ws
								
									
									//--------------hora medica--------------------------
									//si la hora medica es igual a 0 no hace nada 
								
										String apellidos = "";
										try {
											
											fecha = Transformar.dateTimetoString2(horaMedica.getFecha());
											nombreMedico = horaMedica.getMedico().getNombre();
											apellidos = horaMedica.getMedico().getApellidos();
											nombreMedico += " " + apellidos;
											box=horaMedica.getBox().getNroHabitacion();
										} catch (NullPointerException e) {

										} catch (UnsupportedOperationException e) {

										} catch (IllegalStateException e) {

										}
										medico = nombreMedico;
								
					%>
					<tr>
						<td id="uuid<%=i%>" hidden><%=idRce%></td>
						<td><%=box %></td>
						<td><%=fecha%></td>
						<td><%=medico%></td>
					
						<td><%=estadoCaso%></td>
						<td>
						<form action="AbrirRce" method="post" id="formAbrirRCE">
						<input hidden type="text" name="idRce" value="<%=idRce%>">
						<input hidden type="text" name="idPaciente" value="<%=idPaciente%>">
							<button type='submit' 
								class='btn btn-success text-right'>Abrir
								RCE</button>
							</form>	
						</td>
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