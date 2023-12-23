pipeline {
  agent any
  tools {
    maven 'Maven-3.9.5' 
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage ('Deploy') {
      steps {
        sh 'mvn clean spring-boot:run'
      }
    }
  }
}
