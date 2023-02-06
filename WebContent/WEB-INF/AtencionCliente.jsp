<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html style="font-size: 16px;">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<title>Atención al Cliente</title>

<link rel="stylesheet" href="./css/nicepage.css" media="screen">
<link rel="stylesheet" href="./css/Casa.css" media="screen">
<script class="u-script" type="text/javascript" src="./js/jquery.js"
	defer=""></script>
<script class="u-script" type="text/javascript" src="./js/nicepage.js"
	defer=""></script>

<link id="u-theme-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
<link id="u-page-google-font" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i">



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
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




	<!---------------------------------------------------------------- SECTION ---------------------------------------------------------------->

	<section class="u-clearfix u-section-5" id="carousel_8bc9">
		<div
			class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-1">
			<div class="u-layout">
				<div class="u-layout-row">
					<div class="u-size-30">
						<div class="u-layout-row">
							<div
								class="u-container-style u-image u-layout-cell u-left-cell u-size-60 u-image-1"
								data-image-width="2250" data-image-height="1500">
								<div class="u-container-layout"></div>
							</div>
						</div>
					</div>
					<div class="u-size-30">
						<div class="u-layout-col">
							<div
								class="u-container-style u-image u-layout-cell u-right-cell u-size-30 u-image-2"
								data-image-width="2250" data-image-height="1500">
								<div class="u-container-layout"></div>
							</div>
							<div
								class="u-align-left u-container-style u-image u-layout-cell u-right-cell u-size-30 u-image-3"
								data-image-width="2250" data-image-height="1500">
								<div class="u-container-layout"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!---------------------------------------------------------------- FIN SECTION ---------------------------------------------------------------->





	<!---------------------------------------------------------------- SECTION ---------------------------------------------------------------->
	<section class="u-align-center u-black u-clearfix u-section-8"
		id="carousel_be4e">
		<div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
			<div class="u-clearfix u-layout-wrap u-layout-wrap-1">
				<div class="u-layout">
					<div class="u-layout-col">
						<div class="u-size-30">
							<div class="u-layout-row">
								<div
									class="u-container-style u-layout-cell u-left-cell u-right-cell u-size-60 u-layout-cell-1">
									<div
										class="u-container-layout u-valign-top u-container-layout-1">
										<h2 class="u-align-center u-text u-text-default u-text-1">
											<b>CONTÁCTANOS</b>
										</h2>
										<p class="u-align-center u-text u-text-grey-40 u-text-2">Atención
											al Cliente - 24H</p>
									</div>
								</div>
							</div>
						</div>
						<div class="u-size-30">
							<div class="u-layout-row">
								<div
									class="u-align-center u-container-style u-layout-cell u-left-cell u-size-20 u-layout-cell-2">
									<div
										class="u-container-layout u-valign-top u-container-layout-2">
										<span class="u-icon u-icon-circle u-icon-1"><svg
												class="u-svg-link" preserveAspectRatio="xMidYMin slice"
												viewBox="0 0 60 60" style="">
												<use xmlns:xlink="http://www.w3.org/1999/xlink"
													xlink:href="#svg-77c8"></use></svg>
											<svg class="u-svg-content" viewBox="0 0 60 60" x="0px"
												y="0px" id="svg-77c8"
												style="enable-background: new 0 0 60 60;">
												<g>
												<path
													d="M30,26c3.86,0,7-3.141,7-7s-3.14-7-7-7s-7,3.141-7,7S26.14,26,30,26z M30,14c2.757,0,5,2.243,5,5s-2.243,5-5,5
		s-5-2.243-5-5S27.243,14,30,14z"></path>
												<path
													d="M29.823,54.757L45.164,32.6c5.754-7.671,4.922-20.28-1.781-26.982C39.761,1.995,34.945,0,29.823,0
		s-9.938,1.995-13.56,5.617c-6.703,6.702-7.535,19.311-1.804,26.952L29.823,54.757z M17.677,7.031C20.922,3.787,25.235,2,29.823,2
		s8.901,1.787,12.146,5.031c6.05,6.049,6.795,17.437,1.573,24.399L29.823,51.243L16.082,31.4
		C10.882,24.468,11.628,13.08,17.677,7.031z"></path>
												<path
													d="M42.117,43.007c-0.55-0.067-1.046,0.327-1.11,0.876s0.328,1.046,0.876,1.11C52.399,46.231,58,49.567,58,51.5
		c0,2.714-10.652,6.5-28,6.5S2,54.214,2,51.5c0-1.933,5.601-5.269,16.117-6.507c0.548-0.064,0.94-0.562,0.876-1.11
		c-0.065-0.549-0.561-0.945-1.11-0.876C7.354,44.247,0,47.739,0,51.5C0,55.724,10.305,60,30,60s30-4.276,30-8.5
		C60,47.739,52.646,44.247,42.117,43.007z"></path>
