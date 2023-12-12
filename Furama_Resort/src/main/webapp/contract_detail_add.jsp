<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/12/2023
  Time: 10:50 PM
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
<form action="/furama?action=createContractDetail&number=3" method="post">
    <div class="parent">
        <div class="child">
            <h1>Thêm Contract Detail</h1>
            <div class="form-group">
                <label for="validationServer04">Số Lượng</label>
                <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="State"
                       required  name="sl" value="${sl}">
            </div>
            <div class="form-group">
                <label for="validationServer04">Mã hợp đồng</label>
                <select class="form-control" id="exampleFormControlSelec" name="mhd">
                    <c:forEach items="${mhd}" varStatus="loop" var="mhd">
                        <option value="${mhd}"><c:out value="${mhd}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="validationServer04">Tên dịch vụ đi kèm</label>
                <select class="form-control" id="exampleFormControlSel" name="dvdk">
                    <c:forEach items="${dvdk}" varStatus="loop" var="dvdk">
                        <option value="${dvdk}"><c:out value="${dvdk}"/></option>
                    </c:forEach>
                </select>
            </div>
            <div class="center">
<%--                <a href="action=number=3" role="button"--%>
<%--                   class="btn btn-primary" type="submit">ADD</a></td>--%>
    <button type="submit" class="btn btn-primary" >ADD</button>
            </div>
        </div>
    </div>
    </div>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous">
</script>
    <script>
        const params = new URLSearchParams(window.location.search);
        let number=params.get('number');
        var mes='<p><c:out value="${message}"/></p>'
         if(number==3){
        swal(mes);
    }
</script>

</body>
</html>
</html>

