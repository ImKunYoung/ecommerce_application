FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
#COPY apiEncryptionKey.jks apiEncryptionKey.jks
COPY build/libs/msa-configservice-0.0.1-SNAPSHOT.jar ConfigServer.jar
ENTRYPOINT ["java","-jar","/ConfigServer.jar"]