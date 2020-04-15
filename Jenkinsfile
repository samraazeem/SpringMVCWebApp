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
					bat 'mvn sonar:sonar -Dsonar.projectKey=Scripted_Pipeline -Dsonar.host.url=http://localhost:9000 -Dsonar.login=710badee0efb15737fe37113a5eafc3e4d2dce71'
				}
			}
		}

		
		stage('Artifact Deploy'){
			steps{
				bat 'mvn deploy'
			}
		}
		stage('Deploy to tomcat'){
			steps{
				bat "copy target\\SpringMVCWebApp.war \"C:\\Users\\samraazeem\\Documents\\apache-tomcat-9.0.33\\webapps"
			}
		}
	}
}
