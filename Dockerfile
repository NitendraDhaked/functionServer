FROM java:8-jdk-alpine

COPY ./target/functionserver-1.0.1.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'functionserver-1.0.1.jar'

ENTRYPOINT ["java","-jar","functionserver-1.0.1.jar"]