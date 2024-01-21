FROM openjdk:17
WORKDIR /app
COPY target/client.jar client.jar
CMD ["java", "-jar", "client.jar"]