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
            sh './gradlew test'
         }
    }
    stage('Results') {
        junit '/build/test-results/test/TEST-*.xml'
//         archiveArtifacts 'target/*.jar'
    }
}