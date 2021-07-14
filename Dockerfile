# First step: build the app from source inside a temp container
FROM openjdk:17-jdk-alpine as BUILD
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Build
RUN sh ./mvnw clean install

# Second step: Create a new image for the compiled application
FROM openjdk:17-jdk-alpine

# Create unprivileged user
RUN addgroup -S spring
RUN adduser -S spring -G spring

# Install jar
COPY --from=BUILD /workspace/app/target/*.jar app.jar

USER spring:spring
WORKDIR /home/spring

# Use production profile by default
ARG DEFAULT_PROFILE="prod"
ENV DEFAULT_JAVA_OPTS="-Dspring.profiles.active=${DEFAULT_PROFILE}"
ENTRYPOINT ["sh", "-c", "java ${DEFAULT_JAVA_OPTS} ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]
