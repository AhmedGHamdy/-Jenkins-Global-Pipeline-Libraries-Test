// vars/buildAndDeploy.groovy

def call(Map pipelineConfig) {
    def deployName = pipelineConfig.deployName
    def repoName = pipelineConfig.repoName
    def stage = pipelineConfig.stage
    def version = pipelineConfig.version

    pipeline {
        agent any
        environment {
            env.deployName = deployName
            env.repoName = repoName
        }
        stages {
            stage('Build') {
                steps {
                    script {
                      sh 'echo "Building"'
                    }
                }
            }
            stage('Create Image') {
                steps {
                    sh 'echo "Create Image"'
                }
            }
            stage('Deploy To Build') {
                steps {
                    script {
                        if (stage == 'dev') {
                            sh 'echo "Deploying to dev environment"'
                        } else if (stage == 'test') {
                            sh 'echo "Deploying to test environment"'
                        } else if (stage == 'release') {
                            sh 'echo "Deploying to release environment"'
                        } else {
                            error "Invalid value for stage parameter: '${stage}'"
                        }
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
