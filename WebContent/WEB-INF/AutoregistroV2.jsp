<%@page import="modelo.clienteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sing up</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="css/stylesignup.css">
</head>

<body>
	<%
		clienteVO cliente;

		cliente = (clienteVO) session.getAttribute("cliente");
	%>
	<div class="wrapper" style="background-image: url('images/bg2.jpeg');">
		<div class="inner">
			<div class="image-holder">
				<img src="images/bgyamaha.jpg" alt="">
			</div>
			<form action="ServletRegistrarCliente" method="post">
				<div class="row">
					<div class="mb-4">
						<h3>Crea una cuenta</h3>
						<p class="mb-4">Únete a nosotros y déjate sorprender por los
							mejores precios del mercado en motocicletas.</p>
					</div>

					<div>
						<p>
							<%  if (request.getAttribute("errorPassword") != null) {
									out.print(" <p style='color:#ff0000';>Las contraseñas no coinciden.</p>");
									}; 
								%>
						</p>

					</div>
					<br>
					<!-- Nombre -->
					<div class="input-group col-lg-12 mb-4">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-user text-muted"></i>
							</span>
						</div>
						<input id="name" type="text" name="nombre" placeholder="Nombre *"
							class="form-control bg-white border-left-0 border-md" required>
					</div>

					<!-- Edad -->
					<div class="input-group col-lg-12 mb-4">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-user text-muted"></i>
							</span>
						</div>
						<input id="edad" type="number" name="edad" placeholder="Edad *"
							class="form-control bg-white border-left-0 border-md" required>
					</div>

					<!-- Email  -->
					<div class="input-group col-lg-12 mb-4">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-envelope text-muted"></i>
							</span>
						</div>
						<input id="correo" type="email" name="correo"
							placeholder="Correo electrónico *"
							class="form-control bg-white border-left-0 border-md" required>
					</div>

					<!-- Contrasena -->
					<div class="input-group col-lg-6 mb-4">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-lock text-muted"></i>
							</span>
						</div>
						<input id="contrasena" type="password" name="contrasena"
							placeholder="Contraseña *"
							class="form-control bg-white border-left-0 border-md" required>
					</div>

					<!-- Repeat Contrasena -->
					<div class="input-group col-lg-6 mb-4">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-lock text-muted"></i>
							</span>
						</div>
						<input id="contrasena2" type="password" name="contrasena2"
							placeholder="Repetir contraseña *"
							class="form-control bg-white border-left-0 border-md" required>
					</div>

					<!-- Documento -->
					<div class="input-group col-lg-12 mb-4">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-user text-muted"></i>
							</span>
						</div>
						<input id="documento" type="text" name="documento"
							placeholder="DNI *"
							class="form-control bg-white border-left-0 border-md" required>
					</div>


					<!-- Phone Number -->
					<div class="form-group">
						<div class="form-group">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-phone-square text-muted"></i>
							</span>
						</div>
						<select id="countryCode" name="countryCode"
							style="max-width: 80px"
							class="custom-select form-control font-weight-bold text-muted">
							<option value="">+34</option>
							<option value="">+93</option>
							<option value="">+355</option>
							<option value="">+49</option>
							<option value="">+ ...</option>
						</select>
						<div class="ajusteTel" style="max-width: 500px">
							<input id="telefono" type="text" name="telefono"
								placeholder="Teléfono *" class="form-control" required>
						</div>
					</div>


					<!-- Ciudad  -->
					<div class="input-group col-lg-12 mb-4">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-white px-4 border-md border-right-0">
								<i class="fa fa-user text-muted"></i>
							</span>
						</div>
						<input id="ciudad" type="text" name="ciudad"
							placeholder="Localidad"
							class="form-control bg-white border-left-0 border-md" required>
					</div>

					<!-- Already Registered -->
					<div class="text-center w-100">
						<p class="text-muted font-weight-bold">
							¿Ya tienes cuenta? <a href="ServletLogin"
								class="text-primary ml-2">Inicia sesión</a>
						</p>
					</div>

					<button>
						Regístrate <i class="zmdi zmdi-arrow-right"></i>
					</button>
			</form>

		</div>
	</div>




	<script>
		$(function() {
			$('input, select').on(
					'focus',
					function() {
						$(this).parent().find('.input-group-text').css(
								'border-color', '#80bdff');
					});
			$('input, select').on(
					'blur',
					function() {
						$(this).parent().find('.input-group-text').css(
								'border-color', '#ced4da');
					});
		});
	</script>
</body>
</html>