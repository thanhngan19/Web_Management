<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/11/2023
  Time: 9:03 PM
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
<form action="/furama?action=createContract" method="post">
    <div class="parent">
        <div class="child">
            <h1>Add Contract</h1>
            <div class="form-group">
                <label for="validationServer04">Ngày làm họp đồng</label>
                <input type="date" class="form-control is-invalid" id="validationServer04" placeholder="State"
                       required  name="startdate">
            </div>
                <div class="form-group">
                    <label for="validationServer04">Ngày Kết Thúc</label>
                    <input type="date" class="form-control is-valid"id="validationServer012" placeholder="State"
                           placeholder="Last name"   name="enddate">
                </div>
                <div class="form-group">
                    <label for="validationServer02">Tiền đặt cọc</label>
                    <input type="text" class="form-control is-valid" id="validationServer02"
                           placeholder="Last name"  name="tdc" required>
                </div>
                <div class="form-group">
                    <label for="validationServer04">Nhân viên</label>
                    <select class="form-control" id="exampleFormControlSelect122" name="nv">
                        <c:forEach items="${nv}" varStatus="loop" var="nhanvien">
                            <option value="${nhanvien}"><c:out value="${nhanvien}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Khách Hàng</label>
                    <select class="form-control" id="exampleFormControlSelect1" name="kh">
                        <c:forEach items="${kh}" varStatus="loop" var="kh">
                            <option value="${kh}"><c:out value="${kh}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Dịch vụ</label>
                    <select class="form-control" id="exampleFormControlSelect" name="dv">
                        <c:forEach items="${dv}" varStatus="loop" var="dv">
                            <option value="${dv}"><c:out value="${dv}"/></option>
                        </c:forEach>
                    </select>
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

