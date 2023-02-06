<%@page import="modelo.clienteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Gestión</title>

<%
	clienteVO cliente;
	String nombre;

	cliente = (clienteVO) session.getAttribute("cliente");

	nombre = (String) cliente.getNombre();
%>
</head>
<body>

	<%
		if (nombre != null)
			out.println("<div style='text-align:center; margin-top:10em;'>");
		out.println("<h4><b>Bienvenido </b>" + nombre + "<b>, este acceso es solo para ADMINS</b></h4>");
		out.println("</div>");
	%>

	<form action="ServletGestion" method="post">


		<div class="form-group row" style="margin-top: 5em;">
			<label for="select" class="col-4 col-form-label"></label>
			<div class="col-3">
				<select id="select" name="select" class="custom-select">
					<option value="articulo">Gestionar Articulo</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-4 col-8">
				<button name="submit" id="gestionar" type="submit"
					class="btn btn-primary">GESTIONAR</button>
			</div>
		</div>


	</form>


	<div style="margin-top: 5em; text-align: center;">
		<a class='btn btn-light action-button' role='button'
			href='ServletPerfil' style='background-color: gray; color: white;'>Volver</a>
		<a class='btn btn-light action-button' role='button'
			href='ServletCerrarSesion'
			style='background-color: gray; color: white;'>Cerrar sesión</a>
	</div>

</body>
</html>