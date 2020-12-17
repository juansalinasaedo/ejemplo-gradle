pipeline {
	agent any 

	parameters { choice(name: 'herramienta', choices: ['maven','gradle'], description: '') }

	stages {
		stage('Pipelines') {
			steps {
				script {

					params.herramienta // -> gradle o maven

					def ejecucion = (params.herramienta == 'gradle') ? "${load 'gradle.groovy'}" : "${load 'maven.groovy'}"
				}
			}
		}
	}
}