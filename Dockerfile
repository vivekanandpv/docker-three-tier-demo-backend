FROM openjdk:21-jdk

COPY target/docker-three-tier-demo-backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "./docker-three-tier-demo-backend-0.0.1-SNAPSHOT.jar"]