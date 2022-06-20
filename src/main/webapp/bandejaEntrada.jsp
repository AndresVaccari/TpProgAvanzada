<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" import="entities.Mensaje" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bandeja de entrada</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%
	Mensaje[] mensajes = (Mensaje[])request.getAttribute("mensajes");
%>
</head>
<body>
	<header>
		<nav class="navbar bg-light">
			<div class="container-fluid">
				<form class="d-flex" action="ServletNavbar" method="get">
					<button type="submit" name="bs"
						class="btn btn-link navbar-brand">
							<img alt="Logo" width="120px" src="img/mail.svg">
						</button>
				</form>
				<form class="d-flex" action="ServletNavbar" method="get">
					<ul class="nav">
						<li class="nav-item">
							<button type="submit" name="botonVolver" value="volver"
								class="btn btn-secondary m-2 ">Volver</button>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>
	<main>
		<form action="ServletBandejaEntrada" method="get">
			<div class="d-flex justify-content-center align-items-center m-5">
				<div class="d-flex col-8 p-5 bg-light border rounded-4">
					<ul class="list-group w-100 border border-dark overflow-hidden">
						<%
						if (mensajes.length != 0) {
							%>
							<div class="row">
								<div class="col-2 border-end border-dark"><b>Remitente</b> </div>
								<div class="col-5 border-end border-dark"><b>Asunto</b> </div>
								<div class="col-1 border-end border-dark"><b>Estado</b> </div>
								<div class="col-2"></div>
								<div class="col-2"></div>
							</div>
							<%
							for (Mensaje mensaje : mensajes) {
								%>
								<li class="row bg-white">
									<div class="col-2 border-end border-dark"> <%=mensaje.getRemitente()%></div>
									<div class="col-5 border-end border-dark"> <%=mensaje.getAsunto()%> </div>
									<div class="col-1 border-end border-dark"> <%=mensaje.getEstado()%></div>
									<div class="col-2">
										<button type="submit" class="btn btn-primary w-100" name="botonLeer" value=<%=mensaje.getIDMensaje()%> >Leer mensaje</button>
									</div>
									<div class="col-2">
										<button type="submit" class="btn btn-primary w-100" name="botonBorrar" value=<%=mensaje.getIDMensaje()%>>Borrar Mensaje</button>
									</div>
								</li>
								<%
							}
						} else {
							%>
							<li class="list-group-item d-flex justify-content-between align-items-center">
								<p class="d-flex m-0">
									No hay mensajes para mostrar
								</p>
							</li>
							<%
						}
						%>
					</ul>
				</div>
			</div>
		</form>
	</main>
</body>
</html>