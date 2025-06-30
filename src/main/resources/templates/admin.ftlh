<#import "/spring.ftl" as spring />
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Страница админа</title>
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

        .left_content {
            background: #EBE7E3;
            float: left;
            width: 50%;
            text-align: left;

        }

    </style>
</head>
<body>
<#include "headerForAuthorized.ftlh">

<div class="container">
    <div class="bordo_frame_in_container">
        <div class="left_content">
            <div class="button-container">
                <button type="button">  <a href="/admin/photoStudios">Фотостудии</a></button>
                <button type="button">  <a href="/admin/users">Пользователи</a></button>

            </div>
        </div>

    </div>
</div>
</body>
</html>