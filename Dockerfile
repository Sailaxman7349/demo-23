FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY target/school-gateway-0.0.1-SNAPSHOT.jar /app/school-gateway.jar

EXPOSE 8081

CMD ["java", "-jar", "school-gateway.jar"]