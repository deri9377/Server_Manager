pipeline {
  agent {
        docker {
          // Set both label and image
          label 'docker'
          image '3.9.6-eclipse-temurin-17'
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
        sh 'mvn clean spring-boot:run'
      }
    }
  }
}
