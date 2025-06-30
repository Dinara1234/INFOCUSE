<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Результаты поиска Unsplash</title>
    <style>
        body { font-family: sans-serif; margin: 20px; background-color: #EBE7E3; }
        .container { max-width: 800px; margin: auto; }
        form { margin-bottom: 30px; }
        input[type="text"] { padding: 8px; width: 300px; }
        input[type="submit"] { padding: 8px 15px; background-color:rgba(148, 57, 57, 0.9); color: white; border: none; cursor: pointer; }
        body { font-family: sans-serif; margin: 20px;  }
        .container { max-width: 1200px; margin: auto;  background-color: #EBE7E3;}
        .photo-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;

        }
        .photo-item {
            border: 5px solid #943939;
            padding: 10px;
            text-align: center;
        }
        .photo-item img {
            max-width: 100%;
            height: auto;
            display: block;
            margin: auto;
        }
        .photo-item p {
            margin-top: 10px;
            font-size: 0.9em;
            color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="container">
        <h1>Поиск фотографий Unsplash</h1>
        <form action="/references/search-photos" method="get">
            <label for="query">Что ищем?</label>
            <input type="text" id="query" name="query" placeholder="например, природа">
            <input type="submit" value="Найти">
        </form>
    </div>
    <h1>Результаты поиска для: <span>${query}</span></h1>
    <#if totalResults??>
        <p>Найдено: <span>${totalResults}</span> фото.</p>
    </#if>
    <#if message??>
        <p style="color: red;">${message}</p>
    </#if>

    <#if photos?has_content>
        <div class="photo-grid">
            <#list photos as photo>
                <div class="photo-item">
                    <a href="${photo.urls.full}" target="_blank">
                        <img src="${photo.urls.small}" alt="${photo.alt_description!''}">
                    </a>
                    <#if photo.description??>
                        <p>${photo.description}</p>
                    <#else>
                        <p>Без описания</p>
                    </#if>
                    <p>Автор: <a href="${photo.user.portfolio_url!''}" target="_blank">${photo.user.name!''}</a></p>
                </div>
            </#list>
        </div>
    <#else>
        <#if !message??>
            <p>Фотографии по запросу не найдены.</p>
        </#if>
    </#if>

    <p><a href="/references/search-photos?query=${query}&page=${page+1}">Следующая страница</a></p>
</div>
</body>
</html>