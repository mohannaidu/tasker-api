FROM openjdk:11-jdk-slim-stretch
WORKDIR /app
COPY target/tasker-1.0-SNAPSHOT.jar .
COPY config.yml .
CMD java -jar tasker-1.0-SNAPSHOT.jar server /app/config.yml
EXPOSE 8080