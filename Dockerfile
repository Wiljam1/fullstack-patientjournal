# Use OpenJDK 21 as the base image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper files and the project POM
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Clean up the Maven wrapper file
RUN sed -i 's/\r$//' mvnw

# Resolve dependencies and package the application into a JAR file
RUN ./mvnw clean package

# Copy the application source code
COPY src ./src

# Command to run when the container starts
CMD ["java", "-jar", "target/fullstack-patientjournal.jar"]
