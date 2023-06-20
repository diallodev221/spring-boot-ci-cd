FROM openjdk:17-jdk

WORKDIR /app

COPY target/spring-boot-ci-cd-1.0.0.jar /app/spring-boot-ci-cd.jar

EXPOSE 8080

CMD ["java", "-jar", "spring-boot-ci-cd.jar"]