pipeline {
    agent any
	
	parameters { choice(name: 'devtool', choices: ['maven', 'gradle'], description: 'Elección de herramienta de construcción para aplicación covid') }

	stages {
        stage('Pipeline') {
            steps {
                script {
                    env.TAREA = 'No Especificado'
                    env.buildtool = params.herramienta
                    
                    println params.herramienta

                    if (params.herramienta == 'gradle') {
                        def ejecucion = load 'gradle.groovy'
                        ejecucion.call()
                    }else {
                        println 'Ejecutando MAVEN GROOVY'
                        def ejecucion = load 'maven.groovy'
                        ejecucion.call()
                    }
                }
            }
        }
    }


	

	//Post
	post {
        success {
            println "Proceso Terminado - TAREA: ${env.TAREA}"
            slackSend (color: 'good', message: "[Juan Salinas][${env.JOB_NAME}][${env.buildtool}] Ejecución Correcta")
        }
        failure {
            println "Proceso no Terminado y con fallas - Ultima Tarea Ejecutada: ${env.TAREA}"

            slackSend (color:'danger', message: "[Juan Salinas][${env.JOB_NAME}][${env.buildtool}] Fallo en Stage: [${env.TAREA}]")
        }
    }
}