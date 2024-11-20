pipeline{
    agent any
    stages{
        stage("Git clone remote repo"){
            steps{
                git url:"https://github.com/rjteche/addressbook-cicd-project.git"
                echo "we have cloned the github repo"

            }
        }
        stage("Compile the code"){
            steps{
                sh "mvn compile"
            }
        }
        stage("Test the code"){
            steps{
                sh "mvn test"
            }
        }
        stage("Code package"){
            steps{
                sh "mvn package"
            }
        }
        stage("Deploy application on tomcat"){
            steps{
                sh "sudo mv /var/lib/jenkins/workspace/cicdproject/target/addressbook.war /home/ubuntu/apache-tomcat-9.0.97/webapps"
            }
        }
    }
}