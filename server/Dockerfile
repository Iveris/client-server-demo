FROM eclipse-temurin:21 
RUN mkdir /opt/app
COPY target/server-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "-Dspring.profiles.active=docker-secrets", "opt/app/server-0.0.1-SNAPSHOT.jar"]
