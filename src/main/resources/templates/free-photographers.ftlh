<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Запись на фотосессию</title>
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
        .registration-form h4{
            text-align: left;
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
    <h2>Записаться на фотосессию</h2>
    <h4>Когда: ${startTime?datetime?string('dd.MM.yyyy HH:mm')} </h4>
    <h4>Где: ${studio.address} </h4>

    <form action="/api/new-photosession" method="post" id="myForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="hidden" name="timeStart" value="${startTime}" />
        <input type="hidden" name="timeEnd" value="${endTime}" />
        <input type="hidden" name="photoStudioId" id="photoStudioId" value="${studioId}" />
        <label for="title">Какая тематика фотосессии?</label>
        <input type="text" name="title" id="title"/>
        <label for="quantityOfModels">Сколько человек будет на фотосессии?</label>
        <input type="number" name="quantityOfModels" id ="quantityOfModels"/>
        <label for="photographerId">Выберите свободного фотографа:</label>
        <select id="photographerId" name="photographerId">
            <#list photographers as photographer>
                <option value="${photographer.id}">${photographer.user.firstName} ${photographer.user.lastName}</option>
            </#list>

        </select>
        <button type="button" onclick="submitForm()">Записаться</button>
        <div id="response"></div>

    </form>
</div>

</body>
<script>
    function submitForm() {

        const formData = {
            title: document.querySelector('input[name="title"]').value,
            quantityOfModels: document.getElementById('quantityOfModels').value,
            photographerId: document.getElementById('photographerId').value,
            photoStudioId: document.getElementById('photoStudioId').value,
            timeStart: document.querySelector('input[name="timeStart"]').value,
            timeEnd: document.querySelector('input[name="timeEnd"]').value
        };

        const csrfToken = document.querySelector('input[name="${_csrf.parameterName}"]').value;

        fetch('/api/new-photosession', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                '${_csrf.headerName}': csrfToken
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if (response.ok) {
                    document.getElementById('response').innerHTML =
                        '<div class="success">Фотосессия успешно создана!</div>';

                    setTimeout(() => {
                        window.location.href = '/user';
                    }, 2000);
                } else {
                    return response.json().then(error => {
                        throw new Error(error.message || 'Ошибка сервера');
                    });
                }
            })
            .catch(error => {
                document.getElementById('response').innerHTML =
                    `<div class="error">Ошибка: ОШИБКА</div>`;
            });
    }
</script>
</html>


