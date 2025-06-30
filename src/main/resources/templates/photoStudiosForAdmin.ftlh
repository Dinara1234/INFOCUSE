<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль</title>
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
            font-family: "Montserrat ExtraBold", "Calibri";
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



        .photostudio-row {
            display: flex;
            align-items: center;
            gap: 10px;
            margin-bottom: 10px;
            width: 100%;
        }


        .photostudio-card {
            flex-grow: 1;
            background-color: #EBE7E3;
            border: 2px solid #943939;
            color: #943939;
            padding: 10px 20px;
            text-align: left;
            text-decoration: none;
            display: flex;
            align-items: center;
            font-size: 22px;
            cursor: pointer;
            border-radius: 5px;
            height: 100px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }


        .delete-button {
            background-color: #943939;
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

        .delete-form {
            height: 100%;
            display: flex;
            align-items: center;
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
<#import "/spring.ftl" as spring />
<#include "headerForAuthorized.ftlh" />

<div class="container">

    <div class="left_content">
        <div class="button-container">
            <button type="button"><a href="/admin/photoStudios/create">Добавить фотостудию</a></button>
        </div>
        <h1>Наши локации для фотосессий</h1>
        <#if photoStudios?has_content>
            <#list photoStudios as photoStudio>
                <div class="photostudio-row">
                    <a class="photostudio-card" href="/admin/photoStudios/${photoStudio.id}">
                        ${photoStudio.address}: ${photoStudio.title}
                    </a>

                    <form action="<@spring.url '/admin/photoStudios/${photoStudio.id}'/>" method="post" class="delete-form">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button type="submit" class="delete-button"
                                onclick="return confirm('Вы уверены, что хотите удалить ${photoStudio.title} (${photoStudio.address})?');">
                            Удалить
                        </button>
                    </form>
                    <a class="delete-button" href="/admin/photoStudios/update/${photoStudio.id}">
                        Изменить
                    </a>
                </div>
            </#list>
        <#else>
            <p>Пока нет доступных фотостудий.</p>
        </#if>
    </div>

</div>

</body>
</html>