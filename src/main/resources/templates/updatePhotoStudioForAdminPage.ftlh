<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Изменить информацию о фотосдудии</title>
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
            height: 550px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            color: white;
            font-size: 19px;

        }

        .registration-form label {
            display: block;
            margin-top: 6px;
            color: #cccccc;
        }

        .registration-form input {
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
    <h2>Инфомация о фотостудии</h2>
    <form action="/admin/photoStudios/update/${photoStudio.id}" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="hidden" name="id" value="${photoStudio.id}" />

        <label for="address">Адрес:</label>
        <input type="text" name="address" value="${photoStudio.address}" id="address"/>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "address">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>

        <label for="title">Описание:</label>
        <input type="text" name="title" value="${photoStudio.title}" id="title"/>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "title">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>

        <button type="submit">Изменить</button>
    </form>

    <form method="post" enctype="multipart/form-data" action="/admin/photoStudios/update/${photoStudio.id}/upload">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="file" name="file" accept="image/*" required>
        <button type="submit">Загрузить</button>
    </form>
</div>

</body>
</html>