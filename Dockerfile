FROM openjdk:8-jre-slim

#need to verify working WORKDIR
WORKDIR C:\Windows\System32\cmd.exe

# Add the project jar & copy dependencies
ADD  target/selenium-docker.jar selenium-docker.jar
ADD  target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD  target/libs libs

ENTRYPOINT java -cp "seleniumDocker-0.0.1-SNAPSHOT.jar;libs/*" -DseleniumHubHost=localhost org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests