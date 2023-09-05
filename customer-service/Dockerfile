FROM ubuntu:latest
FROM openjdk

LABEL authors="AXE, Ashish"

COPY target/*.jar /customer-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/customer-service.jar"]