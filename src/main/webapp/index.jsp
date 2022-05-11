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
	<div class="verticalContainer">
		<form action="ServletLogin" method="get" id="tablaLogin">
			<table>
				<tr><th>Usuario</th><th><input type="text" name="user"></input></th></tr>
				<tr><th>Contraseña</th><th><input type="password" name="pass"></input></th></tr>
				<tr><th><button type="submit" name="bl" value="Login">Login</button></th><th><button type="submit" name="br" value="Registro">Registro</button>
			</table>	
		</form>
	</div>
</body>
</html>