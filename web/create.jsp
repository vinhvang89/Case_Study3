<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2020
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>V.T.Jail - Thêm tù nhân mới</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css2/style.css">
<%--    <link rel="stylesheet" href="css/style.css">--%>
</head>
<body>

<div id="--header">
    <nav id="--navbar" class="navbar navbar-expand-lg navbar-light bg-transparent">
        <%--        <a class="navbar-brand" href="#">Vinh Trung Ngục</a>--%>
        <img src="imgs/Reapers.png" width="50" height="50">
        <h4 style="color: #002752; margin-left: 10px">V . T . Jail</h4>
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
                    <a class="nav-link" href="http://localhost:8080/abc?action=showAll">Danh sách</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Tìm kiếm ..." aria-label="Search">
                <button id="--search" class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Tìm kiếm</button>
            </form>
        </div>
    </nav>
</div>


<div id="--body">
    <div class="sidenav">
        <a href="http://localhost:8080/abc?action=showAll">Danh sách tù nhân</a>
        <a href="#services">Thêm tù nhân</a>
        <a href="#contact">Phiếu đánh giá</a>
    </div>

    <div id="--body-create-form">
        <form id="--create">


            <div class="form-row">
                <div class="form-group col-lg-6">
                    <label for="id">ID</label>
                    <input type="text" class="form-control" id="id" name="id" placeholder="ID">
                </div>
                <div class="form-group col-lg-6">
                    <label for="cellRoom">Room</label>
                    <input type="text" class="form-control" id="cellRoom" name="cellRoom" placeholder="Room">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-lg-8">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
                </div>
                <div class="form-group col-lg-4">
                    <label for="age">Age</label>
                    <input type="text" class="form-control" id="age" name="age" placeholder="Age">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-lg-8">
                    <label for="height">Height</label>
                    <input type="text" class="form-control" id="height" name="height">
                </div>
                <div class="form-group col-lg-4">
                    <label for="weight">Height</label>
                    <input type="text" class="form-control" id="weight" name="weight">
                </div>
            </div>

            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address">
            </div>

            <div class="form-row">
                <div class="form-group col-lg-6">
                    <label for="identification">Identification</label>
                    <input type="text" class="form-control" id="identification" name="identification" placeholder="Identification">
                </div>
                <div class="form-group col-lg-6">
                    <label for="crime">Crime</label>
                    <input type="text" class="form-control" id="crime" name="crime" placeholder="Crime">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-lg-6">
                    <label for="date_arrived">Date arrived</label>
                    <input type="text" class="form-control" id="date_arrived" name="date_arrived" placeholder="Date arrived">
                </div>
                <div class="form-group col-lg-6">
                    <label for="date_departure">Date departure</label>
                    <input type="text" class="form-control" id="date_departure" name="date_departure" placeholder="Date departure">
                </div>
            </div>
            <div class="form-group">
                <label for="judgment">Judgment</label>
                <input type="text" class="form-control" id="judgment" name="judgment" placeholder="Judgment">
            </div>
            <div class="form-group">
                <label for="other">Other</label>
                <input type="text" class="form-control" id="other" name="other" placeholder="Other">
            </div>
            <div class="form-group">
            <button type="submit" class="btn btn-primary">Create</button>
            </div>
        </form>
    </div>
</div>

<div id="--footer">
    <h6>Copyright Vinh & Trung, 6/2020</h6>
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
