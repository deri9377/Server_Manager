pipeline {
  agent {
        docker {
            image 'maven:3.9.3-eclipse-temurin-17'
        }
    }
  tools {
    maven 'Maven-3.9.5' 
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage ('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage ('Deploy') {
      steps {
        
      }
    }
  }
}
