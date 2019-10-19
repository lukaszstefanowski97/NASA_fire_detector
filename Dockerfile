FROM openjdk:8
ADD target/bookApp.jar bookApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ICFire.jar"]