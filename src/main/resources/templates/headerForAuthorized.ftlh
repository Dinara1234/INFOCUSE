<div class="header">
    <img src="/img.png" alt="Логотип компании"> <!-- Замените logo.png на путь к вашему логотипу -->
    <div>
        <form action="<@spring.url '/logout'/>" method="post">
            <input type="submit" value="Выйти">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
</div>