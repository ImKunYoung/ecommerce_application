```dockerfile
FROM mariadb
ENV MYSQL_ROOT_PASSWORD admin
ENV MYSQL_DATABASE bootex
COPY ./mysql_data/mysql /var/lib/mysql
EXPOSE 3306
ENTRYPOINT ["mysqld", "--user=root"]
```

- `FROM mariadb` : mariadb 이미지를 기반으로 한다.
- `ENV MYSQL_ROOT_PASSWORD admin` : root 계정의 비밀번호를 admin으로 설정한다.
- `ENV MYSQL_DATABASE bootex` : bootex라는 이름의 데이터베이스를 생성한다.
- `COPY ./mysql_data/mysql /var/lib/mysql` : mysql_data/mysql 디렉토리의 내용을 컨테이너의 /var/lib/mysql 디렉토리에 복사한다.
- `EXPOSE 3306` : 3306 포트를 개방한다.
- `ENTRYPOINT ["mysqld"]` : 컨테이너가 시작될 때 mysqld를 실행한다.

<br/>
<br/>

---

<br/>
<br/>


```shell
docker build -t imkunyoung/my_mariadb:1.0 .
```

- `docker build` : 도커 이미지를 빌드한다.
- `-t imkunyoung/my_mariadb:1.0` : 빌드한 이미지에 태그를 붙인다.

<br/>
<br/>

---

<br/>
<br/>

```shell
docker run -d -p 3306:3306 --network ecommerce-network --name mariadb imkunyoung/my_mariadb:1.0
```

- `docker run` : 도커 컨테이너를 실행한다.
- `-d` : 백그라운드 모드로 실행한다.
- `-p 3306:3306` : 호스트의 3306 포트와 컨테이너의 3306 포트를 연결한다.
- `--name mariadb` : 컨테이너의 이름을 mariadb로 지정한다.
- `imkunyoung/my_mariadb:1.0` : 실행할 이미지를 지정한다.

<br/>
<br/>

---

<br/>
<br/>









