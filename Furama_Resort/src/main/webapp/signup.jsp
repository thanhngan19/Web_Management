<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>W3.CSS Template</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="w3-content" style="max-width:1200px">

<div class="w3-panel">
    <i class="w3-xlarge fa fa-bars"></i>
</div>
<!-- First Grid: Logo & About -->
<div class="w3-row">
    <div class="w3-half w3-container">
        <h1 class="w3-xxlarge w3-text-light-grey">Hello</h1>
        <h1 class="w3-xxlarge w3-text-grey">We are</h1>
        <h1 class="w3-jumbo">Furama</h1>
    </div>
    <div class="w3-half w3-container w3-xlarge w3-text-grey">
        <p class="">Thank you for using our resort , Furama Resort.

            We have pleasure in confirming that we have booked a <span><c:out value="${category}"/></span> for you at <span><c:out value="${startdate}"/></span> for three nights. The room has a view over the park. A deposit is not required.
            We look forward to your visit.

        </p>
        <p>Yours sincerely</p>
    </div>
</div>

<!-- Second Grid: Resent -->
<div class="w3-panel w3-text-grey">
    <h4>TO CONFIRM:</h4>
</div>
<div class="w3-row">
    <div class="w3-half w3-container">
        <img  src="khu-bao-ton-thien-nhien-son-tra-3.jpg" style="width:100%">
    </div>
    <div class="w3-half w3-container">
        <img src="resort.webp" style="width:100%">
        <p class="w3-xlarge w3-text-grey">
            Demos, Logos, Reports, Names, Events, Media, Wordpress, Google, Books, Optimisations</p>
    </div>
</div>

<!-- Footer -->
<div class="w3-row w3-section">
    <div class="w3-third w3-container w3-black w3-large" style="height:250px">
        <h2>Contact Info</h2>
        <p><i class="fa fa-map-marker" style="width:30px"></i> Da Nang,Viet Name</p>
        <p><i class="fa fa-phone" style="width:30px"></i> Phone: +00 151515</p>
        <p><i class="fa fa-envelope" style="width:30px"> </i> Email: reservation@mail.com</p>
    </div>
    <div class="w3-third w3-center w3-large w3-dark-grey w3-text-white" style="height:250px">
        <h2>Contact Us</h2>
        <p>If you have an idea.</p>
        <p>What are you waiting for?</p>
    </div>
    <div class="w3-third w3-center w3-large w3-grey w3-text-white" style="height:250px">
        <h2>Like Us</h2>
        <i class="w3-xlarge fa fa-facebook-official"></i><br>
        <i class="w3-xlarge fa fa-pinterest-p"></i><br>
        <i class="w3-xlarge fa fa-twitter"></i><br>
        <i class="w3-xlarge fa fa-flickr"></i><br>
        <i class="w3-xlarge fa fa-linkedin"></i>
    </div>
</div>
<div class="w3-container w3-text-grey">
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</div>

</body>
</html>
