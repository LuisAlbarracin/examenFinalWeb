<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tokens de Conexioó</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
                <a href="#" class="navbar-brand"> Gestión de Tokens de Conexión</a>
            </div>
            
            <ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Tokens de Conexión</a></li>
            </ul>
		
		</nav>
	</header>
	<br/>
	
	<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Listado de Tokens de Conexión</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Token de Conexión</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>DB</th>
                                <th>HOST</th>
                                <th>PORT</th>
                                <th>STATE</th>
                                <th>TOKEN</th>
                                <th>USERDB</th>
                                <th>TYPEDB</th>
                                <th>USUARIO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="connectiontoken" items="${connectiontokens}">

                                <tr>
                                    <td>
                                        <c:out value="${connectiontoken.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${connectiontoken.db}" />
                                    </td>
                                    <td>
                                        <c:out value="${connectiontoken.host}" />
                                    </td>
                                    <td>
                                        <c:out value="${connectiontoken.state}" />
                                    </td>
                                    <td>
                                    	<c:out value="${connectiontoken.token}" />
                                    </td>
                                     <td>
                                    	<c:out value="${connectiontoken.userdb}" />
                                    </td>
                                     <td>
                                    	<c:out value="${connectiontoken.token}" />
                                    </td>
                                    <td>
                                    	<c:out value="${connectiontoken.typedb}" />
                                    </td>
                                     <td>
                                    	<c:out value="${connectiontoken.usuario.usuario}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${connectiontoken.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${connectiontoken.id}' />">Elimnar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
	
	
	
	
</body>
</html>