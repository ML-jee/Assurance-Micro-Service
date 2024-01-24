FROM openjdk:17
EXPOSE 8082
ADD target/AssuranceMicroService-0.0.1-SNAPSHOT.jar AssuranceMicroService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/AssuranceMicroService-0.0.1-SNAPSHOT.jar"]