FROM openjdk:latest

EXPOSE 8083

COPY ./target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]