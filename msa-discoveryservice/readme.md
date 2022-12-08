```dockerfile
FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/msa-discoveryservice-1.0-SNAPSHOT.jar discoveryservice.jar
ENTRYPOINT ["java","-jar","/discoveryservice.jar"]
```

- `FROM openjdk:17-ea-11-jdk-slim`: 베이스 이미지
- `VOLUME /tmp`: 임시 디렉토리
- `COPY build/libs/msa-discoveryservice-1.0-SNAPSHOT.jar discoveryservice.jar`: jar 파일 복사
- `ENTRYPOINT ["java","-jar","discoveryservice.jar"]`: 실행 명령어

<br/>
<br/>

---

<br/>
<br/>


```shell
docker build -t imkunyoung/discoveryservice:1.0 .
```

- `build`: 이미지 빌드
- `--tag= imkunyoung/discoveryservice`: 이미지 이름
- `.`: 현재 디렉토리


<br/>
<br/>

---

<br/>
<br/>


```shell
docker push imkunyoung/discoveryservice:1.0
```

- `push`: 이미지 푸시
- `imkunyoung/discoveryservice`: 이미지 이름

<br/>
<br/>

---

<br/>
<br/>


```shell
docker run -d -p 8761:8761 --network ecommerce-network -e "spring.cloud.config.uri=http://msa-configservice:8888" --name discovery-service imkunyoung/discoveryservice:1.0
```

- `run`: 컨테이너 실행
- `-d`: 백그라운드 실행
- `-p 8761:8761`: 포트 포워딩
- `--network ecommerce-network`: 네트워크 연결
- `-e "spring.cloud.config.uri=http://msa-configservice:8888"`: 환경 변수 설정
- `--name discovery-service`: 컨테이너 이름 지정
- `imkunyoung/discoveryservice:1.0`: 실행할 이미지 이름

<br/>
<br/>

---

<br/>
<br/>

```shell
docker network inspect ecommerce-network
```
- `network inspect`: 네트워크 정보 확인


