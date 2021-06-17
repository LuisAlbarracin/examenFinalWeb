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
<title>Reporte</title>
</head>
<body>

	<section>
		<form>

			<div class="mb-3">
				<label for="descripcion" class="form-label">Descripción</label> <input
					type="text" class="form-control" id="descripcion"
					name="descripcion" required>
			</div>

			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre</label> <input
					type="text" class="form-control" id="nombre" name="nombre" required>
			</div>

			<div class="mb-3">
				<label for="archivo" class="form-label">Archivo</label> <input
					type="file" class="form-control" id="archivo" name="archivo"
					required>
			</div>

			<div class="mb-3">
				<label for="fecha-creacion" class="form-label">Fecha
					Creación</label> <input type="date" class="form-control"
					id="fecha-creacion" name="fecha-creacion" required>
			</div>

			<select class="form-select" aria-label="Default select example">
				<option selected>Conexion</option>
				<option value="1">Mensajeria</option>
				<option value="2">reportes</option>
			</select>
		
			<button type="submit" class="btn btn-primary">Guardar</button>
		
		</form>

	</section>
</body>
</html>