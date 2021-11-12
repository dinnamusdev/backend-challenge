FROM adoptopenjdk/openjdk8:alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backend-challenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /backend-challenge-0.0.1-SNAPSHOT.jar"]