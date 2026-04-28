<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Страница пользователя | InFocus</title>
    <!-- Подключаем Montserrat для стиля ExtraBold -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800;900&display=swap" rel="stylesheet">
    <style>
        :root {
            --burgundy: #943939;
            --beige: #EBE7E3;
            --font-main: 'Montserrat', sans-serif;
        }

        body {
            font-family: var(--font-main);
            background-color: var(--beige);
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
        }
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



        /* Шапка из стиля пользователя */
        .header {
            background-color: var(--burgundy);
            color: white;
            padding: 15px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        .header h1 {
            margin: 0;
            font-weight: 900;
            letter-spacing: -1px;
            font-size: 32px;
        }

        .header .logout-link {
            color: white;
            font-weight: 700;
            text-decoration: none;
            font-size: 18px;
            text-transform: uppercase;
            transition: opacity 0.3s;
        }

        .header .logout-link:hover {
            opacity: 0.8;
        }

        /* Контейнер */
        .container {
            padding: 40px;
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: flex-start;
        }

        /* Та самая бордовая рамка */
        .bordo_frame_in_container {
            border: 7px solid var(--burgundy);
            background-color: var(--beige);
            padding: 60px 40px;
            width: 100%;
            max-width: 1400px;
            min-height: 500px;
            display: flex;
            position: relative;
        }

        .left_content {
            width: 100%;
            display: flex;
            flex-direction: column;
        }

        /* Контейнер кнопок - теперь вертикально слева */
        .button-container {
            display: flex;
            flex-direction: column;
            gap: 20px;
            align-items: flex-start; /* Прижимаем влево */
        }

        .button-container button {
            background-color: var(--beige);
            border: 2px solid var(--burgundy);
            padding: 0; /* Убираем падинг у кнопки, переносим на ссылку */
            cursor: pointer;
            border-radius: 5px;
            transition: all 0.3s ease;
            min-width: 300px; /* Одинаковая ширина для красоты */
        }

        .button-container button:hover {
            background-color: var(--burgundy);
        }

        .button-container button a {
            color: var(--burgundy);
            font-family: 'Montserrat', sans-serif;
            font-weight: 800; /* ExtraBold */
            text-decoration: none;
            font-size: 20px;
            display: block;
            padding: 15px 30px;
            text-align: center;
            transition: color 0.3s ease;
        }

        .button-container button:hover a {
            color: white;
        }

        /* Текстовые заголовки внутри контента */
        .welcome-text {
            margin-bottom: 40px;
        }

        .welcome-text h4 {
            color: var(--burgundy);
            margin: 0;
            font-weight: 900;
            font-size: 42px;
            text-transform: uppercase;
        }

        /* Декоративный элемент сбоку (опционально для красоты) */
        .decorative-text {
            position: absolute;
            bottom: 40px;
            right: 40px;
            color: var(--burgundy);
            opacity: 0.1;
            font-size: 100px;
            font-weight: 900;
            pointer-events: none;
            line-height: 1;
        }

        @media (max-width: 768px) {
            .bordo_frame_in_container {
                padding: 30px 20px;
            }
            .button-container button {
                min-width: 100%;
            }
            .welcome-text h4 {
                font-size: 30px;
            }
        }
    </style>
</head>
<body>
<#include "headerForAuthorized.ftlh">
<div class="container">
    <div class="bordo_frame_in_container">
        <div class="left_content">

            <div class="welcome-text">
                <h4>Личный кабинет</h4>
            </div>

            <div class="button-container">
                <button type="button">
                    <a href="/user/photoSessions">Мои фотосессии</a>
                </button>
                <button type="button">
                    <a href="/user/photoStudios">Фотостудии</a>
                </button>
                <button type="button">
                    <a href="/user/portfolios">Фотографы</a>
                </button>
                <button type="button">
                    <a href="/references">Вдохновение</a>
                </button>

            </div>

        </div>

    </div>
</div>

</body>
</html>

