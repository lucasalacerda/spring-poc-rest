node {
    stage('Preparation') {
          git 'https://github.com/lucasalacerda/spring-poc-rest.git'
     }
    stage('Test') {
        withGradle {
            sh './gradlew clean test'
        }
    }
    stage('Build') {
        withGradle {
            sh './gradlew clean build'
            archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
        }
    }

     stage('Artifactory') {
        def server = Artifactory.server 'ARTIFACTORY_SERVER'
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
     stage('Results') {
        junit 'build/**/TEST-*.xml'
     }
}