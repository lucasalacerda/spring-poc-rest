node {
    stage('Build') {
        withGradle {
            sh "./gradlew build"
        }
    }
    stage('Build') {
         withGradle {
            sh "./gradlew test"
         }
    }
}