FROM openjdk:17-jdk-slim
LABEL authors="PIXL CTO - Parker Rennie"
WORKDIR /app
COPY build/libs/PIXL-POS-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]