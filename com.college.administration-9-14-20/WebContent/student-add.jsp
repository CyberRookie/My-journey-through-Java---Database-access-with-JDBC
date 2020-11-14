<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Form</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<body>
<header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Student Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        
                    </ul>
                </nav>
            </header>
            <br>
             <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Students</h3>
                    
                    <li><a href="<%=request.getContextPath()%>/student-list" class="nav-link">Students</a></li>
                    <div class="container text-left">

                    <a href="<%=request.getContextPath()%>/student-edit-form.jsp" class="btn btn-success">Add New Student</a>
     				
                    </div>
                    <br>
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
                                    <td><a href="edit?student_id=<c:out value='${student.student_id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?student_id=<c:out value='${student.student_id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
</body>
</html>