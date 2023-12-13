FROM maven:3.9.5 AS build
WORKDIR /home/app
# COPY ./pom.xml /home/app/pom.xml
# COPY ./src/main/java/com/a00n/springeureka/SpringEurekaApplication.java /home/app/src/main/java/com/a00n/springeureka/SpringEurekaApplication.java

# RUN mvn -f /home/app/pom.xml clean package -DskipTests

COPY . /home/app/

RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:17-slim

EXPOSE 8761

COPY --from=build /home/app/target/*.jar app.jar

ENTRYPOINT [ "sh","-c","java -jar /app.jar" ]