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
<title>Insertar articulo</title>
</head>
<body>
	<div style="text-align: center; margin-top: 5em;">
		<h3>
			<b>INSERTAR ARTÍCULO</b>
		</h3>
	</div>
	<form action="ServletInsertarArticulo" method="post">
		<div>
			<div class="form-group row">
				<label for="codigo" class="col-4 col-form-label"></label>
				<div class="col-4">
					<div class="input-group">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-code-fork"></i>
							</div>
						</div>
						<input id="codigo" name="codigo"
							placeholder="Introducir matrícula..." type="text"
							class="form-control">
					</div>
				</div>
			</div>


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
							class="form-control">
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
							class="form-control">
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
							placeholder="Introducir precio..." type="number"
							class="form-control">
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
							<option value="1">Carretera</option>
							<option value="2">Naked</option>
							<option value="3">Deportiva</option>
							<option value="4">Cross</option>
							<option value="5">Trail</option>
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
							<option value="1">49cc</option>
							<option value="2">125cc</option>
							<option value="3">250cc</option>
							<option value="4">600cc</option>
							<option value="5">900cc</option>
							<option value="6">1200cc</option>
						</select>
					</div>
				</div>
			</div>

		</div>

		<div class="form-group row">
			<div class="offset-4 col-4">
				<button name="submit" type="submit" class="btn btn-primary">
					<b>AÑADIR ARTÍCULOS</b>
				</button>
			</div>
		</div>
	</form>

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