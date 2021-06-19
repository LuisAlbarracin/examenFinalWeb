<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Token de Conexión</title>
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
				<a href="#" class="navbar-brand">Gestión de Tokens de Conexión </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Token de Conexion</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:if test="${connectiontoken != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${connectiontoken == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${connectiontoken != null}">
                                    Editar Token de Conexión
                                </c:if>
						<c:if test="${connectiontoken == null}">
                                    Agregar Nuevo Token de Conexión
                                </c:if>
					</h2>
				</caption>

				<c:if test="${connectiontoken != null}">
					<input type="hidden" name="id"
						value="<c:out value='${connectiontoken.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Base de Datos</label> <input type="text"
						value="<c:out value='${connectiontoken.db}' />"
						class="form-control" name="db" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Host</label> <input type="text"
						value="<c:out value='${connectiontoken.host}' />"
						class="form-control" name="host">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${connectiontoken.pass}' />"
						class="form-control" name="pass">
				</fieldset>

				<fieldset class="form-group">
					<label>Port</label> <input type="number"
						value="<c:out value='${connectiontoken.port}' />"
						class="form-control" name="port">
				</fieldset>

				<fieldset class="form-group">
					<label>Estado</label> <input type="number"
						value="<c:out value='${connectiontoken.state}' />"
						class="form-control" name="state">
				</fieldset>

				<fieldset class="form-group">
					<label>Token</label> <input type="text"
						value="<c:out value='${connectiontoken.token}' />"
						class="form-control" name="token">
				</fieldset>

				<fieldset class="form-group">
					<label>Usuario DB</label> <input type="text"
						value="<c:out value='${connectiontoken.userdb}' />"
						class="form-control" name="userdb">
				</fieldset>

				<select class="form-select" aria-label="Default select example">
					<c:forEach var="typedb" items="${typesdb}">
						<option value="<c:out value='${typedb.id}' />"><c:out value='${typedb.id}' /></option>
					</c:forEach>


				</select> <select class="form-select" aria-label="Default select example">
					<c:forEach var="usuario" items="${usuarios}">
						<option value="<c:out value='${usuario.id}' />"><c:out value='${usuario.nombre}' /></option>
					</c:forEach>
				</select>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>