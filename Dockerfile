FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
WORKDIR /app
COPY target/ai-insight-reader-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
