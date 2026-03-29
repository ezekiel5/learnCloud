# Base image Java 17
FROM eclipse-temurin:17-jdk-alpine

# Tentukan folder kerja di dalam container
WORKDIR /app

# Copy jar hasil build dari target folder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose port Spring Boot default
EXPOSE 8080

# Jalankan aplikasi
ENTRYPOINT ["java","-jar","/app.jar"]