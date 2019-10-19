FROM maven:3-jdk-8 as builder
WORKDIR /build
ADD . .
RUN mvn clean package

FROM openjdk:8
COPY --from=builder target/ICFire.jar ICFire.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ICFire.jar"]
