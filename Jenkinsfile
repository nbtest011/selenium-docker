pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                echo 'STEP_1--> Building JAR files...'
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                echo 'STEP_2--> Building Image...'
                //sh
                bat "docker build -t nbtest011/seleniumdocker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
                    echo 'STEP_3-->Pushing Image to DockerHUB...'
			        bat "docker login --username=nbtest011 --password=nick@7528"
			        bat "docker push nbtest011/seleniumdocker:latest"
			    }                           
            }
        }
    }
}