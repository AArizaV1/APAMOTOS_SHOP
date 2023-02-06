<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet" />

<!-- Style -->
<link rel="stylesheet" href="./css/styleVerificacion.css"
	type="text/css" />


<title>Code verification</title>
</head>
<body class="img js-fullheight"
	style="background-image: url(images/bg.jpeg);">

	<div class="modal-dialog" role="document">
		<div class="modal-content rounded-5 shadow">
			<div class="modal-header p-5 pb-4 border-bottom-0">
				<h2 class="fw-bold mb-0">Revise su email.</h2>
			</div>

			<form action="ServletVerificarCodigo" method="post">

				<div class="modal-body p-5 pt-0">
					<div class="form-floating mb-3">
						<input type="email" class="form-control rounded-4"
							id="emailVerificar" name="emailVerificar"
							placeholder="Introduzca su email a verificar."> <label
							for="emailVerificar">Introduzca email a verificar.</label>
					</div>

					<div class="form-floating mb-3">
						<input type="text" class="form-control rounded-4" id="codigo"
							name="codigo" placeholder="Introduzca código de verificación.">
						<label for="codigo">Introduzca código de verificación.</label>
					</div>

					<button class="w-100 mb-2 btn btn-lg rounded-4 btn-primary"
						type="submit">Verificar</button>
					<small class="text-muted">Al hacer clic en Verificar,
						aceptas los términos de uso.</small>
					<hr class="my-4">
				</div>

			</form>
		</div>
	</div>



</body>
</html>