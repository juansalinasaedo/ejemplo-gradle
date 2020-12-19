def call(){

	stage('Build & Test'){
		STAGE_NAME = 'Build & test'
		//sh "./gradlew clean build"
		sh "gradle clean build"
	}	

	stage('Sonar'){
		STAGE_NAME = 'sonar'
		def scannerHome = tool 'sonar-scanner';
		//nombre del servidor de sonar en jenkins
		withSonarQubeEnv('sonar') {
			sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
		}
	}

	stage('Run'){
		STAGE_NAME = 'Run'
		sh "nohup bash gradlew bootRun &"
		sleep 30
	}

	stage('Test'){
		STAGE_NAME = 'Test'
		sh "curl -X GET 'http://localhost:8082/rest/mscovid/test?msg=testing'"
	}

	stage('Nexus'){
		STAGE_NAME = 'Nexus'
		nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/home/juan/ejemplo-maven-1/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
	}
}

return this;