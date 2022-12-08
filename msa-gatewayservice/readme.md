```shell
docker run -d -p 8000:8000 --network eccomerce-network -e "spring.cloud.config.uri=http://configservice:8888" -e "spring.rabbitmq.host=rabbitmq"  -e "eureka.client.serviceUrl.defaultZone=http://discovery-service:8761/eureka/" --name apigateway-service imkunyoung/apigateway-service:1.0
```

- ``run``: 컨테이너 실행
- ``-d``: 백그라운드 실행
- ``-p 8000:8000``: 포트 포워딩
- ``--network eccomerce-network``: 네트워크 연결
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
