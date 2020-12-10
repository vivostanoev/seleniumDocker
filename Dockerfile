FROM maven:3.5-jdk-8
RUN mkdir -p /build
WORKDIR /build

COPY pom.xml build/pom.xml
COPY src build/src

VOLUME scr/target build/src/target

ENTRYPOINT mvn clean install -DseleniumHubHost=$SELENIUM_HUB