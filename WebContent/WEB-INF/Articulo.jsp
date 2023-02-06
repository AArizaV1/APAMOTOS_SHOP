<%@page import="modelo.clienteVO"%>
<%@page import="modelo.articuloVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.articuloDAO"%>
<%@page import="modelo.clienteDAO"%>
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
<title>Gestión articulo</title>

<%
	HttpSession sesion;
	sesion = request.getSession();

	String documento;
	String codigo;

	documento = (String) sesion.getAttribute("documento");
%>



</head>
<body>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Descripción</th>
					<th scope="col">Precio</th>
					<th scope="col">Código</th>
					<th scope="col">Categoria</th>
					<th scope="col">Cilindrada</th>
					<th scope="col">Imagen</th>
					<th scope="col">&nbsp;</th>
					<th scope="col">&nbsp;</th>
				</tr>
			</thead>
			<tbody>

				<%
					//Array de articulo
					ArrayList<articuloVO> listaArticulos;
					//Cargamos el listado de articulos desde BD
					listaArticulos = articuloDAO.cargarArticulos(documento, 1, 6);
					//Recorremos el arraylist
					for (int i = 0; i < listaArticulos.size(); i++) {

						codigo = listaArticulos.get(i).getCodigo();

						session.setAttribute("codigo", codigo);
						//Generamos la fila con tr
						out.println("<tr>");
						//Mostramos en cada celda td los datos correspondientes a su columna
						out.println("<td scope='row'>" + listaArticulos.get(i).getNombre() + "</td>");
						out.println("<td scope='row'>" + listaArticulos.get(i).getDescripcion() + "</td>");
						out.println("<td scope='row'>" + listaArticulos.get(i).getPrecio() + "</td>");
						out.println("<td scope='row'>" + listaArticulos.get(i).getCodigo() + "</td>");
						out.println("<td scope='row'>" + listaArticulos.get(i).getCategoria() + "</td>");
						out.println("<td scope='row'>" + listaArticulos.get(i).getCilindrada() + "</td>");
						out.println("<td scope='row'> <img src='ServletImagenArticulo?codigo=" + codigo
								+ "'  height='100px' width='150px' style='margin: 10px;'/>  </td>");
						//Formulario para eliminar Articulos src='TFG.ServletImagenArticulo?codigo="+prueba+"'
						out.println("<td>");
						out.println("<form method='post' action='ServletEliminarArticulo'>");
						out.println(
								"<input class='btn btn-light action-button' style='background-color: red; color: white;' type='submit' value='Eliminar'/>");
						out.println("<input type='hidden' value='" + listaArticulos.get(i).getCodigo() + "' name='codigo' />");
						out.println("</form></td>");
						out.println("</td>");

						//Formulario para editar Articulos
						out.println("<td>");
						out.println("<form action='ServletVerEditarArticulo?codigo=" + listaArticulos.get(i).getCodigo()
								+ "' method='post'>");
						out.println(
								"<input class='btn btn-light action-button' style='background-color: orange; color: white;' type='submit' value='Modificar'/>");

						out.println("<input type='hidden' value='" + listaArticulos.get(i).getNombre() + "' name='nombre' />");
						out.println("<input type='hidden' value='" + listaArticulos.get(i).getDescripcion()
								+ "' name='descripcion' />");
						out.println("<input type='hidden' value='" + listaArticulos.get(i).getPrecio() + "' name='precio' />");
						out.println("<input type='hidden' value='" + listaArticulos.get(i).getCodigo() + "' name='codigo' />");
						out.println("<input type='hidden' value='" + listaArticulos.get(i).getCategoria()
								+ "' name='categoria' />");
						out.println("<input type='hidden' value='" + listaArticulos.get(i).getCilindrada()
								+ "' name='cilindrada' />");

						out.println("</form></td>");
						out.println("</tr>");

					}

					//Cerrar sesion y Volver
					out.println("<div style='margin-top:3em;'>");
					out.println(
							"<a class='btn btn-light action-button' role='button' href='ServletCerrarSesion' style='background-color: gray; color: white;'>Cerrar sesión</a>");
					out.println(
							"<a class='btn btn-light action-button' role='button' href='ServletGestion' style='background-color: gray; color: white;'>Volver</a>");
					out.println("</div>");

					//Formulario Insertar Articulo
					out.println("<div style='margin-top:2em; margin-bottom:1em;'>");
					out.println("<form action='ServletInsertarArticulo' method='post'>");
					out.println(
							"<a class='btn btn-light action-button' role='button' href='ServletVerInsertarArticulo' style='background-color: blue; color: white;'>Insertar artículo</a>");
					out.println("</form>");
					out.println("</div>");
				%>
			</tbody>
		</table>
	</div>
</body>
</html>