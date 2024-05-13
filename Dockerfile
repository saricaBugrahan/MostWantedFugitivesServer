FROM maven:3.9.3 as BUILD

COPY src /usr/app/src
COPY pom.xml /usr/app

WORKDIR /usr/app

RUN mvn clean package  -DskipTests


# Running the jar file
FROM openjdk:17

COPY --from=BUILD /usr/app/target/MostWantedFugitivesServer-0.0.1-SNAPSHOT.jar /usr/app/MostWantedFugitivesServer-1.0-SNAPSHOT.jar

CMD ["java", "-cp", "/usr/app/MostWantedFugitivesServer-1.0-SNAPSHOT.jar"]