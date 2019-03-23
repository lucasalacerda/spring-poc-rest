## API rest - Spring - Docker

A poc made with spring to run on docker container. There's to endpoints: greeting and sum.

### Stack

* Java - 1.8
* Gradle - 5.3
* Spring Boot - 2.0.5
* Docker


### Installation + build

Clone the repository:

```bash
git clone https://github.com/lucasalacerda/spring-poc-rest.git
```
Build project:

```bash
.gradlew build
```

### Usage

Run api locally:

```
java -jar buid/libs/*.jar
```

Run with Dockerfile:

1 - Build the image passing the path of the .jar file

```
 docker build --build-arg JAR_FILE=build/libs/*.jar -t spring-app .
```
2 - Run container

```
 docker run -p 8080:8080 spring-app
```
