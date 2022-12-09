FROM mariadb
ENV MYSQL_ROOT_PASSWORD admin
ENV MYSQL_DATABASE admin
COPY ./mysql_data/mysql /var/lib/mysql
EXPOSE 3306
ENTRYPOINT ["mysqld", "--user=root"]