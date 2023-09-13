// my-shared-library/vars/buildAndDeploy.groovy

def call(Map parameters) {
    def deployName = parameters.deployName
    def repoName = parameters.repoName

    // Define environment variables for use in the calling pipeline
    env.DEPLOY_NAME = deployName
    env.REPO_NAME = repoName

    // Print some information for testing purposes
    echo "Deploy Name: ${DEPLOY_NAME}"
    echo "Repo Name: ${REPO_NAME}"
}
