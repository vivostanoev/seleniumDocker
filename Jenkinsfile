def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('Get Maven Dependancies'){
            steps{
                sh "docker build -f Dockerfile -t mavenselenium ."
                //sh "docker run --rm mavenselenium"
            }
        }

    }
}