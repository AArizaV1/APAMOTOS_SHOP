<%@page import="java.util.ArrayList"%>
<%@page import="modelo.articuloVO"%>
<%@page import="modelo.clienteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>EDITAR ARTICULO</title>
</head>
<body>

	<%
		articuloVO articulo;
		
		articulo = (articuloVO) request.getAttribute("articulo");
	%>

	<div style="text-align: center; margin-top: 5em; margin-bottom: 2em;">
		<h3>
			<b>EDITAR ARTÍCULO</b>
		</h3>

		<%
			out.println("<td scope='row'> <img src='ServletImagenArticulo?codigo=" + articulo.getCodigo() + "'  height='100' style='margin: 10px;'/>  </td>");
			%>

	</div>




	<%



		out.println("<form action='ServletImagenArticulo?codigo="+articulo.getCodigo()+"' method='post' enctype='multipart/form-data'>");
%>
	<div class="form-group row">
		<label for="imagen" class="col-4 col-form-label"></label>
		<div class="col-4">
			<div class="input-group">
				<div class="input-group-prepend">
					<div class="input-group-text">
						<i class="fa fa-address-book"></i>
					</div>
				</div>
				<input id="imagen" name="imagen" type="file" class="form-control">
			</div>
		</div>
	</div>

	<div class="form-group row">
		<div class="offset-4 col-4">
			<button name="submit" type="submit"
				class="btn btn-light action-button"
				style="background-color: gray; color: white;">
				<b>ACTUALIZAR IMAGEN</b>
			</button>
		</div>
	</div>

	


	<form action="ServletEditarArticulo" method="post">
		<div>
			<input type="hidden" name="codigo" value="<%=articulo.getCodigo()%>" />

			<div class="form-group row">
				<label for="nombre" class="col-4 col-form-label"></label>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-address-book"></i>
							</div>
						</div>
						<input id="nombre" name="nombre"
							placeholder="Introducir nombre..." type="text"
							class="form-control" value="<%=articulo.getNombre()%>">
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="descripcion" class="col-4 col-form-label"></label>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-sort-amount-desc"></i>
							</div>
						</div>
						<input id="descripcion" name="descripcion"
							placeholder="Introducir breve descripción..." type="text"
							class="form-control" value="<%=articulo.getDescripcion()%>">
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label for="precio" class="col-4 col-form-label"></label>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-taxi"></i>
							</div>
						</div>
						<input id="precio" name="precio"
							placeholder="Introducir Precio..." type="text"
							class="form-control" value="<%=articulo.getPrecio()%>">
					</div>
				</div>
			</div>


			<div class="form-group row">
				<label for="categoria" class="col-4 col-form-label"></label>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Categoría:</span>
						</div>
						<select name="categoria" id="categoria">
							<option value="1" <% if(articulo.getCategoria() == 1){ %>
								selected <% }%>>Carretera</option>
							<option value="2" <% if(articulo.getCategoria() == 2){ %>
								selected <% }%>>Naked</option>
							<option value="3" <% if(articulo.getCategoria() == 3){ %>
								selected <% }%>>Deportiva</option>
							<option value="4" <% if(articulo.getCategoria() == 4){ %>
								selected <% }%>>Cross</option>
							<option value="5" <% if(articulo.getCategoria() == 5){ %>
								selected <% }%>>Trail</option>
						</select>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="cilindrada" class="col-4 col-form-label"></label>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Cilindrada:</span>
						</div>
						<select name="cilindrada" id="cilindrada">
							<option value="1" <% if(articulo.getCilindrada() == 1){ %>
								selected <% }%>>49cc</option>
							<option value="2" <% if(articulo.getCilindrada() == 2){ %>
								selected <% }%>>125cc</option>
							<option value="3" <% if(articulo.getCilindrada() == 3){ %>
								selected <% }%>>250cc</option>
							<option value="4" <% if(articulo.getCilindrada() == 4){ %>
								selected <% }%>>600cc</option>
							<option value="5" <% if(articulo.getCilindrada() == 5){ %>
								selected <% }%>>900cc</option>
							<option value="5" <% if(articulo.getCilindrada() == 5){ %>
								selected <% }%>>1200cc</option>
						</select>
					</div>
				</div>
			</div>

			<div class="form-group row">
				<div class="offset-4 col-4">
					<button name="submit" type="submit" class="btn btn-primary">
						<b>EDITAR ARTÍCULO</b>
					</button>
				</div>
			</div>
		</div>
	</form>
	<hr />
	<div style="margin-left: 15em;">
		<a class="btn btn-light action-button" role="button"
			href="ServletCerrarSesion"
			style="background-color: gray; color: white;">Cerrar sesión</a> <a
			class="btn btn-light action-button" role="button"
			href="ServletGestion" style="background-color: gray; color: white;">Volver</a>
	</div>
	<hr />
</body>
</html>