<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hora Médica</title>
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
		String fecha = "";
		String tipo = "";
		String box = "";
		String nombreHospital = "";
		String medico = "";
		String especialidad = "";
		String idHoraMedica ="0";
		String idPaciente="";
		try{
			fecha=request.getAttribute("fecha").toString();
			tipo=request.getAttribute("tipo").toString();
			box=request.getAttribute("box").toString();
			nombreHospital=request.getAttribute("nombreHospital").toString();
			medico=request.getAttribute("medico").toString();
			especialidad=request.getAttribute("especialidad").toString();
			idHoraMedica = request.getParameter("idHora");
			idPaciente=request.getParameter("idPaciente");
		}catch(NullPointerException e){
			
		}
	%>
	<div class="container">
		<div class="jumbotron">
			<center>
				<h2>Detalle Hora Médica</h2>


			</center>
			<br>
			<div class="row fondo">

				<div class="col-lg-6">
					<center>
						<h3>
							<b>Hora Médica</b>
						</h3>
					</center>
					<form class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-4" for="fecha">Fecha y
								hora:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="fecha"
									placeholder="Fecha y Hora" disabled value="<%=fecha%>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="tipo">Tipo de
								hora:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="tipo"
									placeholder="Tipo de hora médica" disabled value="<%=tipo%>">
							</div>
						</div>
<!-- reeeeeeeeeeeeeeeeeeeeeeeeeeeviiiiiiiiiiiiiiiiiiiiiiiiiiiiisaaaaaaaaaaaaaaaaaaaaaaaaaaar ""  disabled value="< %=tipo%>"-->
					</form>
				</div>
				<div class="col-lg-6">
					<center>
						<h3>
							<b>Médico</b>
						</h3>
					</center>
					<form class="form-horizontal">

						<div class="form-group">
							<label class="control-label col-sm-4" for="medico">Médico:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="medico"
									placeholder="Médico" disabled value="<%=medico%>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="especialidad">Especialidad:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="especialidad"
									placeholder="Especialidad" disabled value="<%=especialidad%>">
							</div>
						</div>

					</form>
				</div>
			</div>
			<div class="row fondo">
				<div class="col-lg-6">
					<center>
						<h3>
							<b>Establecimiento</b>
						</h3>
					</center>
					<form class="form-horizontal">

						<div class="form-group">
							<label class="control-label col-sm-4" for="box">Box:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="box"
									placeholder="número del box" disabled value="<%=box%>">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="hospital">Nombre
								Hospital:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="hospital"
									placeholder="Nombre del hospital" disabled value="<%=nombreHospital%>">
							</div>
						</div>

					</form>
				</div>
				<div class="col-lg-6">

					<center>
						<h3>
							<b>Opciones</b>
						</h3>
						<form class="form-horizontal" method="post" action="RCE">
							<div hidden>
								<input type="text" class="form-control" id="idHoraMedica"
									name="idHoraMedica" value="<%=idHoraMedica%>" /> <input type="text" 
									class="form-control" id="idPaciente" name="idPaciente" value="<%=idPaciente%>"/>
							</div>
							<button type="submit" class="btn btn-success">Registrar
								RCE</button>

						</form>
					</center>
				</div>
			</div>
			<br>
			<div class="text-right">
				<a href="BuscarPaciente" class="btn btn-default ">Volver</a>
			</div>
		</div>
	</div>
</body>
</html>