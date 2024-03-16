FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/MyBookStore-0.0.1-SNAPSHOT.jar MyBookStore.jar
EXPOSE 8080
EXTRYPOINT ["java","-jar","MyBookStore.jar"]