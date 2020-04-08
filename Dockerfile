FROM niggusch/java-mvn-mongo 
#FROM maven:3.6.1-jdk-8-slim

WORKDIR /app

COPY .  .

RUN mvn package && \
    mv target/web-quarantine-service.jar /run/web-quarantine.jar && \
    rm -rf /app/*

EXPOSE 8081

CMD java  -jar /run/web-quarantine.jar
