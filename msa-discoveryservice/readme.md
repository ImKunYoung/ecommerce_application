```dockerfile
FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/msa-discoveryservice-0.0.1-SNAPSHOT.jar discoveryservice.jar
ENTRYPOINT ["java","-jar","/discoveryservice.jar"]
```

- `FROM openjdk:17-ea-11-jdk-slim`: 베이스 이미지
- `VOLUME /tmp`: 임시 디렉토리
- `COPY build/libs/msa-discoveryservice-0.0.1-SNAPSHOT.jar discoveryservice.jar`: jar 파일 복사
- `ENTRYPOINT ["java","-jar","discoveryservice.jar"]`: 실행 명령어

<br/>
<br/>

---

<br/>
<br/>

```shell

```shell
docker build -t imkunyoung/discoveryservice .
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
docker push imkunyoung/discoveryservice
```

- `push`: 이미지 푸시
- `imkunyoung/discoveryservice`: 이미지 이름

<br/>
<br/>

---

<br/>
<br/>



