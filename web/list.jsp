<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 33vin
  Date: 09-Jun-20
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<div id="--header">
    <nav id="--navbar" class="navbar navbar-expand-lg navbar-light bg-transparent">
        <%--        <a class="navbar-brand" href="#">Vinh Trung Ngục</a>--%>
        <img src="img/Reapers.png" width="50" height="50">
        <h4 style="color: #002752; margin-left: 10px">Vinh trung ngục</h4>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/index.jsp">Trang chủ</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/hoat_dong.jsp">Hoạt động</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/tin_tuc.jsp">Tin tức</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/nhat_ky.jsp">Nhật ký trong tù</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Danh sách</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Tìm kiếm ..." aria-label="Search">
                <button id="--search" class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Tìm kiếm</button>
            </form>
        </div>
    </nav>
</div>
<div>
    <h1>This is list</h1>
    <table border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>CellRoom</th>
            <%--            <th>Name</th>--%>
            <%--            <th>Age</th>--%>
            <%--            <th>Height</th>--%>
            <%--            <th>Weight</th>--%>
            <%--            <th>Address</th>--%>
            <%--            <th>Identification</th>--%>
            <%--            <th>Crime</th>--%>
            <%--            <th>Date Arrived</th>--%>
            <%--            <th>Date Departed</th>--%>
            <%--            <th>Judgment</th>--%>
            <%--            <th>Other</th>--%>
        </tr>
        <%--        <jsp:useBean id="list" scope="request" type="java.util.List"/>--%>
        <c:forEach var="prisoner" items="${list}">
            <tr>
                <td><c:out value="${prisoner.getId()}"/></td>
                <td><c:out value="${prisoner.getCellRoom()}"/></td>
                    <%--                <td><c:out value="${prisoner.name}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.age}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.height}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.weight}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.address}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.identification}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.crime}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.date_arrived}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.date_departure}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.judgment}"/></td>--%>
                    <%--                <td><c:out value="${prisoner.other}"/></td>--%>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
