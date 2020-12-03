FROM openjdk:8-jre-slim

# Add the project jar & copy dependencies
ADD  //var/jenkins_home/workspace/seleniumDocker_master/target/selenium-docker.jar selenium-docker.jar
ADD  //var/jenkins_home/workspace/seleniumDocker_master/target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD  //var/jenkins_home/workspace/seleniumDocker_master/target/libs libs

ENTRYPOINT java -cp "seleniumDocker-0.0.1-SNAPSHOT.jar;libs/*" -DseleniumHubHost=localhost org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests