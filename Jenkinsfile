def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'
def workspace = pwd()

pipeline {
    agent any

    stages {
        stage('Create network') {
            steps{
                sh "docker network create ${network}"
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
                sh "docker build -f Dockerfile -t mavenselenium ."
                sh "docker run --rm -e SELENIUM_HUB=${seleniumHub} -v ${workspace}/target:/target --network ${network} mavenselenium"
            }
        }
        stage('Tearing Down Selenium Grid'){
            steps{
                sh "docker rm -vf ${chrome}"
                sh "docker rm -vf ${seleniumHub}"
                sh "docker network rm ${network}"
            }
        }
        stage('Reports test results') {
            steps {
            script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
            }
            }
        }
    }
}