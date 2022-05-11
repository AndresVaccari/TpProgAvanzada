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
	<%
		String mensaje = (String)request.getAttribute("mensaje");
	%>
	<h1>Bienvenido <%=mensaje%></h1>
</body>
</html>