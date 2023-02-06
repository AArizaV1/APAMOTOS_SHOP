<%@page import="modelo.cilindradaVO"%>
<%@page import="modelo.articuloDAO"%>
<%@page import="modelo.categoriaVO"%>
<%@page import="modelo.articuloVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px;">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<title>Catálogo</title>

<link rel="stylesheet" href="./css/nicepage.css" media="screen">
<link rel="stylesheet" href="./css/Catalogo.css" media="screen">

<script class="u-script" type="text/javascript" src="./js/jquery.js"></script>
<script class="u-script" type="text/javascript" src="./js/nicepage.js"></script>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
</head>

<%
	String codigo;

	ArrayList<articuloVO> articulos;
	ArrayList<categoriaVO> familias;
	ArrayList<cilindradaVO> cilindradas;

	int filtroArticulo = 0;
	int filtroFamilia = 0;
	int filtroCilindrada = 0;

	int totalPaginas = 1;
	boolean siguiente = false;
	boolean anterior = false;

	totalPaginas = (int) request.getAttribute("totalPaginas");
	siguiente = (boolean) request.getAttribute("siguiente");
	anterior = (boolean) request.getAttribute("anterior");

	articulos = (ArrayList<articuloVO>) request.getAttribute("articulo");
	familias = (ArrayList<categoriaVO>) request.getAttribute("categoria");
	cilindradas = (ArrayList<cilindradaVO>) request.getAttribute("cilindrada");

	if (request.getParameter("filtroArticulo") != null) {
		filtroArticulo = Integer.parseInt(request.getParameter("filtroArticulo"));
	}

	if (request.getParameter("filtroFamilia") != null) {
		filtroFamilia = Integer.parseInt(request.getParameter("filtroFamilia"));
	}

	if (request.getParameter("filtroCilindrada") != null) {
		filtroCilindrada = Integer.parseInt(request.getParameter("filtroCilindrada"));
	}
%>

<%!public static String mostrarPaginacion(int numPagina) {
		String paginacion = "";

		paginacion += "<a href='/APAmotos/ServletVerCatalogo?numPagina=" + (numPagina - 1) + "'>Anterior</a>";
		paginacion += "<a href='/APAmotos/ServletVerCatalogo?numPagina=" + (numPagina - 1) + "'>" + (numPagina - 1)
				+ "</a>";
		paginacion += " " + numPagina + " ";
		paginacion += "<a href='/APAmotos/ServletVerCatalogo?numPagina=" + (numPagina + 1) + "'>Posterior</a>";
		return paginacion;
	}%>

<%
	//Recuperamos el tipo de pagina
	int numPagina = 1;
	if (request.getAttribute("numPagina") != null)
		numPagina = (int) request.getAttribute("numPagina");
%>

