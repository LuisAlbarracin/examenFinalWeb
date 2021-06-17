<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Registrar Usuario</title>
</head>
<body>


	<section>
		<form>
			<div class="mb-3">
				<label for="usuario" class="form-label">Usuario</label> <input
					type="text" class="form-control" id="usuario" name="usuario"
					placeholder="Nombre usuario">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="name@example.com">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com"
					required>
			</div>
			<div class="mb-3">
				<label for="contrasenia" class="form-label">Contraseña</label> <input
					type="password" class="form-control" id="contrasenia" required>
			</div>
			<select class="form-select" aria-label="Default select example">
				<option selected>Seleciona el tipo de usuario</option>
				<option value="1">Administrador</option>
				<option value="2">Usuario</option>
			</select>
		</form>
	</section>
</body>
</html>