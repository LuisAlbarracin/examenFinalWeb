<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Iniciar Session</title>
</head>
<body>
<section>
		<form action="login" method="post">
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="name@example.com">
			</div>
			<div class="mb-3">
				<label for="contrasenia" class="form-label">Contraseña</label> <input
					type="password" class="form-control" id="contrasenia" required>
			</div>
			 <select class="form-select" name="rol" aria-label="Default select example">
					<c:forEach var="rol" items="${roles}">
						<option value="<c:out value='${rol.id}' />"><c:out value='${rol.description}' /></option>
					</c:forEach>
				</select>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			
		</form>
	</section>
</body>
</html>