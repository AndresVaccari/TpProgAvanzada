<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<header>
		<nav class="navbar bg-light">
			<div class="container-fluid">
				<form class="d-flex" action="ServletNavbar" method="get">
					<button type="submit" name="bs" class="btn btn-link navbar-brand m-2">Logo</button>
				</form>
				<form class="d-flex" action="ServletNavbar" method="get">
					<ul class="nav">
						<li class="nav-item">
							<button type="submit" name="bl" class="btn btn-secondary m-2">Iniciar Sesion</button>
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
		<form action="ServletLogin" method="get">
			<div class="d-flex justify-content-center align-items-center m-5">
				<div class="d-flex flex-column p-5 bg-light border rounded-4">
					<div class="mx-auto mb-4" style="width: 500px;">
					    <input type="text" class="form-control" name="user"/>
					    <label class="form-label">Usuario</label>
					</div>
					<div class="mx-auto mb-4" style="width: 500px;">
					    <input type="password" class="form-control" name="pass"/>
					    <label class="form-label" >Contraseña</label>
					</div>
					<button type="submit" name="bl" value="Login" class="btn btn-primary btn-block mb-4">Iniciar Sesion</button>
					<p>No tienes una cuenta? <a href="registro.jsp">Registrate!</a></p>
				</div>
			</div>
		</form>
	</main>
</body>
</html>