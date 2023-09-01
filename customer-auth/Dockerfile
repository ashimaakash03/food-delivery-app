FROM ubuntu:latest
FROM openjdk

LABEL authors="AXE, Ashim"

COPY target/*.jar /customer-auth-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/customer-auth-service.jar"]