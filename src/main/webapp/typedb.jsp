<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Tipo de DB</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestión de Tipos DB </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Tipos DB</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:if test="${typedb != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${typedb == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${typedb != null}">
                                    Editar Tipo de DB
                                </c:if>
						<c:if test="${typedb == null}">
                                    Agregar Nuevo Tipo de DB
                                </c:if>
					</h2>
				</caption>


				<fieldset class="form-group">
					<label>ID</label> <input type="text"
						value="<c:out value='${typedb.id}' />" class="form-control"
						name="id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Descripcion</label> <input type="text"
						value="<c:out value='${typedb.descripcion}' />"
						class="form-control" name="descripcion">
				</fieldset>

				<fieldset class="form-group">
					<label>Driver</label> <input type="text"
						value="<c:out value='${typedb.driver}' />" class="form-control"
						name="driver">
				</fieldset>

				<fieldset class="form-group">
					<label>Aditional</label> <input type="text"
						value="<c:out value='${typedb.aditional}' />" class="form-control"
						name="aditional">
				</fieldset>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>