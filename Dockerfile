FROM openjdk:8-jre-slim

#need to verify working WORKDIR
WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
COPY  target/libs libs
COPY  target/seleniumDocker-0.0.1-SNAPSHOT.jar selenium-docker.jar

ENTRYPOINT java -cp "/usr/share/tag/seleniumDocker-0.0.1-SNAPSHOT.jar;/usr/share/tag/libs/*" -DseleniumHubHost=localhost org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests