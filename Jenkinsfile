pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t nbtest011/seleniumdocker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dmr@1234', usernameVariable: 'nbtest011')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push nbtest011/seleniumdocker:latest"
			    }                           
            }
        }
    }
}