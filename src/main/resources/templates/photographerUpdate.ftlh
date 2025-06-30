<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Изменить информацию о фотографе</title>
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
            height: 420px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            color: white;
            font-size: 19px;

        }

        .registration-form label {
            display: block;
            margin-top: 10px;
            color: #cccccc;
        }

        .registration-form input[type="email"],
        .registration-form input[type="password"] {
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
    <h2>Изменить данные фотографа</h2>

    <form action="/photographer/update" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <label for="name">Имя:</label>
        <input type="text" name="firstName" id="name" value="${photographer.firstName}"/><#if errors??>
        <#list errors as error>
            <#if error.field == "firstName">
                <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
            </#if>
        </#list>
        </#if>

        <label for="sername">Фамилия:</label>
        <input type="text" name="lastName" id="sername" value="${photographer.lastName}"/>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "lastName">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>

        <#if photographerDetails??>
            <#if photographerDetails.title??>
                <label for="title">О себе:</label>
                <input type="text" name="title" id="title" value="${photographerDetails.title}"/>
                <#if errors??>
                    <#list errors as error>
                        <#if error.field == "title">
                            <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                        </#if>
                    </#list>
                </#if>
            <#else>
                <label for="title">Добавьте информацию о себе:</label>
                <input type="text" name="title"/>
                <#if errors??>
                    <#list errors as error>
                        <#if error.field == "title">
                            <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                        </#if>
                    </#list>
                </#if>
            </#if>
        <#else>
            <label for="title">Добавьте информацию о себе:</label>
            <input type="text" name="title"/>
            <#if errors??>
                <#list errors as error>
                    <#if error.field == "title">
                        <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                    </#if>
                </#list>
            </#if>
        </#if>

        <input type="submit" value="Изменить"/>
    </form>

    <form method="post" enctype="multipart/form-data" action="/photographer/update/upload">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <label for="image">Загрузите свои фотографии:</label>
        <input type="file" name="file" id="image" accept="image/*" required>
        <button type="submit">Загрузить</button>
    </form>
</div>

</body>
</html>
