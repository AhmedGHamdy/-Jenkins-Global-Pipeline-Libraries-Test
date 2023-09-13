// myPipeline.groovy
def call(Map pipelineParams) {
    pipeline {
        agent any
        stages {
            stage('Build and Deploy') {
                steps {
                    echo "Deploy Name: ${pipelineParams.DEPLOY_NAME}"
                    echo "Repo Name: ${pipelineParams.REPO_NAME}"
                    echo "Stage: ${pipelineParams.STAGE}"
                    // Add your build and deploy steps here
                }
            }
        }
    }
}
