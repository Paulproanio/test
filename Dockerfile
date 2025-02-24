FROM openjdk:11
VOLUME /tmp
EXPOSE 16000
ADD ./target/paul-0.0.1-SNAPSHOT.jar.original app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
