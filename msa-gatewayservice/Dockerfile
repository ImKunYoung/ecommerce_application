FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/msa-gatewayservice-1.0.jar GatewayService.jar
ENTRYPOINT ["java","-jar","/GatewayService.jar"]