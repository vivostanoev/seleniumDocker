FROM maven:3.5-jdk-8

COPY pom.xml pom.xml
COPY src/test src

ENTRYPOINT mvn test -DseleniumHubHost=$SELENIUM_HUB