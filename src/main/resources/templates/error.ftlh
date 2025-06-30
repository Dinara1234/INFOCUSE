<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ошибка приложения</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            line-height: 1.6;
            color: #333;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f8f9fa;
        }
        .error-container {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            padding: 30px;
            margin-top: 40px;
        }
        .error-header {
            color: #dc3545;
            border-bottom: 1px solid #e9ecef;
            padding-bottom: 15px;
            margin-bottom: 20px;
        }
        .error-detail {
            margin-bottom: 15px;
            padding: 10px;
            background: #f8f9fa;
            border-radius: 4px;
        }
        .label {
            font-weight: bold;
            display: inline-block;
            width: 120px;
            color: #6c757d;
        }
        .value {
            display: inline-block;
        }
        .timestamp {
            color: #6c757d;
            font-size: 0.9em;
            margin-top: 25px;
            text-align: center;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            color: #0d6efd;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1 class="error-header">Произошла ошибка</h1>

    <div class="error-detail">
        <span class="label">Код ошибки:</span>
        <span class="value">${errorStatus!500}</span>
    </div>

    <div class="error-detail">
        <span class="label">Описание:</span>
        <span class="value">${errorMessage!'Internal Server Error'}</span>
    </div>

    <div class="error-detail">
        <span class="label">URL запроса:</span>
        <span class="value">${errorUrl!'Unknown URL'}</span>
    </div>

    <div class="error-detail">
        <span class="label">Время ошибки:</span>
        <span class="value">${errorTimestamp?datetime!now?datetime}</span>
    </div>


    <div class="timestamp">
        Текущее время: ${.now?datetime}
    </div>
</div>
</body>
</html>