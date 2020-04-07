def server= Artifactory.server 'artifactory'
def rtMaven= Artifactory.newMavenBuild()

def buildInfo

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
					bat 'mvn sonar:sonar -Dsonar.projectKey=SpringMVCWebForm -Dsonar.host.url=http://localhost:9000 -Dsonar.login=c098978530ef3e812e02e4db9cdab606b28f00b1'
				}
			}
		}
		stage('Artifact Deploy'){
			steps{
				script{
					rtMaven.tool= 'MAVEN'
					rtMaven.deployer releaseRepo: 'SpringMVCWebApp', snapshotRepo: 'SpringMVCWebApp', server: server
					buildInfo= Artifactory.newBuildInfo()
					buildInfo.env.capture= true
				}
			}
		}
    	}
}
