FROM openjdk:8
ADD target/api-covid19.jar api-covid19.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-covid19.jar"]