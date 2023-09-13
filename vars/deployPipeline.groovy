#!/usr/bin/env groovy

// vars/deployPipeline.groovy

def call(Map params) {
    pipeline {
        agent any
        environment {
            deployName = params.deployName
            repoName = params.repoName
        }
        stages {
            stage('Build') {
                steps {
                    sh 'echo "Deploying to dev environment"'
                }
            }
            stage('Create Image') {
                steps {
                    sh 'echo "Deploying to dev environment"'
                }
            }
            stage('Deploy To Build') {
                steps {
                    script {
                        if (params.stage == 'dev') {
                            sh 'echo "Deploying to dev environment"'
                            // Add your dev deployment steps here
                        } else if (params.stage == 'test') {
                            sh 'echo "Deploying to test environment"'
                            // Add your test deployment steps here
                        } else if (params.stage == 'release') {
                            sh 'echo "Deploying to release environment"'
                            // Add your release deployment steps here
                        } else {
                            error "Invalid value for stage parameter: '${params.stage}'"
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
