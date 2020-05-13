node {
    stage('Preparation') {
          git 'https://github.com/lucasalacerda/spring-poc-rest.git'
     }
    stage('Build') {
        withGradle {
            sh './gradlew clean build'
            archiveArtifacts artifacts: 'build/**/libs/*.jar', fingerprint: true
        }
    }
//     stage('Build') {
//          withGradle {
//             sh './gradlew clean test'
//          }
//     }
//     stage('Results') {
//         junit 'build/**/TEST-*.xml'
//     }
     stage('Artifactory') {
        def server = Artifactory.server 'ARTIFACTORY_SERVER'
        print server.username
        print server.credentialsId
        def uploadSpec = """{
          "files": [
           {
                "pattern": "build/libs/*.jar",
                "target": "gradle-release-local/spring-poc-rest/"
            }
         ]
        }"""
        server.upload(uploadSpec)
        def buildInfo = Artifactory.newBuildInfo()
        server.upload spec: uploadSpec, buildInfo: buildInfo
        server.publishBuildInfo buildInfo
     }
}