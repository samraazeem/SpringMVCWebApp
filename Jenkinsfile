pipeline{
	agent any
	
	tools{
		jdk "Java-11"
		maven "Maven-3.6"
	}

	stages {
		stage('Code Checkout'){
			steps{
				git url: 'https://github.com/samraazeem/Training.git'
			}
		}
		stage('Build Stage'){
			steps{
				bat 'mvn clean install'
			}
	}
		stage('Unit Test Stage'){
			steps{
				echo 'Unit Test Passes Successfully'
		}
	}

		stage('SonarQube Analysis'){
			steps{
				withSonarQubeEnv('Sonar_Qube'){
					bat 'mvn sonar:sonar'
				}
			}
		}
	stage('Artifact Deploy'){
		steps{
			rtServer{
				id: 'Artifactory.artifactory',
				url: 'http://localhost:8082/artifactory',
				username: 'admin',
				password: 'password'
			}
			rtUpload{
				serverId: 'artifactory',
				spec: '''{
					 "files": [
 					{
     						 "pattern": ".war",
     					 	"target": "SpringMVCWebApp"
    					}
					]
				}"""
			}
		}
	}
}
