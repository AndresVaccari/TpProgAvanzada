<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%
	String mensaje = (String)request.getAttribute("mensaje");
	String color = (String)request.getAttribute("color");
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
							<button type="submit" name="botonLogin" class="btn btn-secondary m-2">Iniciar
								Sesion</button>
						</li>
						<li class="nav-item">
							<button type="submit" name="botonRegistro" class="btn btn-secondary m-2">Registrarse</button>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>
	<main>
		<form action="ServletRegistro" method="get">
			<div class="d-flex justify-content-center align-items-center m-5">
				<div class="d-flex flex-column p-5 bg-light border rounded-4">
					<%
						if (mensaje != null) {
							%>
								<p class="text-center text-white p-2 rounded-3 <%=color %>" ><%=mensaje %></p>
							<%
						}
					%>
					<div class="mx-auto mb-4" style="width: 500px;">
						<input type="text" class="form-control" name="user" placeholder="Usuario"/>
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<input type="password" class="form-control" name="pass" placeholder="Contraseña"/>
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<input type="password" class="form-control" name="pass2" placeholder="Repetir contraseña"/>
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<input type="text" class="form-control" name="doc" placeholder="Documento"/>
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<input type="text" class="form-control" name="name" placeholder="Nombre"/>
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<input type="text" class="form-control" name="lname" placeholder="Apellido"/>
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<input type="text" class="form-control" name="email" placeholder="Email"/>
					</div>
					<button type="submit" class="btn btn-primary btn-block mb-4">Registrarse!</button>
				</div>
			</div>
		</form>
	</main>
</body>
</html>