<%@page import="modelo.clienteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Perfil</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Bitter:400,700">
<link rel="stylesheet" href="./css/stylePerfil.css">
</head>
<body>

	<%
		clienteVO cliente;
		String nombre;

		cliente = (clienteVO) session.getAttribute("cliente");
		nombre = (String) cliente.getNombre();
	%>

	<header class="u-clearfix u-header u-grey-80 u-header" id="sec-d5cf">
		<div>
			<div class="header-dark">
				<nav
					class="navbar navbar-dark navbar-expand-md navigation-clean-search">
					<div class="container">

						<img src="ServletImagen" height="100"
							style="margin: 10px; border-radius: 60px;" /> <a
							class="navbar-brand" href="ServletPerfil"> <%
 	nombre = (String) cliente.getNombre().split(" ")[0];
 	out.print(nombre);
 %>
						</a>


						<div class="collapse navbar-collapse" id="navcol-1">
							<form class="form-inline mr-auto" target="_self"></form>
							<span class="navbar-text"> <a class="editar"
								href="ServletEditarImagen">Cambiar imagen</a> <a class="editar"
								href="ServletEditarPerfil">Editar perfil</a>
							</span> <a class="btn btn-light action-button" role="button"
								href="ServletCerrarSesion">Cerrar sesión</a>
						</div>
					</div>
				</nav>
				<div class="container hero">
					<div class="row">
						<div class="col-md">
							<h1 class="text-center">
								<%
									out.print(nombre + ", adéntrate y mira nuestro catálogo.");
								%>
							</h1>
						</div>
					</div>
				</div>

				<div class="col-auto p-5 text-center">
					<div class="form-group row">
						<div class="offset-4 col-4">
							<a role="button" href="ServletVerCatalogo"><button
									name="submit" type="submit" class="btn btn-primary">CATÁLOGO</button></a>
						</div>
					</div>
				</div>
</header>
					
				<% if (nombre != null)
			out.println("<div style='text-align:center; margin-top:5em;'>");
			out.println("<h4><b>Bienvenido </b>" + nombre + "<b>, este acceso es solo para ADMINS</b></h4>");
			out.println("</div>");
			%>


	<div class="col-auto p-5 text-center">
		<form action="ServletGestion" method="post">


			<div class="form-group row" style="margin-top: 2em;">
				<label for="select" class="col-5 col-form-label"></label>
				<div class="col-2">
					<select id="select" name="select" class="custom-select text-center">
						<option value="articulo">Gestionar Articulo</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="offset-4 col-4">
					<button name="submit" type="submit" class="btn btn-primary">GESTIONAR</button>
				</div>
			</div>


		</form>
	</div>

	<div style="margin-top: 2em; text-align: center;">
		<a class='btn btn-light action-button' role='button'
			href='ServletCerrarSesion'
			style='background-color: gray; color: white;'>Cerrar sesión</a>
	</div>















</body>
</html>