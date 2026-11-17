# weatherforecast
Java 25 and Spring Boot 4 Weather Forecast REST API

## Setup
You need to inform an API Key for the OpenWeatherMAP API in application.properties

`apikey=MYAPIKEY`

You can get one by making a free account at [https://openweathermap.org/]

You need [JDK 25](https://jdk.java.net/) to build and run this project. The Gradle wrapper (Gradle 9.9.1) is included.

## Building
`./gradlew clean build`

## Running
`./gradlew bootRun`

## Documentation
(default: http://localhost:8080)  
server:port/swagger-ui.html

## Example
`curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/v1/data/countries/GB/cities/London`

