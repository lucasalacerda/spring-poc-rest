node {
    stage('Preparation') {
          git 'https://github.com/lucasalacerda/spring-poc-rest.git'
     }
    stage('Build') {
        withGradle {
            sh './gradlew ./spring-poc-rest/build'
        }
    }
    stage('Build') {
         withGradle {
            sh './gradlew ./spring-poc-rest/build'
         }
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/*.jar'
    }
}