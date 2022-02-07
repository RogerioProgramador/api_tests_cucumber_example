pipeline {
    agent any
    tools {
            maven 'maven'
            jdk 'java'
    }
    stages {
        stage ('Run Tests'){
			steps{
				script {
					if (isUnix()) {
						sh 'mvn clean test -Denv=des'
					} else {
						bat 'mvn clean test -Denv=des'
					}
				}
			}
        }
        stage ('Generate Allure Reports'){
            steps{
                script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
                }
            }
         }
     }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/xml-junit/junit.xml'
            archiveArtifacts artifacts: 'target/log/*.log'
        }
    }
}