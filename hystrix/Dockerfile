FROM openjdk:latest

WORKDIR /hystrix
COPY ./target/hystrix-0.0.1-SNAPSHOT.jar /hystrix

EXPOSE 8674

CMD ["java", "-jar", "hystrix-0.0.1-SNAPSHOT.jar"]