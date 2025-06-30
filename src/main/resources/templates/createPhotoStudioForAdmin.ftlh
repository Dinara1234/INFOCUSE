<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Зарегистрировать новую фотостудию</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background-image: url("https://sun9-25.userapi.com/impg/VbcucxtjWP0F_XoWnUc5osdcS--Mus15qBOT4Q/8PXYp_HCpWI.jpg?size=2128x1042&quality=95&sign=12b3606c40d65c10e8202352a1f29ebc&type=album"); /* Замените на путь к вашему изображению */
            background-size: cover;
            background-repeat: no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .registration-form {
            background-color: rgba(148, 57, 57, 0.9);
            border-radius: 10px;
            padding: 10px;
            width: 360px;
            height: 350px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Тень */
            text-align: center;
            color: white;
            font-size: 19px;

        }

        .registration-form label {
            display: block;
            margin-top: 28px;
            color: #cccccc;
        }

        .registration-form input{
            width: 100%;
            padding: 15px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .registration-form button {
            background-color: #f9f9f9;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            color:rgba(148, 57, 57, 1);;
            margin-top: 30px;
            font-size: 18px;
            font-family: sans-serif

        }
    </style>
</head>
<body>

<div class="registration-form">
    <h2>Новая фотостудия</h2>

    <form action="/admin/photoStudios" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="text" name="address" id="address" placeholder="Адрес"/>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "address">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>
        <input type="text" name="title" id="title" placeholder="Описание"/>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "title">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>
        <button type="submit">Сохранить</button>
    </form>
</div>

</body>
</html>
