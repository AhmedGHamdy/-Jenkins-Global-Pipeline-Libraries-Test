// my-shared-library/vars/buildAndDeploy.groovy

def call(Map parameters) {
    def deployName = parameters.deployName ?: 'DefaultDeployName'
    def repoName = parameters.repoName ?: 'DefaultRepoName'

    // Define environment variables using 'withEnv'
    withEnv([
        "DEPLOY_NAME=${deployName}",
        "REPO_NAME=${repoName}"
    ]) {
        // Print some information for testing purposes
        echo "Deploy Name: ${DEPLOY_NAME}"
        echo "Repo Name: ${REPO_NAME}"

        // Perform your actual pipeline steps here
        stage('Build') {
            steps {
                script {
                    echo "Building ${DEPLOY_NAME} using repo value: ${REPO_NAME}"
                    // Add your build steps here
                }
            }
        }
        stage('Create Image') {
            steps {
                script {
                    echo "Creating image for ${DEPLOY_NAME} using repo value: ${REPO_NAME}"
                    // Add your image creation steps here
                }
            }
        }
        stage('Deploy To Build') {
            steps {
                script {
                    echo "Deploying to ${DEPLOY_NAME} using repo value: ${REPO_NAME}"
                    // Add your deployment steps here
                }
            }
        }
    }
}
