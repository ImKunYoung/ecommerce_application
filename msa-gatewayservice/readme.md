```dockerfile
FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/msa-gatewayservice-1.0.jar GatewayService.jar
ENTRYPOINT ["java","-jar","/GatewayService.jar"]
```

- `FROM openjdk:17-ea-11-jdk-slim`: 베이스 이미지
- `VOLUME /tmp`: 임시 디렉토리
- `COPY build/libs/msa-gatewayservice-1.0.jar GatewayService.jar`: jar 파일 복사
- `ENTRYPOINT ["java","-jar","/GatewayService.jar"]`: 실행 명령어


<br/>
<br/>

---

<br/>
<br/>



```shell
docker build -t imkunyoung/gatewayservice:1.0 .
```

- `build`: 이미지 빌드
- `-t imkunyoung/gatewayservice:1.0`: 이미지 이름
- `.`: 현재 디렉토리

<br/>
<br/>

---

<br/>
<br/>

```shell
docker push imkunyoung/gatewayservice:1.0
```

- `push`: 이미지 푸시


<br/>
<br/>

---

<br/>
<br/>

```shell
docker run -d -p 8000:8000 --network ecommerce-network -e "spring.cloud.config.uri=http://configservice:8888" -e "spring.rabbitmq.host=rabbitmq"  -e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" --name gatewayservice imkunyoung/gatewayservice:1.0
```

- ``run``: 컨테이너 실행
- ``-d``: 백그라운드 실행
- ``-p 8000:8000``: 포트 포워딩
- ``--network ecommerce-network``: 네트워크 연결
- ``-e "spring.cloud.config.uri=http://configservice:8888"``: 설정 서버 주소
- ``-e "spring.rabbitmq.host=rabbitmq"``: RabbitMQ 주소
- ``-e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/"``: Eureka 주소
- ``--name apigateway-service``: 컨테이너 이름
- ``imkunyoung/apigateway-service:1.0``: 이미지 이름

- ``8000``: 컨테이너 내부 포트
- ``8000``: 호스트 포트

- ``spring.cloud.config.uri``: 설정 서버 주소
- ``spring.rabbitmq.host``: RabbitMQ 주소
- ``eureka.client.serviceUrl.defaultZone``: Eureka 주소


<br/>
<br/>

---

<br/>
<br/>


```shell
docker network inspect ecommerce-network
```

<br/>
<br/>

---

<br/>
<br/>

```shell
docker logs gatewayservice
```

- ``logs``: 로그 확인