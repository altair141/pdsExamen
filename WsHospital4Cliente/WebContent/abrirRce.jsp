<%@page import="com.google.gson.JsonParser"%>
<%@page import="capaNegocio.fichaMedicaDomain.DiagnosticoVO"%>
<%@page import="capaNegocio.fichaMedicaDomain.ActividadVO"%>
<%@page import="capaNegocio.fichaMedicaDomain.ProcedimientoVO"%>
<%@page import="capaServicio.ServicioProxy"%>
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
		ServicioProxy s=new ServicioProxy();

			String folio = "";//request.getAttribute("display").toString();
		String idhce = "";// request.getAttribute("idHce").toString();
		String idHoraMedica = "";
		String id = "0";
		String procedimientos = "";
		
		try {
			folio = request.getAttribute("paciente").toString();
			id=request.getAttribute("idPaciente").toString();		
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
						<input class="btn btn-success" type="submit"
							value="Ver Datos Paciente">
					</form>
				</div>
				<div class="col-lg-1">

					<input hidden name="idHce" class="idPaciente" value="<%=idhce%>">
					<form action="HCE" method="POST">
						<input name="idPaciente" hidden class="idPaciente" value="<%=id%>">
						<input class="btn btn-success" type="submit"
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
			

			<!--      formulario    -->
			<form method="post" action="HCE">
		
				<div class="row"></div>

				<br>
				<ul class="nav nav-tabs">

					<li role="presentation" class="active"><a href="#">REGISTRO
							CLÍNICO</a></li>

				</ul>

				<br>

				<div class="row">
				<%
				String anamnesis="";
				try{
					anamnesis=request.getAttribute("anamnesis").toString();
				}catch(NullPointerException e){
					
				}
				%>
					<div class="col-lg-6">
						<textarea disabled class="form-control" rows="3" placeholder="ANAMNESIS"
							name="anamnesis"><%=anamnesis%></textarea>

					</div>
					
				<%
				String alergia="";
				try{
					alergia=request.getAttribute("alergia").toString();
				}catch(NullPointerException e){
					
				}
				%>
					<div class="col-lg-6">
						<textarea class="form-control" rows="3" placeholder="ALERGIAS" disabled
							name="alergias"><%=alergia %></textarea>
					</div>
				</div>
				<div class="row">
				<%
					String examenFisico="";
				try{
					examenFisico=request.getAttribute("examenFisico").toString();
				}catch(NullPointerException e){
					
				}
				%>
					<div class="col-lg-6">
						<textarea class="form-control" rows="3" disabled
							placeholder="EXAMEN FÍSICO" name="examenFisico"><%=examenFisico %></textarea>

					</div>
					<%
					String indicaMedica="";
				try{
					indicaMedica=request.getAttribute("indicacionMedica").toString();						
				}catch(NullPointerException e){					
				}
				%>
					<div class="col-lg-6">
						<textarea class="form-control" rows="3" disabled
							placeholder="INDICACIÓN MÉDICA" name="indicaMedica"><%=indicaMedica %></textarea>
					</div>
				</div>
				<div class="row">
				<%
					String cierreClinico="";
				try{
					cierreClinico=request.getAttribute("indicacionCierreCaso").toString();					
				}catch(NullPointerException e){
					
				}
				%>
					<div class="col-lg-12">
						<textarea class="form-control" rows="3" disabled
							placeholder="INDICACIÓN CIERRE CASO CLÍNICO"
							name="indicaCierreCasoClinico"><%=cierreClinico %></textarea>

					</div>
				</div>
				<div class="row">
				<%
					String hipoDiag="";
				try{
					hipoDiag=request.getAttribute("hipotesisDiagnostico").toString();
				}catch(NullPointerException e){					
				}
				%>
					<div class="col-lg-12">
						<textarea class="form-control" rows="2" disabled
							placeholder="HIPÓTESIS DIAGNOSTICO" name="hipoDiagnostico"><%=hipoDiag %></textarea>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						
						<select  multiple class="form-control" id="selecdiag" name="diagnostico">
							<%
								String listaDiagnostico="";
							
							String iddDiagnostico="";
							String nombreDiagnos="";
								try{
								listaDiagnostico=request.getAttribute("listaDiagnostico").toString();
								String listaDiagnosticoVo=s.obtenerListaDiagnosticosPorId(listaDiagnostico);
								List<DiagnosticoVO> diagnostico=Transformar.jsonToDiagnostico(listaDiagnosticoVo);	
								for(int i=0;i<diagnostico.size();i++){
									nombreDiagnos=diagnostico.get(i).getNombre();
									
									%>
									<option  ><%=nombreDiagnos%></option>
									<%
								}
								
								}catch(NullPointerException e){
									
								}
							%>
							<!---->
						

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
						<%
						String pacienteGes="";
						try{
						pacienteGes=request.getAttribute("pacienteGes").toString();	
						}catch(NullPointerException e){
							
						}
						
						%>
						<div class="col-lg-5">
							Paciente GES: <label class="radio-inline"> <input disabled
								type="radio" name="paciGESradio" <%if(pacienteGes.equals("si")){ %> checked<%} %> value="si">si
							</label> <label class="radio-inline"><input type="radio" disabled
								name="paciGESradio" <%if(pacienteGes.equals("no")){ %> checked<%} %> value="no">no</label>
						</div>
						<%
						String patologia="";
						try{
							patologia=request.getAttribute("patologiaGes").toString();
						}catch(NullPointerException e){
							
						}
						%>
						<div class="col-lg-6">
							Patología GES: <label class="radio-inline"><input disabled
								type="radio" name="patoloGESradio" <%if(patologia.equals("si")){ %> checked<%} %> value="si">si</label> <label
								class="radio-inline"><input type="radio" disabled
								name="patoloGESradio" <%if(patologia.equals("no")){ %> checked<%} %> value="no">no</label>
						</div>
						<div class="clearfix visible-lg"></div>
						<br>
						<%
						String pacienteCronico="";
						try{
							pacienteCronico=request.getAttribute("pacienteCronico").toString();
									
						}catch(NullPointerException e){
							
						}
				
						%>
						<div class="col-lg-6">
							Paciente Crónico: <label class="radio-inline"><input disabled
								type="radio" name="paciCroniradio" <%if(pacienteCronico.equals("si")){ %> checked<%} %> value="si">si</label> <label
								class="radio-inline"><input type="radio" disabled
								name="paciCroniradio" <%if(pacienteCronico.equals("no")){ %> checked<%} %> value="no">no</label>
						</div>
						<div class="col-lg-6">Validez:</div>

						<div class="clearfix visible-lg"></div>

						<%
						String receta="";
						try{
							receta=request.getAttribute("receta").toString();
						}catch(NullPointerException e){							
						}
						%>
						<div class="col-lg-11">
							<br>
							<textarea class="form-control" rows="3" disabled
								placeholder="RECETA EN MODO TEXTO" name="receta"><%=receta %></textarea>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="col-lg-1">
							<b>Certificados</b>
						</div>
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-11" style="overflow: scroll; height: 200px;">
							<div class="clearfix visible-lg"></div>
							<%
							String certificado1 ="";
							try{
								certificado1 =request.getAttribute("certificado1").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input disabled type="radio" <%if(certificado1.equals("1")){ %> checked<%} %>
									value="1"   name="certialcoholemiaradio">sí</label> <label
									class="radio-inline"><input type="radio" <%if(certificado1.equals("2")){ %> checked<%} %>
									name="certialcoholemiaradio" disabled  value="2">No Alcoholemia</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado2 ="";
							try{
								certificado2 =request.getAttribute("certificado2").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" <%if(certificado2.equals("3")){ %> checked<%} %>
									name="certivfamiliarradio" disabled value="3">sí</label> <label
									class="radio-inline"><input type="radio" <%if(certificado2.equals("4")){ %> checked<%} %>
									name="certivfamiliarradio" disabled  value="4">No V.
									Intrafamiliar</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado3 ="";
							try{
								certificado3 =request.getAttribute("certificado3").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" <%if(certificado3.equals("5")){ %> checked<%} %>
									name="certidrogasradio" disabled  value="5">sí</label> <label
									class="radio-inline"><input type="radio" <%if(certificado3.equals("6")){ %> checked<%} %>
									name="certidrogasradio" disabled  value="6">No Drogas</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado4 ="";
							try{
								certificado4 =request.getAttribute("certificado4").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado4.equals("7")){ %> checked<%} %>
									name="certilecionesradio" value="7">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado4.equals("8")){ %> checked<%} %>
									name="certilecionesradio" value="8">No Lesiones</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado5 ="";
							try{
								certificado5 =request.getAttribute("certificado5").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado5.equals("9")){ %> checked<%} %>
									name="certisuicidioradio" value="9">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado5.equals("10")){ %> checked<%} %>
									name="certisuicidioradio" value="10">No Suicidio</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado6 ="";
							try{
								certificado6 =request.getAttribute("certificado6").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado6.equals("11")){ %> checked<%} %>
									name="certianimalradio" value="11">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado6.equals("12")){ %> checked<%} %>
									name="certianimalradio" value="12">No Animal</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado7 ="";
							try{
								certificado7 =request.getAttribute("certificado7").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado7.equals("13")){ %> checked<%} %>
									name="certiotrosradio" value="13">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado7.equals("14")){ %> checked<%} %>
									name="certiotrosradio" value="14">No Otros ML</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado8 ="";
							try{
								certificado8 =request.getAttribute("certificado8").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado8.equals("15")){ %> checked<%} %>
									name="certivgeneroradio" value="15">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado8.equals("16")){ %> checked<%} %>
									name="certivgeneroradio" value="16">No V. Género</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado9 ="";
							try{
								certificado9 =request.getAttribute("certificado9").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado9.equals("17")){ %> checked<%} %>
									name="certisaludcompatibleradio" value="17">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado9.equals("18")){ %> checked<%} %>
									name="certisaludcompatibleradio" value="18">No Salud
									Compatible</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado10 ="";
							try{
								certificado10 =request.getAttribute("certificado10").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-8">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado10.equals("19")){ %> checked<%} %>
									name="certiatenciondiagnosticoradio" value="19">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado10.equals("20")){ %> checked<%} %>
									name="certiatenciondiagnosticoradio" value="20">No
									Atención Diagnóstica</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado11 ="";
							try{
								certificado11 =request.getAttribute("certificado11").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-8">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado11.equals("21")){ %> checked<%} %>
									name="certiatencionprofecionalradio" value="21">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado11.equals("22")){ %> checked<%} %>
									name="certiatencionprofecionalradio" value="22">No
									Atención Profesional</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado12 ="";
							try{
								certificado12 =request.getAttribute("certificado12").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-8">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado12.equals("23")){ %> checked<%} %>
									name="certiderivacioninternaradio" value="23">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado12.equals("24")){ %> checked<%} %>
									name="certiderivacioninternaradio" value="24">No
									Derivación Interna</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado13 ="";
							try{
								certificado13 =request.getAttribute("certificado13").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado13.equals("25")){ %> checked<%} %>
									name="certicitacionkntradio" value="25">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado13.equals("26")){ %> checked<%} %>
									name="certicitacionkntradio" value="26">No Citacion a
									KNT</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado14 ="";
							try{
								certificado14 =request.getAttribute("certificado14").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado14.equals("27")){ %> checked<%} %>
									name="certiordencuracionradio" value="27">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado14.equals("28")){ %> checked<%} %>
									name="certiordencuracionradio" value="28">No Orden
									Curación</label>
							</div>
							<div class="clearfix visible-lg"></div>
							<%
							String certificado15 ="";
							try{
								certificado15 =request.getAttribute("certificado15").toString();
							}catch(NullPointerException e){								
							}
							%>
							<div class="col-lg-7">
								<label class="radio-inline"><input type="radio" disabled <%if(certificado15.equals("29")){ %> checked<%} %>
									name="certiordencitacionradio" value="29">sí</label> <label
									class="radio-inline"><input type="radio" disabled <%if(certificado15.equals("30")){ %> checked<%} %>
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
						
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-12">
							<select  multiple class="form-control" id="actividades" name="actividad">
							
								
								
								<%
									String listaActividad="";
								String actividad="";
								String idDiag="";
								String nombreActi="";
								try{
									listaActividad=request.getAttribute("listaActividad").toString();
									String listaActividadVO=s.obtenerListaActividadPorId(listaActividad);
									List<ActividadVO>actividadVo=Transformar.jsonToActividad(listaActividadVO);
									for(int i=0;i<actividadVo.size();i++){
										nombreActi=actividadVo.get(i).getNombreActividad();
										%>
										<option><%=nombreActi%></option>
										<%
									}
									
								}catch(NullPointerException e){
									
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
						
						<div class="clearfix visible-lg"></div>
						<div class="col-lg-12">
							<select  multiple class="form-control" id="procedimientos"
								name=procedimiento>
								<%
								String listaProcedimiento="";
								String idDiagnos="";
								String procedimiento="";
								String nombreProcedi="";
								try{
									listaProcedimiento=request.getAttribute("listaProcedimiento").toString();
									String listaProcedimientoVO=s.obtenerListaProcedimientoPorId(listaProcedimiento);
									List<ProcedimientoVO>procedimientoVo=Transformar.jsonToProcedimiento(listaProcedimientoVO);
									for(int i=0;i<procedimientoVo.size();i++){
										nombreProcedi=procedimientoVo.get(i).getNombre();
										%>
										<option><%=nombreProcedi %></option>
										<%
									}
								/*	
									procedimiento=s.obtenerProcedimientosporId(idProcedimiento);
									ProcedimientoVO proceVO=Transformar.jsonToProcedimientoNoLista(procedimiento);
									nombreProcedi=proceVO.getNombre();*/
								}catch(NullPointerException e){
									
								}
								
								%>
								
								
							</select>
						</div>
					</div>
				</div>
				<br>
				<%
				String tipoCierre="";
				try{
					tipoCierre=request.getAttribute("tipoCierre").toString();
							
				}catch(NullPointerException e){
					
				}
				%>
				<div class="row">
					<div class="col-lg-12">
						<b>Cierre Caso</b>
					</div>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Tipo Cierre Clínico:</div>
					<div class="col-lg-9">
						<select disabled class="form-control" id="tipoCierre" name="tipoCierre">
							<option value=""><%=tipoCierre %></option>
						
						</select>
					</div>
					<%
					String destino="";
					try{
						destino=request.getAttribute("destino").toString();
					}catch(NullPointerException e){
						
					}
					
					%>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Destino:</div>
					<div class="col-lg-9">
						<select class="form-control" disabled id="destino" name="destino">
							<option value=""><%=destino %></option>
							

						</select>
					</div>
					<%
					String fechaIni="";
					try{
						fechaIni=request.getAttribute("fechaAtencion").toString();
					}catch(NullPointerException e){
						
					}
					%>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Fecha Atención:</div>
					<div class="col-lg-5">
						<input type="text" disabled value="<%=fechaIni %>" class="form-control" name="fechaAtencion"
							max="2015-08-12">

					</div>
					<%
					String horaAtencion="";
					try{
						horaAtencion=request.getAttribute("horaInicioAtencion").toString();
								
					}catch(NullPointerException e){
						
					}
					%>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Hora Inicio Atención:</div>
					<div class="col-lg-5">
						<input type="text" disabled value="<%=horaAtencion %>" class="form-control" name="horaInicioAtencion">

					</div>
					<%
					String fechaCierre="";
					try{
						fechaCierre=request.getAttribute("fechaCierreClinico").toString();
					}catch(NullPointerException e){
						
					}
					%>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Fecha Cierre Clínico:</div>
					<div class="col-lg-5">
						<input type="text" value="<%=fechaCierre %>" disabled class="form-control" name="fechaCierreClinico">

					</div>
					<%
					String horaCierre="";
					try{
					horaCierre=request.getAttribute("horaCierreClinico").toString();
					}catch(NullPointerException e){
						
					}
					%>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Hora Cierre Clínico:</div>
					<div class="col-lg-5">
						<input type="text" value="<%=horaCierre %>" disabled class="form-control" name="horaCierreCLinico">

					</div>
					<%
					String tiempoControl="";
					try{
						tiempoControl=request.getAttribute("tiempoControl").toString();
								
					}catch(NullPointerException e){
						
					}
					%>
					<div class="clearfix visible-lg"></div>
					<div class="col-lg-2">Tiempo Control:</div>
					<div class="col-lg-9">
						<select class="form-control" disabled id="tiempoControl"
							name="tiempoControl">
							<option value=""><%=tiempoControl %></option>
							
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
					<%
					String tipoEncuentro="";
					try{
						tipoEncuentro=request.getAttribute("tipoEncuentro").toString();
					}catch(NullPointerException e){
						
					}
					%>
					<div class="col-lg-3">Realizar Cierre Administrativo:</div>
					<div class="col-lg-3">
						<label class="radio-inline"><input type="radio" disabled
							name="cierreAdmin" <%if(tipoEncuentro.equals("CIERRE ADMINISTRATIVO")){ %> checked <%} %> value="CIERRE ADMINISTRATIVO">sí</label> <label
							class="radio-inline"><input type="radio" disabled
							name="cierreAdmin" <%if(tipoEncuentro.equals("CATEGORIZADO")){ %> checked<%} %> value="CATEGORIZADO">No</label>
					</div> 


				</div>

				<div class="row">
					<div class="col-lg-2">
	
						
					</div>
					<div class="text-right" >

					<input name="idPaciente" hidden  class="idPaciente" value="<%=id%>">
					<button type="button" class="btn btn-primary" onclick="myFunction()">Imprimir</button>
					<input type="submit" class="btn btn-default" value="volver">
					</div>

				</div>

			</form>


<script>
function myFunction() {
    window.print();
}
</script>




		</div>
	</div>





</body>
</html>