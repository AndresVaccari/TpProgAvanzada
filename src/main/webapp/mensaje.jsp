<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1" import="entities.Mensaje" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mensaje</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%
	Mensaje mensaje = (Mensaje)request.getAttribute("mensaje");
	String nameVolver = (String)request.getAttribute("nameVolver");
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
							<button type="submit" name=<%=nameVolver%> value="volver"
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
				<div class="col-8 p-5 bg-light border rounded-4">
					<p><b>Remitente:</b> <%=mensaje.getRemitente() %> <b>Destinatario:</b> <%=mensaje.getDestinatario() %></p>
					<p><b>Asunto:</b> <%=mensaje.getAsunto() %></p>
					<p><b>Mensaje</b></p>
					<p><%=mensaje.getMensaje() %></p>
				</div>
			</div>
		</form>
	</main>
</body>
</html>