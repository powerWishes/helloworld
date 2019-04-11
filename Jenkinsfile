pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('构建') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('测试') {
            steps {
                sh 'echo skip test stage, because ... You konw.' 
            }
        }
        stage('运行') {
            steps {
                sh 'java -jar target/helloworld-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
