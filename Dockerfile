FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/TodoList-1.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]