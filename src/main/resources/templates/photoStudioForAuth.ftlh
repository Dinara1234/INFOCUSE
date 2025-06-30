<#import "/spring.ftl" as spring />
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Фотостудия на ${photoStudio.address}</title>
    <style>
        a {
            color: white;
            font-family: "Montserrat ExtraBold";
            text-decoration: none;
        }
        .button-container button a{
            color: #943939;
            text-align: center;
            text-decoration: none;
            font-size: 22px;


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

        .header button {
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

        .container {
            padding: 40px;
            max-width: inherit;

        }
        .bordo_frame_in_container{

            background-color: #EBE7E3;
            padding: 20px;
            height: 72%;
            width: 95%;

        }

        .container h1 {
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

        .slideshow-container {
            max-width: 1000px;
            max-height: 450px;
            position: relative;
            margin: auto;
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

        .prev:hover, .next:hover {
            background-color: rgba(0,0,0,0.8);
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
        .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }

        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
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

        .left_content {
            background: #EBE7E3;
            float: left;
            width: 50%;
            text-align: left;

        }
        .right_container{
            background: #EBE7E3;
            float: right;
            width: 50%;
            text-align: left;
        }
        .date-nav { margin-bottom: 20px; }
        .date-link {
            margin-right: 15px;
            padding: 5px 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            text-decoration: none;
        }
        .date-link.active {
            background-color: #007bff;
            color: white;
            border-color: #007bff;
        }
        .slot-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));
            gap: 10px;
        }
        .slot-btn {
            padding: 10px;
            background-color: #943939;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }
        .slot-btn:hover {
            background-color: #c82333;
        }
        .no-slots {
            padding: 20px;
            text-align: center;
            color: #6c757d;
        }

    </style>
</head>
<body>
<#include "headerForAuthorized.ftlh">

<div class="container">
    <div class="bordo_frame_in_container">
        <div class="left_content">
            <h1>Фотостудия на ${photoStudio.address}:</h1>
            <h3>${photoStudio.title}</h3>
        </div>

        <div class="right_container">
            <div class="slideshow-container">
                <#if photos?has_content>
                    <#list photos as photo>
                        <div class="mySlides fade">
                            <div class="numbertext">${photo_index + 1} / ${photos?size}</div>
                            <img src="${photo.getImageUrl()}" style="width:100%">
                        </div>
                    </#list>
                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
                <#else>
                    <p>Картинок пока нет, загрузите фотографии</p>
                </#if>
            </div>
            <br>
            <div style="text-align:center">
                <#if photos?has_content>
                    <#list photos as photo>
                        <span class="dot" onclick="currentSlide(${photo_index + 1})"></span>
                    </#list>
                </#if>
            </div>
        </div>
    </div>
    <h1>Свободные слоты на ${currentSelectedDate.dayOfMonth?string("00")}.${currentSelectedDate.monthValue?string("00")}.${currentSelectedDate.year}</h1>

    <div class="date-nav">
        <a class="date-link ${(currentSelectedDate == today)?then('active', '')}"
           href="?displayDate=${today}T00:00:00">
            Сегодня
        </a>
        <a class="date-link ${(currentSelectedDate == tomorrow)?then('active', '')}"
           href="?displayDate=${tomorrow}T00:00:00">
            Завтра
        </a>
        <a class="date-link ${(currentSelectedDate == dayAfterTomorrow)?then('active', '')}"
           href="?displayDate=${dayAfterTomorrow}T00:00:00">
            Послезавтра
        </a>
    </div>

    <#if freeSlots?has_content>
        <div class="slot-grid">
            <#list freeSlots as slot>
                <#assign startHour = slot.startTime.hour?string("00")>
                <#assign startMinute = slot.startTime.minute?string("00")>
                <#assign endHour = slot.endTime.hour?string("00")>
                <#assign endMinute = slot.endTime.minute?string("00")>

                <button class="slot-btn"
                        onclick="selectSlot('${slot.startTime}', '${slot.endTime}')">
                    ${startHour}:${startMinute} - ${endHour}:${endMinute}
                </button>
            </#list>
        </div>
    <#else>
        <div class="no-slots">
            Нет доступных слотов на эту дату
        </div>
    </#if>
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
    function selectSlot(startTime, endTime) {
        const baseUrl = `/user/photoStudios/${studioId}/free-photographers`;

        const params = new URLSearchParams();
        params.append('startTime', startTime);
        params.append('endTime', endTime);

        const fullUrl = baseUrl+'?'+params.toString();

        window.location.href = fullUrl;
    }
</script>
</body>
</html>