<body class="u-body u-xl-mode" onload=init()>


	<script type='application/javascript' src='./js/buscarNombre.js'></script>
	<script type='text/javascript'>
  function init() {
	  //SBNombre=new SocketBuscarNombre('ws://localhost:8082/APAmotos/SBNombre')};
	  SBNombre=new SocketBuscarNombre('ws://ns3034756.ip-91-121-81.eu:8080/APAmotos/SBNombre')};
  </script>

	<!---------------------------------------------------------------- HEADER ---------------------------------------------------------------->
	<header class="u-clearfix u-header u-grey-80 u-header" id="sec-d5cf">
		<div class="u-clearfix u-sheet u-sheet-1">
			<a href="ServletInicio" class="u-image u-logo u-image-1"> <img
				src="./images/default-logo.png" class="u-logo-image u-logo-image-1"
				style="width: 150px;">
			</a>
			<nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
				<div class="menu-collapse"
					style="font-size: 1rem; letter-spacing: 0px; font-weight: 700; text-transform: uppercase;">
					<a
						class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-white u-text-body-alt-color u-text-hover-grey-70"
						href="#"> <svg class="u-svg-link" viewBox="0 0 24 24">
              	<use xmlns:xlink="http://www.w3.org/1999/xlink"
								xlink:href="#menu-hamburger"></use>
              </svg> <svg class="u-svg-content" version="1.1"
							id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px"
							xmlns:xlink="http://www.w3.org/1999/xlink"
							xmlns="http://www.w3.org/2000/svg">
	              <g>
		              <rect y="1" width="16" height="2"></rect>
		              <rect y="7" width="16" height="2"></rect>
		              <rect y="13" width="16" height="2"></rect>
				  </g>
			 </svg>
					</a>
				</div>
				<div class="u-nav-container">
					<ul class="u-nav u-spacing-0 u-unstyled u-nav-1">
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-white u-text-body-alt-color u-text-hover-grey-70"
							href="ServletVerCatalogo" style="padding: 10px 20px;">CATÁLOGO</a>
						</li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-white u-text-body-alt-color u-text-hover-grey-70"
							href="ServletAtencionCliente" style="padding: 10px 20px;">ATENCIÓN
								AL CLIENTE</a></li>
						<li class="u-nav-item"><a
							class="u-button-style u-nav-link u-text-active-white u-text-body-alt-color u-text-hover-grey-70"
							href="ServletLogin" style="padding: 10px 20px;">LOG IN</a></li>
					</ul>
				</div>
				<div class="u-nav-container-collapse">
					<div
						class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
						<div class="u-inner-container-layout u-sidenav-overflow">
							<div class="u-menu-close"></div>
							<ul
								class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2">
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="ServletVerCatalogo" style="padding: 10px 20px;">CATÁLOGO</a>
								</li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="ServletAtencionCliente" style="padding: 10px 20px;">ATENCIÓN
										AL CLIENTE</a></li>
								<li class="u-nav-item"><a class="u-button-style u-nav-link"
									href="ServletLogin" style="padding: 10px 20px;">LOG IN</a></li>
							</ul>
						</div>
					</div>
					<div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
				</div>
			</nav>
		</div>
	</header>
	<!---------------------------------------------------------------- FIN HEADER ---------------------------------------------------------------->


	<!---------------------------------------------------------------- FILTROS ---------------------------------------------------------------->
	<div class="filtros">
		<form action="ServletVerCatalogo" method="post">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">Nombre:</span>
				</div>
				<input type="text" onkeyup="SBNombre.filtrar()" id="nombre" /> <select
					name="filtroArticulo" class="custom-select" id="inputGroupSelect04">
					<option value="1" <%if (filtroArticulo == 1) {%> selected <%}%>>Nombre
						(A-Z)</option>
					<option value="2" <%if (filtroArticulo == 2) {%> selected <%}%>>Nombre
						(Z-A)</option>
					<option value="3" <%if (filtroArticulo == 3) {%> selected <%}%>>Precio
						Ascendente</option>
					<option value="4" <%if (filtroArticulo == 4) {%> selected <%}%>>Precio
						Descendente</option>
				</select> <select name="filtroFamilia" class="custom-select"
					id="inputGroupSelect04">
					<option value="0" <%if (filtroFamilia == 0) {%> selected <%}%>>Sin
						filtros</option>
					<%
						for (int i = 0; i < familias.size(); i++) {
					%>
					<option value="<%=familias.get(i).getId()%>"
						<%if (filtroFamilia == familias.get(i).getId()) {%> selected
						<%}%>>
						<%=familias.get(i).getNombre()%>
					</option>
					<%
						}
					%>
				</select> <select name="filtroCilindrada" class="custom-select"
					id="inputGroupSelect04">
					<option value="0" <%if (filtroCilindrada == 0) {%> selected <%}%>>Sin
						filtros</option>
					<%
						for (int i = 0; i < cilindradas.size(); i++) {
					%>
					<option value="<%=cilindradas.get(i).getId()%>"
						<%if (filtroCilindrada == cilindradas.get(i).getId()) {%> selected
						<%}%>>
						<%=cilindradas.get(i).getNombre()%>
					</option>
					<%
						}
					%>
				</select>


				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="submit">FILTRAR</button>
				</div>
			</div>
		</form>
	</div>
	<!---------------------------------------------------------------- FIN FILTROS ---------------------------------------------------------------->


	<!---------------------------------------------------------------- ARTICULOS ---------------------------------------------------------------->
	<section class="u-clearfix u-section-1" id="sec-f024">
		<div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
			<div class="u-blog u-expanded-width u-repeater u-repeater-1">
				<%
					//Recorremos el arraylist
					for (int i = 0; i < articulos.size(); i++) {
						codigo = articulos.get(i).getCodigo();

						out.println("<div class='u-blog-post u-container-style u-repeater-item u-white u-repeater-item-1'>");
						out.println(
								"<div class='u-container-layout u-similar-container u-valign-top u-container-layout-1' name='card'>");
						out.println("<h4 class='u-blog-control u-text u-text-1'>");
						out.println("<a class='u-post-header-link' href='ServletVerMas?codigo=" + codigo + "'><b name='nombre'>"
								+ articulos.get(i).getNombre() + "</b></a>");
						out.println("</h4>");
						out.println("<a class='u-post-header-link' href='ServletVerMas?codigo=" + codigo
								+ "'><img alt='' class='u-blog-control u-expanded-width u-image u-image-default u-image-1' src='ServletImagenArticulo?codigo="
								+ codigo + "' ></a>");
						out.println("<div class='u-blog-control u-post-content u-text u-text-2 fr-view'>"
								+ articulos.get(i).getDescripcion().substring(0, 35) + "...</div>");
						out.println("<div class='u-blog-control u-post-content u-text u-text-1 fr-view'><strong>"
								+ articulos.get(i).getPrecio() + "€</strong></div>");
						out.println("<a href='ServletVerMas?codigo=" + codigo
								+ "' class='u-blog-control u-border-2 u-border-palette-1-base u-btn u-btn-rectangle u-button-style u-none u-btn-1'>Ver más...</a>");
						out.println("</div>");
						out.println("</div>");
					}
				%>
			</div>
		</div>
	</section>

	<div class="filtros">

		<div class="fila">
			<%
				if (anterior) {
			%>
			<input id="siguienteYanterior" name="boton_enlace" type="button"
				onclick="location.href='ServletVerCatalogo?numPagina=<%=numPagina - 1%>';"
				value="Anterior" />
			<%
				}
			%>

			<%
				for (int i = 1; i < totalPaginas + 1; i++) {
					if (i == numPagina) {
			%>
			<input id="boton_paginacion_actual" type="button"
				onclick="location.href='ServletVerCatalogo?numPagina=<%=numPagina%>';"
				value="<%=numPagina%>" />
			<%
				} else {
			%>
			<input id="boton_paginacion" name="boton_enlace" type="button"
				onclick="location.href='ServletVerCatalogo?numPagina=<%=i%>';"
				value="<%=i%>" />
			<%
				}
			%>
			<%
				}
			%>

			<%
				if (siguiente) {
			%>
			<input id="siguienteYanterior" name="boton_enlace" type="button"
				onclick="location.href='ServletVerCatalogo?numPagina=<%=numPagina + 1%>';"
				value="Siguiente" />
			<%
				}
			%>

		</div>

	</div>
	<!---------------------------------------------------------------- FIN ARTICULOS ---------------------------------------------------------------->


	<!---------------------------------------------------------------- FOOTER ---------------------------------------------------------------->

	<footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer"
		id="sec-167b">
		<section class="u-backlink u-clearfix u-grey-80">
			<p class="u-text">
				<span>Adrián Ariza Patrón ®</span>
			</p>
		</section>
	</footer>
	<!---------------------------------------------------------------- FIN FOOTER ---------------------------------------------------------------->

</body>
</html>