<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мои фотосессии</title>
    <style>
        a {
            color: white;
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
        .container {
            padding: 40px;
            max-width: inherit;

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


        .photostudio-card {
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
            height: 100px;
            width: 900px;
        }

        .left_content {
            background: #EBE7E3;
            float: left;
            width: 70%;
            display: flex;
            gap: 5px;
            flex-direction: column;
            text-align: left;


        }

    </style>
</head>
<body>
<#include "headerForAuthorized.ftlh">

<div class="container">

    <div class="left_content">
        <h1>Мои фотосессии</h1>
        <#if photoSessions?has_content>
            <#list photoSessions as photoSession>
                <a class="photostudio-card" >
                    ${photoSession.timeStart.dayOfMonth}.${photoSession.timeStart.monthValue}.${photoSession.timeStart.year} ${photoSession.timeStart.hour}:${photoSession.timeStart.minute?string("00")} - ${photoSession.timeEnd.hour}:${photoSession.timeEnd.minute?string("00")}
                    ${photoSession.address}: ${photoSession.title}
                </a>
                <br/>
            </#list>
        <#else>
            <p>Пока нет доступных фотоcессий.</p>
        </#if>

    </div>
</div>
</body>
</html>