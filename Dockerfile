FROM maven:3.9.9-amazoncorretto-23-alpine

ADD pom.xml /
RUN mvn verify clean
ADD . /
RUN mvn package

FROM amazoncorretto:23-alpine
WORKDIR /root/
COPY --from=0 /target/*-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]