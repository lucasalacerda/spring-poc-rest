node {
    stage('Preparation') {
          git 'https://github.com/lucasalacerda/spring-poc-rest.git'
     }
    stage('Build') {
        withGradle(gradleName:'gradle6') {
            sh 'gradle build'
        }
    }
    stage('Build') {
         withGradle(gradleName:'gradle6') {
            sh 'gradle test'
         }
    }
    stage('Results') {
        junit '/build/test-results/test/TEST-*.xml'
//         archiveArtifacts 'target/*.jar'
    }
}