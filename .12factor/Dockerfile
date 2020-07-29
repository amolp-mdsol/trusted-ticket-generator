# Todo use Medidata docker image for java
FROM openjdk:8-jdk-alpine
MAINTAINER team22
#RUN rm -rf /var/lib/apt/lists/* && apt-get update
RUN apt-get install maven -y --no-install-recommends
RUN artifactory-exec mvn install
# Todo create work directory
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ticket-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ticket-service.jar"]