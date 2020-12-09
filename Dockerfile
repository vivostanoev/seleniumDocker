FROM maven:3.5-jdk-8
COPY pom.xml pom.xml
RUN mvn dependency:resolve