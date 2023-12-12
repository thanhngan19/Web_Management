<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/11/2023
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <link type="text/css"
          href="cssui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .parent {

            width: 100vw;
            height: 100vh;

            display: flex;
            justify-content: center;
            align-items: center;
        }

        .child {
            width: 750px;
            height: 750px;
        }

    </style>
</head>
<body>
<form action="/furama?action=createService" method="post">
    <div class="parent">
        <div class="child">
            <h1>Thêm Service</h1>
            <div class="form-group">
                <label for="validationServer04">Mã dịch vụ</label>
                <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="State"
                       readonly  name="mdv">
                <div class="form-group">
                    <label for="validationServer04">Tên dịch vụ</label>
                    <input type="text" class="form-control is-valid"id="validationServer012" placeholder="State"
                           placeholder="Last name"   name="tdv" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Diện tích</label>
                    <input type="text" class="form-control is-valid" id="validationServer02"
                           placeholder="Last name"  name="dt" required>
                </div>
                <div class="form-group">
                    <label for="validationServer04">Chi phí thuê</label>
                    <input type="text" class="form-control is-valid" id="validationServer10"
                           placeholder="Last name"name="cpt"  >
                </div>
                <div class="form-group">
                    <label for="validationServer02">Số người tối đa</label>
                    <input type="text" class="form-control is-valid" id="validationServer2"
                           placeholder="Last name"name="sntd" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Tên kiểu thuê</label>
                    <select class="form-control" id="exampleFormControlSelect" name="tkt">
                        <c:forEach items="${tkt}" varStatus="loop" var="tkt">
                            <option value="${tkt}"><c:out value="${tkt}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Tên loại dịch vụ</label>
                    <select class="form-control" id="exampleFormControlSelect111" name="ldv">
                        <c:forEach items="${ldv}" varStatus="loop" var="ldv">
                            <option value="${ldv}"><c:out value="${ldv}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Tiêu chuẩn phòng</label>
                    <input type="text" class="form-control is-valid" id="validationServer21"
                           placeholder="Last name" name="tcp" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Mô tả tiện nghi khác </label>
                    <input type="text" class="form-control is-valid" id="validationServer213"
                           placeholder="Last name"name="mttnk" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Diện tích hồ bơi</label>
                    <input type="text" class="form-control is-valid" id="validationServer23"
                           placeholder="Last name"name="dthb" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Số tầng</label>
                    <input type="text" class="form-control is-valid" id="validationServer244"
                           placeholder="Last name"name="st" required>
                </div>
                <div class="center">
                    <button type="submit" class="btn btn-primary">ADD</button>
                </div>
            </div>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous">
</script>
</body>
</html>
</html>
