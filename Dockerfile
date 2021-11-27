FROM openjdk:11
RUN mkdir /app
COPY out/artifacts/calculator_jar/calculator.jar /app/rest-api.jar
WORKDIR /app
CMD ["java", "-jar", "rest-api.jar"]
