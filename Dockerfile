FROM openjdk:8-jre-slim

#need to verify working WORKDIR

# Add the project jar & copy dependencies
ADD  target/libs libs
ADD  target/seleniumDocker-0.0.1-SNAPSHOT.jar selenium-docker.jar

ENTRYPOINT java -cp "seleniumDocker-0.0.1-SNAPSHOT.jar;libs/*" -DseleniumHubHost=localhost org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests