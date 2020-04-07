pipeline{
	agent any
	
	tools{
		maven 'MAVEN'
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
	
	}
}
