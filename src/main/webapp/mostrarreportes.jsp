<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Reportes</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
                <a href="#" class="navbar-brand"> Gestión de Reportes </a>
            </div>
            
            <ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Reportes</a></li>
            </ul>
		
		</nav>
	</header>
	<br/>
	
	<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Listado de Usuarios</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Reporte</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NAME</th>
                                <th>FILE</th>
                                <th>DATECREATE</th>
                                <th>USUARIO</th>
                                <th>STATE</th>
                                <th>DESCRIPCION</th>
                                <th>TIPO DB</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="reporte" items="${resportes}">

                                <tr>
                                    <td>
                                        <c:out value="${reporte.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${reporte.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${reporte.file}" />
                                    </td>
                                    <td>
                                        <c:out value="${reporte.datecreate}" />
                                    </td>
                                     <td>
                                        <c:out value="${reporte.connectiontoken.usuario}" />
                                    </td>
                                    <td>
                                        <c:out value="${reporte.state}" />
                                    </td>
                                    <td>
                                        <c:out value="${reporte.descripcion}" />
                                    </td>
                                    <td>
                                        <c:out value="${reporte.connectiontoken.typedb}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${reporte.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${reporte.id}' />">Elimnar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
	
	
	
	
</body>
</html>