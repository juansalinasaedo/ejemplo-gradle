def call() {

	stage('Compile') {
        env.TAREA = env.STAGE_NAME
        git( branch: 'main', url: 'https://github.com/juansalinasaedo/ejemplo-gradle.git')
        sh './mvnw clean compile -e'
    }

    stage('Test') {
        env.TAREA = env.STAGE_NAME
        sh './mvnw test -e'
    }

    stage('Jar') {
        env.TAREA = env.STAGE_NAME
        sh './mvnw package -e -DskipTests=true'
    }


    stage('Run') {
        env.TAREA = env.STAGE_NAME
        sh './mvnw spring-boot:run &'
    }

    
    stage('SonarQube') {
        env.TAREA = env.STAGE_NAME
        withSonarQubeEnv(installationName: 'sonar') {
            sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
        }
    }


     /* stage('uploadNexus') {
         STAGE_NAME = 'uploadNexus'
         nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
         
       }   */
}

return this;