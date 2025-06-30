<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>регистрация фотосессии</title>
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
            height: 700px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            color: white;
            font-size: 19px;

        }

        .registration-form label {
            display: block;
            margin-top: 28px;
            color: #cccccc;
        }

        .registration-form input[type="email"],
        .registration-form input[type="password"],
        .registration-form input[type="number"],
        .registration-form input[type="text"],
        .registration-form input[type="file"]{
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

    <form action="/photographer/createPhotoSession" method="post" onsubmit="return validateForm()">

        <input type="text" id="title" name="title" placeholder="Описание:"  required>

        <div class="form-group">
            <select id="photoStudioId" name="photoStudioId" required>
                <option value="user">Пользователь</option>
            </select>
        </div>


        <div class="form-group">
            <label for="timeStart">Время и дата начала:</label>
            <input id="timeStart" name="timeStart" type="datetime-local" required>
        </div>
        <div class="form-group">
            <label for="timeEnd">Время и дата окончания:</label>
            <input id="timeEnd" name="timeEnd" type="datetime-local">
        </div>


        <input type="number" id="numberOfModels" name="numberOfModels" placeholder="Количество моделей:" required >

        <input type="number" id="price" name="price" placeholder="Оплата моделям:">

        <input type="text" id="camera" name="camera" placeholder="Камера:">


        <button type="submit">Зарегистрировать фотосессию</button>
    </form>
</div>
<script>
    function validateForm() {
        let value = document.getElementById("price").value;
        if (value.length > 8) {
            alert("Ввод должен быть не болльше 8 символов");
            return false;
        }
        return true;
    }
</script>
</body>
</html>