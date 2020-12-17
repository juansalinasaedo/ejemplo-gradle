pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps {
               script {


               	 stage('Build & Test'){
               	 	sh "./gradle clean build"
               	 }

               	 stage('Sonar'){
               	 	//corresponde a lo que se configuro en global tool config
               	    def scannerHome = tool 'sonar-scanner';
               	    //coresponde a lo que se configuro en administrar jenkins - configurar sistema - sonarqube server
               	    withSonarQubeEnv('sonar') {
               	    	sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
               	    }
               	 }

               	 stage('Run'){
               	 	//
               	 }

               	 stage('Rest'){
               	 	//
               	 }

               	 stage('Nexus'){
               	 	//
               	 }


               }
            }
        }
    }
}
