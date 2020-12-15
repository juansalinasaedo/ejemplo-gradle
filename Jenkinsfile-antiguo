pipeline {
     agent any
     stages {
        stage('Compile'){
          steps{
            sh 'mvn clean compile -e'
          }
        }

        stage('Test'){
          steps{
            sh 'mvn clean test -e'
          }
        }

        stage('Jar'){
          steps{
            sh 'mvn clean package -e'
          }
        }

        stage('SonarQube analysis') {
          withSonarQubeEnv('b7ebf13f1da15514bc93797c4cb704fe619c408b', installationName: 'sonar') { 
          sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
          }
        }

        stage('Run'){
          steps{
            sh 'mvn spring-boot: run &'
          }
        }

        stage('Sleep'){
          steps{
            sh 'sleep 10'
          }
        }

        stage('Testing'){
          steps{
            sh 'curl -X GET "http://localhost:8081/rest/mscovid/test?msg=testing"'
          }
        }

    }

}
