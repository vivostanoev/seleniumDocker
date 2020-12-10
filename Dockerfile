FROM maven:3.5-jdk-8
RUN mkdir -p /build
WORKDIR build/app

COPY pom.xml build/app/pom.xml
COPY src build/app/src

VOLUME scr/target build/app/src/target

ENTRYPOINT mvn clean install -DseleniumHubHost=$SELENIUM_HUB