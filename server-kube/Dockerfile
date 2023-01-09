FROM openjdk:17-jdk-alpine
COPY build/libs/server-kube-0.0.1-SNAPSHOT.jar server-kube-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/server-kube-0.0.1-SNAPSHOT.jar"]