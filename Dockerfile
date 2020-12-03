FROM openjdk:8-jre-slim

#need to verify working WORKDIR
#WORKDIR /var/jenkins_home/workspace/seleniumDocker_master

# Add the project jar & copy dependencies
COPY  target/libs libs
COPY  target/seleniumDocker-0.0.1-SNAPSHOT.jar selenium-docker.jar

ENTRYPOINT java -cp "seleniumDocker-0.0.1-SNAPSHOT.jar;libs/*" -DseleniumHubHost=localhost org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests