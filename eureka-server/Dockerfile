FROM ubuntu:latest
FROM openjdk

LABEL authors="AXE, Ashish"

COPY target/*.jar /eureka-server.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]