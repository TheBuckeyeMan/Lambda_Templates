FROM openjdk:17-jdk-slim
ARG JAR_FILE=./target/template-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar

# Switch to non-root user (optional but recommended for security)
RUN useradd -m appuser && chown -R appuser /app
USER appuser

ENTRYPOINT ["java","-jar","/app/app.jar"]