# Start with a base image containing Java runtime
FROM openjdk:17-jdk as build

# Add Maintainer Info
LABEL maintainer="ramy.oubeid@gmail.com"

# Set the current working directory inside the Docker image
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Fetch all dependencies
RUN ./mvnw dependency:go-offline -B

# Copy your source code into the Docker image
COPY src src

# Package the application
RUN ./mvnw package -DskipTests

# Use a lightweight base image for the runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy only the built artifact and nothing else
COPY --from=build /app/target/*.jar app.jar

EXPOSE 4000

# Specify the entry point
ENTRYPOINT ["java","-jar","app.jar"]