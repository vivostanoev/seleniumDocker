def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('Build a Dockerfile') {
            steps{
                $ docker build -f Dockerfile -t seleniumdocker .
            }
        }
        stage('Run a Selenium Grid') {
            steps{

                $ docker network create grid
                $ docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.141.59-20201119
                $ docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-20201119


            }
        }
        stage('Run Automation test'){
            steps{
                $ docker run --rm -e SELENIUM_HUB=selenium-hub --network ${network} seleniumdocker"
            }
        }
    }
}