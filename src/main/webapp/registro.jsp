<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/bootstrap.css" />

</head>
<body>
	<form action="ServletRegistro" method="get">
		<header>
			<nav>
				<ul class="nav-left-section">
					<li>
	                    <a href="index.jsp">Titulo de la pag</a>
	                </li>
				</ul>
	            <ul class="nav-right-section">
	                <li>
	                    <a href="login.jsp">Iniciar Sesion</a>
	                </li>
	                <li>
	                    <a href="registro.jsp"">Registrarse</a>
	                </li>
	            </ul>
	        </nav>
		</header>
		<main class="verticalContainer">
			<div class="tablaLogin">
				<table>
					<tr><th>Usuario</th><th><input type="text" name="user"></input></th></tr>
					<tr><th>Contraseña</th><th><input type="password" name="pass"></input></th></tr>
					<tr><th>Documento</th><th><input type="text" name="doc"></input></th></tr>
					<tr><th>Nombre</th><th><input type="text" name="name"></input></th></tr>
					<tr><th>Apellido</th><th><input type="text" name="lname"></input></th></tr>
					<tr><th>Email</th><th><input type="text" name="email"></input></th></tr>
					<tr><td colspan="2" align="center"><button type="submit" id="botonRegistro">Registrarse!</button></td></tr>
				</table>	
			</div>
		</main>	
	</form>
	</div>
</body>
</html>