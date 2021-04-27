pipeline {
    agent any

    environment {
        DOCKER_HOST=tcp://192.168.1.145:2377
    }

    stages {
        stage('Build') {
            steps {
                sh 'printenv'
            }
        }
    }
}