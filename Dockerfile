FROM maven:3-openjdk-11 as build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim
RUN mkdir /project
COPY out/artifacts/calculator_jar/calculator.jar /project
WORKDIR /project
ENTRYPOINT ["java","-jar","calculator.jar"]
