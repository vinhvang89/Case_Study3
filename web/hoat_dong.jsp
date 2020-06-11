<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/9/2020
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>V.T.Jail - Hoạt động</title>
    <%--    <link rel="stylesheet" type="text/css" href="CSS\bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css2/style.css">
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

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/index.jsp">Trang chủ</a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/hoat_dong.jsp">Hoạt động</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/tin_tuc.jsp">Tin tức</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/nhat_ky.jsp">Nhật ký trong tù</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/prisoners?action=showAll">Danh sách</a>
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
    <div class="d-flex">
        <div class="--content-left"></div>

        <div class="--content-center">

            <table class="--content-center-news">
                <tr>
                    <td class="thumbnail">
                        <img class="--content-center-news-thumbnail" src="imgs/phicong.jpg"/>
                    </td>
                    <td class="--content-center-news-title">
                        <h5>
                            <a href="https://news.chuyentrangoto.com/2020/06/danh-tinh-chi-gai-giang-bay-phi-cong-98.html">
                                Tổng kết công tác phối hợp tổ chức các hoạt động VHVN TDTT trong Trại giam giai đoạn 2014 – 2018
                            </a>
                        </h5>
                        <p>
                            (Congannghean.vn)-Chiều ngày 17/9, tại Trại giam số 3, Sở Văn hóa và Thể thao Nghệ An phối hợp với
                            Trại giam số 3 và Trại giam số 6 tổ chức Hội nghị Tổng kết công tác phối hợp tổ chức các hoạt động
                            văn hóa, văn nghệ TDTT trong Trại giam giai đoạn 2014 – 2018.
                        </p>
                    </td>
                </tr>
                <tr>
                    <td class="thumbnail">
                        <img class="--content-center-news-thumbnail" src="imgs/tuankhi.jpg"/>
                    </td>
                    <td class="--content-center-news-title">
                        <h5>
                            <a href="https://doisongvietnam.vn/chu-con-bo-bi-tuan-khi-ban-chet-doi-boi-thuong-40-trieu-85094-9.html">
                                Sống lành mạnh, hiền lành, ăn chay và hay cười với mọi người, một chú bò bị bắn chết
                            </a>
                        </h5>
                        <p>
                            Chủ nhân của con bò bị Tuấn "khỉ" dùng súng bắn chết vừa gửi đơn yêu cầu đòi bồi thường 40
                            triệu đồng.
                        </p>
                    </td>
                </tr>
                <tr>
                    <td class="thumbnail">
                        <img class="--content-center-news-thumbnail" src="imgs/matuy.png"/>
                    </td>
                    <td class="--content-center-news-title">
                        <h5>
                            <a href="https://vnexpress.net/mo-tiec-ma-tuy-mung-sinh-nhat-vo-4103168.html">
                                Mở tiệc ma túy mừng sinh nhật vợ
                            </a>
                        </h5>
                        <p>
                            THỪA THIÊN - HUẾ Hồ Công Nhật Quang, 33 tuổi, nhờ bạn mua ma túy về sử dụng trong tiệc mừng
                            sinh nhật vợ.
                            Đang phê tự nhiên bị công an ập vào bắt...
                        </p>
                    </td>
                </tr>
            </table>
        </div>

        <div class="--content-right"></div>
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
