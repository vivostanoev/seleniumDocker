FROM openjdk:8-jre-slim

#need to verify working WORKDIR
WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/seleniumDocker-0.0.1-SNAPSHOT.jar selenium-docker.jar
ADD  target/libs libs

HEALTHCHECK --interval=5s --timeout=3s --retries=3 \
      CMD curl -f http://$SELENIUM_HUB:4444/wd/hub || exit 1

ENTRYPOINT java -cp 'selenium-docker.jar:libs/*' -DseleniumHubHost=$SELENIUM_HUB org.junit.runner.JUnitCore seleniumDocker.OpenBrowserTests