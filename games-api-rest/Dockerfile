FROM maven:3.8.4-openjdk-11 AS build
COPY /src /app/src
COPY /pom.xml /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM eclipse-temurin:11-jre-alpine
EXPOSE 8080
COPY --from-build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]