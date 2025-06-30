<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Свободные слоты</title>
    <style>
        .date-nav { margin-bottom: 20px; }
        .date-link {
            margin-right: 15px;
            padding: 5px 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            text-decoration: none;
        }
        .date-link.active {
            background-color: #007bff;
            color: white;
            border-color: #007bff;
        }
        .slot-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));
            gap: 10px;
        }
        .slot-btn {
            padding: 10px;
            background-color: #943939;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
        }
        .slot-btn:hover {
            background-color: #c82333;
        }
        .no-slots {
            padding: 20px;
            text-align: center;
            color: #6c757d;
        }
    </style>
</head>
<body>
<h1>currentSelectedDate: ${currentSelectedDate}</h1>
<h1>Свободные слоты на ${currentSelectedDate.dayOfMonth?string("00")}.${currentSelectedDate.monthValue?string("00")}.${currentSelectedDate.year}</h1>

<div class="date-nav">
    <a class="date-link ${(currentSelectedDate == today)?then('active', '')}"
       href="?displayDate=${today}T00:00:00">
        Сегодня
    </a>
    <a class="date-link ${(currentSelectedDate == tomorrow)?then('active', '')}"
       href="?displayDate=${tomorrow}T00:00:00">
        Завтра
    </a>
    <a class="date-link ${(currentSelectedDate == dayAfterTomorrow)?then('active', '')}"
       href="?displayDate=${dayAfterTomorrow}T00:00:00">
        Послезавтра
    </a>
</div>

<#if freeSlots?has_content>
    <div class="slot-grid">
        <#list freeSlots as slot>
        <#assign startHour = slot.startTime.hour?string("00")>
        <#assign startMinute = slot.startTime.minute?string("00")>
        <#assign endHour = slot.endTime.hour?string("00")>
        <#assign endMinute = slot.endTime.minute?string("00")>

        <button class="slot-btn"
                onclick="selectSlot('${slot.startTime}', '${slot.endTime}')">
            ${startHour}:${startMinute} - ${endHour}:${endMinute}
        </button>
        </#list>
    </div>
<#else>
    <div class="no-slots">
        Нет доступных слотов на эту дату
    </div>
</#if>

<script>
    function selectSlot(startTime, endTime) {
        const baseUrl = `/${studioId}/free-photographers`;

        const params = new URLSearchParams();
        params.append('startTime', startTime);
        params.append('endTime', endTime);

        const fullUrl = baseUrl+'?'+params.toString();

        window.location.href = fullUrl;
    }
</script>
</body>
</html>