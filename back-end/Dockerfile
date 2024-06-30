FROM maven:3.9.6-eclipse-temurin-22 as builder
WORKDIR /build
COPY ./pom.xml .
RUN mvn dependency:go-offline

COPY ./src /build/src/
RUN mvn package -DskipTests

FROM openjdk:21-jdk
COPY --from=builder /build/target/*.jar Enem-questions.jar
EXPOSE 8080
CMD ["java", "-jar", "Enem-questions.jar"]