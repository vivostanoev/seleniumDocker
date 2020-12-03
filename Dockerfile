FROM openjdk:8-jre-slim

#need to verify working WORKDIR
WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/seleniumDocker-0.0.1-SNAPSHOT.jar selenium-docker.jar
ADD  target/libs libs

ENTRYPOINT java -cp 'selenium-docker.jar:libs/*' -DseleniumHubHost=localhost org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests