pipeline {
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
