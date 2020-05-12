node {
    stage('Preparation') {
          git 'https://github.com/lucasalacerda/spring-poc-rest.git'
     }
    stage('Build') {
        withGradle {
            sh './gradlew build'
        }
    }
    stage('Build') {
         withGradle {
            sh './gradlew clean test'
         }
    }
    stage('Results') {
        junit 'build/**/TEST-*.xml'
//         archiveArtifacts 'target/*.jar'
    }
}