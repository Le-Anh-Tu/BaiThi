<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
          crossorigin="anonymous">
<body>

<%--Container--%>
<div class="container" style="margin-top: 25px">
    <div class="card">

        <%--Search--%>
        <div class="card-header" style="height: 55px">
            <form action="/student">
                <div class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search by Name" name="name"
                           aria-label="Search">
                    <button class="btn btn-secondary me-2" type="submit">Search</button>
                </div>
            </form>
        </div>

        <%--Content--%>
        <div class="card-body">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">address</th>
                    <th scope="col">phoneNumber</th>
                    <th scope="col">email</th>
                    <th scope="col">classroom</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td style="line-height: 38px">${student.id}</td>
                        <td style="line-height: 38px">${student.name}</td>
                        <td style="line-height: 38px">${student.address}</td>
                        <td style="line-height: 38px">${student.phoneNumber}</td>
                        <td style="line-height: 38px">${student.email}</td>
                        <td style="line-height: 38px">${student.classroom.name}</td>
                        <td>
                            <a href="/student?action=update&id=${student.id}">
                                <button type="button" class="btn btn-success">Edit</button>
                            </a>
                        </td>
                        <td>
                            <a href="/student?action=delete&id=${student.id}">
                                <button type="button" class="btn btn-danger">Delete</button>
                            </a>
<%--                        </td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <%--Create--%>
        <div class="card-footer">
            <a href="/student?action=create">
                <button class="btn btn-primary" style="float: right; margin: 5px">Add New Student</button>
            </a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>