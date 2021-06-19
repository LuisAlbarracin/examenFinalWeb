<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Seguimientos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
                <a href="#" class="navbar-brand"> Gestión de Seguimiento </a>
            </div>
            
            <ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Seguimiento</a></li>
            </ul>
		
		</nav>
	</header>
	<br/>
	
	<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Listado de Seguimiento</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Seguimiento</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>DATEGENERATE</th>
                                <th>DETAILREQUEST</th>
                                <th>RESULT</th>
                                <th>STATE</th>
                                <th>STATE</th>
                                <th>TYPE</th>
                                <th>REPORTE</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="seguimiento" items="${seguimientos}">

                                <tr>
                                    <td>
                                        <c:out value="${seguimiento.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${seguimiento.dategenerate}" />
                                    </td>
                                    <td>
                                        <c:out value="${seguimiento.detailrequest}" />
                                    </td>
                                    <td>
                                        <c:out value="${seguimiento.filegenerate}" />
                                    </td>
                                      <td>
                                        <c:out value="${seguimiento.result}" />
                                    </td>
                                    <td>
                                        <c:out value="${seguimiento.state}" />
                                    </td>
                                    <td>
                                        <c:out value="${seguimiento.type}" />
                                    </td>
                                    <td>
                                        <c:out value="${seguimiento.reporte.name}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${seguimiento.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${seguimiento.id}' />">Elimnar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
	
	
	
	
</body>
</html>