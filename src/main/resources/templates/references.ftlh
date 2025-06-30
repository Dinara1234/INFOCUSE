<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Unsplash Photo Search</title>
    <style>
        body { font-family: sans-serif; margin: 20px; background-color: #EBE7E3; }
        .container { max-width: 800px; margin: auto; }
        form { margin-bottom: 30px; }
        input[type="text"] { padding: 8px; width: 300px; }
        input[type="submit"] { padding: 8px 15px; background-color:rgba(148, 57, 57, 0.9); color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>
<div class="container">
    <h1>Поиск фотографий Unsplash</h1>
    <form action="/references/search-photos" method="get">
        <label for="query">Что ищем?</label>
        <input type="text" id="query" name="query" placeholder="например, природа">
        <input type="submit" value="Найти">
    </form>
</div>
</body>
</html>