</g></svg></span>
										<h5 class="u-text u-text-default u-text-3">Address</h5>
										<p class="u-text u-text-default u-text-4">El Puerto de
											Santa María, 11500. Cádiz.</p>
									</div>
								</div>
								<div
									class="u-align-center u-container-style u-layout-cell u-size-20 u-layout-cell-3">
									<div
										class="u-container-layout u-valign-top u-container-layout-3">
										<span class="u-icon u-icon-circle u-icon-2"><svg
												class="u-svg-link" preserveAspectRatio="xMidYMin slice"
												viewBox="0 0 60 60" style="">
												<use xmlns:xlink="http://www.w3.org/1999/xlink"
													xlink:href="#svg-9863"></use></svg>
											<svg class="u-svg-content" viewBox="0 0 60 60" x="0px"
												y="0px" id="svg-9863"
												style="enable-background: new 0 0 60 60;">
												<g>
												<path
													d="M42.595,0H17.405C14.977,0,13,1.977,13,4.405v51.189C13,58.023,14.977,60,17.405,60h25.189C45.023,60,47,58.023,47,55.595
		V4.405C47,1.977,45.023,0,42.595,0z M15,8h30v38H15V8z M17.405,2h25.189C43.921,2,45,3.079,45,4.405V6H15V4.405
		C15,3.079,16.079,2,17.405,2z M42.595,58H17.405C16.079,58,15,56.921,15,55.595V48h30v7.595C45,56.921,43.921,58,42.595,58z"></path>
												<path
													d="M30,49c-2.206,0-4,1.794-4,4s1.794,4,4,4s4-1.794,4-4S32.206,49,30,49z M30,55c-1.103,0-2-0.897-2-2s0.897-2,2-2
		s2,0.897,2,2S31.103,55,30,55z"></path>
												<path
													d="M26,5h4c0.553,0,1-0.447,1-1s-0.447-1-1-1h-4c-0.553,0-1,0.447-1,1S25.447,5,26,5z"></path>
												<path
													d="M33,5h1c0.553,0,1-0.447,1-1s-0.447-1-1-1h-1c-0.553,0-1,0.447-1,1S32.447,5,33,5z"></path>
												<path
													d="M56.612,4.569c-0.391-0.391-1.023-0.391-1.414,0s-0.391,1.023,0,1.414c3.736,3.736,3.736,9.815,0,13.552
		c-0.391,0.391-0.391,1.023,0,1.414c0.195,0.195,0.451,0.293,0.707,0.293s0.512-0.098,0.707-0.293
		C61.128,16.434,61.128,9.085,56.612,4.569z"></path>
												<path
													d="M52.401,6.845c-0.391-0.391-1.023-0.391-1.414,0s-0.391,1.023,0,1.414c1.237,1.237,1.918,2.885,1.918,4.639
		s-0.681,3.401-1.918,4.638c-0.391,0.391-0.391,1.023,0,1.414c0.195,0.195,0.451,0.293,0.707,0.293s0.512-0.098,0.707-0.293
		c1.615-1.614,2.504-3.764,2.504-6.052S54.017,8.459,52.401,6.845z"></path>
												<path
													d="M4.802,5.983c0.391-0.391,0.391-1.023,0-1.414s-1.023-0.391-1.414,0c-4.516,4.516-4.516,11.864,0,16.38
		c0.195,0.195,0.451,0.293,0.707,0.293s0.512-0.098,0.707-0.293c0.391-0.391,0.391-1.023,0-1.414
		C1.065,15.799,1.065,9.72,4.802,5.983z"></path>
												<path
													d="M9.013,6.569c-0.391-0.391-1.023-0.391-1.414,0c-1.615,1.614-2.504,3.764-2.504,6.052s0.889,4.438,2.504,6.053
		c0.195,0.195,0.451,0.293,0.707,0.293s0.512-0.098,0.707-0.293c0.391-0.391,0.391-1.023,0-1.414
		c-1.237-1.237-1.918-2.885-1.918-4.639S7.775,9.22,9.013,7.983C9.403,7.593,9.403,6.96,9.013,6.569z"></path>
</g></svg></span>
										<h5 class="u-text u-text-default u-text-5">phone</h5>
										<p class="u-text u-text-default u-text-6">956 47 46 45</p>
									</div>
								</div>
								<div
									class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-container-style u-layout-cell u-right-cell u-size-20 u-layout-cell-4">
									<div
										class="u-container-layout u-valign-top u-container-layout-4">
										<span class="u-icon u-icon-circle u-icon-3"><svg
												class="u-svg-link" preserveAspectRatio="xMidYMin slice"
												viewBox="0 0 60 60" style="">
												<use xmlns:xlink="http://www.w3.org/1999/xlink"
													xlink:href="#svg-732e"></use></svg>
											<svg class="u-svg-content" viewBox="0 0 60 60" x="0px"
												y="0px" id="svg-732e"
												style="enable-background: new 0 0 60 60;">
												<g>
												<path
													d="M42.5,22h-25c-0.552,0-1,0.447-1,1s0.448,1,1,1h25c0.552,0,1-0.447,1-1S43.052,22,42.5,22z"></path>
												<path
													d="M17.5,16h10c0.552,0,1-0.447,1-1s-0.448-1-1-1h-10c-0.552,0-1,0.447-1,1S16.948,16,17.5,16z"></path>
												<path
													d="M42.5,30h-25c-0.552,0-1,0.447-1,1s0.448,1,1,1h25c0.552,0,1-0.447,1-1S43.052,30,42.5,30z"></path>
												<path
													d="M42.5,38h-25c-0.552,0-1,0.447-1,1s0.448,1,1,1h25c0.552,0,1-0.447,1-1S43.052,38,42.5,38z"></path>
												<path
													d="M42.5,46h-25c-0.552,0-1,0.447-1,1s0.448,1,1,1h25c0.552,0,1-0.447,1-1S43.052,46,42.5,46z"></path>
												<path
													d="M38.914,0H6.5v60h47V14.586L38.914,0z M39.5,3.414L50.086,14H39.5V3.414z M8.5,58V2h29v14h14v42H8.5z"></path>
</g></svg></span>
										<h5 class="u-align-center-xl u-text u-text-default u-text-7">email</h5>
										<p class="u-align-center-xl u-text u-text-default u-text-8">help@ArizaMotor.es</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!---------------------------------------------------------------- FIN SECTION ---------------------------------------------------------------->


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