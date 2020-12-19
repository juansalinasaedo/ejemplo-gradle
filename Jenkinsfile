pipeline {
	agent any 

	parameters { choice(name: 'buildtool', choices: ['gradle', 'maven'], description: 'Elección de herramienta de construcción para aplicación covid')}

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
				script {

					env.TAREA = 'Hola'
					env.TAREA = 'hola params.buildtool' // hola params.buildtool

					def cadena = "Hola" + params.buildtool // Hola gradle
					/*def cadena = "Hola ${params.buildtool}" */ // Hola gradle
					def cadena = "${env.TAREA}" //hola

					println 'Herramienta de ejecución seleccionada: ' + params.buildtool
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