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
                sh "docker network create ${network}"
                sh "docker build -f Dockerfile -t seleniumdocker ."
            }
        }
        stage('Run a Selenium Grid') {
            steps{
                sh "docker run -d -p 4444:4444 --network ${network} --name ${seleniumHub} selenium/hub:3.141.59-20201119"
                sh "docker run -d -e HUB_HOST=${seleniumHub} -e HUB_PORT_4444_TCP_PORT=4444 --network ${network} --name ${chrome} selenium/node-chrome"
            }
        }
        stage('Run Automation test'){
            steps{
                sh "docker run --rm -e SELENIUM_HUB=${seleniumHub} --network ${network} seleniumdocker"
            }
        }
    }
}