FROM openjdk:8-jre-slim

#need to verify working WORKDIR
WORKDIR /test

# Add the project jar & copy dependencies
ADD  target/seleniumDocker-0.0.1-SNAPSHOT.jar selenium-docker.jar
ADD  target/libs libs

ENTRYPOINT java -cp test/seleniumDocker-0.0.1-SNAPSHOT.jar:test/libs/* -DseleniumHubHost=localhost org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests