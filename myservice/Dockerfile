FROM openjdk:15
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} myservice-1.1.1.jar
ENTRYPOINT ["java","-jar","/myservice-1.1.1.jar"]