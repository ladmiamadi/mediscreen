# mediscreen
![Architecture](https://github.com/ladmiamadi/mediscreen/blob/final-branch/mediscreen-architecture.png)

# To run project
1. Clone project
2. docker compose up -d 

3. open http://localhost:8080 on browser

![home-page](https://github.com/ladmiamadi/mediscreen/blob/final-branch/home-page.png)

# Docker Hub

Microservices are also available on Docker Hub

For MySQL : docker pull mysql
For MongoDB : docker pull mongo
For Zipkin: docker pull zipkin

Microservice "Patient" : docker pull ladmia/patient:latest

Microservice "History" : docker pull ladmia/history:latest

Microservice "DiabetesReport" : docker pull ladmia/diabetes-history:latest

Microservice "eureka-servert" : docker pull ladmia/eureka-server:latest

Links to Docker Hub :

[eureka-server](https://hub.docker.com/r/ladmia/eureka-server) <br>
[patient](https://hub.docker.com/r/ladmia/patient)<br>
[history](https://hub.docker.com/r/ladmia/history)<br>
[report](https://hub.docker.com/r/ladmia/diabetes-report)
