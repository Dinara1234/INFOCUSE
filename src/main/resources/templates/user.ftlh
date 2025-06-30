<#import "/spring.ftl" as spring />

<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Страница пользователя</title>
    <style>
        a {
            color: white;
            font-family: "Montserrat ExtraBold";
            text-decoration: none;
        }
        .button-container button a{
            color: #943939;
            font-family: "Montserrat ExtraBold";
            text-decoration: none;
        }

        body {
            font-family: sans-serif;
            background-color: #EBE7E3;
            margin: 0;
        }

        .header {
            background-color: #943939;
            color: white;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header img {
            height: 70px;
        }

        .header form input  {
            background-color: #943939;
            border: none;
            color: white;
            padding: 20px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            color: white;

            font-size: 22px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
            font-family: "Montserrat ExtraBold",  "Calibri";
        }
        .delete-button {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 15px 25px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            font-family: "Montserrat ExtraBold", "Calibri";
            height: 100px;
            white-space: nowrap;
        }
        .delete-button:hover {
            background-color: #c82333;
        }

        .container {
            padding: 40px;
            max-width: inherit;

        }
        .bordo_frame_in_container{
            border: 7px solid #943939;
            background-color: #EBE7E3;
            padding: 20px;
            height: 72%;
            width: 95%;

        }

        .container h4 {
            color: #943939;
            margin-bottom: 54px;
            font-family: "Montserrat ExtraBold";
            font-size: 46px;
        }
        .container h3{
            color: #943939;
            margin-bottom: 30px;
            font-family: "Montserrat";
            font-size: 28px;

        }

        .container img {
            max-width: 600px;
            max-height: 530px;

            margin: 0 10px;
            display: inline-block;
            vertical-align: middle;
        }

        .button-container {
            margin-top: 20px;
            text-align: center;
            padding: 10px;
        }

        .button-container button {
            background-color: #EBE7E3;
            border: 2px solid #943939;
            color: #943939;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 22px;
            cursor: pointer;
            border-radius: 5px;
        }



        .image-container {
            display: flex;
            justify-content: center;
            margin-bottom: 55px;
            margin-right: 45px;
            float: right;
            width: 35%;

            background: #EBE7E3;
        }
        .left_content {
            background: #EBE7E3;
            float: left;
            width: 50%;
            text-align: left;

        }
        .mySlides {
            display: none;
        }

        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            width: auto;
            margin-top: -22px;
            padding: 16px;
            color: white;
            font-weight: bold;
            font-size: 18px;
            transition: 0.6s ease;
            border-radius: 0 3px 3px 0;
        }

        .next {
            right: 0;
            border-radius: 3px 0 0 3px;
        }
        .dot {
            cursor: pointer;
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }

        .active, .dot:hover {
            background-color: #717171;
        }

        .fade {
            -webkit-animation-name: fade;
            -webkit-animation-duration: 1.5s;
            animation-name: fade;
            animation-duration: 1.5s;
        }

        .prev:hover, .next:hover {
            background-color: rgba(0,0,0,0.8);
        }

        .right_container{
            background: #EBE7E3;
            float: right;
            width: 50%;
            text-align: left;
        }
        .slideshow-container {
            max-width: 1000px;
            max-height: 450px;
            position: relative;
            margin: auto;
        }

    </style>
</head>
<body>
<#include "headerForAuthorized.ftlh">

<div class="container">
    <div class="bordo_frame_in_container">
        <div class="left_content">
            <div class="button-container">
                <button type="button">  <a href="/user/photoStudios">Фотостудии</a></button>
                <button type="button">  <a href="/references">Вдохновение</a></button>
                <button type="button">  <a href="/user/photoSessions">Мои фотосессии</a></button>



            </div>
        </div>

    </div>
</div>
<script>
    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        if (n > slides.length) {slideIndex = 1}
        if (n < 1) {slideIndex = slides.length}
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex-1].style.display = "block";
        dots[slideIndex-1].className += " active";
    }
</script>
</body>
</html>
<h1>User</h1>


<form action="<@spring.url '/logout'/>" method="post">
    <input type="submit" value="Выйти">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>