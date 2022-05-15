<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<%
	String pendientes = (String)request.getAttribute("listado");
%>
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
							<button type="submit" name="bl" class="btn btn-secondary m-2">Volver</button>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>
	<main>
		<section>
			<ul>
				<%=pendientes%>
			</ul>		
		</section>
		<section>
			<button>Aceptar</button>
			<button>Denegar</button>
			<button>Desactivar</button>
		</section>
	</main>
</body>
</html>