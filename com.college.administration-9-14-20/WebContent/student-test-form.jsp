<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
            <title>Student Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
        <body>
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Student Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${student != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${student == null}">
                            <form action="insert" method="post">
                        </c:if>
						<caption>
                            <h2>
                                <c:if test="${student != null}">
                                    Edit Student
                                </c:if>
                                <c:if test="${student == null}">
                                    Add New Student
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${student != null}">
                            <input type="hidden" name="id" value="<c:out value='${student.student_id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Student First Name</label> <input type="text" value="<c:out value='${student.firstName}' />" class="form-control" name="firstName" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Student Last Name</label> <input type="text" value="<c:out value='${student.lastName}' />" class="form-control" name="lastName">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email Address</label> <input type="text" value="<c:out value='${student.email}' />" class="form-control" name="email">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button><a href="<%=request.getContextPath()%>/update" class="nav-link">
                        </form>
                    </div>
                </div>
            </div>
                </div>
            </div>
        </body>