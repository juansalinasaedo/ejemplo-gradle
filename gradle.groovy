def call(){

	stage('Build & Test'){
		env.TAREA = env.STAGE_NAME
		//sh "./gradlew clean build"
		sh './gradlew clean build'
	}	

	stage('Sonar') {
    env.TAREA = env.STAGE_NAME
    def scannerHome = tool 'sonar-scanner';
    withSonarQubeEnv('sonar') {
      sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
   	 }
    }

    stage('Run') {
   		env.TAREA = env.STAGE_NAME
    	sh 'nohup bash gradlew bootRun &'
    	sleep 30
 	 }


 	stage('Rest') {    
     env.TAREA = env.STAGE_NAME
     //sh "curl -X GET 'http://localhost:8082/rest/mscovid/test?msg=testing'' "
    }

	stage('Nexus'){
		env.TAREA = env.STAGE_NAME
		nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/home/juan/ejemplo-maven-1/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
	}
}

return this;