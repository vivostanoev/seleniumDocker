def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('Run selenium Grid') {
            steps{
            powershell "docker run -d -p 4444:4444 --name selenium-hub selenium/hub:3.141.59-20201119"
            powershell "docker run -d --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-20201119"
            }
        }

        stage('Run maven '){
            steps{
                powershell "mvn test"
            }
        }
    }
}