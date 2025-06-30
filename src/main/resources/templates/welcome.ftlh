<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InFocus</title>
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
            border: 7px solid #943939;
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

        .button-container {
            margin-top: 20px;
            text-align: center;
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

    </style>
</head>
<body>
<#include "headerForUnAuth.ftlh">

<div class="container">
    <div class="bordo_frame_in_container">
        <div class="left_content">
            <h1>Сервис для записи на фотосессии</h1>
            <h3>Этот сайт поможет фотографам организовывать фотосессии. Вы сможете легко найти моделей для своих творческих задумок!</h3>
            <div class="button-container">
                <button><a href="/photoStudios">Посмотреть фотостудии</a></button>
            </div>
        </div>
        <div class="image-container">
            <img src="https://sun9-53.userapi.com/impg/xuPd4GO4FAtavgc9R3Hw2rlSdpPR2QU2ILh_3Q/Y221jEJH_6Q.jpg?size=1115x1270&quality=95&sign=82c06e3304fefa93dfb1429cd8a4f389&type=album" alt="Изображение 1"> <!-- Замените image1.jpg на путь к вашему изображению -->

        </div>
    </div>
</div>
</body>
</html>