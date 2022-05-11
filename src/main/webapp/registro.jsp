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
		<form action="ServletRegistro" method="get" id="tablaLogin">
			<table>
				<tr><th>Usuario</th><th><input type="text" name="user"></input></th></tr>
				<tr><th>Contraseña</th><th><input type="password" name="pass"></input></th></tr>
				<tr><th>Documento</th><th><input type="text" name="doc"></input></th></tr>
				<tr><th>Nombre</th><th><input type="text" name="name"></input></th></tr>
				<tr><th>Apellido</th><th><input type="text" name="lname"></input></th></tr>
				<tr><th>Email</th><th><input type="text" name="email"></input></th></tr>
				<tr><td colspan="2" align="center"><button type="submit" id="botonRegistro">Registrarse!</button></td></tr>
			</table>	
		</form>
	</div>
</body>
</html>