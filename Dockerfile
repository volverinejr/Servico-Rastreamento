FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD ./target/Servico-Rastreamento-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
