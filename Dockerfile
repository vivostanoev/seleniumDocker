FROM maven:3.5-jdk-8

COPY pom.xml pom.xml
COPY src src

ENTRYPOINT mvn clean install -DseleniumHubHost=$SELENIUM_HUB