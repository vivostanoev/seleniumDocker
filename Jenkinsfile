def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('Build image from Maven and Test Code') {
            steps{
            sh "docker build -f Dockerfile -t mavenselenium ."
            }
        }
        stage('Docker Compose up') {
            steps{
                sh "docker-compose up"
            }
        }
        stage('Docker Compose down'){
            steps{
                sh "docker-compose down"
            }
        }
        stage('Reports test results') {
            steps {
            script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            args: '-u root:root',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
            }
            }
        }
    }
}