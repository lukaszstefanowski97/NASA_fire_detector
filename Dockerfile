FROM openjdk:8
ADD target/ICFire.jar ICFire.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ICFire.jar"]