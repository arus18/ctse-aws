FROM openjdk:17-jdk-slim

ENV SERVER_PORT=80

WORKDIR /app
COPY target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
