<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
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
            height: 600px;
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

        .registration-form input, select {
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
    <h2>Регистрация</h2>

    <form action="/sign-up" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <label for="firstName">Имя:</label>
        <input type="text" name="firstName" id="firstName"/>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "firstName">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>

        <label for="lastName">Фамилия:</label>
        <input type="text" name="lastName" id="lastName"/>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "lastName">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>

        <label for="role">Выберите роль:</label>
        <select id="role" name="role">
            <option value="user">Пользователь</option>
            <option value="photographer">Фотограф</option>
        </select>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "email">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required>
        <#if errors??>
            <#list errors as error>
                <#if error.field == "password">
                    <div style="color: red; margin-top: 5px;">${error.defaultMessage}</div>
                </#if>
            </#list>
        </#if>

        <button type="submit">Зарегистрироваться</button>
    </form>
</div>

</body>
</html>
