#FROM ubuntu:latest
#LABEL authors="a.gabbasova"
#
#ENTRYPOINT ["top", "-b"]

# Используем официальный образ Java
FROM openjdk:21-jdk-slim

# Указываем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем собранный JAR-файл внутрь контейнера
COPY target/UserService-0.0.1-SNAPSHOT.jar app.jar

# Указываем порт, который будет слушать приложение
EXPOSE 8080

# Команда запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
