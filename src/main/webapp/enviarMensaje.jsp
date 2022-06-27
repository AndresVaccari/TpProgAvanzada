<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enviar nuevo mensaje</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
		<form action="ServletEnviarMensaje" method="get">
			<div class="d-flex justify-content-center align-items-center m-5">
				<div class="d-flex flex-column p-5 bg-light border rounded-4">
					<div class="mx-auto mb-4" style="width: 500px;">
						<label class="form-label">Para</label>
						<input type="text" class="form-control" name="destinatario" placeholder="destinatario1, destinatario2, etc" />
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
						<label class="form-label">Asunto</label>
						<input type="text" class="form-control" name="asunto" />
					</div>
					<div class="mb-4">
						<textarea class="rounded-3" maxlength="500" rows="4" cols="40" name="mensaje" placeholder="Mensaje" style="width: 100%;"></textarea>
					</div>
					
					<button type="submit" class="btn btn-primary btn-block mb-2" name="botonEnviar">Enviar Mensaje</button>
				</div>
			</div>
		</form>
	</main>
</body>
</html>