<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajo Final</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%
	String mensaje = (String) request.getAttribute("mensaje");
	String tipoUsuario = (String) request.getAttribute("tipoUsuario");
	String usuario = (String) request.getAttribute("usuario");
	%>
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
							<button type="submit" name="botonLogOut" class="btn btn-secondary m-2">Cerrar
								Sesion</button>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>
	<main>
		<section class="d-flex justify-content-center align-items-center m-5">
			<div class="d-flex m-5 p-5 bg-light border rounded-4">
				<form action="ServletInicio">
				
					<button type="submit" name="botonMensajes"
						class="btn btn-primary btn-block m-1">Enviar Mensaje</button>
						
					<button type="submit" name="botonEnviados"
						class="btn btn-primary btn-block m-1">Bandeja de Salida</button>
						
					<button type="submit" name="botonBandeja"
						class="btn btn-primary btn-block m-1">Bandeja de Entrada</button>
					<%
					if (tipoUsuario.equals("admin")) {
					%>
					<button type="submit" name="botonAdmin" value="Login"
						class="btn btn-primary btn-block m-1">Modificar Usuarios</button>
					<%
					}
					%>
					
				</form>
			</div>
		</section>
	</main>
</body>
</html>