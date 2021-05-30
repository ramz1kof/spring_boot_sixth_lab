FROM maven:3.8.1-adoptopenjdk-15

RUN mkdir /tmp/spring_boot_app
COPY pom.xml /tmp/spring_boot_app
COPY src /tmp/spring_boot_app/src/

WORKDIR /tmp/spring_boot_app

RUN mvn clean package

RUN apt update && apt install mysql-server -y

EXPOSE 3306
EXPOSE 8083

COPY setup /tmp/spring_boot_app/
RUN chmod +x ./setup

ENTRYPOINT [ "./setup" ]