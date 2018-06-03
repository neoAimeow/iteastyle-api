FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./iteastyle-war-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java" , "-jar","/app.jar" , "--server.port=8080"]