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
</head>
<body>
    <h1>This is list</h1>
    <table>
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
</body>
</html>
