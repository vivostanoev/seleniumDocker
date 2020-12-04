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
                sh "docker run -d -p 4444:4444 --net ${network} --name ${seleniumHub} selenium/hub:3.141.59-20201119"
                sh "docker run -d --net ${network} -e HUB_HOST=${seleniumHub} --name ${chrome} -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-20201119"
            }
        }
        stage('Run Automation test'){
            steps{
                sh "docker run --rm -e SELENIUM_HUB=${seleniumHub} --network ${network} seleniumdocker"
            }
        }
        stage('Tearing Down Selenium Grid'){
            steps{
                sh "docker rm -vf ${chrome}"
                sh "docker rm -vf ${seleniumHub}"
                sh "docker network rm ${network}"
            }
        }
    }
}