FROM openjdk:17-jdk

WORKDIR /app

COPY target/springbootcicd-1.0.0.jar /app/springbootcicd.jar

EXPOSE 8080

CMD ["java", "-jar", "springbootcicd.jar"]