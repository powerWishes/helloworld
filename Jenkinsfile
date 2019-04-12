def needBuildProList = []
def buildPerson = ''
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
                    booleanParam(name: 'is-parent-build-chanpay-parent', defaultValue: false, description: '父工程')
                    booleanParam(name: 'is-parent-build-chanpay-parent-general', defaultValue: false, description: '通用父工程')
                    booleanParam(name: 'is-parent-build-chanpay-common', defaultValue: false, description: '公共工程')
               }
            }
            steps {
                if (${is-parent-build-chanpay-parent}==true) {
                     needBuildProList.add('chanpay-parent')
                 }
                if (${is-parent-build-chanpay-parent-general}==true) {
                     needBuildProList.add('chanpay-general')
                 }
                if (${is-parent-build-chanpay-common}==true) {
                     needBuildProList.add('chanpay-common')
                 }
                script {
                    println 'need build project :' + needBuildProList
                    println 'buildPerson :' + buildPerson     
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
