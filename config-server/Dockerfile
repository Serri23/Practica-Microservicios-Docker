FROM openjdk:latest

WORKDIR /config-server
COPY ./target/config-server-0.0.1-SNAPSHOT.jar /config-server

EXPOSE 8090

CMD ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]