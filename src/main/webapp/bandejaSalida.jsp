<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" import="entities.Mensaje" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bandeja de salida</title>
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
						class="btn btn-link navbar-brand m-2">Logo</button>
				</form>
				<form class="d-flex" action="ServletNavbar" method="get">
					<ul class="nav">
						<li class="nav-item">
							<button type="submit" name="bl" class="btn btn-secondary m-2">Iniciar
								Sesion</button>
						</li>
						<li class="nav-item">
							<button type="submit" name="br" class="btn btn-secondary m-2">Registrarse</button>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>
	<main>
		<form action="ServletEnviarMensaje" method="get">
			<div class="d-flex justify-content-center align-items-center m-5">
				<div class="d-flex col-8 p-5 bg-light border rounded-4">
					<ul class="list-group w-100">
						<%
						for (Mensaje mensaje : mensajes) {
							%>
							<li class="list-group-item">
								<b><%=mensaje.getRemitente()%> --- Asunto: </b><%=mensaje.getAsunto()%> 
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