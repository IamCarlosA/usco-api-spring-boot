# usco-api-spring-boot
## Add ```.env``` file with this properties:
- MYSQLUSER=root
- #MYSQLPASSWORD=123456
- MYSQLPASSWORD=82mRx98HKkf9bG9g3VhC
- #MYSQLDATABASE=uscobd-test
- MYSQLDATABASE=railway
- MYSQL_URL=mysql://root:82mRx98HKkf9bG9g3VhC@containers-us-west-131.railway.app:6258
- #MYSQL_URL=mysql://localhost:3306
- MYSQLDB_LOCAL_PORT=3306
- MYSQLDB_DOCKER_PORT=3306
## Up database:
### WARNING! you need to have installed ```docker```
run this command: 
```
docker-compose up -d
```
