# spring-boot-microservices
Microservices Application with SpringBoot


To run project:
1. docker pull mysql:8.0
2. docker pull mongo
3. docker pull quay.io/keycloak/keycloak:21.0.2

Run DBs:
1. docker run -d -p 27017:27017 --name test-mongo mongo:latest
2. docker run --name my-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysql -d mysql

Setup MySQL:
1. Navigate to your MySQL container in Docker and click the ‘CLI’ button to launch a shell client
2. mysql -u root -p
3. CREATE DATABASE order_service;
4. CREATE DATABASE inventory_service;

Run Keycloak
1. docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.2 start-dev
