<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Seguimiento</title>
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
				<a href="#" class="navbar-brand"> Gestión de Seguimiento </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Seguimientos</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:if test="${seguimiento != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${seguimiento == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${seguimiento != null}">
                                    Editar Seguimiento
                                </c:if>
						<c:if test="${seguimiento == null}">
                                    Agregar Nuevo Seguimiento
                                </c:if>
					</h2>
				</caption>

				<c:if test="${seguimiento != null}">
					<input type="hidden" name="id"
						value="<c:out value='${seguimiento.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Fecha</label> <input type="date"
						value="<c:out value='${seguimiento.dategenerate}' />"
						class="form-control" name="dategenerate" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Estado</label> <input type="number"
						value="<c:out value='${seguimiento.state}' />"
						class="form-control" name="state">
				</fieldset>

				<fieldset class="form-group">
					<label>Resultado</label> <input type="text"
						value="<c:out value='${seguimiento.result}' />"
						class="form-control" name="result">
				</fieldset>

				<fieldset class="form-group">
					<label>Detalles</label> <input type="text"
						value="<c:out value='${seguimiento.detailrequest}' />"
						class="form-control" name="detailrequest">
				</fieldset>

				<fieldset class="form-group">
					<label>Resultado</label> <input type="text"
						value="<c:out value='${seguimiento.result}' />"
						class="form-control" name="result">
				</fieldset>

				<fieldset class="form-group">
					<label>Archivo Generado</label> <input type="text"
						value="<c:out value='${seguimiento.filegenerate}' />"
						class="form-control" name="filegenerate">
				</fieldset>

				<fieldset class="form-group">
					<label>Type</label> <input type="text"
						value="<c:out value='${seguimiento.type}' />" class="form-control"
						name="type">
				</fieldset>

				<select class="form-select" name="reporte"
					aria-label="Default select example">
					<c:forEach var="reporte" items="${reportes}">
						<option value="<c:out value='${reporte.id}' />"><c:out
								value='${reporte.name}' /></option>
					</c:forEach>
				</select>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>