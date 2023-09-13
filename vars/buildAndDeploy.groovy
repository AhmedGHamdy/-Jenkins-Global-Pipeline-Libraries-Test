// vars/buildAndDeploy.groovy

def call(String deployName, String repoName, String stage, String version) {
    pipeline {
        agent any
        environment {
            // Use parameters passed to this step
            env.deployName = deployName
            env.repoName = repoName
        }
        stages {
            stage('Build') {
                steps {
                    script {
                        // Your build logic here
                    }
                }
            }
            stage('Create Image') {
                steps {
                    script {
                        // Your image creation logic here
                    }
                }
            }
            stage('Deploy To Build') {
                steps {
                    script {
                        // Your deployment logic here
                    }
                }
            }
        }
        post {
            success {
                sh "printenv"
            }
        }
    }
}
