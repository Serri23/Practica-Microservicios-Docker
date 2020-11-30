FROM openjdk:latest

WORKDIR /pago
COPY ./target/pago-0.0.1-SNAPSHOT.jar /pago

EXPOSE 8001

CMD ["java", "-jar", "pago-0.0.1-SNAPSHOT.jar"]