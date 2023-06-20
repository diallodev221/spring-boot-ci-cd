FROM openjdk:17-jdk

WORKDIR /app

COPY target/*.jar /app/spring-boot-ci-cd.jar

EXPOSE 8080

CMD ["java", "-jar", "spring-boot-ci-cd.jar"]