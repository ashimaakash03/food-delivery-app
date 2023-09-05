FROM ubuntu:latest
FROM openjdk

LABEL authors="AXE, Ashish"

COPY target/*.jar /order-service.jar

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "/order-service.jar"]