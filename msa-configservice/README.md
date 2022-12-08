

```shell
docker network create --gateway 172.27.224.1 --subnet 172.27.0.0/16 ecommerce-network
```

- ``network create``: 네트워크 생성
- ``gateway 172.27.224.1``: 게이트웨이 IP 설정
- ``subnet 172.27.0.0/16``: 서브넷 범위
- ``ecommerce-network``: 네트워크 이름



<br/>
<br/>

---

<br/>
<br/>


```shell
docker run -d --name rabbitmq --network ecommerce-network -p 15672:15672 -p 5672:5672 -p 15671:15671 -p 5671:5671 -p 4369:4369 -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:3-management
```

- ``run``: 컨테이너 실행
- ``-d``: 백그라운드 실행
- ``--name rabbitmq``: 컨테이너 이름
- ``--network ecommerce-network``: 네트워크 연결
- ``-p 15672:15672 -p 5672:5672 -p 15671:15671 -p 5671:5671 -p 4369:4369``: 포트 포워딩
- ``-e RABBITMQ_DEFAULT_USER=admin``: 기본 유저
- ``-e RABBITMQ_DEFAULT_PASS=admin``: 기본 패스워드

<br/>
<br/>

---

<br/>
<br/>

```shell
docker ps -a
```

- ``ps``: 실행중인 컨테이너 확인

<br/>
<br/>

---

<br/>
<br/>

```shell
docker network inspect ecommerce-network
```

- ``network inspect``: 네트워크 정보 확인
- ``ecommerce-network``: 네트워크 이름



<br/>
<br/>

---

<br/>
<br/>

```dockerfile
FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
#COPY apiEncryptionKey.jks apiEncryptionKey.jks
COPY build/libs/msa-configservice-0.0.1-SNAPSHOT.jar ConfigServer.jar
ENTRYPOINT ["java","-jar","/ConfigServer.jar"]
```

- ``FROM openjdk:17-ea-11-jdk-slim``: 베이스 이미지
- ``VOLUME /tmp``: 임시 디렉토리
- ``COPY build/libs/msa-configservice-0.0.1-SNAPSHOT.jar ConfigServer.jar``: jar 파일 복사
- ``ENTRYPOINT ["java","-jar","/ConfigServer.jar"]``: 실행 명령어


<br/>
<br/>

---

<br/>
<br/>

```shell
docker build -t imkunyoung/msa-configservice:0.0.1-SNAPSHOT .
```

- ``build``: 이미지 빌드
- ``-t imkunyoung/msa-configservice-0.0.1-SNAPSHOT``: 이미지 이름
- ``.``: 현재 디렉토리


<br/>
<br/>

---

<br/>
<br/>

```shell
docker images
```

- ``images``: 이미지 목록 확인


<br/>
<br/>

---

<br/>
<br/>

```shell
docker ps -a
```

- ``ps``: 실행중인 컨테이너 확인



<br/>
<br/>

---

<br/>
<br/>

```shell
docker run -d --name configservice --network ecommerce-network -p 8888:8888 imkunyoung/msa-configservice:0.0.1-SNAPSHOT
```

- ``run``: 컨테이너 실행
- ``-d``: 백그라운드 실행
- ``--name configservice``: 컨테이너 이름
- ``--network ecommerce-network``: 네트워크 연결
- ``-p 8888:8888``: 포트 포워딩
- ``imkunyoung/msa-configservice:0.0.1-SNAPSHOT``: 이미지 이름
- ``8888``: 컨테이너 내부 포트
- ``8888``: 호스트 포트


<br/>
<br/>

---

<br/>
<br/>

```shell
docker run -d --name configservice --network ecommerce-network -p 8888:8888 -e "spring.rabbitmq.host=rabbitmq" -e "spring.profiles.active=default" imkunyoung/msa-configservice:0.0.1-SNAPSHOT
```




<br/>
<br/>

---

<br/>
<br/>

```shell
docker network inspect ecommerce-network
```

- ``network inspect``: 네트워크 정보 확인


<br/>
<br/>

---

<br/>
<br/>

```shell
docker ps -a
```

- ``ps``: 실행중인 컨테이너 확인



<br/>
<br/>

---

<br/>
<br/>

```shell
docker logs configservice
```

- ``logs``: 로그 확인
- ``configservice``: 컨테이너 이름


<br/>
<br/>

---

<br/>
<br/>


```shell
docker push imkunyoung/msa-configservice:0.0.1-SNAPSHOT
```

- `push`: 이미지 푸시
- `imkunyoung/configservice`: 이미지 이름











