pipeline{
	agent any
	
	tools{
		maven 'MAVEN'
	}

	stages {
		stage('Code Checkout'){
			steps{
				git url: 'https://github.com/samraazeem/SpringMVCWebApp.git'
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
					bat 'mvn sonar:sonar -Dsonar.projectKey=SpringMVCWebForm -Dsonar.host.url=http://localhost:9000 -Dsonar.login=3311441b9ccb1ee8b2a17945ac36320feca30de1'
				}
			}
		}
		stage('Deploy Artifacts'){
			steps{
				bat 'mvn deploy'
			}
		}
		
		
		stage('Deploy to tomcat'){
			steps{
				bat "copy C:\\Users\\samraazeem\\Documents\\GitHub\\SpringMVCWebApp\\target\\SpringMVCWebApp2.war \"C:\\Users\\samraazeem\\Documents\\apache-tomcat-9.0.33\\webapps"
			}
		}
	}
}
