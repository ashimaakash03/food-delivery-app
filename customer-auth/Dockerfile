FROM ubuntu:latest
FROM openjdk

LABEL authors="AXE, Ashish"

COPY target/*.jar /customer-auth-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/customer-auth-service.jar"]