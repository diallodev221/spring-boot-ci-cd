FROM maven:3.8.6 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/*jar spring-boot-ci-cd.jar
EXPOSE 8080
CMD ["java", "-jar", "spring-boot-ci-cd.jar"]