<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bandeja de entrada</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%
	String usuario = (String)request.getAttribute("usuario");
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
				<div class="d-flex flex-column p-5 bg-light border rounded-4">
					<div class="mx-auto mb-4" style="width: 500px;">
						<label class="form-label">Para</label>
						<input type="text" class="form-control" name="destinatario" />
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<label class="form-label">Asunto</label>
						<input type="password" class="form-control" name="asunto" />
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<textarea rows="4" cols="40" name="mensaje"></textarea>
					</div>
					
					<button type="submit" class="btn btn-danger btn-block mb-2">Cancelar</button>
				</div>
			</div>
		</form>
	</main>
</body>
</html>