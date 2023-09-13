pipeline {
    agent any

    parameters {
        string(name: 'DEPLOY_NAME', description: 'java-maven-app')
        string(name: 'REPO_NAME', description: 'ahmedgamalhamdy/java-maven-app:tagname')
        choice(name: 'STAGE', choices: ['dev', 'test', 'release'], description: 'Select deployment stage')
    }

    stages {
        stage('Build and Deploy App') {
            steps {
                script {
                    // Generate version based on build number
                    def version = "1.${currentBuild.number}"

                    def deployConfig = [
                        deployName: params.DEPLOY_NAME,
                        repoName: params.REPO_NAME,
                        stage: params.STAGE,
                        version: version, // Use the generated version
                    ]
                    buildAndDeploy(deployConfig)
                }
            }
        }
    }
}
