FROM openjdk:17-jdk-alpine
WORKDIR /home
EXPOSE 8080
COPY target/spring-rest-demo-1.0-SNAPSHOT.jar /home/app.jar
ENTRYPOINT ["java","-jar","/home/app.jar"]