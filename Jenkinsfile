node {
    stage('Preparation') {
          git 'https://github.com/lucasalacerda/spring-poc-rest.git'
     }
    stage('Build') {
        withGradle {
            sh './gradlew build'
            archiveArtifacts artifacts: 'build/**/libs/*.jar', fingerprint: true
        }
    }
    stage('Build') {
         withGradle {
            sh './gradlew clean test'
         }
    }
    stage('Results') {
        junit 'build/**/TEST-*.xml'
    }
     stage('Artifactory') {
        rtServer (
            id: "ARTIFACTORY_SERVER",
            url: "http://172.17.0.3:8081/artifactory",
            credentialsId: 'artifactory_id'
         )


        rtUpload (
            serverId: 'ARTIFACTORY_SERVER',
            spec: '''{
                  "files": [
                    {
                      "pattern": "build/**/libs/*.jar",
                      "target": "gradle-dev-local/sprint-rest/"
                    }
                 ]
            }'''
            )
     }
}