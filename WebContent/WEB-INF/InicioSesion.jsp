<%@page import="Servlets.ServletLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
<title>Log in</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/stylelogin.css">



<%
//Inicializamos a 3 el número de intentos
int numIntentos = ServletLogin.NUM_INTENTOS;
//recuperamos el numero de intentos
if (request.getAttribute("numIntentos")!=null){
 numIntentos = (int) request.getAttribute("numIntentos");
}
%>


</head>
<body class="img js-fullheight"
	style="background-image: url(images/bg-moto.png);">

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<a class="heading-section" href="ServletInicio"><b>ARIZA
							MOTOR</b></a>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">

						<form action="ServletLogin" method="post" class="signin-form">
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Correo"
									id="correo" name="correo" required>
							</div>
							<div class="form-group">
								<input id="password-field" type="password" class="form-control"
									placeholder="Contraseña" id="contrasena" name="contrasena"
									required> <span toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>
							</div>
							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">
									<b>Iniciar sesión</b>
								</button>
							</div>
							<div class="form-group d-md-flex">
								<div class="w-50">
									<label class="checkbox-wrap checkbox-primary">Recuérdame
										<input type="checkbox" checked> <span
										class="checkmark"></span>
									</label>
								</div>
								<div class="w-50 text-md-right">
									<a href="#" style="color: #fff">Olvidé contraseña</a>
								</div>
							</div>
							<%
				//Si los intentos no son 3 se ha fallado en el login
				    if (numIntentos != ServletLogin.NUM_INTENTOS){
				%>
							<label style='color: #ff0000'><b>Hubo un error en los
									datos, intentelo de nuevo. Te quedan </b>
								<%out.print(numIntentos); %> <b>intentos.</b> </label>
							<%
					};
				%>
							<input type="hidden" name="numIntentos"
								value="<%out.print(numIntentos); %>">
						</form>

						<hr>
						<p class="w-100 text-center">
							<b>&mdash; ¿No tienes cuenta? &mdash;</b>
						</p>
						<div class="social d-flex text-center">
							<a href="ServletRegistrarCliente"
								class="btn btn-primary submit px-7"><b>Regístrate</b></a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>

	<script>
		$(function() {
			"use strict";

			$(".form-control").on("input", function() {
				var $field = $(this).closest(".form-group");
				if (this.value) {
					$field.addClass("field--not-empty");
				} else {
					$field.removeClass("field--not-empty");
				}
			});
		});
	</script>

</body>
</html>

