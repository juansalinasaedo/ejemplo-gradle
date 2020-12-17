pipeline {
	agent any 

	parameters { choice(name: 'herramienta', choices: ['gradle','maven'], description: '') }

	stages {
		stage('Pipelines') {
			steps {
				script {

					params.herramienta // -> gradle o maven

					if(params.herramienta == 'gradle'){
						//inovacion a gradle.groovy
					}else{
						//invocacion a maven.groovy
					}

					switch(params.herramienta) {
						case 'gradle':
						  //inovacion a gradle.groovy							
						break
						case 'maven':
						   //inovacion a maven.groovy
						break
					}

					def ejecucion = (params.herramienta == 'gradle') ? load 'gradle.groovy' : load 'maven.groovy'
				}
			}
		}
	}
}