<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Student Management Application</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	  </tbody>
 		<header>
           <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Student Management App </a>
  
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
                    </ul>
                </nav>
				  
            <br>
            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Students</h3>
                    <hr>
                    <div class="container text-left">                                    
					<ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/update" class="btn btn-success">Add
     New Student</a></li>
     
     				</ul>
                    </div>
					<br>
					<!--   for (Todo todo: todos) {  -->
					<!--   adding fields to add new student??  -->
					<c:if test="${user != null}">
   <form action="update" method="post"> </form>
        </c:if>       
                    <table class="table table-bordered">
                        <thead>                     				
   							<tr>
 				 		<th>ID</th> 
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                       
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="student" items="${listStudent}">

                                <tr>
                                    <td>
                                        <c:out value="${student.student_id}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.firstName}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.lastName}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.email}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${student.student_id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${student.student_id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
</body>
</html>