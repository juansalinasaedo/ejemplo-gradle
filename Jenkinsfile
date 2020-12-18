pipeline {
	agent any 

	parameters { choice(name: 'herramienta', choices: ['gradle','maven'], description: 'Elección de herramienta de construcción para aplicación covid') }

	stages {
		
		/*stage('Pipelines') {
			steps {
				script {

					params.herramienta // -> gradle o maven

					def ejecucion = (params.herramienta == 'gradle') ? "${load 'gradle.groovy'}" : "${load 'maven.groovy'}"
				}
			}
		}*/

		stage('Hello') {
			steps {
				script{

					env.Tarea = ''

					println 'Herramienta de ejecucion seleccionada: ' + params.buildtool
					def pipe = load "${params.buildtool}.groovy"
					pipe.call()
				}
			}
		}

	}

	post {

		success {

		}

		failure {
			println env.TAREA 
			println params.buildtool
		}
	}
}