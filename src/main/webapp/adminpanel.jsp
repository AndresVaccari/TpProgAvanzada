<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
	String pendientes = (String)request.getAttribute("listado");
%>
</head>
<body>
	<form action="ServletAdminPanel">
		<header>
			<nav>
				
			</nav>
		</header>
		<main>
			<section>
				<ul>
					<li>
						<%=pendientes%>
					</li>
				</ul>		
			</section>
			<section>
				<button>Aceptar</button>
				<button>Denegar</button>
			</section>
		</main>
	</form>
</body>
</html>