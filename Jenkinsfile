pipeline { 
    environment { 
        registry = "jobanarubi/delivery-system" 
        registryCredential = 'docker-hub-credentials' 
        dockerImage = '' 
    }
    agent any 
    stages { 
        stage('Cloning our Git') { 
            steps { 
                git 'https://github.com/Jobanarubi/management-system.git' 
            }
        } 
        stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" //It uses jenkins build number for deployment
                }
            } 
        }
        stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push("${env.BUILD_NUMBER}")
 			dockerImage.push("latest")
                    }
                } 
            }
        } 
        stage('Deploy to kubernates') { 
            steps { 
                bat "kubectl apply -f Deployment.yml"  
            }
        } 
    }
}


