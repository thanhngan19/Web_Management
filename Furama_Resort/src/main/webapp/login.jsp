<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/css_login.css">
<%--    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"--%>
<%--          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"--%>
<%--          crossorigin="anonymous">--%>
<%--    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />--%>
<%--    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.27/dist/sweetalert2.min.css" rel="stylesheet">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>--%>
    <title>Ludiflex | Login</title>
</head>
<body>
<div class="box">
    <div class="container">
        <div class="top-header">
            <span>Have an account?</span>
            <header>Login</header>
        </div>

        <form action="/furama?action=checkLogin" method="post">
            <div class="input-field">
                <input type="text" class="input" placeholder="Username" name="username" required>
                <i class="bx bx-user"></i>
            </div>
            <div class="input-field">
                <input type="password" class="input" placeholder="Password" name="password" required>
                <i class="bx bx-lock-alt"></i>
            </div>
            <div class="input-field">
                <input type="submit" class="submit" value="Login">
            </div>
        </form>

        <div class="bottom">
            <div class="left">
                <input type="checkbox"  id="check">
                <label for="check"> Remember Me</label>
            </div>
            <div class="right">
                <label><a href="#">Forgot password?</a></label>
            </div>
        </div>
    </div>
</div>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
    const params = new URLSearchParams(window.location.search);
    let number=params.get('number');
    if(number==1){
        Swal.fire(
            'Login fail!',
            'Try again'
        )}

</script>
</body>
</html>
