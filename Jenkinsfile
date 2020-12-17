pipeline {
	agent any 

	parameters { choice(name: 'herramienta', choices: ['gradle','maven'], description: '') }

	stages {
		stage('Pipelines') {
			steps {
				script {

					params.herramienta // -> gradle o maven


					def ejecucion = (params.herramienta == ‘gradle’) ? (load ‘gradle.groovy’) : (load ‘maven.groovy’) 
				}
			}
		}
	}
}