# Todo use Medidata docker image for java
FROM openjdk:8-jdk-alpine
MAINTAINER team22
# Todo create work directory
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ticket-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ticket-service.jar"]