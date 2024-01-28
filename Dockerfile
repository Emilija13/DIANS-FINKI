FROM maven:3.8.4-openjdk-17  AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17
COPY --from=build /target/app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]