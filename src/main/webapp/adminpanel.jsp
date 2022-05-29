<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<%
	String [] pendientes = (String[])request.getAttribute("usuariosPendientes");
	String [] activos = (String[])request.getAttribute("usuariosActivos");
	String [] inactivos = (String[])request.getAttribute("usuariosInactivos");
	boolean hayInactivos = (boolean)request.getAttribute("hayInactivos");
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
							<button type="button" onclick="history.back()" name="bl" class="btn btn-secondary m-2 ">Volver</button>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>
	<main class="container mt-5">
		<form action="">
			<div class="row">
				<section class="col-4 d-flex flex-column">
					<p>Usuarios Activos</p>
					<%
						for (String activo : activos) {
							%>
								<p>
									<%=activo%>
									<button type="button" type="submit" name="botonDesactivar" class="btn btn-primary m-2 ">Inactivo</button>
								</p>
							<%					
						}
					%>
				</section>
				<section class="col-4">
					<p>Usuarios Inactivos</p>
						<%
							if(hayInactivos) {
								for (String inactivo : inactivos) {
									%>
										<p>
											<%=inactivo%>
											<button type="button" type="submit" name="botonAceptar" class="btn btn-primary m-2 ">Activar</button>
										</p>
									<%					
								}
							} else {
								%>
									<p>
										<%=inactivos[0]%>
									</p>
								<%		
							}
							
						%>
				</section>
				<section class="col-4">
					<p>Usuarios Activos</p>
						<%
							for (String pendiente : pendientes) {
								%>
									<p>
										<%=pendiente%>
										<button type="button" type="submit" name="botonAceptar" class="btn btn-primary m-2 ">Aceptar</button>
									</p>
								<%					
							}
						%>
				</section>
			</div>
		</form>
	</main>
</body>
</html>