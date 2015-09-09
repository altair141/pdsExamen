<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="capaServicio.ServicioProxy"%>
<%@page import="utilitario.Transformar"%>
<%@page import="capaNegocio.personasDomain.PacienteVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paciente</title>
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
		String nombre = "";
		String apellido = "";
		String direccion = "";
		String fichaClinica = "";
		String fechaNacimiento = "";
		String uuid = "";
		String id = "0";
		String paciente = "";
		String estado="";
		try {
			paciente = request.getAttribute("paciente").toString();
			if (paciente
					.equals("{\"results\":[{\"id\":0,\"persona\":{\"id\":0}}]}")) {
				paciente = "{\"results\":[]}";
			}

		} catch (NullPointerException e) {
			paciente = "{\"results\":[]}";
		}
		if (!paciente.equals("{\"results\":[]}")) {
			try {
				
				PacienteVO pacienteVo=Transformar.pacienteVO(paciente);
			
				id = pacienteVo.getId()+"";
				fichaClinica=pacienteVo.getNroFicha();				
				apellido= pacienteVo.getApellidos();
				nombre= pacienteVo.getNombre();
				fechaNacimiento= Transformar.datetoString(pacienteVo.getFechaNacimiento());
				direccion= pacienteVo.getDireccion();				
				estado= pacienteVo.getEstado();
			} catch (NullPointerException e) {
			} catch (UnsupportedOperationException e) {
			} catch (IllegalStateException e) {
			}
		}
	%>
	<div class="container">
		<div class="jumbotron">
			<center>
				<h2>Detalles del Paciente</h2>

			</center>
			<br>
			<div class="row">
				<div class="col-lg-8 fondo">
					<br>
					<form class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-4" for="nombre">Nombres:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="nombre"
									placeholder="nombre del paciente" disabled value="<%=nombre%>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="apellidos">Apellidos:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="apellidos"
									placeholder="apellidos del paciente" disabled value="<%=apellido%>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="direccion">Dirección:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="direccion"
									placeholder="dirección del paciente" disabled value="<%=direccion%>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="fichaClinica">Ficha
								Clínica:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="fichaClinica"
									placeholder="ficha clínica del paciente" disabled value="<%=fichaClinica%>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="fechaNacimiento">Fecha
								de nacimiento:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="fechaNacimiento"
									placeholder="fecha de nacimiento del paciente" disabled value="<%=fechaNacimiento%>">
							</div>
						</div>
						<div class="text-right">
							<a href="BuscarPaciente" class="btn btn-default ">Volver</a>
						</div>
					</form>
					<br>
				</div>

				<!-- botones derecha -->
				<div class="col-lg-4">
					<!--primera fila de botones -->
					<div class="form-inline">
						<div class="form-group">
							<form action="HoraMedica" method="POST">
								<input hidden type="text" name="idPaciente" value="<%=id%>"/>
								<button type="submit" class="btn btn-success">Ver Horas
									médicas</button>
							</form>
						</div>

						
						
							<div class="form-group">
								<form action="HCE" method="POST">
									<input hidden type="text" name="idPaciente" value="<%=id %>"/>

									<button type="submit" class="btn btn-success">Ver HCE</button>
								</form>
							</div>
						
					
					</div>
					<!--fin primera fila de botones -->
					<!--segunda fila de botones -->
					

				</div>
			</div>
		</div>
	</div>

</body>
</html>