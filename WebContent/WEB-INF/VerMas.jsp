<%@page import="java.util.ArrayList"%>
<%@page import="modelo.articuloVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html style="font-size: 16px;">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<title>Ver más...</title>

<link rel="stylesheet" type="text/css" href="./css/nicepage.css"
	media="screen">
<link rel="stylesheet" type="text/css" href="./css/VerMas.css"
	media="screen">

<script class="u-script" type="text/javascript" src="./js/jquery.js"></script>
<script class="u-script" type="text/javascript" src="./js/nicepage.js"></script>



<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"
	integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY"
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>




</head>



<%
	Object[] articulosArray = null;

	if (request.getAttribute("articulosArray") != null) {

		articulosArray = (Object[]) request.getAttribute("articulosArray");
	}
%>





<body class="u-body u-xl-mode">

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


	<section class="u-align-center u-clearfix u-section-1" id="sec-0baa">
		<div
			class="u-clearfix u-sheet u-valign-middle-md u-valign-middle-sm u-valign-middle-xs u-sheet-1">
			<div
				class="u-container-style u-expanded-width u-post-details u-post-details-1">
				<div class="u-container-layout u-valign-middle u-container-layout-1">


					<img alt=""
						class="u-blog-control u-expand-width u-image u-image-default u-image-1"
						src="ServletImagenArticulo?codigo=<%=articulosArray[3]%>">

					<hr />

					<h2 class="u-blog-control u-text u-text-1">
						<strong> <%=articulosArray[0]%>
						</strong>
					</h2>

					<div class="u-blog-control u-metadata u-metadata-1">
						<span class="u-meta-date u-meta-icon"><strong>CATEGORIA:
						</strong><%=articulosArray[4]%></span> <span class="u-meta-date u-meta-icon"><strong>CILINDRADA:
						</strong><%=articulosArray[5]%></span>
					</div>

					<div
						class="u-align-justify u-blog-control u-post-content u-text u-text-2 fr-view">
						<strong>DESCRIPCIÓN:</strong>
						<%=articulosArray[1]%>
					</div>
					<div
						class="u-align-justify u-blog-control u-post-content u-text u-text-2 fr-view">
						<strong>MATRÍCULA:</strong>
						<%=articulosArray[3]%>
					</div>

					<br />

					<h2 class="u-blog-control u-text u-text-1"><%=articulosArray[2]%>
						€
					</h2>
				</div>
				<div class="d-flex justify-content-center">
					<div class="title mt-5 text-center">
						<h3>
							<b>¡ATRÉVETE!</b>
						</h3>
						<h3>
							<b>CONTACTA CON NUESTRO VENDEDOR</b>
						</h3>

						<hr>
						<button type="button" class="btn btn-success btn-lg"
							data-toggle="modal" data-target="#contactar">¡CONTACTAR!</button>

					</div>

					<!--modal -->
					<!-- Modal -->
					<div id="contactar" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">VENDEDOR</h4>
								</div>
								<div class="modal-body">
									<p>
										<strong>NOMBRE: </strong>
										<%=articulosArray[6]%></p>
									<p>
										<strong>EDAD: </strong>
										<%=articulosArray[7]%></p>
									<p>
										<strong>LOCALIDAD: </strong>
										<%=articulosArray[9]%></p>
									<p>
										<strong>CORREO: </strong>
										<%=articulosArray[8]%></p>
									<p>
										<strong>TELEFONO: </strong>
										<%=articulosArray[10]%></p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

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