<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Reportes</title>
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
				<a href="#" class="navbar-brand"> Gestión de Reportes</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Reportes</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:if test="${reporte != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${reporte == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${reporte != null}">
                                    Editar Reporte
                                </c:if>
						<c:if test="${reporte == null}">
                                    Agregar Nuevo Reporte
                                </c:if>
					</h2>
				</caption>

				<c:if test="${reporte != null}">
					<input type="hidden" name="id"
						value="<c:out value='${reporte.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Nombre</label> <input type="text"
						value="<c:out value='${reporte.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Descripción</label> <input type="text"
						value="<c:out value='${reporte.descripcion}' />"
						class="form-control" name="descripcion">
				</fieldset>

				<fieldset class="form-group">
					<label>Estado</label> <input type="text"
						value="<c:out value='${reporte.state}' />" class="form-control"
						name="state">
				</fieldset>

				<fieldset class="form-group">
					<label>Archivo</label> <input type="text"
						value="<c:out value='${reporte.file}' />" class="form-control"
						name="file">
				</fieldset>

				<fieldset class="form-group">
					<label>Fecha</label> <input type="date"
						value="<c:out value='${reporte.datecreate}' />" class="form-control"
						name="datecreate">
				</fieldset>
				
				 <select class="form-select" name="conexion" aria-label="Default select example">
					<c:forEach var="conexion" items="${conexiones}">
						<option value="<c:out value='${conexion.id}' />"><c:out value='${conexion.id}' /></option>
					</c:forEach>
				</select>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>