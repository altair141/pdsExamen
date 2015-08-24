<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
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
	<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="inicio.jsp">Inicio</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Hora
						Medica<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="listaHorasDisponibles.jsp">lista Horas
								Medicas disponibles</a></li>
						<li><a href="listaHoraMedica.jsp">lista Horas Medicas</a></li>
						<li><a href="listaHoraMedicaControl.jsp">lista Horas
								Medicas de control</a></li>
						<li><a href="listaHoraMedicaAps.jsp">lista Horas Medicas
								APS</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">M�dicos<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="listaMedicos.jsp">Lista M�dicos</a></li>


					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Pacientes<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="BuscarPaciente">Lista Pacientes</a></li>


					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Reserva<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="reservarHoraControl.jsp">Reservar hora
								control</a></li>
						<li><a href="reservarHoraAps.jsp">Reservar hora APS</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Reporte<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="listaReportes.jsp">Lista Reportes</a></li>
						<li class="divider"></li>
						<li><a href="generarReporteBox.jsp">box utilizados</a></li>
						<li><a href="medicosSolicitados.jsp">m�dicos solicitados</a></li>
						<li><a href="medicoMasSolicitado.jsp">M�dico m�s
								solicitado</a></li>
						<li><a href="pacienteMasAtendido.jsp">Paciente m�s
								atendido</a></li>
					</ul></li>

			</ul>

		</div>
	</div>
	</nav>



	<%
		try {
			String resultado = request.getAttribute("resultado").toString();
	%>

	<div class="container">
		<div class="jumbotron">
			<center>
				<h2>
					<b><%=resultado%></b>
				</h2>
			</center>
		</div>
	</div>

	<%
		} catch (NullPointerException e) {

		}
	%>

</body>
</html>