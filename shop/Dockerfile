# syntax=docker/dockerfile:1


# Create a stage for resolving and downloading dependencies.
FROM eclipse-temurin:17-jdk-jammy as deps

COPY target/shop-0.0.1-SNAPSHOT.jar app-shop.jar

ENTRYPOINT ["java", "-jar", "app-shop.jar"]