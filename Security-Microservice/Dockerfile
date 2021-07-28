FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} security.jar
ENTRYPOINT ["java","-jar","/security.jar"]