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
    stage('Build') {
         withGradle {
            sh './gradlew clean test'
         }
    }
    stage('Results') {
        junit 'build/**/TEST-*.xml'
    }
     stage('Artifactory') {

        def server = Artifactory.newServer url: 'http://172.17.0.3:8081/artifactory',
                                           credentialsId: 'artifactory_id'
        def uploadSpec = """{
          "files": [
           {
                "pattern": "build/**/libs/*.jar",
                "target": "gradle-release-local/"
            }
         ]
        }"""
        def buildInfo = Artifactory.newBuildInfo()
        server.upload spec: uploadSpec, buildInfo: buildInfo
        server.publishBuildInfo buildInfo

//         def urtUpload (
//             serverId: 'ARTIFACTORY_SERVER',
//             spec: '''{
//                   "files": [
//                     {
//                       "pattern": "build/**/libs/*.jar",
//                       "target": "gradle-release-local/spring-poc-rest/"
//                     }
//                  ]
//             }'''
//         )
     }
}