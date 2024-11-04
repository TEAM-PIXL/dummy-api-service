# DUMMY PIXL-POS REST API SEVICE

---

## PREFACE
This API Service is not for production use! This service should only be used for development purposes over localhost or in a controlled cluster.

---

### Setup

1. Run the following command from the sources root to build the docker image:
```bash
docker build -t spring-app:latest .
```
<br>

2. Run the following command to start-up the docker container for the API service.
```bash
docker run -d -p 8080:8080 --name spring-app spring-app:latest
```
<br>

3. Access the application over localhost at the swagger entrypoint:
```
http://localhost:8080/swagger-ui/index.html#/
```
<br>

4. Access the endpoints using [Postman](https://www.postman.com/downloads/):
```
http://localhost:8080/api/<model>
```
