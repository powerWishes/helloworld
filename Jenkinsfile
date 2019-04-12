#!groovy
def needBuildProList = []
def buildPerson = 'admin'
def parent = false
def general = false
def common = false
pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('__init__') {
            input {
                message "Choice your project, please."
                ok "Ok, I'm sure."
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                    booleanParam(name: 'parentBool', defaultValue: false, description: '父工程')
                    booleanParam(name: 'generalBool', defaultValue: false, description: '通用父工程')
                    booleanParam(name: 'commonBool', defaultValue: false, description: '公共工程')
               }
            }
            steps {
                script {
                    parent = '${parentBool}'
                    general = '${generalBool}'
                    common = '${commonBool}'
                    println 'parent,'+parent
                    println 'general,'+general
                    println 'common,'+common
                    if (parent) {
                        needBuildProList.add("chanpay-parent")
                        println 'needBuildProList 1'
                    }
                    if (general) {
                        needBuildProList.add("chanpay-general")
                        println 'needBuildProList 2'
                    }
                    if (common) {
                        needBuildProList.add("chanpay-common")
                        println 'needBuildProList 3'
                    }
                    buildPerson = "${PERSON}"
                    println 'need build project :' + needBuildProList
                    println 'buildPerson :' + buildPerson
                    for(nbp in needBuildProList) {
                        echo "正在检出项目：${nbp}"
                    }
                }
            }
        }
        stage('__build__') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('__test__') {
            steps {
                sh 'echo skip test stage, because ... You konw.' 
            }
        }
        stage('__run__') {
            steps {
                sh 'mkdir -p logs'
                sh 'nohup java -jar target/helloworld-0.0.1-SNAPSHOT.jar > logs 2>&1 &'
            }
        }
    }
}
