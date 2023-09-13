def call(Map parameters) {
    def deployName = parameters.deployName ?: 'DefaultDeployName'
    def repo = parameters.repo ?: 'DefaultRepo'

    pipeline {
        agent any
        environment {
            DEPLOY_NAME = deployName
            REPO = repo
        }
        stages {
            stage('Build') {
                steps {
                    script {
                        echo "Building ${DEPLOY_NAME} using repo value: ${REPO}"
                        // Add your build steps here
                    }
                }
            }
            stage('Create Image') {
                steps {
                    script {
                        echo "Creating image for ${DEPLOY_NAME} using repo value: ${REPO}"
                        // Add your image creation steps here
                    }
                }
            }
            stage('Deploy To Build') {
                steps {
                    script {
                        echo "Deploying to ${DEPLOY_NAME} using repo value: ${REPO}"
                        // Add your deployment steps here
                    }
                }
            }
        }
    }
}
