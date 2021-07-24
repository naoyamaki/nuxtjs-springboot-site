FROM openjdk:11-jdk-slim
ARG JAR_FILE=spring-boot-src/build/libs/\*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
