<%@page import="modelo.clienteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar perfil</title>
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
							href="ServletEditarImagen">Cambiar imagen</a> <a
							class="btn btn-light action-button" role="button"
							href="ServletCerrarSesion">Cerrar sesión</a>
					</div>
				</div>
			</nav>
			<div class="container hero">
				<div class="row">
					<div class="col-md-8 offset-md-2">
						<h1 class="text-center">EDITAR PERFIL</h1>

						<form action="ServletEditarPerfil" method="post">
							<input id="id" name="id" placeholder="Nuevo id" type="hidden"
								class="form-control" value="<%=cliente.getId()%>">
							<div class="form-group">
								<label for="documento"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-address-card"></i>
										</div>
									</div>
									<input id="documento" name="documento"
										placeholder="Nuevo documento de identidad..." type="text"
										class="form-control" value="<%=cliente.getDocumento()%>"
										readonly>
									<hr />
								</div>
								<a style="color: white"> Si deseas modificar el documento de
									identidad, contacte con <a href="ServletAtencionCliente">Atención
										al Cliente</a>.
								</a>
							</div>
							<div class="form-group">
								<label for="nombre"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-address-book"></i>
										</div>
									</div>
									<input id="nombre" name="nombre" placeholder="Nuevo nombre..."
										type="text" class="form-control"
										value="<%=cliente.getNombre()%>">
								</div>
							</div>
							<div class="form-group">
								<label for="edad"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-map-marker"></i>
										</div>
									</div>
									<input id="edad" name="edad" placeholder="Nueva edad..."
										type="number" class="form-control"
										value="<%=cliente.getEdad()%>">
								</div>
							</div>

							<div class="form-group">
								<label for="ciudad"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-map-signs"></i>
										</div>
									</div>
									<input id="ciudad" name="ciudad"
										placeholder="Nueva localidad..." type="text"
										class="form-control" value="<%=cliente.getCiudad()%>">
								</div>
							</div>

							<div class="form-group">
								<label for="correo"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-archive"></i>
										</div>
									</div>
									<input id="correo" name="correo"
										placeholder="Nuevo correo electrónico..." type="text"
										class="form-control" value="<%=cliente.getCorreo()%>">
								</div>
							</div>
							<div class="form-group">
								<label for="telefono"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-phone"></i>
										</div>
									</div>
									<input id="telefono" name="telefono"
										placeholder="Nuevo teléfono..." type="text"
										class="form-control" value="<%=cliente.getTelefono()%>">
								</div>
							</div>
							<div class="form-group">
								<label for="contrasena"></label>
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-compass"></i>
										</div>
									</div>
									<input id="contrasena" name="contrasena"
										placeholder="Nueva contraseña..." type="password"
										class="form-control" value="<%=cliente.getContrasena()%>">
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