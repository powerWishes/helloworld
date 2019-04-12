pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('__init__') {
            input{
                message "please ensure project."
                ok "Yes, I'm sure."
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                    booleanParam(name: 'is-parent-build-chanpay-parent', defaultValue: 'false', description: '父工程')
                    booleanParam(name: 'is-parent-build-chanpay-parent-general', defaultValue: 'false', description: '通用父工程')
                    booleanParam(name: 'is-parent-build-chanpay-common', defaultValue: 'false', description: '公共工程')
                }
            }
            steps {
                script {
                    echo is-parent-build-chanpay-parent value is ${is-parent-build-chanpay-parent}
                    echo is-parent-build-chanpay-parent-general value is ${is-parent-build-chanpay-parent-general}
                    echo is-parent-build-chanpay-common value is ${is-parent-build-chanpay-common}
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
