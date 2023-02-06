<%@page import="modelo.clienteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>- EDITAR PERFIL -</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Bitter:400,700">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./css/stylePerfil.css">
</head>
<body>

	<%
		clienteVO cliente;
		String nombre;

		cliente = (clienteVO) session.getAttribute("cliente");
	%>

	<div>
		<div class="header-dark">
			<nav
				class="navbar navbar-dark navbar-expand-md navigation-clean-search">
				<div class="container">
					<a class="navbar-brand" href="ServletPerfil"> <%
 	nombre = (String) cliente.getNombre();
 	out.print(nombre);
 %>
					</a>
					<div class="collapse navbar-collapse" id="navcol-1">
						<form class="form-inline mr-auto" target="_self"></form>
						<span class="navbar-text"> </span> <a class="editar"
							href="ServletEditarPerfil">Editar perfil</a> <a
							class="btn btn-light action-button" role="button"
							href="ServletCerrarSesion">Cerrar sesión</a>
					</div>
				</div>
			</nav>
			<div class="container hero">
				<div class="row">
					<div class="col-md-8 offset-md-2">
						<h1 class="text-center">EDITAR IMAGEN</h1>

						<form action="ServletImagen" method="post"
							enctype="multipart/form-data">

							<div class="form-group">
								<label for="documento"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-address-card"></i>
										</div>
									</div>
									<input id="imagen" name="imagen" type="file"
										class="form-control">
								</div>
							</div>


							<div class="form-group">
								<button name="submit" type="submit"
									class="btn btn-light action-button">
									<b>ACTUALIZAR</b>
								</button>

							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>





</body>
</html>