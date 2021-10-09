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
    <form method="post">
        <div class="card">
            <div class="card-header">
                <h5>Add new Student</h5>
            </div>

            <%--Content--%>
            <div class="card-body">
                <form method="post">
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" name="name" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">address</label>
                        <input type="text" name="address" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">phoneNumber</label>
                        <input type="text" name="phoneNumber" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">email</label>
                        <input type="text" name="email" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">classroom</label>
                        <select class="form-select" name="classroomId">
                            <c:forEach items="${classrooms}" var="classroom">
                                <option value="${classroom.id}">${classroom.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>

            <div class="card-footer">
                <a href="/student">
                    <button type="button" class="btn btn-secondary" style="float: right; margin: 5px">Back</button>
                </a>
                <button type="submit" class="btn btn-primary" style="float: right; margin: 5px">Add now</button>
            </div>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>
