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
		String menu = (String)request.getAttribute("menu");
	%>
	<form action="">
		<header>
			<nav>
				<ul class="nav-left-section">
					<li>
	                    <a href="index.jsp">Titulo de la pag</a>
	                </li>
				</ul>
	            <ul class="nav-right-section">
	                <li>
	                    Bienvenido <%=mensaje%>
	                </li>
	            </ul>
	        </nav>
		</header>
		<main>
			<nav>
				<ul>
					<%=menu%>
				</ul>
			</nav>
		</main>
	</form>
</body>
</html>