<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%
	String [] pendientes = (String[])request.getAttribute("usuariosPendientes");
	String [] activos = (String[])request.getAttribute("usuariosActivos");
	String [] inactivos = (String[])request.getAttribute("usuariosInactivos");
%>
</head>
<body>
	<header>
		<nav class="navbar bg-light">
			<div class="container-fluid">
				<form class="d-flex" action="ServletNavbar" method="get">
					<button type="submit" name="bs"
						class="btn btn-link navbar-brand m-2">Logo</button>
				</form>
				<form class="d-flex" action="ServletNavbar" method="get">
					<ul class="nav">
						<li class="nav-item">
							<button type="submit" name="botonVolver" value="volver"
								class="btn btn-secondary m-2 ">Volver</button>
						</li>
					</ul>
				</form>
			</div>
		</nav>
	</header>
	<main class="container mt-5">
		<form action="ServletAdminPanel" method="get">
			<div class="row">
				<section class="col-4 d-flex flex-column">
					<p><b>Usuarios Activos</b></p>
					<%
					if(activos.length != 0) {
						for (String activo : activos) {
							%>
							<p>
								<%=activo%>
								<button type="submit" name="botonDesactivar" value=<%=activo%>
									class="btn btn-primary m-2 ">Desactivar</button>
							</p>
							<%					
						}
					} else {
						%>
						<p>
							No hay usuarios Activos
						</p>
						<%		
						}
					%>
				</section>
				<section class="col-4">
					<p><b>Usuarios Inactivos</b></p>
					<%
					if(inactivos.length != 0) {
						for (String inactivo : inactivos) {
							%>
							<p>
								<%=inactivo%>
								<button type="submit" name="botonActivar" value=<%=inactivo%>
									class="btn btn-primary m-2 ">Activar</button>
								<button type="submit" name="botonRechazar" value=<%=inactivo%>
								class="btn btn-primary m-2 ">Eliminar</button>
							</p>
							<%					
						}
					} else {
						%>
						<p>
							No hay usuarios Inactivos
						</p>
						<%		
						}
					%>
				</section>
				<section class="col-4">
					<p><b>Usuarios Pendientes</b></p>
					<%
					if(pendientes.length != 0) {
						for (String pendiente : pendientes) {
							%>
							<p>
								<%=pendiente%>
								<button type="submit" name="botonActivar" value=<%=pendiente%>
									class="btn btn-primary m-2 ">Aceptar</button>
								<button type="submit" name="botonRechazar" value=<%=pendiente%>
									class="btn btn-primary m-2 ">Rechazar</button>
							</p>
							<%					
						}
					} else {
						%>
						<p>
							No hay usuarios Pendientes
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