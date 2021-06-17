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
<title>Registrar Tipo Base Datos</title>
</head>
<body>


	<section>
		<form>
			<div class="mb-3">
				<label for="id" class="form-label">Id</label> <input type="text"
					class="form-control" id="id" name="id"
					placeholder="Id del tipo de base de datos" required>
			</div>
			<div class="mb-3">
				<label for="descripcion" class="form-label">Descripcion</label> <input
					type="text" class="form-control" id="descripcion"
					name="descripcion" placeholder="Descripcion de la base de datos"
					required>
			</div>
			<div class="mb-3">
				<label for="driver" class="form-label">Driver</label> <input
					type="text" class="form-control" id="driver" name="driver" required>
			</div>
			<div class="mb-3">
				<label for="adicional" class="form-label">Adicional</label> <input
					type="text" class="form-control" id="adicional" name="adicional"
					placeholder="Informacion adicional del tipo de base de datos" required>
			</div>
		</form>
	</section>
</body>
</html>