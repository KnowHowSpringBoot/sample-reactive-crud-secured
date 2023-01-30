FROM docker-registry.c2a2.com/ujar/openjdk:17.0.2-slim

WORKDIR /app

COPY ./target/*.jar /app/app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Duser.timezone=UTC -jar /app/app.jar"]
EXPOSE 8080
