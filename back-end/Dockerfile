FROM maven:3.9.6-eclipse-temurin-22 as builder
COPY ./back-end/src src/
COPY ./back-end/pom.xml pom.xml
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=builder target/*.jar Enem-questions.jar
EXPOSE 8080
CMD ["java", "-jar", "Enem-questions.jar"]