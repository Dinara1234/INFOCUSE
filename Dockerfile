# Второй этап: создаем легковесный образ для запуска приложения
FROM eclipse-temurin:17.0.14_7-jre-ubi9-minimal

# Копируем собранный JAR файл из первого этапа
#COPY build/libs/*.jar app.jar
COPY *.jar app.jar

EXPOSE 80
# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]