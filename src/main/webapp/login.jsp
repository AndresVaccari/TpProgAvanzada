<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
	<header>
		<nav class="navbar bg-light">
			<div class="container-fluid">
				<a href="#" class="navbar-brand">Logo</a>
				<form class="d-flex">
					<ul class="nav">
						<li class="nav-item">
							<a href="#" class="nav-link">Iniciar Sesion</a>
						</li>
						<li class="nav-item">
							<a href="#" class="nav-link">Registrarse</a>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>	
	<main>
		<form action="ServletLogin" method="get">
			<div class="d-flex justify-content-center align-items-center" style="height: 500px;">
				<div class="d-flex flex-column p-4 bg-light border border-dark rounded-4">
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