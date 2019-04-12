pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    parameters {
        choice(name: 'serverAddress', choices: '10.255.1.51\n10.255.0.113', description: '服务器（51测试/113联调）')
        string(name: 'parentBranch', defaultValue: 'master', description: '父工程分支')
        string(name: 'commonBranch', defaultValue: 'master', description: '公共工程分支')
        string(name: 'facadeBranch', defaultValue: 'master', description: '接口工程分支')
        string(name: 'projectBranch', defaultValue: 'master', description: '应用工程分支')

        booleanParam(name: 'is-parent-build-chanpay-parent', description: '父工程')
        booleanParam(name: 'is-parent-build-chanpay-parent-general', description: '通用父工程')
        booleanParam(name: 'is-parent-build-chanpay-common', description: '公共工程')
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
