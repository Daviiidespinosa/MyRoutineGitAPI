FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src /app/src

RUN mvn clean install

FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=build /app/target/your-api.jar /app/your-api.jar

CMD ["java", "-jar", "your-api.jar"]
