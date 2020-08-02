FROM openjdk:14.0-jdk-slim
WORKDIR /app

COPY build/libs/poll-service.jar /app/service.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/service.jar"]
